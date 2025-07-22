# 🧠 Hexagonal Spring Boot REST API

A simple **Hexagonal Architecture** project using **Spring Boot 3.4.7**, created as an example for a pricing service.

---

## 🚀 Features

- ✅ `GET /prices` endpoint to retrieve product prices by date, product ID and brand ID
- 📄 Swagger UI available at: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- 🛢️ In-memory **H2 Database**, loaded at startup from `BcncGroupApplication`
- 🔍 Fully testable, with support for integration and unit tests

---

## 🔧 Technologies Used

- **Java 21**
- **Spring Boot 3.4.7**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Springdoc OpenAPI v2**

---

## ▶️ Getting Started

### 🖥️ Run locally

Use Maven:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

Or directly (if Maven is installed):

```bash
mvn clean package
mvn spring-boot:run
```

### 🐳 Run with Docker (Recommended)

```bash
docker build -t bcnc .
docker run -p 8080:8080 bcnc
```

---

## 🗂️ Project Structure

```
src/
├── domain/          → Domain model and business logic
├── application/     → Application services
├── infrastructure/  → Adapters (REST, JPA, DB)
└── config/          → Spring configuration
```

Follows a **Hexagonal Architecture (Ports & Adapters)** approach.

---

## 🧪 Testing

You can run all tests with:

```bash
./mvnw test
```

---

## 🛠️ H2 Database Access

H2 Console: [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)

- **JDBC URL:** `jdbc:h2:mem:bcnc`
- **User:** `sa`
- **Password:** *(none required)*

---

## 📥 Clone the Repository

```bash
git clone https://github.com/jonathaslimapt/bcnc-group.git
cd bcnc-group
```

---

## 📬 Example Request

### ✅ GET `/prices`

Endpoint para buscar o preço de um produto com base na data, ID do produto e ID da marca.

#### 📘 Request

```http
GET /prices?now=2020-06-14T10:00:00&productId=35455&brandId=1
Host: localhost:8080
```

#### 🧾 Query Parameters

| Name       | Type    | Description                          |
|------------|---------|--------------------------------------|
| `now`      | string  | Data e hora no formato ISO (`yyyy-MM-dd'T'HH:mm:ss`) |
| `productId`| integer | ID do produto                        |
| `brandId`  | integer | ID da marca                          |

---

#### ✅ Exemplo de resposta (HTTP 200 OK)

```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 1,
  "startDate": "2020-06-14T00:00:00",
  "endDate": "2020-12-31T23:59:59",
  "price": 35.50,
  "currency": "EUR"
}
```

#### ❌ Exemplo de resposta quando não encontrado (HTTP 204 No Content)

```http
HTTP/1.1 204 No Content
```

#### ❌ Exemplo de erro de validação (HTTP 400 Bad Request)

```http
GET /prices?now=invalid-date&productId=35455&brandId=1
```

```json
{
  "error": "Invalid date format. Expected yyyy-MM-dd'T'HH:mm:ss"
}
```

---

## 📄 License

This project is for demonstration and educational purposes.
