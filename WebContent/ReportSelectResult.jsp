<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%-- <%@ page import="com.costuary.bean.WebInputBean" %> --%>
<%@ page import="com.costuary.bean.LicaiBean" %>
<%@ page import="com.costuary.constant.SqlConstant" %>
<%@ page import="com.costuary.bean.WebInputBean" %>
<%-- <%@ page import="com.costuary.util.StringUtil" %> --%>
<%@ page import="com.costuary.util.JsonStrFactory" %>
<%@ page import="com.costuary.util.IJsonStrCreator" %>
<%
	String basePath = (String)session.getAttribute("basePath");
	String jQueryPath = (String)session.getAttribute("jQueryPath");
	WebInputBean inputBean = (WebInputBean) session.getAttribute("inputBean");
	String currencyId = inputBean.getCurrencyId();
	boolean flagOfJPY = false;
	if ("102".equals(currencyId)) {
		flagOfJPY = true;
	}
	String temp = (String) request.getAttribute("temp");
	int sumAmt = (int)request.getAttribute("sumAmt");
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
<script type="text/javascript">
window.returnValue=0
var jsonValData = ${jsonVal};
//debug
console.log(jsonValData);
$(function(){
  $('#dg').datagrid({
      data:  jsonValData
  });
});
</script>
</head>
<body>
<!-- jquery ui testing -->
	<div id="showReportResultArea" class="easyui-navpanel" style="position:relative;padding:20px">
        <header>
            <div class="m-toolbar">
                <div class="m-title" style="font-size: 20px">查询结果</div>
                <div class="m-left">
<!--                     <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="location.href='ReportSelectMenu.jsp'" style="width:60px">返回</a> -->
                   <form id="reportSelectMenu" action="ReportSelectMenu" method="get">
						<a href="javascript:void(0)" class="easyui-linkbutton" style="width:60px" onclick="$('#reportSelectMenu').submit()">返回</a>
					</form>
                </div>
                <div class="m-right">
					<a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="" style="width: 100px">Total:<%=sumAmt%>JPY</a>
				</div>
            </div>
        </header>
		<table id="dg" data-options="header:'#hh',singleSelect:true,border:false,fit:true,fitColumns:true,scrollbarSize:0" style="font-size: 16px">
        	<thead>
            	<tr>
	                <th data-options="field:'subCatCn',width:100,align:'center'" style="font-size: 16px">类别</th>
	                <th data-options="field:'sum',width:100,align:'center'" style="font-size: 16px">金额汇总</th>
	                <th data-options="field:'percent',width:100,align:'center'" style="font-size: 16px">百分比</th>
            	</tr>
        	</thead>
    	</table>
    </div>

</body>
</html>