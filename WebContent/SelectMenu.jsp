<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.costuary.bean.WebInputBean" %>
<%@ page import="com.costuary.constant.SqlConstant" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
String typeId = (String) request.getAttribute("typeId");
String currencyId = (String) request.getAttribute("currencyId");
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
//get date string on select for start date
$('#fr').datebox({
	onSelect:function(date){
		var y = date.getFullYear();
		var m = date.getMonth() +1;
		var d = date.getDate();
		if(m < 10){
			m = '0' + m
		}
		return  y + "-" + m + "-" + d;
	}
});

//get date string on select for end date
$('#to').datebox({
	onSelect:function(date){
		var y = date.getFullYear();
		var m = date.getMonth() +1;
		var d = date.getDate();
		if(m < 10){
			m = '0' + m
		}
		return  y + "-" + m + "-" + d;
	}
});


function selectTest(obj){
	//Debug:
//     alert("Option中的中文："+obj.options.value);
    request.Parameter(object.value);
}

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

// function clearForm() {
// 	$('#selectMenu').form('clear');
// }

// function resetForm() {
// 	$('#selectMenu').form('reset');
// }
</script>
</head>
<body>
	<div id="selectArea" class="easyui-navpanel" style="position:relative;padding:20px">

        <header>
                <div class="m-toolbar">
                	<span class="m-title" style="font-size: 20px">查询菜单</span>
                </div>
                <div class="m-left">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="location.href='AppMenu.jsp'" style="width:60px;font-size:18px">返回</a>
                </div>
                <div class="m-right">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="$('#insertMenu').form('reset')" style="width:60px;font-size:18px">重置</a>
                </div>
        </header>

        <form id = "selectMenu" action="SelectMenu" method="post">
            <div style="margin-bottom:10px">
                <input id="fr" name="frDate" class="easyui-datebox" required="required" label="开始日期:" prompt="不可为空" style="width:100%;height:40px;font-size:16px" data-options="editable:false,panelWidth:220,panelHeight:240,iconWidth:30">
            </div>
            <div style="margin-bottom:10px">
                <input id="to" name="toDate" class="easyui-datebox" label="结束日期:" prompt="可为空" style="width:100%;height:40px;font-size:16px" data-options="editable:false,panelWidth:220,panelHeight:240,iconWidth:30">
            </div>
            <div style="margin-bottom:10px">
                		<select id="subCatId" name = "subCatId" class="easyui-combobox" label="支付类别:" style="width:100%;height:40px;font-size:16px" onchange="selectTest(this)">
  							<%
  								for(int i = 100;i < 123;i++){
  									out.print("<option style=\"font-size: 16px\" value = " + i + ">" + SqlConstant.getSubCatCn(i) + "</option>\n");
  								}
  							%>
  							<option value="" selected="selected" style="font-size:16px">未选择 </option>
						</select>
            </div>
            <div style="margin-bottom:10px">
                <input id="cmt" type="text" name="comment"class="easyui-textbox" label="支付备注:" prompt="可为空" style="width:100%;height:40px;font-size:16px">
            </div>
            <div style="margin-bottom:10px">
                <a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%;height:40px" onclick="$('#selectMenu').submit()" ><span style="font-size: 16px">提交</span></a>
            </div>
        </form>


    </div>

</body>


</html>