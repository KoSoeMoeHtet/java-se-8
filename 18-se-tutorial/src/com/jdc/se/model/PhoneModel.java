package com.jdc.se.model;

import com.jdc.se.entity.Phone;

public class PhoneModel extends AbstractModel<Phone> {

	public PhoneModel() {
		super(Phone.class);
	}

	@Override
	protected Phone getEntity() {
		return new Phone();
	}

}
