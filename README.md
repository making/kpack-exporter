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

# HELP buildservice_resource_ready  
# TYPE buildservice_resource_ready gauge
buildservice_resource_ready{name="dependency-updater",namespace="build-service",type="TanzuNetDependencyUpdater",} 1.0
# HELP kpack_resource_ready  
# TYPE kpack_resource_ready gauge
kpack_resource_ready{name="hello-api",namespace="hello",type="Image",} 1.0
kpack_resource_ready{name="demo-api",namespace="demo",type="Image",} 0.0
# HELP kpack_clusterresource_ready  
# TYPE kpack_clusterresource_ready gauge
kpack_clusterresource_ready{name="full-jammy",type="ClusterStack",} 1.0
kpack_clusterresource_ready{name="full-jammy",type="ClusterBuilder",} 1.0
kpack_clusterresource_ready{name="tiny",type="ClusterStack",} 1.0
kpack_clusterresource_ready{name="base-jammy",type="ClusterStack",} 1.0
kpack_clusterresource_ready{name="base",type="ClusterBuilder",} 1.0
kpack_clusterresource_ready{name="full",type="ClusterStack",} 1.0
kpack_clusterresource_ready{name="tiny-jammy",type="ClusterStack",} 1.0
kpack_clusterresource_ready{name="tiny-jammy",type="ClusterBuilder",} 1.0
kpack_clusterresource_ready{name="default",type="ClusterBuilder",} 1.0
kpack_clusterresource_ready{name="full",type="ClusterBuilder",} 1.0
kpack_clusterresource_ready{name="default",type="ClusterStack",} 1.0
kpack_clusterresource_ready{name="base",type="ClusterStack",} 1.0
kpack_clusterresource_ready{name="default",type="ClusterStore",} 1.0
kpack_clusterresource_ready{name="base-jammy",type="ClusterBuilder",} 1.0
kpack_clusterresource_ready{name="tiny",type="ClusterBuilder",} 1.0
```

`xyz_ready` shows `1.0` for normal and `0.0` for abnormal.