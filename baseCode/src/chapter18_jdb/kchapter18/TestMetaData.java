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
				System.out.println ("���ݿ�����:" + dmd.getDatabaseProductName()); 
				System.out.println ("���ݿ�汾:" + dmd.getDatabaseProductVersion()); 
				System.out.println ("���ݿ���������" + dmd.getDriverName()); 
				System.out.println ("��������汾�ţ�" + dmd.getDriverVersion());
				System.out.println ("--------------------------------------------");

				System.out.println ("��������ͼ�֧�����(true-֧��,false-��֧��)");
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
