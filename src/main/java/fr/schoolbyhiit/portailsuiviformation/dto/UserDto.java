package fr.schoolbyhiit.portailsuiviformation.dto;

import fr.schoolbyhiit.portailsuiviformation.entity.model.Status;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private long id;

    private String firstName;

    private String lastName;

    private LocalDate creationDate;

    private LocalDate birthDate;

    private String mail;

    private String phoneNumber;

    private Status status;

}
