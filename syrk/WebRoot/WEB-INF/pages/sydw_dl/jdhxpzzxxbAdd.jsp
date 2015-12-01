<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>剧毒化学品资质信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>jdhxpzzxxb_dl/save" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
    		<input type="hidden" name="flag" id="flag" value="${flag}" />
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" id="dwmc" style="width:628px;" readonly="readonly" /></td>
		  	</tr>
		   <tr class="dialogTr">
		    <td width="20%" class="dialogTd" align="right">资质证件名称：</td>
				<td width="30%" class="dialogTd"><input class='easyui-validatebox ' data-options="required:true ,tipPosition:'right'" type='text' 
					name='zzzjmc' maxlength="30" style="width:200px;" value="${entity.zzzjmc}" />
				</td>
				<td width="20%" class="dialogTd" align="right">资质证件编号：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox"  data-options="required:true,validType:['letterOrNum'],tipPosition:'left'" type="text" id="zzzjbh" name="zzzjbh" maxlength="100" style="width:200px;" value="${entity.zzzjbh}"/>
				</td>
		    </tr>
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">资质证件批准机关：</td>
				<td width="80%" class="dialogTd"  colspan="3">
					<input class="easyui-validatebox" type="text" data-options="required:true ,tipPosition:'left'" id="zzzjpzjg" name="zzzjpzjg" style="width:628px;" value="${entity.zzzjpzjg}" maxlength="50"/>
				</td>
			</tr>
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">资质证件起始时间：</td>
				<td width="30%" class="dialogTd">
				<input type="text" name="qfrq" id="qfrq" class="easyui-validatebox" style="width: 200px;" value="${entity.qfrq}"  
				data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" 
				data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'jzrq\') }'})"/>
				</td>
				<td width="20%" class="dialogTd" align="right">资质证件有效时间：</td>
				<td width="30%" class="dialogTd">
				<input type="text" name="jzrq" id="jzrq" class="easyui-validatebox" style="width: 200px;" value="${entity.jzrq}"  
				data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'qfrq\') }'})"/></td>
			</tr>
			
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p ;
function doInit(paramArray) {
	document.getElementById("dwmc").value = paramArray["dwmc"];
	_p = paramArray["_p"];
}
function beforeSubmit() {
	var ifExist = false;
	var flag =document.getElementById("flag").value;
	if(flag=="add"){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>sydwgl_dl/checkIfExistByCol",
		async:false,
		dataType:"json",
		data:{colMap:'{\'tableName\':\'dw_jdhxpzzxxb\',\'colList\':[{\'colName\':\'zzzjbh\',\'colValue\':\''+$('#zzzjbh').val()+'\'},{\'colName\':\'xt_zxbz\',\'colValue\':\'0\'}]}'},
		success:function(data){
			if (data && data.count > 0) {
				$.messager.alert("提示","资质证件编号已存在,请重新输入","",
				function(){
					$('#zzzjbh').val('');
					$('#zzzjbh').focus();
				});
				ifExist = true;
			}
		}
	});
	}else {
		
	}
	if(ifExist){
		return false;
	}else {
		return true;
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