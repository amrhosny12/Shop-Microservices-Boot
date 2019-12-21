# Shop Application Microservices built on Spring Boot 2.1.11 SNAPSHOT

## List Of Services & Framworks Used
- Inventory Service - Application microservice utilizing JPA and MySQL for data persistent 
- Store Service - Application microservice consuming Inventory Service and will be exposed to client applications
- Config Service - A Configuration Service consuming a configuration server and consumed by application's microservices for QA/DEV configuration, configurations are applied from a centrialized git repo.
- Shop Eureka Naming Server - A Eureka Naming Server for service discovery and Ribbon integration for load balancing
- Shop Zuul API Gateway Server - API Gateway server used for API authentication using OAUTH and logging using Zipkin and RabbitMQ


## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Config Service | 8080, 8081, ... |
| Shop Config Server | 8888 |
|  |  |
| Inventory Service | 8000, 8001, 8002, ..  |
| Store Service | 8100, 8101, 8102, ... |
| Shop Eureka Naming Server | 8761 |
| Shop Zuul API Gateway Server | 8765 |
