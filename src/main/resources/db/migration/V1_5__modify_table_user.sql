USE `portail-suivi-formation`;

-- augmentation taille colonne password dans la table des utilisateurs
ALTER TABLE users MODIFY `password` VARCHAR(250)

