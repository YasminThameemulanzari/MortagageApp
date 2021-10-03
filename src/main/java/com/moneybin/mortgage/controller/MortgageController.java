package com.moneybin.mortgage.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneybin.mortgage.model.Mortgage;
import com.moneybin.mortgage.service.MortgageService;

@RestController
public class MortgageController {

	@Autowired
	private MortgageService service;

	// List all the Mortgage Plans
	@GetMapping("/mortgages")
	public List<Mortgage> list() {
		return service.ListAllMortgages();
	}

	// Calculate Monthly Payment for the given Mortgage Plan
	@PostMapping("/mortgages")
	public Mortgage calculateMonthlyPayment(@RequestBody Mortgage mortgage) {

		return service.createMortgagePlan(mortgage);
	}

}
