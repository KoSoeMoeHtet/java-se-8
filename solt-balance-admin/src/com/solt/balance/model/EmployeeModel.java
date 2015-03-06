package com.solt.balance.model;

import java.io.IOException;

import com.solt.balance.model.entity.Employee;

public class EmployeeModel extends BaseModel<Employee> {
	
	EmployeeModel() {
		super(
				a -> String.format("%d-%s-%s-%s", a.getId(), a.getName(), a.getPassword(), a.getRole()), 
				a -> {
					String [] array = a.split("-");
					if(array.length == 4) {
						Employee e = new Employee();
						e.setId(Integer.parseInt(array[0]));
						e.setName(array[1]);
						e.setPassword(array[2]);
						e.setRole(array[3]);
						return e;
					}
					return null;
				}, 
				"employee.txt");
	}

	private static EmployeeModel em;
	
	public static EmployeeModel getModel() {
		if(null == em)
			em = new EmployeeModel();
		
		return em;
	}
	
	@Override
	public void add(Employee t) throws IOException {
		t.setId(generate());
		super.add(t);
	}

}
