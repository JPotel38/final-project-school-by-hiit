package fr.schoolbyhiit.portailsuiviformation.jwt;

import lombok.Data;

@Data
public class UsernameAndPasswordAuthentication {
    private String username;
    private String password;
}
