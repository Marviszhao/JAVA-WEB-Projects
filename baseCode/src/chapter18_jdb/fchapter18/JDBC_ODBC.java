package chapter18_jdb.fchapter18;

import java.sql.*;
public class JDBC_ODBC{
    public static void main(String args[]){
    	String drv = "sun.jdbc.odbc.JdbcOdbcDriver";
		try{
			Class.forName(drv); 
			Connection con = DriverManager.getConnection("jdbc:odbc:ExcelODBC1", "", ""); 

			DatabaseMetaData dmd = con.getMetaData(); 
			if (dmd == null) { 
				System.out.println ("No DBMeta available"); 
			} else { 
				System.out.println ("DB Name:\t" + dmd.getDatabaseProductName()); 
				System.out.println ("DB Version:\t" + dmd.getDatabaseProductVersion()); 
				System.out.println ("DB Driver Name:\t" + dmd.getDriverName()); 
				System.out.println ("Driver Version:\t" + dmd.getDriverVersion()); 
			} 
	    
		    Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from [Sheet1$]");
			System.out.println("记录内容：");
			System.out.println("\t姓  名\t年龄\t月  薪\t职  务" );
		    while(rs.next()){
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getInt(2));	
				System.out.print("\t" + rs.getString(3));
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