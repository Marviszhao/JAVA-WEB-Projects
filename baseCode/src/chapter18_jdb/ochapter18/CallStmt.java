package chapter18_jdb.ochapter18;

import java.sql.*;
public class CallStmt{
	public static void main(String[] args){
		Connection con = null;
		CallableStatement cst = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/test";
		    con = DriverManager.getConnection(url,"root","123456");
			cst = con.prepareCall("{call MyProcedure(?,?,?)}");			
			cst.setInt(1,1001);
			cst.setString(2,"Jenny");
			cst.setInt(3,48);
			cst.execute();
			cst.close();
		}catch(Exception e){
			System.err.println(e);
		}finally{
			try{
				if(con != null){
					con.close();	
				}	
			}catch(Exception e){
		    	e.printStackTrace();
			}
		}
	}
}
