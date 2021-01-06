package it.peruvanit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("io.peruvianit.web")
public class WebConfiguration implements WebMvcConfigurer{

	
}
