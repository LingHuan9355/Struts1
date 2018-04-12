<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"  prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'reg.jsp' starting page</title>

  </head>
  
  <body>
    	<%--<form action="" method="post">
    		用户名 :<input type="text" name="uname"/><br/>
    		密码:<input type="password" name="upwd"/><br/>
    		<input type="submit" value="提交"/>
    	</form>
    	--%>
    	
    	<html:form action="userAction.do?method=reg" method="post">
    	   	<bean:message key="uname"/>:<input type="text" name="uname"/><br/>
    		<bean:message key="upwd"/>:<input type="password" name="upwd"/><br/>
    		<input type="submit" value="<bean:message key='reg'/>"/>
    	</html:form>
    	<a href="userAction.do?method=change&language=zh"><bean:message key="chinese"/></a>
    	<a href="userAction.do?method=change&language=en"><bean:message key="english"/></a>
    	<%=session.getAttribute("org.apache.struts.action.TOKEN")%>
  </body>
</html>
