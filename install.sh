#!/bin/bash

git pull origin master
rm *.{css,js,ico}.*
groovy index.groovy
