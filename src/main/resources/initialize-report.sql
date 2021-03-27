CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`reports`(
    `report_id` INT NOT NULL AUTO_INCREMENT,
    `author` VARCHAR(50) NOT NULL,
    `date` DATE NOT NULL,
    `text` LONGTEXT NOT NULL,
    `validated` ENUM('VALIDATED', 'NOT VALIDATED'),
    PRIMARY KEY (`report_id`)
    )ENGINE = InnoDB;
