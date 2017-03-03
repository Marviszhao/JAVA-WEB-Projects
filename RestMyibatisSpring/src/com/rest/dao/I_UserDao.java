package com.rest.dao;

import java.util.List;
import java.util.Map;

import com.rest.vo.UserModel;

public interface I_UserDao {

	public void addUser(Map map);

	public UserModel getUser(Map map);

	public List<UserModel> getAllUser();

	public void delete(String userID);

	public void update(Map<String, String> aMap);

}
