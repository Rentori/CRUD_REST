<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=cp1251" />
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
		ОПИСАНИЕ ЗАДАЧИ:&nbsp;
	</span>
</p>
<p>
	<span style="font-weight: 400;">
		 Необходимо реализовать REST API, которое взаимодействует с файловым хранилищем и предоставляет возможность получать доступ к файлам и истории загрузок.
	</span>
</p>
<p>
	<span style="font-weight: 400;">
		 Сущности:
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
			 Требования:
		</span>
	</span>
</p>
<ul>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Все CRUD операции для каждой из сущностей
		</span>
    </li>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Придерживаться подхода MVC
		</span>
    </li>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Для сборки проекта использовать Maven
		</span>
    </li>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Для взаимодействия с БД - Hibernate
		</span>
    </li>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Для конфигурирования Hibernate - аннотации
		</span>
    </li>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Инициализация БД должна быть реализована с помощью flyway
		</span>
    </li>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Взаимодействие с пользователем необходимо реализовать с помощью Postman (
		</span>
        <a href="https://www.getpostman.com/">
			<span style="font-weight: 400;">
				 https://www.getpostman.com/
			</span>
        </a>
        <span style="font-weight: 400;">
			 )
		</span>
    </li>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Репозиторий должен иметь бейдж сборки travis(
		</span>
        <a href="https://travis-ci.com/">
			<span style="font-weight: 400;">
				 https://travis-ci.com/
			</span>
        </a>
        <span style="font-weight: 400;">
			 )
		</span>
    </li>
    <li style="font-weight: 400;" aria-level="1">
		<span style="font-weight: 400;">
			 Рабочее приложение должно быть развернуто на heroku.com
		</span>
    </li>
</ul>
<h4>
	<span style="color: #0000ff;">
		<span style="font-weight: 400;">
			 Технологии:
		</span>
	</span>
    Java, MySQL, Hibernate, HTTP, Servlets, Maven, Flyway.
</h4>
<p>
	<span style="color: #0000ff;">
		ШАБЛОНЫ ПРОЕКТИРОВАНИЯ:
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
		ИНСТРУКЦИЯ ПО ЗАПУСКУ:
	</span>
</p>
<ol>
    <li>
        Импортировать проект на локальный репозиторий;
    </li>
    <li>
        Изменить файлы конфигурации (flyway.properties, hibernate.cfg.xml) для подключения к БД;
    </li>
    <li>
        В консоли прописать команду mvn flyway:migrate для инициализации БД;
    </li>
    <li>
        Сконфигурировать heroku;
    </li>
    <li>
        Команда для запуска локального сервера:
        <code class=" language-term">
			<span class="token input">
				java -jar target/dependency/webapp-runner.jar target/*.war
			</span>
        </code>
    </li>
</ol>
</body>
</html>