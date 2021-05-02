package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ModuleNotFoundException extends RuntimeException{

    public ModuleNotFoundException() {
    }

    public ModuleNotFoundException(String message) {
        super(message);
    }
}
