<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>从业人员核实列表</title>
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'从业人员核实列表',border:false" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>shhxxcj/queryCyryList?enterpriseid=${emEnterpriseId}',
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
							         
							            <th data-options="field:'hszt',width:5,align:'center',	halign:'center'	,sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_HSZT.js'">核实状态</th>
							            <th data-options="field:'xm', 	width:30,	align:'center',	halign:'center',sortable:false">姓名</th>
							            <th data-options="field:'zjhm', width:30,	align:'center',	halign:'center',sortable:false">证件号码</th>
							           	<th data-options="field:'hjdz',width:30,align:'center',	halign:'center'	,sortable:false">户籍地址</th>
							            <th data-options="field:'xzdz',width:30,	align:'center',	halign:'center',sortable:false">暂住地址</th> 
							           	<th data-options="field:'lxdh',width:10,align:'center',	halign:'center'	,sortable:false">联系电话</th>
							           	<th data-options="field:'ygh',width:10,align:'center',	halign:'center'	,sortable:false">员工号</th>
							           	
							            <th data-options="field:'process',	 width:15,align:'center',halign:'center',	formatter:datagridProcessFormater">操作</th>
							        </tr>
							    </thead>
							</table>
					<div id="datagridToolbar" style="padding:5px;height:70px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1000">
							<tbody>
						
								<tr>
									<td class="toolbarTd" style="width:700px;font-size: 15" align="left">
										单位名称：<span style="font-size: 15">${emDwmc}</span>
									
									</td>
							     </tr>
							     </br>
								<tr align="right">
									<td class="toolbarTd" style="width:1000px" align="right">
										姓名：<input type="text" name="xm" id ="xm" class="easyui-validatebox"
										style="width:150px"  />
								  &nbsp;
										证件号码：<input type="text" name="zjhm" id ="zjhm" class="easyui-validatebox"
										style="width:150px"  />
									</td>
								
								
									
									<td class="toolbarTd" style="width:200px" align="right">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
										&nbsp;
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

var emEnterpriseHszt=${emEnterpriseHszt}
//操作列
function datagridProcessFormater(val, row, index) { 
	
	var url="";
	// 自定义操作生成
	if(emEnterpriseHszt=="0"){
		url= '';
	}
	else if(emEnterpriseHszt=="1" && row.hszt=="1"){
		url= '已核实';
		
	}else if(emEnterpriseHszt=="1" && row.hszt=="0"){

		url= '<a class="link" href="javascript:javascript:void(0)" onclick="doHs(this,'+index+')">核实</a>';

	}
    return url;
}

function doHs(linkObject,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	menu_open('从业人员核实','/shhxxcj/cyryhs?emEmployeeId='+id+'&mainTabID='+getMainTabID()+'&invokeJSMethod=queryButton');
		
	
}

function clearCase(){
	  $("#queryForm").form("reset");
}


//查询按钮
function queryButton() {
		var xm = $("#xm").val();
		var zjhm = $("#zjhm").val();
	
		$('#dg').datagrid('reload', {
			'xm' : xm,
			'zjhm' : zjhm
		});
	
	
}



    </script>
  </body>
</html>
