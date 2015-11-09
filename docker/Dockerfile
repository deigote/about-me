FROM java:8-jre

ADD http://dl.bintray.com/groovy/maven/apache-groovy-binary-2.4.5.zip /opt/groovy.zip
RUN \
	cd /opt && \
	unzip groovy.zip && \
	rm groovy.zip

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/jre/
ENV GROOVY_HOME /opt/groovy-2.4.5
ENV PATH $GROOVY_HOME/bin:$PATH

# ENTRYPOINT ["groovy", "-Dgrape.root=/graperoot"]
