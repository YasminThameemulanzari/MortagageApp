package com.moneybin.mortgage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mortgage {

	private int Customer_ID;
	private String Customer_Name;
	private double Total_Loan_Amount;
	private double Interest_Rate;
	private int Years;
	private double Fixed_Monthly_Payment_Amount;

	public Mortgage() {
	}

	public Mortgage(int customer_Id, String customer_name, double total_loan_amount, double interest_rate,
			int years, double fixed_monthly_payment_amount) {
		super();
		Customer_ID = customer_Id;
		Customer_Name = customer_name;
		Total_Loan_Amount = total_loan_amount;
		Interest_Rate = interest_rate;
		Years = years;
		Fixed_Monthly_Payment_Amount = fixed_monthly_payment_amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public double getTotal_Loan_Amount() {
		return Total_Loan_Amount;
	}

	public void setTotal_Loan_Amount(double total_Loan_Amount) {
		Total_Loan_Amount = total_Loan_Amount;
	}

	public double getInterest_Rate() {
		return Interest_Rate;
	}

	public void setInterest_Rate(double interest_Rate) {
		Interest_Rate = interest_Rate;
	}

	public int getYears() {
		return Years;
	}

	public void setYears(int years) {
		Years = years;
	}

	public double getFixed_Monthly_Payment_Amount() {
		return Fixed_Monthly_Payment_Amount;
	}

	public void setFixed_Monthly_Payment_Amount(double fixed_Monthly_Payment_Amount) {
		Fixed_Monthly_Payment_Amount = fixed_Monthly_Payment_Amount;
	}

	public String toString() {
		return "Mortgage [Customer_ID=" + Customer_ID + ", Customer_Name=" + Customer_Name + ", Total_Loan_Amount="
				+ Total_Loan_Amount + ", Interest_Rate=" + Interest_Rate + ", Years=" + Years
				+ ", Fixed_Monthly_Payment_Amount=" + Fixed_Monthly_Payment_Amount + "]";
	}

	
}