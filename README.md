# ms_delivery

The service subscribes to a Kafka topic where it receives order details sent by the [Order Service](https://github.com/SvetlanaVys/ms_order).

### Technologies
* **Java 20** and **Spring Boot 3** for building RESTful APIs.
* **PostgreSQL** Database for data storage (RDB).
* **Kafka** ensuring reliable and asynchronous communication.
* **OpenAPI** specification for well-defined and documented API interactions.
* **Docker** for containerization.
* **Maven** for project management and dependency resolution.

### How to Run the Application

1. **Maven**:
   ```bash
   mvn clean install

2. **Build the Docker Image**:
   Run the following command to build the Docker image:
   ```bash
   docker build -t ms-delivery-api .

2. **Start the Application**:
   Run the following command to bring up the application along with all its services:
   ```bash
    docker-compose up --build

3. **Access Swagger**:
   Once the application is up, you can access the Swagger UI at: <br />
   http://localhost:8081/ms-delivery/swagger-ui/index.html