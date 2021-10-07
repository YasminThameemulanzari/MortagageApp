package com.moneybin.mortgageplan.api.testapplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.moneybin.mortgageplan.api.controller.HomeController;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnWebInterface() throws Exception {
		this.mockMvc.perform(get("/home")).andDo(print()).andExpect(status().isOk());
	}
}
