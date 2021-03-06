package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.dao.JdbcUtils;
import com.project.dao.UserDao;
import com.project.vo.UserVo;

public class UserDao {

	// 싱글톤 패턴 설계
	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	/////////////////

	private UserDao() {
	}

	// 회원가입
	public void addUser(UserVo userVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";
			sql += "INSERT INTO user (id, passwd, name, birthday, email, tel, reg_date) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVo.getId());
			pstmt.setString(2, userVo.getPasswd());
			pstmt.setString(3, userVo.getName());
			pstmt.setString(4, userVo.getBirthday());
			pstmt.setString(5, userVo.getEmail());
			pstmt.setString(6, userVo.getTel());
			pstmt.setTimestamp(7, userVo.getRegDate());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // addUser

	// 아이디 중복체크
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

	// 로그인 확인
	public int loginCheck(String id, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int check = -1; // 없는 아이디 상태값으로 초기화

		try {
			con = JdbcUtils.getConnection();

			// id에 해당하는 passwd 가져오기
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
	} // loginCheck

	// 아이디 찾기
	public String idSearch(String name, int tel) {
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
			pstmt.setInt(2, tel);

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

	// 비밀번호 찾기
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

	// 회원 정보 하나 가져오기
	public UserVo getUserById(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserVo userVo = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";

			sql = "SELECT * FROM user WHERE id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				userVo = new UserVo();
				userVo.setId(rs.getString("id"));
				userVo.setPasswd(rs.getString("passwd"));
				userVo.setName(rs.getString("name"));
				userVo.setBirthday(rs.getString("birthday"));
				userVo.setEmail(rs.getString("email"));
				userVo.setTel(rs.getString("tel"));
				userVo.setRegDate(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return userVo;
	} // getUserById

	// 수정하기
	public void update(UserVo userVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";

			sql = "UPDATE user ";
			sql += "SET name = ?, email = ?, tel = ? ";
			sql += "WHERE id = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getEmail());
			pstmt.setString(3, userVo.getTel());
			pstmt.setString(4, userVo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	}

	// 특정id에 해당하는 회원 1명 삭제하기
	public void deleteById(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";
			sql += "DELETE FROM user WHERE id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteById()
}
