package chapter18_jdb.mchapter18;

import java.sql.*;
public class TestUpdatableResultSet{
    public static void main(String args[]){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/test";
		    conn = DriverManager.getConnection(url,"root","123456");
			Statement stmt = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select id,name,salary from user_java");
			//更新前结果集中数据
			while(rs.next()){
				showOneRow(rs);		
			}
			//更新和删除记录
			rs.beforeFirst();
			while(rs.next()){
				String name = rs.getString("name").trim();
				if(name.equals("李四")){
					double sal = rs.getDouble("salary");
					rs.updateDouble("salary", sal + 8888);
					rs.updateRow();	
				}else if(name.equals("张三")){
					rs.deleteRow();	
				}	
			}
			//插入新记录
			rs.moveToInsertRow();
			rs.updateInt("id",1005);
			rs.updateString("name","云飞扬");
			rs.updateDouble("salary",2840);
			rs.insertRow();
			rs.close();
			
			//结果集更新后后数据库中数据
			System.out.println("--------------------------------------------");
			rs = stmt.executeQuery("select * from user_java");
			while(rs.next()){
				showOneRow(rs);		
			}
			rs.close();
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
    
    public static void showOneRow(ResultSet rs) throws SQLException{
    	System.out.print("第" + rs.getRow() + "行: ");
		System.out.print(rs.getInt(1));
		System.out.print("\t" + rs.getString(2));
		System.out.print("\t" + rs.getDouble(3));
		System.out.println();
    }
}
