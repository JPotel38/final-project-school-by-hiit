package fr.schoolbyhiit.portailsuiviformation.entity.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReportStatus {

    VALIDATED("Validé"),
    NOT_VALIDATED("Non validé");


    @JsonValue
    private final String value;

    ReportStatus(String value) {
        this.value = value;
    }

}
