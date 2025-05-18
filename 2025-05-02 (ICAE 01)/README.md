# IT3232 E-Commerce Practicals - ICAE 01 - Smart Canteen Management System

## Project Overview

### Instruction: 

University Vavuniya wants to build a Smart Canteen Management System using Spring Boot.The system must manage multiple canteens, each located in different parts of the campus. The university maintains a list of foods which can only be sold at the canteen. Each food item has a name, price, and weight.  Each canteen offers a daily menu that includes several food items, where a single food item can appear on menus in different canteens on different days. The university has students and employees, both of whom have common details such as ID, name, age, and gender. Employees have additional attributes like their job position, and students include their academic degree. Employees can be associated with multiple canteens, while each student can place food orders. Every food order can include multiple order lines, and each line refers to a specific food item from the daily menu, along with the quantity. A student may place multiple orders over time, and each order must store the date it was placed.

The following requirements are given to create proper models, implement the 
necessary relationships between the entity classes based on the provided scenario, 
and migrate them as a database using proper ORM techniques. 

## Entity Relationship Diagram

```
+---------------+          +---------------+          +---------------+
| Canteen       |          | DailyMenu     |          | Food          |
+---------------+          +---------------+          +---------------+
| id (PK)       |<---------| id (PK)       |          | id (PK)       |
| name          |          | date          |          | name          |
| location      |          | canteen       |--------->| price         |
| description   |          | food_items    |<---------| weight        |
| employees     |          +---------------+          +---------------+
| daily_menus   |
+---------------+
       ^
       |
       |                      +----------------+
       |                      | Person         |
       |                      +----------------+
       |                      | id (PK)        |
       |                      | name           |
       |                      | age            |
       |                      | gender         |
       |                      +----------------+
       |                             ^
       |                             |
       |                    +--------+--------+
       |                    |                 |
       |                    V                 V
+---------------+    +---------------+    +---------------+
| Employee      |    | Student       |    | FoodOrder     |
+---------------+    +---------------+    +---------------+
| id (PK)       |    | id (PK)       |<---| id (PK)       |
| job_position  |    | degree        |    | order_date    |
| canteens      |<-->|               |    | student       |
+---------------+    | orders        |--->| order_lines   |
                     +---------------+    +---------------+
                                                |
                                                |
                                                V
                                          +---------------+
                                          | OrderLine     |
                                          +---------------+
                                          | id (PK)       |
                                          | quantity      |
                                          | food_item     |----> DailyMenu.food_items
                                          | order         |
                                          +---------------+
```

## Entity Relationships

- **Canteen to DailyMenu**: One-to-Many (One canteen can have many daily menus)
- **DailyMenu to Food**: Many-to-Many (Daily menus can have multiple food items and food items can appear on multiple daily menus)
- **Employee to Canteen**: Many-to-Many (Employees can work at multiple canteens and canteens can have multiple employees)
- **Student to FoodOrder**: One-to-Many (One student can place many orders)
- **FoodOrder to OrderLine**: One-to-Many (One order can have many order lines)
- **OrderLine to Food**: Many-to-One (Many order lines can reference one food item)
- **Person**: Base class for Student and Employee (using inheritance)

## Project Structure

```
com.vau.app.model/
├── Person.java
├── Student.java
├── Employee.java
├── Canteen.java
├── Food.java
├── DailyMenu.java
├── FoodOrder.java
└── OrderLine.java
```

## Database Configuration

The application is configured to use MySQL with the following properties:

```properties
spring.application.name=SmartCanteenSystem
spring.datasource.url=jdbc:mysql://localhost:3306/CanteenDB
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
```

## Database Schema 

After implementing the entity classes and running the migration, the database schema shows the following tables:

