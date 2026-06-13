# 📘 Spring Security Demo (Basic CRUD + Authentication)

## 🔥 Project Overview

This is a **basic CRUD Spring Boot project** integrated with **Spring Security**.

It demonstrates:

* User management (Create, Read, Update, Delete)
* Authentication using:

  * **HTTP Basic Auth**
  * **Form Login**
* Credentials (username & password) are stored in the **database** and utilized by UserDetailsService
* Role-based structure using **Enum (ADMIN / USER)**

---

## 🔐 Authentication

This project uses **Spring Security** to authenticate users.

### Supported Methods:

* Basic Authentication
* Form Login

### How it works:

* User credentials are fetched from the database
* Passwords are encoded using BCrypt
* Spring Security validates login using encoded passwords

---

## 🔑 Password Encryption

We use **BCryptPasswordEncoder** for password hashing.

### Why BCrypt?

* Passwords are never stored as plain text
* Uses one-way hashing
* Automatically adds salt
* Secure against common attacks

```java
passwordEncoder.encode(user.getPassword());
```

---

## 🧱 Tech Stack

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* MySQL (or any RDBMS)

---

## 📦 Project Structure

```
com.project
 ├── controller
 ├── service
 ├── repository
 ├── model (Entity + Enum)
 ├── config (Security Configuration)
```

---

## 🧠 Key Learning Concepts

* Authentication vs Authorization
* Using Enum for roles
* Secure password storage using BCrypt
* Importance of DTOs in API design
* JPA save() behavior (insert vs update)

---

# 🚨 Bugs Encountered & Lessons Learned

---

## ❌ Bug 1: User Data Overwritten

### Problem:

```
{
  "id": 1,
  "username": "newUser"
}
```

Existing user got overwritten.

### Root Cause:

* Entity was directly used in @RequestBody
* JPA save() updates if ID exists

### Solution:

* Introduced DTO
* Removed ID from request

### Lesson:

Never expose entity directly in APIs.

---

## ❌ Bug 2: 500 Error When Sending New ID

### Problem:

```
{
  "id": 999,
  "username": "test"
}
```

Result: 500 Internal Server Error

### Root Cause:

* ID is auto-generated
* Database rejects manual ID insertion

### Solution:

* Do not allow ID in request
* Use DTO or read-only ID

### Lesson:

ID must always be controlled by the server.

---

## ❌ Bug 3: Enum Mapping Error

### Problem:

@Enumerated used on String field caused application failure.

### Root Cause:

```
private String role;
```

### Solution:

```
private Role role;
```

### Lesson:

@Enumerated works only with enum types.

---

## ❌ Bug 4: Password Stored as Plain Text

### Problem:

Passwords were stored directly.

### Solution:

```
passwordEncoder.encode(user.getPassword());
```

### Lesson:

Never store plain text passwords.

---

## ❌ Bug 5: ResponseEntity.created() Error

### Problem:

```
ResponseEntity.created().body(obj);
```

### Root Cause:

created() requires a URI.

### Solution:

```
ResponseEntity.created(URI.create("/users/" + user.getId()))
        .body(user);
```

### Lesson:

Follow proper REST response standards.

---

# 🏆 Final Takeaways

* Always use DTOs
* Never trust client input
* Secure passwords properly
* Understand JPA behavior
* Follow REST API standards

---

## 🚀 Future Improvements

* JWT Authentication
* Role-based Authorization
* Global Exception Handling
* Validation annotations
* Swagger documentation

---

## ✍️ Author

* GitHub: IsraelRufus-RJ
