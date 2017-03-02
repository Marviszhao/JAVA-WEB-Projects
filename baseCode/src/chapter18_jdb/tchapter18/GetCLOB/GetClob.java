package chapter18_jdb.tchapter18.GetCLOB;

import java.sql.*;
import java.io.*;

public class GetClob{
	public static void main(String[] args){
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs =  null;
	    FileOutputStream fos = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url=   "jdbc:oracle:thin:@localhost:1521:ora9";
			conn = DriverManager.getConnection(url,"scott","tiger");
			String sql="select * from book_list where bid='b001'";
			stmt = conn.prepareStatement(sql);			
			rs = stmt.executeQuery();
            rs.next();            			
			
			StringBuffer sb = new StringBuffer();
            Reader rd = rs.getCharacterStream(3);
            BufferedReader br = new BufferedReader(rd);
			String s;
            while((s=br.readLine())!=null)
            {
                sb.append(s + "\n");
            }
            System.out.println(sb.toString());
            
            rs.close();
            br.close();
			stmt.close();
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
