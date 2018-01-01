<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.costuary.bean.ServerHealthInfoBean" %>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>家庭理财网络应用程序beta1.0 written by Tim Zhang</title>
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/mobile.css" />
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/icon.css" />
<!-- try to change theme by user selecting -->
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/material/easyui.css" />
<script type="text/javascript" src="${jQueryPath}/jquery.min.js"></script>
<script type="text/javascript" src="${jQueryPath}/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${jQueryPath}/jquery.easyui.mobile.js"></script>
</head>
<body>

<a href="AppMenu.jsp">Return to menu</a><br><br>

<%
String temp = (String)request.getAttribute("result");
// out.print(temp);
%>

<div id = "welcomeArea">
 <table border = "0" align="center">
    <tr align = "left">
     <td><%=temp%></td>
	</tr>
 </table>
</div>
<br>

<%
ServerHealthInfoBean bean = new ServerHealthInfoBean();
bean = (ServerHealthInfoBean)request.getAttribute("serverHealthInfoBean");
%>

 <div id = "dataArea">
  <table border = "0" align="center">
	<tr><td align="right">记录ID:</td><td align="left"><% out.print(bean.getRecord_id()); %></td></tr>
	<tr><td align="right">CPU温度:</td><td align="left"><% out.print(bean.getCpu_teperature() + "°C"); %></td></tr>
	<tr><td align="right">显卡温度:</td><td align="left"><% out.print(bean.getGpu_temperature() + "°C"); %></td></tr>
	<tr><td align="right">风扇转速:</td><td align="left"><% out.print(bean.getFan_speed() + "RPM"); %></td></tr>
	<tr><td align="right">记录时间:</td><td align="left"><% out.print(bean.getRecord_timeStamp()); %></td></tr>
	<tr>
	 <td></td>
	 <td></td>
	</tr>
  </table>
 </div>
<br>

 <div id = "formArea">
 <table border = "0" align="center">
    <tr align = "center">
        <td>
     	<form action="ServerHealthInfo" method="get">
	 		<input type="submit" value="查询">
   		</form>
   		</td>
	</tr>
 </table>
</div>

</body>
</html>