# Backend for Library Application

## Here will be application description

##To create a database: 
1. Add application.properties file in src/main/resources/application.properties
2. In application properties add database config, for example: 

```
spring.datasource.url=jdbc:postgresql://localhost:5432/library 
spring.datasource.username=postgres 
spring.datasource.password=password 
spring.jpa.hibernate.ddl-auto=update

spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.hbm2ddl.import_files=data.sql
```

## To start server on localhost: 
- On Mac or Linux:
`./gradlew bootRun`
- On Windows:
`gradlew bootRun`

### Api documentation in swagger (with default spring-boot configuration)

`http://localhost:8080/swagger-ui.html`
