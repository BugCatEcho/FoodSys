package service;

import java.util.List;

import controller.userDao;
import model.user;

public class userService {

	userDao ud = new userDao();

	public user getUser(int uid) {

		return ud.queryone(uid);
	}

	public String getName(int uid) {

		return ud.queryone(uid).getName();
	}

	public boolean exist(int uid) {
		// 检查用户是否存在
		
		
		return ud.exist(uid);
	}

	public List<user> queryAll() {
		// TODO Auto-generated method stub
		return ud.queryAll();
	}
	
}
