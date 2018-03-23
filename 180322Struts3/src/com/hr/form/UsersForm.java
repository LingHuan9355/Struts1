package com.hr.form;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

@SuppressWarnings("serial")
public class UsersForm extends BaseForm{

	private int id;
	private String uname;
	private String upwd;
	private String uemail;
	private Date udate;
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		if(isEmpty(uname)){
			ActionMessage msg = new ActionMessage("<font color='red'>用户名不能为空</font>",false);
			errors.add("error.uname",msg);
		}
		if(isEmpty(upwd)){
			ActionMessage msg = new ActionMessage("<font color='red'>密码不能为空</font>",false);
			errors.add("error.upwd",msg);
		}
		if(isEmpty(uemail)){
			ActionMessage msg = new ActionMessage("<font color='red'>邮箱不能为空</font>",false);
			errors.add("error.uemail",msg);
		}
		
		if(!isEmail(uemail)){
			ActionMessage msg = new ActionMessage("<font color='red'>邮箱格式不正确</font>",false);
		    errors.add("error.uemail",msg);
		}
		
		return errors;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}

}
