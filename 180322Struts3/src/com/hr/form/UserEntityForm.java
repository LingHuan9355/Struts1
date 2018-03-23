package com.hr.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hr.entity.Users;

@SuppressWarnings("serial")
public class UserEntityForm extends BaseForm {

	//struts1.x�İ汾��ʵ�������ռ�������ʱ��һ��Ҫnew����
	private Users users = new Users();

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		String temp = request.getParameter("temp");
		ActionErrors errors = new ActionErrors();
		if("a".equals(temp)){
			if(isEmpty(users.getUname())){
				ActionMessage msg = new ActionMessage("<font color='red'>�û�������Ϊ��</font>",false);
				errors.add("error.uname",msg);
			}
			if(isEmpty(users.getUpwd())){
				ActionMessage msg = new ActionMessage("<font color='red'>���벻��Ϊ��</font>",false);
				errors.add("error.upwd",msg);
			}
		}else{
			if(isEmpty(users.getUemail())){
				ActionMessage msg = new ActionMessage("<font color='red'>���䲻��Ϊ��</font>",false);
				errors.add("error.uemail",msg);
			}
			if(!isEmail(users.getUemail())){
				ActionMessage msg = new ActionMessage("<font color='red'>�����ʽ����ȷ</font>",false);
			    errors.add("error.uemail",msg);
			}
		}
		return errors;
	}
}
