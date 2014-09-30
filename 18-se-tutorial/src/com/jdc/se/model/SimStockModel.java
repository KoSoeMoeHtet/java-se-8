package com.jdc.se.model;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jdc.se.entity.Sim_stock;

public class SimStockModel extends CommonModel<Sim_stock> implements StockModel<Sim_stock>{

	public SimStockModel() {
		super(Sim_stock.class);
		super.creation = true;
		super.modification = true;
	}

	@Override
	public void addStock(Map<String, Object> param) throws SQLException {
		// get old
		Sim_stock oldRec = getLastStock((Integer)param.get("sim_id"));
		Integer inCount = (Integer) param.get("in");
		Integer outCount = (Integer) param.get("out");
		Integer total = 0;
		Integer oldTotal = 0;
		
		if(null != oldRec) {
			// update old data
			Map<String, Object> setParam = new LinkedHashMap<>();
			setParam.put("status", 2);
			
			Map<String, Object> whereParam = new LinkedHashMap<>();
			whereParam.put("id", oldRec.getId());
			
			this.update(setParam, whereParam);
			
			// set old total
			oldTotal = oldRec.getTotal();
		}

		// set total
		total = oldTotal + inCount - outCount;
		param.put("total", total);
		param.put("status", 1);
		
		// insert new		
		this.insert(param);
	}

	private Sim_stock getLastStock(Integer id) throws SQLException {
		Map<String, Object> param = new LinkedHashMap<>();
		param.put("sim_id", id);
		param.put("status", new Integer(1));
		List<Sim_stock> list = this.getWhere(param);
		for(Sim_stock s : list) {
			return s;
		}
		return null;
	}

	@Override
	public void updateStock(Map<String, Object> param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
