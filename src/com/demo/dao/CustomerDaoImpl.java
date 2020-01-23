package com.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> listcustomerss() {
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	public Customer getcustomer(Long customer_mobileno) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customer_mobileno);
	}

	public void deletecustomer(Customer customer) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM Customer WHERE customer_mobileno = " + customer.getCustomer_mobileno())
				.executeUpdate();
	}

}
