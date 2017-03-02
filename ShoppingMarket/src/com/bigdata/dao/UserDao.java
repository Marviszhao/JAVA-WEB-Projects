package com.bigdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.bigdata.util.BaseDao;
import com.bigdata.util.JDBCUtil;
import com.bigdata.vo.UserModel;

public class UserDao extends BaseDao implements UserInterface{
	/**
	 * @param map
	 */
	public void insertUser(Map<String, Object> map) {
	
		String userName = "" + map.get("userName");
		boolean isExist = this.isHaveUser(userName);
		if (isExist == true) {
			System.err.println("�Ѵ����û�---" + userName);
			return;
		}
		
		String userPassword = "" + map.get("userPsw");
		int userType = Integer.parseInt(map.get("userType").toString());
		String sql = "insert into sm_user (name, pass_word,user_type) " +
				"		values('"+userName+"','"+userPassword+"', "+userType+")";
		executeSql(sql);
	}

	
	@Override
	public UserModel checkUser(String userName, String userPsw) {
		String sql = "select * from sm_user u where u.name = '"+userName+"' and u.pass_word = '"+userPsw+"'";
		return queryUser(sql);
	}
	
	public boolean isHaveUser(String userName) {
		String sql = "select * from sm_user u where u.name = '"+userName+"'";
		return queryUser(sql) == null;
	}
	
	public UserModel queryUser(String sql) {
		
		JDBCUtil jdbcUtil = JDBCUtil.getInstance();
		try {
			Connection connection = jdbcUtil.getConnection();
			PreparedStatement psStatement = connection.prepareStatement(sql);
			ResultSet rs = psStatement.executeQuery();
			if (rs.next()) {
				UserModel userModel = new UserModel();
				userModel.setId(rs.getInt("id"));
				userModel.setName(rs.getString("name"));
				userModel.setPass_word(rs.getString("pass_word"));
				userModel.setGender(rs.getInt("gender"));
				userModel.setPhone(rs.getString("phone"));
				userModel.setUser_type(rs.getInt("user_type"));
				jdbcUtil.close(null, psStatement, connection);
				return userModel;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public void updateUserPsw(int id, String new_psw) {
		String sql ="update sm_user set pass_word = '"+new_psw+"' where id = "+id+"";
		executeSql(sql);
	}

}
