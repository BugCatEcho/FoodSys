package model;

public class food {
//	fid int primary key auto_increament;
//	name varchar(20) not null,
//	typeid int,
//	money Decimal(10,2)
	Integer fid=null;
	Integer cid=null;
	String name=null;
	Integer typeid=null;
	double money;
	String jieshao=null;
	
	public food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public food(Integer fid, Integer cid, String name, Integer typeid, double money, String jieshao) {
		super();
		this.fid = fid;
		this.cid = cid;
		this.name = name;
		this.typeid = typeid;
		this.money = money;
		this.jieshao = jieshao;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
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
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getJieshao() {
		return jieshao;
	}
	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}
	
	
	
	
}
