package com.hr.entity;

import java.util.Date;

/**
 * ������Ϣʵ����
 *@Name : TBL_FWXX
 *@Author : LH
 *@Date : 2018-4-4����11:57:37
 *@Version : V1.0
 * @Description:
 */
public class TBL_FWXX {

	//����id
	private int fwid;
	//�û�id
	private int uid;
    //�ֵ�id
	private int jdid;
	//����id
	private int qxid;
	//��������id
	private int lxid;
	//��
	private int shi;
	//��
	private int ting;
	//������Ϣ����
	private String fwxx;
	//���
	private double zj;
	//�������
	private String title;
	//��������
	private Date date;
	//��ϵ�绰
	private String telephone;
	//��ϵ��
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
