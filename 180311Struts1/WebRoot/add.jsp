<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
  <head>
    
    <title>My JSP 'add.jsp' starting page</title>

  </head>
  
  <body>
       <form action="add.do" method="post">
    		用户名:<input name="name"/><br/>
    		工资:<input name="money"/><br/>
    		出生日期:<input type="date" name="birthday"/><br/>
    		<input type="submit" value="提交"/>
    	</form>
    
  </body>
</html>
