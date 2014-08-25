package com.jdc.shop.model;

import com.jdc.shop.model.io.RegistrationModelBuf;
import com.jdc.shop.model.io.RegistrationModelNio;
import com.jdc.shop.model.io.RegistrationModelObj;
import com.jdc.shop.model.io.TownshipModelBuf;
import com.jdc.shop.model.io.TownshipModelNio;
import com.jdc.shop.model.io.TownshipModelObj;
import com.jdc.shop.model.jdbc.RegistrationModelDb;
import com.jdc.shop.model.jdbc.TownshipModelDb;
import com.jdc.shop.model.memory.RegistrationModelImp;
import com.jdc.shop.model.memory.TownshipModelImp;

public class ModalManager {
	
	public static TownshipModel getTownshipModel(ModelType type) {
		if(ModelType.Memory.equals(type))
			return TownshipModelImp.getModel();
		else if(ModelType.File.equals(type))
			return TownshipModelBuf.getModel();
		else if(ModelType.Object.equals(type))
			return TownshipModelObj.getModel();
		else if(ModelType.NIO.equals(type))
			return TownshipModelNio.getModel();
		else
			return TownshipModelDb.getModel();
	}
	
	public static RegistrationModel getRegistrationModel(ModelType type) {
		if(ModelType.Memory.equals(type))
			return RegistrationModelImp.getModel();
		else if(ModelType.File.equals(type))
			return RegistrationModelBuf.getModel();
		else if(ModelType.Object.equals(type))
			return RegistrationModelObj.getModel();
		else if(ModelType.NIO.equals(type))
			return RegistrationModelNio.getModel();
		else
			return RegistrationModelDb.getModel();
	}

}
