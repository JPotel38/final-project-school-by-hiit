package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class ModuleNotFoundException extends ResponseStatusException {

    public ModuleNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("Module with id : %s not found",id));
    }

}
