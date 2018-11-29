package service;

import java.util.List;

import controller.foodDao;
import model.food;

public class foodService {

	foodDao fd=new foodDao();	
	public List<food> getAll() {
		// TODO Auto-generated method stub	
		
		return fd.queryAll();
	}

	public List<food> queryType(int typeid) {
		// TODO Auto-generated method stub
		
		
		return fd.queryType(typeid);
	}

	public food getOne(int fid) {
		// TODO Auto-generated method stub
		return fd.queryOne(fid);
	}

	public List<food> search(String flag) {
		// TODO Auto-generated method stub
		

		return fd.search(flag);
	}


}
