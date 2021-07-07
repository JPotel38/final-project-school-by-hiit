USE `portail-suivi-formation`;

-- tables des privileges
CREATE TABLE IF NOT EXISTS privileges (
    `privilege_id` INT NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    PRIMARY KEY (`privilege_id`)
);

CREATE TABLE IF NOT EXISTS roles_privileges (
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

-- initialisation des relation roles - privileges
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (1, 1);
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (1, 2);
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (1, 3);
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (1, 4);
INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES (2, 1);
