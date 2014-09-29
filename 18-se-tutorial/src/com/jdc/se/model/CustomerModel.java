package com.jdc.se.model;

import com.jdc.se.entity.Customer;

public class CustomerModel extends AbstractModel<Customer> {

	public CustomerModel() {
		super(Customer.class);
	}

	@Override
	protected Customer getEntity() {
		return new Customer();
	}

}
