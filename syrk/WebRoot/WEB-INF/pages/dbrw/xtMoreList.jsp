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
	    	var context = document.getElementById("ywxtrwms").value;
	    	var rwclrbm = $("#rwclrbm").val();
	    	var fqrbm = document.getElementById("fqrbm").value;
	    	var begin = document.getElementById("fqsj").value;
	    	var end = document.getElementById("jssj").value;
	    	var rwcljgdm = document.getElementById("rwcljgdm").value;
	    	var cjjgdm = document.getElementById("cjjgdm").value;
	    	
	    	context= $.trim(context);
	    	status= $.trim(status);
	    	begin= $.trim(begin);
	    	end= $.trim(end);
	    	var reloadUrl  = "<%=basePath%>dbrwVL/queryXt";
	    	var opt = $('#rwlb').datagrid('options');
	    	opt.url = reloadUrl;
	    	if($("#fqsj").val()!='' && $("#jssj").val()!='' && $("#fqsj").val() >= $("#jssj").val()){
	    		alert("【结束时间】必须大于【开始时间】！");
	    		return false;
	    	}
    		$("#rwlb").datagrid(
			'load',
			{    
				'ywxtrwms': context,   
				'rwclrbm': rwclrbm ,
				'fqrbm':fqrbm,
				'fqsj':begin,
				'jssj': end,
				'rwcljgdm': rwcljgdm,
				'cjjgdm': cjjgdm
		    });
	    }
	    
	    //协同任务查询按钮
		function selectDbrwmx(val,row,index){
			var url = "/dbrwVL/xtMore?id="+row["id"];
			return '<div id="dbrwck" class="dbrwck" ><a href="javascript:void(0)" onclick="openDbrw(\''+url+'\')")>查看</a></div>';
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
		
		function cljg(val, row, index){
	  		if(val=="1"){
	  			return "未处理";
	  		}else if(val=="0"){
	  			return "已处理";
	  		}  	
	    }
		
		function cjjg(val, row, index){
	  		if(val=="1"){
	  			return "未裁决";
	  		}else if(val=="0"){
	  			return "已裁决";
	  		}  	
	    }
		
    //-->
    </script>
  </head>
  <body class="easyui-layout" data-options="fit:true">
  
  <input id="rwid" value="${id}" type="hidden" />
  
  <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">
  			<div data-options="region:'center',split:true,title:'协同任务列表',border:false" style="height:auto">
  			<table id="rwlb" class="easyui-datagrid" 
            	data-options="
            	    url:'<%=basePath%>dbrwVL/queryXt',
	           		delayCountUrl:'<%=basePath%>dbrwVL/queryXtTotal',
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
			            <th data-options="field:'ywxtrwms',width:200,align:'left',sortable:true,halign:'center',formatter:dbrwStyler">协同内容</th>
			            <th data-options="field:'fqsj',width:100,align:'center',sortable:true,halign:'center'">发起时间</th>
			            <th  data-options="field:'fqrbm',width:100,align:'left',halign:'center',sortable:true">发起部门</th>
			            <th  data-options="field:'rwclrbm',width:50,align:'center',halign:'center',sortable:true">接收部门</th>
			            <th data-options="field:'rwclsj',width:100,align:'center',sortable:true,halign:'center'">处理时间</th>
			            <th  data-options="field:'rwcljgdm',width:100,align:'center',halign:'center',sortable:true, formatter:cljg">处理结果</th>
			        	<th data-options="field:'cjsj',width:100,align:'center',sortable:true,halign:'center'">裁决时间</th>
			            <th  data-options="field:'cjjgdm',width:50,align:'center',halign:'center',sortable:true, formatter:cjjg">裁决结果</th>
			            <!-- 
			            <th  data-options="field:'rwcljgdm',width:50,align:'center',halign:'center',sortable:true, formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DBRW_RWZT.js'">处理结果</th>
			            <th  data-options="field:'cjjgdm',width:50,align:'center',halign:'center',sortable:true, formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DBRW_RWZT.js'">处理结果</th>
			             -->
			            <th  data-options="field:'id',width:50,align:'center',halign:'center',sortable:true,hidden:true">id</th>
			            <th  data-options="field:'true',width:50,align:'center',halign:'center',formatter:selectDbrwmx">查看</th>
			        </tr>
			    </thead>
			</table>
  
  			<div id="datagridToolbar" style="padding:5px;height:80">
	  			<form id ="queryForm">
	   			<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td width="10%" align="right">协同内容：</td>
						<td width="20%">
							<input type="text" name="ywxtrwms" id="ywxtrwms" class="easyui-validatebox" style="width:260px" 
								value="${entity.ywxtrwms}" data-options="required:false,tipPosition:'bottom'" maxlength="100"/>
						</td>
						<!-- 
						<td width="100" nowrap="nowrap" align="right">任务状态：</td>
						<td width="180"><input class="easyui-combobox" type="text" id="rwzt" name="rwzt" style="width:260px" value="${entity.rwzt}"
								data-options="url: contextPath + '/common/dict/D_DBRW_RWZT.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" maxlength="100"/>
						</td>
						 -->
						<td width="10%" nowrap="nowrap" align="right">发起时间起：</td>
						<td width="20%">
							<input type="text" name="fqsj" id="fqsj" class="easyui-validatebox"  style="width:115px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'left',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.fqsj}"/>
							至&nbsp;
							<input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width:115px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'left',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.rwjssj}"/>
						</td>
						<td width="10%" nowrap="nowrap" align="right">发起部门：</td>
						<td width="20%">
								<input type="hidden" id="fsbmid" name="fsbmid" value="" style="width: 100;" />
									    <input  class="easyui-validatebox" type="text" id="fqrbm" name="fqrbm" style="width:200px;" value="" />
									   	<input type="hidden" id="orgid3" name="orgid3" value="" style="width: 100;" />
									    <input type="button" id="orgbutton3" value="选择" onClick="public_singleSelectOrg('', '01', '50', '01,01,03,04', 'fsbmid', 'fqrbm', 'orgid3', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
								
							<!--
							<input type="text" name="fqrbm" id="fqrbm" class="easyui-validatebox" style="width:260px" 
								value="${entity.fqrbm}" data-options="required:false,tipPosition:'bottom'" maxlength="100"/>
							  -->
						</td>
					</tr>
					<tr>
						<td width="10%" nowrap="nowrap" align="right">接收部门：</td>
						<td width="20%">
							<input type="hidden" id="fsbmid" name="fsbmid" value="" style="width: 100;" />
									    <input  class="easyui-validatebox" type="text" id="rwclrbm" name="rwclrbm" style="width:200px;" value="" />
									   	<input type="hidden" id="orgid3" name="orgid3" value="" style="width: 100;" />
									    <input type="button" id="orgbutton3" value="选择" onClick="public_singleSelectOrg('', '01', '50', '01,01,03,04', 'fsbmid', 'rwclrbm', 'orgid3', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
							<!-- 	
							<input type="text" name="rwclrbm" id="rwclrbm" class="easyui-validatebox" style="width:260px" 
								value="${entity.rwclrbm}" data-options="required:false,tipPosition:'bottom'" maxlength="100"/>
							-->
						</td>
						<td width="10%" nowrap="nowrap" align="right">处理结果：</td>
						<td width="20%">
							<input type="text" name="rwcljgdm" id="rwcljgdm" class="easyui-validatebox" style="width:260px" 
								value="${entity.rwcljgdm}" data-options="required:false,tipPosition:'bottom'" maxlength="100"/>
						</td>
						<td width="10%" nowrap="nowrap" align="right">裁决结果：</td>
						<td width="20%"><input type="text" name="cjjgdm" id="cjjgdm" class="easyui-validatebox" style="width:260px" 
								value="${entity.cjjgdm}" data-options="required:false,tipPosition:'bottom'" maxlength="100"/>
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
