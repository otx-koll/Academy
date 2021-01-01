package com.project.vo;

public class FileVo {
	private int num;
	private String filename; 	// 실제 업로드된 파일명
	private String uploadpath;  // 실제 업로드된 폴더 경로 
	private String image;		// 파일이 이미지인지 여부. "I"는 이미지, "O"는 이미지 아님
	private int noNum; 			// review 테이블의 글번호 num
	
	public FileVo() {}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUploadpath() {
		return uploadpath;
	}
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getNoNum() {
		return noNum;
	}
	public void setNoNum(int noNum) {
		this.noNum = noNum;
	}
	
	@Override
	public String toString() {
		return "FileVo [num=" + num + ", filename=" + filename + ", uploadpath=" + uploadpath + ", image=" + image
				+ ", noNum=" + noNum + "]";
	}
}

