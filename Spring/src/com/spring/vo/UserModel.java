package com.spring.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
//实体名也就是对应的表明，否则hibernateTemplate根本就不知道该对那个表进行操作，
//因为其只接受一个model参数也没有对表进行筛选，因此在model层必然会有表名注解
@Entity(name="usertable")
public class UserModel {
//	保存数据的时候必须有@Id,
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	@Column(name = "id")
	private int cid;
	
//	@Column注解表中的字段，与model类的对应的情况,updatable=false的作用有待验证，目前发现都设置可更新为false后，插整个数据会没有作用
	@Column(name="user_name",updatable=false)
	private String userName;
	
//	@Column(name="user_psw",updatable=false) 与上面同时设置会有bug，出现不能更新的bug
	@Column(name="user_psw")
	private String userPsw;
	
	@Column(name="user_type")
	private int userType;
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPsw() {
		return userPsw;
	}
	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
}
