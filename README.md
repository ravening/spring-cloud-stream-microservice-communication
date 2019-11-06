# Event Driven communication between microservices

A Java microservice applicaton to demonstrate the bidirectional communication between microservices using spring cloud stream

## Getting started

### Prerequisites

Below are the softwares that needs to be installed as a dependency

```
Java
Maven
Docker (to build Docker image)
```

## Running the application

1 . Git clone the repo to any machine

2 . Start each of the microservice beginning with eureka-server
```bash
cd eureka-server
./mvnw spring-boot:run
```

3 . Start the rabbitmq and the zipkin containers
```bash
docker run -d --hostname my-test-rabbit --name test-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
docker run -d -p 9411:9411 openzipkin/zipkin
```

4 . Access the Rabbitmq ui by navigating to
```html
http://localhost:15672
```

Login using ```guest/guest``` as the credentials

4 . Once eureka-server is started and docker images are up and running we can start all other services
```bash
cd <microservice-name>
./mvnw spring-boot:run
```

4 . Now create a new order by navigating to
```html
curl http://localhost:5000/api/order
```

This will send messages to both account service and product service.\
Each of the service process the message and sends a response back to order service.\

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors
Rakesh Venkatesh