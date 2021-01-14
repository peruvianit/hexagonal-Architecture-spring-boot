package io.peruvianit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
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
public class WebApplication extends SpringBootServletInitializer  {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
