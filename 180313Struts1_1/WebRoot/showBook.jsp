<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showBook.jsp' starting page</title>

  </head>
  
  <body>
       <div align="center">
       <table border="1" bordercolor="black" cellspacing="0" width="50%">
         <tr>
           <th>书籍编号</th>
           <th>书籍名称</th>
           <th>书籍价格</th>
           <th>作       者</th>
           <th>操作</th>
         </tr>
         <c:forEach items="${list}" var="book">
	         <tr align="center">
	           <td>${book.book_id }</td>
	           <td>${book.book_name }</td>
	           <td>${book.book_price }</td>
	           <td>${book.book_write }</td>
	           <td>
	             <a href="delBook.do?bookId=${book.book_id}">删除</a>
	           </td>
	         </tr>
         </c:forEach>
       </table>
       <h1><a href="index.jsp">首页</a></h1>
     </div>
  </body>
</html>
