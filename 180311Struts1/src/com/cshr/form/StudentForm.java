package com.cshr.form;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

/**
 * 
 *@Name : StudentForm
 *@Author : LH
 *@Date : 2018-3-13ÏÂÎç05:39:22
 *@Version : V1.0
 * @Description:
 */
@SuppressWarnings("serial")
public class StudentForm extends ActionForm {

	private int id;
	private String name;
	private Double money;
	private Date birthday;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
