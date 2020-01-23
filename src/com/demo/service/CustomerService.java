package com.demo.service;

import java.util.List;


import com.demo.model.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer customer);

	public List<Customer> listcustomerss();
	
	public Customer getcustomer(Long customer_mobileno);
	
	public void deletecustomer(Customer customer);
}
