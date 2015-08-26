<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>恳谈会信息</title>
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'恳谈会信息',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>fwqz/queryKthb',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,
			            checkOnSelect:true,
			            border:false,
			            sortOrder:'desc',
			            sortName:'',
			            idField:'id',
			            pageSize:getAutoPageSize(175),
			            pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2]">
							    <thead>
							        <tr>
							            <th data-options="field:'zksj', 	width:10,	align:'center',	halign:'center',sortable:true">召开时间</th>
							            <th data-options="field:'zzr', 	width:30,	align:'center',	halign:'center',sortable:true">组织人</th>
							            <th data-options="field:'yhr', 	width:20,	align:'center',	halign:'center',sortable:true">与会人</th>
							            <th data-options="field:'hynr', 	width:20,	align:'center',	halign:'center',sortable:true">与会内容</th>
							            <th  data-options="field:'xt_lrrbmid',hidden:true">xt_lrrbmid</th>
							            <th data-options="field:'process',	 width:10,align:'center',	halign:'center',	formatter:datagridProcessFormater">操作</th>
							        </tr>
							    </thead>
				</table>
					<div id="datagridToolbar" style="padding:5px;height:auto" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" >
							<tbody>
							
							<tr class="dialogTr">
								<td class="toolbarTd">
									会议内容：<input type="text" name="hynr" id ="hynr" class="easyui-validatebox" 
									 		data-options="required:false,validType:'maxLength[20]'"  
											 />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
									与会人：<input type="text" name="yhr" id ="yhr" class="easyui-validatebox" 
									 		data-options="required:false,validType:'maxLength[20]'"  
											 />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
										召开时间起：<input type="text" name="startDate" id="startDate" class="easyui-validatebox " 
														data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
													onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\') }'})" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
										召开时间止：<input type="text" name="endDate" id="endDate" class="easyui-validatebox " 
														data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
													onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\') }'})" />
								</td>
								</tr>
								
								<tr class="dialogTr">
								<td class="toolbarTd" colspan="7" align="right">
									<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>&nbsp;
									<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();">重置</a>&nbsp;
									<a class="easyui-linkbutton" iconCls="icon-add" onclick="add();">新增</a>
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

function info(linkObject, index){
	
	cancelBubble();
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	//var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	
	var hsUrl = "/fwqz/kthInFo?";
	hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
	menu_open("恳谈会信息",hsUrl);
}
var zzjgdmPd = "<%=userOrgCode%>";
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	if(row.xt_lrrbmid==zzjgdmPd){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;'+
		'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
    		  
	}else {
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="info(this, '+index+')">详情</a>&nbsp;'+
			 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
	}
    	
}
  
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){
  	var hynr = document.getElementById("hynr").value;
  	var yhr = document.getElementById("yhr").value;
	var startDate = document.getElementById("startDate").value;
  	var endDate = document.getElementById("endDate").value;
  	
  	hynr= $.trim(hynr);
  	yhr= $.trim(yhr);
  	startDate= $.trim(startDate);
  	endDate= $.trim(endDate);
	
	
  	$('#dg').datagrid(
  			'reload',
  			{    
  				'hynr': hynr ,
  				'yhr':yhr,
  				'startDate':startDate,
  				'endDate':endDate
  			});
  }
  
function doEdit(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/fwqz/addKthb?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
	//	var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("恳谈会信息编辑" ,hsUrl);
  }
  
//注销单条
  function doDelete(linkObject, index) {
	  cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/fwqz/deleteKthb';
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
					doSubmitResult(result, null, datagrid_ID);
				});
			}
		});
  }
	
function dbClickRow(rowIndex,rowData){
	var hsUrl = "/fwqz/kthInFo?";
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("恳谈会信息" + rowData.xm,hsUrl);
}

function add(){
	var hsUrl = "/fwqz/addKthb?";
	hsUrl+="&mainTabID="+getMainTabID();
	menu_open("恳谈会信息新增",hsUrl);
}

function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}
    </script>
  </body>
</html>
