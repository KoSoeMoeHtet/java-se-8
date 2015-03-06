package com.solt.balance.model;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.solt.balance.model.entity.Balance;

public class BalanceModel extends BaseModel<Balance> {

	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final String DEL = "\t";
	private static final String FORMAT = "%d"+ DEL +"%s" + DEL + "%d"  + DEL + "%d" + DEL + "%d" + DEL +"%s";
	BalanceModel() {
		super(
			a -> String.format(FORMAT, 
					a.getId(), df.format(a.getDate()),
					a.getEmployee().getId(), a.getCategory().getId(), a.getAmount(), a.getRemark()), 
			a -> {
				String [] strs = a.split(DEL);
				try {
					if(strs.length >= 5) {
						Balance b = new Balance();
						b.setId(Integer.parseInt(strs[0]));
						b.setDate(df.parse(strs[1]));
						b.setEmployee(EmployeeModel.getModel().findById(c -> c.getId() == Integer.parseInt(strs[2])));
						b.setCategory(CategoryModel.getModel().findById(c -> c.getId() == Integer.parseInt(strs[3])));
						b.setAmount(Integer.parseInt(strs[4]));
						
						if(strs.length > 5)
							b.setRemark(strs[5]);
						
						return b;
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				return null;
			}, 
			"balance.txt"
		);
	}

	@Override
	public void add(Balance t) throws IOException {
		t.setId(generate());
		super.add(t);
	}
	
	private static BalanceModel MODEL;
	
	public static BalanceModel getModel() {
		if(null == MODEL)
			MODEL = new BalanceModel();
		
		return MODEL;
	}
}
