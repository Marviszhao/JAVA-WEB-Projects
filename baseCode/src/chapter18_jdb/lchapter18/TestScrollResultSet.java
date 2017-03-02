package chapter18_jdb.lchapter18;

import java.sql.*;

public class TestScrollResultSet {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123456");
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select * from user_java");
			while (rs.next()) {
				showOneRow(rs);
			}
			System.out.println("-----------");
			rs.last();
			showOneRow(rs);
			rs.first();
			showOneRow(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void showOneRow(ResultSet rs) throws SQLException {
		System.out.print("µÚ" + rs.getRow() + "ÐÐ: ");
		System.out.print(rs.getString(1));
		System.out.print("\t" + rs.getString(2));
		System.out.print("\t" + rs.getString(3));
		System.out.println();
	}
}
