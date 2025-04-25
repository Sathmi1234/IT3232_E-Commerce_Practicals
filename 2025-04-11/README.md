# IT3232 E-Commerce Practicals - Day 6 - 2025-04-11

## Project Overview

This project is a Spring Boot application for managing employees, departments, projects, and insurance information using JPA for data persistence.

## Entity Relationship Diagram

```
+-------------+        +-------------+        +-------------+        +-------------+
| Department  |        |  Employee   |        |  Insurance  |        |   Project   |
+-------------+        +-------------+        +-------------+        +-------------+
| id (PK)     |<---+   | empId (PK)  |   +--->| insId (PK)  |        | projectId   |
| depName     |    |   | name        |   |    | years       |        | name        |
| established |    |   | age         |   |    | employee    |        | employees   |
| employees   |----+   | salary      |   |    +-------------+        +-------------+
+-------------+        | department  |   |                                ^
                       | projects    |---+----------------------------+   |
                       | insurance   |---+                            |   |
                       +-------------+                                +---+
```

## Entity Relationships

- **Department to Employee**: One-to-Many (One department can have many employees)
- **Employee to Project**: Many-to-Many (Employees can work on multiple projects and projects can have multiple employees)
- **Employee to Insurance**: One-to-One (Each employee can have one insurance policy)

## Project Structure

```
com.vau.app.day6
├── model/
│   ├── Department.java
│   ├── Employee.java
│   ├── Insurance.java
│   └── Project.java
```

## Database Configuration

The application is configured to use MySQL with the following properties:

```properties
spring.application.name=AppWithDB
spring.datasource.url=jdbc:mysql://localhost:3306/EmployeeDB
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
```
## MYSQL Outputs
```sql
MariaDB [(none)]> create database EmployeeDB;
Query OK, 1 row affected (0.002 sec)
MariaDB [(none)]> USE EmployeeDB;
Database changed
MariaDB [EmployeeDB]> SHOW TABLES;
+----------------------+
| Tables_in_employeedb |
+----------------------+
| department           |
| employee             |
| insurance            |
| project              |
| project_employees    |
+----------------------+
5 rows in set (0.003 sec)

MariaDB [EmployeeDB]> DESC department;
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| established | date         | YES  |     | NULL    |       |
| dep_id      | varchar(255) | NO   | PRI | NULL    |       |
| dep_name    | varchar(255) | NO   |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
3 rows in set (0.021 sec)

MariaDB [EmployeeDB]> DESC employee;
+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| age               | int(11)      | NO   |     | NULL    |       |
| salary            | double       | NO   |     | NULL    |       |
| department_dep_id | varchar(255) | YES  | MUL | NULL    |       |
| emp_id            | varchar(255) | NO   | PRI | NULL    |       |
| name              | varchar(255) | YES  |     | NULL    |       |
+-------------------+--------------+------+-----+---------+-------+
5 rows in set (0.006 sec)

MariaDB [EmployeeDB]> DESC insurance;
+-----------------+--------------+------+-----+---------+-------+
| Field           | Type         | Null | Key | Default | Extra |
+-----------------+--------------+------+-----+---------+-------+
| years           | int(11)      | NO   |     | NULL    |       |
| employee_emp_id | varchar(255) | YES  | UNI | NULL    |       |
| insurance_id    | varchar(255) | NO   | PRI | NULL    |       |
+-----------------+--------------+------+-----+---------+-------+
3 rows in set (0.006 sec)

MariaDB [EmployeeDB]> DESC project;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| project_id   | varchar(255) | NO   | PRI | NULL    |       |
| project_name | varchar(255) | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
2 rows in set (0.005 sec)

MariaDB [EmployeeDB]> DESC project_employees;
+---------------------+--------------+------+-----+---------+-------+
| Field               | Type         | Null | Key | Default | Extra |
+---------------------+--------------+------+-----+---------+-------+
| employees_emp_id    | varchar(255) | NO   | MUL | NULL    |       |
| projects_project_id | varchar(255) | NO   | MUL | NULL    |       |
+---------------------+--------------+------+-----+---------+-------+
2 rows in set (0.006 sec)
```
## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Java 17 (or the version you're using)
- Maven/Gradle (depending on your build tool)