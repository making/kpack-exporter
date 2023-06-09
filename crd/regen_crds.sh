#!/usr/bin/env bash
docker rm -f  kind-control-plane
set -e -o pipefail
CURRENT_DIR=$(cd `dirname $0` && pwd)
LOCAL_MANIFEST_FILE=$(echo "$(cd "$(dirname "$1")"; pwd)/$(basename "$1")")
PKG=$2
if [ "${PKG}" == "" ];then
  PKG=io.kpack
fi
echo "CURRENT_DIR=${CURRENT_DIR}"
echo "PKG=${PKG}"
echo "LOCAL_MANIFEST_FILE=${LOCAL_MANIFEST_FILE}"
rm -rf /tmp/java
mkdir -p /tmp/java
cd /tmp/java
docker run \
  --rm \
  -v "$LOCAL_MANIFEST_FILE":"$LOCAL_MANIFEST_FILE" \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v "$(pwd)":"$(pwd)" \
  -ti \
  --network host \
  ghcr.io/kubernetes-client/java/crd-model-gen:v1.0.6 \
  /generate.sh \
  -u $LOCAL_MANIFEST_FILE \
  -n ${PKG} \
  -p $(echo ${PKG} | sed 's/-//g') \
  -o "$(pwd)"
mkdir -p ${CURRENT_DIR}/../src/main/java/$(echo ${PKG} | sed 's/-//g' | sed 's|\.|/|g')
cp -r /tmp/java/src/main/java/$(echo ${PKG} | sed 's/-//g' | sed 's|\.|/|g')/*  ${CURRENT_DIR}/../src/main/java/$(echo ${PKG} | sed 's/-//g' | sed 's|\.|/|g')/
