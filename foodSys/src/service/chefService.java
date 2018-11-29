package service;

import java.util.List;

import controller.chefDao;
import model.chef;

public class chefService {
	chefDao cd=new chefDao();
	public List<chef> queryAll() {
		// TODO Auto-generated method stub
		return cd.queryAll();
	}

}
