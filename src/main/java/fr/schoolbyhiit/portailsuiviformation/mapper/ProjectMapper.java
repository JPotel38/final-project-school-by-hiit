package fr.schoolbyhiit.portailsuiviformation.mapper;

import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDto toProjectDto(Project project);

    Project toProject(ProjectDto projectDto);

    List<ProjectDto> toProjectDtoToList(List<Project> projects);

}

