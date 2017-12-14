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
			System.out.println("드라이버 적재 성공");
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("데이버 베이스 연결 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}catch(SQLException e) {
			System.out.println("연결에 실패하였습니다.");
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
