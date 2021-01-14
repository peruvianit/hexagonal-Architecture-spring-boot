package io.peruvianit.sample.ehcache.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.peruvianit.sample.ehcache.service.EhcacheService;

@RestController
@RequestMapping(EhcaheController.URL_BASE)
public class EhcaheController{
	
	@Autowired
	EhcacheService ecache;
	/**
	 * BaseRequest URL di input
	 */
	public static final String URL_BASE = "/ehcache/";

	@GetMapping({ "", URL_BASE })
	public String home() {
		BigDecimal valore =  ecache.square(2L);
		return "Il valore di ritorno è : " + valore.toString();
	}
	
	
}
