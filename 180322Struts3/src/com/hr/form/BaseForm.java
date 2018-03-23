package com.hr.form;

import java.util.regex.Pattern;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class BaseForm extends ActionForm {

	/**
	 * �ж��ַ����������Ƿ�Ϊnull����˫���ŵĿ�ֵ
	 */
	public boolean isEmpty(String str){
		if(str != null && str.trim().length()>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * �ж�����ĸ�ʽ
	 * @param str
	 * @return
	 */
	public boolean isEmail(String str){
		String regex = "^\\w+@[a-zA-Z0-9]+\\.((com)|(cn))$";
		if(Pattern.matches(regex, str)){
			return true;
		}else{
			return false;
		}
	}
}
