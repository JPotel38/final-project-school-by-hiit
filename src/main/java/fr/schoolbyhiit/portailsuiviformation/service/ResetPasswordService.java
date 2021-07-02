package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dao.UserRepository;
import fr.schoolbyhiit.portailsuiviformation.exception.InvalidPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResetPasswordService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void changePassword(String username, String currentPassword, String newPassword) {
        userRepository.getUserByMail(username)
            .ifPresent(user -> {
                String currentPasswordEncoder = user.getPassword();
                if (!passwordEncoder.matches(currentPassword, currentPasswordEncoder)) {
                    throw new InvalidPasswordException();
                }
                String newPasswordencode = passwordEncoder.encode(newPassword);
                user.setPassword(newPasswordencode);
                userRepository.save(user);
            });
    }
}
