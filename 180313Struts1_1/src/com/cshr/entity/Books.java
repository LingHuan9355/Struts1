package com.cshr.entity;

/**
 * 
 *@Name : Books
 *@Author : LH
 *@Date : 2018-3-13����09:39:46
 *@Version : V1.0
 * @Description: ʵ����
 */
public class Books {

	//�鼮���
	private int book_id;
	//�鼮����
	private String book_name;
	//�鼮�۸�
	private double book_price;
	//�鼮����
	private String book_write;
	
		
	public Books() {
		super();
	}
	
	public Books(String bookName, double bookPrice, String bookWrite) {
		book_name = bookName;
		book_price = bookPrice;
		book_write = bookWrite;
	}

	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int bookId) {
		book_id = bookId;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String bookName) {
		book_name = bookName;
	}
	public double getBook_price() {
		return book_price;
	}
	public void setBook_price(double bookPrice) {
		book_price = bookPrice;
	}
	public String getBook_write() {
		return book_write;
	}
	public void setBook_write(String bookWrite) {
		book_write = bookWrite;
	}

		
}