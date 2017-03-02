package chapter18_jdb.kchapter18;

import java.sql.*;
public class TestMetaData{
    public static void main(String args[]){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/test";
		    conn = DriverManager.getConnection(url,"root","123456");
		    ResultSet rs = null;		
			DatabaseMetaData dmd = conn.getMetaData(); 
			if (dmd == null) { 
				System.out.println ("No Meta available"); 
			} else { 
				System.out.println ("数据库名称:" + dmd.getDatabaseProductName()); 
				System.out.println ("数据库版本:" + dmd.getDatabaseProductVersion()); 
				System.out.println ("数据库驱动程序：" + dmd.getDriverName()); 
				System.out.println ("驱动程序版本号：" + dmd.getDriverVersion());
				System.out.println ("--------------------------------------------");

				System.out.println ("结果集类型及支持情况(true-支持,false-不支持)");
				System.out.println ("TYPE_FORWARD_ONLY: " + 
					dmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)); 
				System.out.println ("TYPE_SCROLL_INSENSITIVE: " + 
					dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)); 
				System.out.println ("TYPE_SCROLL_SENSITIVE: " + 
					dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)); 
				System.out.println ("CONCUR_READ_ONLY: " + 
					dmd.supportsResultSetType(ResultSet.CONCUR_READ_ONLY)); 
				System.out.println ("CONCUR_UPDATABLE: " + 
					dmd.supportsResultSetType(ResultSet.CONCUR_UPDATABLE)); 
			} 					    
		}catch(Exception e){
		    e.printStackTrace();
		}finally{
			try{
				if(conn != null){
					conn.close();	
				}	
			}catch(Exception e){
		    	e.printStackTrace();
			}
		}
    }
}
