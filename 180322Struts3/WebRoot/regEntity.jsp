<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'regEntity.jsp' starting page</title>
  </head>
  
  <body>
  
    <form action="regEntity.do" method="post">
        	用户名:<input name="users.uname" value="${ueForm.uname}"/><html:errors property="error.uname"/><br/> 
        	密码:<input name="users.upwd" value="${ueForm.upwd}"/><html:errors property="error.upwd"/><br/> 
        	邮箱:<input name="users.uemail" value="${ueForm.uemail}"/><html:errors property="error.uemail"/><br/> 
        	日期:<input type="date" name="users.udate" value="${ueForm.udate}"/><br/> 
        	<input type="submit" value="提交"/><br/> 
    </form>
  </body>
</html>
