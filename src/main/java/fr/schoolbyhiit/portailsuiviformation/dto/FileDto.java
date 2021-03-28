package fr.schoolbyhiit.portailsuiviformation.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class FileDto {


    @NotBlank
    private String designation;

    @NotBlank
    private LocalDateTime creationDate;


}
