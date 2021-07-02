package fr.schoolbyhiit.portailsuiviformation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id", nullable = false,updatable = false)
    private Long id;

    @Column(name = "designation")
    @NotBlank
    private String designation;

    @Column(name = "creation_date")
    @NotNull
    private LocalDateTime creationDate;

    @Column(name = "link")
    @NotBlank
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_course_id")
    @NotNull
    private Course course;

}
