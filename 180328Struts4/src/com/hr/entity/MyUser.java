package com.hr.entity;
/**
 * 
 *@Name : MyUser
 *@Author : LH
 *@Date : 2018-3-31����12:33:34
 *@Version : V1.0
 * @Description:
 * 
 * Ҫ��ʵ����һ��Ҫ�ͱ���һ�� 
 *      �������ͱ������һ��
 * 
 */
public class MyUser {

	private int id;
	private String name;
	private int age;
	private String filename;
	private byte [] img;
	
	
	
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	
	
	
}
