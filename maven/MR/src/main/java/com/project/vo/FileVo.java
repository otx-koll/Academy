package com.project.vo;

public class FileVo {
	private int num;
	private String filename; 	// ���� ���ε�� ���ϸ�
	private String uploadpath;  // ���� ���ε�� ���� ��� 
	private String image;		// ������ �̹������� ����. "I"�� �̹���, "O"�� �̹��� �ƴ�
	private int noNum; 			// review ���̺��� �۹�ȣ num
	
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

