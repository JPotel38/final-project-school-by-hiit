USE `portail-suivi-formation`;

INSERT INTO `roles` (`name`) VALUES ('ADMIN');
INSERT INTO `roles` (`name`) VALUES ('STUDENT');
INSERT INTO `roles` (`name`) VALUES ('TEACHER');
INSERT INTO `roles` (`name`) VALUES ('TUTOR');

INSERT INTO `users` (`first_name`, `last_name`, `creation_date`, `birth_date`, `mail`, `phone_number`, `password`)
VALUES ('patrick', 'patrick', '2021-03-21', '2000-03-03', 'patrick@mail.fr', '00000000', 'pwd');
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 3); -- user patrick has role ADMIN
