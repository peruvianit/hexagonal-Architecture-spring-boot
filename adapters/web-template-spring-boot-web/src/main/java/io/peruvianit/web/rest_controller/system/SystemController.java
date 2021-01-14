package io.peruvianit.web.rest_controller.system;

import java.time.Instant;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SystemController.URL_BASE)
public class SystemController{
	
	@Autowired
    private BuildProperties buildProperties;
	
	@Autowired
	private GitProperties gitProperties;
	
	public static final String URL_BASE = "/version";
	
	public static final String URL_APP_INFO = "/app";
	public static final String URL_GIT_INFO = "/git";

	@GetMapping(URL_APP_INFO)
    public Properties getInfo() {
        Properties prop = new Properties();
        buildProperties.forEach(entry -> prop.put(entry.getKey(),entry.getValue()));
        //proper date formatting for time
        prop.put("time", Instant.ofEpochMilli(Long.parseLong(prop.getProperty("time"))).toString());
        return prop;
    }
	
	@GetMapping(URL_GIT_INFO)
	public Properties gitInfo() {
		Properties prop = new Properties();
		gitProperties.forEach(entry -> prop.put(entry.getKey(),entry.getValue()));
        return prop;
	}
	
}
