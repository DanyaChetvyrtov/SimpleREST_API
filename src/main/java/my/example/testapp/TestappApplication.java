package my.example.testapp;

import my.example.testapp.run.Location;
import my.example.testapp.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class TestappApplication {

	private static final Logger log = LoggerFactory.getLogger(TestappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestappApplication.class, args);

		log.info("Something's been changed");
	}


	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "First Run",
					LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS),
					5, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}
}
