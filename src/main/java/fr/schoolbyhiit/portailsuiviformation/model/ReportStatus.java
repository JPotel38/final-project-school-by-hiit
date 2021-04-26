package fr.schoolbyhiit.portailsuiviformation.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ReportStatus {

    VALIDATED("Validated"),
    NOT_VALIDATED("Not validated");


    @JsonValue
    private final String value;

    ReportStatus(String value) {
        this.value = value;
    }

}
