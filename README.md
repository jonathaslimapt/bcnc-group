# bcnc-group


# 📦 Spring Boot 3.4.7 REST API Example

This project is an simple Hexagonal project using Spring Boot 3.4

- ✅ Endpoint REST -> GET /prices
- 📄 Spec on OpenAPI/Swagger -> http://localhost:8080/swagger-ui/index.html
- 🛢️ H2 Database in memory H2 -> Loades and charged from BncGroupApplication class on the root 
- 🚀 Already done to test

---

## 🔧 Technologies

- Java 21+
- Spring Boot 3.4.7
- Spring Web
- Spring Data JPA
- H2 Database
- springdoc-openapi v2

---

## ▶️ How to run
./mvnw clean package

### H2 Connection
To access the H2 console -> http://localhost:8080/h2-console/
- JDBC URL : jdbc:h2:mem:bcnc
- user = sa
- no password is necessary

### Steps

```bash
- git clone git@github.com:jonathaslimapt/bcnc-group.git or
- https://github.com/jonathaslimapt/bcnc-group.git

After, go to the root folder at: 
- cd bcnc-group

To execute direclty you can use 
- /mvn clean package
- /mvnw spring-boot:run

or Dockerized (Recommended)

docker build -t bcnc .
docker run -p 8080:8080 bcnc


