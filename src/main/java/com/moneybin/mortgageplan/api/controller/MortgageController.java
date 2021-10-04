package com.moneybin.mortgageplan.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneybin.mortgageplan.api.model.Mortgage;
import com.moneybin.mortgageplan.api.service.MortgageService;

@RestController
public class MortgageController {

	@Autowired
	private MortgageService service;

	// List all the Mortgage Plans
	@GetMapping(value = "/mortgages", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Mortgage> list() {
		return service.ListAllMortgages();
	}

	// Calculate Monthly Payment for the given Mortgage  
	@PostMapping(value = "/mortgages", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mortgage calculateMonthlyPayment(@RequestBody Mortgage mortgage) throws Exception{


		return this.service.createMortgagePlan(mortgage);
		//this.service.createMortgagePlan(mortgage);
		//System.out.println(mortgage);
		//return(mortgage);
	}

}
