# Student Management REST API

A RESTful API built with Spring Boot for managing student records,
demonstrating a clean three-layer architecture with full CRUD operations.

## Tech Stack
- Java 25
- Spring Boot 4.x
- Spring Data JPA
- MySQL
- Maven

## Architecture
Controller → Service → Repository → Database

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get student by ID |
| GET | /api/students/course/{course} | Get students by course |
| GET | /api/students/top?gpa=3.5 | Get students above GPA |
| POST | /api/students | Create new student |
| PUT | /api/students/{id} | Update student |
| DELETE | /api/students/{id} | Delete student |

### Steps
1. Clone the repository - 
   git clone https://github.com/abhi29092001/Student-Management-Rest-API

2. Create MySQL database - 
   CREATE DATABASE student_db;

3. Configure database - 
   Copy application.properties.example to application.properties
   Fill in your database credentials

4. Run - 
   ./mvnw spring-boot:run

## Key Concepts Demonstrated
- Spring Core — IoC, Dependency Injection, Bean lifecycle
- Spring Data JPA — JpaRepository, custom JPQL queries
- REST API design — proper HTTP methods and status codes
- Exception handling — @RestControllerAdvice, custom exceptions
- Layered architecture — Controller, Service, Repository
- Constructor injection throughout