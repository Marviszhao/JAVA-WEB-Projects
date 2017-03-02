package com.zhiyou.dao;

import java.util.List;

public interface UserTabInterface {

	public void addUser(UserModel user);
	public List<UserModel> selectAll();
	public UserModel isHaveUser(String userName);
	public boolean changedPassword(UserModel user,String newPsw);
}
