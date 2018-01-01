<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.costuary.bean.WebInputBean" %>
<%@ page import="com.costuary.constant.SqlConstant" %>
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

function selectTest(obj){
	//Debug:
    alert("Option中的中文："+obj.options.value);
    request.Parameter(object.value);
}

function openit(target){
    var text = $(target).text();
    $('#p2-title').html(text);
//     $('#subCatid').find("option[text='"+ text + "']").attr("selected",true);//$(".selector").find("option[text='pxx']").attr("selected",true);
    $.mobile.go('#p2');
}
</script>
</head>
<body>
	 <div id="selectArea" class="easyui-navpanel" style="position:relative;padding:20px">
        <header>
            <div class="m-toolbar">
                <div class="m-title" style="font-size:20px">增加菜单</div>
                <div class="m-left">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="location.href='AppMenu.jsp'" style="width:60px;font-size:18px">返回</a>
                </div>
                <div class="m-right">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="$('#selectMenu').form('reset')" style="width:60px;font-size:18px">重置</a>
                </div>
            </div>
        </header>
<!--         <div id="commonSubCatSelectArea" style="padding:0 20px"> -->
<!--             <form id = "selectMenu" action="CostuaryMenu" method="post"> -->
<!--             	<div style="margin-bottom:10px"> -->
<!--             	</div> -->

<!--         	</form> -->
<!--         </div> -->

<!-- 		<div id="anySubCatSelectArea" style="padding:0 20px"> -->
<!-- 			<form id="selectMenu" action="CostuaryMenu" method="post"> -->
<!-- 			 	<div style="margin-bottom:10px"> -->
<!-- 					<p>选择其他支出分类：</p><br> -->
<!-- 				</div> -->
<!-- 				<div style="margin-bottom:10px"> -->
<!-- 					<select id="subCatId" name = "SUBCAT_ID" class="easyui-combobox" label="支付类别:" style="width:200px;" onchange="selectTest(this)"> -->
<%-- 								<% --%>
<!-- // 									for (int i = 100; i < 123; i++) { -->
<!-- // 										out.print("<option value = " + i + ">" + SqlConstant.getSubCatCn(i) + "</option>\n"); -->
<!-- // 									} -->
<%-- 								%> --%>
<!-- 								<option value="" selected="selected">未选择</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 		    	<div style="margin-bottom:10px"> -->
<!--                 	<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%;height:40px" onclick="$('#selectMenu').submit()" ><span style="font-size: 16px">提交</span></a> -->
<!--             	</div> -->
<!-- 			</form> -->
<!-- 		</div> -->


<!--         <ul class="m-list"> -->
<!--             <li><a href="javascript:void(0)" style="font-size: 16px" onclick="openit(this)">食品</a></li> -->
<!--             <li><a href="javascript:void(0)" style="font-size: 16px" onclick="openit(this)">饮品</a></li> -->
<!--             <li><a href="javascript:void(0)" style="font-size: 16px" onclick="openit(this)">交通</a></li> -->
<!--             <li><a href="javascript:void(0)" style="font-size: 16px" onclick="openit(this)">水电煤</a></li> -->
<!--             <li><a href="javascript:void(0)" style="font-size: 16px" onclick="openit(this)">杂物</a></li> -->
<!--             <li><a href="javascript:void(0)" style="font-size: 16px" onclick="openit(this)">保险</a></li> -->
<!--             <li><a href="javascript:void(0)" style="font-size: 16px" onclick="openit(this)">转账</a></li> -->
<!--             <li><a href="javascript:void(0)" style="font-size: 16px" onclick="openit(this)">其他请选择</a></li> -->
 		<ul class="m-list">
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#food').submit()">食品</a>
            	  	<form id="food" action="CostuaryMenu" method="post">
						<input type="hidden" name="SUBCAT_ID" value = "101">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#drinks').submit()">饮品</a>
            	  	<form id="drinks" action="CostuaryMenu" method="post">
						<input type="hidden" name="SUBCAT_ID" value = "102">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#tansport').submit()">交通</a>
            	  	<form id="tansport" action="CostuaryMenu" method="post">
						<input type="hidden" name="SUBCAT_ID" value = "109">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#utilities').submit()">水电煤</a>
            	  	<form id="utilities" action="CostuaryMenu" method="post">
						<input type="hidden" name="SUBCAT_ID" value = "121">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#grocery').submit()">杂物</a>
            	  	<form id="grocery" action="CostuaryMenu" method="post">
						<input type="hidden" name="SUBCAT_ID" value = "103">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="$('#insurance').submit()">保险</a>
            	  	<form id="insurance" action="CostuaryMenu" method="post">
						<input type="hidden" name="SUBCAT_ID" value = "120">
					</form>
            </li>
            <li><a href="javascript:void(0)" style="font-size:16px" onclick="openit(this)">请选择类别</a>
            	  	<form id="tansport" action="CostuaryMenu" method="post">
						<input type="hidden" name="SUBCAT_ID" value = "109">
					</form>
            </li>
        </ul>

    </div>
    <div id="p2" class="easyui-navpanel" style="position:relative;padding:20px">
        <header>
            <div class="m-toolbar">
                <span id="p2-title" class="m-title" style="font-size:20px"></span>
                <div class="m-left">
                    <a href="javascript:void(0)" class="easyui-linkbutton m-back" plain="true" outline="true" style="width:50px;font-size:18px" onclick="$.mobile.back()">返回</a>
                </div>
            </div>
        </header>
			<form id = "anySubCatId" action="CostuaryMenu" method="post">
            <div style="margin-bottom:10px">
                		<select id="subCatId" name = "SUBCAT_ID" class="easyui-combobox" label="支付类别:" style="width:100%;height:40px;font-size:16px" onchange="selectTest(this)">
  							<%
  								for(int i = 100;i < 123;i++){
  									out.print("<option style=\"font-size: 16px\" value = " + i + ">" + SqlConstant.getSubCatCn(i) + "</option>\n");
  								}
 							%>
  							<option value="" selected="selected" style="font-size:16px">未选择 </option>
						</select>
            </div>
            <div style="margin-bottom:10px">
                <a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%;height:40px" onclick="$('#anySubCatId').submit()" ><span style="font-size:16px">提交</span></a>
            </div>
        	</form>
    </div>







</body>
</html>