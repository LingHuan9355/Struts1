package com.cshr.form;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


@SuppressWarnings("serial")
public class StudentForm extends ActionForm {

	private int id;
	private String name;
	private double momey;
	private Date brithday;
	
	private String sex;
	private String [] hobby;
	private String province;
	private String info;
	private boolean pub;
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		//重置属性值
		pub = false ;
		System.out.println("reset...");

	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		System.out.println("validate...");
		
		ActionErrors errors = new ActionErrors();
		if(!"admin".equals(name)){
			//false表示的是不引用资源文件，如果为true，则需要去外部的
			//properties文件中取一个key名
			ActionMessage msg = new ActionMessage("<font color='red'>用户名不是admin</font>",false);
		  errors.add("errors.name",msg); 
		}
		
		return errors;
	}



	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public boolean isPub() {
		return pub;
	}
	public void setPub(boolean pub) {
		this.pub = pub;
	}
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
	public double getMomey() {
		return momey;
	}
	public void setMomey(double momey) {
		this.momey = momey;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	
	
}
