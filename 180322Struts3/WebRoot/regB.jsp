<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<!DOCTYPE HTML >
<html>
  <head>
    <title>My JSP 'regB.jsp' starting page</title>
    
  </head>
  
  <body>
    <form action="regBAction.do" method="post">
            <input type="hidden" name="temp" value="b"/>
        	邮箱:<input name="users.uemail" value="${ueForm.users.uemail}"/>
        	   <html:errors property="error.uemail" /><br/> 
        	日期:<input type="date" name="users.udate" value="${ueForm.users.udate}"/><br/> 
        	<input type="submit" value="提交"/><br/> 
    </form>

  </body>
</html>
