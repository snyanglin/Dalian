<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-3 下午13:15:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>民枪专管人员信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveMqzgry" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xm" name=xm style="width:200px;" value="${entity.xm}"  
			    			data-options="required:true,validType:['maxLength[50]'],tipPosition:'right'"/>
			    	</td>	
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xb" name="xb" style="width:200px;" value="${entity.xb}" 
			    			data-options="url:contextPath+'/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
			    	</td>
			    </tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">证件种类：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="zjlx" name="zjlx" style="width:200px;" value="${entity.zjlx}" 
			    			data-options="url:contextPath+'/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zjhmCheck"/>
					</td>
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;" value="${entity.zjhm}" maxlength="30"
							data-options="required:true,tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">联系电话：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;" value="${entity.lxdh}" maxlength="30"
							data-options="required:false,validType:['phone'],tipPosition:'right'" maxlength="30"/>
					</td>
					<td width="20%" class="dialogTd" align="right">职责：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="zz" name="zz" style="width:200px;" value="${entity.zz}"
							data-options="validType:['maxLength[50]'],required:false,tipPosition:'right'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">审批机关：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="spjg" name="spjg" style="width:200px;" value="${entity.spjg}"
							data-options="validType:['maxLength[50]'],required:false ,tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">审批人：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="spr" name="spr" style="width:200px;" value="${entity.spr}"
							data-options="validType:['maxLength[50]'],required:false,tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">审批日期：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" name="sprq" id="sprq" class="easyui-validatebox" style="width: 200px;" value="${entity.sprq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" 
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd"  colspan="3">
						<textarea class="easyui-validatebox" type="text" data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false ,tipPosition:'left'" id="bz" name="bz" style="width:630px;height: 30px;">${entity.bz}</textarea>
					</td>
				</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
	if($("#zjlx").val()  == "111" || $("#zjlx").val() =="112" || $("#zjlx").val()  == "335"){ 
			$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
}

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	parent.$("#mqzgry_datagrid").datagrid("reload");
}

function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	$("#zjhm").val("");
	_zjhm = "";
}
</script>