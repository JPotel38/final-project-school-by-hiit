package fr.schoolbyhiit.portailsuiviformation.controller;

import com.google.common.base.Strings;
import fr.schoolbyhiit.portailsuiviformation.dao.UserRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.PasswordChangeDto;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.exception.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/reset-password")
public class ResetPasswordController {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public ResetPasswordController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping()
    public void changePassword(@RequestBody PasswordChangeDto passwordChangeDto){
        if (!Strings.isNullOrEmpty(passwordChangeDto.getPassword())){
            this.changePassword(passwordChangeDto.getUsername(),passwordChangeDto.getPassword());
        } else{
            throw new RuntimeException("le mot de passe ne doit pas etre null");
        }

    }
    public void changePassword(String username,String newPassword){
        Optional<User> userByMail = userRepository.getUserByMail(username);
        String newPasswordencode = passwordEncoder.encode(newPassword);
        userByMail.get().setPassword(newPasswordencode);
        userRepository.save(userByMail.get());
    }
}
