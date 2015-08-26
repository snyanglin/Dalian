<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%
String  rfid="";
rfid = request.getParameter("rfid");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人防成员</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=contextPath%>/js/zafffwqz/rf.js"></script>
	<script type="text/javascript">
	var rfid = "<%=rfid%>";
	if(rfid=="" || rfid==null && typeof(rfid)=="undefined"){
		rfid="###########";
	}
	</script>
  </head>
  
  <body class="easyui-layout" data-options="fit:true" onload="initDg()">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'人防成员',border:true" style="height:400px">
  			<table id='cydg' iconCls="icon-edit" ></table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<table border="0" cellpadding="0" cellspacing="0" width="100%"	align="center">
						<tr>
							<td>
								<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="rfcyAdd();">新增</a>
							</td>
							<!-- 
							<td>
								<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="rfcySave();">保存</a>
							</td>
							 -->
						</tr>
					</table>
				</div>
  </div>
  </div>
  </div>
  
  <div id="cancel" class="easyui-window" title="人防成员添加" style="width:650px;height:310px"   
        data-options="iconCls:'icon-save',
        modal:true,
        closed:true,
        collapsible:false,
        minimizable:false,
        maximizable:false"> 
        <form id="cyryForm" >
        <table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%" align="left" style="margin:0px;padding:0px;padding-right:20px;">
					
					<input type="hidden" name="rfid" id="rfid" value="">
					<input type="hidden" name="ryid" id="ryid" value="">
			   		<tr class="dialogTr" style="height:15px">
				    	<td width="10%" class="dialogTd" align="right">常用证件：</td>
				    	<td width="30%" class="dialogTd" align="left"><input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" value="${entity.cyzjdm}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:zjhmCheck"/></td>
			    	
			    		<td width="30%" class="dialogTd" align="center">证件号码：</td>
				    	<td width="30%" class="dialogTd" align="left"><input type="text" name="zjhm" id ="zjhm" value="${entity.zjhm}" 
				    	class="easyui-validatebox" data-options="required:true,tipPosition:'left'"  style="width:200px;" />
				    	<span class="lodingimg" id="jbxxLoadDiv"></span></td>
			    	</tr>	
			    	
			    	<tr class="dialogTr" style="height:15px">
				    	<td width="20%" class="dialogTd" align="right">姓名：</td>
				    	<td width="30%" class="dialogTd" align="left"><input type="text" name="xm" id="xm" value="${entity.xm}" 
				    	class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  style="width:200px;" /></td>
			    		
			    		<td width="20%" class="dialogTd" align="right">性别：</td>
				    	<td width="30%" class="dialogTd" align="left"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" value="${entity.xbdm}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
			    	</tr>	

			    	<tr class="dialogTr" style="height:15px">
			    		<td width="30%" class="dialogTd" align="right">出生日期：</td>
		    	 		<td width="70%" class="dialogTd" colspan='3' align="left"><input class="easyui-validatebox" type="text" id="csrq" name="csrq" value="" style="width:200px;" 
		    	 			data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
			    	</tr>
			    				    	
	    	       <tr class="dialogTr" style="height:15px">
	    	       		<td width="20%" class="dialogTd" align="right">居住地址：</td>
			    		<td class="dialogTd" width="50%" colspan="2" align="left">
				    		<input class="easyui-combobox" id="jzd1" style="width:200px;" value="${entity.dz_jzdzmlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,tipPosition:'left'">
				    		<input type='hidden' name='dz_ffzrrjzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
				    		<input type='hidden' name='dz_ffzrrjzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/>
				    	</td>
				    	
				    	<td class="dialogTd" width="20%" >
				    		<input class="easyui-combobox" id="jzd2" style="width:150px;" value="${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz,'')}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,tipPosition:'left'">
				    		<input type='hidden' name='dz_jzdzdm' id="dz_jzdzdm" value="${entity.dz_jzdzdm}"/>
				    		<input type='hidden' name='dz_jzdzssxdm' id="dz_jzdzssxdm" value="${entity.dz_jzdzssxdm}"/>
				    		<input type='hidden' name='dz_jzdzxz' id="dz_jzdzxz" value="${entity.dz_jzdzxz}"/>
			    	</td>
	
			    		    	
	       <tr style="height:15px">
	       		<td align="right" colspan="4">
	       			<a id="icon-ok" class="easyui-linkbutton" iconCls="icon-ok" >确定</a>
					<a class="easyui-linkbutton" iconCls="icon-reset" onclick="clearCase()">重置</a>
					<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('cancel');">关闭</a>&nbsp;
	       		</td>
	       </tr>
        </table>
        </form>
</div> 
<script type="text/javascript">
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}


