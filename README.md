# ms_delivery

The service subscribes to a Kafka topic where it receives order details sent by the [Order Service](https://github.com/SvetlanaVys/ms_order).

### Technologies
* **Java 22** and **Spring Boot 3** for building RESTful APIs.
* **PostgreSQL** Database for data storage (RDB).
* **Kafka** ensuring reliable and asynchronous communication.
* **OpenAPI** specification for well-defined and documented API interactions.
* **Docker** for containerization.
* **Maven** for project management and dependency resolution.

## How to Run the Application

> **Note:** Make sure Kafka is running on port 9092 before starting the application, as it requires Kafka for message brokering.


### Running the Application Locally

To run the application in IntelliJ IDEA with the local profile:

1. **Open the project** in IntelliJ IDEA.
2. **Maven**:
   ```bash
   mvn clean install
3. **Select the Run Configuration:**
   - Go to Run > Edit Configurations.
   - Under `VM Options`, add the following:
     ```bash
     -Dspring.profiles.active=local

4. **Start the application**

### Running the Application with Docker

> **Note:** Run [Order Service](https://github.com/SvetlanaVys/ms_order) first.


1. **Maven**:
   ```bash
   mvn clean install

2. **Create shared network** if you haven't already created it in order service
   ```bash
   docker network create marketplace-network

3. **Build the Docker Image**:
   Run the following command to build the Docker image:
   ```bash
   docker build -t ms-delivery-api .

4. **Start the Application**:
   Run the following command to bring up the application along with all its services:
   ```bash
    docker-compose up --build

#### Access Swagger:
   Once the application is up, you can access the Swagger UI at: <br />
   http://localhost:8081/ms-delivery/swagger-ui/index.html
