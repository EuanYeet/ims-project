CREATE DATABASE IF NOT EXISTS ims;

use ims;

CREATE TABLE IF NOT EXISTS `ims`.`user` (
    `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `forename` VARCHAR(40) NOT NULL,
    `surname` VARCHAR(40) NOT NULL,
    `age` INT(3) NOT NULL,
    `phone_no` VARCHAR(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`item` (
    `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `stock` INT(11) NOT NULL,
    `price` DECIMAL(15,2) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `fk_user_id` BIGINT(11) NOT NULL,
    `fk_item_id` BIGINT(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY(fk_user_id) REFERENCES user(id),
    FOREIGN KEY(fk_item_id) REFERENCES item(id)
);

CREATE TABLE IF NOT EXISTS `ims`.`itemorder` (
    `fk_order_id` BIGINT(11) NOT NULL,
    `fk_item_id` BIGINT(11) NOT NULL,
    `quantity` INT(11) NOT NULL,
    FOREIGN KEY(fk_order_id) REFERENCES orders(id),
    FOREIGN KEY(fk_item_id) REFERENCES item(id)
);

