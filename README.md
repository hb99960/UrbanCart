# UrbanCart

<h1 align="center" id="title">UrbanCart</h1>

<p align="center"><img src="https://socialify.git.ci/hb99960/UrbanCart/image?language=1&amp;owner=1&amp;name=1&amp;stargazers=1&amp;theme=Light" alt="project-image"></p>

<p id="description">Production Grade e-Commerce App built using Java Spring Boot framework JPA Hibernate.</p>

## Overview of UrbanCart App
<img width="1478" alt="image" src="https://github.com/user-attachments/assets/062396d0-a3ed-462a-aca9-dbd1fa66bfba">

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Modules

* Category Module
* Product Module
* Order Module
* Cart Module
* Auth Module

## Features


## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](src/main/resources/application.properties) file. 
* Update the port number and url as per your local database config.

```
    server.port=8080
    spring.h2.console.enabled=true
    spring.datasource.url = jdbc:h2:mem:test

```


## API Root Endpoint

`https://localhost:8080/api`

## API Module Endpoints

### Category Module
* `POST /public/categories` : Create a new category
* `GET /public/categories` : Get all categories
* `DELETE /admin/categories/{categoryId}` : Update existing category
* `PUT /public/categories/{categoryID}` : Delete a category


