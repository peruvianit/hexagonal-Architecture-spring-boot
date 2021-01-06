package io.peruvianit.web.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(HomeController.URL_BASE)
public class HomeController{
	
	/**
	 * BaseRequest URL di input
	 */
	public static final String URL_BASE = "/private/";

	/**
	 * Viste di output
	 */
	public static final String VIEW_HOME = "/home/home";

	@GetMapping({ "", URL_BASE })
	public String home() {
		return VIEW_HOME;
	}	
}
