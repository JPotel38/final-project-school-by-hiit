package fr.schoolbyhiit.portailsuiviformation.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReportNotFoundException extends ResponseStatusException {
    public static final ReportNotFoundException INSTANCE = new ReportNotFoundException();


    public ReportNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Report not found");
    }
}
