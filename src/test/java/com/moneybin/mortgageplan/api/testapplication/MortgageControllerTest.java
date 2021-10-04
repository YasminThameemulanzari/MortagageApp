package com.moneybin.mortgageplan.api.testapplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moneybin.mortgageplan.api.controller.MortgageController;
import com.moneybin.mortgageplan.api.dao.MortgageRepository;
import com.moneybin.mortgageplan.api.model.Mortgage;
import com.moneybin.mortgageplan.api.service.MortgageService;

//@RunWith(SpringRunner.class)
@WebMvcTest(MortgageController.class)
//@AutoConfigureMockMvc
//@SpringBootTest
public class MortgageControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	//@InjectMocks
	@MockBean
	private MortgageService mortgageService = new MortgageService();
	

	@InjectMocks
	private MortgageController controller;
	
	//@InjectMocks
	//private MortgageRepository repo;

   
	@BeforeEach
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testPost() throws Exception {
		Mortgage mortgage = new Mortgage();

		mortgage.setCustomer_Name("Balu");
		mortgage.setInterest_Rate(3.14);
		mortgage.setTotal_Loan_Amount(98500.5);
		mortgage.setYears(5);

		String jsonMortgage = om.writeValueAsString(mortgage);

		MvcResult result = mockMvc
				.perform(post("/mortgages").content(jsonMortgage).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();

		assertThat(status().isOk());

	}

}
