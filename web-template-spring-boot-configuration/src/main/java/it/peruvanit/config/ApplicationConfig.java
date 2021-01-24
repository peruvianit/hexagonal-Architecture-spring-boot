package it.peruvanit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.Data;

@Configuration
@PropertySources({
	@PropertySource(value = {"file:${catalina.home}/conf/web-template-spring-boot.properties"}, ignoreResourceNotFound = true),
	@PropertySource(value="classpath:web-template-spring-boot.properties", ignoreResourceNotFound=true)
})
@ConfigurationProperties(prefix = "io.peruvianit")
@Data
public class ApplicationConfig{
	
	private App app;
	
	@Data
	public static class App{
		private String code;
	}
	
}
