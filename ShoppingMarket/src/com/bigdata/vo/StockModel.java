package com.bigdata.vo;

public class StockModel {
	private int id;
	private String stockName;
	private double stockPrice;
	private String stockComment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getStockComment() {
		return stockComment;
	}
	@Override
	public String toString() {
		return "StockModel [id=" + id + ", stockName=" + stockName
				+ ", stockPrice=" + stockPrice + ", stockComment="
				+ stockComment + "]";
	}
	public void setStockComment(String stockComment) {
		this.stockComment = stockComment;
	}
	
}
