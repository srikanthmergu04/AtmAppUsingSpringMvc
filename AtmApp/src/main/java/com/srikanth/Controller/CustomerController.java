package com.srikanth.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.srikanth.Model.Customer;
import com.srikanth.Service.Impl.CustomerServiceImplimentation;



@Controller
public class CustomerController {
	
	@Autowired
	CustomerServiceImplimentation service;
	
	@RequestMapping("/CreateAccount")
	public String registerStudents(Model model)
	{
		//System.out.println("service obj = "+service);
		
		model.addAttribute("customer", new Customer());

		return "RegisterCustomer.jsp";
	
		
	}
	
	@RequestMapping(value="/registerSuccess", method=RequestMethod.POST)
	public String registerSuccess(@ModelAttribute("customer") Customer customer) {
		
	
		
		//System.out.println(customer.getName());
		//System.out.println(customer.getCity());
		
		service.addCustomer(customer);
		
		return "redirect:/listStudents";
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

}
