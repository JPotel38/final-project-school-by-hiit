package fr.schoolbyhiit.portailsuiviformation.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDto {


    @NotBlank
    private String designation;

    @NotBlank
    private LocalDateTime creationDate;


}
