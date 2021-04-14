package fr.schoolbyhiit.portailsuiviformation.dto;

import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private long idProjects;

    private User user;

    private String nameProjects;

    private ProjectStatus projectStatus;

    private float scoreProject;

}
