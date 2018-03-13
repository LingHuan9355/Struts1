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
 *@Date : 2018-3-13����06:29:09
 *@Version : V1.0
 * @Description: ɾ����Action�̳�Action�࣬��д��execute()����
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
			System.out.println("ɾ���ɹ���");
		}
		//true��ʾ�ض���
		return new ActionForward("/query.do",true);
	}
}
