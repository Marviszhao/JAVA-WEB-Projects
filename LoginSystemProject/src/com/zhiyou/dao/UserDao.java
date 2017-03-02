package com.zhiyou.dao;

import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

public class UserDao extends BaseDao implements UserTabInterface {

	@Override
	public void addUser(UserModel user) {
		try {
			String sql = "insert user values(null,?,?);";
			update(sql, user.getU_user(),user.getU_password());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<UserModel> selectAll() {
		try {
			String sql = "select * from user;";
			List<UserModel> list = query(sql, UserModel.class);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel isHaveUser(String userName) {
		List<UserModel> list;
		try {
			String sql = "select * from user where u_user = ?;";
			list = query(sql, UserModel.class, userName);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changedPassword(UserModel user, String newPsw) {
		UserModel userModel = this.isHaveUser(user.getU_user());
		if (userModel == null) {
			System.out.println("用户不存在无法修改密码");
			return false;
		}
		if (userModel.getU_password().equals(user.getU_password()) == false) {
			System.out.println("新旧密码不一致！无法修改密码");
			return false;
		}
		
		try {
			String sql = "update user set u_password=? where u_id=?;";
			update(sql, newPsw,user.getU_id());
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}

}
