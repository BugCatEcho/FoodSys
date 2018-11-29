package model;

public class user {
//	uid int primary key auto_increment,
//	name varchar(10) not null,
//	money money(10,2) not null
	Integer uid=null;
	String name=null;
	double money;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(Integer uid, String name, double money) {
		super();
		this.uid = uid;
		this.name = name;
		this.money = money;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
