package com.cshr.form;

import org.apache.struts.action.ActionForm;

/**
 * 
 *@Name : BookForm
 *@Author : LH
 *@Date : 2018-3-13下午09:45:25
 *@Version : V1.0
 * @Description: 收集jsp页面表单数据，继承ActionForm类
 */
@SuppressWarnings("serial")
public class BookActionForm extends ActionForm {

	//书籍编号
	private int bookId;
	//书籍名称
	private String bookName;
	//书籍价格
	private double bookPrice;
	//书籍作者
	private String bookWrite;
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookWrite() {
		return bookWrite;
	}
	public void setBookWrite(String bookWrite) {
		this.bookWrite = bookWrite;
	}
	
	
	
}
