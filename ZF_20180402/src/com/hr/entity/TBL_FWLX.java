package com.hr.entity;

/**
 * ��������ʵ����
 *@Name : FWLXEntity
 *@Author : LH
 *@Date : 2018-4-4����11:56:04
 *@Version : V1.0
 * @Description:
 */
public class TBL_FWLX {

	//����id
	private int lxid;
	//������������
	private String fwlx;
	
	
	public TBL_FWLX() {
	}
	public TBL_FWLX(int lxid, String fwlx) {
		super();
		this.lxid = lxid;
		this.fwlx = fwlx;
	}
	public int getLxid() {
		return lxid;
	}
	public void setLxid(int lxid) {
		this.lxid = lxid;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	
	
}
