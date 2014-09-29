package com.jdc.se.model;

import com.jdc.se.entity.Phone_stock;

public class PhoneStockModel extends AbstractModel<Phone_stock> {

	public PhoneStockModel() {
		super(Phone_stock.class);
	}

	@Override
	protected Phone_stock getEntity() {
		return new Phone_stock();
	}

}
