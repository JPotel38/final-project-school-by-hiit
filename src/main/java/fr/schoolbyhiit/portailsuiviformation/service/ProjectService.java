package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAll();

    ProjectDto create(ProjectDto projectDto);

    ProjectDto updateProject(Long id,ProjectDto projectDto);

    ProjectDto getProject(Long id);

    void delete(Long id);
}
