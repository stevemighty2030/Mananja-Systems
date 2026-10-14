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

The consultation form sends requests to `wambu2040@gmail.com` through SMTP. Configure these environment variables in the deployment settings before using the form:

- `MAIL_HOST` (defaults to `smtp.gmail.com`)
- `MAIL_PORT` (defaults to `587`)
- `MAIL_USERNAME` (the Gmail account used to send the message)
- `MAIL_PASSWORD` (a Google App Password for that account)
- `CONTACT_EMAIL` (defaults to `wambu2040@gmail.com`)

For Gmail, use an App Password rather than your regular account password. Add the values in Vercel under **Project Settings → Environment Variables**, then redeploy. The visitor's email address is set as the reply-to address so you can reply directly.
# Mananja-Systems
