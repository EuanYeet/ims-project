INSERT INTO user(forename,surname,age,phone_no) VALUES ('jordan', 'harrison', 24, '07828138122');
INSERT INTO user(forename,surname,age,phone_no) VALUES ('chris', 'dongle', 22, '07818138122');
INSERT INTO user(forename,surname,age,phone_no) VALUES ('matt', 'walsh', 32, '07428138122');
INSERT INTO user(forename,surname,age,phone_no) VALUES ('steven', 'dingle', 18, '07818138764');
INSERT INTO item(name,description,stock,price) VALUES ("xbox", "console", 50, 150.00);
INSERT INTO item(name,description,stock,price) VALUES ("ps4", "console", 1, 120.00);
INSERT INTO item(name,description,stock,price) VALUES ("wii", "console", 1, 100.00);
INSERT INTO orders(fk_user_id) VALUES ((SELECT id FROM user WHERE id = 1));
INSERT INTO orders(fk_user_id) VALUES ((SELECT id FROM user WHERE id = 2));
INSERT INTO orders(fk_user_id) VALUES ((SELECT id FROM user WHERE id = 3));
INSERT INTO orders(fk_user_id) VALUES ((SELECT id FROM user WHERE id = 4));
INSERT INTO itemorder(fk_order_id, fk_item_id, quantity) VALUES (1,1,1);
INSERT INTO itemorder(fk_order_id, fk_item_id, quantity) VALUES (2,2,1);
INSERT INTO itemorder(fk_order_id, fk_item_id, quantity) VALUES (3,3,1);
INSERT INTO itemorder(fk_order_id, fk_item_id, quantity) VALUES (4,2,1);
INSERT INTO itemorder(fk_order_id, fk_item_id, quantity) VALUES (4,3,1);