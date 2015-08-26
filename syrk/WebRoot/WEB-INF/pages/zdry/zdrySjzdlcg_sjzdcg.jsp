<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>上级指定撤管</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdrySjzdlcg/sjzdcgSave" id="dataForm" name="dataForm" method="post">
    	<!-- 列撤管ID -->
    	<input type="hidden" id="id" name="id" value="${entity.id }" />
    	<input type="hidden" id="ryid" name="ryid" value="${entity.ryid }" />
    	<input type="hidden" id="syrkid" name="syrkid" value="${entity.syrkid }" />
    	<input type="hidden" id="cglxdm" name="cglxdm" value="${entity.zdrygllxdm }" />
    	<input type="hidden" id="dzdmStr" name="dzdmStr"/>
    	<input type="hidden" id="jzdzzbidStr" name="jzdzzbidStr"/>
	    <div data-options="region:'center', split:true" style="width:600px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" value="${entity.xm}" id="xm" style="width:200px;" readonly="readonly" /></td>
					<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" value="${entity.zjhm}" id="zjhm" style="width:200px;" readonly="readonly" /></td>
			    </tr>
			    <!--  
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">户籍地址：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    		<input class="easyui-validatebox" type="text" id="dz_hjdzxz" name="dz_hjdzxz" value="${dzList[0].dzxz}" maxlength="50" 
			    			style="width: 540px;" data-options=""/>
			    		<a class="easyui-linkbutton" onclick="$('#tr_hjdz_dtl_1').toggle();$('#tr_hjdz_dtl_2').toggle();$('#text_add').toggle();$('#text_sub').toggle();"><font id="text_add">+</font><font hidden="true" id="text_sub">-</font></a>
			    		<c:if test="${dzList[0].checked == 1}">
			    			<input type="checkbox" checked="checked" id="hjdzCheckbox" name="" onclick="return false"/>
			    		</c:if>
			    		<c:if test="${dzList[0].checked == 0}">
			    			<input type="checkbox" hidden="true" id="hjdzCheckbox" name="" onclick="return false"/>
			    		</c:if>
			    		<c:if test="${dzList[0].checked == null}">
			    			<input type="checkbox" id="hjdzCheckbox" name=""/>
			    		</c:if>
			    	</td>
			    </tr>
			    <tr class="dialogTr" id="tr_hjdz_dtl_1" hidden="true">
			    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="" value="${dzList[0].pcs}" style="width:200px;" readonly="readonly"/>
			    		<input type="hidden" name="ygxpcsdm" id="ygxpcsdm" value=""/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxzrq" name="" value="${dzList[0].zrq}" style="width:200px;" readonly="readonly"/>
			    		<input type="hidden" name="ygxzrqdm" id="ygxzrqdm" value=""/>	
			    	</td>
			    </tr>
			    <tr class="dialogTr" id="tr_hjdz_dtl_2" hidden="true">
			    	<td width="20%" class="dialogTd" align="right">管辖民警：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="" value="${dzList[0].gxmj}" style="width:200px;" readonly="readonly"/>
			    		<input type="hidden"  name="ygxmjdm" id="ygxmjdm" value=""/>	
			    	</td>
					<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="ygxmjlxdh" name="" value="${dzList[0].gxmjlxdh}" style="width:200px;" readonly="readonly" /></td>
			    </tr>
			    -->
		    	<tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">现居住地址：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    		<input class="easyui-validatebox" type="text" id="dz_jzdzxz" name="dz_jzdzxz" value="${dz.DZXZ}" maxlength="50" 
			    			style="width: 540px;" data-options=""/>
			    		<input type="checkbox" id="jzdzCheckbox" checked="checked" name="jzdzCheckbox"/>
			    		<input type="hidden" id="dzdm" name="dzdm" value="${dz.DZDM}"/>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr"">
			    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxpcs" name="" value="${dz.PCS}" style="width:200px;" readonly="readonly"/>
			    		<input type="hidden" name="xgxpcsdm" id="xgxpcsdm" value=""/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxzrq" name="" value="${dz.ZRQ}" style="width:200px;" readonly="readonly"/>
			    		<input type="hidden" name="xgxzrqdm" id="xgxzrqdm" value=""/>
			    	</td>
			    </tr>
			    <tr class="dialogTr"">
			    	<td width="20%" class="dialogTd" align="right">管辖民警：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxpcs" name="" value="${dz.gxmj}" style="width:200px;" readonly="readonly"/>
			    		<input type="hidden"  name="xgxmjdm" id="xgxmjdm" value=""/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="xgxmjlxdh" name="" value="${dz.gxmjlxdh}" style="width:200px;" readonly="readonly" /></td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" id="bz" class="easyui-validatebox" style="width: 602px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${bz}</textarea></td>
		    	</tr>
		    	<!--  
		    	<tr>
					<td class="toolbarTd" colspan="4" align="center">
						<a class="easyui-linkbutton" iconCls="icon-search" onclick="save();" style="margin-right: 10px;">指定</a>
						<a class="easyui-linkbutton" iconCls="icon-reload" onclick="reset();">重置</a>
						<a class="easyui-linkbutton" iconCls="icon-reload" onclick="close();">关闭</a>
					</td>
				</tr>
				-->
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	setInputReadonly('zdrylbdm',true);
}

function beforeSubmit() {
}

function afterSubmit() {
	dzdmStr = "";
	jzdzzbidStr = "";
}
//设置转递原因值
function zdyySelect(obj){
	document.getElementById("zdyyName").value = obj.text;
}
$(document).ready(function(){
	initAddressSearch('xjzd1', {zrqdm:'${xgxzrqdm}'}, 'dz_xjzdzmlpdm', 'dz_xjzdzmlpxz', 'xjzd2', {text:'dz_xjzdzxz',dzxzqh:'dz_xjzdzssxdm',id:'dz_xjzdzdm'}, null, null);
});

var isUploadFilePage = "1";  // 上传文件页面标志
var uploadCount = 1;
var fileType = "${fileType}";
var validType = "";
if (fileType == "img") {
	validType = "imgFile";
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var idField = opts.idField;
	$('#downloadID').val(rowData[idField]);
	$('#downloadform').form('submit', {
		success: function(result) {
			if (result) {
				result = parseReturn(result);
				if (result.status == 'success') {
				}
				else {
					topMessager.alert('', result.message);
				}
			}
		}
	});
}

function zdrylbChange(record){
	window.location = '<%=contextPath%>/zdrySjzdlcg/sjzdcgAdd?ryid='+$('#ryid').val()+'&zdrylbdm='+record.id;
	return;
}
</script>
</html>