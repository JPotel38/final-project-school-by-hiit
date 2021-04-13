package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailExistsException extends ResponseStatusException {

    public EmailExistsException(String mail) {
        super(HttpStatus.CONFLICT,
                String.format("User with mail : %s already exist !", mail));
    }
}
