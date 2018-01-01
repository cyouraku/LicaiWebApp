<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% response.sendRedirect("UserLogin.jsp"); %> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="${basePath}stylesheets/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index Page</title>
<script type="text/javascript">
function delayURL(url) {
   var delay=document.getElementById("time").innerHTML;
   //最后的innerHTML不能丢，否则delay为一个对象
   if(delay>0){
   		delay--;
   		document.getElementById("time").innerHTML=delay;
   }else{
   	window.top.location.href=url;
<%--    		<% response.sendRedirect("UserLogin.jsp"); %> --%>
   }
	setTimeout("delayURL('" + url + "')", 3000);
}
</script>
</head>
<body>


<div id = "welcome">
<p>欢迎使用理财应用!</p><br>
</div>

<div id = "redirect">
<span id="time" style="background: red">3</span>
<p>3秒后如果没有进入菜单页面，请点击下面的链接:</p><br>

<a href="UserLogin.jsp">请登录网站!</a><br>

<script type="text/javascript">
	delayURL("UserLogin.jsp")
</script>


</div>

</body>
</html>