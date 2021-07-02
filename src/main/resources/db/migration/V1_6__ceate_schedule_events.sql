CREATE TABLE IF NOT EXISTS `schedule_events`
(
    `event_id`  INT         NOT NULL AUTO_INCREMENT,
    `title`     VARCHAR(50) NOT NULL,
    `start`     DATETIME    NOT NULL,
    `end`       DATETIME,
    `all_day`   BOOLEAN,
    `course_id` INT,
    PRIMARY KEY (`event_id`)
) ENGINE = InnoDB;

insert into schedule_events (title, start, end, all_day, course_id)
values ('Devops Docker', '2021-07-03 09:00:00', '2021-07-03 17:00:00', false, 1)
