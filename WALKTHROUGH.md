# Video Walkthrough Script (approx. 5 minutes)

Record with any screen recorder (OBS, Loom, Zoom) and upload as **unlisted** on YouTube / Loom / Google Drive.

1. **Intro (20s)** – project name, stack (Spring Boot 3, JPA/Hibernate, Spring Security sessions, Springdoc, vanilla JS UI).
2. **Architecture (45s)** – open `README.md`, show the layered diagram: controller → service → repository → DB.
3. **Login (30s)** – sign in as `staff / staff123`. Point out the `JSESSIONID` cookie in DevTools → Application → Cookies.
4. **CRUD (60s)** – add a patient, edit it, search it. Try an invalid email to show validation messages coming from `@ControllerAdvice`.
5. **Business rule (30s)** – book two appointments for the same doctor/time → 409 conflict message.
6. **Roles (30s)** – as `staff` there is no Delete button; log in as `admin` and delete a record. (Show 403 JSON in Swagger for staff.)
7. **Swagger (45s)** – open `/swagger-ui.html`, run `POST /api/auth/login`, then call an endpoint.
8. **Exception handling code (30s)** – show `GlobalExceptionHandler.java`.
9. **Wrap-up (15s)** – GitHub repo, how to run (`mvn spring-boot:run`), future improvements.
