package com.moneybin.mortgageplan.api.service;

import java.util.List;

import javax.validation.Valid;

import com.moneybin.mortgageplan.api.model.Mortgage;

public interface MortgageService {

	public abstract List<Mortgage> ListAllMortgages();

	public abstract Mortgage createMortgagePlan(@Valid Mortgage mp) throws Exception;
}
