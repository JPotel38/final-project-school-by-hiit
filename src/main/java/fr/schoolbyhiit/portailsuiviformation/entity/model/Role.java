package fr.schoolbyhiit.portailsuiviformation.entity.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Role {

    STUDENT("Etudiant"),
    TEACHER("Professeur"),
    TUTOR("Tuteur");

    @JsonValue
    private final String value;

    Role(String value) {
        this.value = value;
    }

}
