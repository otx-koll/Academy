package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.vo.AttachVo;
import com.project.vo.ReviewVo;

public class ReviewDao {
	private static ReviewDao instance = new ReviewDao();

	public static ReviewDao getInstance() {
		return instance;
	}

	////////////////

	private ReviewDao() {
	}

	// 주글쓰기 메서드
	public void addReview(ReviewVo reviewVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "INSERT INTO review (id, mv_subject, subject, content, reg_date) ";
			sql += "VALUES (?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reviewVo.getId());
			pstmt.setString(2, reviewVo.getMvSubject());
			pstmt.setString(3, reviewVo.getSubject());
			pstmt.setString(4, reviewVo.getContent());
			pstmt.setTimestamp(5, reviewVo.getRegDate());

			// 실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // addReview()

	// 검색어를 적용한 글갯수 가져오기
	public int getCountBySearch(String category, String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "SELECT COUNT(*) FROM review ";

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
				pstmt.setString(1, search); // 물음표에 검색어 설정
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

	// 검색한 목록 불러오기
	public List<ReviewVo> getReviewBySearch(int startRow, int pageSize, String category, String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ReviewVo> list = new ArrayList<>();
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "SELECT * ";
			sql += "FROM review ";
			// 동적 sql 구현
			if (category.equals("subject")) {
				sql += "WHERE subject LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("content")) {
				sql += "WHERE content LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("id")) {
				sql += "WHERE id LIKE CONCAT('%', ?, '%') ";
			}
			sql += "ORDER BY num DESC ";
			sql += "LIMIT ?, ? ";

			pstmt = con.prepareStatement(sql);

			if (!category.equals("")) { // 검색어가 있을때
				pstmt.setString(1, search); // 물음표에 검색어 설정
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, pageSize);
			} else { // 검색어가 없을때
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, pageSize);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewVo reviewVo = new ReviewVo();
				reviewVo.setNum(rs.getInt("num"));
				reviewVo.setId(rs.getString("id"));
				reviewVo.setMvSubject(rs.getString("mv_subject"));
				reviewVo.setSubject(rs.getString("subject"));
				reviewVo.setContent(rs.getString("content"));
				reviewVo.setRegDate(rs.getTimestamp("reg_date"));

				list.add(reviewVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return list;
	} // getForumsBySearch()

	// 글 하나 가져오기
	public ReviewVo getReviewByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ReviewVo reviewVo = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";

			sql = "SELECT * FROM review WHERE num = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				reviewVo = new ReviewVo();

				reviewVo.setId(rs.getString("id"));
				reviewVo.setMvSubject(rs.getString("mv_subject"));
				reviewVo.setSubject(rs.getString("subject"));
				reviewVo.setContent(rs.getString("content"));
				reviewVo.setRegDate(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return reviewVo;
	} // getForumByNum

	// 게시글 하나 삭제
	public void deleteReviewByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "DELETE FROM review WHERE num = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteReviewByNum

	// review 테이블과 attach 테이블 왼쪽 외부조인해서 가져오기
	public ReviewVo getReviewAndAttaches(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ReviewVo reviewVo = new ReviewVo();
		List<AttachVo> attachList = new ArrayList<>();
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "SELECT r.num, r.id, r.mv_subject, r.subject, r.content, r.reg_date, ";
			sql += "       a.num as anum, a.filename, a.uploadpath, a.image, a.no_num ";
			sql += "FROM review r LEFT OUTER JOIN attach a ";
			sql += "ON r.num = a.no_num ";
			sql += "WHERE r.num = ? ";

			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AttachVo attachVo = new AttachVo();
				attachVo.setNum(rs.getInt("anum"));
				attachVo.setFilename(rs.getString("filename"));
				attachVo.setUploadpath(rs.getString("uploadpath"));
				attachVo.setImage(rs.getString("image"));
				attachVo.setNoNum(rs.getInt("no_num"));

				attachList.add(attachVo);
			} // while

			rs.last(); // 데이터가 존재하는 행으로 커서위치 이동시키기

			reviewVo.setNum(rs.getInt("num"));
			reviewVo.setId(rs.getString("id"));
			reviewVo.setMvSubject(rs.getString("mv_subject"));
			reviewVo.setSubject(rs.getString("subject"));
			reviewVo.setContent(rs.getString("content"));
			reviewVo.setRegDate(rs.getTimestamp("reg_date"));

			reviewVo.setAttachList(attachList); // 첨부파일 리스트 저장

			System.out.println("조인결과 : \n" + reviewVo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return reviewVo;
	} // getNoticeAndAttaches
}
