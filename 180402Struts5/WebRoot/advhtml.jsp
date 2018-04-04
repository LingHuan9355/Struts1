<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'advhtml.jsp' starting page</title>

  </head>
  
  <body>
     <div align="center">
     <html:form action="tagAction.do?method=update" method="post">
       <!-- property相当于普通标签的name属性
   			可以将值提交到ActionForm里面对应的属性中，但要求did一定要在ActionForm要有对应的get/set方法
   		-->
         Dog:<html:select property="did">
       <!-- name属性表示从哪个ActionForm获取值，所以这里填写ActionForm存在session(request)中的key名 struts-config.xml中写好的名字 
   		    property在ActionForm中具体存的一个集合属性的名字
   			label用于设置显示的属性名
   			value用于提交的属性名
   		-->
   				<html:optionsCollection  name="userForm" property="dlist" label="dname" value="did"/>
          
             </html:select>
             <br/>
   
               狗:
   		<!-- id相当c:forEach的var
   			name是ActionForm的存在session(request)中的key名
   			propety是ActionForm中的集合属性名，相当于items
   		 -->
   		 <logic:iterate id="dog" name="userForm" property="dlist">
   		    <html:multibox property="dids">${dog.did}</html:multibox>${dog.dname}
   		 </logic:iterate><br/>
   		 <html:submit value="提交"></html:submit>
      </html:form>
      </div>
  </body>
</html>
