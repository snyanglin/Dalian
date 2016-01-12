<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
	String userOrgCode = userInfo.getUserOrgCode();
%>
<html>
<head>
<title>动态纪实详细</title>
<script type="text/javascript"
	src="<%=contextPath%>/js/zdrygl/dtjsMore.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/css/bzdz.css"></link>
</head>
<body >
	<input type="hidden" id="zdry_zjhm" value="${zdryZjhm}" />
	<input type="hidden" id="zdryid" value="${zdryid}" />
	<div id="dtjsMore" class="easyui-tabs" data-options="border:false,onSelect:onTabSelect" style="height: 560px;width: 980px;">
		<div title="写实基本信息" id="dwxx" >
			<c:if test="${mode != 'view'}">
				<div id="toolbar_0">
					<a id="xsjbxxAdd" class="easyui-linkbutton" iconCls="icon-add"
							onclick="xsjbxxAdd();">新增</a>
				</div>
			</c:if>
			<table id="xsjbxx" style="height: 200px;"></table>
		</div>

		<div title="在逃属性" id="ztxx" >
			<table id="ztxxTable" ></table>
		</div>
		
		<div title="维稳信息" id="swxx" >
			<c:if test="${mode != 'view'}">
				<div id="toolbar_2">
					<a id='swxxAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="swxxAdd();">新增</a>
				</div>
			</c:if>
			<table id="swxxtable" ></table>
		</div>
		
		<div title="上访信息" id="sfxx" >
			<c:if test="${mode != 'view'}">
				<div id="toolbar_3">
					<a id='sfxxAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="sfxxAdd();">新增</a>
				</div>
			</c:if>
			<table id="sfxxtable" ></table>
		</div>
		
		<div title="刑事犯罪前科信息" id="zdxsfzqkxxb" >
			<c:if test="${mode != 'view'}">
				<div id="toolbar_4">
					<a id='zdxsfzqkxxbAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="zdxsfzqkxxbAdd();">新增</a>
				</div>
			</c:if>
			<table id="zdxsfzqkxxbtable"></table>
		</div>

		<div title="社会关系人信息" id="shgxrxxb">
			<c:if test="${mode != 'view'}">
				<div id="toolbar_5">
					<a id='shgxrxxbAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="shgxrxxbAdd();">新增</a>
				</div>
			</c:if>
			<table id="shgxrxxbtable"></table>
		</div>
		
		<div title="涉案信息" id="saxx">
			<table id="saxxTable"></table>
		</div>

		<div title="车辆信息" id="sfxx">
			<c:if test="${mode != 'view'}">
				<div id="toolbar_7">
					<a id='clxxAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="clxxAdd();">新增</a>
				</div>
			</c:if>
			<table id="clxxtable"></table>
		</div>

		<div title="涉毒信息" id="sdxx">
			<input type="radio" name="sdlx" value="xd" checked="checked">吸毒信息 </input> 
			<input type="radio" name="sdlx" value="fd"> 贩毒信息 </input> 
			<input type="radio" name="sdlx" value="zd"> 制毒信息 </input>

			<!-- 引入具体的框架信息 -->
			<iframe id="sdxxFrame" name="sdxxFrame" src="" border="0"
				frameborder="0" scrolling="no" style="width: 100%; height: 510px;">
			</iframe>
		</div>

		 <div title="肇事肇祸精神病信息" id="zszhjsbxx" >
			<input type="radio" name="zszhjsblx" value="zszhjsbrxx" checked="checked"> 肇事肇祸精神病信息 </input>
			<input type="radio" name="zszhjsblx" value="zszhjsbrzdjl">诊断记录</input>
			<input type="radio" name="zszhjsblx" value="zszhjsbrzszhjl"> 肇事肇祸记录 </input>
			
			<!-- 引入具体的框架信息 -->
			<iframe id="zszhjsbFrame" name="zszhjsbFrame" src="" 
				border="0" frameborder="0" scrolling="no" 
				style="width:100%;height:510px;" > </iframe>
		</div>  

	</div>
