package com.jdc.se.model;

import com.jdc.se.entity.Division;

public class DivisionModel extends AbstractModel<Division> {

	public DivisionModel() {
		super(Division.class);
	}

	@Override
	protected Division getEntity() {
		return new Division();
	}

}
