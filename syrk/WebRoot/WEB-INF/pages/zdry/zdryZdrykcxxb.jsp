<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>重点人员考察</title>
	</head>

<body>
		<form action="" id="dataForm" name="dataForm" method="post" >
			
			<input type="hidden" id="_method" name="_method" value=""/>
			<input type='hidden' name='id' id="pk" value="${entity.id}" />
			<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}" />
			
			<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
				<tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="xm" name="xm" style="width:200px;" readonly="readonly"/>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" name="sfzh" style="width:200px;" readonly="readonly"/>
			    	</td>
	    		</tr>
				<tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">考察时间：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="kc_sj" name="kc_sj" value="${entity.kc_sj}" style="width:200px;" readonly="readonly"/>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">考察民警：</td>
			    	<td width="30%" class="dialogTd">
			    		<input type='hidden' name='kcmjid' id="kcmjid" value="${entity.kcmjid}" />
			    		<input class="easyui-validatebox inputreadonly" type="text" id="kcmjxm" name="kcmjxm" value="${entity.kcmjxm}" style="width:200px;" readonly="readonly"/>
			    	</td>
	    		</tr>
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">考察周期：</td>
			    	<td width="30%" class="dialogTd"><input name="kczqdm" id="kczqdm" class="easyui-combobox" style="width:200px;" maxlength="1" value="${entity.kczqdm}"
							data-options="tipPosition:'right',required:true,url: contextPath + '/common/dict/DL_D_KCZQDM.js',valueField:'id',textField:'text',
							selectOnNavigation:false,method:'get',onSelect:selectKczq"/>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right"></td>
			    	<td width="30%" class="dialogTd"></td>
		    	</tr>
		    	<tr class="dialogTr" id="kc_kcnf_tr" style="display: none;">
			    	<td width="20%" class="dialogTd" align="right">考察年分：</td>
			    	<td width="30%" class="dialogTd">
		    			<input class="easyui-validatebox" type="text" id="kcnf" name="kcnf" style="width:200px;" maxlength="4" value="${entity.kcnf}"
							data-options="validType:['date[\'yyyy\']'],tipPosition:'right'"/>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr" id="kc_kcjd_tr" style="display: none;">
			    	<td width="20%" class="dialogTd" align="right">考察季度：</td>
			    	<td width="30%" class="dialogTd">
		    			<input type="text" name="kcjd" id="kcjd" class="easyui-combobox" style="width:200px;" maxlength="1" value="${entity.kcjd}"
							data-options="tipPosition:'right',url: contextPath + '/common/dict/DL_D_JDDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr" id="kc_kcyf_tr" style="display: none;">
			    	<td width="20%" class="dialogTd" align="right">考察月份：</td>
			    	<td width="30%" class="dialogTd">
		    			<input class="easyui-validatebox" type="text" id="kcyf" name="kcyf" style="width:200px;" maxlength="2" value="${entity.kcyf}"
							data-options="tipPosition:'right',validType:['numericRange[\'i\',0,1,12]'],invalidMessage:'正确的月份为1-12，请重新输入！'"/>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">考察情况：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><textarea name="kcqk" id="kcqk" class="easyui-validatebox" style="width: 618px; height:96px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'考察情况不能超过1000个汉字，请重新输入！',tipPosition:'left',required:true">${entity.kcqk}</textarea></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" id="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
		    	</tr>
	    	</table>
    	</form>

</body> 

<script type="text/javascript">
var sfgxArray = new Array();
var glbmdmArray = new Array();
var glbmNameArray = new Array();
var zdrylbNameArray = new Array();

function doInit(paramArray){
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);
	selectKczq();
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryZdrykcxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/zdryZdrykcxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

/**
 * 通过选择考察周期代码，对应显示的输入值框也不一样
 */
function selectKczq(obj){
	var kczqdmValue = $('#kczqdm').combobox('getValue');
	if (kczqdmValue == "1" || kczqdmValue == ""){

		setInputReadonly('kcnf',false);
		setInputReadonly('kcjd',true);
		setInputReadonly('kcyf',true);
		
		$("#kc_kcnf_tr").show();
		$("#kc_kcjd_tr").hide();
		$("#kc_kcyf_tr").hide();
		
		$("#kcnf").val((new Date()).getFullYear());
		$("#kcjd").combobox("setValue","");
		$("#kcyf").val("");

	}else if(kczqdmValue == "2"){
		setInputReadonly('kcnf',true);
		setInputReadonly('kcjd',false);
		setInputReadonly('kcyf',true);

		$("#kc_kcnf_tr").hide();
		$("#kc_kcjd_tr").show();
		$("#kc_kcyf_tr").hide();
	
		$("#kcnf").val("");
		$("#kcyf").val("");
		
	}else if(kczqdmValue == "3"){
		setInputReadonly('kcnf',true);
		setInputReadonly('kcjd',true);
		setInputReadonly('kcyf',false);

		$("#kc_kcnf_tr").hide();
		$("#kc_kcjd_tr").hide();
		$("#kc_kcyf_tr").show();
		
		$("#kcnf").val("");
		$("#kcjd").combobox("setValue","");
		$("#kcyf").val((new Date()).getMonth());

	}
}
</script>
</html>