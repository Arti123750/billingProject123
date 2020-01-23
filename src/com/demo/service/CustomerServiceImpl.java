package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.demo.dao.CustomerDao;
import com.demo.model.Customer;




@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public List<Customer> listcustomerss() {
		return customerDao.listcustomerss();
	}

	public Customer getcustomer(Long customer_mobileno) {
		return customerDao.getcustomer(customer_mobileno);
	}
	
	public void deletecustomer(Customer customer) {
		customerDao.deletecustomer(customer);
	}











}
