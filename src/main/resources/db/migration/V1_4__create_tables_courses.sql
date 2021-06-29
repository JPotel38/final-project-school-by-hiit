USE `portail-suivi-formation`;

-- table des cours, modules et fichiers

CREATE TABLE IF NOT EXISTS modules
(
    `module_id`    INT         NOT NULL AUTO_INCREMENT,
    `designation`  VARCHAR(50) NOT NULL,
    PRIMARY KEY (`module_id`)
    );

CREATE TABLE IF NOT EXISTS files
(
    `file_id`       INT          NOT NULL AUTO_INCREMENT,
    `designation`   VARCHAR(50)  NOT NULL,
    `creation_date` DATE         NOT NULL,
    `link`          VARCHAR(250) NOT NULL,
    PRIMARY KEY (`file_id`)
);


CREATE TABLE IF NOT EXISTS courses
(
    `course_id`    INT         NOT NULL AUTO_INCREMENT,
    `designation`  VARCHAR(50) NOT NULL,
    `date`         DATE        NOT NULL,
    `fk_module_id` INT         NOT NULL,
    `fk_file_id`   INT         NOT NULL,
    PRIMARY KEY (`course_id`),
    CONSTRAINT `module_fk` FOREIGN KEY (`fk_module_id`) REFERENCES modules (`module_id`),
    CONSTRAINT `file_fk` FOREIGN KEY (`fk_file_id`) REFERENCES files (`file_id`)
    );

