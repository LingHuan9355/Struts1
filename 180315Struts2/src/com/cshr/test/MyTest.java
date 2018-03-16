package com.cshr.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.junit.Test;

import com.cshr.converter.UtilDateConverter;
import com.cshr.entity.Student;
import com.cshr.form.StudentForm;


public class MyTest  {

	@Test
	public void testMain() throws Exception{
		
		//注册自定义的util.date的转换器
		ConvertUtils.register(new UtilDateConverter(),Date.class);
		
		//创建一个form对象
		StudentForm  stuForm = new StudentForm();
		
		String name = "tom";
		String money = "8888";
		String bithday = "1999-09-09";
		
		//关于java.util.Date收集表单数据时，默认是会
		//出现IllegalArgumentException: argument type mismatch
		
		
		//方法一、将属性值放到对应的对象中
		/*BeanUtils.copyProperty(stuForm, "name", name);
		BeanUtils.copyProperty(stuForm, "momey", money);
		BeanUtils.copyProperty(stuForm, "brithday", bithday);*/
		
		//方法二、
		//request.getPameterMap():
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("momey", money);
		map.put("brithday", bithday);
		
        BeanUtils.populate(stuForm, map);
		
		//System.out.println(stuForm.getName());
		//System.out.println(stuForm.getMomey());
		//System.out.println(stuForm.getBrithday());
		
		//方法三
		Student stu = new Student();
		//stu.setBirthday(stuForm.getBirthday());
		//实现对象的复制
		BeanUtils.copyProperties(stu, stuForm);
		System.out.println(stu.getName());
		System.out.println(stu.getMomey());
		System.out.println(stu.getBrithday());
	}
	
}
