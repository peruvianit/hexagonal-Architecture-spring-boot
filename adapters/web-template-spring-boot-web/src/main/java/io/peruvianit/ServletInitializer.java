/**
 * 
 */
package io.peruvianit;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		    return application.sources(new Class[] { WebApplication.class });
		  }
		}
