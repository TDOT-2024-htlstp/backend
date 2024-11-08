-- Categories
INSERT INTO categories (id, name) VALUES (DEFAULT, 'Bonbons');
INSERT INTO categories (id, name) VALUES (DEFAULT, 'Schokolade');
INSERT INTO categories (id, name) VALUES (DEFAULT, 'Lutscher');

-- Products
INSERT INTO products (id, name, price, amount_left, image_path, category_id)
VALUES (DEFAULT, 'Maoam Cola', 10, 20, 'api/images/maoam/cola.png', 1);
INSERT INTO products (id, name, price, amount_left, image_path, category_id)
VALUES (DEFAULT, 'Maoam Erdbeere', 10, 20, 'api/images/maoam/erdbeere.png', 1);
INSERT INTO products (id, name, price, amount_left, image_path, category_id)
VALUES (DEFAULT, 'Maoam Himbeere', 10, 20, 'api/images/maoam/himbeere.png', 1);
INSERT INTO products (id, name, price, amount_left, image_path, category_id)
VALUES (DEFAULT, 'Maoam Orange', 10, 20, 'api/images/maoam/orange.png', 1);
INSERT INTO products (id, name, price, amount_left, image_path, category_id)
VALUES (DEFAULT, 'Maoam Zitrone', 10, 20, 'api/images/maoam/zitrone.png', 1);
INSERT INTO products (id, name, price, amount_left, image_path, category_id)
VALUES (DEFAULT, 'Milka Mini', 10, 20, 'api/images/milka/minis.png', 2);
INSERT INTO products (id, name, price, amount_left, image_path, category_id)
VALUES (DEFAULT, 'Nimm 2 Lollipop', 30, 20, 'api/images/nimm2/lolli.png', 3);

-- Orders
INSERT INTO orders (id, status) VALUES (DEFAULT, 'IN_PROGRESS');
INSERT INTO orders (id, status) VALUES (DEFAULT, 'IN_PROGRESS');

-- Product Entries
INSERT INTO product_entries (id, product_id, amount) VALUES (DEFAULT, 3, 6);
INSERT INTO product_entries (id, product_id, amount) VALUES (DEFAULT, 5, 7);
INSERT INTO product_entries (id, product_id, amount) VALUES (DEFAULT, 4, 2);
INSERT INTO product_entries (id, product_id, amount) VALUES (DEFAULT, 3, 3);
INSERT INTO product_entries (id, product_id, amount) VALUES (DEFAULT, 1, 5);
INSERT INTO product_entries (id, product_id, amount) VALUES (DEFAULT, 2, 2);

-- Orders Entries (mapping orders to their respective product entries)
INSERT INTO orders_entries (order_id, entries_id) VALUES (1, 1);
INSERT INTO orders_entries (order_id, entries_id) VALUES (1, 2);
INSERT INTO orders_entries (order_id, entries_id) VALUES (1, 3);
INSERT INTO orders_entries (order_id, entries_id) VALUES (1, 4);
INSERT INTO orders_entries (order_id, entries_id) VALUES (2, 5);
INSERT INTO orders_entries (order_id, entries_id) VALUES (2, 6);
