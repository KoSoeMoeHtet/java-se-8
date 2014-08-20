package com.jdc.shop.model.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdc.shop.model.FileModel;
import com.jdc.shop.model.NumberGenerator;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;

public class RegistrationModelObj implements RegistrationModel, FileModel {

	public static String DATE = "yyyyMMdd HH:mm:ss";

	private static RegistrationModel model;
	private List<Registration> list;
	private NumberGenerator gen;
	
	public static RegistrationModel getModel() {

		if (null == model) {
			model = new RegistrationModelObj();
		}

		return model;
	}
	
	@SuppressWarnings("unchecked")
	private RegistrationModelObj() {
		list = new ArrayList<Registration>();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Registration.obj"))) {
			Object obj = in.readObject();
			if(null != obj)
				list = (List<Registration>) obj;
			
		}  catch (IOException | ClassNotFoundException e) {
			System.err.println("First Time");
		}
		gen = new NumberGenerator(RegistrationModel.getLastNumber(list));
	}

	@Override
	public List<Registration> getRegistrationData(Date from, Date to) {
		return RegistrationModel.getRegistrationData(from, to, list);
	}
	
	@Override
	public List<Registration> getSoldData() {
		return RegistrationModel.getSoldData(list);
	}

	@Override
	public void update(Date from, Date to) {
		RegistrationModel.update(from, to, list, gen);
		save();
	}

	@Override
	public void create(Registration regist) {
		list.add(regist);
		save();
	}

	@Override
	public void save() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(""))) {
			out.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public String getFileName() {
		return String.format("%s.obj", Registration.class.getSimpleName());
	}
}
