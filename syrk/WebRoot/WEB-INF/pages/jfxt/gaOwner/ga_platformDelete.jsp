<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>平台删除</title>
  <!-- 字典翻译需要的js库文件  -->
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/jf_sxtScript.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/JF_DIC_TRANSLATE.js"></script>

<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/codetranslate.js"></script>    
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
		<table id="dgPlatformDelete" class="easyui-datagrid" data-options="url:'<%=basePath %>platform/pageQueryPlatform',toolbar:'#datagridToolbar',
		            method:'post',
		            singleSelect:true,
		            rownumbers:true,
		            selectOnCheck:true,
		            checkOnSelect:true,
		            border:false,
		            sortOrder:'desc',
		            sortName:'ptmc',
		            idField:'id',
		            pageSize:getAutoPageSize(),
		            pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						    <thead>
						        <tr>
						            <th data-options="field:'id', width:15,	align:'left',	halign:'center',sortable:true,formatter:subStr">平台ID</th>
						            <th data-options="field:'ptmc', width:25,	align:'left',	halign:'center',sortable:true">平台名称</th>
						            <th data-options="field:'ptcs', width:10,	align:'center',	halign:'center',sortable:true,formatter:dictTranslate,dictName:contextPath + '/common/dict/jfxt/D_JF_SLPTCS.js' ">平台厂商</th>
						            <th data-options="field:'zxfwqIp', width:10,	align:'center',	halign:'center',sortable:true">中心服务器端口号</th>

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
 	//翻译平台厂商
    function getPlatformFactory(val, row, index){
    	return JFXT.getSimpleDictionary('SLPTCS'+val);
    	
    }
    //翻译平台名称
    
    function getPlatformName(val, row, index){
    	return JFXT.getSimpleDictionary('PTMC'+val);
    	
    }
    //级联删除
 	function doDelete(linkObject, index) {
		//var datagrid_ID = getDatagrid_ID(0, linkObject);
		//var rowSet = $('#' + datagrid_ID).datagrid('getData');
		var rowSet=$('#dgPlatformDelete').datagrid('getData');
		var rowData = rowSet.rows[index];
		
		if(confirm("删除平台将删除关联的NVR和摄像头，你确信要删除吗?")){
			var editUrl = contextPath+"/platform/deletePlatformById/"+rowData.id;
			parent.document.getElementById("mainAreaId").src = editUrl;
		}
	}
	</script>
  </body>
</html>