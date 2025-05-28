# IT3232 E-Commerce Practicals - Day 10 - 2025-05-23

## 1. Error Response Model

Created a standardized `ErrorResponse` class to provide consistent error information across all API endpoints.

### Key Features:
- **statusCode**: HTTP status code for the error
- **errorMessage**: Descriptive error message
- **Default constructor**: For framework instantiation
- **Parameterized constructor**: For quick error response creation

## 2. Global Exception Handler

Implemented `GenericExceptionHandler` using `@RestControllerAdvice` to handle exceptions across the entire application:

### Handled Exception Types:

#### EntityNotFoundException
- **HTTP Status**: 404 Not Found
- **Use Case**: When requested entities don't exist in the database
- **Example Response**:
```json
{
    "statusCode": 404,
    "errorMessage": "Department Not Found"
}
```

#### DuplicateKeyException
- **HTTP Status**: 400 Bad Request  
- **Use Case**: When attempting to insert duplicate records
- **Example Response**:
```json
{
    "statusCode": 400,
    "errorMessage": "Department already Exists"
}
```

#### Generic Exception
- **HTTP Status**: 500 Internal Server Error
- **Use Case**: Catches all other unhandled exceptions
- **Purpose**: Prevents application crashes and provides meaningful error responses

## 3. Spring Boot Annotations

### @RestControllerAdvice
This annotation combines `@ControllerAdvice` and `@ResponseBody`. It allows the class to:
- Handle exceptions globally across all controllers
- Automatically serialize response objects to JSON
- Provide centralized exception handling logic
- Reduce code duplication across multiple controllers

### @ExceptionHandler
Used to define methods that handle specific exception types:
- Maps exception types to handler methods
- Allows custom error response creation
- Enables different handling strategies for different exceptions
- Supports exception hierarchy (parent exceptions catch child exceptions)

## 4. Exception Handling Flow

1. **Controller Method Execution**: API endpoint method executes
2. **Exception Occurrence**: Database operation or business logic throws exception
3. **Exception Interception**: `@RestControllerAdvice` intercepts the exception
4. **Handler Method Selection**: Appropriate `@ExceptionHandler` method is called
5. **Error Response Creation**: `ErrorResponse` object is created with status code and message
6. **HTTP Response**: Structured error response is returned to client

## 5. API Testing Examples

### Duplicate Department Error (POST /dept/)

![Output](./Duplicate%20Key.png)

### Department Not Found (GET /dept/001)

![Output](./Not%20found.png)

## 6. Benefits of Exception Handling Implementation

### For Developers:
- **Centralized Error Management**: All exception handling logic in one place
- **Consistent Error Format**: Standardized error response structure
- **Reduced Code Duplication**: No need to handle exceptions in each controller
- **Better Debugging**: Clear error messages and status codes

### For API Consumers:
- **Predictable Error Format**: Always receive structured error responses
- **Meaningful HTTP Status Codes**: Proper status codes for different error types
- **Clear Error Messages**: Descriptive messages for troubleshooting
- **No Application Crashes**: Graceful error handling prevents system failures