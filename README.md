# Todo Application (Spring Boot)

A simple task management web application built using **Spring Boot**, **Spring Security**, **Thymeleaf**, and **MySQL**.  
Users can register, log in, and manage personal tasks.

---

## Features

- User registration and authentication
- Secure login using Spring Security
- Create new tasks
- Mark tasks as completed
- Delete tasks
- Tasks are associated with the logged-in user

---

# Running the Project

Follow these steps to run the project locally.

## 1. Clone the repository
```bash
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
```
## 2. Create a MySQL database
Create a database in MySQL:
```CREATE DATABASE todo_db;```

## 3. Create application-dev.properties
This file should NOT be committed to GitHub since it contains database credentials.

Create the file: ```src/main/resources/application-dev.properties```

Add the following configuration:

```
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

## 4. Activate the dev profile
Ensure the project runs with the dev profile.
There's already a line ```spring.profiles.active=dev``` in the main profile.

## 5. Run the application
Using Maven:
```./mvnw spring-boot:run```

Or run the main Spring Boot class from your IDE.