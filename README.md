# kpack exporter

example metrics

```
# HELP kpack_cluster_store_ready  
# TYPE kpack_cluster_store_ready gauge
kpack_cluster_store_ready{name="default",} 1.0
# HELP kpack_image_ready  
# TYPE kpack_image_ready gauge
kpack_image_ready{name="hello-api",namespace="hello",} 1.0
kpack_image_ready{name="demo-api",namespace="demo",} 0.0
# HELP kpack_cluster_builder_ready  
# TYPE kpack_cluster_builder_ready gauge
kpack_cluster_builder_ready{name="base-jammy",} 1.0
kpack_cluster_builder_ready{name="default",} 1.0
kpack_cluster_builder_ready{name="base",} 1.0
# HELP kpack_cluster_stack_ready  
# TYPE kpack_cluster_stack_ready gauge
kpack_cluster_stack_ready{name="base-jammy",} 1.0
kpack_cluster_stack_ready{name="default",} 1.0
kpack_cluster_stack_ready{name="base",} 1.0
```

## How to install kpack-exporter

```
NAMESPACE=... (e.g. tap-install, tbs-install)
tanzu package repository add kpack-exporter-repo --url ghcr.io/making/kpack-exporter-repo:0.0.1 -n ${NAMESPACE}
tanzu package install -p kpack-exporter.pkg.maki.lol -v 0.0.1 -n ${NAMESPACE}
```