```sql
MariaDB [AppWithDB]> show tables;
+---------------------+
| Tables_in_appwithdb |
+---------------------+
| canteen             |
| daily_menu          |
| employee            |
| employee_canteen    |
| food                |
| food_order          |
| menu_food           |
| order_line          |
| student             |
+---------------------+
9 rows in set (0.004 sec)

MariaDB [AppWithDB]> desc canteen;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| id       | bigint(20)   | NO   | PRI | NULL    |       |
| location | varchar(255) | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
2 rows in set (0.027 sec)

MariaDB [AppWithDB]> desc daily_menu;
+------------+------------+------+-----+---------+-------+
| Field      | Type       | Null | Key | Default | Extra |
+------------+------------+------+-----+---------+-------+
| date       | date       | YES  |     | NULL    |       |
| canteen_id | bigint(20) | YES  | MUL | NULL    |       |
| id         | bigint(20) | NO   | PRI | NULL    |       |
+------------+------------+------+-----+---------+-------+
3 rows in set (0.005 sec)

MariaDB [AppWithDB]> desc employee;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| age          | int(11)      | NO   |     | NULL    |       |
| id           | bigint(20)   | NO   | PRI | NULL    |       |
| gender       | varchar(255) | YES  |     | NULL    |       |
| job_position | varchar(255) | YES  |     | NULL    |       |
| name         | varchar(255) | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
5 rows in set (0.006 sec)

MariaDB [AppWithDB]> desc employee_canteen;
+-------------+------------+------+-----+---------+-------+
| Field       | Type       | Null | Key | Default | Extra |
+-------------+------------+------+-----+---------+-------+
| canteen_id  | bigint(20) | NO   | MUL | NULL    |       |
| employee_id | bigint(20) | NO   | MUL | NULL    |       |
+-------------+------------+------+-----+---------+-------+
2 rows in set (0.004 sec)

MariaDB [AppWithDB]> desc food;
+--------+--------------+------+-----+---------+-------+
| Field  | Type         | Null | Key | Default | Extra |
+--------+--------------+------+-----+---------+-------+
| price  | double       | NO   |     | NULL    |       |
| weight | double       | NO   |     | NULL    |       |
| id     | bigint(20)   | NO   | PRI | NULL    |       |
| name   | varchar(255) | YES  |     | NULL    |       |
+--------+--------------+------+-----+---------+-------+
4 rows in set (0.006 sec)

MariaDB [AppWithDB]> desc food_order;
+------------+------------+------+-----+---------+-------+
| Field      | Type       | Null | Key | Default | Extra |
+------------+------------+------+-----+---------+-------+
| order_date | date       | YES  |     | NULL    |       |
| id         | bigint(20) | NO   | PRI | NULL    |       |
| student_id | bigint(20) | YES  | MUL | NULL    |       |
+------------+------------+------+-----+---------+-------+
3 rows in set (0.006 sec)

MariaDB [AppWithDB]> desc menu_food;
+---------+------------+------+-----+---------+-------+
| Field   | Type       | Null | Key | Default | Extra |
+---------+------------+------+-----+---------+-------+
| food_id | bigint(20) | NO   | MUL | NULL    |       |
| menu_id | bigint(20) | NO   | MUL | NULL    |       |
+---------+------------+------+-----+---------+-------+
2 rows in set (0.005 sec)

MariaDB [AppWithDB]> desc order_line;
+----------+------------+------+-----+---------+-------+
| Field    | Type       | Null | Key | Default | Extra |
+----------+------------+------+-----+---------+-------+
| quantity | int(11)    | NO   |     | NULL    |       |
| food_id  | bigint(20) | YES  | MUL | NULL    |       |
| id       | bigint(20) | NO   | PRI | NULL    |       |
| order_id | bigint(20) | YES  | MUL | NULL    |       |
+----------+------------+------+-----+---------+-------+
4 rows in set (0.012 sec)

MariaDB [AppWithDB]> desc student;
+--------+--------------+------+-----+---------+-------+
| Field  | Type         | Null | Key | Default | Extra |
+--------+--------------+------+-----+---------+-------+
| age    | int(11)      | NO   |     | NULL    |       |
| id     | bigint(20)   | NO   | PRI | NULL    |       |
| degree | varchar(255) | YES  |     | NULL    |       |
| gender | varchar(255) | YES  |     | NULL    |       |
| name   | varchar(255) | YES  |     | NULL    |       |
+--------+--------------+------+-----+---------+-------+
5 rows in set (0.012 sec)
```

## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Java 17
- Maven