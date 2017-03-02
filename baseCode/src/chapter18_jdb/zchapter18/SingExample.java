package chapter18_jdb.zchapter18;

import java.sql.*;

public class SingExample {

	Connection con;
	PreparedStatement ps;

	public void doSing(String sql) {
		JdbcUtilsSing jdbcUtilsSing = JdbcUtilsSing.getInstance();
		try {
			con = jdbcUtilsSing.getConnection();
			ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SingExample singExample = new SingExample();
//		singExample.doSing("insert into user_java (name,salary) values ('jerry1',10002) ");
		singExample.doSing("delete from  user_java where id =  1007 ");
	}
	

}
