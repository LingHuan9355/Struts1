package com.cshr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cshr.dao.BaseDao;
import com.cshr.entity.Student;

/**
 * 
 *@Name :QueryAction 
 *@Author : LH
 *@Date : 2018-3-13����04:36:22
 *@Version : V1.0
 *@Description : ��ѯ��Action�̳�Action�࣬��д��execute()����
 */
public class QueryAction extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
       //  System.out.println("execute");
         
         List<Student>  list = BaseDao.queryList(Student.class);
		 request.setAttribute("list", list);
         
		return new ActionForward("/stulist.jsp");
		
	}
	
}
