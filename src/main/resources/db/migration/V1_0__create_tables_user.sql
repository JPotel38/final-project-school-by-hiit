CREATE SCHEMA IF NOT EXISTS `portail-suivi-formation`;
USE `portail-suivi-formation`;

-- table des utilisateurs
CREATE TABLE IF NOT EXISTS users
(
    `user_id`       INT         NOT NULL AUTO_INCREMENT,
    `first_name`    VARCHAR(50) NOT NULL,
    `last_name`     VARCHAR(50) NOT NULL,
    `creation_date` DATE        NOT NULL,
    `birth_date`    DATE        NOT NULL,
    `mail`          VARCHAR(100),
    `phone_number`  VARCHAR(20),
    `password`      VARCHAR(250),
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS roles
(
    `role_id` INT         NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS users_roles
(
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `role_fk_idx` (`role_id`),
    CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

INSERT INTO `roles` (`name`)
VALUES ('ADMIN');
INSERT INTO `roles` (`name`)
VALUES ('STUDENT');
INSERT INTO `roles` (`name`)
VALUES ('TEACHER');
INSERT INTO `roles` (`name`)
VALUES ('TUTOR');




