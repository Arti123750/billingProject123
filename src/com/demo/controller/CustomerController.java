package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bean.CustomerBean;
import com.demo.model.Customer;

import com.demo.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("command") CustomerBean CustomerBean, BindingResult result) {
		Customer Customer = prepareModel(CustomerBean);
		customerService.addCustomer(Customer);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/Customers", method = RequestMethod.GET)
	public ModelAndView listCustomers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customers", prepareListofBean(customerService.listcustomerss()));
		return new ModelAndView("customerList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addCustomer(@ModelAttribute("command") CustomerBean CustomerBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customers", prepareListofBean(customerService.listcustomerss()));
		return new ModelAndView("addCustomer", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editCustomer(@ModelAttribute("command") CustomerBean CustomerBean, BindingResult result) {
		customerService.deletecustomer(prepareModel(CustomerBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer", null);
		model.put("customers", prepareListofBean(customerService.listcustomerss()));
		return new ModelAndView("addCustomer", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@ModelAttribute("command") CustomerBean customerBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer", prepareCustomerBean(customerService.getcustomer(customerBean.getCustomer_mobileno())));
		model.put("customers", prepareListofBean(customerService.listcustomerss()));
		return new ModelAndView("addCustomer", model);
	}

	private Customer prepareModel(CustomerBean customerBean) {
		Customer customer = new Customer();



		customer.setCustomer_name(customerBean.getCustomer_name());
		customer.setCustomer_address(customerBean.getCustomer_address());
		customer.setCustomer_age(customerBean.getCustomer_age());
		customer.setCustomer_mobileno(customerBean.getCustomer_mobileno());
		
		return customer;
	}

	private List<CustomerBean> prepareListofBean(List<Customer> customers) {
		List<CustomerBean> beans = null;
		if (customers != null && !customers.isEmpty()) {
			beans = new ArrayList<CustomerBean>();
			CustomerBean bean = null;
			for (Customer customer : customers) {

				bean = new CustomerBean();
				bean.setCustomer_mobileno(customer.getCustomer_mobileno());
				bean.setCustomer_name(customer.getCustomer_name());
				bean.setCustomer_address(customer.getCustomer_address());
				bean.setCustomer_age(customer.getCustomer_age());
				beans.add(bean);
			}
		}
		return beans;
	}

	private CustomerBean prepareCustomerBean(Customer customer) {
		CustomerBean bean = new CustomerBean();

		bean.setCustomer_mobileno(customer.getCustomer_mobileno());
		bean.setCustomer_name(customer.getCustomer_name());
		bean.setCustomer_address(customer.getCustomer_address());
		bean.setCustomer_age(customer.getCustomer_age());

		return bean;
	}
}
