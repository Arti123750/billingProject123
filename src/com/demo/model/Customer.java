package com.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VodafoneInfo")
public class Customer implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@Column(name="customer_mobileno")
	private Long customer_mobileno;
	
	@Column(name="customer_name")
	private String customer_name;
	
	@Column(name="customer_address")
	private String customer_address;
	
	@Column(name="customer_age")
	private Integer customer_age;

	public Long getCustomer_mobileno() {
		return customer_mobileno;
	}

	public void setCustomer_mobileno(Long customer_mobileno) {
		this.customer_mobileno = customer_mobileno;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public Integer getCustomer_age() {
		return customer_age;
	}

	public void setCustomer_age(Integer customer_age) {
		this.customer_age = customer_age;
	}
	
}
