package fr.schoolbyhiit.portailsuiviformation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.UserNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.dto.GreetingDto;
import fr.schoolbyhiit.portailsuiviformation.service.GreetingService;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public GreetingDto greeting(@RequestParam(defaultValue = "World") String name) {
        return new GreetingDto(String.format(template, name));
    }

    @GetMapping("/greeting/{id}")
    public GreetingDto greeting(@PathVariable long id) {
        return greetingService.findNameByUserId(id)
                .map(name -> new GreetingDto(String.format(template, name)))
                .orElseThrow(() -> new UserNotFoundException());
    }

}
