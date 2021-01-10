package it.peruvanit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource(value="classpath:web-template-spring-boot.properties", ignoreResourceNotFound=false)
@ConfigurationProperties(prefix = "io.peruvianit")
@Data
public class ApplicationConfig{
	
	private App app;
	
	@Data
	public static class App{
		private String code;
	}
	
}
