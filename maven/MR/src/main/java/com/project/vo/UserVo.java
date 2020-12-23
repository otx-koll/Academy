package com.project.vo;

import java.sql.Timestamp;

public class UserVo {
	private String id;
	private String passwd;
	private String name;
	private String birthday;
	private String email;
	private String tel;
	private Timestamp regDate;
	
	public UserVo() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", birthday=" + birthday + ", email="
				+ email + ", tel=" + tel + ", regDate=" + regDate + "]";
	}
}
