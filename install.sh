#!/bin/bash

cd $(dirname $0)

OUTPUT_DIR="$(pwd)/out/"
if [ -d "$1" ] ; then
	OUTPUT_DIR="$1"
fi

git remote update
if [[ ! -f "$OUTPUT_DIR/index.html" || `git status -uno | grep "Your branch is behind"` ]] ; then
	echo "We are behind, building a new release in $OUTPUT_DIR"
	git pull origin master
	find "$OUTPUT_DIR/" -maxdepth 1 -mindepth 1 -type f -delete
	cd src/
	groovy index.groovy "$OUTPUT_DIR"
	for i in 'about-me' 'about-me/' ; do
	        curl -X PURGE "http://deigote.com/$i" &> /dev/null
	done
else
	echo "Everything is up to date"
fi
