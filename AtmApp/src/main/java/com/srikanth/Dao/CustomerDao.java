package com.srikanth.Dao;

import com.srikanth.Model.Customer;

public interface CustomerDao {
	
	public int addCustomer(Customer customer);
	
	public Customer getBalByAcNumber(int acno);

}