</body>
<script type="text/javascript">
	var userOrgCode="<%=userOrgCode%>";

	var initPages = new Array();
	function onTabSelect(title,index){
		
		if(index == 0 && initPages[index] != index){
			console.log('初始化第'+(index+1)+'页');
			initPages[index] = index;
			$('#dwxx').attr('height','435px');
			var url = basePath+'dtjsMore/moreDtjsXsjbxx?zdryZjhm='+'${zdryZjhm}';
			console.log(url);
			$('#xsjbxx').datagrid({    
				url:url,
				toolbar:"#toolbar_0",
           		selectOnCheck:true,
        		checkOnSelect:true, 
        		rownumbers:true,
        		border:false,
        		singleSelect:true,
        		fitColumns:false,
        		fit:true,
        		nowrap:true,    
			    columns:[[    
			        {field:'hssj',title:'核实时间',width:80,align:'left',halign:'center',sortable:true},    
			        {field:'zjzt',title:'在籍状态',width:50,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/QB_D_ZDRYYJSNZTDM.js'},    
			        {field:'lksj',title:'离开时间',width:80,align:'left',halign:'center'},
			        {field:'jzd_dzxz',title:'居住地址',width:100,align:'left',halign:'center'},
			        {field:'qwss',title:'去往省市',width:80,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XZQHDMLIST.js'},
			        {field:'zkzt',title:'在控状态',width:50,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBZDRYZKZTDM.js'},
			    	{field:'wxjb',title:'危险级别',width:50,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBZDRYWXJBDM.js'},
			    	{field:'zy',title:'职业',width:60,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_ZYFLYDM.js'},
			    	{field:'xnsfxx',title:'虚拟身份信息',width:100,align:'left',halign:'center'},
			    	{field:'sfjdbr',title:'是否见到本人',width:40,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFDM.js'},
			    	{field:'zklx',title:'在控类型',width:50,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBZDRYZKZTDM.js'},
			    	{field:'yjzq',title:'约见周期',width:90,align:'left',halign:'center'},
			    	{field:'process',title:'操作',align:'center',width:100,halign:'center',formatter:xsjbxxFormater}
			   	]]    
			});  
		}else if(index == 1 && initPages[index] != index){
			console.log('初始化第'+(index+1)+'页');
			initPages[index] = index;
			var url = basePath+'dtjsMore/moreDtjsZtxxb?zdryZjhm='+'${zdryZjhm}';
			$('#ztxxTable').datagrid({    
				url:url,
           		selectOnCheck:true,
        		checkOnSelect:true,
        		rownumbers:true,
        		border:false,
        		singleSelect:true,
        		fitColumns:false,
        		nowrap:true,
			    columns:[[    
			        {field:'sslb',title:'所属类别',width:80,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'},    
			        {field:'ztlx',title:'在逃类型',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_ZTRYLBDM.js'},
			        {field:'lasj',title:'立案时间',width:80,align:'left',halign:'center'},
			        {field:'ladwmc',title:'立案单位',width:120,align:'left',halign:'center'},
			        {field:'tpsj',title:'逃跑时间',width:80,align:'center',halign:'center'},
			        {field:'tpfx',title:'逃跑方向',width:100,align:'left',halign:'center'},
			        {field:'ltrq',title:'立逃日期',width:80,align:'left',halign:'center'},
			        {field:'ltdwmc',title:'立逃单位',width:100,align:'left',halign:'center'},
			        {field:'ajlbdm',title:'案件类别',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_AJLBDM.js'},
			        {field:'dbjb',title:'督捕级别',width:100,align:'left',halign:'center'},
			        {field:'aqms',title:'案情描述',width:150,align:'left',halign:'center'}
			   	]]    
			});  
		}else if(index == 2 && initPages[index] != index){
			console.log('初始化第'+(index+1)+'页');
			initPages[index] = index;
			var url = basePath+'dtjsMore/moreDtjsSwxx?zdryZjhm='+'${zdryZjhm}';
			$('#swxxtable').datagrid({    
				url:url,
				toolbar:"#toolbar_2",
           		selectOnCheck:true,
        		checkOnSelect:true,
        		rownumbers:true,
        		border:false,
        		singleSelect:true,
        		fitColumns:false,
        		nowrap:true,
			    columns:[[    
			        {field:'zdryzjhm',title:'重点人员证件号码',width:140,align:'center',halign:'center'},
			        {field:'sslb',title:'所属类别',width:120,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'},
			        {field:'sslbxl',title:'所属类别细类',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBZDRYXLDM.js'},
			        {field:'sszzmc',title:'所属组织名称',width:120,align:'left',halign:'center'},
			        {field:'qkgs',title:'情况概述',width:200,align:'left',halign:'center'},
			        {field:'process',title:'操作',align:'center',width:100,halign:'center',formatter:swxxFormater}
			   	]]    
			});  
		}else if(index == 3 && initPages[index] != index){
			console.log('初始化第'+(index+1)+'页');
			initPages[index] = index;
			var url = basePath+'dtjsMore/moreDtjsSfxx?zdryZjhm='+'${zdryZjhm}';
			$('#sfxxtable').datagrid({    
				url:url,
				toolbar:'#toolbar_3',
           		selectOnCheck:true,
        		checkOnSelect:true,
        		rownumbers:true,
        		border:false,
        		singleSelect:true,
        		fitColumns:false,
        		nowrap:true,
			    columns:[[  
			        {field:'zdryzjhm',title:'重点人员证件号码',width:140,align:'center',halign:'center'},
			        {field:'sslb',title:'所属类别',width:120,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'},
			        {field:'sslbxl',title:'所属类别细类',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'},
			        {field:'ssqt',title:'所属群体',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBZDRYQTDM.js'},
			        {field:'sfdd',title:'上访地点',width:200,align:'left',halign:'center'},
			        {field:'bbdwmc',title:'包保单位名称',width:200,align:'left',halign:'center'},
			        {field:'bbld',title:'包保领导',width:200,align:'left',halign:'center'},
			        {field:'sffs',title:'上访方式',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFFSDM.js'},
			        {field:'czjg',title:'处置结果',width:200,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_CZJG.js'},
			        {field:'czry',title:'处置人员',width:200,align:'left',halign:'center'},
			        {field:'sqjb',title:'诉求级别',width:200,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_SQJB.js'},
			        {field:'sfxf',title:'是否息访',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFDM.js'},
			        {field:'yjjb',title:'预警级别',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_YJJB.js'},
			        {field:'lxdh',title:'联系电话',width:120,align:'left',halign:'center'},
			        {field:'zyyy',title:'主要原因',width:120,align:'left',halign:'center'},
			        {field:'zysq',title:'主要事情',width:120,align:'left',halign:'center'},
			        {field:'sfgcms',title:'上访过程描述',width:120,align:'left',halign:'center'},
			        {field:'process',title:'操作',align:'center',width:100,halign:'center',formatter:sfxxFormater}
			   	]]    
			});  
		}else if(index == 4 && initPages[index] != index){
			console.log('初始化第'+(index+1)+'页');
			initPages[index] = index;
			var url = basePath+'dtjsMore/moreDtjsZdxsfzqkxx?zdryZjhm='+'${zdryZjhm}';
			$('#zdxsfzqkxxbtable').datagrid({    
				url:url,
				toolbar:'#toolbar_4',
           		selectOnCheck:true,
        		checkOnSelect:true,
        		rownumbers:true,
        		border:false,
        		singleSelect:true,
        		fitColumns:false,
        		nowrap:true,
			    columns:[[
			        {field:'zdryzjhm',title:'重点人员证件号码',width:140,align:'center',halign:'center'},
			        {field:'sslb',title:'所属类别',width:120,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBZDRYLBDM.js'},
			        {field:'sslbxl',title:'所属类别细类',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBZDRYXLDM.js'},
			        {field:'zasd',title:'作案手段',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_ZASDFLHSDDM.js'},
			        {field:'zagj',title:'作案工具',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_SAWPFLHDM.js'},
			        {field:'zagjly',title:'作案工具来源',width:200,align:'left',halign:'center'},
			        {field:'zatd',title:'作案特点',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_ZATDFLHDM.js'},
			        {field:'xzdx',title:'选择对象',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_XZDXDM.js'},
			        {field:'xzwp',title:'选择物品',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_XZWPDM.js'},
			        {field:'xzcs',title:'选择处所',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_XZCSDM.js'},
			        {field:'xzsj',title:'选择时机',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_XZSJDM.js'},
			        {field:'sfthza',title:'是否团伙作案',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFDM.js'},
			        {field:'process',title:'操作',align:'center',width:100,halign:'center',formatter:zdxsfzqkxxbFormater}
			   	]]    
			});  
		}else if(index == 5 && initPages[index] != index){
			console.log('初始化第'+(index+1)+'页');
			initPages[index] = index;
			var url = basePath+'dtjsMore/moreDtjsShgxrxxb?zdryZjhm='+'${zdryZjhm}';
			$('#shgxrxxbtable').datagrid({    
				url:url,
				toolbar:'#toolbar_5',
           		selectOnCheck:true,
        		checkOnSelect:true,
        		rownumbers:true,
        		border:false,
        		singleSelect:true,
        		fitColumns:false,
        		nowrap:true,
			    columns:[[
			       {field:'zjlx',title:'证件类型',width:140,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/KX_D_CYZJDM.js'},
			       {field:'zjhm',title:'证件号码',width:120,align:'center',halign:'center',sortable:true},
			       {field:'xm',title:'姓名',width:120,align:'center',halign:'center'},
			       {field:'mz',title:'民族',width:120,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_MZDM.js'},
			       {field:'xb',title:'性别',width:200,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XBDM.js'},
			       {field:'gx',title:'关系',align:'center',width:100,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_RYGXDM.js'},
			       {field:'hjdxz',title:'户籍地详址',width:200,align:'center',halign:'center'},
			       {field:'xzdxz',title:'现住地详址',width:200,align:'center',halign:'center'},
			       {field:'process',title:'操作',align:'center',width:100,halign:'center',formatter:shgxrxxbFormater}
			   	]]    
			});  
		}else if(index == 6 && initPages[index] != index){
			console.log('初始化第'+(index+1)+'页');
			initPages[index] = index;
			var url = basePath+'dtjsMore/moreDtjsSaxxb?zdryZjhm='+'${zdryZjhm}';
			$('#saxxTable').datagrid({    
				url:url,
           		selectOnCheck:true,
        		checkOnSelect:true,
        		rownumbers:true,
        		border:false,
        		singleSelect:true,
        		fitColumns:false,
        		nowrap:true,
			    columns:[[
			       {field:'zjhm',title:'证件号码',width:150,align:'left',halign:'center',sortable:false},
			       {field:'ajbh',title:'案件编号',width:100,align:'left',halign:'center'},
			       {field:'ajlb',title:'案件类型',width:120,align:'left',halign:'center'},
			       {field:'fasj',title:'发案时间',width:100,align:'center',halign:'center'},
			       {field:'fadd',title:'发案地点',width:140,align:'left',halign:'center'},
			       {field:'jyaq',title:'简要案情',width:400,align:'left',halign:'center'}
			   	]]    
			});  
		}else if(index == 7 && initPages[index] != index){
			console.log('初始化第'+(index+1)+'页');
			initPages[index] = index;
			var url = basePath+'dtjsMore/moreDtjsClxx?zdryZjhm='+'${zdryZjhm}';
			$('#clxxtable').datagrid({    
				url:url,
				toolbar:'#toolbar_7',
           		selectOnCheck:true,
        		checkOnSelect:true,
        		rownumbers:true,
        		border:false,
        		singleSelect:true,
        		fitColumns:false,
        		nowrap:true,
			    columns:[[
				   {field:'cz_cyzjdm',title:'证件类型',width:50,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/KX_D_CYZJDM.js'},
			       {field:'cz_zjhm',title:'证件号码',width:140,align:'center',halign:'center'},
			       {field:'cz_xm',title:'姓名',width:70,align:'center',halign:'center'},
			       {field:'clpp',title:'车辆品牌',width:120,align:'center',halign:'center',sortable:true},
			       {field:'cllx',title:'车辆类型',width:120,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_CL_CLLX.js'},
			       {field:'clys',title:'车辆颜色',width:80,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_CL_CSYS.js'},
			       {field:'clhm',title:'车辆号码',width:200,align:'center',halign:'center'},
			       {field:'clly',title:'车辆来源',width:200,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_CLHDFS.js'},
			       {field:'gsr',title:'归属人',width:120,align:'center',halign:'center'},
			       {field:'clxxbh',title:'车辆信息编号',width:120,align:'center',halign:'center'},
			       {field:'process',title:'操作',align:'center',width:100,halign:'center',formatter:clxxFormater}
			   	]]    
			});  
		}else if(index == 8 && initPages[index] != index){
			//初始化 单选
			$("input[name=sdlx]").each(function(i, o) {
				$(o).click(function() {
					turnToSdDetail($(this).val());
				});
			});
			
			//初始化框架
			$("#sdxxFrame").attr('src', '<%=contextPath%>/forward/zdrygl|dtjsXdxxList');
		}else if(index == 9 && initPages[index] != index){
			//初始化 单选
			$("input[name=zszhjsblx]").each(function(i, o) {
				$(o).click(function() {
					turnToZszhjsbDetail($(this).val());
				});
			});
			
			//初始化框架
			$("#zszhjsbFrame").attr('src', '<%=contextPath%>/forward/zdrygl|dtjsZszhjsbxxList');
		}
	}
	
	function turnToSdDetail(sdType) {

		var src = contextPath + "/forward/zdrygl|";
		if (sdType == 'xd') {
			src += "dtjsXdxxList";
		} else if (sdType == 'fd') {
			src += "dtjsFdxxList";
		} else {
			src += "dtjsZdxxList";
		}
		$("#sdxxFrame").attr('src', src);
	}
	
	function turnToZszhjsbDetail(zszhjsbType){
		
		var src = contextPath + "/forward/zdrygl|";
		if(zszhjsbType == 'zszhjsbrxx'){
			src += "dtjsZszhjsbxxList";
		}else if(zszhjsbType == 'zszhjsbrzdjl'){
			src += "dtjsZszhjsbrzdjlxxbList";
		}else{
			src += "dtjsZszhjsbrzszhjlxxbList";
		}
		$("#zszhjsbFrame").attr('src',src);
	}

	function getUserOrgCode() {
		return userOrgCode;
	}

	function getZdryzjhm() {
		return '${zdryZjhm}';
	}

	function getZdryid() {
		return '${zdryid}';
	}
	
	function getPageEditAble(){
		console.log('${mode}');
		if('${mode}' != 'view'){
			return true;
		}else{
			return false;
		}
	}
</script>
</html>