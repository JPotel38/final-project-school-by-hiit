package fr.schoolbyhiit.portailsuiviformation.entity;

import fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="projects")
public class Project implements Serializable {


    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProjects;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_projects",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<User> users;

    @Column(name="name_project")
    private String nameProjects;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @Column(name="score_project")
    private float scoreProject;
}
