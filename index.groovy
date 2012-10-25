import groovy.text.SimpleTemplateEngine
import java.security.MessageDigest

def md5(file) {
	new BigInteger(1, MessageDigest.getInstance('MD5').with {
		file.eachByte( 8192 ) { bfr, num -> update bfr, 0, num }
		digest()
	}).toString( 16 ).padLeft( 32, '0' )
}

def versionateFile(filePath, file = new File(filePath)) { 
	new File("$file.${md5(file)}") << file.bytes
}

def parameters =  new ConfigSlurper().parse(new File('config.groovy').toURL())
parameters.resources.each { type, urls ->
	parameters.resources[type] = urls.collect { url -> versionateFile(url) }
}

new File('index.html').write(new SimpleTemplateEngine().createTemplate(
	new java.io.FileReader(new File('index.html.template'))
).make(parameters).toString())