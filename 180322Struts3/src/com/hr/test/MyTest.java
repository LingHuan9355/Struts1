package com.hr.test;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 
 *@Name : MyTest
 *@Author : LH
 *@Date : 2018-3-22下午10:53:19
 *@Version : V1.0
 * @Description:
 *        【java中的正则表达式】
 */
public class MyTest {

	@Test
	public void test1(){
		//字符串的比较:内容是否相同
		/*String str = "abc";
		System.out.println(str.equals("abc"));
		
		//字符串的匹配
		System.out.println(str.matches("abc"));*/
		
		String regex="abc";
		
		/**
		 * 一、单个字符的描述
		 */

		//用于匹配单个a-c任意的一个字符
		/*regex="[abc]";
		System.out.println(Pattern.matches(regex, "b"));*/
		//用于匹配单个a-z任意的一个字符
        /*regex = "[a-z]";//[a-zA-Z]		
        System.out.println(Pattern.matches(regex, "d"));*/
        //用于匹配除了单个a b c任意的一个字符
        /*regex = "[^abc]";
		System.out.println(Pattern.matches(regex, "y"));*/
		//用于匹配单个a-d或m-p任意的一个字符
		/*regex = "[a-d[m-p]]";
		System.out.println(Pattern.matches(regex, "n"));*/
		//用于匹配a-z中的[d-f]的任意一个字符
		/*regex = "[a-z&&[def]]";
		System.out.println(Pattern.matches(regex, "d"));*/
		//a-z之间，除了b c  
		/*regex = "[a-z&&[^bc]]";
		System.out.println(Pattern.matches(regex, "e"));*/
		//a-z之除，除了m-p这些字符
		/*regex = "[a-z&&[^m-p]]";
		System.out.println(Pattern.matches(regex, "q"));*/
		
		
		/**
		 * 二、预定义字符类(特殊字符);
		 */
		/*regex = ".";
		System.out.println(Pattern.matches(regex, "u"));*/
		/*regex = "\\d";//匹配单个数字
		System.out.println(Pattern.matches(regex, "1"));
		regex = "\\D";//匹配除了数字以外的任意字符
		System.out.println(Pattern.matches(regex, "t"));
		regex = "\\w";//匹配[a-zA-Z0-9_]
		System.out.println(Pattern.matches(regex, "#"));
		regex = "\\W";//匹配[^a-zA-Z0-9_]
		System.out.println(Pattern.matches(regex, "$"));*/
		
		//数量词
		/*regex = "a{5}";//表示需要匹配5次
		System.out.println(Pattern.matches(regex, "aaaaa"));*/
		/*regex = "a{1,3}";//表示需要匹配1-3次
		System.out.println(Pattern.matches(regex, "aaaa"));*/
		/*regex = "a{1,}";//表示需要匹配最少1次，最多N次
		System.out.println(Pattern.matches(regex, "b"));*/
		/*regex = "a?b";//a{0,1}
		System.out.println(Pattern.matches(regex, "ab"));
		regex = "a*b";//a{0,}
		System.out.println(Pattern.matches(regex, "aaaaab"));*/
		/*regex = "^a+b$";//a{1,}
		System.out.println(Pattern.matches(regex, "aaab"));*/
		
		//用户名的判断4-12位//[a-zA-Z0-9_]
		regex = "\\w{4}";
		System.out.println(Pattern.matches(regex, "ada7"));
		
		//邮箱的判断[a-zA-Z0-9_]@[a-zA-Z0-9].com|cn
		regex = "^\\w+@[a-zA-Z0-9]+\\.((com)|(cn))$";
		System.out.println(Pattern.matches(regex, "zs@sina.com"));
		
		//日期格式的判断
		regex = "^\\d{4}-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[0-1]))";
		System.out.println(Pattern.matches(regex, "2015-02-23"));
	}
}
