<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'stulist.jsp' starting page</title>

  </head>
  
  <body>
     <div align="center">
       <table border="1" bordercolor="black" cellspacing="0" width="50%">
         <tr>
           <th>编号</th>
           <th>姓名</th>
           <th>金额</th>
           <th>日期</th>
           <th>删除</th>
         </tr>
         <c:forEach items="${list}" var="stu">
	         <tr align="center">
	           <td>${stu.id }</td>
	           <td>${stu.name }</td>
	           <td>${stu.momey }</td>
	           <td>${stu.brithday }</td>
	           <td>
	             <a href="delete.do?id=${stu.id }">删除</a>
	           </td>
	         </tr>
         </c:forEach>
       </table>
     </div>
  
  </body>
</html>
