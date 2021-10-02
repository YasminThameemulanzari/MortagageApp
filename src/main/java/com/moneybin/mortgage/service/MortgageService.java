package com.moneybin.mortgage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneybin.mortgage.dao.MortgageRepository;
import com.moneybin.mortgage.model.Mortgage;


@Service
public class MortgageService {

	@Autowired
	private MortgageRepository repo;

	//List all the Mortgage Plans
	
	public List<Mortgage> ListAllMortgages()
	{
		return repo.findAll();
	}
	
	//Add new Mortgage Plan 
	
	public void saveMortgagePlan(Mortgage cs)
	{
		repo.save(cs);
	}
	
	//Fetch the existing Mortgage Plan for the given Customer_ID
	
	public Mortgage getMortgage(Integer Customer_ID)
	{
		return repo.getById(Customer_ID);
	}
	
	//Delete the existing Mortgage Plan for the given Customer_ID
	
	public void deleteMortgage(Integer Customer_ID)
	{
		repo.deleteById(Customer_ID);
	}
}
	
