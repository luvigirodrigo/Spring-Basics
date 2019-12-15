# SpringBasics
Project to practice Spring framework fundamentals 

# Before starting the application
1. Before proceeding to start the app, application.properties file has to be configured to map to a postgres database and a schema with your own connection properties(following lines).
	
			spring.datasource.url=jdbc:postgresql://localhost:5432/spring_app_db
			spring.datasource.username=postgres
			spring.datasource.password=postgres@11
			spring.jpa.properties.hibernate.default_schema=spring_app_schema

	
