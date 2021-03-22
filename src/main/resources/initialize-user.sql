DROP SCHEMA `portail-suivi-formation`;
CREATE SCHEMA IF NOT EXISTS `portail-suivi-formation`;
USE `portail-suivi-formation`;

-- table des utilisateurs
CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`users` (
    `user_id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `creation_date` DATE NOT NULL,
    `birth_date` DATE NOT NULL,
    `mail` VARCHAR(100) ,
    `phone_number` VARCHAR(20),
    `password` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`user_id`)
)ENGINE = InnoDB;

-- tables des roles
CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`roles` (
    `role_id` INT NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    PRIMARY KEY (`role_id`)
);

-- tables des privileges
CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`privileges` (
    `privilege_id` INT NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    PRIMARY KEY (`privilege_id`)
);

-- table de jointure users - roles
CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`users_roles` (
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `role_fk_idx` (`role_id`),
    CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`roles_privileges`(
    `role_id` INT NOT NULL,
    `privilege_id` INT NOT NULL,
    KEY `role_fk_idx` (`role_id`),
    KEY `privilege_fk_idx` (`privilege_id`),
    CONSTRAINT `privilege_fk` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`privilege_id`),
    CONSTRAINT `role_privilege_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
);

-- initialisation des privilèges
INSERT INTO `privileges` (`name`) VALUES ('USER_READ');
INSERT INTO `privileges` (`name`) VALUES ('USER_ADD');
INSERT INTO `privileges` (`name`) VALUES ('USER_UPDATE');
INSERT INTO `privileges` (`name`) VALUES ('USER_DELETE');

-- initialisation des roles
INSERT INTO `roles` (`name`) VALUES ('ADMIN');
INSERT INTO `roles` (`name`) VALUES ('STUDENT');
INSERT INTO `roles` (`name`) VALUES ('TEACHER');
INSERT INTO `roles` (`name`) VALUES ('TUTOR');

-- initialisation des relation roles - privileges
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (1, 1);
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (1, 2);
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (1, 3);
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (1, 4);


