<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>通知公告</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'通知公告',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>tzgg/queryList',toolbar:'#datagridToolbar',
			            singleSelect:true,
			            selectOnCheck:true,
			            checkOnSelect:true,
			            border:false,
			            sortOrder:'desc',
			            sortName:'fssj',
			            idField:'id',
			            pageSize:getAutoPageSize(),
			            pageList:[getAutoPageSize(),getAutoPageSize() * 2]
			            	">
							    <thead>
							        <tr>
							            <th data-options="field:'ggbt', 	width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr">公告标题</th>
							            <th data-options="field:'ggnr', 	width:25,	align:'left',	halign:'center',sortable:true,formatter:subStr">公告内容</th>
							            <th data-options="field:'fbztdm',	width:5,	align:'center' ,sortable:true,formatter:fbzt">发布状态</th>
							            <th data-options="field:'fsr', width:5,	align:'center',	halign:'center',sortable:true	">发送人</th>
							            <th data-options="field:'fsbm', width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr	">发送部门</th>
							            <th data-options="field:'fssj', width:10,	align:'center',	halign:'center',sortable:true	">发送时间</th>
							            <th data-options="field:'process',	 width:10,align:'center',	halign:'center',	formatter:datagridProcessFormater">操作</th>
							        </tr>
							    </thead>
							</table>
					<div id="datagridToolbar" style="padding:5px;height:48px;width:100%">
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1200">
							<tbody>
							<tr class="dialogTr">
								<td class="toolbarTd">
									消息标题：<input type="text" name="ggbt" id ="ggbt" class="easyui-validatebox" 
									 		data-options="required:false,validType:'maxLength[20]'"  
											 />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
									发送人：<input type="text" name="fsr" id ="fsr" class="easyui-validatebox" 
									 		data-options="required:false,validType:'maxLength[20]'"  
											 />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
										发送部门：
									   	<input type="hidden" id="fsbmid" name="fsbmid" value="" style="width: 100;" />
									    <input  class="easyui-validatebox" type="text" id="fsbm" name="fsbm" style=";" value="" />
									   	<input type="hidden" id="orgid3" name="orgid3" value="" style="width: 100;" />
									    <input type="button" id="orgbutton3" value="选择" onClick="public_singleSelectOrg('', '01', '50', '01,01,03,04', 'fsbmid', 'fsbm', 'orgid3', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
								
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
										发送开始时间：<input type="text" name="startDate" id="startDate" class="easyui-validatebox " 
														data-options="validType:['date[\'yyyy-MM-dd HH:mm:ss\']'],tipPosition:'right'" 
													onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endDate\') }'})" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
										发送结束时间：<input type="text" name="endDate" id="endDate" class="easyui-validatebox " 
														data-options="validType:['date[\'yyyy-MM-dd HH:mm:ss\']'],tipPosition:'right'" 
													onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startDate\') }'})" />
								</td>
								</tr>
								<tr class="dialogTr">
								<td class="toolbarTd" colspan="9" align="right">
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
    function subStr(val, row, index){
    	var str="";
    	if(val.length>30){
    		if(val.length>1){
        		str = val.substring(0,30);
        	}	
    		return str+"...";
    	}
    	
    	return val;
    	
    }
    
    function add(){
    		var hsUrl = "/tzgg/addTzgg?";
    		hsUrl+="&mainTabID="+getMainTabID()+"&mode=add";
    		menu_open("通知公告添加",hsUrl);
    }

  //查询按钮
    function queryButton(){
  		var ggbt = document.getElementById("ggbt").value;
  		var fsr = document.getElementById("fsr").value;
  		var fsbm = document.getElementById("fsbm").value;
  		var fsbmid = document.getElementById("fsbmid").value;
  		var startDate = document.getElementById("startDate").value;
  		var endDate = document.getElementById("endDate").value;
  		
  		ggbt= $.trim(ggbt);
  		fsr= $.trim(fsr);
  		fsbm= $.trim(fsbm);
  		fsbmid = $.trim(fsbmid);
  		startDate= $.trim(startDate);
  		endDate= $.trim(endDate);
  		
  		$('#dg').datagrid(
  				'reload',
  				{    
  					'ggbt':ggbt,
  					'fsr':fsr,
  					'fsbm':fsbm ,
  					'fsbmid':fsbmid,
  					'startDate':startDate,
  					'endDate':endDate
  				});
    }
  
    function fbzt(val, row, index){
  		if(val=="1"){
  			return "未发布";
  		}else if(val=="0"){
  			return "已发布";
  		}  	
    }
  
   	function clearCase(){
  	  $("#queryForm").form("reset");
    }   
  //操作列
 	function datagridProcessFormater(val, row, index) { // 自定义操作生成
	  
	  if(row.fbztdm=="1"){
		  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit1(this,'+index+')">编辑</a>&nbsp;&nbsp;'+
		  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="send(this, '+index+')">发布</a>&nbsp;&nbsp;';
	  }else{
		   //'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit1(this,'+index+')">编辑</a>&nbsp;&nbsp;'+
		   return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="inFo(this, '+index+')">查看</a>&nbsp;&nbsp;';
	  }
    	
    }
  
  	function inFo(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/tzgg/tzggInfo?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("通知公告详情",hsUrl);
  }
  //
  	function doEdit1(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/tzgg/addTzgg?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID()+"&mode=edit";
		menu_open("通知公告编辑",hsUrl);
  }
  //
 	function send(linkObject, index){
	  cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	    var hsUrl = "/tzgg/addTzgg?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID()+"&mode=send";
		menu_open("通知公告发布",hsUrl);
		
  }
	function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}
	
	</script>
	
  </body>
</html>
