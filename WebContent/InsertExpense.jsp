<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.costuary.bean.WebInputBean" %>
<%@ page import="com.costuary.constant.SqlConstant" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
WebInputBean inputBean = (WebInputBean)session.getAttribute("inputBean");
// int subCatId = Integer.parseInt(inputBean.getSubcatId());
//  String subCatCn = SqlConstant.getSubCatCn(subCatId);
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
// $(document).ready.(function(){
// 	$("#date_Input").easyui-calendar();
// 	$('#dateInput').easyui-calendar('setValue','2017-08-18');
// });

//get date string on select
$('#dd').datebox({
	onSelect:function(date){
		var y = date.getFullYear();
		var m = date.getMonth() +1;
		var d = date.getDate();
		if(m < 10){
			m = '0' + m
		}
		alert("date selected：" + y + "-" + m + "-" + d);
		return  y + "-" + m + "-" + d;
	}
});

//get default date of today
// $.fn.datebox.defaults.formatter = function(date){
// 	var y = date.getFullYear();
// 	var m = date.getMonth() + 1;
// 	var d = date.getDate();
// 	if(m < 10){
// 		m = '0' + m
// 	}
// 	return y + '-' + m + '-' + d;
// }
</script>
</head>
<body>

<!-- <a href="CostuaryMenu.jsp">返回支出类别选择菜单</a><br><br><br> -->
<!-- <div id = "temp"> -->
<%--  <p>增加<%=subCatCn %>项目类别的支出</p><br> --%>
<!-- </div> -->

	 <div id="selectArea" class="easyui-navpanel" style="position:relative;padding:20px">
        <header>
            <div class="m-toolbar">
                <div class="m-title" style="font-size: 20px">增加记录</div>
                <div class="m-left">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="location.href='AppMenu.jsp'" style="width:60px;font-size:18px">返回</a>
                </div>
                <div class="m-right">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="$('#insertMenu').form('reset')" style="width:60px;font-size:18px">重置</a>
                </div>
            </div>
        </header>
			<form id = "insertMenu" action="InsertExpense" method="post">
            	<div style="margin-bottom:10px">
                	<input id="dd" name="DATE" class="easyui-datebox" required="required" label="支付日期:" prompt="不可为空" style="width:100%;height:40px;font-size: 16px" data-options="editable:false,panelWidth:220,panelHeight:240,iconWidth:30">
            	</div>
            	<div style="margin-bottom:10px">
            		<input id="amt" type="text" name="AMT" class="easyui-numberbox" label="支付金额:" prompt="不可为空" style="width:100%;height:40px;font-size:16px">
            	</div>
            	<div style="margin-bottom:10px">
                	<input id="comment" type="text" name="COMMENT"class="easyui-textbox" label="支付备注:" prompt="可为空" style="width:100%;height:40px;font-size:16px"><!-- if class = "easyui-numberbox" could only post number data-->
            	</div>
            	<div style="margin-bottom:10px">
                	<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%;height:40px;font-size: 16px" onclick="$('#insertMenu').submit()" ><span style="font-size:16px">提交</span></a>
            	</div>
        	</form>
    </div>


</body>
</html>