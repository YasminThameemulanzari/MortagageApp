package com.moneybin.mortgageplan.api.testapplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moneybin.mortgageplan.api.controller.MortgageController;
import com.moneybin.mortgageplan.api.model.Mortgage;
import com.moneybin.mortgageplan.api.service.MortgageService;

@WebMvcTest(MortgageController.class)
public class MortgageControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean                           
	private MortgageService service;
	
	@Test
	public void testGetMortgages() throws Exception {
		this.mockMvc.perform(get("/mortgages")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testCalculateMonthlyPayment() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		Mortgage mortgage = new Mortgage();

		mortgage.setCustomer_Name("Balu");
		mortgage.setInterest_Rate(3.14);
		mortgage.setTotal_Loan_Amount(10000);
		mortgage.setYears(5);
		
		String jsonMortgage = mapper.writeValueAsString(mortgage);
		
		mortgage.setFixed_Monthly_Payment_Amount(1000.50);
		
		Mockito.when(service.createMortgagePlan(any(Mortgage.class)))
        .thenReturn(mortgage);

		MvcResult result = mockMvc
							.perform(post("/calculateMonthlyPayment")
							.content(jsonMortgage)
							.contentType(MediaType.APPLICATION_JSON_VALUE))
							.andExpect(status().isOk()).andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		
		Mortgage resultMortgage = mapper.readValue(resultContent, Mortgage.class);

		assertThat(mortgage.getFixed_Monthly_Payment_Amount()).isEqualTo(resultMortgage.getFixed_Monthly_Payment_Amount());

	}

}
