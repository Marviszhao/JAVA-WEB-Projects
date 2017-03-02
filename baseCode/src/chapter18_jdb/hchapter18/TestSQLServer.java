package chapter18_jdb.hchapter18;

import java.sql.*;

public class TestSQLServer{
	public static void main(String[] args) {
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			Connection con = DriverManager.getConnection("jdbc:odbc:mydb1", "", ""); 
			//Connection con = DriverManager.getConnection("jdbc:odbc:mydb1;database=pubs", "", ""); 
			Statement stmt = con.createStatement();
			ResultSet rs   = stmt.executeQuery("select * from mytable1");
			while(rs.next()){
					System.out.print("��ţ�" + rs.getInt(1));
					System.out.print("\t������" + rs.getString(2).trim());
					System.out.print("\t�Ա�" + rs.getString(3).trim());
					System.out.println();
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
		    e.printStackTrace();
		}
	}
}