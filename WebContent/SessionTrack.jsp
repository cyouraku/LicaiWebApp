<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.costuary.bean.MyLoginBean" %>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
%>
<%
	// Get session creation time.
	Date createTime = new Date(session.getCreationTime());
	// Get last access time of this web page.
	Date lastAccessTime = new Date(session.getLastAccessedTime());
	Integer visitCount = new Integer(0);
	String visitCountKey = new String("visitCount");
	String userIDKey = new String("userID");
	String userID = "";
	MyLoginBean bean;
	String userIp = "";
	String title = "";
	Map<String, String> myMap = (Map<String, String>) session.getAttribute("Map");
	if (myMap != null) {
		userIp = myMap.get("userIp");
		if (userIp == null) {
			userIp = request.getRemoteAddr();
			//debug:
			System.out.println("Debug(null check): " + userIp);
		}
	}
	bean = (MyLoginBean) session.getAttribute("userBean");
	if (bean != null) {
		userID = bean.getUserName();
		if (userID != null) {
			//debug:
			System.out.println("Debug: " + userID);
		}
		String userPW = bean.getUserPw();
		if (userPW != null) {
			//debug:
			System.out.println("Debug: " + userPW);
		}
	} else {
		//debug:
		System.out.println("Debug: userBean is null!");
	}
	// Check if this is new comer on your web page.
	if (session.isNew()) {
		title = "Welcome!";
		response.sendRedirect("UserLogin.jsp");
	} else {
		title = "Welcome back again!";
// 		userID = (String) session.getAttribute(bean.getUserName());
// 		if (userID == null) {
// 			userID = new String(bean.getUserName());
// 			session.setAttribute(userIDKey, userID);
// 			userID = (String) session.getAttribute(userIDKey);
// 		}
		visitCount = (Integer) session.getAttribute(visitCountKey);
		if (visitCount == null) {
			visitCount = new Integer(0);
			session.setAttribute(visitCountKey, visitCount);
			visitCount = (Integer) session.getAttribute(visitCountKey);
		}
		//Debug:
		System.out.println("old session:");
		System.out.println(userIDKey);
		System.out.println(userID);
		System.out.println(visitCountKey);
		System.out.println(visitCount);

		visitCount = visitCount + 1;
		session.setAttribute(visitCountKey, visitCount);
	}
%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
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

<a href="AppMenu.jsp">Return to menu</a><br>

<center>
<h1>Session Tracking</h1>
<p><%=title%></p><br>
</center>
<table border="1" align="center">
<tr bgcolor="#949494">
   <th>Session info</th>
   <th>Value</th>
</tr>
<tr>
   <td>id</td>
   <td><% out.print(session.getId()); %></td>
</tr>
<tr>
   <td>Creation Time</td>
   <td><% out.print(createTime); %></td>
</tr>
<tr>
   <td>Time of Last Access</td>
   <td><% out.print(lastAccessTime); %></td>
</tr>
<tr>
   <td>IP Address of Last Access</td>
   <td><% out.print(userIp); %></td>
</tr>
<tr>
   <td>User ID</td>
   <td><% out.print(userID); %></td>
</tr>
<tr>
   <td>Number of visits</td>
   <td><% out.print(visitCount); %></td>
</tr>
</table>
</body>
</html>