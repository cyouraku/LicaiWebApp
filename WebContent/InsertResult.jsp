<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.costuary.bean.WebInputBean" %>
<%@ page import="com.costuary.bean.LicaiBean" %>
<%@ page import="com.costuary.util.StringUtil" %>
<%@ page import="com.costuary.util.BeanTransUtil" %>
<%@ page import="com.costuary.util.JsonStrFactory" %>
<%@ page import="com.costuary.util.IJsonStrCreator" %>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
String insertResult = (String)request.getAttribute("result");
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
<script type="text/javascript">
window.returnValue=0
var data = ${jsonVal};
//debug
console.log(data);
$(function(){
  $('#dg').datagrid({
      data: data
  });
});
</script>
</head>
<body>
	<div id="selectArea" class="easyui-navpanel"
		style="position: relative; padding: 20px">
		<header>
			<div class="m-toolbar">
<!-- 				<div class="m-toolbar"> -->
<!--                 	<span class="m-title" style="font-size: 20px">增加结果</span> -->
<!--                 </div> -->
                <div class="m-title" style="font-size: 20px">增加结果</div>
				<div class="m-left">
					<a href="javascript:void(0)" class="easyui-linkbutton" type="text"
						plain="true" outline="true" onclick="location.href='AppMenu.jsp'"
						style="width: 60px;font-size: 18px">返回</a>
				</div>
				<div class="m-right">
					<a href="javascript:void(0)" class="easyui-linkbutton" type="text"
						plain="true" outline="true"
						onclick="" style="width: 100px;font-size: 18px"> <%=insertResult%> </a>
				</div>
			</div>
		</header>
        <table id="dg" data-options="header:'#hh',singleSelect:true,border:false,fit:true,fitColumns:true,scrollbarSize:0" style="font-size: 16px">
        	<thead>
            	<tr>
	                <th data-options="field:'date',width:100,align:'center'" style="font-size: 16px">日期</th>
	                <th data-options="field:'subCatCn',width:80,align:'center'" style="font-size: 16px">类型</th>
	                <th data-options="field:'subCatId',width:80,align:'center'" style="font-size: 16px">类别</th>
	                <th data-options="field:'amt',width:80,align:'center'" style="font-size: 16px">金额</th>
	                <th data-options="field:'currencyId',width:80,align:'center'" style="font-size: 16px">货币</th>
	                <th data-options="field:'comment',width:80,align:'center'" style="font-size: 16px">备注</th>
            	</tr>
        	</thead>
		</table>

	</div>

</body>
</html>