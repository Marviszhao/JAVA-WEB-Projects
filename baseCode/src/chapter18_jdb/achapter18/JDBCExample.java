package chapter18_jdb.achapter18;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
//1 ��������
//2 ��������
//3 ����ִ��sql��statement����
//4 �����õ��Ľ����
public class JDBCExample{
    public static void main(String args[]){
		try{		    
			
			Class.forName("com.mysql.jdbc.Driver");//����mysql������
		    //д��mysql�ķ��ʵ�ַ���˿ں�
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");//�������ݿ�����
		    //����һ������ִ��sql��statment����
		    Statement stmt = conn.createStatement();
		    //��ѯ��sql���ص�һ�������
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
