package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.dao.JdbcUtils;
import com.project.dao.UserDao;
import com.project.vo.UserVo;

public class UserDao {

	// �̱��� ���� ����
	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	/////////////////

	private UserDao() {
	}

	// ȸ������
	public void addUser(UserVo userVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";
			sql += "INSERT INTO user (id, passwd, name, birthday, gender, email, tel) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVo.getId());
			pstmt.setString(2, userVo.getPasswd());
			pstmt.setString(3, userVo.getName());
			pstmt.setString(4, userVo.getBirthday());
			pstmt.setString(5, userVo.getGender());
			pstmt.setString(6, userVo.getEmail());
			pstmt.setString(7, userVo.getTel());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // addUser
	
	// ���̵� �ߺ�üũ
	public int getCountById(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			con = JdbcUtils.getConnection();
			
			String sql = "";
			
			sql += "SELECT COUNT(*) FROM user WHERE id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return count;
	} // getCountById

	// �α��� Ȯ��
	public int loginCheck(String id, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int check = -1; // ���� ���̵� ���°����� �ʱ�ȭ

		try {
			con = JdbcUtils.getConnection();

			// id�� �ش��ϴ� passwd ��������
			String sql = "";
			sql = "SELECT passwd FROM user WHERE id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (passwd.equals(rs.getString("passwd"))) {
					check = 1;
				} else {
					check = 0;
				}
			} else {
				check = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return check;
	} // userCheck

	// ���̵� ã��
	public String idSearch(String name, String tel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String id = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";
			sql = "SELECT id FROM user WHERE name = ? AND tel = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return id;
	} // idCheck

	// ��й�ȣ ã��
	public String passwdSearch(String id, String tel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String passwd = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";
			sql = "SELECT passwd FROM user WHERE id = ? AND tel = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, tel);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				passwd = rs.getString("passwd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return passwd;
	} // passwdSearch
	
	
	
}
