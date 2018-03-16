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
		
		//ע���Զ����util.date��ת����
		ConvertUtils.register(new UtilDateConverter(),Date.class);
		
		//����һ��form����
		StudentForm  stuForm = new StudentForm();
		
		String name = "tom";
		String money = "8888";
		String bithday = "1999-09-09";
		
		//����java.util.Date�ռ�������ʱ��Ĭ���ǻ�
		//����IllegalArgumentException: argument type mismatch
		
		
		//����һ��������ֵ�ŵ���Ӧ�Ķ�����
		/*BeanUtils.copyProperty(stuForm, "name", name);
		BeanUtils.copyProperty(stuForm, "momey", money);
		BeanUtils.copyProperty(stuForm, "brithday", bithday);*/
		
		//��������
		//request.getPameterMap():
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("momey", money);
		map.put("brithday", bithday);
		
        BeanUtils.populate(stuForm, map);
		
		//System.out.println(stuForm.getName());
		//System.out.println(stuForm.getMomey());
		//System.out.println(stuForm.getBrithday());
		
		//������
		Student stu = new Student();
		//stu.setBirthday(stuForm.getBirthday());
		//ʵ�ֶ���ĸ���
		BeanUtils.copyProperties(stu, stuForm);
		System.out.println(stu.getName());
		System.out.println(stu.getMomey());
		System.out.println(stu.getBrithday());
	}
	
}
