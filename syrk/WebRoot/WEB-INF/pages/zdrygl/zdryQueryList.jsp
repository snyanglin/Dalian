<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>重点人员管理</title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "";
    </script>
    <style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}
	
	</style>
    <script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryzbQuery.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'west',border:false" style="width:538px;">
           <!-- 地址管理列表 -->
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/zdryzb/getQeryList',
						onLoadSuccess:function(data){ZdryManage.loadPoint(data,'dg');},
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
		        		fitColumns:true,
						toolbar:'#datagridToolbar',
						onClickRow:ZdryManage.onClickRow">
			        <thead>
			          <tr>
				            <th data-options="field:'zdrygllxdm',width:70,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYGLLX.js'">类型</th>
				            <th data-options="field:'zjhm',width:120,align:'left',sortable:true,halign:'center'">身份证号码</th>
				            <th data-options="field:'xm',width:70,align:'left',sortable:true,halign:'center'">姓名</th>
				            <th  data-options="field:'jzd_dzxz',width:200,align:'right',halign:'center',sortable:true">居住地址</th>
				             <th  data-options="field:'ryid',hidden:true"></th>
				             <th  data-options="field:'dz_jzdzmlpdm',hidden:true"></th>
				             <th  data-options="field:'syrkid',hidden:true"></th>
				            <th data-options="field:'jzd_zbx',hidden:true"></th>
				            <th data-options="field:'jzd_zby',hidden:true"></th>
				            <th data-options="field:'process',align:'center',width:100,halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
			       </thead>
	       </table>
	       <div id="datagridToolbar" style="padding:5px;height:auto">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td align="right">
							<input type="text" class="searchText" name="bz"  id="condition" value="请输入重点人员证件号码、姓名或居住地址" 
									style="color:gray;height:32px;font-size:13px;width:300px" charSet="halfUpper"  />
						</td>
						<td align="left">
							<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px" onclick="searchMain();"/>
						</td>
						<td>
							<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="detailSearch()">精确查询</a>
						</td>																	
					</tr>
				</table>
			</div>
	       
	        
	  </div>
	  <div id="win" class="easyui-window" title="重点人员精确查询" style="width:400px;height:400px;top:20px"   
        data-options="iconCls:'icon-search',
        collapsible:false,
        minimizable:false,
        maximizable:false,
        modal:true,
        closed:true,
        top:100,
        width:400,
        height:400,
        left:50">   
	   
	          <div data-options="region:'left'">  
		        <form id ="queryForm" >
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
		      
				       <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">重点人员类型：</td>
						    	<td width="70%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="zdrygllxdm" name="zdrygllxdm" style="width:150px;"
									data-options="url: contextPath +'/common/dict/BD_D_ZDRYGLLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
								</td>
					   	</tr>	
				        <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">姓名：</td>
						    	<td width="70%" class="dialogTd"><input type="text" name="xm" id ="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  style="width:150px;" /></td>
					    </tr>
					    <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">身份证号码：</td>
						    	<td width="70%" class="dialogTd"><input type="text" id="sfzh" name="sfzh" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  style="width:150px;" /></td>
					    </tr>	
					    <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">性别：</td>
						    	<td width="70%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:150px;"
									data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
					    </tr>	  
					    <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">居住地址：</td>
						    	<td width="70%" class="dialogTd"><input type="text" name="dz_jzdzxz" id ="dz_jzdzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  style="width:150px;" /></td>
					    </tr>	
					    <tr class="dialogTr">
						    <td width="30%" class="dialogTd" align="right">管理状态：</td>
						    <td width="70%" class="dialogTd">
						    	<select class="easyui-combobox" id="glztxz" style="width:70px;" data-options="onChange:changeGlztxz">
						    		<option value="0">未撤管</option>
						    		<option value="4">已撤管</option>
						    	</select>
						    	<span id="glztDiv">
						    	<select class="easyui-combobox" id="glzt" name="glzt" style="width:124px;">
						    		<option value="">全部</option>
						    		<option value="1">列管申请中</option>
						    		<option value="2">已列管</option>
						    		<option value="3">撤管申请中</option>						    		
						    		<option value="5">转递申请中</option>
						    		<option value="6">下发中</option>
						    		<option value="7">转类申请中</option>
						    	</select>
						    	</span>
						    </td>
					    </tr>
					    <tr class="dialogTr">
							<td class="dialogTd" align="right">分市县局：</td>
							<td class="dialogTd"><input
								type="text" name="ssfxjdm" id="ssfxjdm" class="easyui-combobox" style="width:200px;" 
								data-options="url: contextPath +'/orgPublicSelect/queryComboBoxList?orgLevel=21',required:false,method:'get',
									valueField:'id',textField:'text',selectOnNavigation:false,onChange:ssfxjdm_onChange,isTopLoad:false">
							</td>
						</tr>
						<tr class="dialogTr">
							<td class="dialogTd" align="right">所属派出所：</td>
							<td class="dialogTd" ><input
								type="text" name="sspcsdm" id="sspcsdm" class="easyui-combobox" style="width:200px;"
								data-options="required:false,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,onChange:sspcsdm_onChange,isTopLoad:false">
							</td>
						</tr>
						<tr class="dialogTr">
							<td class="dialogTd" align="right">所属责任区：</td>
							<td class="dialogTd" >
								<input type="text" name="sszrqdm" id="sszrqdm" class="easyui-combobox" style="width:200px;"
								data-options="required:false,method:'get',valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
							</td>
						</tr>
					    <tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
						    	<td width="100%" colspan="2" align="center">
						    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton();">确定</a>
						    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
						    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
						    	</td>
					    </tr>
			         </table>
			       </form>
	        </div> 
	    
	   </div>
	  
	  <div data-options="region:'center',border:false">
	       <div id="mapDiv"></div>
	       <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
	  </div>
   </body>
