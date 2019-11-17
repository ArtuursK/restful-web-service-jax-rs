Overview
========
Basic Jersey RESTful web service implementation 

How-to run
==========
Requirements:

Java 8,
Gradle and
Tomcat 8.*
````
1) Compile - compile the project using gradle:
````
```
    gradle build
```
```
    The war file is compiled to: `build/libs` directory
```
```
2) Deploy the war file to apache-tomcat [http://tomcat.apache.org] web container.  

    Use Tomcat Web Application Manager to deploy and undeploy the .war archive

3) Verify that it's running by going to one of the following endpoints:

    http://localhost:8080/rest/hello
    
    http://localhost:8080/rest/user/{name}
    
    http://localhost:8080/rest/exception
```