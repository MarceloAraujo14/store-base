Objective:

Application to provide basic store functionalities.

---

Api Functionalities:

Product:
  - Register product
  - Update product by registration code
  - Find product by registration code
  - Find product by name
  - Filter products by Name
  - Search products by page

Next release:
  - feat/001 - create a frontend interface
  - feat/002 - implement postgresql database
  - feat/003 - implement pagination return
---
  
Code:
- API
  - Expose endpoints to the application functionalities.

- Core
  - Keep the core business rules.
  
- Adapters
  - Make the connection between the core and external dependencies.

---

Tech:
- Java 17
- Spring Boot
  - spring-data-jpa
  - spring-starter-web
- JUnit
- Mockito
- Lombok
- Database
  - H2
  