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

    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @GetMapping("")
    public List<ProjectDto> getAll() {
            return projectService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDto create(@RequestBody ProjectDto projectDto) {
            return projectService.create(projectDto);
    }
    @GetMapping("/{id}")
    public ProjectDto getProject(@PathVariable Long id) {
            return projectService.getProject(id);
    }


    @PreAuthorize("hasAuthority('user:update')")
    @PutMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDto updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto) {
        return projectService.updateProject(id, projectDto);
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        projectService.delete(id);
    }

}
