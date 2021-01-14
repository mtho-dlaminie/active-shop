**Active-Shop Api version 1** 
REST API to purchase momentum active shop products using “Active Days” points. 

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

**NB**
IntelliJ Lombok plugin is required to build project.
Eclicpe/STS will also required Lombok plugin installation https://projectlombok.org/download

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
     "name": "Hatlam",
     "code": 1,
     "points": 10
   },
   {
     "name": "Phys Fintone",
     "code": 2,
     "points": 20
   },
   {
     "name": "New-Sing",
     "code": 3,
     "points": 30
   },
   {
     "name": "Biolam",
     "code": 4,
     "points": 40
   },
   {
     "name": "Kanstock",
     "code": 5,
     "points": 50
   }
 ]`
 
 Request:
 
 `GET v1/1/purchase-product`
 
 `curl -X POST "http://localhost:8080/active-shop-api/v1/1/purchase-product" -H "accept: */*" -H "Content-Type: application/json" -d "[ { \"name\": \"Hatlam\", \"code\": 1, \"points\": 10 }, { \"name\": \"Phys Fintone\", \"code\": 2, \"points\": 20 }, { \"name\": \"New-Sing\", \"code\": 3, \"points\": 30 }]"`
 
 Response:
 
 `[
    {
      "name": "Hatlam",
      "code": 1,
      "points": 10
    },
    {
      "name": "Phys Fintone",
      "code": 2,
      "points": 20
    },
    {
      "name": "New-Sing",
      "code": 3,
      "points": 30
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

Prometheus (vanilla config)

`http://localhost:8080/active-shop-api/actuator`
   
   
           
           