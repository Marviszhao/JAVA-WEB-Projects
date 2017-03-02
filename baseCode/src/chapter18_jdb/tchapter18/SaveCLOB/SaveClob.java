package chapter18_jdb.tchapter18.SaveCLOB;

import java.sql.*;
import java.io.*;

public class SaveClob{
	public static void main(String[] args){	
		Connection conn = null;	
	    PreparedStatement stmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:ora9";
			conn = DriverManager.getConnection(url, "scott","tiger");
			String sql = "insert into book_list values(?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,"b001");
			stmt.setString(2,"99个简单法则");
			BufferedReader br = new BufferedReader(new FileReader("a.txt"));
			StringBuffer sb = new StringBuffer();
			String s;
			while((s=br.readLine()) != null){
				sb.append(s + "\n"); 
			}
			br.close();
			String content = sb.toString();           	
			StringReader sr = new StringReader(content);
			stmt.setCharacterStream(3, sr, content.length());
			stmt.executeUpdate();
			sr.close();
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
