package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidRoleException extends ResponseStatusException {

    public static final InvalidRoleException INSTANCE = new InvalidRoleException();

    public InvalidRoleException() {
        super(HttpStatus.BAD_REQUEST, "No role found for this parameters !");
    }
}
