<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>删除Nvr</title>
<!-- 字典翻译需要的js库文件  -->
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/jf_sxtScript.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/JF_DIC_TRANSLATE.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/codetranslate.js"></script>  
</head>
<body class="easyui-layout" data-options="fit:true">
 <div data-options="region:'center',border:false">
   	<div class="easyui-layout" data-options="fit:true,border:false">   
       <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
		<table id="dgNvrDelete" class="easyui-datagrid" data-options="url:'<%=basePath %>nvrInfo/pageQueryNvr',toolbar:'#datagridToolbar',
		            method:'post',
		            singleSelect:true,
		            rownumbers:true,
		            selectOnCheck:true,
		            checkOnSelect:true,
		            border:false,
		            sortOrder:'desc',
		            sortName:'sbMc',
		            idField:'id',
		            pageSize:getAutoPageSize(),
		            pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						    <thead>
						        <tr>
						        	<th data-options="field:'sbMc', width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr">设备名称</th>
						            <th data-options="field:'sbIp', width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr">设备IP</th>
						            <th data-options="field:'ccsc', width:10,	align:'center',	halign:'center',sortable:true,formatter:dictTranslate,dictName:'<%=contextPath%>/common/dict/jfxt/D_JF_CCSC.js'">存储时长</th>
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
	  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this,'+index+')">删除</a>&nbsp;&nbsp;';
    }
 	//级联删除
 	function doDelete(linkObject, index) {
		//var datagrid_ID = getDatagrid_ID(0, linkObject);
		//var rowSet = $('#' + datagrid_ID).datagrid('getData');
		var rowSet = $('#dgNvrDelete').datagrid('getData');
		var rowData = rowSet.rows[index];
		if(confirm("删除NVR将删除关联的摄像头，你确信要删除吗?")){
			var editUrl = contextPath+"/nvrInfo/deleteNvrInfoById/"+rowData.id;
			//alert(editUrl);
			parent.document.getElementById("mainAreaId").src = editUrl;
		}		
		

	}
	</script>
  </body>
</html>