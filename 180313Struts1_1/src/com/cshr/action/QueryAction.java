package com.cshr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cshr.dao.BaseDao;
import com.cshr.entity.Books;

/**
 * 
 *@Name : QueryAction
 *@Author : LH
 *@Date : 2018-3-13����10:18:27
 *@Version : V1.0
 * @Description: ��ѯ�鼮��QueryAction�̳�Action�࣬��д��execute()����
 */
public class QueryAction extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<Books> list = BaseDao.queryList(Books.class);
		
		request.setAttribute("list", list);
		
		return new ActionForward("/showBook.jsp");
	}
}
