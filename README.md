# Mananja System

A Spring Boot company website rendered with Thymeleaf, with a small JSON services API.

## Requirements

- Java 25 or later
- Maven 3.6.3 or later

## Develop

Start the application:

```powershell
mvn spring-boot:run
```

Open [http://localhost:8080](http://localhost:8080). The homepage is rendered from `src/main/resources/templates/index.html`; its stylesheet and logo are served from `src/main/resources/static`.

The API exposes `GET /api/health` and `GET /api/services`. Set `PORT` to change the HTTP port.

## Package

```powershell
mvn clean package
java -jar target/mananja-system-0.0.1-SNAPSHOT.jar
```

The contact link opens an email draft addressed to `hello@mananja.system`. Change that address or connect the contact flow to your email or CRM provider before launch.
# Mananja-Systems
