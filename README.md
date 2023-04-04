# kpack exporter

## How to install kpack-exporter

```
NAMESPACE=... (e.g. tap-install, tbs-install)
tanzu package repository add kpack-exporter-repo --url ghcr.io/making/kpack-exporter-repo:0.0.1 -n ${NAMESPACE}
tanzu package install -p kpack-exporter.pkg.maki.lol -v 0.0.1 -n ${NAMESPACE}
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