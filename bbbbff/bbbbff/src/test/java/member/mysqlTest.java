package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class mysqlTest {
	private static final String url =
			"jdbc:mysql://"
			+ "j2kb-db.c9wp5lw8dgv8.ap-northeast-2.rds.amazonaws.com:3306/sys"
			+ "?serverTimezone=UTC";
	private static final String id = "admin";
	private static final String pw = "j2kbweb1212!";

	private Connection conn;
	
	@Test
	public void sqlTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			System.out.println("JDBC 드라이버 연결 오류");
			e.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
}
