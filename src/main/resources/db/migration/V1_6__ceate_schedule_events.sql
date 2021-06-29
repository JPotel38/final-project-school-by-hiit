CREATE TABLE IF NOT EXISTS `schedule_events`
(
    `event_id`     INT         NOT NULL AUTO_INCREMENT,
    `title`        VARCHAR(50) NOT NULL,
    `start`        DATE        NOT NULL,
    `end`          DATE        NOT NULL,
    `all_day`      BOOLEAN,
    `course_id`    INT,
    PRIMARY KEY (`event_id`)
) ENGINE = InnoDB;
