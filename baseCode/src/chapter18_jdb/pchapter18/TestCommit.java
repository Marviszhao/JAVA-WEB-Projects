package chapter18_jdb.pchapter18;

import java.sql.*;

public class TestCommit{
    public static void main(String args[]){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/test";
		    conn = DriverManager.getConnection(url,"root","123");
			boolean autoCommit = conn.getAutoCommit();
			
		    // 关闭自动提交功能
		    conn.setAutoCommit(false);
		    Statement stmt=conn.createStatement();
		    stmt.executeUpdate("insert into dept values (77,'Market','Beijing')");
		    stmt.executeUpdate("insert into dept values (88,'R&D','Shanghai')");
		    ResultSet rs=stmt.executeQuery("select * from dept");
		    while(rs.next()){
				System.out.print("DeptNo: "+rs.getInt(1));
				System.out.print("\tDeptName: "+rs.getString(2));
				System.out.println("\tLOC: "+rs.getString(3));						    
			}
			// 提交事务
			conn.commit();      
			// 恢复原来的提交模式
			conn.setAutoCommit(autoCommit);
			stmt.close();
		}catch(Exception e){
			System.out.println("操作失败、任务撤消！");
		    try{
		    	// 回滚、取消前述操作
		    	conn.rollback();   
		    }catch(Exception e1){
		    	e.printStackTrace();	
		    }		    
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
