# Spring Boot JDBC Application

A simple Spring Boot application demonstrating JDBC operations with PostgreSQL database using JdbcTemplate. The application manages student records with basic CRUD operations.

## Overview

This application showcases the fundamentals of Spring Boot data access using JDBC. It demonstrates how to:
- Run PostgreSQL in a Docker container
- Connect to a PostgreSQL database using Spring Boot
- Use JdbcTemplate for database operations
- Implement a simple repository pattern
- Initialize database schema and data automatically

## What is JdbcTemplate?

**JdbcTemplate** is Spring's central class for JDBC operations. It provides:

- **Simplified JDBC**: Eliminates boilerplate code for connection management, statement creation, and exception handling
- **Resource Management**: Automatically handles opening/closing connections and statements
- **Exception Translation**: Converts checked SQL exceptions to Spring's unchecked DataAccessException hierarchy
- **Parameter Binding**: Safe parameter binding to prevent SQL injection
- **Result Set Mapping**: Easy mapping of query results to Java objects

## Run the application locally

### Step 1: Start PostgreSQL with Docker Compose
```bash
# Start PostgreSQL container
docker compose up
```

### Step 2: Verify Container is Running
```bash
# Check running containers and get the container name
docker compose ps
```

### Step 3: Create Database (if not exists)
```bash
# Connect to PostgreSQL container (using the container name from step 2)
docker exec -it postgres-spring-boot-jdbc psql -U rmowlana

# Create database
CREATE DATABASE springbootjdbc;

# Exit PostgreSQL
\q
```

### Step 4: Verify Database Connection
```bash
# Connect to the created database
docker exec -it postgres-spring-boot-jdbc psql -U rmowlana -d springbootjdbc

# You should now be connected to the springbootjdbc database
# Exit when done
\q
```

### Step 5: Run the Spring Boot Application
```bash
# Run the application using Maven
mvn spring-boot:run
```

**Note**: Always ensure PostgreSQL is running before starting the Spring Boot application. The application will automatically create the required tables and insert sample data on startup.