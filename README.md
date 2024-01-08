# Student Management System

## Introduction
This Student Management System is designed to streamline the process of managing students in a school. It includes functionalities for both the Admin/Owner and the Students, providing a user-friendly interface for various operations.

Technologies Used
Spring Boot: For building RESTful APIs and handling backend logic.
JPA with Hibernate: For database operations and mapping between Java objects and relational database tables.
Swagger: For API documentation and testing.
DTO (Data Transfer Object) Layer: For mapping between DTOs and entities.
Project Structure
The project is organized into different layers to maintain a clean and modular structure:

Entity Layer: Contains the JPA entities representing the database tables.
Repo Layer: Handles database operations using Spring Data JPA repositories.
Controller: Manages incoming HTTP requests, processes them, and returns the appropriate response.
Business Layer: Contains the business logic and service classes to handle various operations.
DTO Layer: Represents the Data Transfer Objects to map between entities and API requests/responses.
Functionality
Operations for Admin/Owner:
Admit Student:



