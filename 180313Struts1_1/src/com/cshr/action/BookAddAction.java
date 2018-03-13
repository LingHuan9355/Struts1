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
 *@Name : BookAddAction
 *@Author : LH
 *@Date : 2018-3-13下午09:49:01
 *@Version : V1.0
 * @Description: 添加书籍的BookAddAction继承Action类，重写其execute()方法
 */
public class BookAddAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BookActionForm bookForm = (BookActionForm) form;
		/*System.out.println(bookForm.getBookName());
		System.out.println(bookForm.getBookPrice());
		System.out.println(bookForm.getBookWrite());
		
		System.out.println("add......");*/
		
		Books book = new Books(bookForm.getBookName(),bookForm.getBookPrice(),bookForm.getBookWrite());
		
		int row = BaseDao.save(book);
		if(row > 0){
			return new ActionForward("/success.jsp",true);
		 }else{
			 
			 return new ActionForward("/error.jsp",true);
		 }
	}
}
