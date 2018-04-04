package com.hr.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.hr.entity.Dog;
import com.hr.form.UserActionForm;

public class TagAction extends DispatchAction {

	/**
	 * ������ǩ��Ӧ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward basehtml(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm userForm = (UserActionForm) form;
         System.out.println(userForm.getUname());
         System.out.println(userForm.getUpwd());
         System.out.println(userForm.getUage());
         System.out.println(userForm.getUsex());
         String [] hobby = userForm.getHobby();
         for (int i = 0; i < hobby.length; i++) {
			System.out.println(hobby[i]);
		 }
		System.out.println(userForm.getCity());
		System.out.println(userForm.getInfo());
		return new ActionForward("/basehtml.jsp");
	}
	
	/**
	 * �߼���ǩ��Ӧ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward advhtml(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm userForm = (UserActionForm) form;
		
		List<Dog> list = new ArrayList<Dog>();
		list.add(new Dog(1, "С��"));
		list.add(new Dog(2, "С��"));
		list.add(new Dog(3, "С��"));
		list.add(new Dog(4, "С��"));
		
		userForm.setDid(4);
		
		int [] dids = {1,3,4};
		userForm.setDids(dids);
		//request.setAttribute("list",list);
		userForm.setDlist(list);
		
		
		return new ActionForward("/advhtml.jsp");
	}
	
	/**
	 * �޸�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("update....");
		
		return new ActionForward("/advhtml.jsp");
	}
	
	/**
	 * logic+bean��ǩ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward logic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm userForm = (UserActionForm) form;
		
		//userForm.setUname("admin");
		userForm.setUage(20);
		
		userForm.setMoney(1243998.01);
		userForm.setUdate(new Date(System.currentTimeMillis()));
		
		return new ActionForward("/logic.jsp");
	}
	
}
