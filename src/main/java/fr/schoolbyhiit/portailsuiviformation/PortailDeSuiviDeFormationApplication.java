package fr.schoolbyhiit.portailsuiviformation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class PortailDeSuiviDeFormationApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortailDeSuiviDeFormationApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(PortailDeSuiviDeFormationApplication.class, args);
            LOGGER.info("Application Started !");
        } catch (Exception e) {
            LOGGER.info("Application Failed to Start !");
        }
    }
}