</html>
<script type="text/javascript">
//精确查询
function detailSearch() {
	$("#win").window("open");
}

function searchMain(){
	var condition = document.getElementById("condition").value;
	if(condition=="请输入重点人员证件号码、姓名或居住地址"){
		condition="";
	}
	//parent.frames["main_bottom"].searchMain(condition);
	//var reloadUrl  = contextPath + '/zdryzb/list';
	//var opt = $('#dg').datagrid('options');
	//opt.url = reloadUrl;
	
	$('#dg').datagrid('load',{condition:condition});  
	$('#dg').datagrid("clearSelections");
}




 function datagridProcessFormater(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateAndXq(this, '+index+')">查看</a>&nbsp;' ;
};

 function doUpdateAndXq(linkObject, index){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
    menu_open(rowData.xm +'','/zdryzb/'+rowData.ryid+'/'+rowData.id+'/view'+'?mainTabID='+getMainTabID()+'&mode=view');
};
//查询按钮
function queryButton(){
	var xm = document.getElementById("xm").value;
	var sfzh = document.getElementById("sfzh").value;
	var xbdm = document.getElementById("xbdm").value;
	var dz_jzdzxz = document.getElementById("dz_jzdzxz").value;	
	var ssfxjdm=$("#ssfxjdm").val();
	var sspcsdm=$("#sspcsdm").val();
	var sszrqdm=$("#sszrqdm").val();
	var zdrygllxdm = $("#zdrygllxdm").combobox("getValue");
	if($("#zdrygllxdm").combobox("getText")==""){
		zdrygllxdm="";
	}
	
	xm= $.trim(xm);
	sfzh= $.trim(sfzh);
	dz_jzdzxz= $.trim(dz_jzdzxz);
	
	var glztxz=$("#glztxz").val();
	var glzt="";
	if(glztxz=="0"){//查询所有未撤管的状态
		glzt=$("#glzt").val();
	}else{
		glzt="4";
	}
	
	$('#dg').datagrid(
			'load',
			{    
				'zdrygllxdm':zdrygllxdm,				
				'xm': xm,   
				'zjhm': sfzh ,				
				'xbdm':xbdm,
				'dz_jzdzxz':dz_jzdzxz,
				'ssfxjdm':ssfxjdm,
				'sspcsdm':sspcsdm,
				'sszrqdm':sszrqdm,
				'glzt':glzt
			});
	closeWindow("win");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}


function ssfxjdm_onChange(newValue, oldValue) {
	var parentOrgCode = $('#ssfxjdm').combobox('getValue');
	if (parentOrgCode == "") {
		$('#sspcsdm').combobox('loadData', []);
		$('#sszrqdm').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#sspcsdm').combobox('reload', url);
	}
}
function sspcsdm_onChange(newValue, oldValue) {
	var parentOrgCode = $('#sspcsdm').combobox('getValue');
	if (parentOrgCode == "") {
		$('#sszrqdm').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=50&parentOrgCode=' + parentOrgCode;    
	    $('#sszrqdm').combobox('reload', url);
	}
}

function changeGlztxz(newValue){
	if(newValue=="0"){//查询所有未撤管的状态
		$("#glztDiv").show();
	}else{
		$("#glztDiv").hide();
	}
}
</script>