package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ProjectRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Project;
import fr.schoolbyhiit.portailsuiviformation.mapper.ProjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus.DELIVERED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTests {

    @InjectMocks
    private ProjectServiceImpl projectService;
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private ProjectMapper projectMapper;
    @Test

    void should_create_a_project() {

        // Given
        ProjectDto projectDto = new ProjectDto();
        Project project = new Project();
        project.setIdProjects(1L);
        project.setNameProjects("TP-666");
        project.setScoreProject(16);
        project.setProjectStatus(DELIVERED);

        // When

        Mockito.when(projectRepository.save(any(Project.class))).thenReturn(project);
        Mockito.when(projectMapper.toProjectDto(any(Project.class))).thenReturn(ProjectDto.builder().idProjects(1L).nameProjects("TP-666").scoreProject(16).projectStatus(DELIVERED).build());

        ProjectDto actual = projectService.create(projectDto);

        // Then
        assertEquals("TP-666", project.getNameProjects());
        assertEquals("TP-666", actual.getNameProjects());
        assertEquals(16, project.getScoreProject());
        assertEquals(16, actual.getScoreProject());
        assertEquals(DELIVERED, project.getProjectStatus());
        assertEquals(DELIVERED, actual.getProjectStatus());
        verify(projectMapper, times(1)).toProjectDto(any(Project.class));
    }

}
