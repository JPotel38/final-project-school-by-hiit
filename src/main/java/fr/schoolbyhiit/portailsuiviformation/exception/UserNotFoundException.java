package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {

    public static final UserNotFoundException INSTANCE = new UserNotFoundException();

    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "User not found");
    }
}
