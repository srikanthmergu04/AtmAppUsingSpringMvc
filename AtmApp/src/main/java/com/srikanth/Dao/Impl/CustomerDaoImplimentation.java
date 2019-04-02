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
		
		
		return 0;
	}

}
