package com.jdc.se.model;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jdc.se.entity.Sim_stock;

public class SimStockModel extends CommonModel<Sim_stock> implements
		StockModel<Sim_stock> {

	public SimStockModel() {
		super(Sim_stock.class);
		super.creation = true;
		super.modification = true;
	}

	@Override
	public void addStock(Map<String, Object> param) throws SQLException {
		// get old
		Sim_stock oldRec = getLastStock((Integer) param.get("sim_id"));
		Integer inCount = (Integer) param.get("in");
		Integer outCount = (Integer) param.get("out");
		Integer total = 0;
		Integer oldTotal = 0;

		if (null != oldRec) {
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

	@Override
	public void updateStock(Map<String, Object> param) throws SQLException,
			IllegalArgumentException, IllegalAccessException {
		// get old
		Sim_stock oldRec = getLastStock((Integer) param.get("sim_id"));
		Integer inCount = (Integer) param.get("in");
		Integer outCount = (Integer) param.get("out");
		Integer total = 0;

		if (null != oldRec) {
			// update old data
			Map<String, Object> setParam = new LinkedHashMap<>();
			setParam.put("status", 2);

			Map<String, Object> whereParam = new LinkedHashMap<>();
			whereParam.put("id", oldRec.getId());

			this.update(setParam, whereParam);

			// add cancel record
			Map<String, Object> cancelParam = this.getCancelParam(oldRec);
			this.insert(cancelParam);

			// set total
			total = (Integer)cancelParam.get("total") + inCount - outCount;
			param.put("total", total);
			param.put("status", 1);

			// insert new
			this.insert(param);
		}

	}

	private Map<String, Object> getCancelParam(Sim_stock oldRec)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fs = oldRec.getClass().getDeclaredFields();
		Map<String, Object> param = new LinkedHashMap<>();
		for (Field f : fs) {
			f.setAccessible(true);
			String n = f.getName();
			if (!n.equals("id") && !n.equals("modification") && !n.equals("creation")) {
				param.put(n, f.get(oldRec));
			}
		}
		// status
		param.put("status", 2);

		// total
		int total = oldRec.getTotal() - oldRec.getIn() + oldRec.getOut();
		param.put("total", total);
		param.put("in", 0 - oldRec.getIn());
		param.put("out", 0 - oldRec.getOut());
		return param;
	}

	private Sim_stock getLastStock(Integer id) throws SQLException {
		Map<String, Object> param = new LinkedHashMap<>();
		param.put("sim_id", id);
		param.put("status", new Integer(1));
		List<Sim_stock> list = this.getWhere(param);
		for (Sim_stock s : list) {
			return s;
		}
		return null;
	}

}
