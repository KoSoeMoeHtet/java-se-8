package com.jdc.shop.model.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jdc.shop.model.Township;
import com.jdc.shop.model.TownshipModel;

public class TownshipModelBuf implements TownshipModel {
	
	private static TownshipModel model;
	
	public static TownshipModel getModel() {
		if(null == model)
			model = new TownshipModelBuf();
		return model;
	}

	private List<Township> townships;

	private TownshipModelBuf() {
		townships = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(
				"Township.txt"))) {
			String line = null;
			
			while((line = br.readLine()) != null) {
				String [] str = line.split("\t");
				if(str.length == 2) {
					Township ts = new Township(Integer.parseInt(str[0]), str[1]);
					townships.add(ts);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Township> getTownships() {
		return townships;
	}

}
