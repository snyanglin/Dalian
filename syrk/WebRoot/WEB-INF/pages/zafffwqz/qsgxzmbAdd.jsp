<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亲属关系证明</title>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0; width:800px;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
<form action="<%=basePath%>qsgxzmb/saveQsgxzmb" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="ryid" id="ryid" value="${entity.ryid}" />
    	<input type="hidden" id="flag" value="${flag}">
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" id="table1">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明接收单位：</td>
				<td width="30%" class="dialogTd" colspan="3"><input  type='text' id='zmjsdw' name='zmjsdw' class="easyui-validatebox" style="width:613px;"
				 maxlength="50" value="${entity.zmjsdw}" /></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人身份证号：</td>
				<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox"  type="text" id="gmsfhm1" name="gmsfhm" style="width:200px;float:left;" 
				value="${entity.gmsfhm }" maxlength="30" 
		    		data-options="required:true,validType:['sfzh'],tipPosition:'right'" onblur="fzcyzjhm_onblur()" /><div class="lodingimg" id="yrjbxxDiv"></div></td>
				<td width="20%" class="dialogTd" align="right">证明人姓名：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='xm' name='xm' class="easyui-validatebox" style="width:200px;"
				data-options="required:false,tipPosition:'left'" maxlength="20" value="${entity.xm}" /></td>
			
			</tr>
			 <tr class="dialogTr">
			 	<td width="20%" class="dialogTd" align="right">证明人性别：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xb" value="${entity.xbdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'" /></td>	
				<td width="20%" class="dialogTd" align="right">证明人出生日期：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='csrq' name='csrq' class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.csrq}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" 
				 data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"/></td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">证明人居住地址：</td>
			 <td width="50%" class="dialogTd" colspan="2">
				  <input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_jzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
				    	<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/>
				  </td>
				<td width="30%" class="dialogTd" >
				<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type="hidden" name="dz_jzdzdm" id="dz_jzdzdm" value="${entity.dz_jzdzdm}"/>
				<input type="hidden" name="dz_jzdzssxdm" id="dz_jzdzssxdm" value="${entity.dz_jzdzssxdm}"/>
			    <input type='hidden' name='dz_jzdzxz' id="dz_jzdzxz" value="${entity.dz_jzdzxz}"/>
				</td>
			</tr>
			<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">开具日期：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='kjrq' name='kjrq' class="easyui-validatebox " style="width:200px;"  
				 maxlength="50" value="${entity.kjrq}"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/></td>
				<td width="20%" class="dialogTd" align="right">开具人：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='zmkjr' name='zmkjr' class="easyui-validatebox" style="width:200px;"
				maxlength="20" value="${entity.zmkjr}"  /></td>	
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">开具单位：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='zmkjdw' name='zmkjdw' class="easyui-validatebox" style="width:613px;"
				 maxlength="50" value="${entity.zmkjdw}" /></td>
			</tr>
			
			<tr id="xzqs" >
									<td class="toolbarTd" align="center" colspan="7" style="padding-right:8px" >
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add" onclick="addButton(this);" >新增亲属</a>
									</td>
								</tr>
	    	</table>
				   <table id="dq" class="easyui-datagrid" data-options="url: contextPath +'/qsgxzmb/queryQsList?id=${entity.id}',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'id',sortOrder:'asc',
            		fitColumns:false,
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	 <th data-options="field:'gmsfhm',width:200,align:'left',sortable:true,halign:'center'">身份证号</th>
				        	 <th data-options="field:'xm',width:170,align:'left',sortable:true,halign:'center'">姓名</th>
				        	 <th data-options="field:'ybrgxdm',width:160,align:'left',sortable:true,halign:'center',
				        	 formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_RYGX.js'">与本人关系</th>
				        	  <th data-options="field:'csrq',width:170,align:'left',sortable:true,halign:'center'">出生日期</th>
				           <!-- <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th> --> 
				        </tr>
				    </thead>
				</table>
	    </div>
    </form>
