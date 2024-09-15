<h1 align="center" id="title">UrbanCart</h1>




<img width="1478" alt="image" src="https://github.com/user-attachments/assets/062396d0-a3ed-462a-aca9-dbd1fa66bfba">

<p id="description">Production Grade e-Commerce App built using Java Spring Boot framework JPA Hibernate.</p>

## Overview of UrbanCart App

<img alt="Docker Automated build" src="https://img.shields.io/docker/automated/batrahub/batra-ecom">  <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/hb99960/UrbanCart"> <img alt="Docker Pulls" src="https://img.shields.io/docker/pulls/batrahub/batra-ecom">

## Content
Tech Stack

Spring Dependencies

Modules

Features

Swagger API Documentation

Installation

Endpoints


## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Spring Dependencies

Get these Spring dependency from Spring Intializr website
* spring-boot-starter-web
* spring-boot-starter-data-jpa
* h2
* lombok (Turn on the Annotations in the Settings > Compiler > Annotations)
* spring-boot-starter-validation
* Model Mapper
 

## Modules

* Category Module
* Product Module
* Order Module
* Cart Module
* Auth Module

## Features

## Swagger API Documentation

🎉 We Are Live! 🎉

Our application is now up and running. To explore our API endpoints, follow these steps:

Visit the Swagger UI: https://batra-ecom-1-0.onrender.com/swagger-ui/index.html

Login Credentials:

Username: `user1`

Password: `password1`

Once logged in, you can navigate through the various API endpoints and see how they are documented. Enjoy exploring!

If you encounter any issues or have questions, feel free to reach out.

Happy exploring! 🚀

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
* `PUT /public/categories/{categoryId}` : Delete a category

### Product Module
* `POST /categories/{categoryId}/product` : Add Product
* `GET /public/products` : Get All Products
* `PUT /admin/products/{productId}` : Update Product
* `GET /public/categories/{categoryId}/products` : Get Products by Category
* `GET /public/products/keyword/{keyword}` : Get Prodcuts by Keyword (Search functionality)
* `DELETE /admin/products/{productId}` : Delete Product
* `PUT /products/{productId}/image` : Upload Product Image

### Auth Module
* module is ready, endpoints will be documented soon. Meanwhile, checkout swagger-UI to check REST APIs.

### Cart Module
* module is ready, endpoints will be documented soon. Meanwhile, checkout swagger-UI to check REST APIs.

### Address Module
* module is ready, endpoints will be documented soon. Meanwhile, checkout swagger-UI to check REST APIs.

### Spring Security

### Upcoming Modules
* Order Module
* Payment Module
