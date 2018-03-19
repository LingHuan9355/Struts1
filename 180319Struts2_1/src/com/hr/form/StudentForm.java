package com.hr.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * 
 *@Name : StudentForm
 *@Author : LH
 *@Date : 2018-3-19下午05:45:02
 *@Version : V1.0
 * @Description:
 * 
 * 3. 在一个ActionFrom中准备好上面的属性,重写一个重置方法,对爱好，性别给一个初始值，
  重写验证的方法，对姓名，年龄,存款,性别进行验证，姓名的长度小于2，年龄 <18,存款小于0 ;性别既不是男又不是女
  如果验证失败，跳回原页面去显示错误信息
 */
@SuppressWarnings("serial")
public class StudentForm extends ActionForm {

	private int id;
	 private String name;
	 private int age;
	 private double money;
	 private Date birthday;
	 
	 private String sex;
	 private String []hobby;
	 private String province;
	 private String info;
	 private boolean pub;
	 
	 @Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		//重置属性
		 sex="男";
		 String [] bb = {"阅读","音乐"};
		 hobby=bb;
		//在struts-config.xml作用域设置为request，就不用在这里设置pub了
		//pub=false;
	 }
	 
	 @Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		 
		 ActionErrors errors = new ActionErrors();
		 if(name.length() < 2){
			//false表示的是不引用资源文件，如果为true，则需要去外部的
			 ActionMessage msg = new ActionMessage("<font color='red'>姓名的长度小于2</font>",false);
		     errors.add("error.name",msg);
		 }
		 if(age < 18){
			 ActionMessage msg = new ActionMessage("<font color='red'>年龄小于18</font>",false);
			 errors.add("error.age",msg);
		 }
		 if(money < 0){
			 ActionMessage msg = new ActionMessage("<font color='red'>存款小于0</font>",false);
			 errors.add("error.money",msg);
		 }
		 if(!"男".equals(sex) && !"女".equals(sex)){
			 ActionMessage msg = new ActionMessage("<font color='red'>性别既不是男又不是女</font>",false);
			 errors.add("error.sex",msg);
		 }
			 
		return errors;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	 
	 
}
