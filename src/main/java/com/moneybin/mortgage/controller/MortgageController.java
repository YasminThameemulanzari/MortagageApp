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
	
	//List all the Mortgage Plans
	@GetMapping("/mortgages")
	public List<Mortgage> list()
	{
		return service.ListAllMortgages();
	}
	
	//Fetch the existing mortgage plan for the given Customer_ID
	@GetMapping("/mortgages/{customer_Id}")
	public ResponseEntity<Mortgage> get(@PathVariable Integer customer_Id )
	{
		try
		{
			Mortgage mortgage = service.getMortgage(customer_Id);
			return new ResponseEntity<Mortgage>(mortgage, HttpStatus.OK);
		}catch (NoSuchElementException e)
		{
			return new ResponseEntity<Mortgage>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Add new Mortgage Plan 
	@PostMapping("/mortgages")
	public Mortgage add(@RequestBody Mortgage mortgage)
	{
	     //System.out.println("mortgage in Controller is: " +mortgage);
		
		return service.saveMortgagePlan(mortgage);
	}
	
	//Update the existing mortgage plan for the given customer_ID
	@PutMapping("/mortgages/{customer_Id}")
	public void update(@RequestBody Mortgage mortgage, @PathVariable Integer customer_Id)
	{
		
		service.saveMortgagePlan(mortgage);
	}
	
	//Delete the existing mortgage plan for the given customer_ID
	@DeleteMapping("/mortgages/{customer_Id}")
	public void delete(@PathVariable Integer customer_Id)
	{
		service.deleteMortgage(customer_Id);
	}
}


	