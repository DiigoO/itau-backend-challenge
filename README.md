# Read Me First
The following was discovered as part of building this project:

* The original package name 'br.com.itau.backend-challenge' is invalid and this project uses 'br.com.itau.backendchallenge' instead.

# Getting Started

## Solution Details
```

When creating the base project I added the dependencies:
- Spring Web (to upload my application with toncat and restful with a standard built-in container.)
- Spring Boot Actuator (Monitoring and managing the service)

I thought about creating an object and using RequestBody in the controller, so I could do the proper validations with javax.validation from a regex;
I also thought about creating a PasswordConstraint and a PasswordValidator and using the @GeojsonConstraint annotation to do the necessary validation;
For a better understanding of the construction of the case I chose to use a service for validation;

I later added the libs
- lombook (Helps implementation by exchanging some constructs for annotations)
- Spring validation (For request validation)
- springfox (To build a swagger)

Password Validation was built in two steps, the first is a simple regex that validates:
   * Nine or more characters
   * At least 1 digit
   * At least 1 lowercase letter
   * At least 1 capital letter
   * At least 1 special character
        * Consider the following characters as special: !@#$%^&*()-+
and a stream that validates the number of repeated characters.
    * Do not have repeated characters within the set

Then I wrote the integration and unit tests;
I also created a sandbox properties thinking that the service can run in more than one environment;
Lastly the DOCKERFILE and dockercomposer;

In every development a sonarlint plugin was used, thus ensuring that the code does not have any vulnerability, bug or condesmell;
```

## How To Execute

To clone and run this application, you'll need [Git](https://git-scm.com), [JAVA](https://java.com/en/download/help/download_options.html) and [Apache Maven](https://maven.apache.org/install.html) installed on your computer.

From your command line:
```bash
# Clone this repository
$ git clone https://github.com/DiigoO/itau-backend-challenge.git

# Go into the repository
$ cd itau-backend-challenge-main

# Install dependencies
$ mvn clean install

# Run the api
$ java -jar target/backend-challenge-0.0.1-SNAPSHOT.jar
```

OR [Docker](https://docs.docker.com/engine/install/) and [Docker Compose](https://docs.docker.com/compose/install/) installed on your computer.

```bash
# Clone this repository
$ git clone https://github.com/DiigoO/itau-backend-challenge.git

# Go into the repository
$ cd itau-backend-challenge-main

# Build docker compose
$ docker-compose build --no-cache

# Run docker composer (LINUX example)
$ docker-compose up
```
##Swagger-ui: `http://localhost:8080/swagger-ui.html`

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.5/maven-plugin/reference/html/#build-image)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#production-ready)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

