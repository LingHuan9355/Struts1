package com.hr.entity;

/**
 * ���ص�ʵ����
 *@Name : QXEntity
 *@Author : LH
 *@Date : 2018-4-4����11:52:09
 *@Version : V1.0
 * @Description:
 */
public class QXEntity {

	//����id
	private int qxid;
	//������
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
