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
			
		    // �ر��Զ��ύ����
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
			// �ύ����
			conn.commit();      
			// �ָ�ԭ�����ύģʽ
			conn.setAutoCommit(autoCommit);
			stmt.close();
		}catch(Exception e){
			System.out.println("����ʧ�ܡ���������");
		    try{
		    	// �ع���ȡ��ǰ������
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
