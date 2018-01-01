<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.costuary.bean.WebInputBean" %>
<%@ page import="com.costuary.constant.SqlConstant" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String jQueryPath = basePath + "jquery-easyui-1.5.2";
String webServicePath = "ws://" +  request.getServerName()+":"+request.getServerPort()+path + "/chat";
// request.setAttribute("basePath", basePath);
// request.setAttribute("jQueryPath", jQueryPath);
session.setAttribute("basePath", basePath);
session.setAttribute("jQueryPath", jQueryPath);
session.setAttribute("wsPath",webServicePath);
%>
<!-- <!doctype html> -->
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
<%
		Map<String,String> map = new HashMap<String,String>();
		String userIp = request.getRemoteAddr();
		String sessionId = session.getId();
		map.put("userIp", userIp);
		map.put("sessionId", sessionId);
		session.setAttribute("Map", map);
%>
<script type="text/javascript">
// 	function submitForm() {
// 		$('#userLogin').form('submit');
// 	}
	function clearForm() {
		$('#userLogin').form('clear');
	}
</script>
</head>
<body>
    <div class="easyui-navpanel">
        <header>
            <div class="m-toolbar">
                <span class="m-title">欢迎使用家庭理财网页应用！</span>
            </div>
        </header>
        <div style="margin:20px auto;width:100px;height:100px;border-radius:100px;overflow:hidden">
            <img src="${basePath}/images/tomcat.ico" style="margin:0;width:100%;height:100%;">
        </div>
        <div style="padding:0 20px">
            <form id="userLogin" action = "UserLogin" method="post">
				<div style="margin-bottom: 10px">
					<input id = "user" name = "USER_NM" class="easyui-validatebox"
						data-options="prompt:'请输入用户名',iconCls:'icon-man'"
						style="width: 100%; height: 38px">
				</div>
				<div>
					<input id = "pwd" name = "USER_PW" class="easyui-passwordbox"
						data-options="prompt:'请输入密码'"
						style="width: 100%; height: 38px">
				</div>
				<div style="text-align: center; margin-top: 30px">
<!-- 				submitForm() data post to servlet but failed to redirect to AppMenu.jsp but still back to UserLogin.jsp-->
<!-- 					<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%;height:40px" onclick="submitForm()"><span style="font-size: 16px">登录系统</span></a> -->
<!-- 				$('#userLogin').submit() works well-->
					<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%;height:40px" onclick="$('#userLogin').submit()"><span style="font-size: 16px">登录系统</span></a>
				</div>
			    <div style="text-align: center; margin-top: 30px">
					<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%;height:40px" onclick="clearForm()"><span style="font-size: 16px">重新输入</span></a>
				</div>
			</form>
            <div style="text-align:center;margin-top:30px">
                <a href="#" class="easyui-linkbutton" plain="true" outline="true" style="width:100px;height:35px"><span style="font-size:16px">注册</span></a>
            </div>
            <div style="text-align:center;margin-top:30px">
				<%	String alertInfo = (String) request.getAttribute("alertInfo");%>
				<%	if ("".equals(alertInfo) || alertInfo == null) { %>
						<a plain="true" outline="true" style="width:100px;height:35px;font-size:16px">您的IP地址是：<%=userIp%></a>
<%-- 						<a plain="true" outline="true" style="width:100px;height:35px;font-size:16px">basePath：<%=basePath%></a> --%>
<%-- 						<a plain="true" outline="true" style="width:100px;height:35px;font-size:16px">path：<%=path%></a> --%>
<%-- 						<a plain="true" outline="true" style="width:100px;height:35px;font-size:16px">WebServicePath：<%=webServicePath%></a> --%>
				<%	} else { %>
						<a plain="true" outline="true" style="width:100px;height:35px;font-size:16px"><%=alertInfo%></a>
				<%	} %>
			</div>
        </div>
    </div>
</body>
</html>