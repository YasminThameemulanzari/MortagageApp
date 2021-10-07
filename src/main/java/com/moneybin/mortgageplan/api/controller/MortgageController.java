package com.moneybin.mortgageplan.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moneybin.mortgageplan.api.model.Mortgage;
import com.moneybin.mortgageplan.api.service.MortgageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Validated
public class MortgageController {

	@Autowired
	MortgageService service;

	@ApiOperation(value = "View list of available mortgages", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved the mortgages list") })
	@GetMapping(value = "/mortgages", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Mortgage> list() {
		return service.ListAllMortgages();
	}

	@ApiOperation(value = "Calculate Monthly Payment for the given Mortgage", response = Iterable.class)
	@ApiResponses(value = 
		{ @ApiResponse(code = 200, message = "Mortgage Plan is successfully created"),
		  @ApiResponse(code = 400, message = "Input validation failed!") })
	@PostMapping(value = "/calculateMonthlyPayment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mortgage calculateMonthlyPayment(@Valid @RequestBody Mortgage mortgage) throws Exception {
		return this.service.createMortgagePlan(mortgage);
	}

}
