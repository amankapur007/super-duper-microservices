
# Microservice with Spring Boot and Cloud

This project is a dummy project for learning purpose. This project has been referred from [Microservices with Spring Boot and Spring Cloud - Second Edition](https://www.oreilly.com/library/view/microservices-with-spring/9781801072977/) By Magnus Larsson.

I would recommend this book, if someone wants to master the microservices.

#
1. Project structure 
---
2. Creating the services

    Will be using below dependencies :
    - Spring Boot
    - Spring WebFlux
    - springdoc-openapi
    - Spring Data
    - Spring Cloud Stream
    - Docker
    
    Services :

    We have 3 core service and 1 aggregate service that will combine the data from other 3 core services

    ```
    product-composite-service [aggregate] → product-service [core]

    product-composite-service [aggregate] → recommendation-service [core]
    
    product-composite-service [aggregate] → review-service [core]
    ```

    > api - this project will act as an common interface , where all models, exceptions and api's will be there 


    Models for 3 core services : 

    ```
    API Core Models

    //product-service
    > Product ID
    > Name
    > Weight
    > serviceAddress [we know ipadreess/host of the service] 

    //recommendation-service
    > Product ID
    > Recommendation ID
    > Author
    > Rate
    > Content
    > serviceAddress [we know ipadreess/host of the service]
    
    //review-service 
    > Product ID
    > Review ID
    > Author
    > Subject
    > Content
    > serviceAddress [we know ipadreess/host of the service]
    ```

    Model for agrregate service
    ```
    API Composite Models

    //product-composite-service
    > Product ID
    > Name
    > Weight
    > reviews [List of review]
    > recommendations [List of recommendation]
    > serviceAddress [Service Model with compositeAdress, productAddress, reviewAddress, recommendationAddress as fields] 
    ```

    API Exception : 
    ```
    InvalidInputException , NotFoundException
    ```

    API's : 
    ```
    //api->composite->product
    product-composite/{productId} : GET
    //api->core->product
    product/{productId} : GET
    //api->core->recommendation
    recommendation?productId={productId} : GET
    //api->core->review
    review?productId={productId} : GET

    //All the services Impl will implement these api's by implements ProductService | RecommendationService | ReviewService
    ```

    > util - This product will act as an utility class, contains common classes which is used across application like Glibal Exceptions , service address logic

    Util Models: 
    ```
    //HttpErrorInfo
    > path
    > httpStatus
    > message
    > timestamp
    ```

    Utility Class
    ```
    ServiceUtil
    ```

    Util Exception:
    ```
    GlobalControllerExceptionHandler
    ```

    > Core Service :
    ```
    //product-service
    ProductServiceImpl implements ProductService
    //recommendation-service
    RecommendationServiceImpl implements RecommendationService
    //review-servuce
    ReviewServiceImpl implements ReviewService
    ```

    >Aggregate/Composote Service:
    ```
    Refer the code
    ```

---
2.1 - Services Test Cases 

---
Commands to be used
```
- Build project
./gradlew build

- Run services
java -jar microservices/product-composite-service/build/libs/*.jar &
java -jar microservices/product-service/build/libs/*.jar &
java -jar microservices/recommendation-service/build/libs/*.jar &
java -jar microservices/review-service/build/libs/*.jar &

- Stop 
kill $(jobs -p)
```