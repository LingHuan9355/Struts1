<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>

  </head>
  
  <body>
      <h1 align="center"><a href="index.jsp">首页</a></h1>
      <table border="1" cellspacing="0" background="black" align="center" width="50%">
         <tr>
           <th>编号</th>
           <th>用户名</th>
           <th>年龄</th>
           <th>图片名称</th>
           <th>图片下载</th>
           <th>操作</th>
         </tr>
         <c:forEach items="${list}" var ="user">
         <tr>
           <td>${user.id}</td>
           <td>${user.name}</td>
           <td>${user.age}</td>
           <td>${user.filename}</td>
           <td>
               <img width="30" src="userAction.do?method=showImg&id=${user.id}"/>
               <a href="userAction.do?method=download&id=${user.id}">下载</a>
           </td>
           <td><a href="userAction.do?method=showOne&id=${user.id}">修改</a>
	           <a href="javascript:Del(${user.id})">删除</a>
	       </td>
         </tr>
         </c:forEach>
      </table>

  </body>
  <script type="text/javascript">
       function Del(id){
           if(confirm("确认删除吗？ ")){
           
             location.href="userAction.do?method=DeleteUser&id="+id;
           }
       
       }
  
  </script>
</html>
