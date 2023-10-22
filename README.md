# Word Counter REST API
First version of the API exposing the [Word Counter library](https://github.com/phlebas/WordCounter/blob/main/README.md) functions.

The REST API is built as a Spring Boot application with a Swagger front end. 
The [Project Lombok library](https://projectlombok.org/) is used to avoid boilerplate code. A plugin for IntelliJ is available 
and should be installed if the project is to be opened in that IDE.  

The build system is Maven. To run the application download the project 
and run with the command: 

`mvn spring-boot:run`  

The Swagger front end will be accessible at:  

http://localhost:8080/swagger-ui/index.html


