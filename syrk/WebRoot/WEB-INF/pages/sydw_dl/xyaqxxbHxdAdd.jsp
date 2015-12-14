<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>护校队信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>xyaqxxbHxd_dl/saveXyaqxxbHxd" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="xyid" name="xyid" value="${entity.xyid}" />
    	<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}" />
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件类型：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zjlxdm" name="zjlxdm" style="width:200px;" value="${entity.zjlxdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zjhmCheck" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
			    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm }" maxlength="30" 
			    		data-options="required:true,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div></td>
		    	</tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xm" name="xm" style="width:200px;" value="${entity.xm }" maxlength="20" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${entity.xbdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;" value="${entity.lxdh }" maxlength="18"
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
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
	
	if($("#zjlxdm").combobox("getValue") == ""){
		$("#zjlxdm").combobox("setValue","111");
	}

	//人员信息复用
	$("#zjhm").bind("blur",function(e){ checkRyxx(); });
	zjhmCheck($("#zjlxdm").combobox("getValue"),"")
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
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
		var id="${entity.id}";
		if(id == ""){
			clearRyxx();
		}
		
		_zjhm = "";
	}
	  

}

/**
 * 人员基本信息复用人员基本信息表
 */
function checkRyxx(){
	
	if($("#zjhm").val() == _zjhm){
		return;
	}
	if(!$("#zjhm").validatebox("isValid")){
		return;
	}
	
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#zjlxdm").val(),
		success:function(data){
			if (data && data.ryjbxxb) {
				$("#ryid").val(data.ryjbxxb.id);
				$("#xm").val(data.ryjbxxb.xm);
				$("#xbdm").combobox("setValue",data.ryjbxxb.xbdm);
				$("#lxdh").val(data.ryjbxxb.lxdh);
				$("#xm").validatebox("isValid");
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
	$("#xm").val("");
	$("#xbdm").combobox("setValue","");
	$("#lxdh").val("");
}

</script>