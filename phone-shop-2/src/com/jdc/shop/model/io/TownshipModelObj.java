package com.jdc.shop.model.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import com.jdc.shop.model.FileModel;
import com.jdc.shop.model.Township;
import com.jdc.shop.model.TownshipModel;

public class TownshipModelObj implements TownshipModel, FileModel {

	private static TownshipModel model;

	public static TownshipModel getModel() {
		if (null == model)
			model = new TownshipModelObj();
		return model;
	}

	private List<Township> townships;

	@SuppressWarnings("unchecked")
	private TownshipModelObj() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				getFileName()))) {
			Object obj = in.readObject();
			if (null != obj)
				townships = (List<Township>) obj;
		} catch (IOException e) {
			System.err.println("First Time");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Township> getTownships() {
		return townships;
	}

	@Override
	public void save() {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(getFileName()))) {
			out.writeObject(townships);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFileName() {
		return String.format("%s.obj", Township.class.getSimpleName());
	}

	public static void main(String[] args) {
		TownshipModel fileModel = TownshipModelBuf.getModel();
		TownshipModel objectModel = TownshipModelObj.getModel();

		try {
			Field fList = TownshipModelBuf.class.getDeclaredField("townships");
			fList.setAccessible(true);
			@SuppressWarnings("unchecked")
			List<Township> list = (List<Township>) fList.get(fileModel);

			Field oList = TownshipModelObj.class.getDeclaredField("townships");
			oList.setAccessible(true);
			oList.set(objectModel, list);

			Method method = Arrays
					.asList(TownshipModelObj.class.getDeclaredMethods())
					.stream().filter(a -> "save".equals(a.getName())).findAny()
					.orElse(null);
			method.setAccessible(true);
			method.invoke(objectModel);
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
