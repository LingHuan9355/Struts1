package com.hr.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.hr.entity.MyUser;

@SuppressWarnings("serial")
public class UserActionForm extends ActionForm{

	private MyUser myUser = new MyUser();

	//FormFile是struts用于收集表单文件的一个类型
	private FormFile  myfile;

	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MyUser getMyUser() {
		return myUser;
	}

	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}

	public FormFile getMyfile() {
		return myfile;
	}

	public void setMyfile(FormFile myfile) {
		this.myfile = myfile;
	}



	
	
}
