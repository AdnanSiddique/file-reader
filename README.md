## Introduction
The application is consuming XML and JSON type of data files from resource folder inside Application.  An implementation of SaleObjectConsumer interface is written in order to test the application.

## Technology Stack
- Java version : 11
- Maven version : 3.8.3
- Apis Used 
  - gson version : 2.8.9
  - jaxb version : 3.0.0

## Steps to run
1. Clean and compile project using mvn command mentioned below:
```
 mvn clean compile

```
2. Run test cases using mvn command mentioned below:
```
 mvn test

```

3. Run App.java class using mvn command mentioned below: 
```
 mvn exec:java -D"exec.mainClass"="org.adnan.App"

``` 
4. Run main method in App.java using IDE.

### Author
- Name : Muhammad Adnan
- Email : adnansiddiq@outlook.com

