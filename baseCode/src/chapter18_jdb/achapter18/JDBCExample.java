package chapter18_jdb.achapter18;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
//1 加载驱动
//2 创建链接
//3 创建执行sql的statement对象
//4 操作得到的结果集
public class JDBCExample{
    public static void main(String args[]){
		try{		    
			
			Class.forName("com.mysql.jdbc.Driver");//加载mysql的驱动
		    //写明mysql的访问地址及端口号
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");//创建数据库链接
		    //创建一个用来执行sql的statment对象
		    Statement stmt = conn.createStatement();
		    //查询完sql返回的一个结果集
		    ResultSet rs = stmt.executeQuery("select * from user_java");
		    while(rs.next()){
				System.out.print("id: " + rs.getInt(1));
				System.out.print("\tuname: " + rs.getString(2));
				System.out.println("\tsalary: " + rs.getInt(3));						    
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e){
		}
    }
  }
