package com.examples.spring.web.rest;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.examples.spring.web.rest.exception.LoginException;
import com.examples.spring.web.rest.model.Login;


@RestController
public class LoginController {

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ExceptionHandler(LoginException.class)
	public HttpEntity<Login> authenticate(@RequestBody Login login) {
		
		if(login.getUserName().equalsIgnoreCase("admin") && login.getPassword().equalsIgnoreCase("admin@123"))
		{
			return new ResponseEntity<Login>(HttpStatus.OK);
		}
		else
		{
//			throw new LoginException("Invalid User or Password");
			return new ResponseEntity<Login>(HttpStatus.FORBIDDEN);
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public HttpEntity<String> logout(HttpSession session, SessionStatus sessionStatus)
	{		
		sessionStatus.setComplete();
		
//		session.removeAttribute("userName");		
//		session.invalidate();
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}