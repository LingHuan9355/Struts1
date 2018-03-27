package com.hr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hr.entity.Users;
import com.hr.form.AllForm;
/**
 * 
 *@Name : RegAAction
 *@Author : LH
 *@Date : 2018-3-27下午12:22:56
 *@Version : V1.0
 * @Description:
 * 3.在regA.jsp中填写用户名和密码，一个隐藏域,名称是page ,值是a,然后用AllForm(继承BaseForm),
  在validate(),从request中拿到page参数的值，如果是a,就对用户名和密码进行验证,验证有误重新调回
  regA.jsp，显示错误信息，保持住原来的值。

  验证完了之后，regA.jsp提交到RegA(Action),在RegA中不做任何事情，只是返回一个ActionForward("regB.jsp",true)
  重定向到regB.jsp中,填写邮箱和出生日期,一个隐藏域,名称是page ,值是b,然后还是用原来AllForm
  接收表单的值，在validate()方法中，,从request中拿到page参数的值，如果是b,就对邮箱和出生日期进行验证,
  验证有误重新调回regB.jsp，显示错误信息，保持住原来的值。


  验证完毕，regB.jsp提交到RegB(Action)中拿到AllForm中的值，打印输出

  注意:RegA和RegB的配置文件中，name参数都是AllForm,input参数分别是"/regA.jsp"和"/regB.jsp" .
 */
public class RegAAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AllForm aForm = (AllForm) form;
		Users users = aForm.getUsers();
		System.out.println(users.getUname());
		
		return new ActionForward("/regB.jsp");
	}
}
