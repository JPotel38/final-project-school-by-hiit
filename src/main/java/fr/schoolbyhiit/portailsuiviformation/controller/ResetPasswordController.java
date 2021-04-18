package fr.schoolbyhiit.portailsuiviformation.controller;

import com.google.common.base.Strings;
import fr.schoolbyhiit.portailsuiviformation.dto.PasswordChangeDto;
import fr.schoolbyhiit.portailsuiviformation.service.ResetPasswordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-password")
public class ResetPasswordController {
    private final ResetPasswordService resetPasswordService;

    public ResetPasswordController(ResetPasswordService resetPasswordService) {
        this.resetPasswordService = resetPasswordService;
    }

    @PostMapping()
    public void changePassword(@RequestBody PasswordChangeDto passwordChangeDto){
        if (!Strings.isNullOrEmpty(passwordChangeDto.getNewPassword())){
            resetPasswordService.changePassword(passwordChangeDto.getUsername(),
                passwordChangeDto.getCurrentPassword(), passwordChangeDto.getNewPassword());
        }

    }
}
