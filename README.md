# Order Processing System

## Project Overview
The **Order Processing System** is a Java-based application that processes orders, validates them, and stores the results into JSON files. It handles customer data, product availability, and payment information, ensuring that confirmed orders and errors are properly recorded.

## Features
- Order reading and validation
- Customer, product, and payment data handling
- JSON output for confirmed and error orders
- Database integration for storing customer and order information

## Technologies Used
- **Programming Language**: Java
- **Libraries**:
  - Jackson (for JSON parsing and writing)
  - JUnit (for unit testing)
  - MySQL (for database storage)

## Setup Instructions

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/Adamo08/OrderProcessingSystem.git
   cd OrderProcessingSystem
   ```

2. **Install Dependencies**:
   Ensure you have Java and Maven installed.

3. **Build the Project**:
   Use Maven to build the project:
   ```sh
   mvn clean install
   ```

4. **Run the Project**:
   After building the project, run it using Maven:
   ```sh
   mvn exec:java
   ```

## Contributing

1. Fork the repository.
2. Create a new branch .
3. Make changes and commit.
4. Push your branch .
5. Open a Pull Request.



## Acknowledgements
- [Jackson](https://github.com/FasterXML/jackson) for JSON processing.
- [JUnit](https://junit.org/junit5/) for unit testing.
- [MySQL](https://www.mysql.com/) for database management.
