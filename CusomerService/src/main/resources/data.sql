-- Insert data for customers
INSERT INTO customer (customer_name, email) VALUES ('John Doe', 'john@example.com');
INSERT INTO customer (customer_name, email) VALUES ('Jane Smith', 'jane@example.com');

-- Insert data for addresses
INSERT INTO address (door_no, street_name, city, layout, customer_id) VALUES (123, 'Main Street', 'City', 'Layout A', 1);
INSERT INTO address (door_no, street_name, city, layout, customer_id) VALUES (456, 'Second Avenue', 'Town', 'Layout B', 1);
INSERT INTO address (door_no, street_name, city, layout, customer_id) VALUES (789, 'Third Street', 'Village', 'Layout C', 2);