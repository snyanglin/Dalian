<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<%=contextPath%>/css/dbrw.css" rel="stylesheet" type="text/css" />
    <title>协同任务列表</title>
    <script type="text/javascript">
    <!--
	    //重置按钮
	    function resetButton(){
	    	$("#queryForm").form("reset");
	    }
    
	    //查询按钮
	    function queryButton(){
	    	var context = document.getElementById("xxnr").value;
	    	var begin = document.getElementById("fssj").value;
	    	var end = document.getElementById("jssj").value;
	    	context= $.trim(context);
	    	begin= $.trim(begin);
	    	end= $.trim(end);
	    	var reloadUrl  = "<%=basePath%>dbrwVL/queryMsg";
	    	var opt = $('#rwlb').datagrid('options');
	    	opt.url = reloadUrl;
	    	if($("#fssj").val()!=null && $("#fssj").val()!='' && $("#jssj").val()!=null && $("#jssj").val()!='' && $("#fssj").val() >= $("#jssj").val()){
	    		$.messager.alert("【结束时间】必须大于【开始时间】！");
	    		return false;
	    	}
    		$("#rwlb").datagrid(
			'load',
			{    
				'xxnr': context,   
				'fssj':begin,
				'jssj': end
		    });
	    }
	    
	    function reback(sfck, url){
	    	if(sfck!='0'){
	    		$.messager.alert("该条信息为已读状态, 不能收回!");
		    	return;
	    	} else {
	    		//openDbrw("/dbrwVL/backMsg?id=" +  url);
	    		$.messager.confirm("系统提示", "是否收回该消息?", function(r){
	    			if(r){
	    				$.ajax({
	    					async:false,
	    					type:"POST",
	    					url: contextPath+"/dbrwVL/backMsg",
	    					dataType:"json",
	    					data: "id=" + url,
	    					success:function(data){
	    					if (data && data.e) {
	    							if(data.e != '0'){
	    								$.messager.alert("收回成功!");
	    								$("#rwlb").datagrid("reload");
	    							}else {
	    						
	    							}
	    						}
	    					}
	    				});
	    			}
	    		});
	    	}
	    }
	    //协同任务查询按钮
		function selectDbrwmx(val,row,index){
			var url = "/ywxtgzrwb/ywxtgzrwbViews?id="+row["id"];
			var delUrl = row["id"];
			var sfck = row["sfck"];
			return '<div id="dbrwck" class="dbrwck" ><a href="javascript:void(0)" onclick="openDbrw(\''+url+'\')")>查看</a>'
				+ '&nbsp;<a href="javascript:void(0)" onclick="reback('+ sfck +',' + delUrl + ')">收回</a></div>';
		}
		
		//协同任务，更多打开页面
		function openDbrw(url){
			menu_open('协同任务', url);
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
  			<div data-options="region:'center',split:true,title:'消息列表',border:false" style="height:auto">
  			<table id="rwlb" class="easyui-datagrid" 
            	data-options="
            	    url:'<%=basePath%>dbrwVL/queryMsg',
	           		delayCountUrl:'<%=basePath%>dbrwVL/queryMsgTotal',
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
			            <th data-options="field:'fssj',width:100,align:'center',sortable:true,halign:'center'">发送时间</th>
			            <th  data-options="field:'jsr',width:50,align:'center',halign:'center',sortable:true">接收人</th>
			            <th data-options="field:'xxnr',width:200,align:'left',sortable:true,halign:'center',formatter:dbrwStyler">消息内容</th>
			            <th  data-options="field:'id',width:50,align:'center',halign:'center',sortable:true,hidden:true">id</th>
			            <th  data-options="field:'sfck',width:50,align:'center',halign:'center',sortable:true,hidden:true">sfck</th>
			            <th  data-options="field:'true',width:50,align:'center',halign:'center',formatter:selectDbrwmx">操作</th>
			        </tr>
			    </thead>
			</table>
  
  			<div id="datagridToolbar" style="padding:5px;height:80">
	  			<form id ="queryForm">
	   			<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td width="10%" nowrap="nowrap" align="right">消息内容：</td>
						<td width="20%">
							<input type="text" name="xxnr" id="xxnr" class="easyui-validatebox" style="width:260px" 
								value="${entity.xxnr}" data-options="required:false,tipPosition:'bottom'" maxlength="400"/>
						</td>
						<!-- 
						<td width="100" nowrap="nowrap" align="right">任务状态：</td>
						<td width="180"><input class="easyui-combobox" type="text" id="rwzt" name="rwzt" style="width:260px" value="${entity.rwzt}"
								data-options="url: contextPath + '/common/dict/D_DBRW_RWZT.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" maxlength="100"/>
						</td>
						 -->
						<td width="10%" nowrap="nowrap" align="right">发送时间起：</td>
						<td width="20%">
							<input type="text" name="fssj" id="fssj" class="easyui-validatebox"  style="width:260px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'left',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.fssj}"/>
						</td>
						<td width="10%" nowrap="nowrap" align="right">发送时间止：</td>
						<td width="20%">
							<input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width:260px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'left',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.rwjssj}"/>
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap" colspan="6" align="right">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
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
