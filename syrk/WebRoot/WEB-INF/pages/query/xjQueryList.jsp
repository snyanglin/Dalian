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
							<td width="40%" class="dialogTd" align="right">管辖分局：</td>
							<td width="60%" class="dialogTd"><input type="text" name="gxsxj" id ="gxsxj" class="easyui-combobox" style="width:130px;"
								data-options="valueField:'id',textField:'text',url:'<%=basePath %>gzjk/queryOrg',onSelect:function(rec){
				            	var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#gxpcs').combobox('reload', url);}" />
				            </td>
				        </tr>
				        <tr class="dialogTr">
							<td width="40%" class="dialogTd" align="right">管辖派出所：</td>
							<td width="60%" class="dialogTd">
								<input type="text" id="gxpcs" name="gxpcs" class="easyui-combobox" style="width:130px;" data-options="valueField:'id',textField:'text',required:false"/>
							</td>
						</tr>
						<tr class="dialogTr">
								<td width="40%" class="dialogTd" align="right">管辖行政区划：</td>
								<td width="60%" class="dialogTd" colspan="3">
									<input type="text" name="gxxzqh" id="gxxzqh" class="easyui-combobox" style="width:130px;" 
											             data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',
									                                  method:'get',valueField:'id',textField:'text',selectOnNavigation:false" />
								</td>
								</td>
						</tr>
				        <tr class="dialogTr">
						    	<td width="40%" class="dialogTd" align="right">重点人员类型：</td>
						    	<td width="60%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="zdrylxdm" name="zdrylxdm" style="width:130px;" 
									data-options="url: contextPath + '/common/dict/DL_D_ZDRYGLLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>
						</tr>
						<tr class="dialogTr">
							    <td width="40%" class="dialogTd" align="right">姓名：</td>
						    	<td width="60%" class="dialogTd"><input type="text" name="xm" id ="xm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"   /></td>
									
					   	</tr>
						<tr class="dialogTr">
						    	<td width="40%" class="dialogTd" align="right">身份证号码：</td>
						    	<td width="60%" class="dialogTd"><input type="text" id="gmsfhm" name="gmsfhm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  /></td>					   
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

//查询按钮
function queryButton(){
	clearButton();
	var xm = document.getElementById("xm").value;
	var gmsfhm = document.getElementById("gmsfhm").value;
	var zdrylxdm = document.getElementById("zdrylxdm").value;
	
	// 新增查询条件 beign
	var gxsxj = $("#gxsxj").val(); //管辖市(县)局
	var gxsxjs = gxsxj=='210200000000' ? '' : gxsxj;
	var gxpcs =  $("#gxpcs").val(); //管辖派出所
	var gxxzqh =  $("#gxxzqh").val(); //管辖行政区划
	// 新增查询条件 end
	
	xm= $.trim(xm);
	gmsfhm= $.trim(gmsfhm);
	var parm = "?xm=" + xm + "&gmsfhm=" +  gmsfhm + "&zdrylxdm=" + zdrylxdm + "&gxsxj=" + gxsxjs + "&gxpcs=" + gxpcs + "&gxxzqh=" + gxxzqh;
	window.parent.zdParm(parm, "zdrk");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}

function clearButton(){
	window.parent.zdParm("", "zdrk_clear");
}


</script>  

</html>