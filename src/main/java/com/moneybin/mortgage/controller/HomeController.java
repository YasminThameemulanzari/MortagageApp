package com.moneybin.mortgage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//Re-direct to home page
	@RequestMapping("/home")
	public String home()
	{
		return ("home.jsp");
	}
	
}
