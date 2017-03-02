package com.bigdata.service;

import java.util.Map;

import javax.xml.registry.infomodel.User;

import com.bigdata.dao.UserDao;
import com.bigdata.vo.UserModel;

public class UserService {
	public void insertUser(Map<String, Object> map) {
		UserDao userDao = new UserDao();
		userDao.insertUser(map);
	}
	
	public UserModel checkUser(String userName, String userPsw) {
		UserDao userDao = new UserDao();
		
		UserModel userModel = userDao.checkUser(userName,userPsw);
		
		return userModel;
	}

	public void updateUserPsw(int id, String new_psw) {
		UserDao userDao = new UserDao();
		userDao.updateUserPsw(id, new_psw);
	}
}
