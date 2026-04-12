create table users (
	username varchar(255),
	email varchar(255),
	password varchar(255)
);

create table product (
	name varchar(255),
	description varchar(255),
	price double,
	stock integer
);

CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

create table products (
    id BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(255),
	description varchar(255),
	price double,
	stock integer,
	PRIMARY KEY (id)
);

INSERT INTO products (name, description, price, stock) VALUES
('Laptop Pro 15', 'High-performance laptop', 1499.99, 10),
('Wireless Mouse', 'Ergonomic wireless mouse', 25.50, 150),
('Mechanical Keyboard', 'RGB mechanical keyboard', 89.99, 75),
('USB-C Hub', 'Multiport adapter', 45.00, 60),
('27-inch Monitor', '4K UHD display', 329.99, 20),
('Office Chair', 'Adjustable ergonomic chair', 199.99, 15),
('Desk Lamp', 'LED desk lamp', 39.99, 80),
('External SSD 1TB', 'Portable storage device', 120.00, 40),
('Webcam HD', '1080p USB webcam', 59.99, 55),
('Noise Cancelling Headphones', 'Over-ear headphones', 249.99, 25),

('Smartphone X', 'Latest generation smartphone', 999.99, 30),
('Tablet 10"', '10-inch tablet device', 399.99, 45),
('Bluetooth Speaker', 'Portable speaker', 70.00, 90),
('Gaming Mouse Pad', 'Large surface mouse pad', 19.99, 120),
('Router AX3000', 'Wi-Fi 6 router', 130.00, 35),
('Smartwatch', 'Fitness tracking smartwatch', 199.00, 50),
('Power Bank 20000mAh', 'High-capacity battery pack', 49.99, 85),
('Action Camera', '4K waterproof camera', 220.00, 18),
('Microphone USB', 'Studio quality mic', 110.00, 22),
('Graphics Tablet', 'Digital drawing tablet', 150.00, 27),

('Gaming Laptop', 'High-end gaming laptop', 1799.99, 12),
('VR Headset', 'Virtual reality headset', 349.99, 16),
('Drone Pro', 'Camera drone with GPS', 599.99, 8),
('Smart Light Bulb', 'Wi-Fi enabled bulb', 15.99, 200),
('Electric Kettle', 'Fast boiling kettle', 35.00, 65),
('Coffee Maker', 'Automatic coffee machine', 89.99, 28),
('Air Purifier', 'HEPA air purifier', 140.00, 33),
('Fan Tower', 'Oscillating tower fan', 60.00, 44),
('Heated Blanket', 'Electric blanket', 75.00, 19),
('Mini Projector', 'Portable projector', 210.00, 14);

select * from products;


delete from products;


ALTER TABLE users ADD email_notifications varchar(255);
ALTER TABLE users ADD language varchar(255);
ALTER TABLE users ADD status varchar(255);


select * from users;

select count(*) from users;

delete from users;


CREATE TABLE orders (
    order_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(100) NOT NULL,
    order_date DATE,
    status VARCHAR(50),
    total_amount DECIMAL(10,2),
    PRIMARY KEY (order_id)
);


INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-02-10', 'completed', 99.99);

INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-06-15', 'completed', 49.50);

INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-11-20', 'pending', 120.00);

INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-02-11', 'completed', 99.99);

INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-06-14', 'completed', 49.50);

INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-11-22', 'pending', 120.00);

INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-02-12', 'completed', 99.99);

INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-06-16', 'completed', 49.50);

INSERT INTO orders (user_id, order_date, status, total_amount)
VALUES ('user_789', '2024-11-23', 'pending', 120.00);

select * from products;

select * from orders;
