package com.bigdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bigdata.util.BaseDao;
import com.bigdata.util.JDBCUtil;
import com.bigdata.vo.JudgeModel;
import com.sun.org.apache.regexp.internal.recompile;

public class JudgeDao extends BaseDao implements JudgeInterface {

	@Override
	public void insertJudge(JudgeModel judgeModel) {
		String sqlString = "insert into sm_judge(judge_content,judge_star,stock_id,user_id,judge_secret)" +
				"values('"+judgeModel.getJudge_content()+"',"+judgeModel.getJudge_star()+","+
				judgeModel.getStock_id()+","+judgeModel.getUser_id()+","+judgeModel.getJudge_secret()+")";
		System.out.println("执行sql语句----------");
		System.out.println(sqlString);
		System.out.println("执行完成----------");
		executeSql(sqlString);
	}

	@Override
	public List queryJudgeList(int stockID) {
		String sql = "select * from sm_judge where stock_id = "+stockID+"";
		JDBCUtil jdbcUtil = JDBCUtil.getInstance();
		
		try {
			Connection conn = jdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			List list = new ArrayList();
			while (rs.next()) {
				int id = rs.getInt("id");
				int judge_star = rs.getInt("judge_star");
				String judge_content = rs.getString("judge_content"); 
				int user_id = rs.getInt("user_id");
				int judge_secret = rs.getInt("judge_secret");
				int stock_id = rs.getInt("stock_id");
				
				JudgeModel judgeModel = new JudgeModel();
				judgeModel.setId(id);
				judgeModel.setJudge_star(judge_star);
				judgeModel.setJudge_content(judge_content);
				judgeModel.setUser_id(user_id);
				judgeModel.setJudge_secret(judge_secret);
				judgeModel.setStock_id(stock_id);
				list.add(judgeModel);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void deleteJudge(int judgeID) {
		String sql = "delete from sm_judge where id = "+judgeID+"";
		executeSql(sql);
	}

}
