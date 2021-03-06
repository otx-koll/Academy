package com.exam.dao;

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
		// 헤로쿠 MySQL DB
		// mysql://bf2e748931b0cb:ed3fde98@us-cdbr-east-02.cleardb.com/heroku_84ab2d598813ce4?reconnect=true&useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul

		// 헤로쿠DB id : bf2e748931b0cb
		// 헤로쿠DB ps : ed3fde98
		// 헤로쿠DB localhost : us-cdbr-east-02.cleardb.com
		// 헤로쿠DB 스키마이름 : heroku_84ab2d598813ce4
		// ================================================
		
		Connection con = null;
		
		// DB접속정보
//		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
//		String dbId = "myid";
//		String dbPwd = "mypwd";
//
//		// 1단계. DB드라이버 클래스 로딩
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		// 2단계. DB에 연결 시도. 연결후 Connection객체를 리턴함.
//		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		// ================================================

		// 커넥션 풀 방식 // 톰캣에 의존적. 배포할때는 이 코드. 개발할때는 위에 코드로 해봄
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection(); // 커넥션 한개 빌려오기
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
}
