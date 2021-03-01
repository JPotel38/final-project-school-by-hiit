package fr.schoolbyhiit.portailsuiviformation.entity.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Status {

    STUDENT("etudiant"),
    TEACHER("prof"),
    TUTOR("Tuteur");

    @JsonValue
    private final String value;

    Status(String value) {
        this.value = value;
    }

}
