package com.bigdata.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtil {
	private final  String url = "jdbc:mysql://localhost:3306/shoppingmarket?useUnicode=true&characterEncoding=UTF8";
	private final  String user = "root";
	private final  String psw = "123";
	private JDBCUtil() {
		
	}
	private static JDBCUtil jdbcInstance = null;
	
	public static JDBCUtil getInstance() {
		if (jdbcInstance == null) {
			synchronized (JDBCUtil.class) {
				if (jdbcInstance == null) {
					jdbcInstance = new JDBCUtil();
				}
			}
		}
		return jdbcInstance;
	}
	
	static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, psw);
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
