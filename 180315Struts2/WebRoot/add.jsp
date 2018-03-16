<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'add.jsp' starting page</title>

  </head>
  
  <body>
     <div align="center">
	    <form action="add.do" method="post">
	    		用户名:<input name="name"/><html:errors property="errors.name"/><br/>
	    		工资:<input name="money"/><br/>
	    		出生日期:<input name="birthday"/><br/>
	    		性别:<input type="radio" name="sex" value="male"/>男
    		        <input type="radio" name="sex" value="female"/>女<br/>
    		          爱好:<input type="checkbox" name="hobby" value="game"/>玩游戏
    		       <input type="checkbox" name="hobby" value="tv"/>看电视
    		       <input type="checkbox" name="hobby" value="movie"/>看电影
    		        <br/>
    		          省份:<select name="province">
    				<option value="bj">北京</option>
    				<option value="hn">湖南</option>
    				<option value="js">江苏</option>
    		    </select>
    		    <br/>
    		备注:<textarea rows="5" cols="20" name="info"></textarea>  <br/>
    		是否公开资料:<input type="checkbox" name="pub"><br/>
	    		<input type="submit" value="提交"/>
	    </form>	
    </div>	
  </body>
</html>
