FROM webratio/groovy:2.3.9

# Install git
RUN \
	apt-get update && \
	apt-get install -y git

# Prepare bitbucket auth
COPY deigote.com_deployment_key.pub /root/.ssh/id_rsa.pub
COPY deigote.com_deployment_key /root/.ssh/id_rsa
RUN \
	chmod 600 /root/.ssh/id_rsa* && \
	echo "IdentityFile /root/.ssh/id_rsa" >> /etc/ssh/ssh_config && \
	echo "StrictHostKeyChecking no" >> /etc/ssh/ssh_config

ENTRYPOINT ["/about-me-src/install.sh", "/about-me/"]
