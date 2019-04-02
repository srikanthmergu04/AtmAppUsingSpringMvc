package com.srikanth.Dao;

import com.srikanth.Model.Customer;

public interface CustomerDao {
	
	public int addCustomer(Customer customer);
	
	public Customer getBalByAcNumber(int acno);
	
	public int withdraw(int amount , int acno);
	
	public Customer verifyCustomer(int acno);
	
	public void deposit(int acno , int amount);

}
