package com.hr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hr.entity.Users;
import com.hr.form.RegActionForm;

/**
 * 
 *@Name : RegAction
 *@Author : LH
 *@Date : 2018-3-26下午11:18:26
 *@Version : V1.0
 * @Description:
 */
public class RegAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RegActionForm regForm = (RegActionForm) form;
		
		/*System.out.println(regForm.getUname());
		System.out.println(regForm.getUemail());
		System.out.println(regForm.getUdate());*/
	
		Users user = new Users();
		BeanUtils.copyProperties(user,regForm);
		System.out.println("=======实体打印=====");
		System.out.println(user.getUname());
		System.out.println(user.getUemail());
		System.out.println(user.getUdate());
		
		return new ActionForward("/success.jsp");
	}
	
}
