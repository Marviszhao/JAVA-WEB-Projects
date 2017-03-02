package com.bigdata.vo;

public class UserModel {
	private int id;
	private String name;
	private String pass_word;
	private int gender;
	private String phone;
	private int user_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", pass_word="
				+ pass_word + ", gender=" + gender + ", phone=" + phone
				+ ", user_type=" + user_type + "]";
	}
	
	
}
