package com.srikanth.Dao;

import java.util.List;

import com.srikanth.Model.Customer;


public interface CustomerDao {
	
	public int addCustomer(Customer customer);
	
	public Customer getBalByAcNumber(int acno);
	
	public int withdraw(int amount , int acno);
	
	public Customer verifyCustomer(int acno);
	
	public void deposit(int acno , int amount);
	
	public List<Customer> listAllCustomers();
	
	public void addBeneficiary(int acNo1 , int acNo2);
	
	public Customer showBeneficiaryList(int acNo);

}
