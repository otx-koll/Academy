package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtils {
	
	public static Connection getConnection() throws Exception { // 호출 가능하게 static
		Connection con = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";

		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		// ================================================

		// 커넥션 풀 방식 // 톰캣에 의존적. 배포할때는 이 코드. 개발할때는 위에 코드로 해봄
//		Context context = new InitialContext();
//		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jspdb");
//		con = ds.getConnection(); // 커넥션 한개 빌려오기
		return con;
	} // getConnection()

	public static void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // close()
	
	public static int getNextNum(String tableName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = 0;
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "SELECT AUTO_INCREMENT ";
			sql += "FROM information_schema.tables ";
			sql += "WHERE table_name = ? "; // 
			sql += "AND table_schema = DATABASE() ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tableName);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return num;
	} // getNextNum()
}
