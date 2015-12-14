<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>出租房屋核实列表</title>
  </head>

  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'出租房屋核实列表',border:false" style="height:auto;">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>shhxxcj/queryHousesList',
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
							         
							            <th data-options="field:'hszt',width:10,align:'center',	halign:'center'	,sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_HSZT.js'">房屋状态</th>
							            <th data-options="field:'fwxz', 	width:30,	align:'center',	halign:'center',sortable:false">房屋地址</th>
							            <th data-options="field:'bzdzid', width:30,	align:'left',	halign:'center',sortable:false">房屋标准地址</th>
							           	<th data-options="field:'xm',width:8,align:'left',	halign:'center'	,sortable:false">房主姓名</th>
							           	<th data-options="field:'fzsfzh',width:15,align:'center',	halign:'center'	,sortable:false">房主证件号码</th>
							           	<th data-options="field:'fzyddh',width:10,align:'center',	halign:'center'	,sortable:false">房主电话</th>
							            <th data-options="field:'fzxdz',width:26,	align:'center',	halign:'center',sortable:false">房主现地址</th>
							           	<th data-options="field:'czrq',width:10,align:'center',	halign:'center',sortable:false">出租日期</th>
							            <th data-options="field:'fwszdpcscod',width:12,align:'center',	halign:'center'	,sortable:false">所在地派出所</th>
							           	<th data-options="field:'enterpriseid',width:10,align:'center',	halign:'center'	,sortable:false">录入单位</th>
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
									<td class="toolbarTd" style="width:550px" align="right">
										房屋地址：<input type="text" name="fwxz" id ="fwxz" class="easyui-validatebox"
										style="width:110px"  />
									</td>
									<td class="toolbarTd" style="width:550px" align="right">
										房主姓名：<input type="text" name="xm" id ="xm" class="easyui-validatebox"
										style="width:110px"  />
									</td>
									<td class="toolbarTd" style="width:620px" align="right">
										房主证件号码：<input type="text" name="fzsfzh" id ="fzsfzh" class="easyui-validatebox"
										style="width:110px"  />
									</td>
									<td class="toolbarTd" style="width:620px" align="right">
										房屋状态：	<input class="easyui-combobox" type="text"  id="hszt" name="hszt"   style="width:100px;" value=""
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
	if(row.bzdzid){
		return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">详情</a>&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="czrView(this,'+index+')">核实承租人</a>';;
		
	}else{

		return '<a class="link" href="javascript:javascript:void(0)" onclick="doHs(this,'+index+')">核实</a>&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="czrView(this,'+index+')">查看承租人</a>';;

	}
    return 
}
function doEdit(linkObject, index) {
	//阻止冒泡，不然要执行onClickRow
    cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syfw/"+rowData.syfwid+"/main"+'?&mainTabID='+getMainTabID();
	menu_open("实有房屋编辑",editUrl);
};
function doHs(linkObject,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	menu_open('出租房屋核实','/shhxxcj/czfwhs?id='+id+'&mainTabID='+getMainTabID()+'&invokeJSMethod=queryButton');
		
	
}

function czrView(linkObject,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	menu_open('承租人','/shhxxcj/czrList?housesId='+id);
		
	
}

function clearCase(){
	  $("#queryForm").form("reset");
}


//查询按钮
function queryButton() {
		var fwxz = $("#fwxz").val();
		var xm = $("#xm").val();
		var fzsfzh = $("#fzsfzh").val();
		var hszt = $("#hszt").val();
		
		$('#dg').datagrid('reload', {
			'fwxz' : fwxz,
			'xm' : xm,
			'fzsfzh' : fzsfzh,
			'hszt' : hszt			
		});
	
	
}



    </script>
  </body>
</html>
