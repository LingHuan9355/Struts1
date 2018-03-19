<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'result.jsp' starting page</title>

  </head>
  
  <body>
    <div align="center">
	      编号：${student.id}<br/>
	        姓名：${student.name}<br/>
	       年龄：${student.age}<br/>
	       存款：${student.money}<br/>
	       出生日期：${student.birthday}<br/>
	       
	        爱好：<c:forEach items="${student.hobby}" var="aihao">
	               ${aihao}
	          </c:forEach> <br/>
	       性别：${student.sex}<br/>
	       户籍：${student.province}<br/>
	       资料：${student.info}<br/>
	       是否公开资料：${student.pub}<br/>
    </div>
  </body>
</html>
