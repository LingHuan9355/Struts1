package com.cshr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cshr.dao.BaseDao;
import com.cshr.entity.Student;
import com.cshr.form.StudentForm;

/**
 * 
 *@Name : DeleteAction
 *@Author : LH
 *@Date : 2018-3-13下午06:29:09
 *@Version : V1.0
 * @Description: 删除的Action继承Action类，重写其execute()方法
 */
public class DeleteAction extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		StudentForm stuForm = (StudentForm) form;
		
		int id = stuForm.getId();
		System.out.println(id);
		
		Student stu = new Student();
		stu.setId(id);
		
		int row = BaseDao.delete(stu);
		if(row > 0){
			System.out.println("删除成功！");
		}
		//true表示重定向
		return new ActionForward("/query.do",true);
	}
}
