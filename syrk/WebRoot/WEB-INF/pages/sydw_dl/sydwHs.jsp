<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>实有单位核实</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'实有单位核实',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" 
			data-options="url:'<%=basePath %>sydwcx_dl/queryDwHs',
			delayCountUrl:'<%=basePath %>sydwcx_dl/queryCountSydwHs',
			onLoadSuccess:function(data){ beforeTableLoad(data,'dg');},
			toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,
			            checkOnSelect:true,
			            border:false,
			            idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2],
			            onDblClickRow:dbClickRow1
			            	">
							    <thead>
							        <tr>
							       	 	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
							            <th data-options="field:'dwlbdm',	width:10,	align:'left' ,sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_DWLB.js'">类别</th>
							            <th data-options="field:'dwmc', 	width:10,	align:'left',	halign:'center',sortable:true">单位名称</th>
							            <!-- <th data-options="field:'dwbm', 	width:10,	align:'left',	halign:'center',sortable:true">单位别名</th>
							            <!-- 
							            <th data-options="field:'xm', 	width:10,	align:'left',	halign:'center'	,sortable:true">姓名</th>
							            <th data-options="field:'xbdm',	width:5,	align:'left',	halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
							           	<th data-options="field:'mzdm', 	width:5,	align:'left',	halign:'center',sortable:true,	formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_MZ.js'">民族</th>
							            -->
							            <th data-options="field:'jyxzdm',	width:10,	align:'left' ,sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_JYXZDM.js'">经营性质</th>
							           	<!-- ,formatter:subjzdz -->
							            <th data-options="field:'dz_dwdzxz', width:20,	align:'left',	halign:'center',sortable:true	">单位详址</th>
							            <th data-options="field:'process',	 width:10,align:'center',	halign:'center',	formatter:datagridProcessFormater">操作</th>
							        </tr>
							    </thead>
							</table>
					<div id="datagridToolbar" style="padding:5px;height:auto;">
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0">
							<tbody>
							<tr>
								<td class="toolbarTd" >
									单位类型：<input class="easyui-combobox" type="text" id="dwlbdm" name="dwlbdm"
											data-options="url: contextPath + '/common/dict/D_DW_DWLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" 
											/>
								</td>
								
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
									单位名称：<input type="text" name="dwmc" id ="dwmc" class="easyui-validatebox" 
									 		data-options="required:false,validType:'maxLength[20]'"  
											 />
								</td>
								
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" >
									单位地址：<input type="text" name="dz_dwdzxz" id ="dz_dwdzxz" class="easyui-validatebox" 
											data-options="required:false,validType:'maxLength[30]'" 
									  /></td>
								</tr>
								
								
								
								<tr>
								<td class="toolbarTd">
								经营性质：<input class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm" 
										data-options="url: contextPath + '/common/dict/D_DW_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"
										
								/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" >
									经营范围：<input class="easyui-validatebox" type="text" id="jyfwzy" name="jyfwzy"
												data-options="required:false,validType:'maxLength[30]'" 
												/>
								</td>
								
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
									<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" style="margin-right: 10px;">查询</a>
									<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();">重置</a>
									<a class="easyui-linkbutton" iconCls="icon-add" onclick="batchHs();">批量核实</a>
								</td>
							</tr>
							
							
							</tbody>
						</table>
					</form>
				</div>
	</div>
	</div>
	</div>


	
	<div id="win" class="easyui-window" title="实有单位核实注销" style="width:700px;height:200px"   
        data-options="iconCls:'icon-save',modal:true,
        closed:true,
        collapsible:false,
        minimizable:false,
        maximizable:false"> 
        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
	       	<tr>
	       		<td align="center"> 
	       		<input type="hidden" id ="id" value="">
		       		<textarea id="xt_zxyy"  onblur="if(value==''){value='请输入注销原因...';}" onfocus="if(value=='请输入注销原因...'){value='';}" title="添加注销原因"
		       			class="easyui-validatebox" style="width: 613px; height:78px;"
							data-options="validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"
		       		>请输入注销原因...</textarea>
	       		</td>
	       	</tr>
	       <tr>
	       		<td align="right">
	       			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updateHs();">确定</a>
					<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
					<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
	       		</td>
	       </tr>
        </table>
