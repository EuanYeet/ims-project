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

