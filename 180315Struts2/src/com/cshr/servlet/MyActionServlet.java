package com.cshr.servlet;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionServlet;

import com.cshr.converter.UtilDateConverter;
/**
 * 
 *@Name : MyActionServlet
 *@Author : LH
 *@Date : 2018-3-16����06:22:57
 *@Version : V1.0
 * @Description:
 *һ��ת������ע�᷽ʽһ
 *a.�Զ���Servlet��̳�struts��ActionServlet,Ȼ����init()����ע���Լ���ת���������ø����init()����;
 *   b.��web.xml�����õ�Action��д�Զ����Servlet;
 */
public class MyActionServlet  extends ActionServlet{

	
	 @Override
	public void init() throws ServletException {
		super.init();

		//ConvertUtils.register(new UtilDateConverter(), Date.class);
	 }
}
