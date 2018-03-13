package com.cshr.form;

import org.apache.struts.action.ActionForm;

/**
 * 
 *@Name : BookForm
 *@Author : LH
 *@Date : 2018-3-13����09:45:25
 *@Version : V1.0
 * @Description: �ռ�jspҳ������ݣ��̳�ActionForm��
 */
@SuppressWarnings("serial")
public class BookActionForm extends ActionForm {

	//�鼮���
	private int bookId;
	//�鼮����
	private String bookName;
	//�鼮�۸�
	private double bookPrice;
	//�鼮����
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
