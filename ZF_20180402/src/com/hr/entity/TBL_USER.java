package com.hr.entity;

/**
 * �û���Ϣʵ����
 *@Name : UserEntity
 *@Author : LH
 *@Date : 2018-4-4����11:50:39
 *@Version : V1.0
 * @Description:
 */
public class TBL_USER {

	//�û�id
	private int uid;
	//�û�����
	private String uname;
	//�û�����
	private String upass;

	
	public TBL_USER() {
	}

	public TBL_USER(int uid, String uname, String upass) {
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
