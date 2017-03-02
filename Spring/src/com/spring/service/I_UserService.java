package com.spring.service;

import java.util.List;

import com.spring.vo.UserModel;

public interface I_UserService {

	void add(String user_name, String pass_word);

	List login(String user_name, String user_psw);

	List getAllUsers();

	void delete(String id);

	void update(String id, String user_psw);

	void insert(UserModel userModel);

	void update(UserModel userModel);

}
