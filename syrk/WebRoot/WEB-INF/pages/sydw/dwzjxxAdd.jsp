<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 下午14:31:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位证件信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwzjxxb/saveZjxx" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
    	<input type="hidden" id="flag" value="${flag}">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type='hidden' name='id' id="pk" value="${entity.id }" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">证件种类：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="dwzjzldm" name="dwzjzldm" style="width:200px;" value="${entity.dwzjzldm}"
						data-options="url: contextPath + '/common/dict/D_DW_DWZJZL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">证件编号：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" name="dwzjbh" id="dwzjbh" maxlength="30" style="width: 200px;" value="${entity.dwzjbh}" 
						data-options="required:true,tipPosition:'left',charSet:'halfUpper'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">签发日期：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox " type="text" id="qfrq" name="qfrq" value="${entity.qfrq}" style="width: 200px;"
						data-options="required:false,validType:['date[\'yyyy-MM-dd\']']"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'jzrq\') }'})"/>
					</td>
					<td width="20%" class="dialogTd" align="right">截止日期：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="jzrq" name="jzrq" maxlength="30" style="width: 200px;" value="${entity.jzrq}" 
						data-options="required:false,tipPosition:'left',validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'qfrq\') }'})"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="dialogTd" align="right">证件审批机关：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<input class="easyui-validatebox" type="text" name="zjspjg" id="zjspjg" maxlength="50" style="width: 628px;" value="${entity.zjspjg}" 
						data-options="required:false,tipPosition:'left'"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="dialogTd" align="right">证件年检机关：</td>
					<td width="80%" class="dialogTd" colspan="3" >
						<input class="easyui-validatebox" type="text" name="zjnjjg" id="zjnjjg" maxlength="50" style="width: 628px;" value="${entity.zjnjjg}" 
						data-options="required:false,tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">备注：</td>
			    	<td width="80%" class="dialogTd" colspan="3" >
			    		<textarea id="bz" name="bz" class="easyui-validatebox" style="width: 628px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.bz}</textarea>
					</td>
	    		</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >

function doInit(paramArray) {
}

function beforeSubmit() {
	var su = true;
	var flag = document.getElementById("flag").value;
	if(flag=="add"){
		$.ajax({
			async:false,
			type:"POST",
			url:"<%= basePath%>dwzjxxb/getdwzjbh",
			dataType:"json",
			data:"dwzjzldm="+$("#dwzjzldm").val()+"&dwzjbh="+$("#dwzjbh").val(),
			success:function(data){
				if (data && data.sfzhflag) {
					if(data.sfzhflag==true){
						su = false;
						alert("该单位已经添加过了");
					}else {
					
					}
				}
			}
		});
	}else {
	
	}
	return su;
}
function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	
}
</script>