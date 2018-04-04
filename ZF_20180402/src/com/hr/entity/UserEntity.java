package com.hr.entity;

/**
 * 用户信息实体类
 *@Name : UserEntity
 *@Author : LH
 *@Date : 2018-4-4下午11:50:39
 *@Version : V1.0
 * @Description:
 */
public class UserEntity {

	//用户id
	private int uid;
	//用户名称
	private String uname;
	
	private String upass;

	
	public UserEntity() {
	}

	public UserEntity(int uid, String uname, String upass) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	
	
}
