package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.ProjectDto;
import fr.schoolbyhiit.portailsuiviformation.model.ProjectStatus;
import fr.schoolbyhiit.portailsuiviformation.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PreAuthorize("hasAnyRole('TEACHER')")
    @GetMapping("")
    public List<ProjectDto> getAll() {
            return projectService.findAll();
    }
    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDto create(@RequestBody ProjectDto projectDto) {
            return projectService.create(projectDto);
    }

    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @PutMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDto updateStatus(@PathVariable Long id, @RequestBody ProjectStatus projectStatus) {
        return projectService.updateStatus(id, projectStatus);
    }

    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDto addScore(@PathVariable Long id, @RequestBody int score) {
        return projectService.addScore(id, score);
    }

    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        projectService.delete(id);
    }

}
