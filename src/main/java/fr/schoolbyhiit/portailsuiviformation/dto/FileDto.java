package fr.schoolbyhiit.portailsuiviformation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {


    @NotBlank
    private String designation;

    @NotBlank
    private LocalDateTime creationDate;


}
