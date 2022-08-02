# Titans Assesment
## Spring Boot Application

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/yogisda/titan-assessments/runs/7615822288?check_suite_focus=true)

In the Assessment we created a backend to manage Employee Entity on a Spring Boot Application with Java.

## Technologies and Platform

- Java 8
- Spring Boot
- Maven
- IntelliJ
- Docker
- Azure
- MySQL

## Features

- A CI/CD GitHub Repository based on GitHub Actions
- Spring Boot Backend to manage the Entity Customer with Rest Endpoints
- JPA for Object-Relational Mapping to convert Java Objects to Database Tables
- A MySQL Database to store the Data
- Use of Criteria Queries to Filter on the Entity
- Exposed the Endpoints with Security based on Basic Authentication
- Docker Containers for the Spring Boot and MySQL Database
- Docker-compose.yaml to automatize the deployment of Docker Containers
- A CSV Reader to map a CSV to a Java Object
- Backend Sample on how to Host the Spring Boot Application on Azure Platform
- Use of a MySQL Database in Azure
- Project Structure based on MVC (Model, View, Controller)
- An API Documentation with Swagger UI
- Config Files for multiple environments

## Project Overview

Spring Dependencies

![image alt text](https://i.ibb.co/7vS9b0s/Titan-Spring-Dependecies.png)

Java Classes


![image alt text](https://i.ibb.co/7nx8dfc/Titan-Java-Classes.png)


## Prerequrites

Titan uses a number of Tools:

- [IntellIJ IDEA](https://www.jetbrains.com/de-de/idea/)
- [Maven 3.8.6](https://maven.apache.org/)
- [Java 8 or higher](https://www.java.com/de/)
- [Docker](https://www.docker.com/)
- [Postman](https://www.postman.com/)


[Github Repository](https://github.com/yogisda/titan-assessments)
## Get Started

### Step 1 (Linux)

Install Maven on Linux or (WSL)

```sh
sudo apt install maven
```
### Step 1 (Mac)
Install Brew on Mac
```sh
/bin/bash -c "$(curl -fsSL ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

Install Maven on MacOs
```sh
brew install maven
```
### Step 2 (Both Platforms)
Install the dependencies and devDependencies and start the server.

```sh
mkdir titan-spring
cd titan-spring
git clone https://github.com/yogisda/titan-assessments.git
cd titan-assessments
mvn compile
```
### Step 3 (Choose an Environment)

There are three environments
to choose an environment modify the file application.properties in the resource folder...

The three possible profiles are

```sh
spring.profiles.active=azure
spring.profiles.active=docker
spring.profiles.active=local
```

By choosing one of these active profiles you will either run on Azure, docker or the local computer.

### Step 4 Run the Backend (Local)

Open in IntellIJ on your Laptop


![image alt text](https://i.ibb.co/Dzy9xhP/image002.jpg)

Click on Open and Choose your Project
![image alt text](https://i.ibb.co/tzFN2FY/image001.jpg)

Trust the Project
![image alt text](https://i.ibb.co/wz9PpBN/image009.jpg)

Change Application.properties to Local
```sh
spring.profiles.active=local
```

Open the Terminal and run the following command
```sh
mvn compile
```
After the compile start the Application
If everything compiles fine "Started CloudApplication" will appear
![image alt text](https://i.ibb.co/KKX0k5H/Bildschirmfoto-2022-08-01-um-14-01-53.png)

### Step 5 Run the Backend (Docker)

Change Application.properties to docker
```sh
spring.profiles.active=docker
```

install docker-compose on MacOS

```sh
brew install docker-compose
```

Run Docker command for the containers

```sh
docker-compose up
```

You will see two containers in the Titan Docker Environment
[![docker.png](https://i.postimg.cc/T3DzVGfN/docker.png)](https://postimg.cc/QFjYD2Bc)
### Step 6 Run the Backend (Azure)

##### Prerequisites

Change Application.properties to azure
```sh
spring.profiles.active=azure
```

- Azure Account
- MySQL DB Hosted on Azure
- Change the properties application.properties in the azure profile to link to the new DB

The Documentation has everything you need to set up the enviroment

[Office Azure DOC](https://docs.microsoft.com/de-de/azure/app-service/quickstart-java?tabs=javase&pivots=platform-windows-development-environment-maven)

### Step 7 Testing with Postman Example

[Swagger UI for API Documentation](https://titan-1659264175666.azurewebsites.net/swagger-ui.html)

To access it locally use
- https://localhost:8080/swagger-ui.html

### Step to Step First Example
- Use GET on the Request
- Use the URL https://titan-1659264175666.azurewebsites.net/api/ping
- Use Basic Authentication Credentials
- Click Send
- The Response should be Pong --> (Ping Pong :))

![image alt text](https://i.ibb.co/K50gKNc/Bildschirmfoto-2022-08-01-um-14-21-40.png)

### Step to Step Second Example

- Use GET on the Request
- Use the URL https://titan-1659264175666.azurewebsites.net/api/employees/lastname/Broom
- Use Basic Authentication Credentials
- Click Send
- Here you filter by Employees Lastname named Broom
- The Response should be two Json Objects

![image alt text](https://i.ibb.co/JqrbSyz/Bildschirmfoto-2022-08-01-um-14-27-28.png)


## License


**Free Software, Hell Yeah!**


