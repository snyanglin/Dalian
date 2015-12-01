<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>旅店信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>ldxxb_dl/saveLdxxb" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">旅馆编码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="lgbm" name="lgbm" style="width:200px;" value="${entity.lgbm}" 
		    		data-options="required:true,validType:['maxLength[50]'],invalidMessage:'旅馆编码不能超过50个汉字，请重新输入！',tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">星级：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="xj" name="xj" style="width:200px;" value="${entity.xj}" maxlength="1"
		    		data-options="required:false,validType:['naturalNumber'],tipPosition:'left'"/>
		    	</td>
		    </tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">栋数：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="ds" name="ds" style="width:200px;" value="${entity.ds}"
					data-options="required:false,validType:['naturalNumberRange[1,10000]'],tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">楼层数：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="lcs" name="lcs" style="width:200px;" value="${entity.lcs}"
					data-options="required:false,validType:['naturalNumberRange[1,999]'],tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">客房数：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="kefs" name="kefs" style="width:200px;" value="${entity.kefs}"
					data-options="required:false,validType:['naturalNumberRange[1,10000]'],tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">床位数：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="cws" name="cws" style="width:200px;" value="${entity.cws}"
					data-options="required:false,validType:['naturalNumberRange[1,100000]'],tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">是否涉外：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" type="text" id="sfswdm" name="sfswdm" style="width:200px;" value="${entity.sfswdm}"
					data-options="url:contextPath+'/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">经营状态：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" type="text" id="jyztdm" name="jyztdm" style="width:200px;" value="${entity.jyztdm}"
					data-options="url:contextPath+'/common/dict/D_DW_JYZT.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">经营期：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-validatebox" type="text" id="jyq" name="jyq" style="width:200px;" value="${entity.jyq}"
					data-options="required:false,validType:['maxLength[100]'],invalidMessage:'经营期不能超过100个汉字，请重新输入！',tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">库房数：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-validatebox" type="text" id="kufs" name="kufs" style="width:200px;" value="${entity.kufs}" onchange="kufang(this);"
					data-options="required:false,validType:['numericRange[\'i\',0,0,10000]'],tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">库房门窗数：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-validatebox" type="text" id="kfmcs" name="kfmcs" style="width:200px;" value="${entity.kfmcs}"
					data-options="required:false,validType:['naturalNumberRange[1,10000]'],tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">库房有无防盗门：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" type="text" id="kfywfdmdm" name="kfywfdmdm" style="width:200px;" value="${entity.kfywfdmdm}"  
					data-options="url:contextPath +'/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">有无人值宿：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" type="text" id="ywrzsrdm" name="ywrzsrdm" style="width:200px;" value="${entity.ywrzsrdm}"
					data-options="url:contextPath+'/common/dict/D_BZ_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">更值人口数：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-validatebox" type="text" id="gz_rs" name="gz_rs" style="width:200px;" value="${entity.gz_rs}"
					data-options="required:false,validType:['naturalNumberRange[1,100]'],tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">电子监控：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" type="text" id="ywdzjksbdm" name="ywdzjksbdm" style="width:200px;" value="${entity.ywdzjksbdm}"
					data-options="url:contextPath+'/common/dict/D_BZ_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">闭路电视监控：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" type="text" id="ywbldsjksb" name="ywbldsjksb" style="width:200px;" value="${entity.ywbldsjksb}"
					data-options="url:contextPath+'/common/dict/D_BZ_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">附属娱乐项目：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="fsylxm" name="fsylxm" style="width:627px; height:48px;"
					data-options="validType:['maxLength[4000]'],invalidMessage:'附属娱乐项目不能超过4000个汉字，请重新输入！',required:false,tipPosition:'left'">${entity.fsylxm}</textarea>
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">附属服务项目：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="fsfwxm" name="fsfwxm" style="width: 627px; height:48px;"
					data-options="validType:['maxLength[4000]'],invalidMessage:'附属服务项目不能超过4000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.fsfwxm}</textarea>
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

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	window.parent.location.reload();
}
function kufang(a){
	if(a.value ==0){
	   $("#kfmcs").removeClass("easyui-validatebox");
	   $("#kfmcs").addClass("easyui-validatebox inputreadonly");
	   $("#kfmcs").attr("readonly",true);
	   $("#kfmcs").val("");
	   
	   setInputReadonly('kfywfdmdm', true);
	   $("#kfywfdmdm").combobox('setValue','');
	}else{
	   $("#kfmcs").removeClass("easyui-validatebox inputreadonly");
	   $("#kfmcs").addClass("easyui-validatebox");
	   $("#kfmcs").attr("readonly",false);
	   
	   setInputReadonly('kfywfdmdm', false);
	}
}

</script>