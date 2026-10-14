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

## Deploy to Vercel

Vercel can build and run this Spring Boot app from `Dockerfile.vercel`. Import the repository in Vercel, or deploy it with the Vercel CLI from the repository root. Vercel detects the Dockerfile and routes HTTP requests to the container. The app reads Vercel's `PORT` environment variable through `application.properties`.

For a CLI deployment, install and authenticate the Vercel CLI, then run:

```powershell
vercel
```

Use `vercel --prod` when you are ready to create a production deployment. See [Vercel's Docker deployment guide](https://vercel.com/kb/guide/docker) for platform requirements and local development details.

The contact link opens an email draft addressed to `hello@mananja.system`. Change that address or connect the contact flow to your email or CRM provider before launch.
# Mananja-Systems
