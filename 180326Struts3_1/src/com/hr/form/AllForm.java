package com.hr.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hr.entity.Users;

@SuppressWarnings("serial")
public class AllForm extends BaseForm {

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
    	String page = request.getParameter("page");
    	ActionErrors errors = new ActionErrors();
    	if("a".equals(page)){
    		if(isEmpty(users.getUname())){
    			ActionMessage msg = new ActionMessage("<font color='red' >�û�������Ϊ��</font>", false);
    		    errors.add("error.uname",msg);
    		  }
    		  
    		  if(isLength(users.getUname())){
    			  ActionMessage msg = new ActionMessage("<font color='red' >�û������Ȳ���С��4</font>", false);
    			  errors.add("error.uname",msg);
    		  }
    	}else{
    		 if(isEmpty(users.getUemail())){
   			  ActionMessage msg = new ActionMessage("<font color='red' >���䲻��Ϊ��</font>", false);
   			  errors.add("error.uemail",msg);
   		  }
   		  
   		  if(!isEmail(users.getUemail())){
   			  ActionMessage msg = new ActionMessage("<font color='red' >�����ʽ����ȷ</font>", false);
   			  errors.add("error.uemail",msg);
   		  }
    	}
    	
    	return errors;
    }
}
