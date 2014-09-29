package com.jdc.se.model;

import com.jdc.se.entity.Sim;

public class SimModel extends AbstractModel<Sim> {

	public SimModel() {
		super(Sim.class);
	}

	@Override
	protected Sim getEntity() {
		return new Sim();
	}

}
