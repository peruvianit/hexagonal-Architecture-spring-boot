package io.peruvianit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import it.peruvanit.config.ApplicationConfig;
import it.peruvanit.config.CacheConfig;
import it.peruvanit.config.WebConfiguration;

@SpringBootApplication
@Import({
	ApplicationConfig.class, 
	WebConfiguration.class,
	CacheConfig.class
	})
public class WebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
}
