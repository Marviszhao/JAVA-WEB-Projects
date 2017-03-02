package chapter18_jdb.ichapter18;

import java.io.*;
import java.util.*;
import java.sql.*;

public class JDBCExample{
	public static Connection getConnection()throws SQLException,IOException{
		Properties ps = new Properties();
		FileInputStream fis = new FileInputStream("mydb.properties");
		ps.load(fis);
		fis.close();
		
		String url = ps.getProperty("db_url");
		String username = ps.getProperty("username");	
		String psw = ps.getProperty("password");
		
		Connection conn = DriverManager.getConnection(url,username,psw);
		return  conn;		
	}
	
    public static void main(String args[]){
		try{		    
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn = JDBCExample.getConnection();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("select * from dept");
		    while(rs.next()){
				System.out.print("DeptNo: " + rs.getInt(1));
				System.out.print("\tDeptName: " + rs.getString(2));
				System.out.println("\tLOC: " + rs.getString(3));						    
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
		    e.printStackTrace();
		}
    }    
}
