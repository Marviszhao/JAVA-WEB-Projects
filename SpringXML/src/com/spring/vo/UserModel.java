package com.spring.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
//ʵ����Ҳ���Ƕ�Ӧ�ı���������hibernateTemplate�����Ͳ�֪���ö��Ǹ�����в�����
//��Ϊ��ֻ����һ��model����Ҳû�жԱ����ɸѡ�������model���Ȼ���б���ע��
@Entity(name="usertable")
public class UserModel {
//	�������ݵ�ʱ�������@Id,
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	@Column(name = "id")
	private int cid;
	
//	@Columnע����е��ֶΣ���model��Ķ�Ӧ�����,updatable=false�������д���֤��Ŀǰ���ֶ����ÿɸ���Ϊfalse�󣬲��������ݻ�û������
	@Column(name="user_name",updatable=false)
	private String userName;
	
//	@Column(name="user_psw",updatable=false) ������ͬʱ���û���bug�����ֲ��ܸ��µ�bug
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
