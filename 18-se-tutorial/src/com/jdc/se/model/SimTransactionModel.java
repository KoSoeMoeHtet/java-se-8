package com.jdc.se.model;

import com.jdc.se.entity.Sim_transaction;

public class SimTransactionModel extends AbstractModel<Sim_transaction> {

	public SimTransactionModel() {
		super(Sim_transaction.class);
	}

	@Override
	protected Sim_transaction getEntity() {
		return new Sim_transaction();
	}

}
