package com.hr.entity;

/**
 * 街道实体类
 *@Name : JDEntity
 *@Author : LH
 *@Date : 2018-4-4下午11:54:24
 *@Version : V1.0
 * @Description:
 */
public class TBL_JD {
    
	//街道id
	private int jdid;
    //街道名称
	private String jd;
	//区县id
	private int qxid;
	
	
	
	public TBL_JD() {
	}
	public TBL_JD(int jdid, String jd, int qxid) {
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
