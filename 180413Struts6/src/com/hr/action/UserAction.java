package com.hr.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * struts的token和国际化
 *@Name : UserAction
 *@Author : LH
 *@Date : 2018-4-13上午03:47:32
 *@Version : V1.0
 * @Description:
 */
public class UserAction extends DispatchAction {

	
	/**
	 * 请求保存一个TOKEN号
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//利用struts写好的token机制保存token号
		//是把一个32位长度的字符串，保存到session之中;
		this.saveToken(request);
		
		return new ActionForward("/reg.jsp");
	}
	
	/**
	 * 验证客户端提交的TOKEN是否有效
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward reg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//获取表单提交的字符串token与session
		//中存的token，做equals
		//验证当前这次请求的TOKEN是否有效
		if(isTokenValid(request)){
			//把session中存的token，remove;
			this.resetToken(request);
			
			// 全局异常的配置测试
			//System.out.println(10/0);
			
			//调用dao，做数据保存;
			//System.out.println("注册成功...");

			return new ActionForward("/success.jsp");
		}else {
			
			return new ActionForward("/error.jsp");
		}
		
	}
	
	/**
	 * 切换语言
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    public ActionForward change(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	
    	String language = request.getParameter("language");
    	//System.out.println("语言："+ language);
    	
    	//获取本地语言对象
    	Locale locale = Locale.getDefault();
    	if("zh".equals(language)){
    		locale = new Locale(language, "CN");
    	}else{
    		locale = new Locale(language, "US");
    		
    	}
    	//设置默认语言
    	this.setLocale(request,locale);
    	
    	return init(mapping, form, request, response);
    }	
	
}
