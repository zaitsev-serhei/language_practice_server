# Language Practice Server

[![Java](https://img.shields.io/badge/Java-21-blue)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-blue)](https://www.postgresql.org/)
[![Kafka](https://img.shields.io/badge/Kafka-3.6-yellow)](https://kafka.apache.org/)

## Project Description
Language Practice Server is a backend for mobile and web applications for language learning and managing educational tasks.  
The project follows **Clean Architecture principles**, separating domain, database, service, and controller layers.

### Main Modules and Packages

- **domain** — business logic and models:
  - `model` — domain classes, e.g., `Task`, `Assignment`, `User`.
  - `repository` — domain repository interfaces for working with domain objects.
  
- **db** — database layer:
  - `entity` — JPA entities (`TaskEntity`, `AssignmentEntity`, `UserEntity`).
  - `repository` — Spring Data JPA repositories (`TaskRepositoryJpa`, etc.).
  - `adapter` — adapters for integrating domain repositories with JPA.
  
- **service** — business logic services:
  - Implementations of service interfaces (`TaskServiceImpl`, `UserServiceImpl`, `AssignmentServiceImpl`).
  - Contains transactional methods for CRUD operations.
  
- **web/controller** — REST controllers:
  - Endpoints for managing tasks, users, and assignments.
  - Uses DTOs to transfer data to the frontend.
  
- **mapper** — MapStruct mappers between entities, domain models, and DTOs.

- **kafka** — Kafka integration:
  - `KafkaEventProducer` — publishes events to Kafka topics.
  - `NotificationKafkaListener` (in Notification Service) — consumes events for creating notifications.

- **config** — Spring Boot configurations:
  - JPA Auditing, Kafka.

### Project Structure
language_practice_server/</br>
├── src/main/java/com/language_practice_server/</br>
│ ├── server_demo/</br>
│ │ ├── audit/</br>
│ │ ├── common/</br>
│ │ ├── db/</br>
│ │ │ ├── entity/</br>
│ │ │ ├── repository/</br>
│ │ │ └── adapter/</br>
│ │ ├── domain/</br>
│ │ │ ├── model/</br>
│ │ │ └── repository/</br>
│ │ ├── kafka/</br>
│ │ ├── mapper/</br>
│ │ ├── service/</br>
│ │ │ ├── impl/</br>
│ │ └── web/</br>
│ │ │ ├── controller/</br>
│ │ │ ├── security/</br>
│ │ │ └── dto/</br>
│ │  config/</br>
├── pom.xml</br>
└── README.md</br>

## Kafka and Event Flow

The system uses Kafka to propagate domain events, e.g., when tasks or assignments are created.  
This allows other microservices (like a Notification Service) to react to changes without tight coupling.

**Example flow for Task creation:**

1. User creates a task via REST API: `POST /tasks/create`.
2. `TaskServiceImpl` saves the task in the database.
3. `KafkaEventProducer` publishes a `TaskCreatedEvent` to the `task-created` Kafka topic.
4. Notification Service listens to `task-created` events via `NotificationKafkaListener`.
5. Notification Service creates a notification for the task creator or assignee.

This architecture ensures loose coupling between services and allows scaling the Notification Service independently.

# Installation and Running

Clone the repository:

git clone https://github.com/zaitsev-serhei/language_practice_server.git </br>
cd language_practice_server</br>

Clone the repository(for notification service) and explore Readme.md file with setup instructions:</br>

git clone https://github.com/zaitsev-serhei/notification_service</br>

# Install the contracts module locally:

git clone https://github.com/zaitsev-serhei/contracts.git</br>
cd contracts</br>
mvn -B clean install</br>


# The artifact will be installed in your local Maven repository:

~/.m2/repository/org/vavilonLearn/contracts/contracts-1.0-SNAPSHOT.jar


# Install dependencies and run the project:

mvn clean install</br>
mvn spring-boot:run


REST API is available at http://localhost:8080/

# Example Endpoints

POST /tasks/create — create a new task

GET /tasks//findById/{taskId} — get task by ID

GET /tasks/creator/{creatorId} — get tasks by creator

Kafka events are automatically published when creating tasks and assignments(TBD).

# Authors

Sir Beard — https://github.com/Sir-Beard

Serhii Zaitsev — https://github.com/zaitsev-serhei

