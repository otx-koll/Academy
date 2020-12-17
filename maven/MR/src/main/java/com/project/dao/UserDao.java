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
	
	// 회원정보 1개 insert하기
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
	
	// 로그인 확인
	// check -1이면 없는 아이디
	// check 0이면 패스워드 틀림
	// check 1이면 아이디, 패스워드 모두 일치
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
	} // userCheck

}
