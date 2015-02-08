import groovy.io.FileType
@Grapes(
  @Grab(
    group='com.yahoo.platform.yui',
    module='yuicompressor',
    version='2.4.6'
  )
)
import groovy.text.SimpleTemplateEngine

import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest

outputPath = args.getAt(0) ?: './'
outputDir = new File(outputPath)
if (!outputDir.exists()) {
	outputDir.mkdir()
}

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
	def filePathParts = filePath.tokenize('.'),
		fileNamePrefix = filePathParts[0..-2].join(''),
		fileNameExt = filePathParts.last(),
		fileName = "${outputPath}${fileNamePrefix}__${md5(file)}.${fileNameExt}"
	new File(fileName) << file.bytes
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

new File("${outputPath}index.html").write(new SimpleTemplateEngine().createTemplate(
	new java.io.FileReader(new File('index.html.template'))
).make(parameters).toString())

if (!(outputPath in ['', './'])) {
	new File('.').traverse(type: FileType.FILES) { file ->
		if (['png', 'jpg'].any { extensionToCopy -> file.path.endsWith(extensionToCopy) }) {
			Files.copy(Paths.get(file.path), Paths.get("${outputPath}${file.path}"))
		}
	}
}
