package com.j2kb.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;



public class mysqlConnectionTest {
	private static final String url =
			"jdbc:mysql://"
			+ "j2kb-db.c9wp5lw8dgv8.ap-northeast-2.rds.amazonaws.com:3306/sys"
			+ "?serverTimezone=UTC";
	private static final String id = "admin";
	private static final String pw = "j2kbweb1212!";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Test
	public void sqlConnectionTest() {
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
	
	@Test
	public void sqlSelectTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "SELECT * FROM MEMBERS";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("member id: " + rs.getString("MEMBER_ID"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	}
}
