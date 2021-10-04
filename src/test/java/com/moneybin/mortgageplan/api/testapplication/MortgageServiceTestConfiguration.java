package com.moneybin.mortgageplan.api.testapplication;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.moneybin.mortgageplan.api.service.MortgageService;

@Profile("test")
@Configuration
public class MortgageServiceTestConfiguration {

	@Bean
	@Primary
	public MortgageService mortgageService()
	{
		return Mockito.mock(MortgageService.class);
	}
}
