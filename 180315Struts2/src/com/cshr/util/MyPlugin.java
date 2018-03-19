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
 *@Date : 2018-3-16下午06:57:50
 *@Version : V1.0
 * @Description:  
 * //转换器的注册方式二
 * 二、插件注册
     a.自定义一个类，实现一个插件接口(Plugin);
     b.在struts-config.xml中配置出上面写的自定义类;
 */
public class MyPlugin implements PlugIn {

	public void destroy() {

	}

	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {
		ConvertUtils.register(new UtilDateConverter(), Date.class);
	}

}
