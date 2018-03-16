package com.cshr.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

/**
 * 
 *@Name : UtilDateConverter
 *@Author : LH
 *@Date : 2018-3-16ÏÂÎç05:48:24
 *@Version : V1.0
 * @Description:  java.util.DateµÄ×ª»»Æ÷
 */
public class UtilDateConverter implements Converter {

	@SuppressWarnings("unchecked")
	public Object convert(Class type, Object value) {
          if(value == null){
        	  return null;
          }
          
          if(value instanceof Date){
        	  return value;
          }
          
          if(value instanceof String){
        	String str = (String) value;
        	
        	if(str.trim().length() > 0){
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	    
        		try {
					Date date = sdf.parse(str);
                    return date;
        		} catch (ParseException e) {
					e.printStackTrace();
				}
        	
        	}
          }
		
		return null;
	}

}
