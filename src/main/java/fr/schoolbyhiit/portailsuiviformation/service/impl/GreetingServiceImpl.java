package fr.schoolbyhiit.portailsuiviformation.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.schoolbyhiit.portailsuiviformation.dao.UserRepository;
import fr.schoolbyhiit.portailsuiviformation.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final UserRepository userRepository;

    public GreetingServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<String> findNameByUserId(long id) {
        return userRepository.findNameById(id);
    }
}