function closeWindow(obj){
	$("#"+obj).window("close");
	$('#cydg').datagrid('unselectAll'); 
}
function clearCase(){
	  $("#cyryForm").form("reset");
	  setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	$("#cyzjdm").combobox('setValue', '111');
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}


function addRfry(){
	var addUrl = contextPath + '/rfxx/saveRfcyxx';
	
	var rfid = $("#rfid").val();
	var ryid = $("#ryid").val();
	var xm = $("#xm").val();
	var zjhm = $("#zjhm").val();
	var csrq = $("#csrq").val();
	var xbdm = $("#xbdm").combobox('getValue');
	var cyzjdm = $("#cyzjdm").combobox('getValue');
	
	var dz_ffzrrjzdzmlpdm = $("#dz_ffzrrjzdzmlpdm").val();
	var dz_jzdzmlpxz = $("#dz_jzdzmlpxz").val();
	var dz_jzdzdm = $("#dz_jzdzdm").val();
	var dz_jzdzssxdm = $("#dz_jzdzssxdm").val();
	var dz_jzdzxz = $("#dz_jzdzxz").val();
	
	$.ajax({
		url: addUrl,
		type: 'POST',
		data: {
			ryid:ryid,
			xm:xm,
			zjhm:zjhm,
			csrq:csrq,
			xbdm:xbdm,
			cyzjdm:cyzjdm,
			dz_ffzrrjzdzmlpdm:dz_ffzrrjzdzmlpdm,
			dz_jzdzmlpxz:dz_jzdzmlpxz,
			dz_jzdzdm:dz_jzdzdm,
			dz_jzdzssxdm:dz_jzdzssxdm,
			dz_jzdzxz:dz_jzdzxz,
			rfid:rfid}
	}).done(function(result) {
		$('#cydg').datagrid('load');  
		$('#cydg').datagrid("clearSelections");
		$("#cancel").window("close"); 
	});
	
}

function doEdit(linkObject, index){
	var rows = $('#cydg').datagrid('getData');
	var rowData = rows.rows[index];
	$("#cancel").window("open"); 
	
	var xm = $("#xm").val(rowData.xm);
	var zjhm = $("#zjhm").val(rowData.zjhm);
	var csrq = $("#csrq").val(rowData.csrq);
	var xbdm = $("#xbdm").combobox('setValue',rowData.xbdm);
	var cyzjdm = $("#cyzjdm").combobox('setValue',rowData.cyzjdm);
	if(rowData.cyzjdm==""){
		$("#cyzjdm").combobox('setValue', '111');
	}
	
}

//删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/rfxx/deleteRfcyxx';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要注销数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

$(document).ready(function(){
	if(rfid!="" && rfid!=null && typeof(rfid)!="undefined"){
		$("#rfid").val(rfid);
	}
	initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
	
	$("#zjhm").bind("blur",function(e){	
		checkZjhm();
	})
});

//验证证件号码
function zjhmCheck(newValue, oldValue){
	if (!newValue) {
		return;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue == "112" || newValue == "335"){ 
		$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearValues();
}

function clearValues(){
	 $("#ryid").val("");
	 $("#xm").val("");
	 $("#zjhm").val("");
	 $("#csrq").val("");
	 $("#xbdm").combobox('setValue',"");
	
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
}

function checkZjhm() {
	if (!$("#cyzjdm").combo("isValid")){
		return;
	}
	if (!$("#zjhm").validatebox("isValid")){
		return;
	}
	var _zjhm = $("#zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if($("#zjhm").val() == _zjhm){
		return;
	}
	
	$("#jbxxLoadDiv").show();
	$.ajax({
		type:"POST",
		url:contextPath+"/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#cyzjdm").val(),
		success:function(data) {
			if (data && data.ryRyjbxxb) {
					var ryid = $("#ryid").val(data.ryRyjbxxb.id);
					var xm = $("#xm").val(data.ryRyjbxxb.xm);
					var zjhm = $("#zjhm").val(data.ryRyjbxxb.zjhm);
					var csrq = $("#csrq").val(data.ryRyjbxxb.csrq);
					var xbdm = $("#xbdm").combobox('setValue',data.ryRyjbxxb.xbdm);
					var cyzjdm = $("#cyzjdm").combobox('setValue',data.ryRyjbxxb.cyzjdm);
					if(data.ryRyjbxxb.cyzjdm==""){
						$("#cyzjdm").combobox('setValue', '111');
					}
				}else{
					clearValues();
				}
		},
		complete:function() {
			setInputReadonly("xm", true);
			setInputReadonly("csrq", true);
			setInputReadonly("xbdm", true);
			$("#jbxxLoadDiv").hide();
		}
	});
}

</script>  
  </body>
</html>
