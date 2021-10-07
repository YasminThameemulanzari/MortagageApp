package com.moneybin.mortgageplan.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Prospects {

	//Re-direct to home page
	@RequestMapping("/prospects")
	public String home()
	{
		return ("prospects.jsp");
	}
	
}
