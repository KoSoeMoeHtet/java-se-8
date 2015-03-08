package com.solt.balance.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.solt.balance.model.entity.Balance;
import com.solt.balance.model.entity.Category;

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
	public List<Balance> getAll() {
		return this.getTotalList(super.getAll());
	}
	
	public List<Balance> getWhere(Predicate<Balance> where) {
		return this.getTotalList(super.getWhere(where));
	}
	
	private List<Balance> getTotalList(List<Balance> list) {
		Total total = new Total();
		return list.stream().map(a -> {
			if(a.getCategory().getType().equals("IN")) {
				total.setTotal(a.getAmount());
			} else {
				total.setTotal(0 - a.getAmount());
			}
			
			a.setBalance(total.getTotal());
			
			return a;
		}).collect(Collectors.toList());
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
	
	private class Total {
		int total;
		
		public int getTotal() {
			return total;
		}
		
		public void setTotal(int total) {
			this.total += total;
		}
	}
	
	public Map<String, Integer> getChartData(Predicate<Balance> where, CategoryType type) throws IOException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<Category> list = new ArrayList<>();
		if(type == CategoryType.ALL) {
			list = CategoryModel.getModel().getAll();
		} else {
			list = CategoryModel.getModel().getWhere(a -> a.getType().equals(type.toString()));
		}
		
		list.forEach(a -> {
			map.put(a.getName(), getWhere(where).stream()
					.filter(b -> b.getCategory().getId() == a.getId())
					.mapToInt(b -> b.getAmount())
					.sum());
		});
		
		return map;
	}
	
	public Integer getAmount(final Category cat) {
		return 0;
	}
	
	public enum CategoryType {
		ALL, IN, OUT;
	}
 }
