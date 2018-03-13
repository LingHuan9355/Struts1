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
 *@Name : DelBookAction
 *@Author : LH
 *@Date : 2018-3-13下午10:37:36
 *@Version : V1.0
 * @Description:删除书籍的DelBookAction继承Action类，重写其execute()方法
 */
public class DelBookAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        BookActionForm bookForm = (BookActionForm) form;
        int id = bookForm.getBookId();
        System.out.println(id);
		
        Books book = new Books();
        book.setBook_id(id);
        
        int row = BaseDao.delete(book);
        if(row >0){
        	return new ActionForward("/showBook.do",true);
		}else{
			return new ActionForward("/error.jsp",true);
		}
	}
}
