USE `portail-suivi-formation`;
CREATE TABLE projects (
    project_id     INT auto_increment PRIMARY KEY,
    name_project   VARCHAR(100) NOT NULL,
    status_project VARCHAR(45) DEFAULT 'IN_PROGRESS',
    score_project  DECIMAL(4,2)
);


CREATE TABLE users_projects (
    user_id    INT NOT NULL,
    project_id INT NOT NULL,
    CONSTRAINT fk_project_id FOREIGN KEY (project_id) REFERENCES projects (project_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

INSERT INTO projects (`name_project`,`status_project`,`score_project`)  VALUES ('TP-1', 'IN_PROGRESS', 15);
INSERT INTO projects (`name_project`,`status_project`,`score_project`)  VALUES ('TP-2', 'DELIVERED', 10);
INSERT INTO projects (`name_project`,`status_project`,`score_project`)  VALUES ('TP-3', 'IN_PROGRESS', 6);

INSERT INTO users_projects (`user_id`, `project_id`) VALUES (1,1);
