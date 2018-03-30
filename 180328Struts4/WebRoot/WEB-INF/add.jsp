<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'add.jsp' starting page</title>

  </head>
  
  <body>
         <!-- struts的文件上传
  			method="post"
  			enctype="multipart/form-data"  设置字节流的方式提交数据
  		 
  		 	在xxx.do后面的method=add，表示调用Action中的add方法
  		    method这个字符串来源于struts-config.xml中的配置
  		    add来源于Action中具体的方法名
  		 -->                                                           
  		 <form action="userAction.do?method=add" method="post" enctype="multipart/form-data">
  		       用户名:<input name="myUser.name"/><br/>
    	       年    龄:<input name="myUser.age"/><br/>
    	       头    像:<input type="file" name="myfile"/><br/>
    		<input type="submit" value="提交"/>
  		 </form>
  </body>
</html>
