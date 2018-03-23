package com.hr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hr.entity.Users;
import com.hr.form.UserEntityForm;

public class RegAAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserEntityForm uForm = (UserEntityForm) form;
		Users users = uForm.getUsers();
		System.out.println(users.getUname());
		System.out.println(users.getUpwd());
		
		return new ActionForward("/regB.jsp");
	}
	
}
