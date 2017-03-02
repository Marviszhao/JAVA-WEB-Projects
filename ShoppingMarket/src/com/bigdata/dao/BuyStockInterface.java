package com.bigdata.dao;

import java.util.List;

import com.bigdata.vo.BuyStockModel;

public interface BuyStockInterface {
	public void insertBuyStock(BuyStockModel model);
	
	public List queryBoughtStocks(int user_id);
}
