#!/bin/bash

cd $(dirname $0)

OUTPUT_DIR="$(pwd)/out/"
if [ -d "$1" ] ; then
	OUTPUT_DIR="$1"
fi

find "$OUTPUT_DIR/" -maxdepth 1 -mindepth 1 -type f -delete
cd src/
groovy index.groovy "$OUTPUT_DIR"
