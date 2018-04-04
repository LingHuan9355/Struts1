package com.hr.entity;

/**
 * 区县的实体类
 *@Name : QXEntity
 *@Author : LH
 *@Date : 2018-4-4下午11:52:09
 *@Version : V1.0
 * @Description:
 */
public class QXEntity {

	//区县id
	private int qxid;
	//区县名
	private String qx;

	
    
	
	public QXEntity() {
	}

	public QXEntity(int qxid, String qx) {
		super();
		this.qxid = qxid;
		this.qx = qx;
	}

	public int getQxid() {
		return qxid;
	}

	public void setQxid(int qxid) {
		this.qxid = qxid;
	}

	public String getQx() {
		return qx;
	}

	public void setQx(String qx) {
		this.qx = qx;
	}
	
	
	
}
