<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'basehtml.jsp' starting page</title>

  </head>
  
  <body>
      <!-- form标签
  			property就相当于普通标签的name属性
  	  -->
  	  <div align="center">
  	  <html:form action="tagAction.do?method=basehtml" method="post">
  	     用户名：<html:text property="uname"></html:text>
  	     <br/>
  	     密    码：<html:password property="upwd"></html:password>
  	     <br/>
  	     年    龄：<html:text property="uage"></html:text>
  	     <br/>  
  	     性    别：<html:radio property="usex" value="male">男</html:radio>  
  	       <html:radio property="usex" value="female">女</html:radio>
  	       <br/>
  	     爱    好：<html:checkbox property="hobby" value="play">玩</html:checkbox>       
  	       <html:checkbox property="hobby" value="eat">吃</html:checkbox>       
  	       <html:checkbox property="hobby" value="drink">喝</html:checkbox>
  	       <br/> 
              城市：<html:select property="city">
  	                 <html:option value="changsha">长沙</html:option>
  	                 <html:option value="dongguan">东莞</html:option>
  	                 <html:option value="shanghai">上海</html:option>
  	                 <html:option value="beijing">北京</html:option>
  	                 <html:option value="shenzhen">深圳</html:option>
  	    </html:select>
  	     <br/>    
  	   备注：<html:textarea property="info" rows="5" cols="20"></html:textarea> 
  	    <br/>         
  	  <html:submit value="提交"></html:submit>
  	  </html:form>
  	  </div>
  </body>
</html>
