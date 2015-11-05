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
				<td width="20%" class="dialogTd" align="right">证件类型：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-combobox" type="text" id="cyzjdm" name="zdryZdryzb.cyzjdm" value="${ryjbxxb.cyzjdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',
							selectOnNavigation:false,method:'get',tipPosition:'left',onChange:cyzjdmChange"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" value="${zdryZdryzbVO.xm}"/></td>
		    </tr>
		    <tr class="dialogTr">
		    		    	
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="zjhm" name="zdryZdryzb.zjhm" style="width:200px;float:left;" value="${zdryZdryzbVO.zjhm}" onblur="checkZjhm()"
		    			data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'" />
		    		<div class="lodingimg" id="ryxxLoadDiv" ></div>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">性别：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-combobox" type="text"  id="xbdm" name="zdryZdryzb.xbdm"   style="width:200px;" value="" 
					data-options="url: contextPath +'/common/dict/GB_D_XBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>		    		
		    	</td>	
		    </tr>
		    </table>
		    
		    <!-- 隐藏的人员信息 -->
		    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" id="ryxxDiv">		    
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">民族：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-combobox" type="text" id="mzdm" name="zdryZdryzb.mzdm" value="" style="width:200px;"
					data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>		    		
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="csrq" name="zdryZdryzb.csrq" style="width:200px;" value=""/>	    		
		    	</td>	
		    </tr>	
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">籍贯省市县代码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="jgssxdm" name="zdryZdryzb.jgssxdm" style="width:200px;" value=""/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">户籍地_行政区划代码：</td>
		    	<td width="30%" class="dialogTd">		  
		    		<input class="easyui-combobox" type="text" id="hjd_xzqhdm" name="zdryZdryzb.hjd_xzqhdm" value="" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>  		
		    	</td>	
		    </tr>
		    
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">户籍地_门楼牌代码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="hjd_mlpdm" name="zdryZdryzb.hjd_mlpdm" style="width:200px;" value=""/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">户籍地_门楼牌详址：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="hjd_mlpxz" name="zdryZdryzb.hjd_mlpxz" style="width:200px;" value=""/>	    		
		    	</td>	
		    </tr>	
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">户籍地_地址ID：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="hjd_dzid" name="zdryZdryzb.hjd_dzid" style="width:200px;" value=""/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">户籍地_地址详址：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="hjd_dzxz" name="zdryZdryzb.hjd_dzxz" style="width:200px;" value=""/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">居住地_行政区划代码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-combobox" type="text" id="jzd_xzqhdm" name="zdryZdryzb.jzd_xzqhdm" value="" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>		    		
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">居住地_门楼牌代码：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="jzd_mlpdm" name="zdryZdryzb.jzd_mlpdm" style="width:200px;" value=""/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">居住地_门楼牌详址：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="jzd_mlpxz" name="zdryZdryzb.jzd_mlpxz" style="width:200px;" value=""/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">居住地_地址ID：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="jzd_dzid" name="zdryZdryzb.jzd_dzid" style="width:200px;" value=""/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">居住地_地址详址：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="jzd_dzxz" name="zdryZdryzb.jzd_dzxz" style="width:200px;" value=""/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">居住地_坐标X：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="jzd_zbx" name="zdryZdryzb.jzd_zbx" style="width:200px;" value=""/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">居住地_坐标Y：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="jzd_zby" name="zdryZdryzb.jzd_zby" style="width:200px;" value=""/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">管辖分局代码：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="gxfjdm" name="zdryZdryzb.gxfjdm" style="width:200px;" value=""/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">管辖派出所代码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="gxpcsdm" name="zdryZdryzb.gxpcsdm" style="width:200px;" value=""/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">管辖责任区代码：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="gxzrqdm" name="zdryZdryzb.gxzrqdm" style="width:200px;" value=""/>	    		
		    	</td>	
		    </tr>    
		    </table>		  		    		    	    	
		    
		    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		    <tr class="dialogTr">
		    	<td colspan="4" align="center">
		    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="querySyrk()">查询实有人口</a>
		    		<a href="javascript:void(0)" class="easyui-linkbutton" id="ryxxShow" onclick="ryxxTag(1)" style="display:none">显示全部</a>
		    		<a href="javascript:void(0)" class="easyui-linkbutton" id="ryxxHide" onclick="ryxxTag(2)" >收起部分</a>		    	
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
					data-options="url: contextPath +'/common/dict/BD_D_ZDRYGLLX.js',  
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zdrylxChange"/>

	    			<input type="text" name="zdryZdryzb.zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:390px;"
	    			data-options="onlyLeaf:true,valueField:'id',textField:'text',
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
		    	<input class="easyui-validatebox " type="text" id="ywfqyy" name="ywsqyy" style="width: 595px;" data-options="required:false,validType:['maxLength[100]','unnormal']" /></td>
	    	</tr>	    	
	    	</table>	    		    		    
    </form>


	

	<div id="syrkDiv" class="easyui-window" title="实有人口查询"  data-options="iconCls:'icon-search',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:600,height:500">
		        <div id="datagridToolbar" style="padding: 0px; height: 150px; width: 100%; vertical-align: top;">
		        <form id ="queryForm" >		        
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				        
				        <tr class="dialogTr">
					    	<td width="20%" class="dialogTd" align="right">姓名：</td>
					    	<td width="30%" class="dialogTd">
					    	    <input type="text" name="syrkXm" id="syrkXm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					    	</td>				    	
					    	<td width="20%" class="dialogTd" align="right">人员类型：</td>
					    	<td width="30%" class="dialogTd">
					    	    <input class="easyui-combobox" type="text" id="syrkywlxdm" name="syrkywlxdm" style="width:180px;"
								    	   data-options="url: contextPath + '/common/dict/BD_D_SYRKYWLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
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
		        </div>
		        <!-- 人口查询列表 -->
	           <table id="dg" class="easyui-datagrid"
	           		data-options="url: '<%=contextPath%>/syrkGl/queryList',
	           		toolbar:'#datagridToolbar',
	           		rownumbers:true,
            		border:false,
            		selectOnCheck:false,
            		sortName:'xt_cjsj',
            		sortOrder:'asc',
            		idField:'id',
            		pageSize:10
            		">
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
	var zjhm = document.getElementById("syrkZjhm").value;	
	var xbdm = $("#syrkXbdm").combobox("getValue");
	if($("#syrkXbdm").combobox("getText")==""){
		xbdm="";
	}
	var jzd_dzxz = document.getElementById("syrk_jzd_dzxz").value;		
	var syrkywlxdm = $("#syrkywlxdm").combobox("getValue");
	if($("#syrkywlxdm").combobox("getText")==""){
		syrkywlxdm="";
	}
	$('#dg').datagrid('load',{ 
		'syrkywlxdm':syrkywlxdm,
		'xm':xm,		
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
	$("#xbdm").combobox("setValue", rowData.xbdm);
	$("#cyzjdm").combobox("setValue", rowData.cyzjdm);	
	$("#zjhm").val(rowData.zjhm);
	$("#syrkid").val(rowData.id);	
	$("#ryid").val(rowData.ryid);
	
	$("#csrq").val(rowData.csrq);
	$("#mzdm").combobox("setValue",rowData.mzdm);	
	$("#jgssxdm").val(rowData.jgssxdm);
	$("#hjd_xzqhdm").combobox("setValue",rowData.hjd_xzqhdm);
	$("#hjd_mlpdm").val(rowData.hjd_mlpdm);
	$("#hjd_mlpxz").val(rowData.hjd_mlpxz);
	$("#hjd_dzid").val(rowData.hjd_dzid);
	$("#hjd_dzxz").val(rowData.hjd_dzxz);
	$("#jzd_xzqhdm").combobox("setValue",rowData.jzd_xzqhdm);
	$("#jzd_mlpdm").val(rowData.jzd_mlpdm);
	$("#jzd_mlpxz").val(rowData.jzd_mlpxz);
	$("#jzd_dzid").val(rowData.jzd_dzid);
	$("#jzd_dzxz").val(rowData.jzd_dzxz);
	$("#jzd_zbx").val(rowData.jzd_zbx);
	$("#jzd_zby").val(rowData.jzd_zby);
	$("#gxfjdm").val(rowData.gxfjdm);
	$("#gxpcsdm").val(rowData.gxpcsdm);
	$("#gxzrqdm").val(rowData.gxzrqdm);	
	
	querySyrkClose();
	queryYlglx(rowData.ryid,rowData.id);
	showGroup();
	$("#zdrygllxdm").combobox("setValue", "");	
	$('#zdrylbStr').combotree('tree').tree('loadData', '');	
	$("#ryxxLoadDiv").hide();
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

/**根据证件种类 设置证件号码验证*/
function cyzjdmChange(newVal, oldVal) {	
	if (!newVal) {
		newVal = "";
	}	
	
	if (newVal == "111" || newVal == "112" || newVal == "335" ) {
		$("#zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	$("#zjhm").val("");
}

/**
 * 根据证件种类与号码 ，进行人员比对，复用
 */
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
	
	czrkNO = "0";
	jzrkNO = "0";
	ldrkNO = "0";
	wlczrkNO = "0";
	jwryNO = "0";
	autoGllb = true;
	$("#ryxxLoadDiv").show();
	$.ajax({
		type:"POST",
		url:"<%=basePath%>dataApply/ryxxApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#cyzjdm").val(),
		success:function(data) {
			if (data) {
				data = $.parseJSON(data);
				$("#xm").val(data.xm);	
				$("#xbdm").combobox("setValue", data.xbdm);
				$("#cyzjdm").val(data.cyzjdm);
				$("#zjhm").val(data.zjhm);
				$("#syrkid").val(data.id);	
				$("#ryid").val(data.ryid);
				
				$("#csrq").val(data.csrq);
				$("#mzdm").combobox("setValue",data.mzdm);
				$("#jgssxdm").val(data.jgssxdm);
				$("#hjd_xzqhdm").combobox("setValue",data.hjd_xzqhdm);				
				$("#hjd_mlpdm").val(data.hjd_mlpdm);
				$("#hjd_mlpxz").val(data.hjd_mlpxz);
				$("#hjd_dzid").val(data.hjd_dzid);
				$("#hjd_dzxz").val(data.hjd_dzxz);
				$("#jzd_xzqhdm").combobox("setValue",data.jzd_xzqhdm);				
				$("#jzd_mlpdm").val(data.jzd_mlpdm);
				$("#jzd_mlpxz").val(data.jzd_mlpxz);
				$("#jzd_dzid").val(data.jzd_dzid);
				$("#jzd_dzxz").val(data.jzd_dzxz);
				$("#jzd_zbx").val(data.jzd_zbx);
				$("#jzd_zby").val(data.jzd_zby);
				$("#gxfjdm").val(data.gxfjdm);
				$("#gxpcsdm").val(data.gxpcsdm);
				$("#gxzrqdm").val(data.gxzrqdm);			
			}
		},
		complete:function() {
			$("#zjhm").attr("zjhm", $("#zjhm").val());
			$("#ryxxLoadDiv").hide();
		},
		error:function() {
		}
	});	
}

function ryxxTag(index){
	
	if(index==1){
		$("#ryxxShow").hide();
		$("#ryxxHide").show();
		$("#ryxxDiv").show();
	}else{
		$("#ryxxShow").show();
		$("#ryxxHide").hide();
		$("#ryxxDiv").hide();
	}
}
</script>

</html>
