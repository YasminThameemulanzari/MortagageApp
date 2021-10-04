package com.moneybin.mortgageplan.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moneybin.mortgageplan.api.model.Mortgage;

@Repository
public interface MortgageRepository extends JpaRepository <Mortgage, Integer>{

}
