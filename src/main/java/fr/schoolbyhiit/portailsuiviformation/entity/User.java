package fr.schoolbyhiit.portailsuiviformation.entity;

import fr.schoolbyhiit.portailsuiviformation.entity.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate creationDate;

    @Column
    private LocalDate birthDate;

    @Column
    private String mail;

    @Column
    private String phoneNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

}
