package com.bigdata.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDao {
	protected void executeSql(String sql) {
		JDBCUtil jdbcUtil = JDBCUtil.getInstance();
		try {
			Connection connection = jdbcUtil.getConnection();
			PreparedStatement psStatement = connection.prepareStatement(sql);
			psStatement.execute();
			jdbcUtil.close(null, psStatement, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
