import groovy.text.SimpleTemplateEngine
import java.security.MessageDigest

def withNewFile(File file, closure)
{
	file.delete()
	closure(file)
	file.createNewFile()
	return file
}

File.metaClass.leftShift = { Object content ->
	withNewFile(delegate) { file -> file.append(content as String) }
}

File.metaClass.leftShift = { byte[] content ->
	withNewFile(delegate) { file -> file.append(content) }
}

def md5(file) {
	new BigInteger(1, MessageDigest.getInstance('MD5').with {
		file.eachByte( 8192 ) { bfr, num -> update bfr, 0, num }
		digest()
	}).toString( 16 ).padLeft( 32, '0' )
}

def versionateFile(filePath, file = new File(filePath)) { 
	new File("$file.${md5(file)}") << file.bytes
}

String mixFiles(files) {
	def file = new File((files*.toString()).join('_'))
	file << files.collect { new File(it).text }.join("\n")
}

def parameters =  new ConfigSlurper().parse(new File('config.groovy').toURL())
parameters.resources.each { type, urls ->
	parameters.resources[type] = (type in ['css', 'js' ] && urls) ?
		[versionateFile(mixFiles(urls))] : 
		urls.collect { url -> versionateFile(url) }
}

new File('index.html').write(new SimpleTemplateEngine().createTemplate(
	new java.io.FileReader(new File('index.html.template'))
).make(parameters).toString())
