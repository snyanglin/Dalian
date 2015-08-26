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
				<form id="xlcqueryForm">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
						<tr class="dialogTr">
							<td width="40%" class="dialogTd" align="right">所属分局：</td>
							<td width="60%" class="dialogTd"><input type="text" name="gxsxj" id ="gxsxj" class="easyui-combobox" style="width:130px;"
								data-options="valueField:'id',textField:'text',url:'<%=basePath %>gzjk/queryOrg',onSelect:function(rec){
				            	var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#gxpcs').combobox('reload', url);}" />
				            </td>
				        </tr>
				        <tr class="dialogTr">
							<td width="40%" class="dialogTd" align="right">下属派出所：</td>
							<td width="60%" class="dialogTd">
								<input type="text" id="gxpcs" name="gxpcs" class="easyui-combobox" style="width:130px;" data-options="valueField:'id',textField:'text',required:false"/>
							</td>
						</tr>
						
						
										
					<tr class="dialogTr">
						<td class="dialogTd" align="center" colspan="4">
								<hr>
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="xlcqueryButton()">查询</a>
								&nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 	iconCls="icon-reset" onclick="xlcresetButton()">重置</a>
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

//查询按钮
function xlcqueryButton(){
	// 新增查询条件 beign
	var gxsxj = $("#gxsxj").val(); //管辖市(县)局
	var gxpcs =  $("#gxpcs").val(); //管辖派出所
	// 新增查询条件 end
	var parm = "?gxsxj=" + gxsxj + "&gxpcs=" +  gxpcs;
	 window.parent.zdParm(parm, "xlc");
}

//重置按钮
function xlcresetButton(){
	$("#xlcqueryForm").form("reset");
	
}


</script>  

</html>