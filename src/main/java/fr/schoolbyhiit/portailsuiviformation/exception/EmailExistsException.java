package fr.schoolbyhiit.portailsuiviformation.exception;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException() {
        super();
    }

    public EmailExistsException(String message) {
        super(message);
    }
}
