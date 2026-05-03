# 🚀 Miqat Task Scheduler

A production-ready **Task Scheduling System** built with **Spring Boot + Kotlin**, designed to manage and execute background jobs reliably using **JobRunr**, with database versioning powered by **Liquibase**.

---

## ✨ Overview

Miqat Task Scheduler is a backend service that allows users to:

* Create and schedule tasks for future execution
* Track task lifecycle in real-time
* Execute background jobs asynchronously
* Persist data reliably using PostgreSQL

---

## 🧠 Architecture

```text
Client → Controller → Service → Repository → Database
                         ↓
                    JobRunr Scheduler
                         ↓
                 Background Execution
```

---

## 🛠️ Tech Stack

| Layer           | Technology                  |
| --------------- | --------------------------- |
| Language        | Kotlin                      |
| Framework       | Spring Boot 3               |
| Database        | PostgreSQL (Docker)         |
| ORM             | Spring Data JPA (Hibernate) |
| Migration       | Liquibase                   |
| Background Jobs | JobRunr                     |
| API Docs        | Swagger (Springdoc OpenAPI) |

---

## ⚙️ Features

* ⏱️ Schedule tasks at a specific date/time
* 🔄 Background processing using JobRunr
* 📊 Task status tracking:

  * `PENDING`
  * `RUNNING`
  * `DONE`
  * `FAILED`
* 🧾 RESTful API
* 📦 Clean layered architecture
* 🔄 Database version control via Liquibase
* 🌐 Interactive API docs via Swagger

---

## 📁 Project Structure

```bash
src/main/kotlin/tasks/
│
├── controller     # API endpoints
├── service        # Business logic
├── repository     # Data access layer
├── entity         # Database models
├── dto            # Request / Response objects
└── enum           # Enums (status, priority)
```

---

## 🐳 Running the Database (Docker)

```bash
docker-compose up -d
```

### Database Config

| Property | Value          |
| -------- | -------------- |
| Host     | localhost      |
| Port     | 5434           |
| DB       | task_scheduler |
| User     | ********       |
| Password | ********       |

---

## ▶️ Running the Application

```bash
./gradlew bootRun
```

---

## 🌐 API Documentation

Since the app uses a dynamic port:

```bash
Tomcat started on port XXXXX
```

Open Swagger UI:

```
http://localhost:XXXXX/swagger-ui/index.html
```

---
ة
## 🧩 Database Migration

Handled automatically via Liquibase.

Main file:

```
db/changelog/db.changelog-master.xml
```

---

## 🔥 Key Implementation Highlights

* Uses **JobRunr** for reliable background job scheduling
* Clean separation of concerns (Controller → Service → Repository)
* Automatic timestamp management using JPA lifecycle hooks
* Enum-based status and priority system
* Resilient execution with failure handling

---

## ⚠️ Important Notes

* Database runs via Docker on port `5434`
* Application uses dynamic port (`server.port=0`)
* Liquibase runs automatically on startup


---

## 👩‍💻 Author

**Ghaida Alqahtani**

