package fr.schoolbyhiit.portailsuiviformation.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {

    public static final UserNotFoundException INSTANCE = new UserNotFoundException();
    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "User not found");
    }
}
