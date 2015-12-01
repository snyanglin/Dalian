<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位重要部位</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwzybw_dl/save" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid }" />
    
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<input type="hidden" name="id" id="pk" value="${entity.id }" />
	    	<input type="hidden" name="flag" id="flag" value="${flag}"/>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" id="dwmc" style="width:618px;" readonly="readonly" /></td>
		    </tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部位名称：</td>
		    	<td width="80%" class="dialogTd" colspan='3'>
		    	<input class="easyui-validatebox" 
		    	data-options="required:true,validType:['maxLength[30]'],tipPosition:'left'" type="text" name="zybwmc" id="bwmc" value="${entity.zybwmc}" style="width:618px;" maxlength="30" /></td>
		    </tr>
		    
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部位位置：</td>
		    	<td width="80%" class="dialogTd" colspan='3'><input class="easyui-validatebox" type="text"  name="zybwwz"  id="bwwz" value="${entity.zybwwz}" maxlength="100" 
		    	data-options="required:true,validType:['maxLength[100]'],tipPosition:'left'" style="width:618px;"/></td>
		    </tr>		    
		    
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">物防设施情况：</td>
				<td width="80%" class="dialogTd" colspan='3'>
				<textarea id="wfssqk" name="wfssqk" class="easyui-validatebox" style="width: 618px; height:50px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'物防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.wfssqk}</textarea>
				
				</td>
			 </tr>	
			 
			 <tr>	    
				<td width="20%" class="dialogTd" align="right">技防设施情况：</td>
				<td width="80%" class="dialogTd" colspan='3'>
				<textarea id="jfssqk" name="jfssqk" class="easyui-validatebox" style="width: 618px; height:50px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.jfssqk}</textarea>
				</td>
			</tr>
			<tr>	    
				<td width="20%" class="dialogTd" align="right">重要部位描述：</td>
				<td width="80%" class="dialogTd" colspan='3'>
				<textarea id="zybwms" name="zybwms" class="easyui-validatebox" style="width: 617px; height:50px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'重要部位描述不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zybwms}</textarea>
				</td>
			</tr>
			<tr>	    
				<td width="20%" class="dialogTd" align="right">确定理由依据：</td>
				<td width="80%" class="dialogTd" colspan='3'>
				<textarea id="qdlyyj" name="qdlyyj" class="easyui-validatebox" style="width: 617px; height:50px;"maxlength="1000"
					data-options="validType:['maxLength[1000]'],invalidMessage:'重要部位描述不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.qdlyyj}</textarea>
				</td>
			</tr>
			
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">确定时间：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="qdsj" id="qdsj" value="${entity.qdsj}"
		    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'" 
		    		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"
		    			 style="width: 200px;"
		    	 /></td>
		    </tr>
		    


			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">责任人证件类型：</td>
		    	<td width="30%" class="dialogTd"><input  type="text" name="fzr_cyzjdm"  id="zjlx"  value="${entity.fzr_cyzjdm}" class="easyui-combobox inputreadonly"
		    	style="width: 200px;"
		    		data-options="required:false,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:setPassPort,
		    		onSelect:function(record){
						if(record.id==111||record.id==112||record.id==335){
							$('#zjhm').validatebox({validType:['sfzh']});
						}else  {
							$('#zjhm').validatebox({validType:['maxLength[30]']});
						}
					}"
		    	 /></td>
		    	 
		    	<td width="20%" class="dialogTd" align="right">责任人证件号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="fzr_zjhm" id="zjhm" maxlength="30" value="${entity.fzr_zjhm}"
		    		data-options="required:false,tipPosition:'left'"    style="width: 200px;float:left;"/><div class="lodingimg" id="yrjbxxDiv"></div></td>
		    </tr>			

			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">责任人姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="fzr_xm" id="fzrxm" maxlength="20"  value="${entity.fzr_xm}"
		    		data-options="required:false,validType:['maxLength[20]']" style="width: 200px;"
		    	 /></td>
		    	 
		    	<td width="20%" class="dialogTd" align="right">责任人性别：</td>
		    	<td width="30%" class="dialogTd"><input  class="easyui-combobox" type="text" name="fzr_xbdm" id="fzrxbdm" 
		    		data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"
		    		  style="width:200px;"/></td>
		    </tr>			
		    
		    <tr class="dialogTr">
		    
		    	<td width="20%" class="dialogTd" align="right">责任人联系电话：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="fzr_lxdh" id="fzrlxdh" maxlength="18"   value="${entity.fzr_lxdh}"
		    		data-options="required:false,validType:['phone','maxLength[18]'],tipPosition:'right'"    style="width: 200px;"/></td>
		    		
		    		
		    	<td width="20%" class="dialogTd" align="right">责任人职务：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="fzr_zwmc" id="fzrzw" maxlength="20" value="${entity.fzr_zwmc}"
		    		data-options="required:false,validType:['maxLength[20]'],tipPosition:'left'"
		    		style="width: 200px;"
		    	 /></td>
		    	 
		    	
		    </tr>			
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _zjhm = "";
function doInit(paramArray) {
	$("#dwmc").val(paramArray["dwmc"]);
	$("#fzrxbdm").combobox("setValue","${entity.fzr_xbdm}");

	$("#jfssqk").val("${entity.jfssqk}");
	$("#wfssqk").val("${entity.wfssqk}");
	var flag = document.getElementById("flag").value;
	if(flag=="add"){
		$("#zjlx").combobox("setValue","111");
	}
	
	
}
$(document).ready(function(){
	$("#zjhm").bind("blur",function(e){	check();});
});
/**根据证件类型 设置证件号码验证 与人员基本信息只读状态*/
function setPassPort(newVal,oldVal){
	if(newVal==""){
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if (!newVal) {
		return;
	}
	if(newVal=="111"||newVal=="112"||newVal=="335"){
		$("#zjhm").validatebox({validType:['sfzh']});
	} else  {
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	clearRyjbxx();
	$("#zjhm").val("");
	_zjhm = "";
}
/**
 * 根据证件类型与号码 ，进行人员比对，复用
 */
function check(){
	
	if(!$("#zjhm").validatebox("isValid")){
		return;
	}
	
	
	if($("#zjhm").val() == _zjhm){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#zjlx").val(),
		success:function(data){
			if (data && data.ryjbxxb) {
				$("#fzrxm").val(data.ryjbxxb.xm);
				$("#fzrxbdm").combobox("setValue",data.ryjbxxb.xbdm);
				$("#fzrlxdh").val(data.ryjbxxb.lxdh);
				$("#fzrzw").val(data.ryjbxxb.zw);
				if(data.ryjbxxb.xm != ""){
					setInputReadonly("fzrxm", true);
				}
				if(data.ryjbxxb.xbdm != ""){
					setInputReadonly("fzrxbdm", true);
				}
				if(data.ryjbxxb.lxdh != ""){
					setInputReadonly("fzrlxdh", true);
				}
				if(data.ryjbxxb.zw != ""){
					setInputReadonly("fzrzw", true);
				}
				
			}else {
				clearRyjbxx();
			}
		},
		complete:function(){
			_zjhm = $("#zjhm").val();
			$(".lodingimg").hide();
		}
	});	
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
function clearRyjbxx(){
	$("#fzrxm").val("");
	$("#fzrxbdm").combobox("clear");
	$("#fzrlxdh").val("");
	$("#fzrzw").val("");
}
function resetTable(){
	$("#bwmc").val("");
	$("#bwwz").val("");
	$("#wfssqk").val("");
	$("#jfssqk").val("");
	$("#qdsj").val("");
	$("#qdlyyj").val("");
	$("#zjhm").val("");
	$("#zjlx").combobox("clear");
	$("#fzrxm").val("");
	$("#fzrxbdm").combobox("clear");
	$("#fzrlxdh").val("");
	$("#fzrzw").val("");
	$("#zybwms").val("");
	$("#zjlx").combobox("setValue","111");
	setInputReadonly("fzrxm", false);
	setInputReadonly("fzrxbdm", false);
	setInputReadonly("fzrlxdh", false);
	setInputReadonly("fzrzw", false);
}
</script>