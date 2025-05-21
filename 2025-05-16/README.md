# IT3232 E-Commerce Practicals - Day 8 - 2025-05-16

## Get methods

### Get All Departments

Route : GET /dept/

**Output:**

``` JSON
[
    {
        "id": "D001",
        "depName": "Computer Science",
        "established": "2010-03-01"
    },
    {
        "id": "D002",
        "depName": "Mathematics",
        "established": "2005-06-15"
    },
    {
        "id": "D003",
        "depName": "Physics",
        "established": "2000-01-10"
    },
    {
        "id": "D004",
        "depName": "Chemistry",
        "established": "2012-09-20"
    },
    {
        "id": "D005",
        "depName": "Biology",
        "established": "2018-11-25"
    }
]
```

### Get All Employees

Route : GET /emp/

``` JSON
[
    {
        "name": "Alice",
        "age": "28",
        "gender": "Female",
        "empId": "E001",
        "salary": 60000.0,
        "insurance": {
            "insId": "I001",
            "years": 2
        }
    },
    {
        "name": "Bob",
        "age": "35",
        "gender": "Male",
        "empId": "E002",
        "salary": 72000.0,
        "insurance": {
            "insId": "I002",
            "years": 3
        }
    },
    {
        "name": "Charlie",
        "age": "30",
        "gender": "Male",
        "empId": "E003",
        "salary": 68000.0,
        "insurance": {
            "insId": "I003",
            "years": 1
        }
    },
    {
        "name": "Diana",
        "age": "27",
        "gender": "Female",
        "empId": "E004",
        "salary": 64000.0,
        "insurance": {
            "insId": "I004",
            "years": 4
        }
    },
    {
        "name": "Ethan",
        "age": "32",
        "gender": "Male",
        "empId": "E005",
        "salary": 70000.0,
        "insurance": {
            "insId": "I005",
            "years": 2
        }
    }
]
```