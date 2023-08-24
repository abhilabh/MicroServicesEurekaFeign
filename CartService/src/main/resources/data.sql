-- Insert sample carts
INSERT INTO cart DEFAULT VALUES;
INSERT INTO cart DEFAULT VALUES;

-- Insert sample line items
INSERT INTO line_items (product_id, product_name, quantity, price, cart_id) VALUES
    (1, 'Product A', 2, 1000, 1),
    (2, 'Product B', 3, 1500, 1),
    (3, 'Product C', 1, 2000, 2);