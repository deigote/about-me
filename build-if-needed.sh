#!/bin/bash

cd $(dirname $0)

OUTPUT_DIR="$(pwd)/out/"
if [ -d "$1" ] ; then
	OUTPUT_DIR="$1"
fi

git remote update
if [[ ! -f "$OUTPUT_DIR/index.html" || `git status -uno | grep "Your branch is behind"` ]] ; then
	echo "We are behind, building a new release"
	./build.sh
else
	echo "Everything is up to date"
fi
