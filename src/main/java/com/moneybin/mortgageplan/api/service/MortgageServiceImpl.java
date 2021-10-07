package com.moneybin.mortgageplan.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.moneybin.mortgageplan.api.dao.MortgageRepository;
import com.moneybin.mortgageplan.api.model.Mortgage;

@Service
@Validated
public class MortgageServiceImpl implements MortgageService  {

	@Autowired
	private MortgageRepository repo;

	// List all the Mortgage Plans

	@Override
	public List<Mortgage> ListAllMortgages() {
		return repo.findAll();
	}
	
	@Override
	public Mortgage createMortgagePlan(@Valid Mortgage mp) throws Exception {
		calculateMonthlyPayment(mp);
		repo.save(mp);
		return mp;
	}

	// Calculate Monthly Payment for the given Mortgage Plan
	// Mortgage formula:
	// =================
	//	E = Fixed monthly payment
	//	b = Interest on a monthly basis
	//	U = Total loan
	//	p = Number of payments
	//  E = U[b(1 + b)^p]/[(1 + b)^p - 1]

		
	public Mortgage calculateMonthlyPayment(@Valid Mortgage cs) {

		double b = ((cs.getInterest_Rate() / 100) / 12);      //Calculate Interest on a monthly basis 
		double U = cs.getTotal_Loan_Amount();                 //Total loan amount received in input
		int p = cs.getYears() * 12;                           //Calculate Number of Payments

		//Calculate (1 + b)^p part -> x 
		double x = 1;
		while (p > 0) {
			x *= (1 + b);
			p--;
		}
		
		double monthlyPayment = U * ((b * x) / (x - 1));      // Calculate E = U[b(1 + b)^p]/[(1 + b)^p - 1]
		
		cs.setFixed_Monthly_Payment_Amount(monthlyPayment);
		return cs;

	}



}
