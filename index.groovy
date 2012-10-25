import groovy.text.SimpleTemplateEngine

def siteName = "deigote.com"
def siteURL = "http://siteName"
def nickname = "deigote"
def name = "Diego Toharia"
def author = "$name (also known as $nickname)"
def company = "OSOCO"
def parameters = 
[
	clear: "<div style='clear:both; height: 0; width: 0'>&nbsp</div>",
	title: "About $author", 
	shortDescription: """$author is a software engineer that develops software for $company using 
Grails, J2EE, web technologies and iOS. He also enjoy Linux sysadmin tasks and in his spare time 
jokes about being a beer taster""",
	author: "$author",
	siteName: "$siteName",
	siteURL: "$siteURL",
	faviconURL: "$siteURL/favicon.ico",
	twitterId: "@$nickname",
	smallAvatarURL: "$siteURL/avatar-small.jpg",
	bigAvatarURL: "$siteURL/avatar-big.jpg",
	keywords: 
	[
		'Diego Toharia', 'deigote', 'software', 'developer', 'engineer', 'groovy', 'grails', 
		'j2ee', 'java', 'linux', 'sysadmin', 'cloud', 'amazon', 'aws', 'liferay', 'beer'
	],
	greeting: "$author",
	professional_description: 
	[
		"""I am a software engineer who has passion for <strong>software 
developing</strong>. I work for <a href="http://osoco.es">$company</a> making products 
that help other companies digital dreams to come true. I usually speak 
<strong>Groovy</strong>, but my <em>mother tongue</em> is <strong>Java</strong>, and 
I have wide experience developing <strong>web applications</strong>.""",
		"""On the other hand, I enjoy <strong>Linux</strong> system administration a 
lot, and I have being able to explote such passion by exercising as <strong>sysadmin
</strong> in complex cloud-based production systems that use <strong>Amazon AWS</strong> 
and <strong>Puppet</strong>."""
	],
	professional_links:
	[
		[title: 'Linked In', tag: 'linked-in', url: 'http://www.linkedin.com/in/dtoharia'],
		[title: 'Blog', tag: 'blog', url:  'http://blog.deigote.com/category/informatica-internet-y-tecnologia/'],
		[title: "Me at $company", tag: 'job', url: 'http://osoco.es/equipo'],
		[title: "I Do The Shopping, a pet project written in Groovy and Grails", tag: 'idotheshopping', url: 'http://idotheshopping.com'],
		[title: "My Best Lap, a pet project written in Ruby on Rails", tag: 'mybestlap', url: 'http://mybestlap.com']
	],
	personal_description:
	[
	"""When I'm not working, I like to joke about me being a <strong>beer</strong> taster.
The truth is I enjoy good beer and I blog about it in <a href="http://unacervezaaldia.es">
Una cerveza al dia</a>.""", 
	"""Other than that, <strong>music</strong> is my passion, and I like to <strong>travel</strong>
and to do outdoor <strong>sports</strong>."""
	],
	personal_links:
	[
		[title: 'Twitter', tag: 'twitter', url: "http://twitter.com/$nickname"],
		[title: 'Una cerveza al dia', tag: 'una-cerveza-al-dia', url: 'http://unacervezaaldia.es'],
		[title: 'Instagram', tag: 'instagram', url: "http://web.stagram.com/n/$nickname"],
		[title: 'Flickr', tag: 'flickr', url: "http://www.flickr.com/photos/$nickname"],
		[title: 'Dailymile', tag: 'dailymile', url: "http://www.dailymile.com/people/$nickname"],
		[title: 'Soundtracking', tag: 'soundtracking', url: "http://soundtracking.com/$nickname"],
	],
	learMore: 'Learn more!'
]

println new SimpleTemplateEngine().createTemplate(
	new java.io.FileReader(new File('index.html.template'))
).make(parameters).toString()