package com.cshr.entity;

import java.util.Date;

/**
 * 
 *@Name : Student
 *@Author : LH
 *@Date : 2018-3-16����05:11:25
 *@Version : V1.0
 * @Description:
 * Ҫ��ʵ����һ��Ҫ�ͱ���һ�� 
 *      �������ͱ������һ��
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
