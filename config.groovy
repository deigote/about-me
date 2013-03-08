siteName = "deigote.com"
siteURL = "http://$siteName"
nickname = "deigote"
name = "Diego Toharia"
author = "$name (also known as $nickname)"
company = "tadoº"
clear = "<div style='clear:both; height: 0; width: 0'>&nbsp</div>"
title = "About $author" 
shortDescription= """$author is a software engineer that develops software for $company using 
Grails, J2EE, web technologies and iOS. He also enjoy Linux sysadmin tasks and in his spare time 
jokes about being a beer taster"""
author = "$author"
siteName = "$siteName"
siteURL = "$siteURL"
twitterId = "@$nickname"
smallAvatarURL = "$siteURL/avatar-small.jpg"
bigAvatarURL = "$siteURL/avatar-big.jpg"
greeting = "$author"
learnMore = 'Learn more!'
keywords = 
	[
		'Diego Toharia', 'deigote', 'software', 'developer', 'engineer', 'groovy', 'grails', 
		'j2ee', 'java', 'linux', 'sysadmin', 'cloud', 'amazon', 'aws', 'liferay', 'beer'
	]
professional_paragraphs = 
	[
		"""I am a software engineer who has passion for <strong>software 
	developing</strong>. I work for <a href="http://tado.com">$company</a> 
	with an <a href="http://www.tado.com/en/team.html">awesome team</a> making 
	an <em>Internet of the things</em> super cool product. I usually speak 
	<strong>Groovy</strong>, but my <em>mother tongue</em> is <strong>Java</strong>, and 
	I have wide experience developing <strong>web applications</strong>.""",
		"""On the other hand, I enjoy <strong>Linux</strong> system administration a 
	lot, and I have being able to explote such passion by exercising as <strong>sysadmin
	</strong> in complex cloud-based production systems that use <strong>Amazon AWS</strong> 
	and <strong>Puppet</strong>."""
	]
professional_links =
	[
		[title: 'Linked In', tag: 'linked-in', url: 'http://www.linkedin.com/in/dtoharia'],
		[title: 'CV', tag: 'cv', url: 'http://diego.toharia.com/cv'],
                [title: 'Github activity', tag: 'github', url: "https://github.com/${nickname}?tab=activity"],
		[title: 'Blog', tag: 'blog', url:  'http://blog.deigote.com/category/informatica-internet-y-tecnologia/'],
		[title: "Me at $company", tag: 'job', url: 'http://http://www.tado.com/en/team.html'],
		[title: "I Do The Shopping, a pet project written in Groovy and Grails", tag: 'idotheshopping', url: 'http://idotheshopping.com'],
		[title: "My Best Lap, a pet project written in Ruby on Rails", tag: 'mybestlap', url: 'http://mybestlap.com']
	]
personal_paragraphs =
	[
		"""When I'm not working, I like to joke about me being a <strong>beer</strong> taster.
	The truth is I enjoy good beer and I blog about it in <a href="http://unacervezaaldia.es">
	Una cerveza al dia</a>.""", 
		"""Other than that, <strong>music</strong> is my passion, and I like to <strong>travel</strong>
	and to do outdoor <strong>sports</strong>."""
	]
personal_links =
	[
		[title: 'Twitter', tag: 'twitter', url: "http://twitter.com/$nickname"],
		[title: 'Una cerveza al dia', tag: 'una-cerveza-al-dia', url: 'http://unacervezaaldia.es'],
		[title: 'Instagram', tag: 'instagram', url: "http://web.stagram.com/n/$nickname"],
		[title: 'Flickr', tag: 'flickr', url: "http://www.flickr.com/photos/$nickname"],
		[title: 'Dailymile', tag: 'dailymile', url: "http://www.dailymile.com/people/$nickname"],
		[title: 'Soundtracking', tag: 'soundtracking', url: "http://soundtracking.com/$nickname"],
	]
piwik = """<!-- Piwik -->
<script type="text/javascript">
var pkBaseURL = (("https:" == document.location.protocol) ? 
"https://stats.deigote.com/piwik/" : "http://stats.deigote.com/piwik/");
document.write(unescape("%3Cscript src='" + pkBaseURL + "piwik.js' type='text/javascript'%3E%3C/script%3E"));
</script><script type="text/javascript">
try {
var piwikTracker = Piwik.getTracker(pkBaseURL + "piwik.php", 2);
piwikTracker.trackPageView();
piwikTracker.enableLinkTracking();
} catch( err ) {}
</script><noscript><p><img src="http://stats.deigote.com/piwik/piwik.php?idsite=2" 
style="border:0" alt=""/></p></noscript>
<!-- End Piwik Tag -->"""
sections = 
	[
		[ name:"professional", paragraphs: professional_paragraphs, links: professional_links],
		[ name:"personal", paragraphs: personal_paragraphs, links: personal_links],
	]
resources = 
	[
		ico: ['favicon.ico'],
		css: ['aboutme.css', 'fonts.css'],
		js: ['aboutme.js'],
	]
