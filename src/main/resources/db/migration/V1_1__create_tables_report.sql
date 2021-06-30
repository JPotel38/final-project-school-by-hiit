USE `portail-suivi-formation`;

CREATE TABLE IF NOT EXISTS reports (
    `report_id` INT NOT NULL AUTO_INCREMENT,
    `prof_id` VARCHAR(50) NOT NULL,
    `student_id` VARCHAR(50) NOT NULL,
    `tutor_id` VARCHAR(50) NOT NULL,
    `date` DATE NOT NULL,
    `text` LONGTEXT NOT NULL,
    `validated` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`report_id`)
    )ENGINE = InnoDB;
