package com.hr.servlet;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionServlet;

import com.hr.converter.UtilDateConverter;

/**
 * 
 *@Name : MyActionServlet
 *@Author : LH
 *@Date : 2018-3-19����09:12:05
 *@Version : V1.0
 *@Description:
 *  a.�Զ���Servlet��̳�struts��ActionServlet
 *	     Ȼ����init()����ע���Լ���ת���������ø����init()����;
 *	b.��web.xml�����õ�Action��д�Զ����Servlet;
 */
@SuppressWarnings("serial")
public class MyActionServlet extends ActionServlet {

	@Override
	public void init() throws ServletException {
		super.init();
	
	  ConvertUtils.register(new UtilDateConverter(),Date.class);
	}
}
