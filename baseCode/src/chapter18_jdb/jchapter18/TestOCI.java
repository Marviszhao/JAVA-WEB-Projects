package chapter18_jdb.jchapter18;

import java.sql.*;

public class TestOCI{
    public static void main(String args[]){
		try{		    
			Class.forName("com.mysql.jdbc.Driver");
		    //Connection conn = DriverManager.getConnection("jdbc:oracle:oci:@mdb1","scott","tiger");
		   	Connection conn = DriverManager.getConnection("jdbc:oracle:oci:@(description=(address=(host=127.0.0.1)(protocol=tcp)(port=1521))(connect_data=(sid=ora9)))","scott", "tiger");
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
