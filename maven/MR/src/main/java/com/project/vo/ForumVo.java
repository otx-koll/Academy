package com.project.vo;

import java.sql.Timestamp;
import java.util.List;

public class ForumVo {
	
	private int num; // 게시판 글번호
	private String id; // 작성자 ID
	private String subject;
	private String content;
	private int readcount;
	private Timestamp regDate;
	private String ip;
	private int reRef; // 그룹번호. 주글번호는 그룹번호가 됨
	private int reLev; // 들여쓰기 레벨
	private int reSeq; // 그룹 내에서의 순번
	private int thumbsUp; // 좋아요
	
	public ForumVo() {}
	
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
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getReRef() {
		return reRef;
	}
	public void setReRef(int reRef) {
		this.reRef = reRef;
	}
	public int getReLev() {
		return reLev;
	}
	public void setReLev(int reLev) {
		this.reLev = reLev;
	}
	public int getReSeq() {
		return reSeq;
	}
	public void setReSeq(int reSeq) {
		this.reSeq = reSeq;
	}

	public int getThumbsUp() {
		return thumbsUp;
	}

	public void setThumbsUp(int thumbsUp) {
		this.thumbsUp = thumbsUp;
	}

	@Override
	public String toString() {
		return "ForumVo [num=" + num + ", id=" + id + ", subject=" + subject + ", content=" + content + ", readcount="
				+ readcount + ", regDate=" + regDate + ", ip=" + ip + ", reRef=" + reRef + ", reLev=" + reLev
				+ ", reSeq=" + reSeq + ", thumbsUp=" + thumbsUp + "]";
	}
}
