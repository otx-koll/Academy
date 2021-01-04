package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.vo.FileVo;

public class FileDao {
	
	private static FileDao instance = new FileDao();
	
	public static FileDao getInstance() {
		return instance;
	}
	
	private FileDao() {}
	
	public void insertFile(FileVo fileVo) { // FileVo 타입으로 받아서
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "INSERT INTO file (filename, uploadpath, image, no_num) ";
			sql += "VALUES (?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fileVo.getFilename());
			pstmt.setString(2, fileVo.getUploadpath());
			pstmt.setString(3, fileVo.getImage());
			pstmt.setInt(4, fileVo.getNoNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // insertAttach()
	
	public FileVo getFileByNum(int num) {
		FileVo fileVo = null;
				
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT * FROM file WHERE num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				fileVo = new FileVo();
				fileVo.setNum(rs.getInt("num"));
				fileVo.setFilename(rs.getString("filename"));
				fileVo.setUploadpath(rs.getString("uploadpath"));
				fileVo.setImage(rs.getString("image"));
				fileVo.setNoNum(rs.getInt("no_num"));
			} // if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return fileVo;
	} // getAttachByNum
	
	public List<FileVo> getFilesByNoNum(int noNum) {
		List<FileVo> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select니까 resultset도
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT * FROM file WHERE no_num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noNum);
			
			rs = pstmt.executeQuery(); // select니까 executeQuery()
			
			while(rs.next()) {
				FileVo fileVo = new FileVo();
				fileVo.setNum(rs.getInt("num"));
				fileVo.setFilename(rs.getString("filename"));
				fileVo.setUploadpath(rs.getString("uploadpath"));
				fileVo.setImage(rs.getString("image"));
				fileVo.setNoNum(rs.getInt("no_num"));
				
				list.add(fileVo);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		
		return list;		
	} // getAttachesByNoNum()
	
	public void deleteFileByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "DELETE FROM file where num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteAttachByNum
	
	public void deleteFilesByNoNum(int noNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "DELETE FROM file WHERE no_num = ? ";
			
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
