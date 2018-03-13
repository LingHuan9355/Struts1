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
 *@Date : 2018-3-13����05:36:14
 *@Version : V1.0
 * @Description:��ӵ�Action�̳�Action�࣬��д��execute()����
 */
public class AddAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//��ȡActionForm�ռ��ı����ݣ�ǿת
		StudentForm stuForm = (StudentForm) form;
		/*System.out.println(stuForm.getName());
		System.out.println(stuForm.getMoney());
		System.out.println(stuForm.getBirthday());*/
		
		//System.out.println("add...");
		
		//���ռ������ݣ����浽���ݿ���;
		Student stu = new Student();
		stu.setName(stuForm.getName());
		stu.setMomey(stuForm.getMoney());
		stu.setBrithday(stuForm.getBirthday());
		
	    int row = BaseDao.save(stu);
		if(row > 0){
			System.out.println("��ӳɹ���");
		}
		return new ActionForward("/query.do",true);
	}
}
