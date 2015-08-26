<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryAdd.js"></script>
<title>重点人员列撤管</title>
</head>

<body style="margin-top:20px; margin-bottom:10px" class="bodybg" onload="startup()">
<div data-options="region:'center',split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc"> 
 		<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">

    <form action="<%=basePath%>zdryzb/saveLg"  id="dataFormZdry" name="dataFormZdry" method="post" enctype="multipart/form-data">    	
    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdryZdryzbVO.id}" />
    	<input type="hidden" id="zdryLczywblb.ywblr_id" name="zdryLczywblb.ywblr_id" value="${zdryLczywblb.ywblr_id}" />
    	<input type="hidden" id="zdryHsbId" name="zdryHsbId" value="${zdryHsbId}" />
    	<input type="hidden" id="syrkid" name="zdryZdryzb.syrkid" value="" />
    	<input type="hidden" id="ryid" name="zdryZdryzb.ryid" value="" />
    	
	    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="xm" style="width:200px;" readonly="readonly"  value="${zdryZdryzbVO.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="zjhm" name="zjhm" style="width:200px;" readonly="readonly" value="${zdryZdryzbVO.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr">
		    	<td colspan="4" align="center">
		    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="querySyrk()">查询实有人口</a>		    	
		    	</td>		    	
		    </tr>
		    		     
		    <tr class="dialogTr" style="display:none" id="ylglxTr">
	    		<td width="20%" class="dialogTd" align="right">已列管类型：</td>
	    		<td width="80%" class="dialogTd" colspan="3" id="ylglx">
	    		
		    	</td>
		    </tr>		    

		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员类型：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
					<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm"   style="width:200px;" value=""
					data-options="url: contextPath +'/zdryzb/queryZdryTopLbList',  
					valueField:'lbdm',textField:'bz',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zdrylxChange"/>

	    			<input type="text" name="zdryZdryzb.zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:400px;"
	    			data-options="onlyLeaf:true,valueField:'lbdm',textField:'bz',
	    			multiple:false,required:true,panelWidth:400,method:'get',lines:true,tipPosition:'left'" >
		    	</td>
		    </tr>
		    
		    </table>
 		<!-- 这里引用公用列管信息模块 -->
		    <%@include file="/WEB-INF/pages/zdrygl/add/zdryLgLxInc.jsp"%>
		     <!-- 列管公共信息 -->
	    	<table id="ggDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;">
	    	
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgrqText">申请日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ywclsj" id="ywclsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="${applyUser}" readonly="readonly" /></td>
		    	<td width="20%" class="dialogTd" align="right" id="lgrText">申请人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="ywblr_xm" name="ywblr_xm" style="width:200px;" value="${applyDate}" readonly="readonly" />
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="ywfqyy" name="ywsqyy" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']" /></td>
	    	</tr>	    	
	    	</table>	    		    		    
    </form>


	

	<div id="syrkDiv" class="easyui-window" title="实有人口查询"  data-options="iconCls:'icon-search',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:600,height:400">
		        <form id ="queryForm" >
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				        
				        <tr class="dialogTr">
					    	<td width="20%" class="dialogTd" align="right">姓名：</td>
					    	<td width="30%" class="dialogTd">
					    	    <input type="text" name="syrkXm" id="syrkXm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					    	</td>				    	
					    	<td width="20%" class="dialogTd" align="right">证件类型：</td>
					    	<td width="30%" class="dialogTd">
					    	    <input class="easyui-combobox" type="text" id="syrkCyzjdm" name="syrkCyzjdm" style="width:180px;"
							    	   data-options="url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
				    		<td width="20%" class="dialogTd" align="right">性别：</td>
					    	<td width="30%" class="dialogTd">
					    	    <input class="easyui-combobox" type="text" id="syrkXbdm" name="syrkXbdm" style="width:180px;"
									data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						    </td>
					    					    	
					    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
					    	<td width="30%" class="dialogTd">
					    	    <input type="text" name="syrkZjhm" id ="syrkZjhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:180px;"/>
					    	</td>
				    	</tr>					    	  				    
				    	<tr class="dialogTr">
					    	<td width="20%" class="dialogTd" align="right">居住地址：</td>
					    	<td width="80%" class="dialogTd" colspan="3">
					            <input type="text" name="syrk_jzd_dzxz" id ="syrk_jzd_dzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:470px;"/>
					        </td>
				    	</tr>	
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="syrkQuery();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="querySyrkClose()">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		        
		        <!-- 人口查询列表 -->
	           <table id="dg" class="easyui-datagrid"
		              	data-options="url:'<%=contextPath%>/syrkGl/querySyrk',
		                  	delayCountUrl:'<%=contextPath%>/syrkGl/querySyrkCount',							
							selectOnCheck:true,
			        		checkOnSelect:true,
			        		rownumbers:true,
			        		border:false,
			        		sortName:'',
			        		sortOrder:'desc',
			        		pageSize:getAutoPageSize(105),
			        		pageList:[getAutoPageSize(105),
			        		getAutoPageSize(105) * 2],
			        		singleSelect:true,
			        		fitColumns:false,
			        		nowrap:true,
							toolbar:'#datagridToolbar',
							onClickRow:ZdryAdd.onClickRow">
				        <thead>
				          <tr>
				           	<th data-options="field:'syrkywlxdm',width:80,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SYRKYWLXDM.js'">人员类型</th>
				            <th data-options="field:'zjhm',width:120,align:'center',sortable:true,halign:'center'">证件号码</th>
					        <th data-options="field:'xm',width:50,align:'center',sortable:true,halign:'center'">姓名</th>
					        <th data-options="field:'jzd_dzxz',width:180,align:'left',sortable:true,halign:'center',formatter:ZdryAdd.subjzddzxz">居住地址</th>
					        <th data-options="field:'process',width:120,align:'center',halign:'center',formatter:selectOne">操作</th>
				          </tr>
				       </thead>
		       </table>
		   </div>    
	</div>
			
		</div>
	    </div>
	    </div>		 
	    
	    
	    <div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
			<a id="saveButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="saveForm(this)">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>			
		</div>	     
	   
	</td></tr></table>
</div>
</body>
<script type="text/javascript" >
var mainTabID = "${mainTabID}";
var invokeJSMethod = "${invokeJSMethod}";
var pcsdm = "${pcsdm}";
var zrqdm = "${zrqdm}";
var cyzjdm = "${ryRyjbxxb.cyzjdm}"; 
var zjhm = "${ryRyjbxxb.zjhm}"; 
function doInit(paramArray) {
	$.ajax({
		type: "POST",
		url: contextPath + "/zdryzb/queryLglxByZdrylx",
		dataType: "json",
		data:"&syrkid=" + syrkid,
		success: function(data) {
			if (data) {								
				$('#zdrygllxdm').combobox('setDataFilter', '[^'+data+']');
			}
		},		
		error: function() {
		}
	});	
}

function beforeSubmit() {
}

function afterSubmit() {
}	

function startup(){
	$("#jgdxDiv").hide();
	$("#zdrkDiv").hide();
	$("#zszhjsbrDiv").hide();
	$("#fzcfryDiv").hide();
	$("#sqjzryDiv").hide();
	$("#sqsbzdryDiv").hide();
	$("#sgafzdryDiv").hide();
	//$("#ggDiv").hide();	
};


/**
 * 根据撤管类型,得到撤管后的类型,大类选择
 */
function getcghlx(newValue,oldValue){
	var name = $("#xm").val();
	if(newValue){
		var cglx=newValue;
		var zdrylx="5|6";
		if(cglx=="1"){
			zdrylx="2|5"
		}else if(cglx=="5"){
			zdrylx="6"
		}
		$('#zdrygllxdm').combobox('setDataFilter', zdrylx);
		if(zdrylx=='6'){
		//$('#zdrygllxdm').combobox('setValue', zdrylx);
		setComboRequired("zdrylbStr", false);
		}
	}
}



function closeWindow(){
	closeSelf();
}

function querySyrk(){
	$("#syrkDiv").window("open");
}
//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
function querySyrkClose(){
	$("#syrkDiv").window("close");
}
function syrkQuery(){
	var xm = document.getElementById("syrkXm").value;
	var cyzjdm = document.getElementById("syrkCyzjdm").value;
	var zjhm = document.getElementById("syrkZjhm").value;
	var xbdm = document.getElementById("syrkXbdm").value;	
	var jzd_dzxz = document.getElementById("syrk_jzd_dzxz").value;	
	$('#dg').datagrid('load',{    		
		'xm':xm,
		'cyzjdm':cyzjdm,
		'zjhm':zjhm,
		'xbdm':xbdm,		
		'jzd_dzxz':jzd_dzxz
	});
}

function selectOne(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="selectSyrk('+index+')">选择</a>&nbsp;';
}

function selectSyrk(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	$("#xm").val(rowData.xm);
	$("#zjhm").val(rowData.zjhm);
	$("#syrkid").val(rowData.id);	
	$("#ryid").val(rowData.ryid);
	querySyrkClose();
	queryYlglx(rowData.ryid,rowData.id);	
}

//查询已列管类型
function queryYlglx(ryid,syrkid){	
	$.ajax({
		type: "POST",
		url: contextPath + "/zdryzb/queryYlglx",
		dataType: "json",
		data:"ryid=" + ryid + "&syrkid=" + syrkid,
		success: function(data) {
			if (data) {				
				var resAry=data.split("/");
				$("#ylglxTr").show();
				$("#ylglx").text(resAry[0]);
				queryKlglx(resAry[1]);//查询可列管类型				
			}else{
				$("#ylglxTr").hide();
				$("#zdrygllxdm").combobox("setDataFilter", "");
			}
		},		
		error: function() {
			$("#ylglxTr").hide();
			$("#zdrygllxdm").combobox("setDataFilter", "");
		}
	});		
}

//查询可列管类型
function queryKlglx(ylglxStr){
	$.ajax({
		type: "POST",
		url: contextPath + "/zdryzb/queryklglx",
		dataType: "json",
		data:"ylglxStr=" + ylglxStr,
		success: function(data) {
			if (data) {								
				$("#zdrygllxdm").combobox("setDataFilter", data);	
				$("#zdrygllxdm").combobox("setValue", "");
				$('#zdrylbStr').combotree('tree').tree('loadData', [''])
			}else{
				$("#zdrygllxdm").combobox("setDataFilter", "");					
			}
		},		
		error: function() {
			$("#zdrygllxdm").combobox("setDataFilter", "");	
		}
	});	
}
</script>

</html>
