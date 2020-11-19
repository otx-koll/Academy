package db.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryBean {
	Connection con; // 연결 객체
	Statement stmt; // 질외 객체 // 물음표가 없으면 Statement. 있으면 preparedstatement
	ResultSet rs; 	// 결과 객체
	
	public QueryBean() {
		con = null;
		stmt = null;
		rs = null;
	}
	
	public void getConnection() { // 연결 하기
		try {
			con = DBConnection.getConnetcion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() { // 연결 끊기
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList getUserInfo() throws Exception {
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT ");
		sb.append("U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME ");
		sb.append("FROM ");
		sb.append("user_info_sample ");
		sb.append("ORDER BY ");
		sb.append("WRITE_TIME ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
			res.add(rs.getString(5));
		}
		System.out.print(sb.toString());
		return res;
	}
	
	public ArrayList getUserInfo(String id) throws Exception {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT ");
		sb.append(" U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME ");
		sb.append(" FROM ");
		sb.append(" user_info_sample ");
		sb.append(" WHERE ");
		sb.append(" U_ID like '%" + id + "%' ");
		sb.append(" ORDER BY WRITE_TIME ");
		sb.append(" DESC ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		
		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
			res.add(rs.getString(5));
		}
		System.out.print(sb.toString());
		return res;
	}
	
	public int setUserInfo(String id, String name, String phone, String grade) {
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
		sb.append(" INSERT INTO ");
		sb.append(" USER_INFO_SAMPLE (U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME) ");
		sb.append(" VALUES ");
		sb.append(" ('" + id + "', '" + name + "', '" + phone + "', '" + grade + "', now() ) ");
		
		System.out.println(sb.toString());

		int res = 0;
		
		try {
			pstmt = con.prepareStatement(sb.toString()); // preparedstatement로 하면 이렇게 해야함
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close(); // 메모리 누수가 일어나기때문에 해줘야함
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public int deleteUserInfo(String id) throws Exception {
		int res = 0;
		
		PreparedStatement pstmt = null;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("DELETE ");
		sb.append("FROM ");
		sb.append("USER_INFO_SAMPLE ");
		sb.append("WHERE ");
		sb.append("U_ID = ? ");
		
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.clearParameters();
			pstmt.setString(1, id);
			
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			} 
		}
		return res;
	}
	
	public int updateUserInfo(String id, String name, String phone, String grade) {
		int res = 0;
		
		PreparedStatement pstmt = null;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE ");
		sb.append("USER_INFO_SAMPLE ");
		sb.append("SET U_NAME = ?, U_PHONE = ?, U_GRADE = ?, WRITE_TIME = now() ");
		sb.append("WHERE U_ID = ? ");
		
		System.out.println(sb.toString());
		
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.clearParameters();
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, grade);
			pstmt.setString(4, id);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

//	public ArrayList searchUserInfo(String strUser) throws Exception {
//		StringBuffer sb = new StringBuffer();
//		
//		sb.append(" SELECT ");
//		sb.append(" U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME ");
//		sb.append(" FROM ");
//		sb.append(" user_info_sample ");
//		sb.append(" WHERE ");
//		sb.append(" U_ID like '%" + strUser + "%' ");
//		sb.append(" ORDER BY ");
//		sb.append(" WRITE_TIME ");
//		sb.append(" DESC ");
//		
//		rs = stmt.executeQuery(sb.toString());
//		
//		ArrayList res = new ArrayList();
//		while (rs.next()) {
//			res.add(rs.getString(1));
//			res.add(rs.getString(2));
//			res.add(rs.getString(3));
//			res.add(rs.getString(4));
//			res.add(rs.getString(5));
//		}
//		System.out.print(sb.toString());
//		return res;
//	}
}
