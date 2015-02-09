FROM webratio/groovy:2.3.9

# Install git
RUN \
	apt-get update && \
	apt-get install -y git

ENTRYPOINT ["/about-me-src/install.sh", "/about-me/"]
