package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FileNotFoundException extends ResponseStatusException {

    public FileNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("File with id : %s not found",id));
    }

}

