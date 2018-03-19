package com.cshr.util;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.cshr.converter.UtilDateConverter;
/**
 * 
 *@Name : MyPlugin
 *@Author : LH
 *@Date : 2018-3-16����06:57:50
 *@Version : V1.0
 * @Description:  
 * //ת������ע�᷽ʽ��
 * �������ע��
     a.�Զ���һ���࣬ʵ��һ������ӿ�(Plugin);
     b.��struts-config.xml�����ó�����д���Զ�����;
 */
public class MyPlugin implements PlugIn {

	public void destroy() {

	}

	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {
		ConvertUtils.register(new UtilDateConverter(), Date.class);
	}

}
