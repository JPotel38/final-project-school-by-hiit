package fr.schoolbyhiit.portailsuiviformation;

import fr.schoolbyhiit.portailsuiviformation.service.impl.ReportServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class PortailDeSuiviDeFormationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortailDeSuiviDeFormationApplication.class, args);
	}
}
