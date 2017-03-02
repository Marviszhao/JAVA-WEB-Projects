package com.bigdata.dao;

import com.bigdata.vo.UserModel;

public interface UserInterface {
	
	public UserModel checkUser(String userName, String userPsw);
	
	public void updateUserPsw(int id, String new_psw);
}
