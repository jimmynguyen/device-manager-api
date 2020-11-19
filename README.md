# Device Manager API

Simple Spring Boot REST API for creating, updating, and finding devices by serial number and machine code.

## Endpoints

| Method Type | Path                                               | Description          |
| ----------- | -------------------------------------------------- | -------------------- |
| GET         | /devicemanager/devices                             | getAllDevices        |
| POST        | /devicemanager/devices                             | addDevice            |
| GET         | /devicemanager/devices/machineCode/{machineCode}   | findByMachineCode    |
| PUT         | /devicemanager/devices/machineCode/{machineCode}   | updateByMachineCode  |
| GET         | /devicemanager/devices/serialNumber/{serialNumber} | findBySerialNumber   |
| PUT         | /devicemanager/devices/serialNumber/{serialNumber} | updateBySerialNumber |

## How to Run

If you use an IDE, I'm assuming you won't need instructions for how to run it...

These instructions will be for running from the command line.

1. Clone repository
2. From the command line, navigate to project root folder
3. Run Maven install
  ```shell
  mvn install
  ```
4. Start Spring Boot app (application runs on portt 8080 by default)
  ```shell
  mvn spring-boot:run
  ```

## Testing API with Swagger

After starting the API, navigate to [http://localhost:8080/devicemanager/swagger-ui/](http://localhost:8080/devicemanager/swagger-ui/) to test the API using Swagger.

You should see something like this:

![](https://raw.githubusercontent.com/jimmynguyen/device-manager-api/main/img/swagger.png)