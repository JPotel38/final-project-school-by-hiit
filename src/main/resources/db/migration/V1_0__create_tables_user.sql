CREATE SCHEMA IF NOT EXISTS `portail-suivi-formation`;
USE `portail-suivi-formation`;

-- table des utilisateurs
CREATE TABLE IF NOT EXISTS users (
    `user_id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `creation_date` DATE NOT NULL,
    `birth_date` DATE NOT NULL,
    `mail` VARCHAR(100) ,
    `phone_number` VARCHAR(20),
    PRIMARY KEY (`user_id`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS roles (
    `role_id` INT NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS users_roles (
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `role_fk_idx` (`role_id`),
    CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

INSERT INTO `roles` (`name`) VALUES ('ADMIN');
INSERT INTO `roles` (`name`) VALUES ('STUDENT');
INSERT INTO `roles` (`name`) VALUES ('TEACHER');
INSERT INTO `roles` (`name`) VALUES ('TUTOR');

INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`)
VALUES ('admin', 'admin', '2021-03-21', '2000-03-03', 'admin@admin', '00000000');
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1); -- user patrick has role ADMIN
INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`)
VALUES ('Jon', 'Snow', '2021-02-18', '1978-08-05', 'snow@mail.fr', '00000001');
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`)
VALUES ('Iron', 'Man', '2001-03-19', '1999-01-04', 'iron@mail.fr', '00000002');
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 4);
