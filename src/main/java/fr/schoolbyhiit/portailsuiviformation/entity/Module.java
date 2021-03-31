package fr.schoolbyhiit.portailsuiviformation.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="modules")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module-id", nullable = false,updatable = false)
    private Long id;

    @Column(name = "designation")
    @NotBlank
    private String designation;

    @OneToMany(mappedBy = "module")
    private Set<Course> courses = new HashSet<>();

    //TODO Ajouter les relations avec les entités User, Project... => new user story
}
