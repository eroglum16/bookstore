
# Online Bookstore API

This is a Spring Boot application built using Maven.

## Prerequisites

Before running the application, ensure that you have the following installed:

- **Java 17** or higher
- **Maven 3.6.3** or higher

## Getting Started

### 1. Build the application

Use Maven to build the application:

```bash
mvn clean install
```

### 2. Run the application

After building, run the application with:

```bash
mvn spring-boot:run
```

Alternatively, you can run the generated JAR file:

```bash
java -jar target/api-0.0.1-SNAPSHOT.jar
```

### 3. Access the application

Once the application is running, access the OpenAPI definition in your browser at:

```
http://localhost:8080/swagger-ui.html
```

## Configuration

You can configure the application settings (e.g., database, port) in the `src/main/resources/application.properties` file.

---

### Additional Notes

- To run tests: `mvn test`
- API is protected with basic auth. To access endpoints, remember to register a user first using the `/register` endpoint.
