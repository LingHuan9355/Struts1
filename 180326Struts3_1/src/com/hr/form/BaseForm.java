package com.hr.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.struts.action.ActionForm;

/**
 * 
 *@Name : BaseForm
 *@Author : LH
 *@Date : 2018-3-26下午10:33:06
 *@Version : V1.0
 * @Description:
 * 1.写一个reg1.jsp，一个表单用户名，出生日期， 邮箱地址，写一个BaseForm,继承ActionForm里面四个方法
 * public boolean isEmpty(String str)
 * public boolean isLength(String str)
 * public boolean isEmail(String str)
 * public boolean isDate(String str)
 * 使用正则表达式验证
 */
@SuppressWarnings("serial")
public class BaseForm extends ActionForm {

	/**
	 * 判断字符串的内容是否为null或是双引号的空值
	 * @param str
	 * @return
	 */
	public boolean isEmpty(String str){
		if(str != null && str.trim().length()>0){
			return false;
		}else{
			return true;
		}
	}
	
	 /**
	  * 判断字符串的长度是否大于4
	  * @param str
	  * @return
	  */
	 public boolean isLength(String str){
		  if(str.length() < 4){
			  return true;  
		  }else{
			  return false;
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
	  
	  /**
	   * 判断是不是日期格式
	   * @param str
	   * @return
	   * @throws Exception
	   */
	  public boolean isDate(Date str) {
			//  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//try {
				//Date date = sdf.parse(str);
				if(str instanceof java.util.Date){
					return true;
				}else{
					return false;
				}
			/*} catch (ParseException e) {
				e.printStackTrace();
			}*/
			  
	  }
}