</div>
</div></div>
		<div style="height:6px;font-size:1px;"></div>
	    	  
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="backBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">退出</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="resetBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">重置</span>
					<span class="l-btn-icon icon-reset"> </span>
				</span>
			</a>
		</div>
</td>
</tr>
</table>
</div>
</body>
</html>
<script type="text/javascript" >

function processFormater(val, row, index) { // 自定义操作生成
	//return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">查看</a>&nbsp;'+
	//	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
}

function doInit(paramArray) {
	
}
function body_onload() {
	$('#dataform').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            //alert(data);  
        }  
    });   
    
} 
// 页面加载完成事件
window.onload = function() {
	body_onload();
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	document.getElementById("flag").value="update";
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
		setInputReadonly('zmjsdw', true);
		setInputReadonly('gmsfhm1', true);
		setInputReadonly('xm', true);
		setInputReadonly('xb', true);
		setInputReadonly('csrq',true);
		setInputReadonly('dz_jzdzxz',true);
		setInputReadonly('kjrq',true);
		setInputReadonly('zmkjr',true);
		setInputReadonly('zmkjdw',true);
	 var editUrl = contextPath + '/qsgxzmb/addQsgxrzb?qsgxid='+$("#pk").val();
		var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		
		var paramArray = [];
		//paramArray["qsgxid"] = ;//关系证明ID
		//alert(arr["saveID"]);
	//	paramArray["dwmc"] = "";//单位名称
		datagridAdd(obj, 'addWindow', 
					    		null,
					    		{
					    		title: '亲属关系',
					    		url: editUrl,
					    		width: 850,
					    		height: 320
					    		},
   								'您是否要保存数据？'
					    		);
	$('#xzqs').show();
}
//新增/查看
  function addButton(obj){
   var editUrl = contextPath + '/qsgxzmb/addQsgxrzb?qsgxid='+$("#pk").val();
		var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		
		var paramArray = [];
		paramArray["sfzh"]=$("#gmsfhm1").val();
		datagridAdd(obj, 'addWindow', 
					    		paramArray,
					    		{
					    		title: '亲属关系',
					    		url: editUrl,
					    		width: 850,
					    		height: 320
					    		},
   								'您是否要保存数据？'
					    		);
  }
