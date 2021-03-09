package fr.schoolbyhiit.portailsuiviformation.controller.exception;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException() {
        super();
    }

    public EmailExistsException(String message) {
        super(message);
    }
}
