package com.hr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hr.entity.Student;
import com.hr.form.StudentForm;

/**
 * 
 *@Name : AddStudentAction
 *@Author : LH
 *@Date : 2018-3-19����11:21:45
 *@Version : V1.0
 * @Description:
 * 4.��Action�У�ʹ��BeanUtils.copyProperties(),��ActionFrom��ֵ���Ƶ�Users�У�
 * Ȼ�����õ�request��,ת����result.jsp�Ľ��ҳ�棬��result.jsp��չʾUsers����Ϣ
 */
public class AddStudentAction extends Action {

	  @Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		  
		  StudentForm stuForm = (StudentForm) form;
		  /*System.out.println(stuForm.getId());
		  System.out.println(stuForm.getName());
		  System.out.println(stuForm.getMoney());
		  System.out.println(stuForm.getBirthday());*/
		  
		  Student stu = new Student();
		  BeanUtils.copyProperties(stu, stuForm);
		  System.out.println(stu.getId());
		  System.out.println(stu.getName());
		  System.out.println(stu.getMoney());
		  System.out.println(stu.getBirthday());
		  
		  request.setAttribute("student", stu);
		  
		return new ActionForward("/result.jsp");
	}
}
