package com.srikanth.Dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
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
		
		session.close();
				
		return customer;
	}

	public int withdraw(int amount , int acno) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction trnx  = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, acno);
		
		//Customer cust =  (Customer) session.get(Customer.class, acno);
		//System.out.println("checking first level cache");
		
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
		
		session.close();
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

	public List<Customer> listAllCustomers() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
				
		List<Customer> list = new ArrayList();
				
		Query query = session.createQuery("from Customer");
		
		list = query.list();

				
		session.close();
				
		return list;
		
		}

	public void addBeneficiary(int acNo1, int acNo2) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		Transaction trnx  = session.beginTransaction();
		
		Customer c1 = (Customer) session.get(Customer.class, acNo1);
		
		Customer c2 = (Customer) session.get(Customer.class, acNo2);
		
		List<Customer> list = new ArrayList();
		
		if(c1.getBeneficiary() == null)
		{
			c1.setBeneficiary(list);
		}
		
				
		c1.getBeneficiary().add(c2);
		
		session.update(c1);
		
		trnx.commit();
		
		
		
	}

	public List<Customer> showBeneficiaryList(int acNo) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("from Customer where acNO =  :acNo");
		
		q.setParameter("acNo", acNo);
				
		Customer cs = (Customer) q.uniqueResult();
		
		List<Customer> customer = cs.getBeneficiary();
		
		//Customer cs = l.get(1);
		
	
		/*
		System.out.println(cs.getBeneficiary().get(0).getAcNo()+" :: "+cs.getBeneficiary().get(0).getName());
		System.out.println(cs.getBeneficiary().get(1).getAcNo()+" :: "+cs.getBeneficiary().get(1).getName());
		System.out.println(cs.getBeneficiary().get(2).getAcNo()+" :: "+cs.getBeneficiary().get(2).getName());
		*/
		
		/*
		System.out.println(customer.get(0).getAcNo()+" :: "+customer.get(0).getName());
		System.out.println(customer.get(1).getAcNo()+" :: "+customer.get(1).getName());
		System.out.println(customer.get(2).getAcNo()+" :: "+customer.get(2).getName());
		*/
		
		
		return customer;
		
		
		
		
		
		
		
	}

}
