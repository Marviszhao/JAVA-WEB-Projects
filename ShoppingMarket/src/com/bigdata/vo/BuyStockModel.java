package com.bigdata.vo;

public class BuyStockModel {
	private int id;
	private int user_id;
	private int stock_id;
	private int stock_count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public int getStock_count() {
		return stock_count;
	}
	public void setStock_count(int stock_count) {
		this.stock_count = stock_count;
	}
	@Override
	public String toString() {
		return "BuyStockModel [id=" + id + ", user_id=" + user_id
				+ ", stock_id=" + stock_id + ", stock_count=" + stock_count
				+ "]";
	}
	
}
