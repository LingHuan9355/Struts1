package com.hr.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * struts��token�͹��ʻ�
 *@Name : UserAction
 *@Author : LH
 *@Date : 2018-4-13����03:47:32
 *@Version : V1.0
 * @Description:
 */
public class UserAction extends DispatchAction {

	
	/**
	 * ���󱣴�һ��TOKEN��
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
		//����strutsд�õ�token���Ʊ���token��
		//�ǰ�һ��32λ���ȵ��ַ��������浽session֮��;
		this.saveToken(request);
		
		return new ActionForward("/reg.jsp");
	}
	
	/**
	 * ��֤�ͻ����ύ��TOKEN�Ƿ���Ч
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
		
		//��ȡ���ύ���ַ���token��session
		//�д��token����equals
		//��֤��ǰ��������TOKEN�Ƿ���Ч
		if(isTokenValid(request)){
			//��session�д��token��remove;
			this.resetToken(request);
			
			// ȫ���쳣�����ò���
			//System.out.println(10/0);
			
			//����dao�������ݱ���;
			//System.out.println("ע��ɹ�...");

			return new ActionForward("/success.jsp");
		}else {
			
			return new ActionForward("/error.jsp");
		}
		
	}
	
	/**
	 * �л�����
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
    	//System.out.println("���ԣ�"+ language);
    	
    	//��ȡ�������Զ���
    	Locale locale = Locale.getDefault();
    	if("zh".equals(language)){
    		locale = new Locale(language, "CN");
    	}else{
    		locale = new Locale(language, "US");
    		
    	}
    	//����Ĭ������
    	this.setLocale(request,locale);
    	
    	return init(mapping, form, request, response);
    }	
	
}
