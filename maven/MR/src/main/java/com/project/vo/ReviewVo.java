package com.project.vo;

import java.sql.Timestamp;
import java.util.List;

import com.project.vo.AttachVo;

public class ReviewVo {
	private int num;
	private String id;
	private String mvSubject;
	private String subject;
	private String content;
	private Timestamp regDate;
	
	private List<AttachVo> attachList;
	
	public ReviewVo() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMvSubject() {
		return mvSubject;
	}

	public void setMvSubject(String mvSubject) {
		this.mvSubject = mvSubject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public List<AttachVo> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<AttachVo> attachList) {
		this.attachList = attachList;
	}

	@Override
	public String toString() {
		return "ReviewVo [num=" + num + ", id=" + id + ", mvSubject=" + mvSubject + ", subject=" + subject
				+ ", content=" + content + ", regDate=" + regDate + ", attachList=" + attachList + "]";
	}
}
