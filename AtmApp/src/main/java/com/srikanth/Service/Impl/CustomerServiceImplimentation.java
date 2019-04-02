package com.srikanth.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srikanth.Dao.Impl.CustomerDaoImplimentation;
import com.srikanth.Model.Customer;
import com.srikanth.Service.CustomerService;

@Service
public class CustomerServiceImplimentation implements CustomerService {
	
	@Autowired
	CustomerDaoImplimentation dao;

	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		//System.out.println("dao obj = "+dao);
		
		dao.addCustomer(customer);
				
		return 0;
	}

}
