<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>自助银行及自助设备</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zzyhjzzsbb_dl/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:700px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">自助设备类别：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='zzsblbdm' name='zzsblbdm' class="easyui-combobox " style="width:200px;"
				data-options="required:true,url: contextPath + '/common/dict/D_DW_ZZYHLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" value="${entity.zzsblbdm}" /></td>			
				<td width="20%" class="dialogTd" align="right">安装日期：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="az_rq" id="az_rq" style="width:200px" value="${entity.az_rq}"
		    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" /></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">安装地点：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='azdd' name='azdd' class="easyui-validatebox" style="width:627px;"
						maxlength="100" value="${entity.azdd}" /></td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">监控情况：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="jkqk" name="jkqk" style="width: 627px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'监控情况不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.jkqk}</textarea>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">责任人常用证件：</td>
		    	<td width="30%" class="dialogTd">
		    	<input type="hidden" id="zrr_ryid" name="zrr_ryid" value="${entity.zrr_ryid }"/>
		    	<input class="easyui-combobox" type="text" id="zrr_cyzjdm" name="zrr_cyzjdm" style="width:200px;" value="${entity.zrr_cyzjdm }"
					data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:zjhmCheck" />
		    	</td>
				<td width="20%" class="dialogTd" align="right">责任人证件号码：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zrr_zjhm" name="zrr_zjhm" style="width:200px;float:left;" value="${entity.zrr_zjhm }" maxlength="30" 
		    		data-options="required:false,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div></td>
	    	</tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">责任人姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zrr_xm" name="zrr_xm" style="width:200px;" value="${entity.zrr_xm }" maxlength="20" 
		    		data-options="required:false,tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">责任人联系电话：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zrr_lxdh" name="zrr_lxdh" style="width:200px;" value="${entity.zrr_lxdh }" maxlength="18"
		    		data-options="validType:['phone'],required:false,tipPosition:'left'" />
		    	</td>
		    </tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">责任人职务：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zrr_zwmc" name="zrr_zwmc" style="width:200px;" value="${entity.zrr_zwmc }" maxlength="20" 
		    		data-options="required:false,tipPosition:'right'"/>
		    	</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 627px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bz}</textarea>
				</td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _zjhm = "";
function doInit(paramArray) {
	if($("#zrr_cyzjdm").combobox("getValue") == ""){
		$("#zrr_cyzjdm").combobox("setValue","111");
	}

	//人员信息复用
	$("#zrr_zjhm").bind("blur",function(e){ checkRyxx(); });
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#zrr_zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#zrr_zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zrr_zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearRyxx();
	$("#zrr_zjhm").val("");
	_zjhm = "";
}

/**
 * 人员基本信息复用人员基本信息表
 */
function checkRyxx(){
	
	if($("#zrr_zjhm").val() == _zjhm){
		return;
	}
	if(!$("#zrr_zjhm").validatebox("isValid")){
		return;
	}
	
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#zrr_zjhm").val()+"&cyzjdm="+$("#zrr_cyzjdm").val(),
		success:function(data){
			if (data && data.ryjbxxb) {
				$("#zrr_ryid").val(data.ryjbxxb.id);
				$("#zrr_xm").val(data.ryjbxxb.xm);
				$("#zrr_lxdh").val(data.ryjbxxb.lxdh);
			}else{
				clearRyxx();
			}
		},
		complete:function(){
			$("#yrjbxxDiv").hide();
		}
	});
}

//清空复用的人员基本信息
function clearRyxx(){
	$("#zrr_ryid").val("");
	$("#zrr_xm").val("");
	$("#zrr_lxdh").val("");
}

</script>
