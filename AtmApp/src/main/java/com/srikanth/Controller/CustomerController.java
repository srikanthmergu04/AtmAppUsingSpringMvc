package com.srikanth.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.srikanth.Model.Customer;
import com.srikanth.Service.Impl.CustomerServiceImplimentation;




@Controller
public class CustomerController {
	
	@Autowired
	CustomerServiceImplimentation service;
	
	@RequestMapping("/CreateAccount")
	public ModelAndView registerStudents(Model model)
	{
		//System.out.println("service obj = "+service);
		
		//model.addAttribute("customer", new Customer());
		ModelAndView m = new ModelAndView();

		m.addObject("customer", new Customer());
		
		m.setViewName("RegisterCustomer.jsp");
		
		return m;
	
		
	}
	
	@RequestMapping(value="/registerSuccess", method=RequestMethod.POST)
	public String registerSuccess(@ModelAttribute("customer") Customer customer , Model model ) {
		
	
		
		//System.out.println(customer.getName());
		//System.out.println(customer.getCity());
		
		service.addCustomer(customer);
		
		model.addAttribute("customer", customer);
		
		
		return "DisplayAcDetails.jsp";
	}
	
	
	@RequestMapping("/BalanceEnquiry")
	public String balanceEnquiry(HttpServletRequest req , Model model)
	{
		int id = Integer.parseInt(req.getParameter("acno"));
		System.out.println("id = "+id);
		
		Customer customer = service.getBalByAcNumber(id);

		model.addAttribute("customer", customer);
		//System.out.println("balance = "+customer.getBalance());
		
		return "ShowBalance.jsp";
		
	}
	
	
	@RequestMapping("/VerifyCustomer")
	public String verifyCustomer(HttpServletRequest req , Model model)
	{
		int acno = Integer.parseInt(req.getParameter("acno"));
		System.out.println("id = "+acno);
		
		int pin = Integer.parseInt(req.getParameter("pin"));
		System.out.println("pin = "+pin);
		
		int amount = Integer.parseInt(req.getParameter("amount"));
		System.out.println("amount = "+amount);
		
				
		boolean status = service.verifyCustomer(acno, pin);
		
		if(status == true)
		{
			int remAmount = service.withdraw(amount , acno);
			
			if(remAmount == -1)
			{
				return "errorBalance.jsp";
			}
			else
			{
				model.addAttribute("balance", remAmount);
				return "DisplayBal.jsp";
				
			}
			
		}
		else
		{
			return "errorPin.jsp";
		}
		
		
		
	}
	
	@RequestMapping("/deposit")
	public String deposit(HttpServletRequest req)
	{
		
		int acno = Integer.parseInt(req.getParameter("acno"));
		System.out.println("id = "+acno);

		int amount = Integer.parseInt(req.getParameter("amount"));
		System.out.println("amount = "+amount);
		
		service.deposit(acno, amount);
		
		
		
		return "depositsuccess.jsp";
		
	}
	
	@RequestMapping("/fundTranser")
	public String fundTranser(HttpServletRequest req , Model model)
	{
		int acno1 = Integer.parseInt(req.getParameter("acno1"));
		System.out.println("acNo1 = "+acno1);
		
		int pin = Integer.parseInt(req.getParameter("pin"));
		System.out.println("pin = "+pin);
		
		int amount = Integer.parseInt(req.getParameter("amount"));
		System.out.println("amount = "+amount);
		
		int acno2 = Integer.parseInt(req.getParameter("acno2"));
		System.out.println("acNO2 = "+acno2);
		
	boolean status = service.verifyCustomer(acno1, pin);
		
		if(status == true)
		{
			int remAmount = service.withdraw(amount , acno1);
			
			if(remAmount == -1)
			{
				return "errorBal.jsp";
			}
			else
			{
				
				model.addAttribute("balance", remAmount);
				
				service.deposit(acno2, amount);
				return "DisplayBal.jsp";
				
			}
			
		}
		else
		{
			return "errorpassword.jsp";
		}
		
		
	
	}
	
	@RequestMapping("/customerList")
	public String getCustomerList(Model model)
	{
		
		List<Customer> list = new ArrayList();
		
		list = service.listAllCustomers();
		
		model.addAttribute("list", list);
		
		return "CustomerDetails.jsp";
		
	}
	
	@RequestMapping("/addBeneficiary")
	public String addBeneficiary(HttpServletRequest req , Model model)
	{
		int acNo1 = Integer.parseInt(req.getParameter("acNo1"));
		int acNo2 = Integer.parseInt(req.getParameter("acNo2"));
		
		System.out.println("acNO1 =  "+acNo1+"  acNO2 = "+acNo2);
		
		service.addBeneficiary(acNo1, acNo2);
		
		return "beneficiarysuccess.jsp";
		
	}
	
	@RequestMapping("/showBeneficiaryList")
	public String showBeneficiaryList(HttpServletRequest req , Model m)
	{
		int acNo = Integer.parseInt(req.getParameter("acNo"));
		
		System.out.println("acNO = "+acNo);
		
		
		
		Customer customer = service.showBeneficiaryList(acNo);
		
		List<Customer> list = customer.getBeneficiary();
		
		int acNum = customer.getAcNo();
		
		m.addAttribute("acNum", acNum);
		
		m.addAttribute("BeneficiaryList", list);
		
		/*
		
		for (Customer customer2 : customer) {
			
			System.out.println(customer2.getAcNo()+" :*: "+customer2.getName());
		}
		
		*/
		
		
		
		return "displayBeneficiaryList.jsp";
			
	}
	


}
