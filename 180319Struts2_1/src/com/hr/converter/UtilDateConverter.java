package com.hr.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class UtilDateConverter implements Converter {

	//java.util.DateµÄ×ª»»Æ÷
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
