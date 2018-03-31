<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'addUser.jsp' starting page</title>

  </head>
  
  <body>
     <form action="userAction.do?method=addUser" method="post" enctype="multipart/form-data">
		用户名:<input name="user.name"/><br/>
	           年    龄:<input name="user.age"/><br/>
	           图    片:<input type="file" name="imgfile"/><br/>
	    <input type="submit" value="提交"/>
  </form>
  </body>
</html>
