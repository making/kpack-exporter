# kpack exporter

## How to install kpack-exporter

```
NAMESPACE=... (e.g. tap-install, tbs-install)
tanzu package repository add kpack-exporter-repo --url ghcr.io/making/kpack-exporter-repo:0.0.1 -n ${NAMESPACE}
tanzu package install kpack-exporter -p kpack-exporter.pkg.maki.lol -v 0.0.1 -n ${NAMESPACE}
```

```
kubectl port-forward -n kpack-exporter svc/kpack-exporter 8080:8080
```

```
$ curl -s http://localhost:8080/actuator/prometheus | grep resource_ready

# HELP kpack_clusterresource_ready  
# TYPE kpack_clusterresource_ready gauge
kpack_clusterresource_ready{kind="ClusterStack",name="tiny-jammy",} 1.0
kpack_clusterresource_ready{kind="ClusterStack",name="full",} 1.0
kpack_clusterresource_ready{kind="ClusterBuilder",name="default",} 1.0
kpack_clusterresource_ready{kind="ClusterBuilder",name="full-jammy",} 1.0
kpack_clusterresource_ready{kind="ClusterBuilder",name="full",} 1.0
kpack_clusterresource_ready{kind="ClusterBuilder",name="tiny",} 1.0
kpack_clusterresource_ready{kind="ClusterBuilder",name="base-jammy",} 1.0
kpack_clusterresource_ready{kind="ClusterStack",name="default",} 1.0
kpack_clusterresource_ready{kind="ClusterBuilder",name="base",} 1.0
kpack_clusterresource_ready{kind="ClusterStore",name="default",} 1.0
kpack_clusterresource_ready{kind="ClusterBuilder",name="tiny-jammy",} 1.0
kpack_clusterresource_ready{kind="ClusterStack",name="base",} 1.0
kpack_clusterresource_ready{kind="ClusterStack",name="tiny",} 1.0
kpack_clusterresource_ready{kind="ClusterStack",name="base-jammy",} 1.0
kpack_clusterresource_ready{kind="ClusterStack",name="full-jammy",} 1.0
# HELP kpack_resource_ready  
# TYPE kpack_resource_ready gauge
kpack_resource_ready{kind="Image",name="demo-api",namespace="demo",} 0.0
kpack_resource_ready{kind="Image",name="hello-api",namespace="hello",} 1.0
# HELP buildservice_resource_ready  
# TYPE buildservice_resource_ready gauge
buildservice_resource_ready{kind="TanzuNetDependencyUpdater",name="dependency-updater",namespace="build-service",} 1.0
```

`****resource_ready` shows `1.0` for success and `0.0` for failure.

### Monitoring with Prometheus

#### Scrape Config

