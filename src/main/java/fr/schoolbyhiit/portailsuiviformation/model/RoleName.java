package fr.schoolbyhiit.portailsuiviformation.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum RoleName {

    ADMIN("Admin"),
    STUDENT("Student"),
    TEACHER("Teacher"),
    TUTOR("Tutor");

    @JsonValue
    private final String value;

    RoleName(String value) {
        this.value = value;
    }

}
