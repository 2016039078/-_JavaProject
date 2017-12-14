package gp;

import java.sql.*;
public class ConnectDatabase {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/bread";
		String id = "root";
		String password = "111111";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("����̹� ���� ����");
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("���̹� ���̽� ���� ����");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		}catch(SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		return conn;
	}
	public static void main(String arg[]) throws SQLException{
		Connection conn = makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM flat");
		while(rs.next()) {
			String name = rs.getString("Name");
			int weight = rs.getInt("Weight");
			int kcal = rs.getInt("Kcal");
			System.out.println(name+" "+weight+" "+kcal);
		}
	}
}
