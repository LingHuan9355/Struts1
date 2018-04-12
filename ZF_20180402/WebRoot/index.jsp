<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic"  prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>北京出租房</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">

		<link href="style/mycss.css" rel="stylesheet" type="text/css" />
		<link href="style/texts.css" rel="stylesheet" type="text/css" />
		<link href="style/btn.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/qxjd.js"></script>
	</HEAD>
	
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="5"><img src="images/top.jpg" width="780" height="213"></td>
			</tr>
			<tr>
				<td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
			</tr>
			<tr>
				<td width="38" background="images/middle2.jpg">&nbsp;</td>
				<td width="172" valign="top" align="center">
					<script language="javascript">
					<!--
						function login(){
							if( document.myForm.uname.value =="" ){
								alert("用户名不能为空");
								return false;
							}else if(document.myForm.upass.value == ""){
								alert("密码不能为空");
								return false;
							} else {
								return true;
							}
						}
					-->
					</script>
					<form action="login.htm" method="post" name="myForm"
						onsubmit="return login()">
						<p>&nbsp;</p>
						<table align="center">
							<tr>
								<td colspan="2">用户名：</td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="uname" size=10 " class="editbox"></td>
							</tr>
							<tr>
								<td colspan="2">密&nbsp;&nbsp;码：</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="password" name="upass" size=10 "  class='editbox'>
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" name="sign" value="login" />
									<input type="submit" value="登陆" class='btn'>
									<input type="reset" value="重置" class='btn'>
								</td>
							</tr>
							<tr>
								<td>
									<a href="reg.htm">注册用户</a>
								</td>
							</tr>
						</table>
					</form>
				</td>
				<td width="35" background="images/layout_24.gif">&nbsp;</td>
				<td width="495" align="center">
				<br/>
					<%--<form action="list.htm" method="post" name="mf">--%>
					<!-- styleId相当于普通标签的id -->
	     <html:form action="fwxxAction.do?method=search" method="post" styleId="mf">
				<input type="hidden" name="page" value="1" />
<script>
function fswitch(id){
	var o = document.getElementById(id);
	if (o){
		if (o.style.display == "none"){
			 o.style.display = "block";
	    } else {
		    o.style.display = "none";
		}
	}
}
</script>

		<div style="text-align: left; width: 100%;">
			<html:text property="title" ></html:text>
			<input type="submit" value="查询" class="btn">
			<span onclick="fswitch('advSearch');" style="cursor: hand; color: blue;">高级搜索</span>
		</div>

	<table width="100%;" id="advSearch" style="border: solid 0px #000; display: none;">
		 <tr>
			<td width="14%">区&nbsp;&nbsp;县：</td>
			<td>
				<html:select property="qxid" styleId="qx" onchange="PostJd()">
				     <html:option value="0">不限--</html:option>
	                 <html:optionsCollection name="fwxxForm" property="qxlist" label="qx" value="qxid"/>
	            </html:select>
			</td>
			<td rowspan="6">&nbsp;</td>
		</tr>
		<tr>
			<td>街&nbsp;&nbsp;道：</td>
			<td>
				<html:select property="jdid" styleId="jd" >
				     <html:option value="0">不限--</html:option><%--
	                 <html:optionsCollection name="fwxxForm" property="jdlist" label="jd" value="jdid"/>
	            --%></html:select>
			</td>
		</tr>
		<tr>
			<td>租&nbsp;&nbsp;金：</td>
			<td>
			  <html:text property="zjmin" size="5" ></html:text>至
			  <html:text property="zjmax" size="5" ></html:text>元/月
            </td>
		</tr>
		<tr>
			<td>户&nbsp;&nbsp;型：</td>
			<td>
				<select name="shi" style="width: 60">
					<option value="0">不限--</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</select>
				室
				<select name="ting" style="width: 60">
					<option value="0">不限--</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
				厅  
			</td>
		</tr>
		<tr>
			<td>房屋类型：</td>
			<td>
				<logic:iterate id="fwlx" name="fwxxForm" property="fwlxlist">
					<html:multibox property="lxids">${fwlx.lxid}</html:multibox>${fwlx.fwlx}
				</logic:iterate>			
			</td>
		</tr>
		<tr>
			<td>发布日期：</td>
			<td>
				<select name="date" style="width: 80">
					<option value="0">不限--</option>
					<option value="1">当天</option>
					<option value="2">近两天</option>
					<option value="3">近三天</option>
					<option value="7">近一周</option>
					<option value="14">近两周</option>
					<option value="30">近一月</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan='3'><hr/></td>
		</tr>

		</table>
		<table width="100%" cellspacing="0">
			<tr>
				<th width='250' class="table_title">标题</th>
				<th width='90' align='center' class="table_title">月租金</th>
				<th align='center' class="table_title">发布日期</th>
			</tr>
			
            <logic:iterate id="fwxx" name="fwxxForm" property="fwxxlist">
			<tr>
				<td><a href='detail.htm'>${fwxx.title }</a></td>
				<td align='center' style='height: 30px;'>
				    <bean:write name="fwxx" property="zj" format="#,###" />元
				</td>
				<td align='center'>
					<bean:write name="fwxx" property="date" format="yyyy年MM月dd日" />
				</td>
			</tr>
			</logic:iterate>
			
			<tr>
				<td colspan='3'><hr/></td>
			</tr>
		</table>

	</html:form>
		</td>
		<td width="40" background="images/middle4.jpg">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
	</tr>
</table>
		<P align="center">2007 Beijing Aptech Beida Jade Bird Information Technology Co.,Ltd版权所有</P>
		<br/>
	</BODY>
</HTML>