DESCRIPTION: 

implement a REST API that interacts with file storage and provides file access and download history.

(reference for testing: https://rentori-crud-rest.herokuapp.com/)

ENTITY:

User
Event (File file)
File
User -> List<Events>

REQUIREMENTS:

1) All CRUD operations for each entity
2) Stick to the MVC approach
3) Use Maven to build your project
4) To interact with the database - Hibernate
5) For customizing Hibernate - annotations
6) Database initialization must be implemented using a flyway
7) User interaction must be implemented using Postman (https://www.getpostman.com/).
8) There should be a travis build icon in the repository (https://travis-ci.com/)
9) You need to deploy a working application to heroku.com.

TECHNOLOGES: Java, MySQL, Hibernate, HTTP, Servlets, Maven, Flyway.

DESIGN PATTERNS:

1) Singleton
2) Factory method
3) MVC

RUN INSTRUCTION:

1) Import your project on local repository;
2) Change configuration files (flyway.properties, hibernate.cfg.xml) for DB connection;
3) Run in console: mvn flyway:migrate for DB init;
4) configure heroku dependencyes;
5) Command for local server run: java -jar target/dependency/webapp-runner.jar target/*.war
