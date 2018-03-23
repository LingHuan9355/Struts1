package com.hr.form;

import java.util.regex.Pattern;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class BaseForm extends ActionForm {

	/**
	 * 判断字符串的内容是否为null或是双引号的空值
	 */
	public boolean isEmpty(String str){
		if(str != null && str.trim().length()>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 判断邮箱的格式
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
