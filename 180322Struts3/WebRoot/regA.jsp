<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'regA.jsp' starting page</title>
    
  </head>
  <body>
    <form action="regAAction.do" method="post">
          <input type="hidden" name="temp" value="a"/>
              用户名:<input name="users.uname" value="${ueForm.uname}"/><html:errors property="error.uname"/><br/> 
                 密码:<input name="users.upwd" value="${ueForm.upwd}"/><html:errors property="error.upwd"/><br/> 
    	  <input type="submit" value="下一步"/>
    	</form>
  </body>
</html>