function successCloseWindow(){
 return false;
}
function fzcyzjhm_onblur() {
	var su = true;
	var flag = $("#flag").val()+"";
	//if(flag=="update"){
		
	// }else{
	// 	$.ajax({
	//		async:false,
	//		type:"POST",
	//		url:"<%= basePath%>syrkgl/getQsgxzm",
	//		dataType:"json",
	//		data:"zjhm="+$("#gmsfhm1").val(),
	//		success:function(data){
	//		if (data && data.sfzhflag) {
	//				if(data.sfzhflag==true){
	//					su = false;
	//					alert("该人员已经添加过了");
	//					$("#gmsfhm1").val("").focus();
	//				}else {
	//			
	//				}
	//			}
	//		}
	//	});
	// }
	if(su&&(flag!="update")){
			$(".lodingimg").show();
		$.ajax({
			type:"POST",
			url:contextPath+"/ryRyjbxxb/dataApply",
			dataType:"json",
			data:"zjhm="+$("#gmsfhm1").val()+"&cyzjdm=111",
			success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xb").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#csrq").val(data.ryRyjbxxb.csrq);
			//	$("#jzd2").combobox("setValue",(data.ryRyjbxxb.dz_jzdzxz).substr((data.ryRyjbxxb.dz_jzdmlpxz).length));
			//	$("#dz_jzdzxz").val(data.ryRyjbxxb.dz_jzdzxz);
				$("#ryid").val(data.ryRyjbxxb.id);
			//	$("#jzd1").combobox("setValue",data.ryRyjbxxb.dz_jzdmlpxz);
			//	$("#dz_jzdzssxdm").val(data.ryRyjbxxb.dz_jzdzssxdm);
			//	$("#dz_jzdzdm").val(data.ryRyjbxxb.dz_jzdzdm);
			//	$("#dz_jzdzmlpdm").val(data.ryRyjbxxb.dz_jzdmlpdm);
			//	$("#dz_jzdzmlpxz").val(data.ryRyjbxxb.dz_jzdmlpxz);
			//	$("#csrq").validatebox('validate');
				
			}
			},
			complete:function(){
				$('#dataForm').form('validate');
				$(".lodingimg").hide();
			}
		});
	}
	
	return su;

		
}
$(document).ready(function(){
	initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
	var flag = $("#flag").val()+"";
	if(flag=="update"){
		setInputReadonly('zmjsdw', true);
		setInputReadonly('gmsfhm1', true);
		setInputReadonly('xm', true);
		setInputReadonly('xb', true);
		setInputReadonly('csrq',true);
		
		//setInputReadonly('csd',true);
		//setInputReadonly('jzd1',true);
		//setInputReadonly('jzd2',true);
		//setInputReadonly('sfxm',true);
		//setInputReadonly('smxm',true);
		setInputReadonly('kjrq',true);
		setInputReadonly('zmkjr',true);
		setInputReadonly('zmkjdw',true);
		$('#xzqs').show();
		$('#saveBotton').hide();
		$('#resetBotton').hide();
	}else{
		$('#xzqs').hide();
		$('#saveBotton').show();
	}
	$('#saveBotton').click(function(){
			if ($("#dataForm").form('validate')){
				topMessager.confirm('操作确认', '您是否保存亲属关系证明信息？',  function(r) {
					if (r) {									
						$('#dataForm').submit();
					}
				});
			}
		});
		
		$('#backBotton').click(function(){
			closeSelf();
		});
		$('#resetBotton').click(function(){
			 document.forms["dataForm"].reset();
			 	
			
		});
	
		
		
		
	$('#dataForm').form({  
	        onSubmit:function(){
	            return $(this).form('validate');  
	        },  
	        success:function(data){  
	            var json = $.parseJSON(data);
	            if(json.status != 'success'){
	            	topMessagerAlert(null,json.message);
	            }else{
	            	topMessagerShow(null,json.message);
	            	$("#pk").val(json.saveID); 
	            	if($("#pk").val()){
	            	setInputReadonly('zmjsdw', true);
					setInputReadonly('gmsfhm1', true);
					setInputReadonly('xm', true);
					setInputReadonly('xb', true);
					setInputReadonly('csrq',true);
					//setInputReadonly('jzd1',true);
				//	setInputReadonly('jzd2',true);
					setInputReadonly('kjrq',true);
					setInputReadonly('zmkjr',true);
					setInputReadonly('zmkjdw',true);
	            	$('#xzqs').show();
	            	$('#saveBotton').hide();
	            		var editUrl = contextPath + '/qsgxzmb/addQsgxrzb?qsgxid='+$("#pk").val();
		var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		
		var paramArray = [];
		//paramArray["qsgxid"] = ;//关系证明ID
		//alert(arr["saveID"]);
	//	paramArray["dwmc"] = "";//单位名称
		datagridAdd(obj, 'addWindow', 
					    		null,
					    		{
					    		title: '亲属关系',
					    		url: editUrl,
					    		width: 850,
					    		height: 320
					    		},
   								'您是否要保存数据？'
					    		);
	            	}
	            	var mainTabID='${mainTabID}'
	            	executeTabPageMethod(mainTabID, "reloadDg");
	            	///closeSelf();
	            	
	            }
	        }  
	    }); 
});
function dq(){
	var reloadUrl  = contextPath + '/qsgxzmb/queryQsList';
	var opt = $('#dq').datagrid('options');
	opt.url = reloadUrl;
	var id=$("#pk").val()+"";
	$('#dq').datagrid('load',{id:id});
}
function sfzh(){
	var sfzh=$("#gmsfhm1").val()+"";
	return sfzh;
}
</script>