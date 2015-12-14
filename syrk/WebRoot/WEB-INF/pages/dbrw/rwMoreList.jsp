<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<%=contextPath%>/css/dbrw.css" rel="stylesheet" type="text/css" />
    <title>工作督办任务列表</title>
    <script type="text/javascript">
    
	    //重置按钮
	    function resetButton(){
	    	$("#queryForm").form("reset");
	    }
    
	    //查询按钮
	    function queryButton(){
	    	var title = document.getElementById("rwbt").value;
	    	var status = $("#rwzt").val();
	    	var initiate = document.getElementById("rwfqsj").value;
	    	var begin = document.getElementById("rwkssj").value;
	    	var end = document.getElementById("rwjssj").value;
	    	title= $.trim(title);
	    	status= $.trim(status);
	    	begin= $.trim(begin);
	    	end= $.trim(end);
	    	var reloadUrl  = "<%=basePath%>dbrwVL/queryDb";
	    	var opt = $('#rwlb').datagrid('options');
	    	opt.url = reloadUrl;
	    	if($("#begin").val() >= $("#end").val()){
	    		alert("【任务结束时间】必须大于【任务开始时间】！");
	    		return false;
	    	}
    		$("#rwlb").datagrid(
			'load',
			{    
				'rwbt': title,   
				'rwzt': status ,
				'rwfqsj':initiate,
				'rwkssj':begin,
				'rwjssj': end
		    });
	    }
	    
	    //督办任务查询按钮
		function selectDbrwmx(val,row,index){
			var url = "/dbrwVL/main?id="+row["id"];
			return '<div id="dbrwck" class="dbrwck" ><a href="javascript:void(0)" onclick="openDbrw(\''+url+'\')")>查看</a></div>';
		}
		
		//督办任务，更多打开页面
		function openDbrw(url){
			menu_open('督办任务', url);
		}

		$(function(){
			var rwid = $("#rwid").val();
			if("undefined" != typeof(rwid) && "" != rwid && null != rwid){
				
			}
		});
		
		function dbrwStyler(value, rowData, index){
			return "<font style='font-weight:bold;'>"+value+"</font>";
		}
    //-->
    </script>
  </head>
  <body class="easyui-layout" data-options="fit:true">
  
  <input id="rwid" value="${id}" type="hidden" />
  
  <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">
  			<div data-options="region:'center',split:true,title:'督办任务列表',border:false" style="height:auto">
  			<table id="rwlb" class="easyui-datagrid" 
            	data-options="
            	    url:'<%=basePath%>dbrwVL/queryDb',
	           		delayCountUrl:'<%=basePath%>dbrwVL/queryDbTotal',
	           		toolbar:'#datagridToolbar',
	           		border:false,
	           		sortName:'rwfqsj',
	           		sortOrder:'desc',
	           		pageSize:getAutoPageSize(180),
	           		pageList:[getAutoPageSize(180),
	           		getAutoPageSize(180) * 2],
	           		singleSelect:true,
	           		fitColumns:true">
	           		<!-- onClickRow:doOnClickRow 单击行事件 --> 
			    <thead>
			        <tr>
			            <th data-options="field:'rwbt',width:200,align:'left',sortable:true,halign:'center',formatter:dbrwStyler">任务标题</th>
			        	<th data-options="field:'dbrwfqdwmc',width:100,align:'center',sortable:true,halign:'center'">督办任务发起单位</th>
			            <th data-options="field:'rwfqsj',width:100,align:'center',sortable:true,halign:'center'">任务发起时间</th>
			            <th data-options="field:'rwkssj',width:100,align:'center',sortable:true,halign:'center'">任务开始时间</th>
			            <th data-options="field:'rwjssj',width:100,align:'center',sortable:true,halign:'center'">任务结束时间</th>
			            <th  data-options="field:'rwsm',width:100,align:'left',halign:'center',sortable:true">任务说明</th>
			            <th  data-options="field:'rwsjzl',width:50,align:'center',halign:'center',sortable:true">任务数据总量</th>
			            <th  data-options="field:'rwzt',width:50,align:'center',halign:'center',sortable:true, formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DBRW_RWZT.js'">任务状态</th>
			            <th  data-options="field:'id',width:50,align:'center',halign:'center',sortable:true,hidden:true">id</th>
			            <th  data-options="field:'true',width:50,align:'center',halign:'center',formatter:selectDbrwmx">查看</th>
			        </tr>
			    </thead>
			</table>
  
  			<div id="datagridToolbar" style="padding:5px;height:80">
	  			<form id ="queryForm">
	   			<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td width="100" nowrap="nowrap" align="right">任务标题：</td>
						<td width="180"><input type="text" name="rwbt" id="rwbt" class="easyui-validatebox" style="width:165px" 
								value="${entity.rwbt}" data-options="required:false,tipPosition:'bottom'" maxlength="100"/>
						</td>
						<td width="100" nowrap="nowrap" align="right">任务状态：</td>
						<td width="180"><input class="easyui-combobox" type="text" id="rwzt" name="rwzt" style="width:165px" value="${entity.rwzt}"
								data-options="url: contextPath + '/common/dict/D_DBRW_RWZT.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" maxlength="100"/>
						</td>
						<td width="100" nowrap="nowrap" align="right">任务发起时间：</td>
						<td>
							<input type="text" name="rwfqsj" id="rwfqsj" class="easyui-validatebox"  style="width:165px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'left',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.rwfqsj}"/>
						</td>
					</tr>
						<!-- 
						<td align="right">
							<label>督办任务发起派出所</label>
						</td>
						<td>
							<input type="text" name="dbrwfqpcsdm" id="dbrwfqpcsdm" class="easyui-validatebox " 
								value="${entity.dbrwfqpcsdm}" data-options="required:false,tipPosition:'left'" maxlength="100"/>
						</td>
						 -->
					<tr>
						<td nowrap="nowrap" align="right">任务开始时间：</td>
						<td>
							<input type="text" name="rwkssj" id="rwkssj" class="easyui-validatebox"  style="width:165px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'left',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.rwkssj}"/>
						</td>
						<td nowrap="nowrap" align="right">任务结束时间：</td>
						<td>
							<input type="text" name="rwjssj" id="rwjssj" class="easyui-validatebox" style="width:165px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'left',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.rwjssj}"/>
						</td>
						<td nowrap="nowrap" align="right"></td>
						<td nowrap="nowrap"><a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
						    &nbsp;&nbsp;
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
						</td>
					</tr>
				</table>
	   		</form>
			</div>
		</div>
      </div>
	</div>     			
  
</body>
</html>
