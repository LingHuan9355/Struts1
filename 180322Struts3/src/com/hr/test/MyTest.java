package com.hr.test;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 
 *@Name : MyTest
 *@Author : LH
 *@Date : 2018-3-22����10:53:19
 *@Version : V1.0
 * @Description:
 *        ��java�е�������ʽ��
 */
public class MyTest {

	@Test
	public void test1(){
		//�ַ����ıȽ�:�����Ƿ���ͬ
		/*String str = "abc";
		System.out.println(str.equals("abc"));
		
		//�ַ�����ƥ��
		System.out.println(str.matches("abc"));*/
		
		String regex="abc";
		
		/**
		 * һ�������ַ�������
		 */

		//����ƥ�䵥��a-c�����һ���ַ�
		/*regex="[abc]";
		System.out.println(Pattern.matches(regex, "b"));*/
		//����ƥ�䵥��a-z�����һ���ַ�
        /*regex = "[a-z]";//[a-zA-Z]		
        System.out.println(Pattern.matches(regex, "d"));*/
        //����ƥ����˵���a b c�����һ���ַ�
        /*regex = "[^abc]";
		System.out.println(Pattern.matches(regex, "y"));*/
		//����ƥ�䵥��a-d��m-p�����һ���ַ�
		/*regex = "[a-d[m-p]]";
		System.out.println(Pattern.matches(regex, "n"));*/
		//����ƥ��a-z�е�[d-f]������һ���ַ�
		/*regex = "[a-z&&[def]]";
		System.out.println(Pattern.matches(regex, "d"));*/
		//a-z֮�䣬����b c  
		/*regex = "[a-z&&[^bc]]";
		System.out.println(Pattern.matches(regex, "e"));*/
		//a-z֮��������m-p��Щ�ַ�
		/*regex = "[a-z&&[^m-p]]";
		System.out.println(Pattern.matches(regex, "q"));*/
		
		
		/**
		 * ����Ԥ�����ַ���(�����ַ�);
		 */
		/*regex = ".";
		System.out.println(Pattern.matches(regex, "u"));*/
		/*regex = "\\d";//ƥ�䵥������
		System.out.println(Pattern.matches(regex, "1"));
		regex = "\\D";//ƥ�������������������ַ�
		System.out.println(Pattern.matches(regex, "t"));
		regex = "\\w";//ƥ��[a-zA-Z0-9_]
		System.out.println(Pattern.matches(regex, "#"));
		regex = "\\W";//ƥ��[^a-zA-Z0-9_]
		System.out.println(Pattern.matches(regex, "$"));*/
		
		//������
		/*regex = "a{5}";//��ʾ��Ҫƥ��5��
		System.out.println(Pattern.matches(regex, "aaaaa"));*/
		/*regex = "a{1,3}";//��ʾ��Ҫƥ��1-3��
		System.out.println(Pattern.matches(regex, "aaaa"));*/
		/*regex = "a{1,}";//��ʾ��Ҫƥ������1�Σ����N��
		System.out.println(Pattern.matches(regex, "b"));*/
		/*regex = "a?b";//a{0,1}
		System.out.println(Pattern.matches(regex, "ab"));
		regex = "a*b";//a{0,}
		System.out.println(Pattern.matches(regex, "aaaaab"));*/
		/*regex = "^a+b$";//a{1,}
		System.out.println(Pattern.matches(regex, "aaab"));*/
		
		//�û������ж�4-12λ//[a-zA-Z0-9_]
		regex = "\\w{4}";
		System.out.println(Pattern.matches(regex, "ada7"));
		
		//������ж�[a-zA-Z0-9_]@[a-zA-Z0-9].com|cn
		regex = "^\\w+@[a-zA-Z0-9]+\\.((com)|(cn))$";
		System.out.println(Pattern.matches(regex, "zs@sina.com"));
		
		//���ڸ�ʽ���ж�
		regex = "^\\d{4}-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[0-1]))";
		System.out.println(Pattern.matches(regex, "2015-02-23"));
	}
}
