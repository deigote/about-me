#!/bin/bash

git remote update
if [[ `git status -uno | grep "Your branch is behind"` ]] ; then 
	echo "We are behind, building a new release..."
	git pull origin master
	rm *.{css,js}_* *.ico.* 
	groovy index.groovy
	for i in 'about-me' 'about-me/' ; do
	        curl -X PURGE "http://deigote.com/$i" &> /dev/null
	done
else 
	echo "Everything is up to date"
fi
