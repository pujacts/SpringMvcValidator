package com.validator.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.validator.vo.Customer;

@Controller
public class CustomerController {

private Map<String, Customer> customers = null;
	
	public CustomerController(){
		customers = new HashMap<String, Customer>();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cust/save")
	public String saveCustomerPage(Model model)
	{
		model.addAttribute("customer", new Customer());
		return "custSave";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cust/save")
	public String saveCustomerAction(@Valid Customer customer,BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "custSave";
		}
		
		model.addAttribute("customer", customer);
		//customers.put(customer.getEmail(), customer);
		return "custSaveSuccess";
	}
}
