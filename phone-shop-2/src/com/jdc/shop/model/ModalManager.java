package com.jdc.shop.model;

import com.jdc.shop.model.io.RegistrationModelBuf;
import com.jdc.shop.model.io.TownshipModelBuf;
import com.jdc.shop.model.memory.RegistrationModelImp;
import com.jdc.shop.model.memory.TownshipModelImp;

public class ModalManager {
	
	public static TownshipModel getTownshipModel(ModelType type) {
		if(ModelType.Memory.equals(type))
			return TownshipModelImp.getModel();
		else if(ModelType.File.equals(type))
			return TownshipModelBuf.getModel();
		else
			return null;
	}
	
	public static RegistrationModel getRegistrationModel(ModelType type) {
		if(ModelType.Memory.equals(type))
			return RegistrationModelImp.getModel();
		else if(ModelType.File.equals(type))
			return RegistrationModelBuf.getModel();
		else
			return null;
	}

}
