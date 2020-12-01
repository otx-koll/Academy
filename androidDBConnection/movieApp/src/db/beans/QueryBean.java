package db.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryBean {
	Connection con;
	Statement stmt;
	ResultSet rs;

	public QueryBean() {
		con = null;
		stmt = null;
		rs = null;
	}

	public void getConnection() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
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

		sb.append(" SELECT ");
		sb.append(" id, name, password, write_time ");
		sb.append(" from ");
		sb.append(" movie ");
		sb.append(" order by write_time ");

		rs = stmt.executeQuery(sb.toString());

		ArrayList res = new ArrayList();
		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
		}
		System.out.print(sb.toString());
		return res;
	}

	public ArrayList getUserInfo(String id) throws Exception {
		StringBuffer sb = new StringBuffer();

		sb.append(" SELECT ");
		sb.append(" id, name, password, write_time ");
		sb.append(" from ");
		sb.append(" movie ");
		sb.append(" where ");
		sb.append(" id like '%" + id + "%' ");
		sb.append("order by write_time ");
		sb.append(" desc ");

		rs = stmt.executeQuery(sb.toString());

		ArrayList res = new ArrayList();

		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
		}
		System.out.print(sb.toString());
		return res;
	}

	public int setUserInfo(String id, String name, String password) {

		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;

		sb.append(" INSERT INTO ");
		sb.append(" movie (id, name, password, write_time) ");
		sb.append(" VALUES ");
		sb.append(" ('" + id + "', '" + name + "', '" + password + "', now() ) ");

		System.out.println(sb.toString());

		int res = 0;

		try {
			pstmt = con.prepareStatement(sb.toString()); 

			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public int loginCheck(String id, String passwd) {
		// check -1이면 없는 아이디
		// check 0이면 패스워드 틀림
		// check 1이면 아이디, 패스워드 모두 일치
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
		sb.append("SELECT * ");
		sb.append("FROM movie ");
		sb.append("WHERE ");
		sb.append(" id = '" + id + "' AND password = '" + passwd + "' ");
		
		int check = -1;
		
		try {
			pstmt = con.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery(sb.toString());
			
			if (rs.next()) {
				check = 1;
			} else {
//				if (passwd.equals(rs.getString("password"))) {
//					check = 0;
//				} else {
//					check = -1;
//				}
				check = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(sb.toString());
		
		return check;
	}
	
}
