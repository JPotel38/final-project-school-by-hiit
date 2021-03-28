USE `portail-suivi-formation`;

-- table des cours et modules

CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`courses` (
    `course_id` INT  NOT NULL AUTO_INCREMENT,
    `designation` VARCHAR (50) NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (`course_id`)
)

CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`modules` (
    `module_id` INT  NOT NULL AUTO_INCREMENT,
    `designation` VARCHAR (50) NOT NULL,
    PRIMARY KEY (`module_id`)
    )

CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`files` (
    `file_id` INT  NOT NULL AUTO_INCREMENT,
    `designation` VARCHAR (50) NOT NULL,
    `creation_date` DATE NOT NULL,
    PRIMARY KEY (`file_id`)
    )