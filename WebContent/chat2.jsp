<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.costuary.bean.MyLoginBean" %>
<%-- <% response.sendRedirect("InsertExpense.jsp"); %> --%>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
String wsPath = (String)session.getAttribute("wsPath");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Basic Layout - jQuery EasyUI Mobile Demo</title>
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/mobile.css" />
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/icon.css" />
<!-- try to change theme by user selecting -->
<link type="text/css" rel="stylesheet"href="${jQueryPath}/themes/material/easyui.css" />
<script type="text/javascript" src="${jQueryPath}/jquery.min.js"></script>
<script type="text/javascript" src="${jQueryPath}/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${jQueryPath}/jquery.easyui.mobile.js"></script>
<script type="text/javascript">
var websocket = null;
//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
	//测试结果：在远程服务器上仅台式机电脑上的chrome浏览器支持WebSocket聊天室
// 	websocket = new WebSocket("ws://localhost:8080/licai/chat");
	websocket = new WebSocket("${wsPath}");
} else {
	alert('The current browser does not support websocket')
}
//returen error msg if connectiong error
websocket.onerror = function() {
	setMessageInnerHTML("WebSocket Connecting Error!");
};
//echo when connection success
websocket.onopen = function() {
	setMessageInnerHTML("WebSocket Connecting Success!");
}
//function to get msg
websocket.onmessage = function(event) {
	setMessageInnerHTML(event.data);
}
//function to close websocket
websocket.onclose = function() {
	setMessageInnerHTML("WebSocket Connecting Closed!");
}
//Close websocket when window closed, in order to prevent server error.
window.onbeforeunload = function() {
	closeWebSocket();
}

//output msg on web page
function setMessageInnerHTML(innerHTML) {
	document.getElementById('message').innerHTML += innerHTML + '<br/>';
}

//close websocket connecting
function closeWebSocket() {
	websocket.close();
}
//semd msg
function send() {
	var message = document.getElementById('text').value;
	websocket.send(message);
}
</script>
</head>
<body>
    <div class="easyui-navpanel">
        <header>
            <div class="m-toolbar">
                <div class="m-title">聊天室</div>
                <div class="m-left">
                    <a href="javascript:void(0)" class="easyui-linkbutton m-back" plain="true" outline="true" onclick="location.href='AppMenu.jsp'">返回</a>
                </div>
                <div class="m-right">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" outline="true">Search</a>
                </div>
            </div>
        </header>
        <div id="message"></div>
        <footer style="padding:2px 3px">
<!--         <input class="easyui-textbox" style="width:100%;height:32px;" data-options="prompt:'Type something here',buttonText:'<span style=\'padding:0 15px\'>Send</span>'"> -->
<!--             <input class="easyui-textbox" style="width:100%;height:32px;" data-options="prompt:'Type something here',buttonText:'<span style=\'padding:0 15px\'>Send</span>'"> -->
            <input id="text" type="text" name="COMMENT"class="easyui-textbox" prompt="type something here" style="width:80%;height:40px;font-size:16px;padding:5px"><button class="easyui-linkbutton" style="width:20%;height:40px" onclick="send()">Send</button>
        </footer>
    </div>
</body>
</html>