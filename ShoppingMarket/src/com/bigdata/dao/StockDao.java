package com.bigdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bigdata.util.BaseDao;
import com.bigdata.util.JDBCUtil;
import com.bigdata.vo.StockModel;


public class StockDao extends BaseDao implements StockInterface{

	@Override
	public void addStock(Map map) {
		String stockName = "" +  map.get("stockName");
		String stockPrice = "" + map.get("stockPrice");
		String stockComment = "" + map.get("stockComment");
		
		String sql = "insert into sm_stock (stock_name,stock_price,stock_descrip) " +
				"values('"+stockName+"' , '"+stockPrice+"', '"+stockComment+"')";
		executeSql(sql);
		
	}

	@Override
	public List queryStocks() {
		List list = new ArrayList();
		String sql = "select * from sm_stock";
		
		JDBCUtil jdbcUtil = JDBCUtil.getInstance();
		
		Connection conn;
		try {
			conn = jdbcUtil.getConnection();
			PreparedStatement psStatement = conn.prepareStatement(sql);
			
			ResultSet resultSet = psStatement.executeQuery();
			
			while (resultSet.next()) {
				int stockID = resultSet.getInt("id");
				String stockName = resultSet.getString("stock_name");
				double stockPrice = resultSet.getDouble("stock_price");
				String stockComment = resultSet.getString("stock_descrip");
				
				StockModel stockModel = new StockModel();
				stockModel.setId(stockID);
				stockModel.setStockName(stockName);
				stockModel.setStockPrice(stockPrice);
				stockModel.setStockComment(stockComment);
				list.add(stockModel);
			}
			jdbcUtil.close(resultSet, psStatement, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public void deletsStock(String stockID) {
		String sql = "delete from sm_stock where id = '"+stockID+"'";
		executeSql(sql);
	}

	@Override
	public void editorStock(StockModel stockModel) {
		String sql = "update sm_stock set stock_name = '"+stockModel.getStockName()
				+"' ,stock_descrip = '"+stockModel.getStockComment()
				+"',  stock_price = "+stockModel.getStockPrice()
				+" where id = "+stockModel.getId()+"";
		executeSql(sql);
	}

}
