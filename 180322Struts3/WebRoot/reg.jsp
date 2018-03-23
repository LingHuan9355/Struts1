<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML >
<html>
  <head>
    <title>My JSP 'reg.jsp' starting page</title>
  </head>
  
  <body>
    <form action="regAction.do" method="post">
        	用户名:<input name="uname" value="${uForm.uname}"/><html:errors property="error.uname"/><br/> 
        	密码:<input name="upwd" value="${uForm.upwd}"/><html:errors property="error.upwd"/><br/> 
        	邮箱:<input name="uemail" value="${uForm.uemail}"/><html:errors property="error.uemail"/><br/> 
        	日期:<input type="date" name="udate" value="${uForm.udate}"/><br/> 
        	<input type="submit" value="提交"/><br/> 
    </form>
  </body>
</html>
