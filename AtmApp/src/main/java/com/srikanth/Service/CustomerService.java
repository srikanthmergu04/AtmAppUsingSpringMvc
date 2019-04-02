package com.srikanth.Service;

import com.srikanth.Model.Customer;

public interface CustomerService {
	
	public int addCustomer(Customer customer);
	
	public Customer getBalByAcNumber(int acno);

}
