<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userId = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userId = userInfo.getUserId();
        
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>非法运营车辆列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'非法运营车辆列表',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>ffyycltjb/query',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
			            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
			            	onDblClickRow:dbClickRow
			            	">
			  <!-- 查询结果模块 -->
			    <thead>
			        <tr>
			       	 	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
			       	 	<th data-options="field:'id',     width:20,   align:'center',	halign:'center'	,sortable:true">编号</th>
				        <th data-options="field:'tjlb',     width:20,   align:'center',	halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_TJLB.js'">统计类别</th>
				        <th data-options="field:'sjxm',		width:20,	align:'center',	halign:'center'	,sortable:true">司机姓名</th>
				        <th data-options="field:'sjsfzhm',		width:20,	align:'center',	halign:'center'	,sortable:true">司机身份证号码</th>
				        <th data-options="field:'sjdh',		width:20,	align:'center',	halign:'center'	,sortable:true">司机电话</th>
				        <th data-options="field:'cpzhm',	width:20,	align:'center',	halign:'center'	,sortable:true">车牌照号码</th>
				        <th data-options="field:'process', width:30, align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
			         </tr>
				</thead>
			</table>
			<!-- 查询条件模块 -->
			<div id="datagridToolbar" style="padding:5px;height:auto" >
					
					<!-- 表格工具条按钮 -->
					<form id="queryForm" style="margin:0px;">
						<table cellspacing="0" cellpadding="0" border="0"  width="100%">
							<tbody>
							<tr>
							<td class="toolbarTd" style="width:250px">
										开始时间：<input class="easyui-validatebox" type="text" name="starttime" id="starttime" 
											data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:260px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间：<input class="easyui-validatebox" type="text" name="endtime" id="endtime" 
											data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										&nbsp;&nbsp;&nbsp;&nbsp;编号：<input class="easyui-validatebox" type="text" name="id" id="id" 
											data-options="required:false"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										&nbsp;&nbsp;统计类别：<input class="easyui-combobox" type="text" name="tjlb" id="tjlb" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_TJLB.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
									</td>
								</tr>								
								<tr>
										<td class="toolbarTd" style="width:250px">
											司机姓名：<input class="easyui-validatebox" type="text" name="sjxm" id="sjxm" 
											data-options="required:false"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:26W0px">
										司机身份证号码：<input class="easyui-validatebox" type="text" name="sjsfzhm" id="sjsfzhm" 
											data-options="required:false"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										司机电话：<input class="easyui-validatebox" type="text" name="sjdh" id="sjdh"
											data-options="required:false"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										车牌照号码：<input class="easyui-validatebox" type="text" name="cpzhm" id="cpzhm"
												data-options="required:false"  style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a class="easyui-linkbutton" iconCls="icon-add" onclick="addNew();">新增</a>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
//操作列
	function datagridProcessFormater(val, row, index) { // 自定义操作生成
			return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewDetail(this,'+index+')">查看详细</a>&nbsp;';
	} 
  
function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){
  	var starttime = document.getElementById("starttime").value;
  	var endtime = document.getElementById("endtime").value;
  	var id = document.getElementById("id").value;
  	var tjlb = document.getElementById("tjlb").value;
  	var sjxm = document.getElementById("sjxm").value;
  	var sjsfzhm = document.getElementById("sjsfzhm").value;
  	var sjdh = document.getElementById("sjdh").value;
  	var cpzhm = document.getElementById("cpzhm").value;

    var xt_lrrbm = '';
    var xt_lrrid ='';
    
	if($("#chkbox1").prop('checked')){
		
		xt_lrrid='<%=userId%>';
	}

	if($("#chkbox2").prop('checked')){
		
		xt_lrrbm='<%=userOrgCode%>';
	}
	

  	
  	$('#dg').datagrid(
  			'reload',
  			{    'starttime':starttime,
  				'endtime':endtime,
  				'id':id,
  				'tjlb':tjlb,
  				'sjxm':sjxm,
  				'sjsfzhm':sjsfzhm,
  				'sjdh':sjdh,
  				'cpzhm':cpzhm,
  				'xt_lrrid':xt_lrrid,
  				'xt_lrrbm':xt_lrrbm
  			});
  }
  
function doEdit(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/xsjbxxb/openAdd?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		//mainTabID=1
		menu_open("编辑线索",hsUrl);
  }
 
//注销单条
  function doDelete(linkObject, index) {
	  cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/xsjbxxb/delete';
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
					var json = $.parseJSON(result);
					if(json.status=="success")  topMessagerAlert(null, "注销成功","success");
					else topMessagerAlert(null, "注销失败");
					doSubmitResult(result, null, datagrid_ID);
					
					//if (json.status != 'success')
				});
			}
		});
  }
	
function dbClickRow(rowIndex,rowData){
	
	var hsUrl = "/ffyycltjb/openAdd?";
	hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("编辑线索",hsUrl);
}

function addNew(){
	var hsUrl = "/ffyycltjb/openAdd?";
	hsUrl+="&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("新增非法运营车辆",hsUrl);
}
function viewDetail(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/ffyycltjb/openAdd?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		//mainTabID=1
		menu_open("查看详细",hsUrl);
	}

    </script>
  </body>
</html>
