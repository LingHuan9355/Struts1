<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML >
<html>
  <head>
    <title>My JSP 'addStudent.jsp' starting page</title>
    
  </head>
  
  <body>
    <div align="center">
      <form action="addStudent.do" method="post">
              编号:<input name="id"><br/>
              姓名:<input name="name"><html:errors property="error.name"/><br/>
              年龄:<input name="age"><html:errors property="error.age"/><br/>
              余额:<input name="money"><html:errors property="error.money"/><br/>
              出生日期: <input name="birthday" type="date"><br/>
              性别:<input type="radio" name="sex" value="男">男 
        <input type="radio" name="sex" value="女">女 
        <input type="radio" name="sex" value="妖">妖 
        <html:errors property="error.sex"/>
        <br/>
              爱好: <input type="checkbox" name="hobby" value="阅读">阅读
        <input type="checkbox" name="hobby" value="音乐">音乐
        <input type="checkbox" name="hobby" value="运动">运动
        <input type="checkbox" name="hobby" value="编程">编程
        <input type="checkbox" name="hobby" value="历史">历史
        <br/>
               户籍:<select name="province">
               <option value="hn">湖南</option>
               <option value="hb">湖北</option>
               <option value="gd">广东</option>
               <option value="gx">广西</option>
               <option value="sh">上海</option>
        </select>
       <br/>
               资料:<textarea rows="5" cols="20" name="info"></textarea><br/>
              是否公开资料:<input type="checkbox" name="pub"><br/>
     <input type="submit" value="提交"/>
    </form>
    </div>
    
  </body>
</html>
