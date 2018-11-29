package model;

public class bill {
//	bid int primary key auto_increment,
//	uid int,
//	addtime varchar(20),
//	Settlement int
	Integer bid=null;
	Integer uid=null;
	Integer fid=null;
	String addtime=null;
	Integer settlement=null;//(1为已结算 2 为未结算)
	user user;
	food food;
	public bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public bill(Integer bid, Integer uid, String addtime, Integer settlement) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.addtime = addtime;
		this.settlement = settlement;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public user getUser() {
		return user;
	}
	
	public void setUser(user user) {
		this.user = user;
	}
	public food getFood() {
		return food;
	}
	public void setFood(food food) {
		this.food = food;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public Integer getSettlement() {
		return settlement;
	}
	public void setSettlement(Integer settlement) {
		this.settlement = settlement;
	}
	
}
