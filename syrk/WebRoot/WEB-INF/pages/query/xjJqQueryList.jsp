<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}

	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	
</style>
<script type="text/javascript">
  var markerArr = new Array();
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
				<div id="datagridToolbar" style="padding:0px;height:auto">
				<form id="queryForm">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
				        <tr class="dialogTr">
					        <td width="10%" nowrap="nowrap" align="right">接警日期起：</td>
							<td width="20%">
								<input type="text" name="fqsj" id="fqsj" class="easyui-validatebox"  style="width:130px" 
								 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'%y-%M-%d'})" data-options="required:false,tipPosition:'left',
								 	validType:['date[\'yyyy-MM-dd\']']" style="" />
						</tr>
						<tr class="dialogTr">
							<td width="10%" nowrap="nowrap" align="right">接警日期止：</td>
							<td width="20%">
								<input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width:130px" 
								 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'%y-%M-%d'})" data-options="required:false,tipPosition:'left',
								 	validType:['date[\'yyyy-MM-dd\']']" style="" />
							</td>
						</tr>
				        <tr class="dialogTr">
						    	<td width="40%" class="dialogTd" align="right">出警方式：</td>
						    	<td width="60%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="cjfs" name="cjfs" style="width:130px;" 
									data-options="url: contextPath + '/common/dict/DL_D_ZDRYGLLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>
						</tr>
						<tr class="dialogTr">
						    	<td width="40%" class="dialogTd" align="right">警情类别：</td>
						    	<td width="60%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="jqlb" name="jqlb" style="width:130px;" 
									data-options="url: contextPath + '/common/dict/DL_D_ZDRYGLLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>
						</tr>
						<tr class="dialogTr">
							    <td width="40%" class="dialogTd" align="right">简要警情：</td>
						    	<td width="60%" class="dialogTd"><input type="text" name="jyjq" id ="jyjq" style="width:130px;" class="easyui-validatebox" 
						    		data-options="required:false,validType:'maxLength[20]'"   /></td>
									
					   	</tr>
					<tr class="dialogTr">
						<td class="dialogTd" align="center" colspan="4">
								<hr>
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="queryButton()">查询</a>
								 &nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 	iconCls="icon-reset" onclick="resetButton()">重置</a>
								&nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 	iconCls="icon-reload" onclick="clearButton()">清除</a>
					</td>
				</tr>					
				</table>
				</form>
				</div>
			</div>
        </div>
    </div>   
    
    <input type="hidden" id ="zbz" value="">
    <input type="hidden" id ="type" value="">
    <input type="hidden" id ="mapRadius" value="">


</body>
<script type="text/javascript">

$(function(){
	var date = new Date()
	var y = date.getFullYear();
	var m = date.getMonth()+1+'';
	if(m.length != 2){
		m = '0'+m;
	}
	var d = date.getDate()+'';
	if(d.length != 2){
		d = '0'+d;
	}
	var last = y + "-" + m + "-" + d;
	document.getElementById("fqsj").value = last;
	document.getElementById("jssj").value = last;
});

//查询按钮
function queryButton(){
	clearButton();
	var jyjq = document.getElementById("jyjq").value;
	var cjfs = document.getElementById("cjfs").value;
	var jqlb = document.getElementById("jqlb").value;
	var fqsj = document.getElementById("fqsj").value;
	var jssj = document.getElementById("jssj").value;
	
	jyjq= $.trim(jyjq);
	var parm = "?jyjq=" + jyjq + "&cjfs=" + cjfs + "&fqsj=" + fqsj + "&jssj=" + jssj + "&jqlb=" + jqlb;
	//alert(parm)
	window.parent.zdParm(parm, "jq");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}

function clearButton(){
	window.parent.zdParm("", "jq_clear");
}

</script>  

</html>