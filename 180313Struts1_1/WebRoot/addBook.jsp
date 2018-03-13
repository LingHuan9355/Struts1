<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'addBook.jsp' starting page</title>
  </head>
  
  <body>
	  <div align="center" >
	     <form action="addBook.do" method="post">
	        <table border="1" bordercolor="black" cellspacing="0" width="200">
	          <tr>
	           <th>书名</th>
	           <td><input name="bookName"/></td>
	          </tr>
	          <tr>
	           <th>价格</th>
	           <td><input name="bookPrice"/></td>
	          </tr>
	          <tr>
	           <th>作者</th>
	           <td><input name="bookWrite"/></td>
	          </tr>
	          <tr>
	              <td colspan="2" align="center">
	               <input type="submit" value="添加"/>
	             </td>
	          </tr>
	        </table>
	     </form>
	  </div>
  </body>
</html>
