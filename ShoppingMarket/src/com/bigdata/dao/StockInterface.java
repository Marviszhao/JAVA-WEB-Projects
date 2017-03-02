package com.bigdata.dao;

import java.util.Map;

import java.util.List;

import com.bigdata.vo.StockModel;

public interface StockInterface {
	public void addStock(Map map);
	public List queryStocks();
	public void deletsStock(String stockID);
	public void editorStock(StockModel stockModel);
}
