package com.bigdata.service;

import java.util.List;
import java.util.Map;

import com.bigdata.dao.StockDao;
import com.bigdata.vo.StockModel;

public class StockService {
	StockDao stockDao = new StockDao();
	public void addStock(Map map) {
		
	stockDao.addStock(map);
	}

	public List queryStocks() {
		
		return stockDao.queryStocks();
	}

	public void deleteStock(String stockID) {
		
		stockDao.deletsStock(stockID);
	}

	public void editorStock(StockModel stockModel) {
		stockDao.editorStock(stockModel);
		
	}
}
