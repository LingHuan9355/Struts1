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
	 * 基础标签的应用
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
	 * 高级标签的应用
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
		list.add(new Dog(1, "小白"));
		list.add(new Dog(2, "小黑"));
		list.add(new Dog(3, "小蓝"));
		list.add(new Dog(4, "小灰"));
		
		userForm.setDid(4);
		
		int [] dids = {1,3,4};
		userForm.setDids(dids);
		//request.setAttribute("list",list);
		userForm.setDlist(list);
		
		
		return new ActionForward("/advhtml.jsp");
	}
	
	/**
	 * 修改
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
	 * logic+bean标签
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
