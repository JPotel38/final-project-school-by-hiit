package fr.schoolbyhiit.portailsuiviformation.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false,updatable = false)
    private Long id;

    @Column(name = "designation")
    @NotBlank
    private String designation;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_fk")
    private Module module;

    @OneToMany
    private Set<File> files = new HashSet<>();

}
