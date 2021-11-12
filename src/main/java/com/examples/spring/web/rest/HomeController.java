package com.examples.spring.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@Autowired
	Environment env;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Welcome to Employee Management Service! Developer=>"+env.getProperty("developer")
		+" Broswer=>"+env.getProperty("browser");
	}
	
}
