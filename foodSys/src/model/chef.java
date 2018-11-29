package model;

public class chef {
//	主键 cid int
//	名字 name String
//	密码 pwd String
//	手机号 phone String
//	邮箱 mail String
//	个人介绍 vita String
	Integer cid=null;
	String name=null;
	String pwd=null;
	String phone=null;
	String mail=null;
	String vita=null;
	public chef() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chef(Integer cid, String name, String pwd, String phone, String mail, String vita) {
		super();
		this.cid = cid;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.mail = mail;
		this.vita = vita;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getVita() {
		return vita;
	}
	public void setVita(String vita) {
		this.vita = vita;
	}
	

}
