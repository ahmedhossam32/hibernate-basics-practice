# 📚 Hibernate Basics Practice

This project demonstrates **Hibernate ORM (Object-Relational Mapping)** concepts using a practical Java application connected to a PostgreSQL database.  
It includes implementation of basic CRUD operations and fundamental **JPA annotations** for entity relationships.

---

## ✅ What I Learned

Through this exercise, I practiced and understood the following Hibernate and JPA concepts:

### 🔹 Hibernate Core Concepts
- What is Hibernate and why it's used
- How Hibernate maps Java classes to database tables (ORM)
- Hibernate configuration using `hibernate.cfg.xml`
- Maven setup for Hibernate and PostgreSQL dependencies

### 🔹 JPA Annotations
- `@Entity`, `@Id`, `@Table`, `@Column` – for basic entity setup
- `@OneToOne` – one-to-one relationships
- `@ManyToMany` – many-to-many relationships
- `@JoinColumn`, `@JoinTable` – to customize foreign keys and join tables

### 🔹 Entity Relationships
- One-to-One: Each `Profile` is associated with exactly one `Student`
- Many-to-Many: Multiple `Instructors` can teach multiple `Courses`

### 🔹 Session Operations
- `Session.persist()` to save entities
- `Session.get()` for immediate fetching
- `Session.getReference()` for lazy loading (proxy objects)
- Transaction handling using `Transaction` object

---

## 🧱 Project Structure

```plaintext
HibernatePractice/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── hibernate/
│                   ├── Main.java
│                   ├── Student.java
│                   ├── Profile.java
│                   ├── Instructor.java
│                   └── Course.java
├── resources/
│   └── hibernate.cfg.xml
└── pom.xml
