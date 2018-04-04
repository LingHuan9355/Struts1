package com.hr.form;

import java.sql.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.hr.entity.Dog;

@SuppressWarnings("serial")
public class UserActionForm extends ActionForm {

	
	private String uname;
	private String upwd;
	private int uage;
	private String usex;
	private String[] hobby;
	private String city;
	private String info;
	
	private List<Dog> dlist;
	private int did ;
	private int [] dids;
	
	
	private double money;
	private Date udate;
	
	
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public int[] getDids() {
		return dids;
	}
	public void setDids(int[] dids) {
		this.dids = dids;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public List<Dog> getDlist() {
		return dlist;
	}
	public void setDlist(List<Dog> dlist) {
		this.dlist = dlist;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
