package java0923;

import java.sql.Timestamp;

public class MemberVo {
	private String id;
	private String passwd;
	private String name;
	private Timestamp reg_date;
	
	public MemberVo() {}
	
	public MemberVo(String id, String passwd, String name) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}

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

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", reg_date=" + reg_date + "]";
	}

	
}
