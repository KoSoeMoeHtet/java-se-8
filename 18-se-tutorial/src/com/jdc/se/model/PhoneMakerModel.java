package com.jdc.se.model;

import com.jdc.se.entity.Phone_maker;

public class PhoneMakerModel extends AbstractModel<Phone_maker> {

	public PhoneMakerModel() {
		super(Phone_maker.class);
	}

	@Override
	protected Phone_maker getEntity() {
		return new Phone_maker();
	}

}
