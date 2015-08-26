<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript">
  <!--
  var markerArr =  new Array;
  
  var option = parent.frames.options;
  
  function getParm(name){
	  var flag = ""; 
  	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
  	  var r = window.location.search.substr(1).match(reg);
  	  if(r != null){
  		  flag = unescape(r[2]);
  	  } 
  	  return flag;
  }
  
  function getScore(val,row,index){
		var userids = row["userName"];
		var url = "/forward/query|xjJqQueryListDown";
		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"警情详细信息\", \""+url+"\")')>"+val+"</a></div>";
  }
  
  $(document).ready(function(){
	$('#dg').datagrid('getPager').pagination({
		showPageList:false,
		showRefresh:false,
		displayMsg : ''
	});
	$("#dg").datagrid('resize', {});
  });
  
  -->
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" >
            	<table id="dg" class="easyui-datagrid" 
            	data-options="
            	queryParams: {'fqsj': getParm('fqsj'), 'jssj': getParm('jssj'), 'jqlbdm': getParm('jqlbdm'), 'jqdzms':getParm('jqdz'), 'gxdwdm':getParm('gxdwdm')},
            	url: '<%=basePath %>jz/queryJq',
            	delayCountUrl:'<%=basePath %>jz/queryCountJq',
            	toolbar:'#datagridToolbar',
            		singleSelect:false,
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:true,
           			pagination:true,
  					rownumbers: 'true',
  			        sortName:'',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:10,
            		pageList:[10,20,200],
            		onSelect:onSelectRow,
            		onLoadSuccess:function(data){ loadPoints(data);},
            		fitColumns:true,
            		singleSelect:true">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'jjbh',width:200,align:'left',sortable:false,halign:'center'">编号</th>
				            <th data-options="field:'bj_sj',width:200,align:'center',sortable:false,halign:'center', formatter: function(value, row, index){return value.substr(0, 19);}">时间</th>
				            <th data-options="field:'jqlbdm',width:200,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_JCJ_JQLBDM.js'">类别</th>
				            <th  data-options="field:'jqdzms',width:400,align:'left',halign:'center',sortable:false,formatter:subjzdz">发生地</th>
				            <th  data-options="field:'bjnr',width:400,align:'left',halign:'center',sortable:false">简要警情</th>
				            <th data-options="field:'zddw_zxdhzb',hidden:true">zbx</th>
				            <th data-options="field:'zddw_zxdzzb',hidden:true">zby</th>
				        </tr>
				    </thead>
				</table>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">
<!--
function onSelectRow(rowIndex, data){
	if (IE) {
		window.parent.XjMap.centerByPoint(markerArr[rowIndex],18,data, 'jq');
		//parent.frames["mapDiv"].XjMap.centerByPoint(markerArr[rowIndex],18,data, 'jq');
	}else{
		var obj = parent.frames.document.getElementById("mapDiv").contentWindow;
		obj.XjMap.centerByPoint(markerArr[rowIndex], 19, data, 'jq');
	}
}

var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	/*
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	*/
	return val;
}

//页面载入画点
function loadPoints(data) {
	//clearPoints();
	//延迟加载统计
	beforeTableLoad(data,'dg');
	var mapWindow = null;
	if (IE) {
		mapWindow = window.parent.mapDiv; //parent.frames["mapDiv"];
	}
	else {
		mapWindow = window.parent.mapDiv.contentWindow; //parent.frames.document.getElementById("mapDiv").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if (mapWindow.XjMap) {
			mapPoint(mapWindow);
		}
		else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}

function mapPoint(mapWindow) {
	var obj = window.parent.mapDiv; //parent.frames.document.getElementById("mapDiv").contentWindow;
	//obj.XjMap.clearMarkers
	clearPoints();
	//if (mapWindow.XjMap) {
		//mapWindow.XjMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		for (var i = 0; i < len; i++) {
			//var dz = rows[i].jqfsdz;
			if (rows[i].zddw_zxdhzb != null && rows[i].zddw_zxdhzb != "") {
				var marker = null;
				//根据设置决定是否显示图层
				var img = "dz_zb02.png";
				/*
				if(rows[i].jqlb == '1'){
					img = "jq_qz.png";
				} else if(rows[i].jqlb == '2'){
					img = "jq_tj.png";
				} else if(rows[i].jqlb == '3'){
					img = "jq_xs.png";
				} else if(rows[i].jqlb == '4'){
					img = "jq_za.png";
				}
				*/
				if (IE) {
					marker = window.parent.addMarkers('',rows[i].zddw_zxdhzb,rows[i].zddw_zxdzzb, img,null,null,25,25,false,rows[i], 'jq');
				}
				else {
					marker = window.parent.addMarkers('',rows[i].zddw_zxdhzb,rows[i].zddw_zxdzzb, img,null,null,25,25,false,rows[i], 'jq');
				}
				markerArr.push(marker);
			}
		}
	//}
}

//清空已存在坐标点
function clearPoints(){
	var mapWindow = null;
	if (IE) {
		mapWindow = window.parent.mapDiv;
	}
	else {
		mapWindow = window.parent.mapDiv.contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if(markerArr != null){
			var markerLen = markerArr.length;
			for(var j=0;j<markerLen;j++){
				mapWindow.XjMap.map._MapApp.removeOverlay(markerArr[j]);
			}
		}
	}
	//mapWindow.XjMap.map._MapApp.closeInfoWindow();
}
-->
</script>  
</html>