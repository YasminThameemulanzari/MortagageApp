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
public class MortgageService {

	@Autowired
	private MortgageRepository repo;

	// List all the Mortgage Plans

	public List<Mortgage> ListAllMortgages() {
		return repo.findAll();
	}
	
	public Mortgage createMortgagePlan(@Valid Mortgage mp) throws Exception{
		calculateMonthlyPayment(mp);
		repo.save(mp);
		return mp;
	}

	// Calculate Monthly Payment for the given Mortgage Plan
	public Mortgage calculateMonthlyPayment(@Valid Mortgage cs) {
		System.out.println("Customer_Name:" + cs.getCustomer_Name());
		System.out.println("Years:" + cs.getYears());
		System.out.println("Loan Amount:" + cs.getTotal_Loan_Amount());

		double b = ((cs.getInterest_Rate() / 100) / 12);
		double U = cs.getTotal_Loan_Amount();
		System.out.println("b is: " + b);
		System.out.println("U is: " + U);

		int p = cs.getYears() * 12;
		System.out.println("p is: " + p);
		double x = 1;
		while (p > 0) {
			x *= (1 + b);
			p--;
		}
		double monthlyPayment = U * ((b * x) / (x - 1));
		cs.setFixed_Monthly_Payment_Amount(monthlyPayment);

		System.out.println("Result is: " + monthlyPayment);
		System.out.println("cs is: " + cs);
		return cs;

	}



}
