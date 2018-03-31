package com.hr.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.hr.entity.MyUser;

@SuppressWarnings("serial")
public class UserActionForm extends ActionForm {

	private MyUser user = new MyUser();
	
	//FormFile是struts用于收集表单文件的一个类型
	private FormFile imgfile;
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FormFile getImgfile() {
		return imgfile;
	}

	public void setImgfile(FormFile imgfile) {
		this.imgfile = imgfile;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
	
}
