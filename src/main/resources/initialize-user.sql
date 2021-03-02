CREATE SCHEMA `portail-suivi-formation`;

-- table des utilisateurs
CREATE TABLE IF NOT EXISTS `portail-suivi-formation`.`users` (
    `id_user` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `creation_date` DATE NOT NULL,
    `birth_date` DATE NOT NULL,
    `mail` VARCHAR(100) ,
    `phone_number` VARCHAR(20),
    `role` VARCHAR(10),
    PRIMARY KEY (`id_user`)
)
ENGINE = InnoDB;

