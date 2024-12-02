# README: Recipe Filtering REST API 

## Overview
In this assignment, you will build a Spring Boot REST API that reads and filters recipes based on dietary preferences. The application ingests recipe data from a `recipe.txt` file, parses it using the Apache Commons CSV library, and stores it in a Java Collection. The API will expose endpoints for filtering recipes based on attributes like vegan, gluten-free, and vegetarian.

## What You Will Learn
1. **File Parsing with Apache Commons CSV**  
   - Learn how to parse CSV files and map data to a POJO (Plain Old Java Object).  

2. **Spring Boot REST API Development**  
   - Create RESTful endpoints using `@RestController` and implement filtering logic.  

3. **Java Collections**  
   - Store and manipulate data using Java Collections.  

4. **Service and Controller Layers**  
   - Structure your application with separation of concerns by using service and controller layers.  

5. **Filtering Logic**  
   - Implement filtering based on specific attributes (e.g., gluten-free, vegan).  

## How to Use This Project
### 1. **Setup Spring Boot**
   - Visit [Spring Initializr](https://start.spring.io/) and create a new Spring Boot project with dependencies:
     - Spring Web
     - Spring Boot DevTools  
   - Import the project into your IDE.

### 2. **Add Apache Commons CSV Dependency**
   - Include the following Maven dependency in your `pom.xml`:
     ```xml
     <dependency>
         <groupId>org.apache.commons</groupId>
         <artifactId>commons-csv</artifactId>
         <version>1.9.0</version>
     </dependency>
     ```

### 3. **Create the Recipe POJO**
   - Define a `Recipe` class with the following fields:
     - `Integer cookingMinutes`
     - `Boolean dairyFree`
     - `Boolean glutenFree`
     - `String instructions`
     - `Double preparationMinutes`
     - `Double pricePerServing`
     - `Integer readyInMinutes`
     - `Integer servings`
     - `Double spoonacularScore`
     - `String title`
     - `Boolean vegan`
     - `Boolean vegetarian`  
   - Add appropriate getters and setters.

### 4. **Create RecipeRepository**
   - Store the list of `Recipe` objects in a Java Collection, such as a `List`.

### 5. **Implement RecipeService**
   - Parse the `recipe.txt` file using Apache Commons CSV and populate the `RecipeRepository`.
   - Implement filtering logic for dietary preferences.

### 6. **Create RecipeController**
   - Expose the following endpoints:
     - `/all-recipes` - Returns the full recipe list.
     - `/gluten-free` - Filters recipes where `glutenFree` is `true`.
     - `/vegan` - Filters recipes where `vegan` is `true`.
     - `/vegan-and-gluten-free` - Filters recipes where both `glutenFree` and `vegan` are `true`.
     - `/vegetarian` - Filters recipes where `vegetarian` is `true`.

### 7. **Run and Test**
   - Start the Spring Boot application and test the endpoints using a tool like Postman or your browser.

## Expected Output
When the API is called, it will return JSON responses with the filtered recipes. Examples:  

- **`GET /all-recipes`**  
  Returns the complete list of recipes.  
- **`GET /vegan`**  
  Returns only recipes where `vegan = true`.  
- **`GET /vegan-and-gluten-free`**  
  Returns recipes where both `vegan = true` and `glutenFree = true`.  

## Skills Gained
- Working with file parsing libraries like Apache Commons CSV.
- Developing RESTful APIs using Spring Boot.
- Applying filtering logic with Java Collections.
- Structuring applications with service, repository, and controller layers.
- Testing API endpoints with real-world data.

## Extensions and Challenges
- Add more filtering options, such as price per serving or preparation time.
- Use a database like H2 or MySQL to store recipes instead of a Collection.
- Build a front-end application to interact with this API.
