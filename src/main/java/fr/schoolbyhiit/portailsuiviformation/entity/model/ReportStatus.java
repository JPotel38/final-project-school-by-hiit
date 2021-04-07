package fr.schoolbyhiit.portailsuiviformation.entity.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReportStatus {

    VALIDATED("Validated"),
    NOT_VALIDATED("Not validated");


    @JsonValue
    private final String value;

    ReportStatus(String value) {
        this.value = value;
    }

}
