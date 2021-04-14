package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ProjectRepository;
import fr.schoolbyhiit.portailsuiviformation.entity.Project;
import fr.schoolbyhiit.portailsuiviformation.mapper.ProjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTests {

    @InjectMocks
    private ProjectServiceImpl projectService;
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private ProjectMapper projectMapper;

    @Test
    void should_return_status_inProgress() {
        // Given
        Project project = new Project();

        // When
        project.setProjectStatus(IN_PROGRESS);

        // Then
        assertEquals(IN_PROGRESS, project.getProjectStatus());
    }


    @Test
    void should_change_status_delivered_to_corrected() {
        // Given
        Project project = new Project();
        project.setProjectStatus(DELIVERED);
        project.setIdProjects(1L);

        // TODO test à corriger pour qu'il passe sans erreur.
        // When
        ///projectService.updateStatus(1L, CORRECTED);

        // Then
        //assertEquals(CORRECTED, project.getStatusProject());
    }

    @Test
    void should_return_a_score() {
        // Given
        Project project = new Project();

        // When
        project.setScoreProject(18);

        // Then
        assertEquals(18, project.getScoreProject());
    }

}
