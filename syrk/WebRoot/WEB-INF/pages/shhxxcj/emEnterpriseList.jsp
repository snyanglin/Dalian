<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>单位核实列表</title>
  </head>

  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'单位核实列表',border:false" style="height:auto;">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>shhxxcj/queryEmEnterpriseList',
			            method:'POST',
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		pageSize:'20',
		        		pageList:['20','40'],
		        		singleSelect:false,
		        		fitColumns:true,
						toolbar:'#datagridToolbar'
			            	">
							    <thead>
							        <tr>
							         
							            <th data-options="field:'hszt',width:10,align:'center',	halign:'center'	,sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_HSZT.js'">单位状态</th>
							            <th data-options="field:'dwmc',width:29,align:'center',	halign:'center'	,sortable:false">单位名称</th>							            
							            <th data-options="field:'dwlb',width:10,align:'center',	halign:'center'	,sortable:false">单位类别</th>							            							            
							            <th data-options="field:'dwdz', width:30,	align:'center',	halign:'center',sortable:false">单位地址</th>
							            <th data-options="field:'bzdzid', width:30,	align:'center',	halign:'center',sortable:false">单位标准地址</th>
							           	<th data-options="field:'jyxz',width:12,align:'center',	halign:'center'	,sortable:false">经营性质</th>
							           	<th data-options="field:'lxdh',width:10,align:'center',	halign:'center'	,sortable:false">联系电话</th>
							            <th data-options="field:'pcscode',width:12,	align:'center',	halign:'center',sortable:false">所属派出所</th>
							            <th data-options="field:'process',	 width:25,align:'center',halign:'center',	formatter:datagridProcessFormater">操作</th>
							        </tr>
							    </thead>
							</table>
					<div id="datagridToolbar" style="padding:5px;height:40px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="800">
							<tbody>
						
								
								<tr>
									<td class="toolbarTd" style="width:550px" align="right">
										单位名称：<input type="text" name="dwmc" id ="dwmc" class="easyui-validatebox"
										style="width:150px"  />
									</td>
				
									<td class="toolbarTd" style="width:620px" align="right">
										核实状态：	<input class="easyui-combobox" type="text"  id="hszt" name="hszt"   style="width:150px;" value=""
					                      data-options="url: contextPath +  '/common/dict/BD_D_HSZT.js',
					                       valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									
									</td>
								
									
									<td class="toolbarTd" style="width:850px" align="right">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
										&nbsp;&nbsp;
									    <a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();">重置</a>
									</td>
									
								</tr>
							
							</tbody>
						</table>
					</form>
				</div>
	</div>
	</div>
	</div>
	
	
<script language="javascript">

</script>	
<script type="text/javascript">



//操作列
function datagridProcessFormater(val, row, index) { 
	// 自定义操作生成
	if(row.hszt=="1"){
		return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">详情</a>&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="frfzrView(this,'+index+')">法人/负责人</a>&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cyryView(this,'+index+')">从业人员</a>';
		
	}else{

		return '<a class="link" href="javascript:javascript:void(0)" onclick="doHs(this,'+index+')">核实</a>&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="frfzrView(this,'+index+')">法人/负责人</a>&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cyryView(this,'+index+')">从业人员</a>';

	}
    return 
}
function doEdit(linkObject, index) {
	//阻止冒泡，不然要执行onClickRow
    cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl_dl/view?id="+rowData.sydwid;
	menu_open("实有单位编辑",editUrl);
};
function doHs(linkObject,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	menu_open('实有单位核实','/shhxxcj/sydwhs?id='+id+'&mainTabID='+getMainTabID()+'&invokeJSMethod=queryButton');
		
	
}

function frfzrView(linkObject,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	menu_open('法人/负责人','/shhxxcj/frfzrList?ementerpriseid='+id);
		
	
}
function cyryView(linkObject,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	menu_open('从业人员','/shhxxcj/cyryList?emEnterpriseId='+id);
		
	
}

function clearCase(){
	  $("#queryForm").form("reset");
}


//查询按钮
function queryButton() {
		var dwmc = $("#dwmc").val();
		var hszt = $("#hszt").val();
		
		$('#dg').datagrid('reload', {
			'dwmc' : dwmc,
			'hszt' : hszt			
		});
	
	
}



    </script>
  </body>
</html>
