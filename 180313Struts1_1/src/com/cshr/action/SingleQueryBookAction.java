package com.cshr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cshr.dao.BaseDao;
import com.cshr.entity.Books;
import com.cshr.form.BookActionForm;

/**
 * 
 *@Name : SingleQueryBookAction
 *@Author : LH
 *@Date : 2018-3-14下午06:06:14
 *@Version : V1.0
 * @Description:查询单本书籍的QueryAction继承Action类，重写其execute()方法
 */
public class SingleQueryBookAction extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BookActionForm bookForm = (BookActionForm) form;
		int bookId = bookForm.getBookId();
		//System.out.println("single:"+bookId);
		
		Object obj =  BaseDao.load(Books.class, bookId);
		Books book = (Books) obj;
		
		request.setAttribute("book", book);
		
		return new ActionForward("/updBook.jsp",false);
	}
}
