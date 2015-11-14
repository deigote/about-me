# about-me

This is a typical `about me` page that was use as an excuse to have some fun creating a simple, 
staticpage using `Groovy` for generating the content, `Docker` for building it, and `Travis CI` 
for deploying it.

[![Build Status][travis-image]][travis-url] [![Build Status][visit-image]][visit-url]

### Technologies

This `about me` page is possible thanks to the following great technologies:
- [Groovy language](src/index.groovy) ([more about Groovy](http://www.groovy-lang.org/))
- [Groovy's Config Slurper](src/config.groovy) ([more about Config Slurper](http://docs.groovy-lang.org/latest/html/gapi/groovy/util/ConfigSlurper.html))
- [Groovy's Template Engine](src/index.html.template) ([more about Template Engine](http://docs.groovy-lang.org/next/html/documentation/template-engines.html))
- [Travis CI](.travis.yml) ([more about Travis CI](https://travis-ci.org/))
- [Docker](Dockerfile) ([more about docker](https://www.docker.com/))

[travis-url]: https://travis-ci.org/deigote/cv
[travis-image]: https://travis-ci.org/deigote/cv.svg?branch=master

[visit-url]: http://deigote.com/about-me
[visit-image]: https://img.shields.io/badge/visit-me-green.svg


