package com.hr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hr.entity.Users;
import com.hr.form.UserEntityForm;

/**
 * 2.使用User实体去收集表单的数据,注意表单中控件的名称
 *@Name : RegEntityAction
 *@Author : LH
 *@Date : 2018-3-27上午10:35:17
 *@Version : V1.0
 * @Description:
 */
public class RegEntityAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取到ActionForm对象;
		UserEntityForm userForm = (UserEntityForm) form;
		
		Users users = userForm.getUsers();
		
		System.out.println(users.getUname());
		System.out.println(users.getUemail());
		System.out.println(users.getUdate());
		
        return new ActionForward("/success.jsp");		
	}
}
