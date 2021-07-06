USE `portail-suivi-formation`;

-- augmentation taille colonne password dans la table des utilisateurs
ALTER TABLE users MODIFY `password` VARCHAR(250);

UPDATE users
SET password='$2a$10$C7pDYxdCErXWoYk20.4Qs.k5wo6b1XqwQUyP5aBgMpsRN8BjVznKW'
WHERE user_id=1;

