package model;

public class castle {
Integer cid=null;
String acc=null;
String pwd=null;
public castle() {
	super();
	// TODO Auto-generated constructor stub
}
public castle(Integer cid, String acc, String pwd) {
	super();
	this.cid = cid;
	this.acc = acc;
	this.pwd = pwd;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getAcc() {
	return acc;
}
public void setAcc(String acc) {
	this.acc = acc;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}

}
