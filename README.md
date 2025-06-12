# Spring Boot JDBC Application

A simple Spring Boot application demonstrating JDBC operations with PostgreSQL database using JdbcTemplate. The application manages student records with basic CRUD operations.

## Overview

This application showcases the fundamentals of Spring Boot data access using JDBC. It demonstrates how to:
- Run PostgreSQL in a Docker container
- Connect to a PostgreSQL database using Spring Boot
- Use JdbcTemplate for database operations
- Implement a simple repository pattern
- Initialize database schema and data automatically


## Prerequisites

### Container Runtime (Choose One)

**Option A: Docker Desktop (Recommended)**
- **Docker Desktop** - The most popular containerization platform
- Download from [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- Includes Docker Engine, Docker CLI, and Docker Compose
- **Supported Platforms**: Windows, macOS, Linux
- Verify installation:
  ```bash
  docker --version
  docker compose version
  ```

**Option B: Rancher Desktop (Alternative)**
- **Rancher Desktop** - Open-source alternative to Docker Desktop
- Download from [Rancher Desktop](https://rancherdesktop.io/)
- Provides Docker-compatible container management
- **Supported Platforms**: Windows, macOS, Linux
- **Benefits**: Free, open-source, includes Kubernetes
- After installation, ensure Docker compatibility mode is enabled
- Verify installation:
  ```bash
  docker --version
  docker compose version
  ```

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