package com.jdc.se.model;

import com.jdc.se.entity.Township;

public class TownshipModel extends AbstractModel<Township> {

	public TownshipModel() {
		super(Township.class);
	}

	@Override
	protected Township getEntity() {
		return new Township();
	}

}
