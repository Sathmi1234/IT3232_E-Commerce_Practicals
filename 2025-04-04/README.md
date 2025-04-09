# IT3232 E-Commerce Practicals - Day 4 - 2025-04-04

## Project Overview

The project follows a standard Spring Boot application structure with the following key components:

### Models
- `Student.java`: Represents a student entity with attributes like name, age, department, registration number, and GPA.
- `Course.java`: Represents a course entity with attributes like name, code, description, duration, and year.

### Controllers
- `MapController.java`: Handles CRUD operations for student entities.
- `CourseController.java`: Handles CRUD operations for course entities.

## API Endpoints

### Student Management (`/app`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/app/mapstudent/{id}` | Get a student by registration number |
| GET | `/app/mapstudentAll` | Get all students |
| POST | `/app/add` | Add a new student |
| DELETE | `/app/delStu/{reg}` | Delete a student by registration number |
| PUT | `/app/update/{reg}` | Update a student by registration number |

### Course Management (`/appCourse`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/appCourse/coursebyCode/{c}` | Get a course by course code |
| GET | `/appCourse/allCourses` | Get all courses |
| POST | `/appCourse/add` | Add a new course |
| DELETE | `/appCourse/delStu/{c}` | Delete a course by course code |
| PUT | `/appCourse/updateCourse/{cd}` | Update a course by course code |

## Data Storage

The application uses in-memory storage with `HashMap` to store the data:
- Students are stored with registration number as the key
- Courses are stored with course code as the key

## Example Usage & Outputs

### Student API Examples

#### Get All Students
```
GET /app/mapstudentAll
```

**Output:**

![Output](./GetAllStudents.png) 


#### Get Student by Registration Number
```
GET /app/mapstudent/2020ict150
```

**Output:**

![Output](./GetStudentByReg.png) 

#### Add New Student
```
POST /app/add
```

```bash
{
  "name": "Sarah",
  "age": 21,
  "dept": "IT",
  "regNo": "2020ict300",
  "gpa": 3.7
}
```

**Output:**

![Output](./AddStudent.png) 

#### Update Student
```
PUT /app/update/2020ict300
```
```bash
{
  "name": "Sarah Smith",
  "age": 22,
  "dept": "IT",
  "regNo": "2020ict300",
  "gpa": 3.8
}
```

**Output:**

![Output](./UpdateStudent.png) 

#### Delete Student
```
DELETE /app/delStu/2020ict300
```

**Output:**

![Output](./DeleteStudent.png) 

### Course API Examples

#### Get All Courses
```
GET /appCourse/allCourses
```

**Output:**

![Output](./AllCourses.png) 

#### Get Course by Code
```
GET /appCourse/coursebyCode/101
```

**Output:**

![Output](./GetCourseByCode.png) 

#### Add New Course
```
POST /appCourse/add

```
```bash
{
  "name": "Web Development",
  "code": 101,
  "desc": "Introduction to web development",
  "duration": 4.0,
  "year": 2
}
```

**Output:**

![Output](./AddCourse.png) 

#### Delete Course
```
DELETE /appCourse/delCourse/101
```

**Output:**

![Output](./DeleteCourse.png) 

#### Update Course
```
PUT /appCourse/updateCourse/202

```
```bash
{
  "name": "Mobile Development",
  "code": 202,
  "desc": "Introduction to Mobile development",
  "duration": 1.5,
  "year": 4
}
```

**Output:**

![Output](./UpdateCourse.png) 

## Technologies Used
- Spring Boot
- Spring Web
- Java