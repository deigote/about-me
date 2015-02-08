@Grapes(
  @Grab(
    group='com.yahoo.platform.yui', 
    module='yuicompressor', 
    version='2.4.6'
  )
)
import groovy.text.SimpleTemplateEngine
import java.security.MessageDigest
import com.yahoo.platform.yui.compressor.CssCompressor
import com.yahoo.platform.yui.compressor.JavaScriptCompressor
import org.mozilla.javascript.ErrorReporter

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

def compressFile(file, type, reader = new FileReader(file), reporter = [:] as ErrorReporter) {
	new File("${file.path}_compressed").with {
		withWriter { writer ->
			if (type == 'css') new CssCompressor(reader).compress(writer, 1024)
			else if (type == 'js') new JavaScriptCompressor(reader, reporter).compress(
				writer, 1024, false, false, true, true)
		}
		delegate
	}
}

def mixFiles(files) {
	def file = new File((files*.toString()).join('_'))
	file << files.collect { new File(it).text }.join("\n")
}

def parameters =  new ConfigSlurper().parse(new File('config.groovy').toURL())
parameters.resources.each { type, urls ->
	parameters.resources[type] = (type in ['css', 'js' ] && urls) ?
		[versionateFile(/*compressFile(*/mixFiles(urls)/*, type)*/.path)] : 
		urls.collect { url -> versionateFile(url) }
}

new File('index.html').write(new SimpleTemplateEngine().createTemplate(
	new java.io.FileReader(new File('index.html.template'))
).make(parameters).toString())
