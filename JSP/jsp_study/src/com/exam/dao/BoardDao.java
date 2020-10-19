package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.exam.vo.BoardVo;

public class BoardDao {
	// �̱���
	// �ܺο��� new������ ������ ���ִ� ��
	// �ε��Ǵ� �������� ��ü ������. ��������

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	///////////////////

	private BoardDao() {
	} // �̱���

	public int getNextNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int nextNum = 0;

		String sql = "";

		try {
			con = jdbcUtils.getConnection();

			sql = "SELECT IFNULL(MAX(num),0) + 1 AS next_num ";
			sql += "FROM board";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				nextNum = rs.getInt("next_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close(con, pstmt, rs);
		}
		return nextNum;
	} // getNextNum()

	public void addBoard(BoardVo boardVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "";

		try {
			con = jdbcUtils.getConnection();

			sql = "INSERT INTO board (num, name, passwd, subject, content, readcount, reg_date, ip, file, re_ref, re_lev, re_seq) ";
			sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardVo.getNum());
			pstmt.setString(2, boardVo.getName());
			pstmt.setString(3, boardVo.getPasswd());
			pstmt.setString(4, boardVo.getSubject());
			pstmt.setString(5, boardVo.getContent());
			pstmt.setInt(6, boardVo.getReadcount());
			pstmt.setTimestamp(7, boardVo.getRegDate());
			pstmt.setString(8, boardVo.getIp());
			pstmt.setString(9, boardVo.getFile());
			pstmt.setInt(10, boardVo.getReRef());
			pstmt.setInt(11, boardVo.getReLev());
			pstmt.setInt(12, boardVo.getReSeq());
			// ����
			pstmt.executeUpdate(); // executeQuery�� resultset����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close(con, pstmt);
		}
	} // addBoard()

	public BoardVo getBoardByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BoardVo boardVo = null;
		String sql = "";

		try {
			con = jdbcUtils.getConnection();

			sql = "SELECT * FROM board WHERE num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardVo = new BoardVo();

				boardVo.setNum(rs.getInt("num"));
				boardVo.setName(rs.getString("name"));
				boardVo.setPasswd(rs.getString("passwd"));
				boardVo.setSubject(rs.getString("subject"));
				boardVo.setContent(rs.getString("content"));
				boardVo.setReadcount(rs.getInt("readcount"));
				boardVo.setRegDate(rs.getTimestamp("reg_date"));
				boardVo.setIp(rs.getString("ip"));
				boardVo.setFile(rs.getString("file"));
				boardVo.setReRef(rs.getInt("re_ref"));
				boardVo.setReLev(rs.getInt("re_lev"));
				boardVo.setReSeq(rs.getInt("re_seq"));
				// ���߿� �ٸ� �����ӿ�ũ ���� ��Ģ�� ��߳��� �����ϸ� camel case��� ���°� ����
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close(con, pstmt, rs);
		}
		return boardVo;
	} // getBoardByNum

	public void updateReadcount(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = jdbcUtils.getConnection();

			String sql = "";
			sql = "UPDATE board ";
			sql += "SET readcount = readcount + 1 ";
			sql += "WHERE num = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close(con, pstmt);
		}
	} // updateReadcount()
	
	// ��ü �� ���� ��������
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "";
		
		try {
			con = jdbcUtils.getConnection();
			
			sql = "SELECT COUNT(num) FROM board;";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1); // count(*) ������
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close(con, pstmt, rs);
		}
		return count;
	} // getCount()
	
	public List<BoardVo> getBoards(int startRow, int pageSize) { // ������� BoardVo
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVo> list = new ArrayList<>();
		String sql = "";
		
		try {
			con = jdbcUtils.getConnection();
			
			sql = "SELECT * ";
			sql += "FROM board ";
			sql += "ORDER BY num DESC ";
			sql += "LIMIT ?, ? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setNum(rs.getInt("num"));
				boardVo.setName(rs.getString("name"));
				boardVo.setPasswd(rs.getString("passwd"));
				boardVo.setSubject(rs.getString("subject"));
				boardVo.setContent(rs.getString("content"));
				boardVo.setReadcount(rs.getInt("readcount"));
				boardVo.setRegDate(rs.getTimestamp("reg_date"));
				boardVo.setIp(rs.getString("ip"));
				boardVo.setFile(rs.getString("file"));
				boardVo.setReRef(rs.getInt("re_ref"));
				boardVo.setReLev(rs.getInt("re_lev"));
				boardVo.setReSeq(rs.getInt("re_seq"));
				
				list.add(boardVo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close(con, pstmt, rs);
		}
		return list;
	} // getBoards()
	
	// �۹�ȣ�� �ش��ϴ� �н����� ��ġ���� Ȯ���ϱ�
	public boolean isPasswdOk(int num, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean isPasswdOk = false;
		String sql = "";
		
		try {
			con = jdbcUtils.getConnection();
			
			sql = "SELECT COUNT(*) ";
			sql += "FROM board ";
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
			jdbcUtils.close(con, pstmt, rs);
		}
		return isPasswdOk;
	} // isPasswdOk()

	public void updateBoard(BoardVo boardVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// update�ϱ� resultset�Ⱦ�
		
		String sql = "";
		
		try {
			con = jdbcUtils.getConnection();
			
			sql = "UPDATE board ";
			sql += "SET name = ?, subject = ?, content = ? ";
			sql += "WHERE num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardVo.getName());
			pstmt.setString(2, boardVo.getSubject());
			pstmt.setString(3, boardVo.getContent());
			pstmt.setInt(4, boardVo.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close(con, pstmt);
		}
		
		
		
	} // updateBoard()
	
	public static void main(String[] args) {

		BoardDao boardDao = BoardDao.getInstance();

		for (int i = 0; i < 100; i++) {
			BoardVo boardVo = new BoardVo();

			int num = boardDao.getNextNum(); // dao���� �۹�ȣ�� �����ͼ� vo�� �ִ´�.
			boardVo.setNum(num);
			boardVo.setName("ȫ�浿" + num);
			boardVo.setPasswd("1234");
			boardVo.setSubject("������" + num);
			boardVo.setContent("�۳���" + num);
			boardVo.setReadcount(0);
			boardVo.setRegDate(new Timestamp(System.currentTimeMillis()));
			boardVo.setIp("127.0.0.1");
			boardVo.setReRef(num);
			boardVo.setReLev(0);
			boardVo.setReSeq(0);

			System.out.println(boardVo);
			
			boardDao.addBoard(boardVo);
		} // for
	} // main()
}