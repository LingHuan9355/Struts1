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
 *@Name : AddAction
 *@Author : LH
 *@Date : 2018-3-13下午05:36:14
 *@Version : V1.0
 * @Description:添加的Action继承Action类，重写其execute()方法
 */
public class AddAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//获取ActionForm收集的表单数据，强转
		StudentForm stuForm = (StudentForm) form;
		/*System.out.println(stuForm.getName());
		System.out.println(stuForm.getMoney());
		System.out.println(stuForm.getBirthday());*/
		
		//System.out.println("add...");
		
		//把收集的数据，保存到数据库中;
		Student stu = new Student();
		stu.setName(stuForm.getName());
		stu.setMomey(stuForm.getMoney());
		stu.setBrithday(stuForm.getBirthday());
		
	    int row = BaseDao.save(stu);
		if(row > 0){
			System.out.println("添加成功！");
		}
		return new ActionForward("/query.do",true);
	}
}
