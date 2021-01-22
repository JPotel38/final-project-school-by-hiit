package fr.schoolbyhiit.portailsuiviformation.service;

import java.util.Optional;

public interface GreetingService {

    Optional<String> findNameByUserId(long id);
}
