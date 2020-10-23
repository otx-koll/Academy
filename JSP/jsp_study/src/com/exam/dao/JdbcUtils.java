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
	
	public static Connection getConnection() throws Exception { // ȣ�� �����ϰ� static
		// ����� MySQL DB
		// mysql://bf2e748931b0cb:ed3fde98@us-cdbr-east-02.cleardb.com/heroku_84ab2d598813ce4?reconnect=true&useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul

		// �����DB id : bf2e748931b0cb
		// �����DB ps : ed3fde98
		// �����DB localhost : us-cdbr-east-02.cleardb.com
		// �����DB ��Ű���̸� : heroku_84ab2d598813ce4
		// ================================================
		
		Connection con = null;
		
		// DB��������
//		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
//		String dbId = "myid";
//		String dbPwd = "mypwd";
//
//		// 1�ܰ�. DB����̹� Ŭ���� �ε�
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		// 2�ܰ�. DB�� ���� �õ�. ������ Connection��ü�� ������.
//		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		// ================================================

		// Ŀ�ؼ� Ǯ ��� // ��Ĺ�� ������. �����Ҷ��� �� �ڵ�. �����Ҷ��� ���� �ڵ�� �غ�
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection(); // Ŀ�ؼ� �Ѱ� ��������
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
