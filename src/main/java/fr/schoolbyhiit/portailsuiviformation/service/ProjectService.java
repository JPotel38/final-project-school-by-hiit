package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;
import fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAll();

    ProjectDto create(ProjectDto projectDto);

    ProjectDto updateStatus(Long id, ProjectStatus projectStatus);

    ProjectDto addScore(Long id, int score);

    void delete(Long id);
}
