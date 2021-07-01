package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class CourseNotFoundException extends ResponseStatusException {

    public CourseNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("Course with id : %s not found", id));
    }

}
