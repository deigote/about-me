#!/bin/bash

cd $(dirname $0)

OUTPUT_DIR="$(pwd)/out/"
if [ ! -z "$1" ] ; then
	[ -d "$1" ] || mkdir -p "$1"
	OUTPUT_DIR="$1"
fi

docker build -t about-me-updater . 
docker run --rm -v $(pwd):/about-me-src -v $OUTPUT_DIR:/about-me about-me-updater bash -c "cd /about-me-src/ && ./install.sh /about-me/"
for i in 'about-me' 'about-me/' ; do
	curl -X PURGE "http://deigote.com/$i" &> /dev/null
done
