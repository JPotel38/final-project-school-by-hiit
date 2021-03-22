package fr.schoolbyhiit.portailsuiviformation.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {
    public UserNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("User with id : %s not found !", id));
    }
}
