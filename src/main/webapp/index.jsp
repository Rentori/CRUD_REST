<html>
<head>
    <meta charset=utf-8" />
</head>
<body>
<p>
	<span style="color: #ff0000;">
		files: /FileServlet
	</span>
</p>
<p>
	<span style="color: #ff0000;">
		events: /EventServlet
	</span>
</p>
<p>
	<span style="color: #ff0000;">
		users: /UserServlet
	</span>
</p>
<p>
</p>
<p>
	<span style="color: #0000ff;">
		Description of the task:&nbsp;
	</span>
</p>
<p>
	implement a REST API that interacts with file storage and provides file access and download history.
</p>
<p>
	<span style="font-weight: 400;">
		Entity:
	</span>
</p>
<p>
	<span style="font-weight: 400;">
		 User
	</span>
</p>
<p>
	<span style="font-weight: 400;">
		 Event (File file)
	</span>
</p>
<p>
	<span style="font-weight: 400;">
		 File
	</span>
	<span style="font-weight: 400;">
		<br />
	</span>
	<span style="font-weight: 400;">
		 User -&gt; List&lt;Events&gt;
	</span>
</p>
<p>
	<span style="color: #0000ff;">
		<span style="font-weight: 400;">
			Requirements:
		</span>
	</span>
</p>
<ul>
	<li>
		All CRUD operations for each entity
	</li>
	<li>
		Stick to the MVC approach
	</li>
	<li>
		Use Maven to build your project
	</li>
	<li>
		To interact with the database - Hibernate
	</li>
	<li>
		For customizing Hibernate - annotations
	</li>
	<li>
		Database initialization must be implemented using a flyway
	</li>
	<li>
		User interaction must be implemented using Postman (https://www.getpostman.com/).
	</li>
	<li>
		There should be a travis build icon in the repository (https://travis-ci.com/)
	</li>
	<li>
		You need to deploy a working application to heroku.com.
	</li>
</ul>
<h4>
	<span style="color: #0000ff;">
		<span style="font-weight: 400;">
			Technoligies:
		</span>
	</span>
	Java, MySQL, Hibernate, HTTP, Servlets, Maven, Flyway.
</h4>
<p>
	<span style="color: #0000ff;">
		Design patterns:
	</span>
</p>
<ul>
	<li>
		Singleton
	</li>
	<li>
		Factory method
	</li>
	<li>
		MVC
	</li>
</ul>
<p>
	<span style="color: #0000ff;">
		Run instruction:
	</span>
</p>
<ol>
	<li>
		Import your project on local repository;
	</li>
	<li>
		Change configuration files (flyway.properties, hibernate.cfg.xml) for DB connection;
	</li>
	<li>
		Run in console: mvn flyway:migrate for DB init;
	</li>
	<li>
		configure heroku dependencyes;
	</li>
	<li>
		Command for local server run:
		<code class=" language-term">
			<span class="token input">
				java -jar target/dependency/webapp-runner.jar target/*.war
			</span>
		</code>
	</li>
</ol>
</body>
</html>