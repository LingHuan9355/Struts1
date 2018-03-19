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
 *@Date : 2018-3-19����05:45:02
 *@Version : V1.0
 * @Description:
 * 
 * 3. ��һ��ActionFrom��׼�������������,��дһ�����÷���,�԰��ã��Ա��һ����ʼֵ��
  ��д��֤�ķ�����������������,���,�Ա������֤�������ĳ���С��2������ <18,���С��0 ;�Ա�Ȳ������ֲ���Ů
  �����֤ʧ�ܣ�����ԭҳ��ȥ��ʾ������Ϣ
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
		//��������
		 sex="��";
		 String [] bb = {"�Ķ�","����"};
		 hobby=bb;
		//��struts-config.xml����������Ϊrequest���Ͳ�������������pub��
		//pub=false;
	 }
	 
	 @Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		 
		 ActionErrors errors = new ActionErrors();
		 if(name.length() < 2){
			//false��ʾ���ǲ�������Դ�ļ������Ϊtrue������Ҫȥ�ⲿ��
			 ActionMessage msg = new ActionMessage("<font color='red'>�����ĳ���С��2</font>",false);
		     errors.add("error.name",msg);
		 }
		 if(age < 18){
			 ActionMessage msg = new ActionMessage("<font color='red'>����С��18</font>",false);
			 errors.add("error.age",msg);
		 }
		 if(money < 0){
			 ActionMessage msg = new ActionMessage("<font color='red'>���С��0</font>",false);
			 errors.add("error.money",msg);
		 }
		 if(!"��".equals(sex) && !"Ů".equals(sex)){
			 ActionMessage msg = new ActionMessage("<font color='red'>�Ա�Ȳ������ֲ���Ů</font>",false);
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
