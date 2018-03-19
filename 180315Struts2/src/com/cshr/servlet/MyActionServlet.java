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
 *@Date : 2018-3-16下午06:22:57
 *@Version : V1.0
 * @Description:
 *一、转换器的注册方式一
 *a.自定义Servlet类继承struts的ActionServlet,然后在init()方法注册自己的转换器，调用父类的init()方法;
 *   b.把web.xml中配置的Action改写自定义的Servlet;
 */
public class MyActionServlet  extends ActionServlet{

	
	 @Override
	public void init() throws ServletException {
		super.init();

		//ConvertUtils.register(new UtilDateConverter(), Date.class);
	 }
}
