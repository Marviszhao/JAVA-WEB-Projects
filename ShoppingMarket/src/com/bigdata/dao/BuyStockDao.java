package com.bigdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bigdata.util.BaseDao;
import com.bigdata.util.JDBCUtil;
import com.bigdata.vo.BoughtStockModel;
import com.bigdata.vo.BuyStockModel;

public class BuyStockDao extends BaseDao implements BuyStockInterface{

	@Override
	public void insertBuyStock(BuyStockModel model) {
		BuyStockModel buyStockModel = queryBuyStock(model);
		if (buyStockModel != null) {
			int buyCount = buyStockModel.getStock_count();
			buyCount ++;
			buyStockModel.setStock_count(buyCount);
			updateBuyStock(buyStockModel);
		} else {
			String sql = "insert into sm_user_stock_con(user_id,stock_id,stock_count)" +
					"values("+model.getUser_id()+","+
					model.getStock_id()+","+
					model.getStock_count()+")";
			executeSql(sql);
		}
	}
	
	private BuyStockModel queryBuyStock(BuyStockModel model){
		String sql = "select * from sm_user_stock_con b where b.user_id = "
	+model.getUser_id()+" and b.stock_id = "+model.getStock_id()+"";
		JDBCUtil jdbcUtil = JDBCUtil.getInstance();
		
		try {
			Connection connection = jdbcUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				BuyStockModel buyStockModel = new BuyStockModel();
				buyStockModel.setId(rs.getInt("id"));
				buyStockModel.setUser_id(rs.getInt("user_id"));
				buyStockModel.setStock_id(rs.getInt("stock_id"));
				buyStockModel.setStock_count(rs.getInt("stock_count"));
				return buyStockModel;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void updateBuyStock(BuyStockModel model){
		String sql = "update sm_user_stock_con b set b.stock_count = "+
	model.getStock_count()+" where b.user_id = "+model.getUser_id()
	+" and b.stock_id = "+model.getStock_id()+"";
		executeSql(sql);
	}

	@Override
	public List queryBoughtStocks(int user_id) {
		String sql = "select s.*,c.stock_count from sm_user_stock_con c join sm_stock s " +
				"on c.stock_id = s.id where c.user_id="+user_id+"";
		
		JDBCUtil jdbcUtil = JDBCUtil.getInstance();
		
		try {
			Connection con = jdbcUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				int stockID = rs.getInt("id");
				String stockName = rs.getString("stock_name");
				double stockPrice = rs.getDouble("stock_price");
				String stockDes = rs.getString("stock_descrip");
				int stockCount = rs.getInt("stock_count");
				
				BoughtStockModel boughtStockModel = new BoughtStockModel();
				boughtStockModel.setId(stockID);
				boughtStockModel.setStockName(stockName);
				boughtStockModel.setStockPrice(stockPrice);
				boughtStockModel.setStockComment(stockDes);
				boughtStockModel.setCount(stockCount);
				list.add(boughtStockModel);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
