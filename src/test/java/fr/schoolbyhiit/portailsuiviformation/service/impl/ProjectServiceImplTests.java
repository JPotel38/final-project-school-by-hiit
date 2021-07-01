package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ProjectRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Project;
import fr.schoolbyhiit.portailsuiviformation.exception.ProjectNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.mapper.ProjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


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


    @Test
    void should_change_status_delivered_to_corrected() {
        // Given
        Project project = new Project();
        project.setIdProjects(1L);
        project.setProjectStatus(DELIVERED);

        // When
        //ProjectDto projectDto = ProjectDto.builder().idProjects(1L).projectStatus(CORRECTED).build();
        Mockito.when(projectRepository.findById(anyLong())).thenReturn(Optional.of(project));
        Mockito.when(projectRepository.save(any(Project.class))).thenReturn(project);
        Mockito.when(projectMapper.toProjectDto(any(Project.class))).thenReturn(ProjectDto.builder().idProjects(1L).projectStatus(CORRECTED).build());

        ProjectDto actual = projectService.updateStatus(1L, CORRECTED);

        // Then
        assertEquals(CORRECTED, project.getProjectStatus());
        assertEquals(CORRECTED, actual.getProjectStatus());
        verify(projectMapper, times(1)).toProjectDto(any(Project.class));
    }

    @Test
    void should_change_status_throw_ProjectNotFoundException() {
        // Given
        Long projectId = 1L;

        // When // Then
        assertThatThrownBy(() -> projectService.updateStatus(projectId, DELIVERED))
            .isInstanceOf(ProjectNotFoundException.class);
    }

    @Test
    void should_add_score_in_project() {
        // Given
        Project project = new Project();
        project.setIdProjects(3L);

        // When
        Mockito.when(projectRepository.findById(anyLong())).thenReturn(Optional.of(project));
        Mockito.when(projectRepository.save(any(Project.class))).thenReturn(project);
        Mockito.when(projectMapper.toProjectDto(any(Project.class))).thenReturn(ProjectDto.builder().idProjects(3L).scoreProject(18).build());

        ProjectDto actual = projectService.addScore(3L, 18);

        // Then
        assertEquals(18, project.getScoreProject());
        assertEquals(18, actual.getScoreProject());
        verify(projectMapper, times(1)).toProjectDto(any(Project.class));
    }

    @Test
    void should_add_score_throw_ProjectNotFoundException() {
        // Given
        Long projectId = 1L;

        // When // Then
        assertThatThrownBy(() -> projectService.addScore(projectId, 12))
            .isInstanceOf(ProjectNotFoundException.class);
    }

}
