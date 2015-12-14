<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>人员体貌特征信息</title>
</head>
<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">血型：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xxdm" name="xxdm" style="width:200px;" value="${entity.xxdm}"
					data-options="url: contextPath + '/common/dict/BD_D_XXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">身高（CM）：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="sg" name="sg" maxlength="3" style="width: 200px;" value="${entity.sg}" 
					data-options="validType:['naturalNumberRange[1,300]'],editable:true,required:false,tipPosition:'left'" />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">体重（KG）：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="tz" name="tz" maxlength="3" style="width: 200px;" value="${entity.tz}" 
					data-options="validType:['naturalNumberRange[1,500]'],editable:true,required:false,tipPosition:'right'" />
				</td>
				<td width="20%" class="dialogTd" align="right">体型：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="txdm" name="txdm" style="width:200px;" value="${entity.txdm}"
					data-options="url: contextPath + '/common/dict/BD_D_TMTZDM.js',dataFilter:'^0111|^0112|^0113|^0114|^0115|^0116|^0117',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">脸型：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="lxdm" name="lxdm" style="width:200px;" value="${entity.lxdm}"
					data-options="url: contextPath + '/common/dict/BD_D_TMTZDM.js',dataFilter:'^0311|^0312|^0313|^0314|^0315|^0316|^0317|^0318|^0319',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">足长（MM）：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zc" name="zc" maxlength="3" style="width: 200px;" value="${entity.zc}" 
					data-options="validType:['naturalNumberRange[1,500]'],editable:true,required:false,tipPosition:'left'" />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">鞋号（MM）：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xh" name="xh" maxlength="3" style="width: 200px;" value="${entity.xh}" 
					data-options="validType:['naturalNumberRange[1,500]'],editable:true,required:false,tipPosition:'right'" />
				</td>
				<td width="20%" class="dialogTd" align="right"></td>
				<td width="30%" class="dialogTd"></td>
			</tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">体貌特征描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="tmtzms" id="tmtzms" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'体貌特征描述不能超过200个汉字，请重新输入！',required:true,tipPosition:'left'">${entity.tmtzms}</textarea></td>
	    	</tr>
    	</table>
    </form>
</body>
<script type="text/javascript">
function doInit(paramArray){
	_p = paramArray["_p"];
}

function beforeSubmit() {
	if($("#xxdm").val() == "" && $("#sg").val() == "" && $("#tz").val() == "" && $("#txdm").val() == "" && $("#lxdm").val() == "" && $("#zc").val() == "" && $("#xh").val() == "" && $("#tmtzms").val() == ""){
		return false;
	}
	if ($("#pk").val() == "") {
		var _count;
		$.ajax({
			type:"GET",
			url:"<%= basePath%>ryRytmtzxxb/queryCount",
			dataType:"json",
			data:"ryid="+$("#ryid").val()+"&xxdm="+$("#xxdm").val()+"&sg="+$("#sg").val()+"&tz="+$("#tz").val()+"&txdm="+$("#txdm").val()+"&lxdm="+$("#lxdm").val()+"&zc="+$("#zc").val()+"&xh="+$("#xh").val()+"&tmtzms="+$("#tmtzms").val(),
			async:false,
			success:function(data){
				if(data && data != null && data != undefined && data == 1){
					$.messager.alert('确认对话框', '该体貌特征已存在！请重新输入', 'warning', function(){
						
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
		$("#dataForm").attr('action', contextPath + '/ryRytmtzxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/ryRytmtzxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	$(_p).find("input[name='id']").val($("#pk").val());
	setFormDataToSpan($("body"),_p);
}

function setFormDataToSpan(containObject,_p) {
	var inputSelector = containObject.find('input');
	$.each(inputSelector, function(index, object) {
		var element = $(object);
		var _type = element.attr('type');
		var _name = element.attr('name');
		var _comboname = element.attr('comboname');
		var _span = null;
		if (_name) {
			if (_type == "text" || _type =="hidden") {
				var _class = element.attr('class');
				if (_class != 'combo-value') {
					_span = $(_p).find("span[name='"+_name+"']");
					if (_span) {
						_span.text(element.val());
					}
				}
			}
		}
		if (_comboname) {
			var comboText = element.combo("getText");
			_span = $(_p).find("span[name='"+_comboname+"']");
			if (_span) {
				_span.text(comboText);
			}
		}
	});
	var textareaSelector = containObject.find('textarea');
	$.each(textareaSelector, function(index, object) {
		var element = $(object);
		var _name = element.attr('name');
		if (_name) {
			_span = $(_p).find("span[name='"+_name+"']");
			if (_span) {
				var spanHtml = element.val();
				spanHtml = spanHtml.replace(/\n/g, "<br>");
				_span.html(spanHtml);
			}
		}
	});
}

</script>
</html>
