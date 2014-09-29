package com.jdc.se.model;

import com.jdc.se.entity.Phone_transaction;

public class PhoneTransactionModel extends AbstractModel<Phone_transaction> {

	public PhoneTransactionModel() {
		super(Phone_transaction.class);
	}

	@Override
	protected Phone_transaction getEntity() {
		return new Phone_transaction();
	}

}
