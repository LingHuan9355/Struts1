<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML >
<html>
  <head>
    
    <title>My JSP 'reg1.jsp' starting page</title>

  </head>
  
  <body>
     <form action="regAction.do" method="post">
        	用户名:<input name="uname" value="${uForm.uname}"/><html:errors property="error.uname"/><br/> 
        	邮箱:<input name="uemail" value="${uForm.uemail}"/><html:errors property="error.uemail"/><br/> 
        	日期:<input type="date" name="udate" value="${uForm.udate}"/><html:errors property="error.udate"/><br/> 
        	<input type="submit" value="提交"/><br/> 
    </form>
  </body>
</html>
