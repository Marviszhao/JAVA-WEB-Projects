package chapter18_jdb.bchapter18;

import java.sql.*;

public class TestDML{
    public static void main(String args[]){
		try{		   
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/test";
		    Connection conn = DriverManager.getConnection(url,"root","123456");
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate("insert into user_java values(041,'张三',18)");
		    stmt.executeUpdate("insert into user_java values(042,'李四',20)");
		    stmt.executeUpdate("insert into user_java values(043,'王五',19)");
		    ResultSet rs = stmt.executeQuery("select * from user_java");
		    while(rs.next()){
				System.out.print("学号: " + rs.getString(1));
				System.out.print("\t姓名: " + rs.getString(2));
				System.out.println("\t薪水: " + rs.getInt(3));}
			rs.close();
			stmt.executeUpdate("update user_java set id=id+10");
			stmt.executeUpdate("delete from user_java where id=002");
			System.out.println("--------------更新/删除数据后---------------");
			rs = stmt.executeQuery("select * from user_java");
		    while(rs.next()){
				System.out.print("学号: " + rs.getString("id"));
				System.out.print("\t姓名: " + rs.getString("name"));
				System.out.println("\t薪水: " + rs.getString("salary"));	}
			rs.close();stmt.close();conn.close();
		}catch(Exception e){
		    e.printStackTrace();
		}
    }
}
