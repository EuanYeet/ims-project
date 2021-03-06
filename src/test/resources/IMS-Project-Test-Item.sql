CREATE DATABASE IF NOT EXISTS imstest;

use imstest;

DROP TABLE IF EXISTS itemorder;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS item;

CREATE TABLE IF NOT EXISTS `imstest`.`item` (
    `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `stock` INT(11) NOT NULL,
    `price` DECIMAL(15,2) NOT NULL,
    PRIMARY KEY (`id`)
);

