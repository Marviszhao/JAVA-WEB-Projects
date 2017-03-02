package com.zhiyou.dao;

public class UserModel {

	private int u_id;
	private String u_user;
	private String u_password;
	private int u_lev;
	
	@Override
	public String toString() {
		return "UserModel [u_id=" + u_id + ", u_user=" + u_user + ", u_password=" + u_password + ", u_lev=" + u_lev
				+ "]";
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_user() {
		return u_user;
	}
	public void setU_user(String u_user) {
		this.u_user = u_user;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public int getU_lev() {
		return u_lev;
	}
	public void setU_lev(int u_lev) {
		this.u_lev = u_lev;
	}
	
	
	
}
