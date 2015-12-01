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
            <div data-options="region:'center',split:true,title:'承租人核实列表',border:false" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>shhxxcj/queryCzrList?houseid=${houseId}',
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
							            <th data-options="field:'czrlb', 	width:30,	align:'center',	halign:'center',sortable:false">人员类型</th>
							            <th data-options="field:'czrzjhm', width:30,	align:'left',	halign:'center',sortable:false">证件号码</th>
							           	<th data-options="field:'czrzwxm',width:5,align:'left',	halign:'center'	,sortable:false">姓名</th>
							           	<th data-options="field:'czrhjdz',width:30,align:'center',	halign:'center'	,sortable:false">户籍地址</th>
							           	<th data-options="field:'czrlxdh',width:10,align:'center',	halign:'center'	,sortable:false">联系电话</th>
							            <th data-options="field:'czrczqk',width:30,	align:'center',	halign:'center',sortable:false">承租情况</th>
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
										居住地址：<span style="font-size: 15">${houseDz }</span>
									
									</td>
							     </tr>
							     </br>
								<tr align="right">
									<td class="toolbarTd" style="width:1000px" align="right">
										姓名：<input type="text" name="czrzwxm" id ="czrzwxm" class="easyui-validatebox"
										style="width:110px"  />
								
										证件号码：<input type="text" name="czrzjhm" id ="czrzjhm" class="easyui-validatebox"
										style="width:110px"  />
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

var czfwhszt=${czfwhszt}
//操作列
function datagridProcessFormater(val, row, index) { 
	var url="";
	// 自定义操作生成
	if(row.syrkid && row.hszt=="0"){
		url= '<a class="link" href="javascript:javascript:void(0)" onclick="doHs(this,'+index+')">核实</a>';
		
	}else if(row.syrkid && row.hszt=="1"){

		url= '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">详情</a>';

	}else if(!row.syrkid && czfwhszt=='1'){
		url= '<a class="link" href="javascript:javascript:void(0)" onclick="doSyrkAdd(this,'+index+')">新增实有人口</a>';

	}else if(!row.syrkid && czfwhszt=='0'){
		url= '';

	}
    return url;
}
function doEdit(linkObject, index) {
	//阻止冒泡，不然要执行onClickRow
    cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	console.log(rowData);
	var editUrl = "/syrkEdit/"+rowData.ryid+"/"+rowData.syrkid+"/view";
	if(rowData.xm){
		menu_open("实有人口【"+rowData.czrzwxm+"】",editUrl);
	}else{
		menu_open("实有人口",editUrl);
	}
};
function doHs(linkObject,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	menu_open('承租人核实','/shhxxcj/addCzqk?czrId='+id+'&houseid='+rowData.houseid+'&syrkid='+rowData.syrkid+'&mainTabID='+getMainTabID()+'&invokeJSMethod=queryButton');
		
	
}
function doSyrkAdd(linkObject,index){
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		var id = rowData.id;
		menu_open('实有人口新增','/shhxxcj/syrkAdd?zjhm='+rowData.czrzjhm+'&mainTabID='+getMainTabID()+'&invokeJSMethod=queryButton');

}
function clearCase(){
	  $("#queryForm").form("reset");
}


//查询按钮
function queryButton() {
		var czrzwxm = $("#czrzwxm").val();
		var czrzjhm = $("#czrzjhm").val();
	
		$('#dg').datagrid('reload', {
			'czrzwxm' : czrzwxm,
			'czrzjhm' : czrzjhm	
		});
	
	
}



    </script>
  </body>
</html>
