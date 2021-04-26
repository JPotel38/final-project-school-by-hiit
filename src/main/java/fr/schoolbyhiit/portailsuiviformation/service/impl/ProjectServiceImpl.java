package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ProjectRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Project;
import fr.schoolbyhiit.portailsuiviformation.exception.ProjectNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus;
import fr.schoolbyhiit.portailsuiviformation.mapper.ProjectMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ProjectService;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDto create(ProjectDto projectDto) {
        Project project = new Project();

        project.setNameProjects(projectDto.getNameProjects());
        project.setProjectStatus(projectDto.getProjectStatus());
        project.setScoreProject(projectDto.getScoreProject());

        return  projectMapper.toProjectDto(projectRepository.save(project));
    }

    @Override
    public ProjectDto updateStatus(Long id, ProjectStatus projectStatus) {

        Project project = projectRepository.findById(id)
                .orElseThrow(()-> ProjectNotFoundException.INSTANCE);

        project.setProjectStatus(projectStatus);
        return projectMapper.toProjectDto(projectRepository.save(project));
    }

    @Override
    public ProjectDto addScore(Long id, int score) {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> ProjectNotFoundException.INSTANCE);
        project.setScoreProject(score);

        return projectMapper.toProjectDto(projectRepository.save(project));
    }

    @Override
    public void delete(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> ProjectNotFoundException.INSTANCE);
        projectRepository.delete(project);
    }

}
