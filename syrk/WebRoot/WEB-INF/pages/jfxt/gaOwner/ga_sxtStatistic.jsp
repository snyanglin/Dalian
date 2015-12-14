<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>修改Nvr</title>
<!-- 字典翻译需要的js库文件  -->
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/jf_sxtScript.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/JF_DIC_TRANSLATE.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/codetranslate.js"></script>  
</head>
<body class="easyui-layout" data-options="fit:true">
 <div data-options="region:'center',border:false">
   	<div class="easyui-layout" data-options="fit:true,border:false">   
       <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
		<table id="dgNvrModify" class="easyui-datagrid" data-options="url:'<%=basePath %>idName/getSxtStatistic',
		            method:'post',
		            singleSelect:true,
		            rownumbers:true	">
						    <thead>
						        <tr>
						        	<th data-options="field:'name', width:15,	align:'left',	halign:'center',sortable:true">部门名称</th>
						            <th data-options="field:'hasCoordinate', width:15,	align:'left',	halign:'center',sortable:true">已定位数</th>
						            <th data-options="field:'noCoordinate', width:10,	align:'center',	halign:'center',sortable:true">未定位数</th>
						            <th data-options="field:'total', width:10,	align:'center',	halign:'center',sortable:true">总数</th>
						        </tr>
						    </thead>
						</table>
				
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
    //翻译存储时长
    function getPlatformFactory(val, row, index){
    	return JFXT.getSimpleDictionary('CCSC'+val);
    	
    }
    //操作列
 	function datagridProcessFormater(val, row, index) { // 自定义操作生成
	  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this,'+index+')">修改</a>&nbsp;&nbsp;';
    }
 
	</script>
  </body>
</html>