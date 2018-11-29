package service;

import java.util.List;

import controller.billDao;
import model.bill;

public class billService {
	billDao bd=new billDao();
	public boolean addOne(int fid,int uid){
		
		
		
		return bd.insert(fid, uid);
	}
	public List<bill> getNoPay(int uid) {
		
		
		
		
		return bd.getNoPay(uid);
		
	}
	public boolean removeOne(int bid) {
		// TODO Auto-generated method stub
		return bd.removeOne(bid);
	}
	public boolean pay(int uid) {
		// TODO Auto-generated method stub
		
		
		
		return bd.pay(uid);
	}
	
	
}
