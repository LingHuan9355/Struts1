package com.hr.entity;

/**
 * �ֵ�ʵ����
 *@Name : JDEntity
 *@Author : LH
 *@Date : 2018-4-4����11:54:24
 *@Version : V1.0
 * @Description:
 */
public class JDEntity {
    
	//�ֵ�id
	private int jdid;
    //�ֵ�����
	private String jd;
	//����id
	private int qxid;
	
	
	
	public JDEntity() {
	}
	public JDEntity(int jdid, String jd, int qxid) {
		super();
		this.jdid = jdid;
		this.jd = jd;
		this.qxid = qxid;
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public int getQxid() {
		return qxid;
	}
	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	
	
}
