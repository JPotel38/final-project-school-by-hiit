package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProjectNotFoundException extends ResponseStatusException {
    public static final ProjectNotFoundException INSTANCE = new ProjectNotFoundException();

    public ProjectNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Project not found");
    }

}
