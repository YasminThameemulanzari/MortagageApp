package com.moneybin.mortgageplan.api.testapplication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moneybin.mortgageplan.api.dao.MortgageRepository;
import com.moneybin.mortgageplan.api.model.Mortgage;
import com.moneybin.mortgageplan.api.service.MortgageService;

@SpringBootTest
public class MortgageServiceTests {

	  @Autowired
	  MortgageService service;
	   
	  @Mock
	  MortgageRepository dao;

	  @Test
	  public void testGetFixed_Monthly_Payment_Amount() throws Exception {
		  Mortgage mg = new Mortgage();
		  mg.setCustomer_Name("Thameem");
		  mg.setTotal_Loan_Amount(100000);
		  mg.setInterest_Rate(5);
		  mg.setYears(5);
		  Mortgage result = service.createMortgagePlan(mg);
		  double actual = result.getFixed_Monthly_Payment_Amount();
		  double expected = 1887.1233644010988;
		  assertThat(actual).isEqualTo(expected);
	  }
}
