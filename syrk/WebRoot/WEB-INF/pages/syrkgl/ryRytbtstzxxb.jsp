<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>人员体表特殊特征信息</title>
</head>
<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">特殊体貌特征类型：</td>
				<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type="text" id="tstmtzlxdm" name="tstmtzlxdm" style="width:200px;" value="${entity.tstmtzlxdm}"
					data-options="url: contextPath + '/common/dict/BD_D_TMTZDM.js',valueField:'id',
					dataFilter:'00$',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onChange:tstmtzlxdmOnchange"/>
				</td>
				<td width="20%" class="dialogTd" align="right">特殊体貌特征：</td>
				<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type="text" id="tstmtzdm" name="tstmtzdm" style="width:200px;" value="${entity.tstmtzdm}"
					data-options="url: contextPath + '/common/dict/BD_D_TMTZDM.js',valueField:'id',
					dataFilter:'',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">特殊特征描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="tstzms" id="tstzms" class="easyui-validatebox" style="width: 630px; height:48px;"
					data-options="required:true,validType:['maxLength[200]'],invalidMessage:'特殊特征描述不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.tstzms}</textarea></td>
	    	</tr>
    	</table>
    </form>
</body>
<script type="text/javascript">
function doInit(paramArray) {
	var tstmtzlx = $('#tstmtzlxdm').combobox("getValues")+"";
	if (tstmtzlx != ""){
		$('#tstmtzdm').combobox('setDataFilter',  '^'+tstmtzlx.substring(0,2)+
												 '11|^'+tstmtzlx.substring(0,2)+
												 '12|^'+tstmtzlx.substring(0,2)+
												 '13|^'+tstmtzlx.substring(0,2)+
												 '14|^'+tstmtzlx.substring(0,2)+
												 '15|^'+tstmtzlx.substring(0,2)+
												 '16|^'+tstmtzlx.substring(0,2)+
												 '17|^'+tstmtzlx.substring(0,2)+
												 '18|^'+tstmtzlx.substring(0,2)+
												 '19|^'+tstmtzlx.substring(0,2)+
											     '21|^'+tstmtzlx.substring(0,2)+
											     '22|^'+tstmtzlx.substring(0,2)+
											     '23|^'+tstmtzlx.substring(0,2)+
											     '24|^'+tstmtzlx.substring(0,2)+
											     '25|^'+tstmtzlx.substring(0,2)+
											     '26|^'+tstmtzlx.substring(0,2)+
											     '27|^'+tstmtzlx.substring(0,2)+
											     '28|^'+tstmtzlx.substring(0,2)+
											     '29|^'+tstmtzlx.substring(0,2)+
											     '31|^'+tstmtzlx.substring(0,2)+
											     '32|^'+tstmtzlx.substring(0,2)+
											     '33|^'+tstmtzlx.substring(0,2)+
											     '34|^'+tstmtzlx.substring(0,2)+
											     '35|^'+tstmtzlx.substring(0,2)+
											     '36|^'+tstmtzlx.substring(0,2)+
											     '37|^'+tstmtzlx.substring(0,2)+
											     '38|^'+tstmtzlx.substring(0,2)+
											     '39|^'+tstmtzlx.substring(0,2)+
											     '41|^'+tstmtzlx.substring(0,2)+
											     '42|^'+tstmtzlx.substring(0,2)+
											     '43|^'+tstmtzlx.substring(0,2)+
											     '44|^'+tstmtzlx.substring(0,2)+
											     '45|^'+tstmtzlx.substring(0,2)+
											     '46|^'+tstmtzlx.substring(0,2)+
											     '47|^'+tstmtzlx.substring(0,2)+
											     '48|^'+tstmtzlx.substring(0,2)+
											     '49|^'+tstmtzlx.substring(0,2)+
											     '51|^'+tstmtzlx.substring(0,2)+
											     '52|^'+tstmtzlx.substring(0,2)+
											     '53|^'+tstmtzlx.substring(0,2)+
											     '54|^'+tstmtzlx.substring(0,2)+
											     '55|^'+tstmtzlx.substring(0,2)+
											     '56|^'+tstmtzlx.substring(0,2)+
											     '57|^'+tstmtzlx.substring(0,2)+
											     '58|^'+tstmtzlx.substring(0,2)+
											     '59|^'+tstmtzlx.substring(0,2)+
												 '61|^'+tstmtzlx.substring(0,2)+
												 '62|^'+tstmtzlx.substring(0,2)+
												 '63|^'+tstmtzlx.substring(0,2)+
												 '64|^'+tstmtzlx.substring(0,2)+
												 '65|^'+tstmtzlx.substring(0,2)+
												 '66|^'+tstmtzlx.substring(0,2)+
												 '67|^'+tstmtzlx.substring(0,2)+
												 '68|^'+tstmtzlx.substring(0,2)+
												 '69|^'+tstmtzlx.substring(0,2)+
												 '71|^'+tstmtzlx.substring(0,2)+
												 '72|^'+tstmtzlx.substring(0,2)+
												 '73|^'+tstmtzlx.substring(0,2)+
												 '74|^'+tstmtzlx.substring(0,2)+
												 '75|^'+tstmtzlx.substring(0,2)+
												 '76|^'+tstmtzlx.substring(0,2)+
												 '77|^'+tstmtzlx.substring(0,2)+
												 '78|^'+tstmtzlx.substring(0,2)+
												 '79|^'+tstmtzlx.substring(0,2)+
												 '81|^'+tstmtzlx.substring(0,2)+
												 '82|^'+tstmtzlx.substring(0,2)+
												 '83|^'+tstmtzlx.substring(0,2)+
												 '84|^'+tstmtzlx.substring(0,2)+
												 '85|^'+tstmtzlx.substring(0,2)+
												 '86|^'+tstmtzlx.substring(0,2)+
												 '87|^'+tstmtzlx.substring(0,2)+
												 '88|^'+tstmtzlx.substring(0,2)+
												 '89|^'+tstmtzlx.substring(0,2)+
												 '91|^'+tstmtzlx.substring(0,2)+
												 '92|^'+tstmtzlx.substring(0,2)+
												 '93|^'+tstmtzlx.substring(0,2)+
												 '94|^'+tstmtzlx.substring(0,2)+
												 '95|^'+tstmtzlx.substring(0,2)+
												 '96|^'+tstmtzlx.substring(0,2)+
												 '97|^'+tstmtzlx.substring(0,2)+
												 '98|^'+tstmtzlx.substring(0,2)+
												 '99');
	}else{
		setInputReadonly("tstmtzdm", true);
	}
}