</div> 
	
    <script type="text/javascript">
  //截地址字段
    function subjzdz(val, row, index){
    	if(val.indexOf("辽宁省大连市")>=0){
    		val = val.substring(val.lastIndexOf("市")+1,val.length);
    	}
    	if(val.indexOf("辽宁省")>=0){
    		val = val.substring(val.lastIndexOf("省")+1,val.length);
    	}
    	//var searchKey = "美丽巷";
    	//var regExp = new RegExp(searchKey, "igm");
    	//val = val.replace(regExp, "<font color=\"#FF0000\">"+ searchKey +"</font>");
    	return val;
    }
  //操作列
    function datagridProcessFormater(val, row, index) { // 自定义操作生成
    	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit1(this,'+index+')">核实</a>&nbsp;'
    			+
    		  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCancel(this, '+index+')">注销</a>&nbsp;';
    }
  
  function clearCase(){
	  $("#queryForm").form("reset");
  }
  
//查询按钮
  function queryButton(){
		var dwlbdm = document.getElementById("dwlbdm").value;
		var dwmc = document.getElementById("dwmc").value;
		var dz_dwdzxz = document.getElementById("dz_dwdzxz").value;
		var jyfwzy = document.getElementById("jyfwzy").value;
		var jyxzdm = document.getElementById("jyxzdm").value;
		
		dz_dwdzxz= $.trim(dz_dwdzxz);
		dwmc= $.trim(dwmc);
		jyfwzy= $.trim(jyfwzy);
		
		$('#dg').datagrid(
				'load',
				{    
					'dwlbdm':dwlbdm,
					'dwmc':dwmc,
					'dz_dwdzxz':dz_dwdzxz,
					'jyfwzy':jyfwzy,
					'jjlxdm':jyxzdm
				});
  }
  //
  function doEdit1(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/dwjbxxb_dl/createHs?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		hsUrl+="dwidString="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("实有单位核实",hsUrl);
  }
  
//注销单条
  function doDelete(linkObject, index) {
	  cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/ryjzdzzb/delete';
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

	function dbClickRow1(rowIndex,rowData){
		var hsUrl = "/dwjbxxb_dl/createHs?";
		hsUrl+="dwidString="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("实有单位核实",hsUrl);
	}
	
	/**
	*批量核实
	**/
	function batchHs(){
		var hsUrl = "/dwjbxxb_dl/createHs?";
		var  getSelections = $("#dg").datagrid("getSelections");
		var len = getSelections.length;
		var idstr="";
		if(len>=1){
			for(var i=0;i<len;i++){
				idstr+=getSelections[i].id +",";
			}
			idstr = idstr.substring(0, idstr.length-1);		
			hsUrl+="dwidString="+idstr +"&mainTabID="+getMainTabID();
			menu_open("实有单位核实",hsUrl);
		}else{
			alert("请选择批量核实记录");
		}
			
	}
	
	function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('load');
	}
	
	//注销action
	function doCancel(linkObject, index){
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		document.getElementById("xt_zxyy").value ="请输入注销原因...";
		document.getElementById("id").value =rowData.id;
		$("#win").window("open"); 
	}
	
	//注销后台操作
	function updateHs(){
		var sydwHsUrl= contextPath+"/sydwcx_dl/updateHs";
		var xt_zxyy = document.getElementById("xt_zxyy").value;
		var id = document.getElementById("id").value;
		if(xt_zxyy!="" ){
			if(xt_zxyy.length>100){
				return;
			}else{
				$.ajax({
					type:"GET",
					sync:true,
					url:sydwHsUrl,
					data:{'id':id,'xt_zxyy':xt_zxyy,'xt_zxbz':1},
					dataType:'json',
					success:function(json){
						if(json==1){
							$.messager.alert("提示","实有单位注销成功","info");
							$("#win").window("close");
							$("#dg").datagrid("load");
						}else{
							$.messager.alert("提示","实有单位注销失败","info");
						}
					}
				
				});	
			}
		}else{
			$.messager.alert("提示","请输入注销原因","info");
		}
	}
	  
	function closeWindow(){
		  var zxyy = document.getElementById("xt_zxyy").value;
		  if(zxyy!="请输入注销原因..." && zxyy!=""){
			  if(confirm("数据还未保存，确定要关闭吗?")){
				  $("#win").window("close");
			  }
		  }else{
			  $("#win").window("close");
		  }
	  }
    </script>
  </body>
</html>
