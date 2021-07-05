package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Le format des données est incorrect" )
public class BadFormatException extends RuntimeException {
    public BadFormatException(String s){
        super(s);
    }
}
