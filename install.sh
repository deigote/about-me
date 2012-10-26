#!/bin/bash

git remote update
if [[ `git status -uno | grep "# Your branch is behind"` ]] ; then 
	echo "We are behind, building a new release..."
	git pull origin master
	rm *.{css,js}_* *.ico.* 
	groovy index.groovy
        curl -X PURGE http://deigote.com/about-me &> /dev/null
else 
	echo "Everything is up to date"
fi
