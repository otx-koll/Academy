package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.vo.AttachVo;

public final class AttachDao {
	
	private static AttachDao instance = new AttachDao();
	
	public static AttachDao getInstance() {
		return instance;
	}
	
	private AttachDao() {}
	
	public void insertAttach(AttachVo attachVo) { // AttachVo 타입으로 받아서
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "INSERT INTO attach (filename, uploadpath, image, no_num) ";
			sql += "VALUES (?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, attachVo.getFilename());
			pstmt.setString(2, attachVo.getUploadpath());
			pstmt.setString(3, attachVo.getImage());
			pstmt.setInt(4, attachVo.getNoNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // insertAttach()
	
	public AttachVo getAttachByNum(int num) {
		AttachVo attachVo = null;
				
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT * FROM attach WHERE num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				attachVo = new AttachVo();
				attachVo.setNum(rs.getInt("num"));
				attachVo.setFilename(rs.getString("filename"));
				attachVo.setUploadpath(rs.getString("uploadpath"));
				attachVo.setImage(rs.getString("image"));
				attachVo.setNoNum(rs.getInt("no_num"));
			} // if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return attachVo;
	} // getAttachByNum
	
	public List<AttachVo> getAttachesByNoNum(int noNum) {
		List<AttachVo> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select니까 resultset도
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT * FROM attach WHERE no_num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noNum);
			
			rs = pstmt.executeQuery(); // select니까 executeQuery()
			
			while(rs.next()) {
				AttachVo attachVo = new AttachVo();
				attachVo.setNum(rs.getInt("num"));
				attachVo.setFilename(rs.getString("filename"));
				attachVo.setUploadpath(rs.getString("uploadpath"));
				attachVo.setImage(rs.getString("image"));
				attachVo.setNoNum(rs.getInt("no_num"));
				
				list.add(attachVo);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		
		return list;		
	} // getAttachesByNoNum()
	
	public void deleteAttachByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "DELETE FROM attach where num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteAttachByNum
	
	public void deleteAttachesByNoNum(int noNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "DELETE FROM attach WHERE no_num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noNum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteAttachesByNoNum()
}
