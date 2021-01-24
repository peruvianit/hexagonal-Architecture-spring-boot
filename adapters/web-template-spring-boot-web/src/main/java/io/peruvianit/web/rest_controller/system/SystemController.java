package io.peruvianit.web.rest_controller.system;

import java.time.Instant;
import java.util.Properties;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

@RestController
@RequestMapping(SystemController.URL_BASE)
@Validated
public class SystemController{
	
	@Autowired
    private BuildProperties buildProperties;
	
	@Autowired
	private GitProperties gitProperties;
	
	public static final String URL_BASE = "/version";

	@GetMapping({"/{tipoInfo}"})
    public Properties version(@PathVariable @NotNull @Pattern(regexp = "^(app|git)$") String tipoInfo) {
        Properties prop = new Properties();
        
        switch (tipoInfo) {
		case "app":
			buildProperties.forEach(entry -> prop.put(entry.getKey(),entry.getValue()));
	        prop.put("time", Instant.ofEpochMilli(Long.parseLong(prop.getProperty("time"))).toString());
			break;
		case "git":
			gitProperties.forEach(entry -> prop.put(entry.getKey(),entry.getValue()));
			break;
		default:
			break;
		}
        
        return prop;
    }
	
}
