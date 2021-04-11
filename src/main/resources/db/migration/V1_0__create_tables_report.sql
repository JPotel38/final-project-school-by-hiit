CREATE SCHEMA IF NOT EXISTS `portail-suivi-formation`;
USE `portail-suivi-formation`;

CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`reports`(
    `report_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(50) NOT NULL,
    `date` DATE NOT NULL,
    `text` LONGTEXT NOT NULL,
    `validated` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`report_id`)
    )ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`users_reports` (
     `user_id` INT NOT NULL,
     `report_id` INT NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `report_fk_idx` (`report_id`),
    CONSTRAINT `report_fk` FOREIGN KEY (`report_id`) REFERENCES `reports` (`report_id`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
    );
