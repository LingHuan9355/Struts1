package com.cshr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cshr.form.StudentForm;

public class AddAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		StudentForm stuForm = (StudentForm) form;
		
		System.out.println(stuForm.getBrithday());
		System.out.println(stuForm.getSex());
		
		String [] hobby = stuForm.getHobby();
		for (String hb : hobby) {
			System.out.println(hb);
		}
		
		System.out.println(stuForm.getProvince());
		System.out.println(stuForm.getInfo());
		System.out.println(stuForm.isPub());
		
		
		return new ActionForward("/success.jsp");
	}
}
