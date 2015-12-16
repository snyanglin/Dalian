<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>重点人员作案规律特点表</title>
</head>
	
<body>

<form action="" id="dataForm" name="dataForm" method="post">
	<input type="hidden" id="_method" name="_method" value=""/>
	<input type="hidden" id="pk" name="id" value="${entity.id}"/>
	<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}"/>
			
	<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		<tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">姓名：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="xm" style="width:200px;" readonly="readonly"/>
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" style="width:200px;" readonly="readonly"/>
	    	</td>
    	</tr>
		<tr class="dialogTr">
   			<td width="20%" class="dialogTd" align="right">案件类别：</td>
   			<td width="30%" class="dialogTd"><input name="ajlbdm" id="ajlbdm" class="easyui-combobox" style="width:200px;" value="${entity.ajlbdm}" maxlength="300"
				data-options="required:true,url: contextPath + '/common/dict/XZ_D_AJLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
			</td>
			<td width="20%" class="dialogTd" align="right">选择物品：</td>
			<td width="30%" class="dialogTd"><input type="text" name="xzwpdm" id="xzwpdm" class="easyui-combobox" style="width:200px;" value="${entity.xzwpdm}" maxlength="300"
				data-options="required:false,url: contextPath + '/common/dict/XZ_D_XZWPDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',multiple:true"/>
			</td>
 		</tr>
	 	<tr class="dialogTr">
		  	<td width="20%" class="dialogTd" align="right">选择对象：</td>
		  	<td width="80%" class="dialogTd" colspan="3"><input name="xzdxdm" id="xzdxdm" class="easyui-combotree" style="width:618px;" value="${entity.xzdxdm}" maxlength="300"
				data-options="required:false,url: contextPath + '/common/dict/XZ_D_XZDXDM.js',onlyLeaf:true,multiple:false,method:'get',editable:true,lines:true,multiple:true"/>
			</td>
 		</tr>
 		<tr id="kc_kcjd_tr" class="dialogTr">
			<td width="20%" class="dialogTd" align="right">作案手段：</td>
		  	<td width="80%" class="dialogTd" colspan="3"><input type="text" name="zasddm" id="zasddm" class="easyui-combotree" style="width:618px;" value="${entity.zasddm}" maxlength="300"
					data-options="required:false,url: contextPath + '/common/dict/XZ_D_ZASDDM.js',method:'get',onlyLeaf:true,editable:true,multiple:true"/>
			</td>
 		</tr>
 		<tr class="dialogTr">
		  	<td width="20%" class="dialogTd" align="right">作案工具：</td>
		  	<td width="30%" class="dialogTd"><input type="text" name="zagjdm" id="zagjdm" class="easyui-combobox" style="width:200px;" value="${entity.zagjdm}" maxlength="300"
				data-options="required:false,url: contextPath + '/common/dict/XZ_D_ZAGJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',multiple:true"/>
			</td>
			<td width="20%" class="dialogTd" align="right">销赃方式：</td>
  			<td width="30%" class="dialogTd"><input type="text" name="xyrxzfsdm" id="xyrxzfsdm" class="easyui-combotree" style="width:200px;" value="${entity.xyrxzfsdm}" maxlength="300"
				data-options="url: contextPath + '/common/dict/XZ_D_XZFSFLHDM.js',onlyLeaf:true,method:'get',editable:true,multiple:true"/>
			</td>
 		</tr>
 		<tr class="dialogTr">
		  	<td width="20%" class="dialogTd" align="right">作案特点：</td>
		  	<td width="30%" class="dialogTd"><input type="text" name="zatddm" id="zatddm" class="easyui-combobox" style="width:200px;" value="${entity.zatddm}" maxlength="300"
				data-options="required:false,url: contextPath + '/common/dict/XZ_D_ZATDDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',multiple:true"/>
			</td>
			<td width="20%" class="dialogTd" align="right">选择时机：</td>
  			<td width="30%" class="dialogTd"><input type="text" name="xzsjdm" id="xzsjdm" class="easyui-combobox" style="width:200px;" value="${entity.xzsjdm}" maxlength="300"
				data-options="required:false,url: contextPath + '/common/dict/XZ_D_XZSJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',multiple:true"/>
			</td>
 		</tr>
 		<tr class="dialogTr">
		  	<td width="20%" class="dialogTd" align="right">选择处所：</td>
		  	<td width="80%" class="dialogTd" colspan="3"><input type="text" name="xzcsdm" id="xzcsdm" class="easyui-combotree" style="width:618px;" value="${entity.xzcsdm}" maxlength="300"
				data-options="required:false,url: contextPath + '/common/dict/XZ_D_XZCSDM.js',method:'get',onlyLeaf:true,editable:true,multiple:true"/>
			</td>
 		</tr>
 		<tr class="dialogTr">
		  	<td width="20%" class="dialogTd" align="right">备注：</td>
		  	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" id="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
				data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
			</td>
		</tr> 
   	</table>
</form>
</body>

<script type="text/javascript">

function doInit(paramArray){
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);
}

function beforeSubmit() {
	if($("#ajlbdm").val().length > 300){
		topMessagerAlert("","案件类别字段超长，请重新选择!");
		$("#ajlbdm").combobox("setValue", "");
		return false;
	}
	if($("#xzwpdm").val().length > 300){
		topMessagerAlert("","选择物品字段超长，请重新选择!");
		$("#xzwpdm").combobox("setValue", "");
		return false;
	}
	if($("#xzdxdm").combo("getValues").length > 75){
		topMessagerAlert("","选择对象字段超长，请重新选择!");
		$("#xzdxdm").combotree("setValue", "");
		return false;
	}
	if($("#zasddm").combo("getValues").length > 75){
		topMessagerAlert("","作案手段字段超长，请重新选择!");
		$("#zasddm").combotree("setValue", "");
		return false;
	}
	if($("#zagjdm").val().length > 300){
		topMessagerAlert("","作案工具字段超长，请重新选择!");
		$("#zagjdm").combobox("setValue", "");
		return false;
	}
	if($("#xyrxzfsdm").combo("getValues").length > 100){
		topMessagerAlert("","销赃方式字段超长，请重新选择!");
		$("#xyrxzfsdm").combotree("setValue", "");
		return false;
	}
	if($("#zatddm").val().length > 300){
		topMessagerAlert("","作案特点字段超长，请重新选择!");
		$("#zatddm").combobox("setValue", "");
		return false;
	}
	if($("#xzsjdm").val().length > 300){
		topMessagerAlert("","选择时机字段超长，请重新选择!");
		$("#xzsjdm").combobox("setValue", "");
		return false;
	}
	if($("#xzcsdm").combo("getValues").length > 75){
		topMessagerAlert("","选择处所字段超长，请重新选择!");
		$("#xzcsdm").combotree("setValue", "");
		return false;
	}

	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryZagltdxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/zdryZagltdxxb/' + $("#pk").val());
	}
	
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
</script>

</html>