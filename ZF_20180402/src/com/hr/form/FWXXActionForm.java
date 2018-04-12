package com.hr.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.hr.entity.TBL_FWLX;
import com.hr.entity.TBL_FWXX;
import com.hr.entity.TBL_JD;
import com.hr.entity.TBL_QX;

/**
 * 
 *@Name : FWXXActionForm
 *@Author : LH
 *@Date : 2018-4-5����10:28:46
 *@Version : V1.0
 * @Description:
 */
@SuppressWarnings("serial")
public class FWXXActionForm extends ActionForm {

	//������Ϣ����
	private String title;
	//����ID
	private int qxid;
	//�ֵ�id
	private int jdid;
	//������ֵ
	private double zjmin;
	//������ֵ
	private double zjmax;
	//������������(id)
	private int [] lxids; 
	
	
	

	
	//������Ϣ����
	private List<TBL_FWXX> fwxxlist;
    //������Ϣ����
	private List<TBL_QX> qxlist;
	//�ֵ���Ϣ����
	private List<TBL_JD> jdlist;
	//����������Ϣ����
	private List<TBL_FWLX> fwlxlist;
	
	
	
	
	//����get��set����
	public int[] getLxids() {
		return lxids;
	}
	
	public void setLxids(int[] lxids) {
		this.lxids = lxids;
	}
	
	public double getZjmin() {
		return zjmin;
	}

	public void setZjmin(double zjmin) {
		this.zjmin = zjmin;
	}

	public double getZjmax() {
		return zjmax;
	}

	public void setZjmax(double zjmax) {
		this.zjmax = zjmax;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	//����get��set����
	
	public List<TBL_FWLX> getFwlxlist() {
		return fwlxlist;
	}

	public void setFwlxlist(List<TBL_FWLX> fwlxlist) {
		this.fwlxlist = fwlxlist;
	}

	public List<TBL_JD> getJdlist() {
		return jdlist;
	}

	public void setJdlist(List<TBL_JD> jdlist) {
		this.jdlist = jdlist;
	}

	public List<TBL_QX> getQxlist() {
		return qxlist;
	}

	public void setQxlist(List<TBL_QX> qxlist) {
		this.qxlist = qxlist;
	}

	public List<TBL_FWXX> getFwxxlist() {
		return fwxxlist;
	}

	public void setFwxxlist(List<TBL_FWXX> fwxxlist) {
		this.fwxxlist = fwxxlist;
	}
	
	
	
}
