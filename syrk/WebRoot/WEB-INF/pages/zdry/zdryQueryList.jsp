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
    <script type="text/javascript" src="<%=contextPath%>/js/zdry/zdryzbQuery.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'west',border:false" style="width:538px;">
           <!-- 地址管理列表 -->
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/zdryzb/queryZdryOnPT',
						onLoadSuccess:function(data){ZdryManage.loadPoint(data,'dg');},
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(335),
		        		pageList:[getAutoPageSize(335),
		        		getAutoPageSize(335) * 2],
		        		singleSelect:true,
		        		fitColumns:true,
						toolbar:'#datagridToolbar',
						onClickRow:ZdryManage.onClickRow">
			        <thead>
			          <tr>
				            <th data-options="field:'zdrygllxdm',width:70,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'">类型</th>
				            <th data-options="field:'zjhm',width:120,align:'left',sortable:true,halign:'center'">身份证号码</th>
				            <th data-options="field:'xm',width:70,align:'left',sortable:true,halign:'center'">姓名</th>
				            <th  data-options="field:'dz_jzdzmlpxz',width:200,align:'right',halign:'center',sortable:true">居住地址</th>
				             <th  data-options="field:'ryid',hidden:true"></th>
				             <th  data-options="field:'dz_jzdzmlpdm',hidden:true"></th>
				             <th  data-options="field:'syrkid',hidden:true"></th>
				            <th data-options="field:'zbx',hidden:true"></th>
				            <th data-options="field:'zby',hidden:true"></th>
				            <th data-options="field:'process',align:'center',width:100,halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
			       </thead>
	       </table>
	       <div id="datagridToolbar" style="padding:5px;height:auto">
				<form id="queryForm">
				   <input type="hidden" id ="zbz" value="">
				    <input type="hidden" id ="type" value="">
				    <input type="hidden" id ="mapRadius" value="">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">分市县局：</td>
						<td width="80%" class="dialogTd" colspan="3"><input
							type="text" name="ssfxjdm" id="ssfxjdm" 
							class="easyui-combobox" style="width:200px;"
							data-options="url: contextPath +'/orgPublicSelect/queryComboBoxList?orgLevel=21',required:false,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,onChange:ssfxjdm_onChange,isTopLoad:false">
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">所属派出所：</td>
						<td width="80%" class="dialogTd" colspan="3"><input
							type="text" name="sspcsdm" id="sspcsdm" class="easyui-combobox"
							style="width:200px;"
							data-options="required:false,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,onChange:sspcsdm_onChange,isTopLoad:false">
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">所属责任区：</td>
						<td width="80%" class="dialogTd" colspan="3"><input
							type="text" name="sszrqdm" id="sszrqdm" class="easyui-combobox"
							style="width:200px;"
							data-options="required:false,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
						</td>
					</tr>
					<tr class="dialogTr">
						    	
							    <td width="20%" class="dialogTd" align="right">姓名：</td>
						    	<td width="30%" class="dialogTd"><input type="text" name="xm" id ="xm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"   /></td>
								<td width="20%" class="dialogTd" align="right">重点人员类型：</td>
						    	<td width="30%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="zdrygllxdm" name="zdrygllxdm" style="width:130px;" 
									data-options="url: contextPath + '/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>	
					   	</tr>	
				        <tr class="dialogTr">
						    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
						    	<td width="30%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:130px;" 
									data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>	
						    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
						    	<td width="30%" class="dialogTd"><input type="text" id="zjhm" name="zjhm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  /></td>					   
					    </tr>				
					    <tr class="dialogTr">
						    	<td width="20%" class="dialogTd" align="right">民族：</td>
						    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:130px;"
									data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
					    		<td width="20%" class="dialogTd" align="right">性别：</td>
						    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:130px;"
									data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
					    </tr>
					      <tr class="dialogTr">
						    	<td width="20%" class="dialogTd" align="right">管理状态：</td>
						    	<td width="30%" class="dialogTd">
						    	<select class="easyui-combobox" id="glzt" name="glzt" style="width:130px;">
						    	<option value="0">未撤管</option>
						    	<option value="1"> 已撤管</option>
						    	</select>
					    </tr>
					<tr class="dialogTr">
						<td class="dialogTd" align="center" colspan="4">
							<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="queryButton()">查询</a>
								 &nbsp;&nbsp;
								 <a href="javascript:void(0)" class="easyui-linkbutton" 
								 	iconCls="icon-reset" onclick="resetButton()">重置</a>
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
$(document).ready(function(){

	$('#zdrygllxdm').combobox('setDataFilter', '^0[1-8]{1,1}$');

});


 function datagridProcessFormater(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateAndXq(this, '+index+')">查看</a>&nbsp;' ;
};

 function doUpdateAndXq(linkObject, index){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
    menu_open(rowData.xm +'','/zdry/'+rowData.ryid+'/'+rowData.syrkid+'/view'+'?mainTabID='+getMainTabID()+'&mode=view');
};
//查询按钮
function queryButton(){
	var xm = $("#xm").val();
	var zjhm = $("#zjhm").val();
	var xbdm = $("#xbdm").val();
	var mzdm = $("#mzdm").val();
	var cyzjdm = $("#cyzjdm").val();
	var zdrygllxdm = $("#zdrygllxdm").val();
	var ssfxjdm=$("#ssfxjdm").val();
	var sspcsdm=$("#sspcsdm").val();
	var sszrqdm=$("#sszrqdm").val();
	var zbz = $("#zbz").val();
	var type = $("#type").val();
	var mapRadius = $("#mapRadius").val();
	var glzt =$("#glzt").val();
	xm= $.trim(xm);
	$('#dg').datagrid(
			'load',
			{    
				'zdrygllxdm':zdrygllxdm,
				'xm': xm,   
				'zjhm': zjhm ,
				'cyzjdm':cyzjdm,
				'xbdm':xbdm,
				'mzdm':mzdm,
				'ssfxjdm':ssfxjdm,
				'sspcsdm':sspcsdm,
				'sszrqdm':sszrqdm,
				'type':type,
				'mapRadius':mapRadius,
				'zbz':zbz,
				'glzt':glzt
			});
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
//新增列管
function addLg(){
	
	
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
</script>