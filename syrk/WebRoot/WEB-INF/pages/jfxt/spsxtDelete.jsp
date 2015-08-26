<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>视频摄像头列表</title>
<!-- 字典翻译需要的js库文件  -->
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/jf_sxtScript.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/JF_DIC_TRANSLATE.js"></script>

<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/codetranslate.js"></script>  
<script type="text/javascript">
	var snswObject={"0":"室内","1":"室外"};
	var qjqjObject={"0":"枪机","1":"球机"};
	var gdkdObject={"0":"固定","1":"可动"};
	function traslateCode(code){
		return jslbObject[code];
		//return jslbObject.code;
	}
	function gaoqingbiaoqing(code){
		return JFXT.getResolution(code);
	}
	/*function qiangjiqiuji(code){
		return qjqjObject[code];
	}
	function shineishiwai(code){
		return snswObject[code];
	}
	function gudingkedong(code){
		return gdkdObject[code];
	}*/
	function yeshi(code){
		return JFXT.getSight(code);
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
 <div data-options="region:'center',border:false">
   	<div class="easyui-layout" data-options="fit:true,border:false">   
       <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
		<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>sptgl/queryList',toolbar:'#datagridToolbar',
		            singleSelect:true,
		            rownumbers:true,
		            selectOnCheck:true,
		            checkOnSelect:true,
		            border:false,
		            sortOrder:'desc',
		            sortName:'xt_zhxgsj',
		            idField:'id',
		            pageSize:getAutoPageSize(),
		            pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						    <thead>
						        <tr>
						            <th data-options="field:'sxtbh', 	width:10,	align:'left',	halign:'center',sortable:true,formatter:subStr">摄像头编号</th>
						            <th data-options="field:'jd',	width:9,	align:'left' ,sortable:true">经度</th>
						            <th data-options="field:'wd', width:9,	align:'left',	halign:'center',sortable:true	">纬度</th>
						            <th data-options="field:'cx', width:5,	align:'left',	halign:'center',sortable:true,formatter:subStr	">朝向</th>
						            <th data-options="field:'jkjd', 	width:7,	align:'left',	halign:'center',sortable:false">监控角度</th>
						            <th data-options="field:'sbgqsx',	width:6,	align:'left' ,formatter:function(value,row,index){return gaoqingbiaoqing(value);},sortable:true">高清标清</th>
						            <th data-options="field:'sb_qjqj', width:6,	align:'left',formatter:dictTranslate,dictName:contextPath + '/common/dict/jfxt/D_JF_QJQJ.js',	halign:'center',sortable:true	">枪机球机</th>
						            <th data-options="field:'sb_snsw', width:6,	align:'left',formatter:dictTranslate,dictName:contextPath + '/common/dict/jfxt/D_JF_SNSW.js',	halign:'center',sortable:true	">室内室外</th>
						            <th data-options="field:'sbyssx', width:6,	align:'left',formatter:function(value,row,index){return yeshi(value);},	halign:'center',sortable:true	">夜视非夜视</th>
						            <th data-options="field:'sb_gd', width:6,	align:'left',formatter:dictTranslate,dictName:contextPath + '/common/dict/jfxt/D_JF_GDKD.js',	halign:'center',sortable:true	">固定可动</th>
						            <th data-options="field:'azbw',width:30,    align:'left',   halign:'center',sortable:false,formatter:subStr ">安装部位</th>
						            <th data-options="field:'process',	 width:10,align:'center',	halign:'center',	formatter:datagridProcessFormater">操作</th>
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
	  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;&nbsp;';
    }
    //修改单条
 	function doEdit(linkObject, index) {
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		//alert(rowData.id);
		var editUrl = contextPath+"/sptgl/spsxtEdit?id="+rowData.id;
		parent.document.getElementById("mainAreaId").src = editUrl;
	}

	function doDelete(linkObject, index) {
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		var delUrl = contextPath+"/sptgl/spsxtDel?id="+rowData.id;
		topMessager.confirm('','您确认要删除数据吗？',function(r) {    
		if (r) {	
			parent.document.getElementById("mainAreaId").src = delUrl;
		}});
	}
	

	
	
	</script>
  </body>
</html>