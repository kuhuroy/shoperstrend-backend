package com.niit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	public CustomerDao customerDao;
	
	
	
	

	public CustomerServiceImpl() {
		System.out.println("customer service bean is created...");
	}
	
	@Autowired
	public void registerCustomer(Customer customer) {
		customerDao.registerCustomer(customer);
	}
	
}
