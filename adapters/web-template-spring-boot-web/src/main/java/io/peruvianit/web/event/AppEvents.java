/**
 * 
 */
package io.peruvianit.web.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import io.peruvianit.WebApplication;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
@Component
@PropertySource(value = {"classpath:git.properties"}, ignoreResourceNotFound = true)
public class AppEvents {
	private static final Logger log = LogManager.getLogger(WebApplication.class);
	  
	@Autowired
	Environment env;
	
	@EventListener({ApplicationReadyEvent.class})
	public void onApplicationReady() {
		log.info("CommitId: {}", this.env.getProperty("git.commit.id.describe", ""));
	}
}
