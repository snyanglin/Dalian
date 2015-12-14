<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userId = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userId = userInfo.getUserId();
        bjzbz = userInfo.getBjzbz();
        
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>基本线索列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'基本线索列表',border:true" style="height:auto">
			<input type='hidden' name='isGjgly' id="isGjgly"/> 
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>xsjbxxb/query',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
			            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
			            	onDblClickRow:dbClickRow
			            	">
			  <!-- 查询结果模块 -->
			    <thead>
			        <tr>
			       	 	<th data-options="field:'id',     width:20,   align:'center',	halign:'center'	,sortable:true">线索编号</th>
				        <th data-options="field:'jbsj',     width:20,   align:'center',	halign:'center'	,sortable:true">受理日期</th>
				        <th data-options="field:'jbnr',     width:20,   align:'center',	halign:'center'	,sortable:true">举报内容</th>
				        <th data-options="field:'ccjg',		width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_DCJG.js'">3日反馈结果</th>
				        <th data-options="field:'fcjg',		width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_DCJG.js'">30日反馈结果</th>
				        <th data-options="field:'xslx',		width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XSLX.js'">线索类型</th>
				        <th data-options="field:'jbxxxz',	width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_AJLB.js'">信息性质</th>
				        <th data-options="field:'xszt', 	width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XSZT.js'">线索状态</th>
				        <th data-options="field:'process',	width:22,   align:'left',	halign:'center',formatter:datagridProcessFormater">操作</th>
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
									<td style="width:220px">
										开始时间：<input class="easyui-validatebox" type="text" name="starttime" id="starttime" 
											data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
											style="width:140px;" />
									</td>
									<td style="width:10px;"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:220px">
										结束时间：<input class="easyui-validatebox" type="text" name="endtime" id="endtime" 
											data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
											style="width:140px;" />
									</td>
									<td style="width:10px;"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										3日反馈结果：<input class="easyui-combobox" type="text" name="ccjg" id="ccjg" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_DCJG.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:140px;" />
									</td>
									<td style="width:10px;"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										30日反馈结果：<input class="easyui-combobox" type="text" name="fcjg" id="fcjg" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_DCJG.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:140px;" />
									</td>
									<td style="width:10px;"><div class="datagrid-btn-separator"></div></td>
									<td style="width:240px">
										信息性质：<input class="easyui-combobox" type="text" name="jbxxxz" id="jbxxxz" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:140px;" />
									</td>
								</tr>								
								<tr>
									<td class="toolbarTd" style="width:220px">
										线索编号：<input class="easyui-validatebox" type="text" name="id" id="id" 
												data-options="required:false"  style="width:140px;" />
									</td>
									<td style="width:10px;"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:220px">
										举报内容：<input class="easyui-validatebox" type="text" name="jbnr" id="jbnr" 
												data-options="required:false"  style="width:140px;" />
									</td>
									<td style="width:10px;"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										线索类型：&nbsp;&nbsp;&nbsp;<input class="easyui-combobox" type="text" name="xslx" id="xslx" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_XSLX.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:140px;" />
									</td>
									<td style="width:10px;"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										线索状态：&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-combobox" type="text" name="xszt" id="xszt" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_XSZT.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:140px;" />
									</td>
									<td style="width:10px;"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:220px" rowspan="2">
										<label><input type="checkbox" name="chkbox" id="chkbox1"  value="1"/>显示本人录入</label>
										<label><input type="checkbox" name="chkbox" id="chkbox2" value="2"/>显示本单位录入</label>
									</td>
									
									<td class="toolbarTd" style="width:240px">
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
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}
//初始化判断该用户是不是超级管理员
$(function(){
	$.ajax({
		type:"GET",
		sync:true,
		url:contextPath+"/xsjbxxb/isGjgly",
		dataType:'json',
		success:function(data){
			$("#isGjgly").val(data.isGjgly);
		}
	});
});

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	var isGjgly = $("#isGjgly").val();
	var Process = '';
	if(((row.xt_lrrid == <%=userId%> && row.xszt == '00' && row.zcbz == '0') || isGjgly == '1')){
		// 只有录入人可以编辑并且没递转过
		Process += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;&nbsp;';
	}

	if(<%=userOrgCode%>=='210200000000'|| isGjgly == '1'){
		
		// 只有受理中心可以注销
		Process += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;&nbsp;';
	}
	
	if(row.xszt=='00'){
		//初查处理中
		Process += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCC(this, '+index+')">3日反馈</a>&nbsp;&nbsp;';
	} else if(row.xszt == '10'){
		// 复查处理中
		Process +='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doFC(this, '+index+')">30日反馈</a>&nbsp;&nbsp;';
	} 
	if(row.xszt == '20'){
		//递转中查看
		Process +='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewDzing(this, '+index+')">查看</a>&nbsp;&nbsp;';
	}
	if(row.xszt == '50'||row.xszt == '40'){
		//废弃查看、已处理查看
		Process +='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewFq(this, '+index+')">查看</a>&nbsp;&nbsp;';
	}
	if(row.xszt == '10' || row.xszt == '00' || row.xszt == '40'){
		//已关联案件
		Process +='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doAJ(this, '+index+')">相关案件</a>&nbsp;&nbsp;';
	}
	
    return Process;
    //	return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;&nbsp;&nbsp;'+
	// 	    	'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCC(this, '+index+')">初查</a>&nbsp;&nbsp;&nbsp;'+
	//	    	'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doFC(this, '+index+')">复查</a>&nbsp;&nbsp;&nbsp;'+
    //			'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doAJ(this, '+index+')">相关案件</a>&nbsp;&nbsp;&nbsp;'+
    //			'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
}
  
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){
  	var starttime = document.getElementById("starttime").value;
  	var endtime = document.getElementById("endtime").value;
  	var ccjg = document.getElementById("ccjg").value;
  	var fcjg = document.getElementById("fcjg").value;
  	var jbxxxz = document.getElementById("jbxxxz").value;
  	var xslx = document.getElementById("xslx").value;
  	var xszt = document.getElementById("xszt").value;
  	var jbnr = document.getElementById("jbnr").value;
  	var id = document.getElementById("id").value;

    var xt_lrrbm = '';
    var xt_lrrid ='';
    
	if($("#chkbox1").prop('checked')){
		
		xt_lrrid='<%=userId%>';
	}

	if($("#chkbox2").prop('checked')){
		
		xt_lrrbm='<%=userOrgCode%>';
	}
	

  	jbnr =  $.trim(jbnr);//模糊查询用
  	
  	$('#dg').datagrid(
  			'reload',
  			{    'starttime':starttime,
  				'endtime':endtime,
  				'ccjg':ccjg,
  				'fcjg':fcjg,
  				'jbxxxz':jbxxxz,
  				'xslx':xslx,
  				'xszt':xszt,
  				'jbnr':jbnr,
  				'xt_lrrid':xt_lrrid,
  				'xt_lrrbm':xt_lrrbm,
  				'id':id
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
 
//暂停
// SYS_SYRK_11.	把自动执行任务表的任务状态修改为1，同时把操作里面暂停调整为“启动”
function doStop(linkObject,index){
	
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
	var hsUrl = "/xsjbxxb/openAdd?";
	hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	var isGjgly = $("#isGjgly").val();

	if(((rowData.xt_lrrid == <%=userId%> && rowData.xszt == '00' && rowData.zcbz == '0') || isGjgly == '1')){
		// 只有录入人可以编辑并且没递转过
		menu_open("编辑线索",hsUrl);
	}
	
}

function addNew(){
	var hsUrl = "/xsjbxxb/openAdd?";
	hsUrl+="&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("新增线索",hsUrl);
}

function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}

//初查
function doCC(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/xsjbxxb/openCC?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("初查线索",hsUrl);
}

//复查
function doFC(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/xsjbxxb/openFC?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("复查线索",hsUrl);
}

// 查看案件
function doAJ(linkObject, index){
	
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = '/xsjbxxb/openXgaj?';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	hsUrl+="xsId="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("相关案件列表",hsUrl);
	
}

//废弃查看
function viewFq(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/xsjbxxb/openXsckLog?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	hsUrl+="xsbh="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("查看详细",hsUrl);
}
//递转中，查看
function viewDzing(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/xsjbxxb/openXsDz?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	hsUrl+="xsbh="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("查看详细",hsUrl);
}

    </script>
  </body>
</html>
