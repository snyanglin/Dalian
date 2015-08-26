<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>监管对象请销假</title>
</head>

<body>

    <form action="<%=basePath%>zdryJgdxqxjdjb/updateSp" id="dataForm" name="dataForm" method="post">
	    
	    <input type="hidden" id="_method" name="_method" value=""/>
	    <input type='hidden' name='id' id="pk" value="${entity.id}" />
	    <input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}" />
	    <input type="hidden" id="messageid" name="messageid" value="${entity.messageid}" />

	    <table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
			<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="xm" value="${zdryZdryzb.xm}" style="width:200px;" readonly="readonly"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" value="${zdryZdryzb.zjhm}" style="width:200px;" readonly="readonly"/>
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
					data-options="url: contextPath + '/common/dict/D_GG_SPJG.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
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
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">实际返回日期：</td>
			    <td width="30%" class="dialogTd"><input type="text" name="sjfh_rq" id="sjfh_rq" class="easyui-validatebox"  style="width: 200px;"/></td>
			   	<td width="20%" class="dialogTd" align="right">销假日期：</td>
			    <td width="30%" class="dialogTd"><input type="text" name="xjrq" id="xjrq" class="easyui-validatebox" style="width: 200px;"/></td>
	    	</tr>
			<tr class="dialogTr" id="tr_sp_4">
		    	<td width="50%" class="dialogTd" align="right" colspan="2" style="padding-right: 10px">
			    	<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="saveClick()">
						<span class="l-btn-left l-btn-icon-left">
							<span class="l-btn-text">保存</span>
							<span class="l-btn-icon icon-save"> </span>
						</span>
					</a>
				</td>
		    	<td width="50%" class="dialogTd" align="left" colspan="2" style="padding-left: 20px">
					<a id="resetBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="resetClick()">
						<span class="l-btn-left l-btn-icon-left">
							<span class="l-btn-text">重置</span>
							<span class="l-btn-icon icon-reset"> </span>
						</span>
					</a>
				</td>
		   	</tr>
	   	</table>
	</form>

</body>

<script type="text/javascript">

var windowID;

function doInit(paramArray) {
	windowID = paramArray['windowID'];
	
	initComboBox('qwxzqhdm', contextPath + '/common/dict/GB_D_XZQHDMLIST.js'); 
	setInputReadonly('qjyy',true);
	setInputReadonly('qjrq',true);
	setInputReadonly('qwxzqhdm',true);
	setInputReadonly('qwxz',true);
	setInputReadonly('yjfh_rq',true);
	setInputReadonly('spsj',true);
	setInputReadonly('spr_xm',true);
	setInputReadonly('sjfh_rq',true);
	setInputReadonly('xjrq',true);
}

function beforeSubmit() {
}

function afterSubmit() {
}

function saveClick() {
	if ($('#dataForm').form('validate')) {
		$('#dataForm').form('submit',{
			dataType: 'json',
			success: function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					executeTabPageMethod("0", "refresh_wfTask");
					topMessager.show({
						title: MESSAGER_TITLE,
						msg: result.message,
						timeout:1500
					});
					window.top.$('#' + windowID).window('close');
				}
				else {
					topMessager.alert(MESSAGER_TITLE, result.message, 'error');
				}
			}
		});
	}
}

function resetClick() {
	$('#dataForm').form('reset');
}

</script>
</html>

