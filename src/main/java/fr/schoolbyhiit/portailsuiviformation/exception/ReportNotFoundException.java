package fr.schoolbyhiit.portailsuiviformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReportNotFoundException extends ResponseStatusException {
    public ReportNotFoundException(Long id){
        super(HttpStatus.NOT_FOUND, "Report not found !" + id);
    }

}
