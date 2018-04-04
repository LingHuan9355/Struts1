<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic"  prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'logic.jsp' starting page</title>

  </head>
  
  <body>
     <div align="center">
        <!-- 空值判断 -->
        <logic:empty name="userForm" property="uname">
           uname=null
        </logic:empty>
        
        <!-- 非空判断 -->
        <logic:notEmpty name="userForm" property="uname">
            uname=admin
        </logic:notEmpty>
        <br/>
        
    	<logic:greaterThan name="userForm" property="uage" value="0" >大于</logic:greaterThan>
    	<logic:greaterEqual name="userForm" property="uage" value="5">大于等于</logic:greaterEqual>
    	<logic:lessEqual name="userForm" property="uage" value="11">小于等于</logic:lessEqual>
    	<logic:lessThan name="userForm" property="uage"  value="15">小于</logic:lessThan>
  		<logic:notEqual name="userForm" property="uage" value="20">不等于</logic:notEqual>
  		
  		
  		<bean:write name="userForm" property="money" format="$#,###,###.##"/><br/>
  		<bean:write name="userForm" property="udate" format="yyyy年MM月dd日 E"/><br/>
  		
  		<fmt:formatNumber value="${userForm.money}" pattern="$#,###,###.##" /><br/>
  		<fmt:formatDate value="${userForm.udate}" pattern="yyyy-MM-dd E" />
     </div>

  </body>
</html>
