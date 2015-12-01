<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校车信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>xyaqxxbXc_dl/saveXyaqxxbXc" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="xyid" name="xyid" value="${entity.xyid}" />
    	<input type="hidden" id="lxdh" name="lxdh"/>
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				 <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">校车号牌：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xcjdchphm" name="xcjdchphm" style="width:200px;" value="${entity.xcjdchphm }" maxlength="20" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">自有或租赁：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zyhzl" name="zyhzl" style="width:200px;" value="${entity.zyhzl }"
						data-options="url: contextPath + '/common/dict/D_DW_ZYHZL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left',onChange:onChangeZyhzl"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">核定载人数：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="hdzrs" name="hdzrs" style="width:200px;" value="${entity.hdzrs }" maxlength="20" 
			    		data-options="validType:'naturalNumber',required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">注册日期：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zcrq" name="zcrq" style="width:200px;" value="${entity.zcrq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">专用标志编号：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zybzbh" name="zybzbh" style="width:200px;" value="${entity.zybzbh }" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">检验有效期：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jyyxq" name="jyyxq" style="width:200px;" value="${entity.jyyxq }"
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">驾驶人证件类型：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jsrzjlxdm" name="jsrzjlxdm" style="width:200px;" value="${entity.jsrzjlxdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:zjhmCheck" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">驾驶人证件号码：</td>
			    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="jsrzjhm" name="jsrzjhm" style="width:200px;float:left;" value="${entity.jsrzjhm }" maxlength="30" 
			    		data-options="required:false,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div></td>
		    	</tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">驾驶人姓名：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jsrxm" name="jsrxm" style="width:200px;" value="${entity.jsrxm }" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">驾驶人联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jsrlxdh" name="jsrlxdh" style="width:200px;" value="${entity.jsrlxdh }" maxlength="18"
			    		data-options="validType:['phone'],required:false,tipPosition:'left'" />
			    	</td>
			    </tr>
			    <tr class="dialogTr" id="tr_zldw">
			    	<td width="20%" class="dialogTd" align="right">租赁单位：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input type="hidden" id="zldwid" name="zldwid" value="${entity.zldwid}" />
			    	<input type='hidden' name='zldwmc' id="zldwmc" value="${entity.zldwmc}"/>
			    	<input class="easyui-combobox" type="text" id="zldw-box" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" name="zldw-box" value="${entity.zldwmc}" maxlength="50" style="width:628px;"/></td>
		    	</tr>
			    <tr class="dialogTr" id="tr_zldwdh">
			    	<td width="20%" class="dialogTd" align="right">租赁单位电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zldwlxdh" name="zldwlxdh" style="width:200px;" value="${entity.zldwlxdh }" maxlength="18"
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">租赁单位法人：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zldwfrdbxm" name="zldwfrdbxm" style="width:200px;" value="${entity.zldwfrdbxm }"
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p ;
var _zjhm = "";
function doInit(paramArray) {
	_p = paramArray["_p"];
	
	if($("#jsrzjlxdm").combobox("getValue") == ""){
		$("#jsrzjlxdm").combobox("setValue","111");
	}

	//人员信息复用
	$("#jsrzjhm").bind("blur",function(e){ checkRyxx(); });
	
	//编辑时，根据【自有或租赁】切换租赁相关属性显示
	if($('#zyhzl').combobox('getValue') == '1'){
		onChangeZyhzl('1', null);
	}
}

$(document).ready(function(){
	initDepartmentSearch('zldw-box', {glpcsid: ''}, 'zldwid', 'zldwmc', {lxdh:'lxdh'}, 'afterSelectDw');
});

function afterSelectDw(dwComboID){
	$('#zldwlxdh').val($('#lxdh').val());
}

function onChangeZyhzl(newVal, oldVal){
	if(newVal == '1'){
		$('#tr_zldw').hide();
		$('#tr_zldwdh').hide();
		$('#zldwid').val("");
		$('#zldwmc').val("");
		$('#zldw-box').combobox('setValue', '');
		$('#zldwlxdh').val("");
		$('#zldwfrdbxm').val("");
	}else if(newVal == '2'){
		$('#tr_zldw').show();
		$('#tr_zldwdh').show();
	}
}

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	//$("#dataForm")[0].reset();
}

//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#jsrzjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#jsrzjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#jsrzjhm").validatebox({validType:['maxLength[30]']});
		clearRyxx();
		$("#jsrzjhm").val("");
		_zjhm = "";
	}
	
}

/**
 * 人员基本信息复用人员基本信息表
 */
function checkRyxx(){
	
	if($("#jsrzjhm").val() == _zjhm){
		return;
	}
	if(!$("#jsrzjhm").validatebox("isValid")){
		return;
	}
	
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#jsrzjhm").val()+"&cyzjdm="+$("#jsrzjlxdm").val(),
		success:function(data){
			if (data && data.ryjbxxb) {
				$("#ryid").val(data.ryjbxxb.id);
				$("#jsrxm").val(data.ryjbxxb.xm);
				$("#jsrlxdh").val(data.ryjbxxb.lxdh);
			}else{
				clearRyxx();
			}
		},
		complete:function(){
			$("#yrjbxxDiv").hide();
		}
	});
}

//清空复用的人员基本信息
function clearRyxx(){
	$("#ryid").val("");
	$("#jsrxm").val("");
	$("#jsrlxdh").val("");
}

</script>