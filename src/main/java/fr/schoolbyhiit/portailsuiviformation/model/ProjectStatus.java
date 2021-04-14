package fr.schoolbyhiit.portailsuiviformation.model;

import lombok.Getter;

@Getter
public enum ProjectStatus {

    IN_PROGRESS("En cours"),
    DELIVERED("Rendu"),
    CORRECTED("Corrigé");

    private final String status;

    ProjectStatus(String status) {
        this.status = status;
    }

}
