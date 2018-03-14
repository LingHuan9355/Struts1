<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'updBook.jsp' starting page</title>
    

  </head>
  
  <body>
     <div align="center" >
	     <form action="updBook.do?bookId=${book.book_id}" method="post">
	        <table border="1" bordercolor="black" cellspacing="0" width="200">
	          <tr>
	           <th>编号</th>
	           <td><input name="bookId" value="${book.book_id}" readonly="readonly"></td>
	          </tr>
	          <tr>
	           <th>书名</th>
	           <td><input name="bookName" value="${book.book_name }"/></td>
	          </tr>
	          <tr>
	           <th>价格</th>
	           <td><input name="bookPrice" value="${book.book_price }"/></td>
	          </tr>
	          <tr>
	           <th>作者</th>
	           <td><input name="bookWrite" value="${book.book_write }"/></td>
	          </tr>
	          <tr>
	              <td colspan="2" align="center">
	               <input type="submit" value="修改"/>
	             </td>
	          </tr>
	        </table>
	     </form>
	  </div>
  
  </body>
</html>
