package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dao.UserRepository;
import fr.schoolbyhiit.portailsuiviformation.exception.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ResetPasswordService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void changePassword(String username,String currentPassword,String newPassword){
        userRepository.getUserByMail(username)
            .ifPresent(user -> {
                String currentPasswordEncoder= user.getPassword();
                if (!passwordEncoder.matches(currentPassword,currentPasswordEncoder)){
                    throw new InvalidPasswordException();
                }
                String newPasswordencode = passwordEncoder.encode(newPassword);
                user.setPassword(newPasswordencode);
                userRepository.save(user);
            });
    }
}
