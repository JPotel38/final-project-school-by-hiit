package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus;

public interface ProjectService {
    ProjectDto create(ProjectDto projectDto);

    ProjectDto updateStatus(Long id, ProjectStatus projectStatus);

    ProjectDto addScore(Long id, int score);

    void delete(Long id);
}
