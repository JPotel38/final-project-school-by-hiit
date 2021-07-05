package fr.schoolbyhiit.portailsuiviformation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="modules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id", nullable = false,updatable = false)
    private Long id;

    @Column(name = "designation")
    @NotBlank
    private String designation;


    //TODO Ajouter les relations avec les entités User, Project... => new user story
}
