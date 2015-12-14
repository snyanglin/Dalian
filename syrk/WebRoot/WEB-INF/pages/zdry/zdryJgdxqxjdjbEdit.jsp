<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>监管对象请销假</title>
</head>

<body>

    <form action="" id="dataForm" name="dataForm" method="post">
	    
	    <input type="hidden" id="_method" name="_method" value=""/>
	    <input type='hidden' name='id' id="pk" value="${entity.id}" />
	    <input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}" />

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
			  	<td width="20%" class="dialogTd" align="right">请假原因：</td>
			  	<td width="80%" class="dialogTd" colspan="3"><textarea name="qjyy" id="qjyy" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'请假原因不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.qjyy}</textarea>
				</td>
			</tr> 
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">请假日期：</td>
			    <td width="30%" class="dialogTd">
			    	<input type="text" name="qjrq" id="qjrq" class="easyui-validatebox" style="width: 200px;" value="${entity.qjrq }"
			     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'yjfh_rq\') }'})" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/>
			    </td>
	    		<td width="20%" class="dialogTd" align="right">去往地行政区划：</td>
			    <td width="30%" class="dialogTd">
			    	<input type="text" name="qwxzqhdm" id="qwxzqhdm" value="${entity.qwxzqhdm}" class="easyui-combobox" style="width:200px;"
	    				data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',required:true,
							valueField:'id',textField:'text',selectOnNavigation:false,tipPosition:'left'">
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">去往地详址：</td>
			    <td width="80%" class="dialogTd" colspan="3">
			    	<input type="text" name="qwxz" id="qwxz" class="easyui-validatebox" maxlength="100" style="width: 618px;" value="${entity.qwxz }"/>
			    </td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">预计返回日期：</td>
			    <td width="80%" class="dialogTd" colspan="3">
			    	<input type="text" name="yjfh_rq" id="yjfh_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.yjfh_rq}" 
			    		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'qjrq\') }'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
			    </td>
	    	</tr>
	 		<tr class="dialogTr">
			  	<td width="20%" class="dialogTd" align="right">备注：</td>
			  	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" id="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
				</td>
			</tr> 
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">请假审批结果：</td>
			    <td width="80%" class="dialogTd" colspan="3">
			   		<input class="easyui-combobox" type="text" id="spjg" name="spjg" style="width:200px;" value="${entity.spjg}"
					data-options="url: contextPath + '/common/dict/D_GG_SPJG.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					<span id="spjgSpan"></span>
			    </td>
	    	</tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">请假审批意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" id="spyj" name="spyj" style="width: 618px;" value="${entity.spyj}" data-options="required:false,validType:['maxLength[100]','unnormal'],tipPosition:'left'"/>
		    	</td>
		   	</tr>
	    	<tr class="dialogTr">
		   		<td width="20%" class="dialogTd" align="right">请假审批日期：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" name="spsj" id="spsj" style="width: 200px;" value="${entity.spsj}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">请假审批人：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" name="spr_xm" id="spr_xm" style="width: 200px;" maxlength="20" value="${entity.spr_xm}"/>
					<input type="hidden" name="spr_id" id="spr_id" value="${entity.spr_id}"/>
				</td>
		    </tr>
			<c:if test="${entity.spjg == '1'}">
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">实际返回日期：</td>
				    <td width="30%" class="dialogTd"><input type="text" name="sjfh_rq" id="sjfh_rq" value="${entity.sjfh_rq}" class="easyui-validatebox"  style="width: 200px;" 
				     	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'xjrq\') }'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/></td>
				   	<td width="20%" class="dialogTd" align="right">销假日期：</td>
				    <td width="30%" class="dialogTd"><input type="text" name="xjrq" id="xjrq" value="${entity.xjrq}" class="easyui-validatebox" style="width: 200px;" 
				      	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sjfh_rq\') }'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"/></td>
		    	</tr>
			</c:if>
			<c:if test="${entity.spjg != '1'}">
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">实际返回日期：</td>
				    <td width="30%" class="dialogTd"><input type="text" name="sjfh_rq" id="sjfh_rq" value="${entity.sjfh_rq}" class="easyui-validatebox" style="width: 200px;" /></td>
				   	<td width="20%" class="dialogTd" align="right">销假日期：</td>
				    <td width="30%" class="dialogTd"><input type="text" name="xjrq" id="xjrq" value="${entity.xjrq}" class="easyui-validatebox" style="width: 200px;" /></td>
		    	</tr>
			</c:if>
	    </table>
	    
	</form>

</body>

<script type="text/javascript">

function doInit(paramArray) {
	windowID = paramArray['windowID'];
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);

	initComboBox('qwxzqhdm', contextPath + '/common/dict/GB_D_XZQHDMLIST.js'); 
	var spjgValue = "${entity.spjg}"; 
	if (spjgValue == "") { // 未审批
		setInputReadonly('spjg',true);
		setInputReadonly('spsj',true);
		setInputReadonly('spr_xm',true);
		setInputReadonly('spyj',true);
		setInputReadonly('sjfh_rq',true);
		setInputReadonly('xjrq',true);
		$('#spjgSpan').css("color", "#666666");
		$('#spjgSpan').html("未审批");
	}
	else {
		setInputReadonly('qjyy',true);
		setInputReadonly('qjrq',true);
		setInputReadonly('qwxzqhdm',true);
		setInputReadonly('qwxz',true);
		setInputReadonly('yjfh_rq',true);
		setInputReadonly('spjg',true);
		setInputReadonly('spsj',true);
		setInputReadonly('spr_xm',true);
		setInputReadonly('spyj',true);
		setInputReadonly('bz',true);
		if (spjgValue == "0") { // 审批不同意
			setInputReadonly('sjfh_rq',true);
			setInputReadonly('xjrq',true);
			$('#spjgSpan').css("color", "#FF0000");
			$('#spjgSpan').html("审批未通过");
			dialogSaveButtonHide(windowID);  // 隐藏保存按钮
		}
		else if (spjgValue == "1") { // 审批同意
			setInputReadonly('sjfh_rq',false);
			setInputReadonly('xjrq',false);
			$('#spjgSpan').css("color", "#009933");
			$('#spjgSpan').html("审批已通过");
		}
	}
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryJgdxqxjdjb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/zdryJgdxqxjdjb/' + $("#pk").val());
	}
}

function afterSubmit() {
}

</script>
</html>

