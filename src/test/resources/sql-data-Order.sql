INSERT INTO user(forename,surname,age,phone_no) VALUES ('jordan', 'harrison', 24, '07828138122');
INSERT INTO item(name,description,stock,price) VALUES ("xbox", "console", 50, 150.00);
INSERT INTO item(name,description,stock,price) VALUES ("ps4", "console", 1, 150.00);
INSERT INTO orders(fk_user_id) VALUES ((SELECT id FROM user WHERE id = 1));
INSERT INTO itemorder(fk_order_id, fk_item_id, quantity) VALUES (1,1,1);
