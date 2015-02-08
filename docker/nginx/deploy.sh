#!/bin/bash
docker rm -f deigote.com docker run \
   --name deigote.com \
   -d \
   -p 0.0.0.0:80:80 \
   -v $(pwd)/sites-available/:/etc/nginx/sites-enabled \
   -v $(pwd)/certs:/etc/nginx/certs \
   -v $(pwd)/html:/var/www/html \
   -v /var/log/nginx_deigote.com/:/var/log/nginx \
   dockerfile/nginx
