<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'UpdUser.jsp' starting page</title>
  </head>
  <body>
      <div align="center" >
    <form action="userAction.do?method=UpdateUser&id=${user.id}" method="post" enctype="multipart/form-data">
            编   号:<input name="user.id" value="${user.id}" readonly="readonly"><br/>
	用户名:<input name="user.name" value="${user.name}"/><br/>
           年     龄:<input name="user.age" value="${user.age}"/><br/>
           图     片:<img src="userAction.do?method=showImg&id=${user.id}"  width="100px"/><br/>
           <input type="file" name="imgfile" /><br/>
    <input type="submit" value="提交"/>
    </form>
  </div>
  </body>
</html>
