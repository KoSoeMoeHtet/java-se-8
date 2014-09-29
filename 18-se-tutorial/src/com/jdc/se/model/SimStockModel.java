package com.jdc.se.model;

import com.jdc.se.entity.Sim_stock;

public class SimStockModel extends AbstractModel<Sim_stock> {

	public SimStockModel() {
		super(Sim_stock.class);
	}

	@Override
	protected Sim_stock getEntity() {
		return new Sim_stock();
	}

}
