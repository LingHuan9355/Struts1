package com.cshr.entity;

import java.util.Date;

/**
 * 
 *@Name : Student
 *@Author : LH
 *@Date : 2018-3-16下午05:11:25
 *@Version : V1.0
 * @Description:
 * 要求：实体类一定要和表名一致 
 *      属性名和表的列名一致
 */
public class Student {

	private int id;
	private String name;
	private Double momey;
	private Date brithday;
	
	
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
	public Double getMomey() {
		return momey;
	}
	public void setMomey(Double momey) {
		this.momey = momey;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	
	
	
}
