package fr.schoolbyhiit.portailsuiviformation.dto;

import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {


    private Long id;

    @NotBlank
    private String designation;

    @NotNull
    private LocalDateTime creationDate;

    @NotBlank
    private String link;

    @NotNull
    private Course course;


}
