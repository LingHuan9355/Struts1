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

public class UpdBookAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BookActionForm bookForm = (BookActionForm) form;
		/*System.out.println(bookForm.getBookId());
		System.out.println(bookForm.getBookName());
		System.out.println(bookForm.getBookPrice());
		System.out.println(bookForm.getBookWrite());
		
		System.out.println("update...");*/
		Books book = new Books(bookForm.getBookId(),bookForm.getBookName(),bookForm.getBookPrice(),bookForm.getBookWrite());
		
		int num =BaseDao.update(book);
		
		
		if(num>0){
			return new ActionForward("/showBook.do",true);
			
		}else{
			return new ActionForward("/error.jsp",true);
		}
	}
}
