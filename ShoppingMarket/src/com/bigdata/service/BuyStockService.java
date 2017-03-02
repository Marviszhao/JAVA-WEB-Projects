package com.bigdata.service;

import java.util.List;

import com.bigdata.dao.BuyStockDao;
import com.bigdata.vo.BuyStockModel;

public class BuyStockService {

	BuyStockDao buyStockDao = new BuyStockDao();
	public void insertBuyStock(BuyStockModel model){
		buyStockDao.insertBuyStock(model);
	}

	public List queryBoughtStocks(int userID) {
		
		List list =	buyStockDao.queryBoughtStocks(userID);
		
		return list;
	}
}
