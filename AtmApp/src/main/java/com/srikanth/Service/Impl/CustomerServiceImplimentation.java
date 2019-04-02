package com.srikanth.Service.Impl;

import java.util.ArrayList;
import java.util.List;

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

	public Customer getBalByAcNumber(int acno) {
		// TODO Auto-generated method stub
		
		Customer customer = dao.getBalByAcNumber(acno);
		
		return customer;
	}

	public int withdraw(int amount , int acno) {
		// TODO Auto-generated method stub
		
		Customer customer = dao.getBalByAcNumber(acno);
		System.out.println("Balance Availble = "+customer.getBalance());
		
		if(amount > customer.getBalance())
		{
			return -1;
		}
		else
		{
			int rem = dao.withdraw(amount , acno);
			return rem;
		}
		
		//int customer = dao.withdraw(amount);
		
		
		
	//	if(amount < )
		
		
		
	}

	public boolean verifyCustomer(int acno, int pin) {
		// TODO Auto-generated method stub
		
		Customer customer = dao.verifyCustomer(acno);
		
		if(pin != customer.getPin())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public void deposit(int acno, int amount) {
		// TODO Auto-generated method stub
		
		dao.deposit(acno, amount);
		
	}

	public List<Customer> listAllCustomers() {
		// TODO Auto-generated method stub
		
	List<Customer> list = new ArrayList();
		
		list = dao.listAllCustomers();
		
		return list;
		
	}

}
