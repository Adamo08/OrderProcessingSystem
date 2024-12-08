-- Table for Addresses
CREATE TABLE addresses (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    country VARCHAR(100) NOT NULL
);

-- Table for Customers
CREATE TABLE customers (
    customer_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address_id INT NOT NULL,
   FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

-- Table for Products
CREATE TABLE products (
    product_id VARCHAR(20) PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL
);

-- Table for Payment
CREATE TABLE payment (
    payment_id VARCHAR(20) PRIMARY KEY,
    method VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL
);

-- Table for Shipping
CREATE TABLE shipping (
    shipping_id INT AUTO_INCREMENT PRIMARY KEY,
    method VARCHAR(50),
    tracking_number VARCHAR(50),
    estimated_delivery DATE
);

-- Table for Orders (Empty for now)
CREATE TABLE orders (
    order_id VARCHAR(20) PRIMARY KEY,
    customer_id VARCHAR(20),
    payment_id VARCHAR(20),
    shipping_id INT,
    order_date DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (payment_id) REFERENCES payment(payment_id),
    FOREIGN KEY (shipping_id) REFERENCES shipping(shipping_id)
);




-- Insert data into Addresses
INSERT INTO addresses (street, city, state, postal_code, country)
VALUES
    ('12 Apple Lane', 'Seattle', 'WA', '98101', 'USA'),
    ('34 Orange St', 'Austin', 'TX', '73301', 'USA'),
    ('56 Grape Ave', 'Chicago', 'IL', '60601', 'USA'),
    ('78 Banana Blvd', 'Miami', 'FL', '33101', 'USA'),
    ('90 Kiwi Ct', 'Denver', 'CO', '80201', 'USA');

-- Insert data into Customers
INSERT INTO customers (customer_id, name, email, phone, address_id)
VALUES
    ('CUST001', 'Alice Johnson', 'alice.johnson@example.com', '+1234567890', 1),
    ('CUST002', 'Bob Williams', 'bob.williams@example.com', '+1234567891', 2),
    ('CUST003', 'Charlie Brown', 'charlie.brown@example.com', '+1234567892', 3),
    ('CUST004', 'Diana Ross', 'diana.ross@example.com', '+1234567893', 4),
    ('CUST005', 'Elliot Page', 'elliot.page@example.com', '+1234567894', 5);

-- Insert data into Products
INSERT INTO products (product_id, product_name, price, stock_quantity)
VALUES
    ('PROD001', 'Laptop', 999.99, 50),
    ('PROD002', 'Laptop Bag', 49.99, 100),
    ('PROD003', 'Bluetooth Headphones', 79.99, 200),
    ('PROD004', 'Tablet', 399.99, 30),
    ('PROD005', 'Tablet Cover', 29.99, 150),
    ('PROD006', 'Smartwatch', 199.99, 75),
    ('PROD007', 'Gaming Console', 499.99, 25),
    ('PROD008', 'Extra Controller', 59.99, 300);

-- Insert data into Payment
INSERT INTO payment (payment_id, method, status, currency, total_amount)
VALUES
    ('PAY10001', 'Credit Card', 'Paid', 'USD', 1049.98),
    ('PAY10002', 'PayPal', 'Paid', 'USD', 159.98),
    ('PAY10003', 'Debit Card', 'Pending', 'USD', 429.98),
    ('PAY10004', 'Credit Card', 'Refunded', 'USD', 199.99),
    ('PAY10005', 'PayPal', 'Paid', 'USD', 619.97);

-- Insert data into Shipping
INSERT INTO shipping (method, tracking_number, estimated_delivery)
VALUES
    ('Standard Shipping', 'TRACK10001', '2024-12-05'),
    ('Standard Shipping', 'TRACK10002', '2024-12-07'),
    ('Standard Shipping', NULL, '2024-12-10'),
    (NULL, NULL, NULL),
    ('Express Shipping', 'TRACK10005', '2024-12-06');
