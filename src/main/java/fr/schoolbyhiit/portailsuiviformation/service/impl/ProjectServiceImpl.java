package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ProjectRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Project;
import fr.schoolbyhiit.portailsuiviformation.exception.ProjectNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus;
import fr.schoolbyhiit.portailsuiviformation.mapper.ProjectMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ProjectService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @Override
    public List<ProjectDto> findAll() {
        return projectMapper.toProjectDtoToList(projectRepository.findAll());
    }

    @Override
    public ProjectDto create(ProjectDto projectDto) {
        Project project = new Project();

        project.setNameProjects(projectDto.getNameProjects());
        project.setProjectStatus(projectDto.getProjectStatus());
        project.setScoreProject(projectDto.getScoreProject());

        return  projectMapper.toProjectDto(projectRepository.save(project));
    }


    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @Override
    public ProjectDto updateProject(Long id,ProjectDto projectDto) {
        Project project = projectRepository.findById(id).orElseThrow(() -> ProjectNotFoundException.INSTANCE);
        project.setProjectStatus(projectDto.getProjectStatus());
        project.setScoreProject(projectDto.getScoreProject());
        return projectMapper.toProjectDto(projectRepository.save(project));
    }

    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @Override
    public ProjectDto getProject(Long id) {
        return projectMapper.toProjectDto(projectRepository.getOne(id));
    }



    @Override
    public void delete(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> ProjectNotFoundException.INSTANCE);
        projectRepository.delete(project);
    }


}
