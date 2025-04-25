# IT3232 E-Commerce Practicals - Day 7 - 2025-04-25(Exercise)

## Project Overview

This project is a Spring Boot application for managing workshops, sessions, presenters, and students (both undergraduate and postgraduate) using JPA for data persistence.

## Entity Relationship Diagram

```
+---------------+        +-----------------+         +----------------+
| Workshop      |        | Session         |         | Person         |
+---------------+        +-----------------+         +----------------+
| id (PK)       |<------o| id (PK)         |         | name           |
| name          |        | name            |         | email          |
| description   |        | description     |         | gender         |
| start_date    |        | date            |         | phone          |
| end_date      |        | time            |         +----------------+
| sessions      |        | workshop        |                ^
+---------------+        | presenters      |                |
                         | undergrads      |                |
                         | postgrads       |                |
                         +-----------------+                |
                                |                    +------+
                                |                    |
                                |    +---------------+
                                |    |               |
                                V    V               V
+-----------------+   +------------------+   +-----------------+
| UnderGraduate   |   | PostGraduate     |   | Presenter       |
+-----------------+   +------------------+   +-----------------+
| id (PK)         |   | id (PK)          |   | id (PK)         |
| degree          |   | institute        |   | affiliation     |
| university      |   | research_interest|   | country         |
| sessions        |<->| second_degree    |   | job_title       |
+-----------------+   | sessions         |<->| sessions        |
                      +------------------+   +-----------------+
```

## Entity Relationships

- **Workshop to Session**: One-to-Many (One workshop can have many sessions)
- **Session to UnderGraduate**: Many-to-Many (Sessions can have multiple undergraduates and undergraduates can attend multiple sessions)
- **Session to PostGraduate**: Many-to-Many (Sessions can have multiple postgraduates and postgraduates can attend multiple sessions)
- **Session to Presenter**: Many-to-Many (Sessions can have multiple presenters and presenters can participate in multiple sessions)
- **Person**: Base class for UnderGraduate, PostGraduate, and Presenter (using inheritance)

## Project Structure

```
com.vau.app.model.Exercise/
├── Person.java
├── Workshop.java
├── Session.java
├── UnderGraduate.java
├── PostGraduate.java
└── Presenter.java
```

## Database Configuration

The application is configured to use MySQL with the following properties:

```properties
spring.application.name=AppWithDB
spring.datasource.url=jdbc:mysql://localhost:3306/UniEventsDB
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
```

## MYSQL Output

```sql
MariaDB [UniEventsDB]> show tables;
+-------------------------+
| Tables_in_unieventsdb   |
+-------------------------+
| post_graduate           |
| post_graduate_sessions  |
| presenter               |
| presenter_sessions      |
| session                 |
| under_graduate          |
| under_graduate_sessions |
| workshop                |
+-------------------------+
8 rows in set (0.001 sec)
MariaDB [UniEventsDB]> DESC post_graduate;
+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| phone             | int(11)      | NO   |     | NULL    |       |
| email             | varchar(255) | YES  |     | NULL    |       |
| gender            | varchar(255) | YES  |     | NULL    |       |
| institute         | varchar(255) | YES  |     | NULL    |       |
| name              | varchar(255) | YES  |     | NULL    |       |
| pg_id             | varchar(255) | NO   | PRI | NULL    |       |
| research_interest | varchar(255) | YES  |     | NULL    |       |
| second_degree     | varchar(255) | YES  |     | NULL    |       |
+-------------------+--------------+------+-----+---------+-------+
8 rows in set (0.034 sec)

MariaDB [UniEventsDB]> DESC post_graduate_sessions;
+-----------------+--------------+------+-----+---------+-------+
| Field           | Type         | Null | Key | Default | Extra |
+-----------------+--------------+------+-----+---------+-------+
| postgraduate_id | varchar(255) | NO   | MUL | NULL    |       |
| session_id      | varchar(255) | NO   | MUL | NULL    |       |
+-----------------+--------------+------+-----+---------+-------+
2 rows in set (0.026 sec)

MariaDB [UniEventsDB]> DESC presenter;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| phone        | int(11)      | NO   |     | NULL    |       |
| affiliation  | varchar(255) | YES  |     | NULL    |       |
| country      | varchar(255) | YES  |     | NULL    |       |
| email        | varchar(255) | YES  |     | NULL    |       |
| gender       | varchar(255) | YES  |     | NULL    |       |
| job_title    | varchar(255) | YES  |     | NULL    |       |
| name         | varchar(255) | YES  |     | NULL    |       |
| presenter_id | varchar(255) | NO   | PRI | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
8 rows in set (0.009 sec)

MariaDB [UniEventsDB]> DESC presenter_sessions;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| presenter_id | varchar(255) | NO   | MUL | NULL    |       |
| session_id   | varchar(255) | NO   | MUL | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
2 rows in set (0.010 sec)

MariaDB [UniEventsDB]> DESC session;
+----------------------+--------------+------+-----+---------+-------+
| Field                | Type         | Null | Key | Default | Extra |
+----------------------+--------------+------+-----+---------+-------+
| date                 | date         | YES  |     | NULL    |       |
| time                 | time(6)      | YES  |     | NULL    |       |
| workshop_workshop_id | int(11)      | YES  | MUL | NULL    |       |
| description          | varchar(255) | YES  |     | NULL    |       |
| name                 | varchar(255) | YES  |     | NULL    |       |
| session_id           | varchar(255) | NO   | PRI | NULL    |       |
+----------------------+--------------+------+-----+---------+-------+
6 rows in set (0.007 sec)

MariaDB [UniEventsDB]> DESC under_graduate;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| phone      | int(11)      | NO   |     | NULL    |       |
| degree     | varchar(255) | YES  |     | NULL    |       |
| email      | varchar(255) | YES  |     | NULL    |       |
| gender     | varchar(255) | YES  |     | NULL    |       |
| name       | varchar(255) | YES  |     | NULL    |       |
| ug_id      | varchar(255) | NO   | PRI | NULL    |       |
| university | varchar(255) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+
7 rows in set (0.009 sec)

MariaDB [UniEventsDB]> DESC under_graduate_sessions;
+------------------+--------------+------+-----+---------+-------+
| Field            | Type         | Null | Key | Default | Extra |
+------------------+--------------+------+-----+---------+-------+
| session_id       | varchar(255) | NO   | MUL | NULL    |       |
| undergraduate_id | varchar(255) | NO   | MUL | NULL    |       |
+------------------+--------------+------+-----+---------+-------+
2 rows in set (0.007 sec)

MariaDB [UniEventsDB]> DESC workshop;
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| end_date    | date         | YES  |     | NULL    |       |
| start_date  | date         | YES  |     | NULL    |       |
| workshop_id | int(11)      | NO   | PRI | NULL    |       |
| description | varchar(255) | YES  |     | NULL    |       |
| name        | varchar(255) | YES  |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
5 rows in set (0.022 sec)

```
## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Java 17
- Maven