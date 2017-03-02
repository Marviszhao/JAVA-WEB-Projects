package chapter18_jdb.zchapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//1 �������ݿ����ӵĲ���
//2 ʵ�ֵ���ģʽ
//3 ��̬�ļ���mysql����
//4 �ṩһ�������ĵ���connection�ķ���
//5 �ͷ�conn��stat��rs����
public final class JdbcUtilsSing {  
    private String url = "jdbc:mysql://localhost:3306/test";  
    private String user = "root";  
    private String password = "123456";  
    private static JdbcUtilsSing instance = null;  
    private JdbcUtilsSing() {  
    }  
    public static JdbcUtilsSing getInstance() {  
        if (instance == null) {  
            synchronized (JdbcUtilsSing.class) {  
                if (instance == null) {  
                    instance = new JdbcUtilsSing();  
                }  
            }  
        }  
        return instance;  
    }  
    static {  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (ClassNotFoundException e) {  
            throw new ExceptionInInitializerError(e);  
        }  
    }  
  
    public Connection getConnection() throws SQLException {  
        return DriverManager.getConnection(url, user, password);  
    }  
  
    public void free(ResultSet rs, PreparedStatement ps, Connection conn) {  
        try {  
            if (rs != null)  
                rs.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (ps != null)  
                	ps.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            } finally {  
                if (conn != null)  
                    try {  
                        conn.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
            }  
        }  
    }  
} 