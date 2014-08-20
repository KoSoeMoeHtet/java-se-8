package com.jdc.shop.model.memory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import com.jdc.shop.model.Township;
import com.jdc.shop.model.TownshipModel;

public class TownshipModelImp implements TownshipModel {

	private static TownshipModel model;

	public static TownshipModel getModel() {
		if (null == model) {
			model = new TownshipModelImp();
		}
		return model;
	}

	private TownshipModelImp() {
	};

	private static List<Township> townships;

	static {
		townships = Arrays.asList(new Township(1, "Bahan"), new Township(2,
				"Yankin"), new Township(3, "Botataung"), new Township(4,
				"Tarmwe"), new Township(5, "Papadan"));
	}

	@Override
	public List<Township> getTownships() {
		return townships;
	}

	public static void main(String[] args) {
		try (PrintWriter pw = new PrintWriter("Township.txt")) {
			for (Township t : townships) {
				pw.println(String.format("%s\t%s", t.getId(), t.getName()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
