package chapter18_jdb.cchapter18;

import java.sql.*;

public class TestDDL{
    public static void main(String args[]){
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
		try{		   
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/test";
		    conn = DriverManager.getConnection(url,"root","123456");
		    stmt = conn.createStatement();
//			stmt执行建表语句
			stmt.execute("create table mytable(id int, name char(10), phone char(10))");		    
//		 执行executeUpdate方法插入数据
			stmt.executeUpdate("insert into mytable values(55,'Tom','67666939')");
//			查询相关结果
		    rs = stmt.executeQuery("select * from mytable");
		    while(rs.next()){
		    	System.out.println(rs.getString(1) + "\t" 
		    + rs.getString(2) + "\t" + rs.getString(3));	
		    }
//		    stmt.execute("drop table mytable");
		}catch(Exception e){
		    e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
		    	e.printStackTrace();
			}	
		}
    }
}
