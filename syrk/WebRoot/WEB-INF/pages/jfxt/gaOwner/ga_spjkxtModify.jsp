<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>视频系统查询</title>
</head>
<body class="easyui-layout" data-options="fit:true">
 <div data-options="region:'center',border:false">
   	<div class="easyui-layout" data-options="fit:true,border:false">   
       <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
		<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>spjkxt/queryList',toolbar:'#datagridToolbar',
		            method:'post',
		            singleSelect:true,
		            rownumbers:true,
		            selectOnCheck:true,
		            checkOnSelect:true,
		            border:false,
		            sortOrder:'desc',
		            sortName:'xh',
		            idField:'xh',
		            pageSize:getAutoPageSize(),
		            pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						    <thead>
						        <tr>
						        	<th data-options="field:'xtmc', width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr">系统名称</th>
						            <th data-options="field:'xh', width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr">系统编码</th>
						            <th data-options="field:'jsryxm', width:10,	align:'center',	halign:'center',sortable:true">技术人员姓名</th>
						            <th data-options="field:'jsrysfzh', width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr">技术人员身份证号</th>
						            <th data-options="field:'process',width:10,align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
						        </tr>
						    </thead>
						</table>
				<div id="datagridToolbar" style="padding:5px;height:30px;width:100%">
			</div>
       </div>
   </div>
</div>
<script type="text/javascript">
    //截取字符串 如果超过30个字
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
    //操作列
 	function datagridProcessFormater(val, row, index) { // 自定义操作生成
	  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">修改</a>&nbsp;&nbsp;';
    }
    //修改单条
 	function doEdit(linkObject, index) {
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		var editUrl = contextPath+"/spjkxt/queryByXh?xh="+rowData.xh;
		parent.document.getElementById("mainAreaId").src = editUrl;
	}
	</script>
  </body>
</html>