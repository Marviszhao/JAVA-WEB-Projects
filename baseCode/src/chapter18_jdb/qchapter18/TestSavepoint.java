package chapter18_jdb.qchapter18;

import java.sql.*;
public class TestSavepoint{
	public static void main(String[] args){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/test";
		    conn = DriverManager.getConnection(url,"root","123456");
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into teacher values(11,'Tom',2500)");
			stmt.executeUpdate("insert into teacher values(12,'John',3400)");
			Savepoint sp1 = conn.setSavepoint("p1");
			stmt.executeUpdate("insert into teacher values(13,'Billy',3150)");
			Savepoint sp2 = conn.setSavepoint("p2");
			stmt.executeUpdate("update teacher set salary = salary+8888 where tid = 12");
			ResultSet rs = stmt.executeQuery("select avg(salary) from teacher");
			rs.next();
			double avg_sal = rs.getDouble(1);
			if(avg_sal > 4000){
				conn.rollback(sp1);	
			}else if(avg_sal >= 3000){
				conn.rollback(sp2);	
			}
			conn.commit();
			
			rs = stmt.executeQuery("select * from teacher");
			while(rs.next()){
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2).trim() + "\t" + rs.getDouble(3));	
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			System.out.println("Failure,rollback!");
		    try{
		    	conn.rollback();   
		    }catch(Exception e1){
		    	e.printStackTrace();	
		    }		    
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
