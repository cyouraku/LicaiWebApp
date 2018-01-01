<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.json.*" %>
<%-- <%@ page import="com.costuary.bean.WebInputBean" %> --%>
<%@ page import="com.costuary.bean.LicaiBean" %>
<%@ page import="com.costuary.bean.WebInputBean" %>
<%@ page import="com.costuary.constant.SqlConstant" %>
<%-- <%@ page import="com.costuary.util.StringUtil" %> --%>
<%@ page import="com.costuary.util.JsonStrFactory" %>
<%@ page import="com.costuary.util.IJsonStrCreator" %>
<%
String basePath = (String)session.getAttribute("basePath");
String jQueryPath = (String)session.getAttribute("jQueryPath");
WebInputBean inputBean = (WebInputBean)session.getAttribute("inputBean");
String typeId = inputBean.getTypeId();
String currencyId = inputBean.getCurrencyId();
List<LicaiBean> beanList = (List<LicaiBean>)request.getAttribute("resultList");
String[] jsonValList;
StringBuilder jsonVal = new StringBuilder();
float sum = 0;
boolean flag = false;
JsonStrFactory factory = new JsonStrFactory();
//Get json creator for SelectResult
IJsonStrCreator creator = factory.creatJsonStrCreatorSelect();
if(beanList != null){
	flag = true;
	//get total amt
	for(LicaiBean bean : beanList){
		sum +=  bean.getAmt();
	}
	//set total amt to page context
	request.setAttribute("totalAmt", sum);
	//using StringBuilder to create json array object.
// 	jsonValList = StringUtil.createJsonStrList(beanList);
	jsonValList = creator.creatJsonStrList(beanList);
	int length = jsonValList.length;
	if(length >= 1){
		jsonVal.append("[");
		for(int i = 0;i < (length -1);i++){
			jsonVal.append(jsonValList[i] + ",");
		}
		jsonVal.append(jsonValList[length -1]);
		jsonVal.append("]");
	}else{
		jsonVal.append(creator.creatJsonStrNull());
	}
}
//set json array object to page context
request.setAttribute("jsonVal", jsonVal.toString());
String temp = (String)request.getAttribute("temp");
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
var jsonValData = ${jsonVal};
//debug
console.log(jsonValData);
$(function(){
    $('#dg').datagrid({
        data:  jsonValData
    });
});

// function onLoadSuccess() {
    //添加“合计”列
//     $('#dg').datagrid('appendRow', {
//         Saler: '<span class="subtotal">合计</span>',
//         TotalAmount: '<span class="subtotal">' + ${totalAmt} + '</span>',
//         TotalOrderMoney: '<span class="subtotal">' + compute("TotalOrderMoney") + '</span>',
//         TotalOrderScore: '<span class="subtotal">' + compute("TotalOrderScore") + '</span>',
//         TotalTrailCount: '<span class="subtotal">' + compute("TotalTrailCount") + '</span>',
//         Rate: '<span class="subtotal">' + ((compute("TotalOrderScore") / compute("TotalTrailCount")) * 100).toFixed(2) + '</span>'
//     });
// }

//指定列求和
// function compute(colName) {
//     var rows = $('#table').datagrid('getRows');
//     var total = 0;
//     for (var i = 0; i < rows.length; i++) {
//         total += parseFloat(rows[i][colName]);
//     }
//     return total;
// }
</script>
</head>
<body>

<!-- <a href="AppMenu.jsp">返回主菜单</a><br><br><br> -->
<!-- <div id = "welcomeArea"> -->
<!--  <table border = "0" align="center"> -->
<!--     <tr align = "left"> -->
<%--      <td><%=temp%></td> --%>
<!-- 	</tr> -->
<!--  </table> -->
<!-- </div> -->
<!-- <br> -->

<!-- <div id = "dataArea"> -->
<!-- 	<table border = "0" align="center"> -->
<!-- 		<tr><td align="center">序列号</td><td align="center">日期</td><td align="center">类别</td><td align="center">金额</td><td align="center">备注</td></tr> -->
<%-- <% --%>
<!-- // 	if (flag) { -->
<!-- // 		Iterator<LicaiBean> iter = beanList.iterator(); -->
<!-- // 		while (iter.hasNext()) { -->
<!-- // 			bean = iter.next(); -->
<!-- // 			sum += bean.getAmt(); -->
<!-- // 			//in case currency is JPY: -->
<!-- // 			if ("102".equals(currencyId)) { -->
<!-- // 				out.print("<tr><td align=\"center\">" + bean.getSeq() + "</td>" -->

<!-- // 						+ "<td align=\"center\">" + bean.getDate() + "</td>" -->

<!-- // 						+ "<td align=\"center\">" + SqlConstant.getSubCatCn(bean.getSubCatId()) + "</td>" -->

<!-- // 						+ "<td align=\"right\">" + (int) bean.getAmt() + "</td>" -->

<!-- // 						+ "<td align=\"center\">" + bean.getComment() + "</td>" + "</tr>"); -->
<!-- // 			} -->
<!-- // 		} -->
<!-- // 	} -->
<%-- %> --%>
<!-- 	</table> -->
<!-- </div> -->

<!--     <div id = "sumArea"> -->
<%--     <%if ("102".equals(currencyId)){ %> --%>
<%-- 	<p align="center">金额汇总：<%=(int)sum %>日元</p> --%>
<%-- 	<%}%> --%>
<!-- 	</div> -->

<!-- jquery ui testing -->
	<div id="showSelectResultArea" class="easyui-navpanel" style="position:relative;padding:20px">
        <header>
            <div class="m-toolbar">
                <div class="m-title" style="font-size: 20px">查询结果</div>
                <div class="m-left">
                    <a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="location.href='SelectMenu.jsp'" style="width:60px">返回</a>
                </div>
                <div class="m-right">
					<a href="javascript:void(0)" class="easyui-linkbutton" type="text" plain="true" outline="true" onclick="" style="width: 100px"> <%=temp%> </a>
				</div>
            </div>
        </header>

        <table id="dg" data-options="header:'#hh',singleSelect:true,border:false,fit:true,fitColumns:true,scrollbarSize:0" style="font-size: 16px">
        	<thead>
            	<tr>
	                <th data-options="field:'seqNo',width:80,align:'center'" style="font-size: 16px">序列</th>
	                <th data-options="field:'date',width:100,align:'center'" style="font-size: 16px">日期</th>
	                <th data-options="field:'subCatCn',width:80,align:'center'" style="font-size: 16px">类别</th>
	                <th data-options="field:'amt',width:80,align:'center'" style="font-size: 16px">金额</th>
	                <th data-options="field:'comment',width:80,align:'center'" style="font-size: 16px">备注</th>
            	</tr>
        	</thead>
    	</table>
    </div>



</body>
</html>