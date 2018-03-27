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
 *@Date : 2018-3-26����10:33:06
 *@Version : V1.0
 * @Description:
 * 1.дһ��reg1.jsp��һ�����û������������ڣ� �����ַ��дһ��BaseForm,�̳�ActionForm�����ĸ�����
 * public boolean isEmpty(String str)
 * public boolean isLength(String str)
 * public boolean isEmail(String str)
 * public boolean isDate(String str)
 * ʹ��������ʽ��֤
 */
@SuppressWarnings("serial")
public class BaseForm extends ActionForm {

	/**
	 * �ж��ַ����������Ƿ�Ϊnull����˫���ŵĿ�ֵ
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
	  * �ж��ַ����ĳ����Ƿ����4
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
	  
	  /**
	   * �ж��ǲ������ڸ�ʽ
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
