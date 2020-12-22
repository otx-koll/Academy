package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.project.vo.*;

public class ForumDao {
	// 싱글톤
	private static ForumDao instance = new ForumDao();
	
	public static ForumDao getInstance() {
		return instance;
	}
	/////////////

	private ForumDao() {}
	
	// 주글쓰기 메서드
	public void addForum(ForumVo forumVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "INSERT INTO forum (id, subject, content, readcount, reg_date, ip, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, forumVo.getId());
			pstmt.setString(2, forumVo.getSubject());
			pstmt.setString(3, forumVo.getContent());
			pstmt.setInt(4, forumVo.getReadcount());
			pstmt.setTimestamp(5, forumVo.getRegDate());
			pstmt.setString(6, forumVo.getIp());
			pstmt.setInt(7, forumVo.getReRef());
			pstmt.setInt(8, forumVo.getReLev());
			pstmt.setInt(9, forumVo.getReSeq());
			// 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // addBoard()
	
	//
	public ForumVo getForumByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ForumVo forumVo = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT * FROM forum WHERE num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				forumVo = new ForumVo();
				
				forumVo.setNum(rs.getInt("num"));
				forumVo.setId(rs.getString("id"));
				forumVo.setSubject(rs.getString("subject"));
				forumVo.setContent(rs.getString("content"));
				forumVo.setReadcount(rs.getInt("readcount"));
				forumVo.setRegDate(rs.getTimestamp("reg_date"));
				forumVo.setIp(rs.getString("ip"));
				forumVo.setReRef(rs.getInt("re_ref"));
				forumVo.setReLev(rs.getInt("re_lev")); 
				forumVo.setReSeq(rs.getInt("re_seq"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return forumVo;
	} // getForumByNum()
	
	// 조회수 카운트
	public void updateReadcount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "UPDATE Forum ";
			sql += "SET readcount = readcount + 1 ";
			sql += "WHERE num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // updateReadcount()
	
	// 검색어를 적용한 글갯수 가져오기
	public int getCountBySearch(String category, String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT COUNT(*) FROM Forum ";
			
			// 동적 sql 구현
			if (category.equals("subject")) {
				sql += "WHERE subject LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("content")) {
				sql += "WHERE content LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("id")) {
				sql += "WHERE id LIKE CONCAT('%', ?, '%') ";
			}
			
			pstmt = con.prepareStatement(sql);
			
			if (!category.equals("")) { // 검색어가 있을때
				pstmt.setString(1, search);  // 물음표에 검색어 설정
			}
			
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
	} // getCountBySearch()
	
	// 목록 불러오기
	public List<ForumVo> getForums(int startRow, int pageSize) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ForumVo> list = new ArrayList<>();
		
		try {
			con = JdbcUtils.getConnection();
			
			String sql = "";
			
			sql = "SELECT * ";
			sql += "FROM forum ";
			sql += "ORDER BY re_ref DESC, re_seq ASC ";
			sql += "LIMIT ?, ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ForumVo forumVo = new ForumVo();
				forumVo.setNum(rs.getInt("num"));
				forumVo.setId(rs.getString("id"));
				forumVo.setSubject(rs.getString("subject"));
				forumVo.setContent(rs.getString("content"));
				forumVo.setReadcount(rs.getInt("readcount"));
				forumVo.setRegDate(rs.getTimestamp("reg_date"));
				forumVo.setIp(rs.getString("ip"));
				forumVo.setReRef(rs.getInt("re_ref"));
				forumVo.setReLev(rs.getInt("re_lev"));
				forumVo.setReSeq(rs.getInt("re_seq"));
				forumVo.setThumbsUp(rs.getInt("thumbs_up"));
				
				list.add(forumVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return list;
	} // getForums
	
	// 목록 불러오기
	public List<ForumVo> getForumBySearch(int startRow, int pageSize, String category, String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ForumVo> list = new ArrayList<>();
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "SELECT * ";
			sql += "FROM Forum ";
			// 동적 sql 구현
			if (category.equals("subject")) {
				sql += "WHERE subject LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("content")) {
				sql += "WHERE content LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("id")) {
				sql += "WHERE id LIKE CONCAT('%', ?, '%') ";
			}
			sql += "ORDER BY re_ref DESC, re_seq ASC ";
			sql += "LIMIT ?, ? ";
			
			pstmt = con.prepareStatement(sql);
			
			if (!category.equals("")) { // 검색어가 있을때
				pstmt.setString(1, search);  // 물음표에 검색어 설정
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, pageSize);
			} else { // 검색어가 없을때
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, pageSize);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ForumVo forumVo = new ForumVo();
				forumVo.setNum(rs.getInt("num"));
				forumVo.setId(rs.getString("id"));
				forumVo.setSubject(rs.getString("subject"));
				forumVo.setContent(rs.getString("content"));
				forumVo.setReadcount(rs.getInt("readcount"));
				forumVo.setRegDate(rs.getTimestamp("reg_date"));
				forumVo.setIp(rs.getString("ip"));
				forumVo.setReRef(rs.getInt("re_ref"));
				forumVo.setReLev(rs.getInt("re_lev")); 
				forumVo.setReSeq(rs.getInt("re_seq"));
				
				list.add(forumVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return list;
	} // getForumsBySearch()
	
	public void updateBoard(ForumVo forumVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "UPDATE Forum ";
			sql += "SET subject = ?, content = ? ";
			sql += "WHERE num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, forumVo.getSubject());
			pstmt.setString(2, forumVo.getContent());
			pstmt.setInt(3, forumVo.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // updateBoard
	
	public void deleteForumByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "DELETE FROM Forum WHERE num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteForumByNum
	
	public void deleteAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "DELETE FROM Forum";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteAll
	
	
	// 답글쓰기 메서드
	public boolean updateAndAddReply(ForumVo forumVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			con.setAutoCommit(false); // 수동커밋으로 변경
			
			sql  = "UPDATE Forum ";
			sql += "SET re_seq = re_seq + 1 ";
			sql += "WHERE re_ref = ? ";
			sql += "AND re_seq > ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, forumVo.getReRef());
			pstmt.setInt(2, forumVo.getReSeq());
			// update 수행
			pstmt.executeUpdate();
			// update문장을 가진 pstmt 객체 닫기
			pstmt.close();
			
			sql  = "INSERT INTO Forum (id, subject, content, readcount, reg_date, ip, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, forumVo.getId());
			pstmt.setString(2, forumVo.getSubject());
			pstmt.setString(3, forumVo.getContent());
			pstmt.setInt(4, forumVo.getReadcount());
			pstmt.setTimestamp(5, forumVo.getRegDate());
			pstmt.setString(6, forumVo.getIp());
			pstmt.setInt(7, forumVo.getReRef());  // 같은 그룹
			pstmt.setInt(8, forumVo.getReLev() + 1); // 답글쓰는 대상글의 들여쓰기 + 1
			pstmt.setInt(9, forumVo.getReSeq() + 1); // 답글쓰는 대상글의 그룹내 순번 + 1

			// insert문 실행
			pstmt.executeUpdate();
			
			con.commit(); // 커밋하기
			
			con.setAutoCommit(true); // 자동커밋은 기본값인 true로 수정
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback(); // 단위작업에 문제가 생기면 롤백(전체취소)하기 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			return false;
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // updateAndAddReply
	
	public static void main(String[] args) {
		
		ForumDao forumDao = ForumDao.getInstance();
		
		forumDao.deleteAll(); // 테이블 내용 모두 삭제
		
		// 주글 10개 insert하기
		for (int i=0; i<10; i++) {
			ForumVo forumVo = new ForumVo();

			forumVo.setId("user1");
			forumVo.setSubject("글제목" + i);
			forumVo.setContent("글내용" + i);
			forumVo.setReadcount(0);
			forumVo.setRegDate(new Timestamp(System.currentTimeMillis()));
			forumVo.setIp("127.0.0.1");
			forumVo.setReRef(JdbcUtils.getNextNum("Forum"));
			forumVo.setReLev(0);
			forumVo.setReSeq(0);
			
			System.out.println(forumVo);
			
			forumDao.addForum(forumVo);
		} // for
	} // main()
	
}
