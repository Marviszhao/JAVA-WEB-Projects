package com.zhiyou.dao;
import java.sql.*;

public class DaoUtil {
	private final static String driverName = "com.mysql.jdbc.Driver";
	private final static String database = "userdb";
	private final static String url = "jdbc:mysql://localhost:3306/"+database;
	private final static String user = "root";
	private final static String password = "123";
	
	static Connection getConnecttion() throws Exception{
		Class<?> a = Class.forName(driverName);
		System.out.println(a);
		return DriverManager.getConnection(url, user, password);
	}
	
	static void closeDB(Connection c) throws Exception{
		c.close();
	}
	
	static void closeDB(Connection c, Statement s)throws Exception{
		s.close();
		c.close();
	}
	
	static void closeDB(Connection c, Statement s, ResultSet set) throws Exception{
		set.close();
		s.close();
		c.close();
	}
}
