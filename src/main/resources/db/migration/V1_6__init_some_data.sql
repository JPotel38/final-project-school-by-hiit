
-- emplois du temps

insert into schedule_events (title, start, end, all_day, course_id)
values ('Devops Docker', '2021-07-03 09:00:00', '2021-07-03 17:00:00', false, 1);

--  users

INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`, password)
VALUES ('admin', 'admin', '2021-03-21', '2000-03-03', 'admin@admin', '00000000', '$2a$10$C7pDYxdCErXWoYk20.4Qs.k5wo6b1XqwQUyP5aBgMpsRN8BjVznKW');
INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES (1, 1); -- user patrick has role ADMIN
INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`)
VALUES ('Jon', 'Snow', '2021-02-18', '1978-08-05', 'snow@mail.fr', '00000001');
INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES (2, 2);
INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`)
VALUES ('Iron', 'Man', '2001-03-19', '1999-01-04', 'iron@mail.fr', '00000002');
INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES (3, 4);

INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`)
VALUES ('Coll', 'Mick', '2001-03-19', '1999-01-04', 'mick@mail.fr', '00000002');
INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES (4, 3);


INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`, password)
VALUES ('user', 'user', '2001-03-19', '1999-01-04', 'user@user', '00000002', '$2a$10$WG6OwzQBYqvHpclEjZ.l3emXdgq82QqTp2aseHp6DSu7PkcyHNKgK');
INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES (5, 2);


-- projects

INSERT INTO projects (`name_project`,`status_project`,`score_project`)  VALUES ('TP-1', 'IN_PROGRESS', 15);
INSERT INTO projects (`name_project`,`status_project`,`score_project`)  VALUES ('TP-2', 'DELIVERED', 10);
INSERT INTO projects (`name_project`,`status_project`,`score_project`)  VALUES ('TP-3', 'IN_PROGRESS', 6);

INSERT INTO users_projects (`user_id`, `project_id`) VALUES (1,1);

-- reports

INSERT INTO `reports` (`teacher_id`,`student_id`, `tutor_id`, `appointment_date`,`report_text`,`validated`)
VALUES ('1', '2', '3', '2021-06-21', 'Quel bon élève', 'VALIDATED');

INSERT INTO `reports` (`teacher_id`,`student_id`, `tutor_id`, `appointment_date`,`report_text`,`validated`)
VALUES ('1', '2', '3', '2011-02-21', 'Bof', 'NOT_VALIDATED');

