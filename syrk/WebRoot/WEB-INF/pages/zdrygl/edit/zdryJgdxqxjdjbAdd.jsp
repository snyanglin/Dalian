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
	    <input type='hidden' name='zdryJgdxqxjdjb.id' id="pk" value="${entity.zdryJgdxqxjdjb.id}" />
	    <input type="hidden" id="zdryid" name="zdryJgdxqxjdjb.zdryid" value="${entity.zdryJgdxqxjdjb.zdryid}" />

	    <table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
			<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">重点人员姓名：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="xm" name="xm" style="width:200px;" readonly="readonly"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">重点人员身份号码：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" name="zjhm" style="width:200px;" readonly="readonly"/>
		    	</td>
	    	</tr>
	 		<tr class="dialogTr">
			  	<td width="20%" class="dialogTd" align="right">请假原因：</td>
			  	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryJgdxqxjdjb.qjyy" id="qjyy" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'请假原因不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zdryJgdxqxjdjb.qjyy}</textarea>
				</td>
			</tr> 
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">请假日期：</td>
			    <td width="30%" class="dialogTd">
			    	<input type="text" name="zdryJgdxqxjdjb.qjrq" id="qjrq" class="easyui-validatebox" style="width: 200px;" value="${entity.zdryJgdxqxjdjb.qjrq }"
			     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'yjfh_rq\') }'})" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/>
			    </td>
	    		<td width="20%" class="dialogTd" align="right">去往地行政区划：</td>
			    <td width="30%" class="dialogTd">
			    	<input type="text" name="zdryJgdxqxjdjb.qwxzqhdm" id="qwxzqhdm" value="${entity.zdryJgdxqxjdjb.qwxzqhdm}" class="easyui-combobox" style="width:200px;"
	    				data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',required:true,
							valueField:'id',textField:'text',selectOnNavigation:false,tipPosition:'left'">
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">去往地详址：</td>
			    <td width="80%" class="dialogTd" colspan="3">
			    	<input type="text" name="zdryJgdxqxjdjb.qwxz" id="qwxz" class="easyui-validatebox" maxlength="100" style="width: 618px;" value="${entity.zdryJgdxqxjdjb.qwxz }"/>
			    </td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">预计返回日期：</td>
			    <td width="80%" class="dialogTd" colspan="3">
			    	<input type="text" name="zdryJgdxqxjdjb.yjfh_rq" id="yjfh_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.zdryJgdxqxjdjb.yjfh_rq}" 
			    		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'qjrq\') }'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
			    </td>
	    	</tr>
	 		<tr class="dialogTr">
			  	<td width="20%" class="dialogTd" align="right">备注：</td>
			  	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryJgdxqxjdjb.bz" id="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zdryJgdxqxjdjb.bz}</textarea>
				</td>
			</tr> 
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">请假审批结果：</td>
			    <td width="80%" class="dialogTd" colspan="3">
			   		<input class="easyui-combobox" type="text" id="spjg" name="zdryJgdxqxjdjb.spjg" style="width:200px;" value="${entity.zdryJgdxqxjdjb.spjg}"
					data-options="url: contextPath + '/common/dict/D_GG_SPJG.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					<span id="spjgSpan"></span>
			    </td>
	    	</tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">请假审批意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" id="spyj" name="zdryJgdxqxjdjb.spyj" style="width: 618px;" value="${entity.zdryJgdxqxjdjb.spyj}" data-options="required:false,validType:['maxLength[100]','unnormal'],tipPosition:'left'"/>
		    	</td>
		   	</tr>
		   	<tr>
		   	<td width="20%" class="dialogTd" align="right">请假审批日期：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" name="zdryJgdxqxjdjb.spsj" id="spsj" style="width: 200px;" value="${entity.zdryJgdxqxjdjb.spsj}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">请假审批人：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" name="zdryJgdxqxjdjb.spr_xm" id="spr_xm" style="width: 200px;" maxlength="20" value="${entity.zdryJgdxqxjdjb.spr_xm}"/>
					<input type="hidden" name="spr_id" id="spr_id" value="${entity.zdryJgdxqxjdjb.spr_id}"/>
				</td>
		    </tr>
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">实际返回日期：</td>
			    <td width="30%" class="dialogTd"><input type="text" name="zdryJgdxqxjdjb.sjfh_rq" id="sjfh_rq" class="easyui-validatebox"  value="${entity.zdryJgdxqxjdjb.sjfh_rq}"
			    								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'#F{$dp.$D(\'qjrq\') }'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" style="width: 200px;"/></td>
			   	<td width="20%" class="dialogTd" align="right">销假日期：</td>
			    <td width="30%" class="dialogTd"><input type="text" name="zdryJgdxqxjdjb.xjrq" id="xjrq" class="easyui-validatebox" style="width: 200px;"  value="${entity.zdryJgdxqxjdjb.xjrq}"
  											    onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'#F{$dp.$D(\'sjfh_rq\') }'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" /></td>
	    	</tr>
		  <!--   <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">流程图:</td>
		    	<td width="30%" class="dialogTd" colspan="3"><a href="#" onclick="viewWorkflowDialog();">查看</a> </td>		    	
		    </tr> -->
	    </table>
	    
	</form>

</body>

<script type="text/javascript">

function doInit(paramArray) {
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);
	initComboBox('qwxzqhdm', contextPath + '/common/dict/GB_D_XZQHDMLIST.js'); 
	
	setInputReadonly('spjg',true);
	setInputReadonly('spsj',true);
	setInputReadonly('spr_xm',true);
	setInputReadonly('spyj',true);
	if($("#spjg").val() == "1"){
		$("table input,textarea").each(function(){
			if($(this).attr("id")!="sjfh_rq"&&$(this).attr("id")!="xjrq")
				setInputReadonly($(this).attr("id"),true);
		});
	}
	if($("#spjg").val()==""){
		if($("#pk").val() == ""){	
			setInputReadonly('sjfh_rq',true);
			setInputReadonly('xjrq',true);
		}else{
			$("table input,textarea").each(function(){
				setInputReadonly($(this).attr("id"),true);
			});
		}
	}
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryJgdxqxjdjb/save');
	/* }else if($("#spjg").val() != "0"){
	 	return false;*/
	}else{
		if($("#spjg").val()==""){ return false ;}
		
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/zdryJgdxqxjdjb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	parent.location.reload();
}
function viewWorkflowDialog(){
	var zdrygllxdm = $("#zdrygllxdm").val();
	var processDefinitionKey =null;
	$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>wf/getProcDefId/3/" + zdrygllxdm,
		dataType:"json",
		success:function(data){
			if (data && data.length>0) {
				processDefinitionKey = data;
				var url = '/syrk/diagram/diagram/' + processDefinitionKey;
				var result=window.open(url,'_blank','modal=yes,height=600px,width=900px,resizable=yes,z-look=yes,alwaysRaised=yes'); 
				window.onfocus=function (){result.focus();};
			}else{
				alert("Workflow is not found.");
			}				
		}
	});   
	
}
</script>
</html>

