package com.jdc.se.model;

import com.jdc.se.entity.Transaction;

public class TransactionModel extends AbstractModel<Transaction> {

	public TransactionModel() {
		super(Transaction.class);
	}

	@Override
	protected Transaction getEntity() {
		return new Transaction();
	}

}
