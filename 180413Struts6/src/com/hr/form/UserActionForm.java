package com.hr.form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class UserActionForm extends ActionForm {

	private String uname;
	private String upwd;
	
	
	
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
	
	
	
}
