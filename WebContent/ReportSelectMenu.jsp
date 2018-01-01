<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.costuary.bean.WebInputBean" %>
<%@ page import="com.costuary.constant.SqlConstant" %>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
String typeId = (String) request.getAttribute("typeId");
String currencyId = (String) request.getAttribute("currencyId");
String currencyNm = SqlConstant.CurrencyEn.getName(Integer.parseInt(currencyId));
WebInputBean inputBean;
inputBean = new WebInputBean();
inputBean.setTypeId(typeId);
inputBean.setCurrencyId(currencyId);
session.setAttribute("inputBean", inputBean);
%>
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
<script type="text/javascript">
window.returnValue=0
</script>
</head>
<body>
	 <div id="selectArea" class="easyui-navpanel" style="position:relative;padding:20px">
        <header>
            <div class="m-toolbar">
                <div class="m-title" style="font-size:20px">查询报表菜单</div>
                <div class="m-left">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="location.href='AppMenu.jsp'" style="width:60px;font-size:18px">返回</a>
                </div>
                <div class="m-right">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="" style="width:80px;font-size:18px">货币：<%=currencyNm%></a>
                </div>
            </div>
        </header>
        <ul class="m-list">
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#annual').submit()">年度报表</a>
            	  	<form id="annual" action="ReportSelectMenu" method="post">
						<input type="hidden" name="reportType" value = "0">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#quater').submit()"> 季度报表</a>
            	  	<form id="quater" action="ReportSelectMenu" method="post">
						<input type="hidden" name="reportType" value = "1">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#month').submit()">每月报表</a>
            	  	<form id="month" action="ReportSelectMenu" method="post">
						<input type="hidden" name="reportType" value = "2">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#week').submit()"> 每周报表</a>
            	  	<form id="week" action="ReportSelectMenu" method="post">
						<input type="hidden" name="reportType" value = "3">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#day').submit()"> 每日报表</a>
            	  	<form id="day" action="ReportSelectMenu" method="post">
						<input type="hidden" name="reportType" value = "4">
					</form>
            </li>

        </ul>
    </div>

<!-- <div id = "costuaryTbl"> -->
<!-- 	<table> -->
<!-- 	 <tr> -->
<!-- 	  <td> -->
<!-- 	    年度报表查询 -->
<!-- 	  </td> -->
<!-- 	  <td> -->
<!-- 	  	<form action="ReportSelectMenu" method="post"> -->
<!-- 	  		<input type="hidden" name="reportType" value = "0"> -->
<!-- 			<input type="submit" value="查询"> -->
<!-- 		</form> -->
<!-- 	  </td> -->
<!-- 	 </tr> -->
<!-- 	 <tr></tr><tr></tr><tr></tr><tr></tr> -->
<!-- 	 <tr> -->
<!-- 	  <td> -->
<!-- 	    季度报表查询 -->
<!-- 	  </td> -->
<!-- 	  <td> -->
<!-- 	  	<form action="ReportSelectMenu" method="post"> -->
<!-- 	  		<input type="hidden" name="reportType" value = "1"> -->
<!-- 			<input type="submit" value="查询"> -->
<!-- 		</form> -->
<!-- 	  </td> -->
<!-- 	 <tr></tr><tr></tr><tr></tr><tr></tr> -->

<!-- 	 <tr> -->
<!-- 	  <td> -->
<!-- 	    每月报表查询 -->
<!-- 	  </td> -->
<!-- 	  <td> -->
<!-- 	  	<form action="ReportSelectMenu" method="post"> -->
<!-- 	  		<input type="hidden" name="reportType" value = "2"> -->
<!-- 			<input type="submit" value="查询"> -->
<!-- 		</form> -->
<!-- 	  </td> -->
<!-- 	 </tr> -->
<!-- 	 <tr></tr><tr></tr><tr></tr><tr></tr> -->
<!-- 	 <tr> -->
<!-- 	  <td> -->
<!-- 	    每周报表查询 -->
<!-- 	  </td> -->
<!-- 	  <td> -->
<!-- 	  	<form action="ReportSelectMenu" method="post"> -->
<!-- 	  		<input type="hidden" name="reportType" value = "3"> -->
<!-- 			<input type="submit" value="查询"> -->
<!-- 		</form> -->
<!-- 	  </td> -->
<!-- 	 </tr> -->
<!-- 	 <tr></tr><tr></tr><tr></tr><tr></tr> -->
<!-- 	</table> -->
<!-- </div> -->


</body>
</html>