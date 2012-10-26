#!/bin/bash

git pull origin master
rm *.{css,js}_* *.ico.*
groovy index.groovy
