package com.hr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hr.form.UsersForm;

public class RegAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UsersForm userForm = (UsersForm) form;
		
		System.out.println(userForm.getUname());
		System.out.println(userForm.getUpwd());
		System.out.println(userForm.getUemail());
		System.out.println(userForm.getUdate());
		
		return new ActionForward("/success.jsp");
	}
}
