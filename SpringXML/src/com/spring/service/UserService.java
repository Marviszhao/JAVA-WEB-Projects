package com.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.I_UserDao;
import com.spring.vo.UserModel;

//@Service("userService")
public class UserService implements I_UserService {
//	@Resource
	I_UserDao userDao;

	public I_UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(I_UserDao userDao) {
		this.userDao = userDao;
	}

	@Override @Transactional(propagation=Propagation.REQUIRED)
	public void add(String user_name, String pass_word) {
		userDao.add(user_name,pass_word);
		
			
	}

	@Override
	public List login(String user_name, String user_psw) {
		
		
		
		return userDao.login(user_name,user_psw);
	}

	@Override
	public List getAllUsers() {
		
		return userDao.getAllUsers();
	}

	@Override
	public void delete(String id) {
		userDao.delete(id);
	}

	@Override
	public void update(String id, String user_psw) {
		userDao.update(id,user_psw);
	}

	@Override
	public void insert(UserModel userModel) {
		userDao.insert(userModel);
	}

	@Override
	public void update(UserModel userModel) {
		userDao.update(userModel);
	}

}
