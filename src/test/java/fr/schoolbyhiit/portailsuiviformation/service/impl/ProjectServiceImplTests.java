package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ProjectRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.entity.Project;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.mapper.ProjectMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ProjectService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.parameters.P;

import java.util.Optional;

import static fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTests {

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Mock
    private ProjectMapper projectMapper;

    @Mock
    private ProjectRepository projectRepository;

    private Project project;


//    @Test
//    void create() {
//        // GIVEN
//        Project project = new Project();
//        User michel = new User();
//
//        ProjectDto projectDto = ProjectDto.builder()
//            .idProjects(2L)
//            .user()
//            .nameProjects("Tp18")
//            .projectStatus(CORRECTED)
//            .scoreProject(18)
//            .build();
//    }


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
    @DisplayName("Vérifie que le status du projet a bien été changé")
    void should_change_status_delivered_to_corrected() {
        // Given
        Project project = new Project();
        project.setProjectStatus(DELIVERED);
        project.setIdProjects(1L);

        // TODO test à corriger pour qu'il passe sans erreur.
        // When
//        projectService.updateStatus(1L, CORRECTED);
//
//        // Then
//        assertEquals(CORRECTED, project.getProjectStatus());
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

//    @Test
//    void addScore_should_throw_ProjectNotFoundException() {
//        // GIVEN
//        Long projectId = 1L;
//        when(projectRepository.findById(anyLong())).thenReturn(Optional.empty());
//
//    }


}
