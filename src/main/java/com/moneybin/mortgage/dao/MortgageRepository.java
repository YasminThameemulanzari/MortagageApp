package com.moneybin.mortgage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moneybin.mortgage.model.Mortgage;

public interface MortgageRepository extends JpaRepository <Mortgage, Integer>{

}
