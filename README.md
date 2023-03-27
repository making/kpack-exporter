# kpack exporter

## How to install kpack-exporter

```
NAMESPACE=... (e.g. tap-install, tbs-install)
tanzu package repository add kpack-exporter-repo --url ghcr.io/making/kpack-exporter-repo:0.0.1 -n ${NAMESPACE}
tanzu package install -p kpack-exporter.pkg.maki.lol -v 0.0.1 -n ${NAMESPACE}
```