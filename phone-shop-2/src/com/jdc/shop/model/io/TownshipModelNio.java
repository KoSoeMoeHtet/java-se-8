package com.jdc.shop.model.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.jdc.shop.model.FileModel;
import com.jdc.shop.model.Township;
import com.jdc.shop.model.TownshipModel;

public class TownshipModelNio implements FileModel, TownshipModel {

	private static TownshipModel model;

	public static TownshipModel getModel() {
		if (null == model)
			model = new TownshipModelNio();
		return model;
	}

	private TownshipModelNio() {
		try {
			List<String> strList = Files.readAllLines(Paths.get(getFileName()));
			townships = strList.stream().filter(a -> a != null)
					.map(a -> a.split("\t")).filter(a -> a.length == 2)
					.map(Township::new).collect(Collectors.toList());
		} catch (IOException e) {
			System.err.println("First Time");
		}
	}

	private List<Township> townships;

	@Override
	public void save() {

	}

	@Override
	public String getFileName() {
		return String.format("%s.txt", Township.class.getSimpleName());
	}

	@Override
	public List<Township> getTownships() {
		return townships;
	}

}