function beforeSubmit() {
	if($("#tstmtzlxdm").val() == "" && $("#tstmtzdm").val() == "" && $("#tstzms").val() == ""){
		return false;
	}
	if ($("#pk").val() == "") {
		var _count;
		$.ajax({
			type:"GET",
			url:"<%= basePath%>ryRytbtstzxxb/queryCount",
			dataType:"json",
			data:"ryid="+$("#ryid").val()+"&tstmtzlxdm="+$("#tstmtzlxdm").val()+"&tstmtzdm="+$("#tstmtzdm").val()+"&tstzms="+$("#tstzms").val(),
			async:false,
			success:function(data){
				if(data && data != null && data != undefined && data == 1){
					$.messager.alert('确认对话框', '该体表特殊特征已存在！请重新输入', 'warning', function(){
						
					});
					_count = 1;
				}
			},
			complete:function(){}
		});
		if(_count == 1){
			return false;
		}
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/ryRytbtstzxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/ryRytbtstzxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

function tstmtzlxdmOnchange() {
	var tstmtzlx = $('#tstmtzlxdm').combobox("getValues")+"";
	if (tstmtzlx != "") {
		setInputReadonly("tstmtzdm", false);
		$('#tstmtzdm').combobox('setDataFilter', '^'+tstmtzlx.substring(0,2)+
												 '11|^'+tstmtzlx.substring(0,2)+
												 '12|^'+tstmtzlx.substring(0,2)+
												 '13|^'+tstmtzlx.substring(0,2)+
												 '14|^'+tstmtzlx.substring(0,2)+
												 '15|^'+tstmtzlx.substring(0,2)+
												 '16|^'+tstmtzlx.substring(0,2)+
												 '17|^'+tstmtzlx.substring(0,2)+
												 '18|^'+tstmtzlx.substring(0,2)+
												 '19|^'+tstmtzlx.substring(0,2)+
											     '21|^'+tstmtzlx.substring(0,2)+
											     '22|^'+tstmtzlx.substring(0,2)+
											     '23|^'+tstmtzlx.substring(0,2)+
											     '24|^'+tstmtzlx.substring(0,2)+
											     '25|^'+tstmtzlx.substring(0,2)+
											     '26|^'+tstmtzlx.substring(0,2)+
											     '27|^'+tstmtzlx.substring(0,2)+
											     '28|^'+tstmtzlx.substring(0,2)+
											     '29|^'+tstmtzlx.substring(0,2)+
											     '31|^'+tstmtzlx.substring(0,2)+
											     '32|^'+tstmtzlx.substring(0,2)+
											     '33|^'+tstmtzlx.substring(0,2)+
											     '34|^'+tstmtzlx.substring(0,2)+
											     '35|^'+tstmtzlx.substring(0,2)+
											     '36|^'+tstmtzlx.substring(0,2)+
											     '37|^'+tstmtzlx.substring(0,2)+
											     '38|^'+tstmtzlx.substring(0,2)+
											     '39|^'+tstmtzlx.substring(0,2)+
											     '41|^'+tstmtzlx.substring(0,2)+
											     '42|^'+tstmtzlx.substring(0,2)+
											     '43|^'+tstmtzlx.substring(0,2)+
											     '44|^'+tstmtzlx.substring(0,2)+
											     '45|^'+tstmtzlx.substring(0,2)+
											     '46|^'+tstmtzlx.substring(0,2)+
											     '47|^'+tstmtzlx.substring(0,2)+
											     '48|^'+tstmtzlx.substring(0,2)+
											     '49|^'+tstmtzlx.substring(0,2)+
											     '51|^'+tstmtzlx.substring(0,2)+
											     '52|^'+tstmtzlx.substring(0,2)+
											     '53|^'+tstmtzlx.substring(0,2)+
											     '54|^'+tstmtzlx.substring(0,2)+
											     '55|^'+tstmtzlx.substring(0,2)+
											     '56|^'+tstmtzlx.substring(0,2)+
											     '57|^'+tstmtzlx.substring(0,2)+
											     '58|^'+tstmtzlx.substring(0,2)+
											     '59|^'+tstmtzlx.substring(0,2)+
												 '61|^'+tstmtzlx.substring(0,2)+
												 '62|^'+tstmtzlx.substring(0,2)+
												 '63|^'+tstmtzlx.substring(0,2)+
												 '64|^'+tstmtzlx.substring(0,2)+
												 '65|^'+tstmtzlx.substring(0,2)+
												 '66|^'+tstmtzlx.substring(0,2)+
												 '67|^'+tstmtzlx.substring(0,2)+
												 '68|^'+tstmtzlx.substring(0,2)+
												 '69|^'+tstmtzlx.substring(0,2)+
												 '71|^'+tstmtzlx.substring(0,2)+
												 '72|^'+tstmtzlx.substring(0,2)+
												 '73|^'+tstmtzlx.substring(0,2)+
												 '74|^'+tstmtzlx.substring(0,2)+
												 '75|^'+tstmtzlx.substring(0,2)+
												 '76|^'+tstmtzlx.substring(0,2)+
												 '77|^'+tstmtzlx.substring(0,2)+
												 '78|^'+tstmtzlx.substring(0,2)+
												 '79|^'+tstmtzlx.substring(0,2)+
												 '81|^'+tstmtzlx.substring(0,2)+
												 '82|^'+tstmtzlx.substring(0,2)+
												 '83|^'+tstmtzlx.substring(0,2)+
												 '84|^'+tstmtzlx.substring(0,2)+
												 '85|^'+tstmtzlx.substring(0,2)+
												 '86|^'+tstmtzlx.substring(0,2)+
												 '87|^'+tstmtzlx.substring(0,2)+
												 '88|^'+tstmtzlx.substring(0,2)+
												 '89|^'+tstmtzlx.substring(0,2)+
												 '91|^'+tstmtzlx.substring(0,2)+
												 '92|^'+tstmtzlx.substring(0,2)+
												 '93|^'+tstmtzlx.substring(0,2)+
												 '94|^'+tstmtzlx.substring(0,2)+
												 '95|^'+tstmtzlx.substring(0,2)+
												 '96|^'+tstmtzlx.substring(0,2)+
												 '97|^'+tstmtzlx.substring(0,2)+
												 '98|^'+tstmtzlx.substring(0,2)+
												 '99');
		//$('#tstmtzdm').combobox('setDataFilter', tstmtzlx.substring(2,4)+'$');
	}
}

</script>
</html>
