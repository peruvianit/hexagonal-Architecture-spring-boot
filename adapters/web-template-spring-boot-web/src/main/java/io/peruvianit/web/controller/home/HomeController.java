package io.peruvianit.web.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.peruvanit.config.ApplicationConfig;

@Controller
@RequestMapping(HomeController.URL_BASE)
public class HomeController{
	
	@Autowired
	private ApplicationConfig conf;
	
	/**
	 * BaseRequest URL di input
	 */
	public static final String URL_BASE = "/private/";

	/**
	 * Viste di output
	 */
	public static final String VIEW_HOME = "/home/home";

	@GetMapping({ "", URL_BASE })
	public String home(Model model) {
		model.addAttribute("prop", conf.getApp().getCode());
		return VIEW_HOME;
	}	
}
