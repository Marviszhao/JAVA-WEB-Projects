package com.bigdata.vo;

public class BoughtStockModel extends StockModel {
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BoughtStockModel [count=" + count + ", getCount()="
				+ getCount() + ", getId()=" + getId() + ", getStockName()="
				+ getStockName() + ", getStockPrice()=" + getStockPrice()
				+ ", getStockComment()=" + getStockComment() + "]";
	}
	
}
