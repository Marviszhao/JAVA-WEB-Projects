package chapter18_jdb.hchapter18;

import java.sql.*;
public class TestSQLServer2{
	public static void main(String[] args) {
		try{

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			Connection con = DriverManager.getConnection("jdbc:odbc:mydb2", "tom", "cat"); 
			Statement stmt = con.createStatement();
			ResultSet rs   = stmt.executeQuery("select * from mytable1");
			while(rs.next()){
					System.out.print("±àºÅ£º" + rs.getInt(1));
					System.out.print("\tÐÕÃû£º" + rs.getString(2).trim());
					System.out.print("\tÐÔ±ð£º" + rs.getString(3).trim());
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