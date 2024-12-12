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

3. **Create the Database**:
   - First, create a MySQL database named ```oms_db```

4. **Import the Database Schema**:
   - Import the `tables.sql` file located in the `util` package to your database in phpMyAdmin. This file contains the SQL commands for creating the necessary tables and inserting testing data.

   - Make sure to update the `DatabaseUtil.java` file, where the database connection URL is specified. By default, it is set to port **4306**:
     ```java
     private static final String URL = "jdbc:mysql://localhost:4306/oms_db";
     ```
     If you are using the default MySQL port, change it to:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/oms_db";
     ```

5. **Build the Project**:
   Use Maven to build the project:
   ```sh
   mvn clean install
   ```

6. **Run the Project**:
   After building the project, run it using Maven:
   ```sh
   mvn exec:java
   ```

## Contributing

1. Fork the repository.
2. Create a new branch.
3. Make changes and commit.
4. Push your branch.
5. Open a Pull Request.

## Acknowledgements
- [Jackson](https://github.com/FasterXML/jackson) for JSON processing.
- [JUnit](https://junit.org/junit5/) for unit testing.
- [MySQL](https://www.mysql.com/) for database management.
