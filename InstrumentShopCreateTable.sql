
DROP TABLE IF EXISTS order_instrument; 
DROP TABLE IF EXISTS orders; 
DROP TABLE IF EXISTS reviews; 
DROP TABLE IF EXISTS instruments; 
DROP TABLE IF EXISTS customers;

CREATE TABLE customers( 
customer_id INT NOT NULL AUTO_INCREMENT,
address VARCHAR(128) NOT NULL, 
phone_number VARCHAR(16) NOT NULL,
customer_name VARCHAR(128) NOT NULL,
PRIMARY KEY (customer_id)
);

CREATE TABLE instruments(
instrument_id INT NOT NULL AUTO_INCREMENT,
make VARCHAR(50) NOT NULL,
model VARCHAR(50) NOT NULL,
description VARCHAR(150) NOT NULL,
price DECIMAL(7,2) NOT NULL,
PRIMARY KEY (instrument_id)
);

CREATE TABLE reviews(
review_id INT NOT NULL AUTO_INCREMENT,
customer_id INT NOT NULL,
text_body VARCHAR(1000) NOT NULL,
PRIMARY KEY (review_id),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE orders( 
order_id INT NOT NULL AUTO_INCREMENT,
customer_id INT NOT NULL, 
order_date date NOT NULL,
PRIMARY KEY (order_id),
FOREIGN KEY(customer_id) REFERENCES customers(customer_id) 
ON DELETE CASCADE
);

CREATE TABLE order_instrument( 
order_id INT NOT NULL, 
instrument_id INT NOT NULL, 
PRIMARY KEY (order_id, instrument_id),
FOREIGN KEY(order_id) REFERENCES orders(order_id) 
ON DELETE CASCADE, 
FOREIGN KEY (instrument_id) REFERENCES instruments(instrument_id)
); 










