# IT3232 E-Commerce Practicals - Day 7 - 2025-04-25  

# [Continuation from last week](/2025-04-11/README.md)

Building on last week's Employee Management System Spring Boot JPA project, the following updates have been implemented:

## 1. Entity Inheritance Structure
- Created a new `Person` base class as a mapped superclass
- Refactored `Employee` to extend `Person` to inherit common attributes
- Moved name, age, and gender fields to the `Person` class

## 2. Updated Entity Field Types
- Changed the `age` field in `Person` from integer to String

## 3. Added New Entity Fields
- Added `gender` field to `Person` class
- Added `totalCost` field to `Project` entity

## 4. Enhanced JPA Relationships
- Improved the Many-to-Many relationship between `Employee` and `Project` with:
  - Custom join table name: "project_assignments"
  - Custom column names: "empid" and "pro_id"
  - Full `@JoinTable` and `@JoinColumn` annotations

## JPA Annotations Explained

### @MappedSuperclass
This annotation is used on the `Person` class to indicate that it's a parent class whose properties should be inherited by child entities (like `Employee`), but the parent class itself is not an entity and doesn't have its own database table. This allows us to reuse common fields and behavior across multiple entity classes without creating a table for the parent class.

### @JoinTable
Used in the `Project` class to customize the join table for the Many-to-Many relationship with `Employee`. It allows us to:
- Specify a custom name for the join table ("project_assignments") 
- Define how the foreign keys are mapped across tables
- Control the database schema for complex relationships

### @JoinColumn
Used within the `@JoinTable` annotation to specify custom names for the foreign key columns in the join table. In our case:
- "empid" refers to the Employee entity
- "pro_id" refers to the Project entity
- This gives us more control over database column naming conventions

## MYSQL Output
```sql
MariaDB [EmployeeDB]> show tables;
+----------------------+
| Tables_in_employeedb |
+----------------------+
| department           |
| employee             |
| insurance            |
| project              |
| project_assignments  |
+----------------------+
6 rows in set (0.049 sec)

MariaDB [EmployeeDB]> DESC project_assignments;
+--------+--------------+------+-----+---------+-------+
| Field  | Type         | Null | Key | Default | Extra |
+--------+--------------+------+-----+---------+-------+
| empid  | varchar(255) | NO   | MUL | NULL    |       |
| pro_id | varchar(255) | NO   | MUL | NULL    |       |
+--------+--------------+------+-----+---------+-------+
2 rows in set (0.006 sec)
```
## Project Structure

The updated project maintains the same overall structure but with enhanced entity models:

```
com.vau.app/
├── model/
│   ├── Person.java (NEW)
│   ├── Department.java
│   ├── Employee.java (UPDATED)
│   ├── Insurance.java
│   └── Project.java (UPDATED)
```

# [Exercise](/2025-04-25/Exercise/README.md)