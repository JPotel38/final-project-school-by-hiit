package fr.schoolbyhiit.portailsuiviformation.dto;

import fr.schoolbyhiit.portailsuiviformation.entity.Role;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDate creationDate;

    private LocalDate birthDate;

    @NotBlank
    private String mail;

    private String phoneNumber;

    @NotBlank
    private String password;

    @NotEmpty
    private Set<Role> roles;

}
