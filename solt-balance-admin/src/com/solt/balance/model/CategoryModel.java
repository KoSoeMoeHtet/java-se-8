package com.solt.balance.model;

import java.io.IOException;

import com.solt.balance.model.entity.Category;

public class CategoryModel extends BaseModel<Category> {
	
	public CategoryModel() {
		
		super(
			a -> String.format("%d-%s-%s", a.getId(), a.getName(), a.getType()), 
			a -> {
				String [] array = a.split("-");
				Category c = new Category();
				c.setId(Integer.parseInt(array[0]));
				c.setName(array[1]);
				c.setType(array[2]);
				return c;
			}, 
			"category.txt"
		);
	}

	private static CategoryModel cm;
	
	public static CategoryModel getModel() throws IOException {
		if(null == cm)
			cm = new CategoryModel();
		
		return cm;
	}
	
	@Override
	public void add(Category t) throws IOException {
		t.setId(super.generate());
		super.add(t);
	}
}
