package com.srikanth.Dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srikanth.Dao.CustomerDao;
import com.srikanth.Model.Customer;

@Repository
public class CustomerDaoImplimentation implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		//System.out.println("sessionFactory obj = "+sessionFactory);
		
		Session session = sessionFactory.openSession();
		
		Transaction trnx = session.beginTransaction();
		
		int primary = (Integer) session.save(customer);
		
		System.out.println("primary = "+primary);
		
		trnx.commit();
		
		session.close();
		
		return primary;
	}

	public Customer getBalByAcNumber(int acno) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		//Transaction trnx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, acno);
				
		return customer;
	}

	public int withdraw(int amount , int acno) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction trnx  = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, acno);
		
		customer.setBalance(customer.getBalance() - amount);
		
		session.update(customer);
		
		trnx.commit();
		
		System.out.println("Bal in dao = "+customer.getBalance());
		int bal = customer.getBalance();
				
		session.close();
		return bal;
	}

	public Customer verifyCustomer(int acno) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, acno);
		
		
		return customer;
	}

	public void deposit(int acno, int amount) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction trnx  = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, acno);
		
		customer.setBalance(customer.getBalance() + amount);
		
		session.update(customer);
		
		trnx.commit();
		session.close();
		
		
	}

}