Here is
an [`kubernetes_sd_configs`](https://prometheus.io/docs/prometheus/latest/configuration/configuration/#kubernetes_sd_config)
example:

```yaml
scrape_configs:
- job_name: kubernetes-pods
  scrape_interval: 30s
  scrape_timeout: 10s
  relabel_configs:
  - source_labels:
    - __meta_kubernetes_pod_annotation_prometheus_io_scrape
    separator: ;
    regex: "true"
    replacement: $1
    action: keep
  - source_labels:
    - __meta_kubernetes_pod_annotation_prometheus_io_scheme
    separator: ;
    regex: (https?)
    target_label: __scheme__
    replacement: $1
    action: replace
  - source_labels:
    - __meta_kubernetes_pod_annotation_prometheus_io_path
    separator: ;
    regex: (.+)
    target_label: __metrics_path__
    replacement: $1
    action: replace
  - source_labels:
    - __address__
    - __meta_kubernetes_pod_annotation_prometheus_io_port
    separator: ;
    regex: (.+?)(?::\d+)?;(\d+)
    target_label: __address__
    replacement: $1:$2
    action: replace
  - source_labels:
    - __meta_kubernetes_pod_label_app_kubernetes_io_part_of
    separator: ;
    regex: (.*)
    target_label: app_kubernetes_io_part_of
    replacement: $1
    action: replace
  - source_labels:
    - __meta_kubernetes_namespace
    separator: ;
    regex: (.*)
    target_label: namespace
    replacement: $1
    action: replace
  - source_labels:
    - __meta_kubernetes_pod_name
    separator: ;
    regex: (.*)
    target_label: pod
    replacement: $1
    action: replace
  - source_labels:
    - __meta_kubernetes_pod_label_app
    separator: ;
    regex: (.*)
    target_label: app
    replacement: $1
    action: replace
  kubernetes_sd_configs:
  - role: pod
    kubeconfig_file: ""
    follow_redirects: true
    enable_http2: true
```

Or you can alos simply
use [`static_configs`](https://prometheus.io/docs/prometheus/latest/configuration/configuration/#static_config)
for example:

```yaml
scrape_configs:
- job_name: kpack-exporter
  scrape_interval: 30s
  scrape_timeout: 10s
  scheme: http
  static_configs:
  - targets:
    - kpack-exporter.kpack-exporter.svc.cluster.local:8080
  metrics_path: /actuator/prometheus
```

#### Alert Rule Config

Here are
example [alert rule](https://prometheus.io/docs/prometheus/latest/configuration/alerting_rules/)
s:

```yaml
alert: KpackResourceFailed
expr: kpack_resource_ready == 0
labels:
  severity: critical
annotations:
  description: |-
    Kpack resource failed
    kind = {{ $labels.kind }}
    namespace = {{ $labels.namespace }}
    name = {{ $labels.name }}
  summary: Kpack resource failed ({{ $labels.kind }})
```

```yaml
alert: KpackClusterResourceFailed
expr: kpack_clusterresource_ready == 0
labels:
  severity: critical
annotations:
  description: |-
    Kpack cluster resource failed
    kind = {{ $labels.kind }}
    name = {{ $labels.name }}
  summary: Kpack clusterresource failed ({{ $labels.kind }})
```

```yaml
alert: BuildServiceResourceFailed
expr: buildservice_resource_ready == 0
labels:
  severity: critical
annotations:
  description: |-
    BuildService resource failed
    kind = {{ $labels.kind }}
    namespace = {{ $labels.namespace }}
    name = {{ $labels.name }}
  summary: BuildService resource failed ({{ $labels.kind }})
```

#### Alert manager config

Here is an
example [`slack_config`](https://prometheus.io/docs/alerting/latest/configuration/#slack_config):

```yaml
global:
  # ...
  slack_api_url: https://hooks.slack.com/services/*******/*******/*******
route:
  receiver: default
  group_by:
  - alertname
  # ...
receivers:
- name: default
  slack_configs:
  - channel: alert
    send_resolved: true
# ...
```

You will receive notifications like this:
<img width="825" alt="image" src="https://user-images.githubusercontent.com/106908/229666447-037944a0-14af-4cd9-9eda-bde7faa99aa4.png">

### Built-in Alert

If having Prometheus to monitor Kpack is too much, you can use the built-in alerts to send
alerts directly from the kpack exporter.

#### Slack

`kpack-exporter-values.yaml`

```yaml
builtin_alert:
  enabled: true
  type: slack
  cluster: build
  webhook_url: https://hooks.slack.com/services/*******/*******/*******
  slack:
    channel: alert
  debug: true # To see HTTP response log for the webhook
```

You will receive notifications like this:
<img width="825" alt="image" src="https://user-images.githubusercontent.com/106908/229665569-d22b522c-39b5-4a57-82b7-3c1645b8606d.png">


```
tanzu package install kpack-exporter -p kpack-exporter.pkg.maki.lol -v 0.0.1 --values-file kpack-exporter-values.yaml -n ${NAMESPACE}
```

or update

```
tanzu package installed update kpack-exporter --values-file kpack-exporter-values.yaml -n ${NAMESPACE}
```

#### Generic Webhook

`kpack-exporter-values.yaml`

```yaml
builtin_alert:
  enabled: true
  type: generic
  cluster: build
  webhook_url: https://mywebhook.example.com/webhook
  generic:
    template: |
      {
        "result": "${RESULT}",
        "kind": "${KIND}",
        "namespace": "${NAMESPACE}",
        "name": "${NAME}",
        "cluster": "${CLUSTER}",
        "text": "${TEXT}"
      }
  debug: true # To see HTTP response log for the webhook
```

```
tanzu package install kpack-exporter -p kpack-exporter.pkg.maki.lol -v 0.0.1 --values-file kpack-exporter-values.yaml -n ${NAMESPACE}
```

or update

```
tanzu package installed update kpack-exporter --values-file kpack-exporter-values.yaml -n ${NAMESPACE}
```

### License

Licensed under the Apache License, Version 2.0.