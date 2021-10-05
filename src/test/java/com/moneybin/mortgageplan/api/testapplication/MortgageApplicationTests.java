package com.moneybin.mortgageplan.api.testapplication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moneybin.mortgageplan.api.controller.HomeController;
import com.moneybin.mortgageplan.api.controller.MortgageController;

@SpringBootTest
class MortgageApplicationTests {

	@Autowired
	private HomeController homeController;

	@Autowired
	private MortgageController mortgageController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void homeControllerLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}

	@Test
	public void mortgageControllerLoads() throws Exception {
		assertThat(mortgageController).isNotNull();
	}

}