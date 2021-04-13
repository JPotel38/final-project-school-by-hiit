package fr.schoolbyhiit.portailsuiviformation.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum RoleName {

    ADMIN("Administrateur"),
    STUDENT("Etudiant"),
    TEACHER("Professeur"),
    TUTOR("Tuteur");

    @JsonValue
    private final String value;

    RoleName(String value) {
        this.value = value;
    }

}
