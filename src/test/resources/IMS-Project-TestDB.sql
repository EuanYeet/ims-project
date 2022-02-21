CREATE DATABASE IF NOT EXISTS imstest;

use imstest;

DROP TABLE IF EXISTS itemorder;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS item;


CREATE TABLE IF NOT EXISTS `imstest`.`user` (
    `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `forename` VARCHAR(40) NOT NULL,
    `surname` VARCHAR(40) NOT NULL,
    `age` INT(3) NOT NULL,
    `phone_no` VARCHAR(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `imstest`.`item` (
    `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `stock` INT(11) NOT NULL,
    `price` DECIMAL(15,2) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `imstest`.`orders` (
    `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `fk_user_id` BIGINT(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY(fk_user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS `imstest`.`itemorder` (
    `fk_order_id` BIGINT(11) NOT NULL,
    `fk_item_id` BIGINT(11) NOT NULL,
    `quantity` INT(11) NOT NULL,
    FOREIGN KEY(fk_order_id) REFERENCES orders(id),
    FOREIGN KEY(fk_item_id) REFERENCES item(id)
);

