package com.hr.entity;

import java.util.Date;

/**
 * 房屋信息实体类
 *@Name : TBL_FWXX
 *@Author : LH
 *@Date : 2018-4-4下午11:57:37
 *@Version : V1.0
 * @Description:
 */
public class TBL_FWXX {

	//房屋id
	private int fwid;
	//用户id
	private int uid;
    //街道id
	private int jdid;
	//区县id
	private int qxid;
	//房屋类型id
	private int lxid;
	//室
	private int shi;
	//厅
	private int ting;
	//房屋信息详情
	private String fwxx;
	//租金
	private double zj;
	//出租标题
	private String title;
	//发布日期
	private Date date;
	//联系电话
	private String telephone;
	//联系人
	private String lxr;
	
	
	public TBL_FWXX() {
	}
	
	public TBL_FWXX(int fwid, int uid, int jdid, int qxid, int lxid, int shi,
			int ting, String fwxx, double zj, String title, Date date,
			String telephone, String lxr) {
		this.fwid = fwid;
		this.uid = uid;
		this.jdid = jdid;
		this.qxid = qxid;
		this.lxid = lxid;
		this.shi = shi;
		this.ting = ting;
		this.fwxx = fwxx;
		this.zj = zj;
		this.title = title;
		this.date = date;
		this.telephone = telephone;
		this.lxr = lxr;
	}
	public int getFwid() {
		return fwid;
	}
	public void setFwid(int fwid) {
		this.fwid = fwid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public int getQxid() {
		return qxid;
	}
	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	public int getLxid() {
		return lxid;
	}
	public void setLxid(int lxid) {
		this.lxid = lxid;
	}
	public int getShi() {
		return shi;
	}
	public void setShi(int shi) {
		this.shi = shi;
	}
	public int getTing() {
		return ting;
	}
	public void setTing(int ting) {
		this.ting = ting;
	}
	public String getFwxx() {
		return fwxx;
	}
	public void setFwxx(String fwxx) {
		this.fwxx = fwxx;
	}
	public double getZj() {
		return zj;
	}
	public void setZj(double zj) {
		this.zj = zj;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	
	
}
