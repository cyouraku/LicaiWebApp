<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.costuary.bean.MyLoginBean" %>
<%-- <% response.sendRedirect("InsertExpense.jsp"); %> --%>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- <meta name="viewport" content="width=device-width, initial-scale=no"> -->
<title>家庭理财网络应用程序beta1.0 written by Tim Zhang</title>
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/mobile.css" />
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/icon.css" />
<!-- try to change theme by user selecting -->
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/material/easyui.css" />
<script type="text/javascript" src="${jQueryPath}/jquery.min.js"></script>
<script type="text/javascript" src="${jQueryPath}/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${jQueryPath}/jquery.easyui.mobile.js"></script>
<script type="text/javascript">
// 	function submitForm(){
// 		$('#costuaryMenu').form('submit');
// 	}
</script>
</head>
<body>

<!-- <a href="index.jsp">Logout(返回首页)</a><br> -->

<%
MyLoginBean bean = (MyLoginBean)session.getAttribute("userBean");
String userNm = bean.getUserName();
Map<String,String> myMap =(Map<String,String>)session.getAttribute("Map");
String userIp = myMap.get("userIp");
%>


<!-- <div id = "showUserInfo"> -->
<%-- <p>欢迎! <%=userNm %> </p> --%>
<%-- <% if(!"".equals(userIp)|| userIp != null) {%> --%>
<%--     <p>您的IP地址是： <%=userIp %></p><br> --%>
<%-- <% } else {%> --%>
<!-- 	<p>没有您的IP地址信息.</p> -->
<%-- <% }%> --%>
<!-- </div> -->

<div class="easyui-navpanel" >
        <header>
            <div class="m-toolbar">
                <span class="m-title" style="font-size: 20px">功能菜单</span>
            </div>
        </header>
<!--         <ul class="m-list"> -->
        <div class="m-buttongroup" style="text-align: center;width:100%">
                <div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list published on 2017-08-20 -->
					<form id="costuaryMenu" action="CostuaryMenu" method="get">
					 	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:true" style="width:100%;height:40px" onclick="$('#costuaryMenu').submit()"><span style="font-size: 16px">日元消费记录增加</span></a>
					</form>
                </div>
                <div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list published on 2017-08-21 -->
					<form id="selectMenu" action="SelectMenu" method="get">
<!-- 						<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%;height:40px" onclick="$('#selectMenu').submit()"><span style="font-size: 16px">查询</span></a> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#selectMenu').submit()"><span style="font-size: 16px">日元消费记录查询</span></a>
					</form>
                </div>
                <div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list published on 2017-08-21-->
					<form id="reportSelectMenu" action="ReportSelectMenu" method="get">
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#reportSelectMenu').submit()"><span style="font-size: 16px">日元消费记录报表</span></a>
					</form>
                </div>
                <div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list published on 2017-08-21-->
<!-- 					<form id="reportSelectMenu" action="ReportSelectMenu" method="get"> -->
						<a href="chat2.jsp" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" ><span style="font-size: 16px">WebSocket聊天室</span></a>
<!-- 					</form> -->
                </div>
<!--             <li style="font-size: 16px;height:40px">日元消费记录修改 -->
<!--                 <div class="m-center">-->
<!--                 	To do list -->
<!-- 					<form id="updateMenu" action="UpdateMenu" method="get"> -->
<!-- 						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#updateMenu').submit()"><span style="font-size: 16px">修改</span></a> -->
<!-- 					</form> -->
<!--                 </div> -->
<!--             </li> -->
<!--             <li style="font-size: 16px;height:40px">日元消费记录删除 -->
<!--                 <div class="m-center"> -->
<!--                 	To do list -->
<!-- 					<form id="deleteMenu" action="DeleteMenu" method="get"> -->
<!-- 						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#deleteMenu').submit()"><span style="font-size: 16px">删除</span></a> -->
<!-- 					</form> -->
<!--                 </div> -->
<!--             </li> -->
			<% if("Tim.Zhang".equals(userNm)) {%>
               <div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list -->
					<form id="updateMenu" action="UpdateMenu" method="get">
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#updateMenu').submit()"><span style="font-size: 16px">日元消费记录修改</span></a>
					</form>
                </div>
                <div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list -->
					<form id="deleteMenu" action="DeleteMenu" method="get">
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#deleteMenu').submit()"><span style="font-size: 16px">日元消费记录删除</span></a>
					</form>
                </div>
            	<div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list -->
					<form id="serverHealthInfo" action="ServerHealthInfo" method="get">
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#serverHealthInfo').submit()"><span style="font-size: 16px">服务器温度记录查询</span></a>
					</form>
                </div>
            	<div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list -->
					<form id="sessionTrackGet" action="SessionTrack" method="get">
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#sessionTrackGet').submit()"><span style="font-size: 16px">Get Session记录查询</span></a>
					</form>
                </div>
                <div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list -->
					<form id="sessionTrackPost" action="SessionTrack" method="post">
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="$('#sessionTrackPost').submit()"><span style="font-size: 16px">Post Session记录查询/span></a>
					</form>
                </div>
                <div style="padding:0 20px; text-align: center; margin-top: 30px">
                	<!-- To do list -->
					<form id="sessionTrackPost" action="SessionTrack" method="post">
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:false" style="width:100%;height:40px" onclick="alert(document.cookie)"><span style="font-size: 16px">XSS攻击测试</span></a>
					</form>
                </div>
<% }%>
        </div>

        	<div style="padding:0 20px; text-align: center; margin-top: 30px">
				<a href="index.jsp" class="easyui-linkbutton" plain="true" outline="true" style="width:100%;height:40px" onclick="clearForm()"><span style="font-size: 16px">重新登录</span></a>
			</div>
    </div>




</body>
</html>