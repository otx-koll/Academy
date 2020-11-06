package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.exam.vo.NoticeVo;

public class NoticeDao {
	// 싱글톤
	private static NoticeDao instance = new NoticeDao();

	public static NoticeDao getInstance() {
		return instance;
	}
	/////////////

	private NoticeDao() {
	}

	public void addNotice(NoticeVo noticeVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "INSERT INTO notice (id, subject, content, readcount, reg_date, ip, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeVo.getId());
			pstmt.setString(2, noticeVo.getSubject());
			pstmt.setString(3, noticeVo.getContent());
			pstmt.setInt(4, noticeVo.getReadcount());
			pstmt.setTimestamp(5, noticeVo.getRegDate());
			pstmt.setString(6, noticeVo.getIp());
			pstmt.setInt(7, noticeVo.getReRef());
			pstmt.setInt(8, noticeVo.getReLev());
			pstmt.setInt(9, noticeVo.getReSeq());
			// 실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // addBoard()

	public NoticeVo getBoardByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		NoticeVo noticeVo = null;
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "SELECT * FROM notice WHERE num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				noticeVo = new NoticeVo();

				noticeVo.setNum(rs.getInt("num"));
				noticeVo.setName(rs.getString("name"));
				noticeVo.setPasswd(rs.getString("passwd"));
				noticeVo.setSubject(rs.getString("subject"));
				noticeVo.setContent(rs.getString("content"));
				noticeVo.setReadcount(rs.getInt("readcount"));
				noticeVo.setRegDate(rs.getTimestamp("reg_date"));
				noticeVo.setIp(rs.getString("ip"));
				noticeVo.setFile(rs.getString("file"));
				noticeVo.setReRef(rs.getInt("re_ref"));
				noticeVo.setReLev(rs.getInt("re_lev"));
				noticeVo.setReSeq(rs.getInt("re_seq"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return noticeVo;
	} // getBoardByNum()

	public void updateReadcount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "UPDATE notice ";
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

	// 전체글갯수 가져오기
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "SELECT COUNT(*) FROM notice";

			pstmt = con.prepareStatement(sql);

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
	} // getCount()

	public List<NoticeVo> getBoards(int startRow, int pageSize) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<NoticeVo> list = new ArrayList<>();
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "SELECT * ";
			sql += "FROM notice ";
			sql += "ORDER BY re_ref DESC, re_seq ASC ";
			sql += "LIMIT ?, ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setNum(rs.getInt("num"));
				noticeVo.setName(rs.getString("name"));
				noticeVo.setPasswd(rs.getString("passwd"));
				noticeVo.setSubject(rs.getString("subject"));
				noticeVo.setContent(rs.getString("content"));
				noticeVo.setReadcount(rs.getInt("readcount"));
				noticeVo.setRegDate(rs.getTimestamp("reg_date"));
				noticeVo.setIp(rs.getString("ip"));
				noticeVo.setFile(rs.getString("file"));
				noticeVo.setReRef(rs.getInt("re_ref"));
				noticeVo.setReLev(rs.getInt("re_lev"));
				noticeVo.setReSeq(rs.getInt("re_seq"));

				list.add(noticeVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return list;
	} // getBoards()

	// 글번호에 해당하는 패스워드 일치여부 확인하기
	public boolean isPasswdOk(int num, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean isPasswdOk = false;
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "SELECT COUNT(*) ";
			sql += "FROM notice ";
			sql += "WHERE num = ? ";
			sql += "AND passwd = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, passwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 1) {
					isPasswdOk = true;
				} else {
					isPasswdOk = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return isPasswdOk;
	} // isPasswdOk()

	public void updateBoard(NoticeVo noticeVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "UPDATE notice ";
			sql += "SET name = ?, subject = ?, content = ?, file = ? ";
			sql += "WHERE num = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeVo.getName());
			pstmt.setString(2, noticeVo.getSubject());
			pstmt.setString(3, noticeVo.getContent());
			pstmt.setString(4, noticeVo.getFile());
			pstmt.setInt(5, noticeVo.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // updateBoard

	public void deleteBoardByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			sql = "DELETE FROM notice WHERE num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteBoard

	public boolean updateAndAddReply(NoticeVo noticeVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			con = JdbcUtils.getConnection();

			con.setAutoCommit(false); // 수동커밋으로 변경

			sql = "UPDATE notice ";
			sql += "SET re_seq = re_seq + 1 ";
			sql += "WHERE re_ref = ? ";
			sql += "AND re_seq > ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noticeVo.getReRef());
			pstmt.setInt(2, noticeVo.getReSeq());
			// update 수행
			pstmt.executeUpdate();
			// update문장을 가진 pstmt 객체 닫기
			pstmt.close();

			sql = "INSERT INTO notice (num, name, passwd, subject, content, readcount, reg_date, ip, file, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noticeVo.getNum());
			pstmt.setString(2, noticeVo.getName());
			pstmt.setString(3, noticeVo.getPasswd());
			pstmt.setString(4, noticeVo.getSubject());
			pstmt.setString(5, noticeVo.getContent());
			pstmt.setInt(6, noticeVo.getReadcount());
			pstmt.setTimestamp(7, noticeVo.getRegDate());
			pstmt.setString(8, noticeVo.getIp());
			pstmt.setString(9, noticeVo.getFile());
			pstmt.setInt(10, noticeVo.getReRef()); // 같은 그룹
			pstmt.setInt(11, noticeVo.getReLev() + 1); // 답글쓰는 대상글의 들여쓰기 + 1
			pstmt.setInt(12, noticeVo.getReSeq() + 1); // 답글쓰는 대상글의 그룹내 순번 + 1
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

		NoticeDao boardDao = NoticeDao.getInstance();

		for (int i = 0; i < 100; i++) {
			NoticeVo noticeVo = new NoticeVo();

			int num = boardDao.getNextNum();
			noticeVo.setNum(num);
			noticeVo.setName("홍길동" + num);
			noticeVo.setPasswd("1234");
			noticeVo.setSubject("글제목" + num);
			noticeVo.setContent("글내용" + num);
			noticeVo.setReadcount(0);
			noticeVo.setRegDate(new Timestamp(System.currentTimeMillis()));
			noticeVo.setIp("127.0.0.1");
			noticeVo.setReRef(num);
			noticeVo.setReLev(0);
			noticeVo.setReSeq(0);

			System.out.println(noticeVo);

			boardDao.addBoard(noticeVo);
		} // for

	} // main()

}
