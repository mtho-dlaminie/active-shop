**Active-Shop Api version 1** 
REST API to purchase momentum active shop products using Active Days points. 

**Requirements**

For building and running the application you need:

- At least Java 8
- Maven 3

**NB**
Eclicpe/STS will also required Lombok plugin installation https://projectlombok.org/download.
IntelliJ Lombok plugin is required to build project.


**Build**

`mvn clean install`

creates a jar file in ~/active-shop/target/active-shop-0.0.1-SNAPSHOT.jar


**Run**

`mvn spring-boot:run`


**Swagger UI**

http://localhost:8080/active-shop-api/swagger-ui.html

**Swagger docs**

`http://localhost:8080/active-shop-api/v2/api-docs`

**REST API**

Request:

`GET /v1/products`

`curl -X GET "http://localhost:8080/active-shop-api/v1/products" -H "accept: */*"`

Response:

`[
    {
        "name": "Burger",
        "code": 1,
        "points": 40
    },
    {
        "name": "Chicken fillet",
        "code": 2,
        "points": 40
    },
    {
        "name": "Sippy Sherbet",
        "code": 3,
        "points": 20
    },
    {
        "name": "Sparkling Water",
        "code": 4,
        "points": 5
    }
]`
 
 Request:
 
 `GET v1/1/purchase-product`
 
 `curl -X POST "http://localhost:8080/active-shop-api/v1/1/purchase-product" -H "accept: */*" -H "Content-Type: application/json" -d "[ { \"name\": \"Burger\", \"code\": 1, \"points\": 40 }, { \"name\": \"Chicken fillet\", \"code\": 2, \"points\": 40 }]"`
 
 Response:
 
 `[
    {
        "name": "Burger",
        "code": 1,
        "points": 40
    },
    {
        "name": "Chicken fillet",
        "code": 2,
        "points": 40
    }
]`
  
  **Dependencies**
  
  Lombok
  
  `        <dependency>
               <groupId>org.projectlombok</groupId>
               <artifactId>lombok</artifactId>
               <optional>true</optional>
           </dependency>
           `



**Monitoring**

Prometheus

`http://localhost:8080/active-shop-api/actuator`
   
   
           
           
