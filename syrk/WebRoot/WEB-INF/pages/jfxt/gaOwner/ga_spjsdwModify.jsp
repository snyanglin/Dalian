<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>视频建设单位查询</title>
<script type="text/javascript">
	var jslbObject={"01":"公安自建","10":"政府机关","40":"企事业单位","80":"居民自建","90":"其它主体"};
	function traslateCode(code){
		return jslbObject[code];
	}

</script>  
</head>
<body class="easyui-layout" data-options="fit:true">
 <div data-options="region:'center',border:false">
   	<div class="easyui-layout" data-options="fit:true,border:false">   
       <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
		<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>spjsdw/queryList',toolbar:'#datagridToolbar',
		            method:'post',
		            singleSelect:true,
		            rownumbers:true,
		            selectOnCheck:true,
		            checkOnSelect:true,
		            border:false,
		            sortOrder:'desc',
		            sortName:'dwbm',
		            idField:'dwbm',
		            pageSize:getAutoPageSize(),
		            pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						    <thead>
						        <tr>
						            <th data-options="field:'dwbm', width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr">单位编码</th>
						            <th data-options="field:'dwmc', width:25,	align:'left',	halign:'center',sortable:true,formatter:subStr">单位名称</th>
						            <th data-options="field:'yzxm', width:10,	align:'center',	halign:'center',sortable:true">业主姓名</th>
						            <th data-options="field:'jslb', width:15,formatter:function(value,row,index){return traslateCode(value);},	align:'left',	halign:'center',sortable:true">行业类别</th>
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
		var editUrl = contextPath+"/spjsdw/queryByDwbm?dwbm="+rowData.dwbm;
		parent.document.getElementById("mainAreaId").src = editUrl;
	}
	</script>
  </body>
</html>