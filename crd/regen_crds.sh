#!/usr/bin/env bash
docker rm -f  kind-control-plane
set -e
CURRENT_DIR=$(cd `dirname $0` && pwd)
LOCAL_MANIFEST_FILE=${CURRENT_DIR}/image.yaml
echo "CURRENT_DIR=${CURRENT_DIR}"
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
  -n io.kpack \
  -p io.kpack \
  -o "$(pwd)"
mkdir -p ${CURRENT_DIR}/../src/main/java/io/kpack
cp -r /tmp/java/src/main/java/io/kpack/*  ${CURRENT_DIR}/../src/main/java/io/kpack/
