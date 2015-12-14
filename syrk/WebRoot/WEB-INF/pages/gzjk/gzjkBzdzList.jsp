<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 30px;
	   border: 1px solid #95B8E7;
	   padding-left: 5px;
	   padding-top: 10px;
	   width:200px;
	}
	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	
.count_left{float:left;}
.count_right{float:right;}	
.c_wrap{
	width:100%; height:auto; overflow:hidden; margin:0 auto;
	}
.t_bg_wrap{
	width:98%; height:180px; float:left; background: url(<%=contextPath%>/images/dt_bg.png) repeat-x #f0ecec; margin:10px 0 0 10px; border:1px solid #e3e3e3;
	}
.count_wrap{
	width:98%; height:auto; overflow:hidden; float:left; margin:10px 0 0 35px; display:inline;
	}
.count_tr{
	width:100%; height:32px; float:left;
	}
.count_jiao{background:url(<%=contextPath%>/images/right_bg.png) no-repeat; width:58px; height:180px; float:right;margin-top: -175px;

}
.count_title{
	width:20%;min-width:70px; float:left; line-height:32px; color:#073d6b; text-align:left; height:32px; font-size:14px;
	}
.count_type{
	width:50%;min-width:185px; line-height:32px; float:left; height:32px; font-size:14px;
	}
.count_number{
	float:left; width:18px; height:21px; border:1px solid #d1dae3; background-color:#f5f5f5; display:block; color:#6395c7;
	line-height:21px; font-size:14px; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif;
	background:url(<%=contextPath%>/images/number_bg.png) repeat-x; margin:4px 0 0 3px;
	}
.count_title01{background:url(<%=contextPath%>/images/bzdz_title.png) no-repeat; width:100%;height:30px; float:left; margin:10px 0 0 10px;
           line-height:30px;}
.count_title01{background:url(<%=contextPath%>/images/syrk_title.png) no-repeat; width:100%;height:30px; float:left; margin:10px 0 0 10px;
           line-height:30px;}

.count_number_red{
	float:left; width:18px; height:21px; border:1px solid #f5c074; background-color:#f5f5f5; display:block; color:#ea3f11;
	line-height:21px; font-size:14px; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif;
	background:url(<%=contextPath%>/images/number_bg_red.png) repeat-x; margin:4px 0 0 3px;
	}
.count_comma{
	float:left; width:6px; height:21px;  display:block; color:#6395c7;margin:4px 0 0 3px;
	line-height:21px; font-size:14px; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; 
	}
.count_comma_red{
	float:left; width:6px; height:21px;  display:block; color:#ea3f11;margin:4px 0 0 3px;
	line-height:21px; font-size:14px; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; 
	}
.count_tiao{
	width:15%;min-width:30px; float:left; margin-left:10px; font-size:14px; color:#073d6b; line-height:32px;
	}
.c_t_wrap{width:98%; height:auto; overflow:hidden; float:left; margin:10px 0 0 10px;}
.c_table{width:100%; border:1px solid #e8e8e8; height:auto; overflow:hidden;}
.c_table tr.trBg{background-color:#f3f3f3}
.c_table tr{background-color:#f9fcfc;}
.c_table th{line-height:30px; font-size:12px; color:#324f85;background:url(<%=contextPath%>/images/tableTitle.png) repeat-x;font-weight:bold;}
.c_table td{border-bottom:1px dashed #e8e8e8; line-height:30px; font-size:12px; color:#000; font-weight:normal;text-align:center;
	 background-color:#ffffff;}
.c_table td.redText{color:#F00; background-color:#ffffe7;}
.c_table td.tdgray{border-bottom:1px dashed #eeeeee; line-height:30px; font-size:12px; color:#000; font-weight:normal;text-align:center;
	 background-color:#f2f2f2;}
.xxcx_wrap{ width:25%; height:32px; float:right;line-height:32px;}
.btnBg{ background: url(<%=contextPath%>/images/fdj_ico.png) no-repeat 10px center #007be3;
 color:#fff; font-weight:bold; line-height:32px; font-size:14px;  border:0px; 
 width:140px; height:32px; cursor:pointer; 
 text-indent:45px; float:right;
 }

.dept_wrap{width:70%; float:left; height:32px;margin-top: 5px;}
.dept_text{ font-size:14px; color:#333;float:left; width:70px; text-align:center; line-height:32px;}
.dept_Select{width:300px; float:left;line-height:32px;}
	
	
	</style>
<title></title>

<script type="text/javascript">
  var markerArr = new Array();
</script>
</head>
<body class="easyui-layout" data-options="fit:true" onload="boydLoad()">  
<input type="hidden" id="dwdm" />
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">  
    	
    	 	
    	 	
    			<div class="c_t_wrap">
				<div class="dept_wrap">
						部门选择:&nbsp;
    					<input id="cc1" class="easyui-combobox"  data-options="    
					        valueField: 'id',    
					        textField: 'text',
					        width:140,    
					        url: '<%=basePath %>gzjk/queryOrg',    
					        onSelect: function(rec){    
					            var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;    
					            $('#cc2').combobox('reload', url);    
					        }" />   
					        &nbsp;
						<input id="cc2" class="easyui-combobox"  data-options="valueField:'id', width:140, textField:'text',onSelect:selectChangeLoad" />  
				</div>
				
				<div class="xxcx_wrap" >
				<div class="btnBg">查询详细信息</div>
				</div>
				
			</div>
    			
    			
    			
				<div class="t_bg_wrap" style="width: 520px;height: 180px">
				<div style="width:100%;  height:auto; overflow:hidden; float:left;">
					  <div class="count_title01"></div>
					<div class="count_wrap">
  					<div class="count_tr">
    					<div class="count_title">总&nbsp;数&nbsp;据：</div>
					      <div class="count_type">
					        <div class="count_right" id="rkCount">
					
					        </div>
					      </div>
				    	<div class="count_tiao">条</div>
				  	</div>
				    <div class="count_tr">
				    <div class="count_title">今日新增：</div>
				      <div class="count_type">
				        <div class="count_right" id="rkAddCount">
				        
				        </div>
				      </div>
				    <div class="count_tiao">条</div>
				  </div>
				  
				  <div class="count_tr">
				    <div class="count_title">今日修改：</div>
				      <div class="count_type">
				        <div class="count_right" id="rkEditCount">
				        
				        </div>
				      </div>
				    <div class="count_tiao">条</div>
				  </div>
				  
				    <div class="count_tr">
				    <div class="count_title">今日注销：</div>
				      <div class="count_type">
				        <div class="count_right" id="rkDeleteCount">
				        </div>
				      </div>
				    <div class="count_tiao">条</div>
				  </div>
				</div>
			</div>
			<div class="count_jiao"></div>
			</div>

    	 	
    	 	<div class="c_t_wrap" style="height: 395px;">
    	 	
            	<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>gzjk/list/dz/${sessionScope.userSession.userOrgCode }',toolbar:'#datagridToolbar',
            		selectOnCheck:false,checkOnSelect:true,border:false,sortName:'c.mlphdm',sortOrder:'desc',
            		idField:'id',
            		pageSize:20,
            		pageList:[20],
            		onLoadSuccess:function(data){ loadPoints();fontColorChange();},
            		onSelect:onSelectRow,
            		singleSelect:true,
            		pagination:false,
            		toolbar:'#datagridToolbar' ">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'bdlx',width:10,align:'center',sortable:true,halign:'center',formatter:getBdlx">变动类型</th>
				            <th  data-options="field:'dzqc',width:30,align:'center',halign:'center',formatter:subjzdz,sortable:true">地址全称</th>
				            <th data-options="field:'zbx',hidden:true">zbx</th>
				            <th data-options="field:'zby',hidden:true">zby</th>
				            <th data-options="field:'isNew',hidden:true">isNew</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
        	</div>
    </div>   
    </div>
</body>
<script type="text/javascript">
function onSelectRow(rowIndex, data){
	if(markerArr[rowIndex]!=undefined && markerArr[rowIndex]!="" && markerArr[rowIndex]!="null"){
		if (IE) {
			parent.frames["main_center"].GzjkMap.centerByPoint(markerArr[rowIndex],19,data.jzdzdm);
		}else{
			var obj = parent.frames.document.getElementById("main_center").contentWindow;
			obj.GzjkMap.centerByPoint(markerArr[rowIndex],19,data.jzdzdm);
		}
	}else{
		//alert("人员无坐标");
	}
	
}
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return changeFontColor(val, row, index)
}

var isFontColorChange = false;
var isChange = false;

//设置返回颜色时间
function fontColorChange(){
	if(isChange){
		if(!isFontColorChange){
			window.setInterval(fontColorChange, 10000);
			isFontColorChange = true;
		}else{
			var gridData = $("#dg").datagrid("getData");
			for(var i=0;i<gridData.rows.length;i++){
				gridData.rows[i].isNew = "0";
			}
			isChange = false;
			isFontColorChange = false;
			$("#dg").datagrid("loadData",gridData);
		}
	}
}


//列表数据变色
function changeFontColor(val, row, index){
	if(row.isNew !=null && row.isNew == "1"){
		isChange = true;
		return "<font color='red'>"+val+"</font>";
	}else{
		return val;
	}
}


//获取变动类型
function getBdlx(val, row, index){
	if( val =="0" ){
		return changeFontColor("新增", row, index);
	}else if(val =="1"){
		return changeFontColor("修改", row, index);
	}else{
		return changeFontColor("注销", row, index);
	}
}

//操作列  
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	return '&nbsp;<a class="link" href= "'+ap.bzdz_url+'?view=house&fwdm=&jzwdm='+rowData.jzwid +'" target="_blank">层户结构</a>&nbsp;' ;
}

//页面载入画点
function loadPoints(){
	if(typeof(parent.frames["main_center"].GzjkMap)=="undefined"){
	}else{
		parent.frames["main_center"].GzjkMap.clearMarkers();
	}
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	for(var i=0;i<len;i++){
		var dz = rows[i].dzqc;
		if(rows[i].zbx!=null && rows[i].zbx!=""){
			var marker =null;
			if (IE) {
				marker =  parent.frames["main_center"].addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,34,34,false,rows[i].jzdzdm,null);
			}
			else {
				var obj = parent.frames.document.getElementById("main_center").contentWindow;
				marker = obj.addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,32,32,false,rows[i].jzdzdm,null);
			}
			markerArr[i] = marker;
		}else{
			//alert("人员无坐标");
		}
	};
}


function boydLoad(){
	var pageType =  "${level}";
	
	if(pageType == "1"){
		
		var orgCode = '${sessionScope.userSession.userOrgCode}';
		
		orgCode = orgCode.substring(0,6) + "000000";
		
		$("#cc1").combobox({editable:false});
		
		$("#cc1").combobox("select",orgCode);
		$("#dwdm").val(orgCode);
		
	}else if(pageType == "2"){
		
		var orgCode = '${sessionScope.userSession.userOrgCode}';
		
		orgCode = orgCode.substring(0,6) + "000000";
		
		$("#cc1").combobox({editable:false});
		
		$("#cc1").combobox("select",orgCode);
		
		var orgCode2 = '${sessionScope.userSession.userOrgCode}';
		
		orgCode2 = orgCode2.substring(0,8) + "0000";
		
		$("#cc2").combobox({editable:false});
		
		$("#cc2").combobox("select",orgCode2);
		$("#dwdm").val(orgCode2);
		
	}else{
		var orgCode = '${sessionScope.userSession.userOrgCode}';
		$("#dwdm").val(orgCode.substring(0, 4));
	}
	loadJrtj();
}

//统计数目 样式改变回来
function ResetStyle(){
	
	$("span[name='numberStyle']").each(function(){
		$(this).removeClass("count_number_red");
		$(this).addClass("count_number");
	})
}

var Re_Count_Data = null;

function loadJrtj(){
	$.ajax({
		type: 'post',
		url: contextPath + '/gzjk/jrtj/dz',
		data:"dwdm="+$("#dwdm").val(),
		dataType:"json",
		success: function(data) {
			
			var textTemp = "";
			var numberTemp = "";
			
			var totalClassName = "count_number";
			var addClassName = "count_number";
			var editClassName = "count_number";
			var delClassName = "count_number";
			
			if(Re_Count_Data != null){
				
				if( Re_Count_Data.total != data.total ){
					totalClassName = "count_number_red";
					window.setInterval(ResetStyle, 10000);
				}
				
				if( Re_Count_Data.add != data.add ){
					addClassName = "count_number_red";
					window.setInterval(ResetStyle, 10000);
				}
				
				if( Re_Count_Data.update != data.update ){
					editClassName = "count_number_red";
					window.setInterval(ResetStyle, 10000);
				}
				
				if( Re_Count_Data.del != data.del ){
					delClassName = "count_number_red";
					window.setInterval(ResetStyle, 10000);
				}
				
				
			}
			
			
			//总条数
			var RkTotal =  data.total + "";
			for(var i = 0 ; i < RkTotal.length ; i++ ){
				numberTemp = RkTotal.substring(i,i+1);
				textTemp+="<span name='numberStyle' class='"+ totalClassName +"'>"+numberTemp+"</span>";
			}
			document.getElementById("rkCount").innerHTML = textTemp;
			
			//新增条数
			textTemp = "";
			var RkAddCount =  data.add + "";
			for(var i = 0 ; i < RkAddCount.length ; i++ ){
				numberTemp = RkAddCount.substring(i,i+1);
				textTemp+="<span name='numberStyle' class='"+ addClassName +"'>"+numberTemp+"</span>";
			}
			document.getElementById("rkAddCount").innerHTML = textTemp;
			
			//修改条数
			textTemp = "";
			var RkEditCount =  data.update + "";
			for(var i = 0 ; i < RkEditCount.length ; i++ ){
				numberTemp = RkEditCount.substring(i,i+1);
				textTemp+="<span name='numberStyle' class='"+ editClassName +"'>"+numberTemp+"</span>";
			}
			document.getElementById("rkEditCount").innerHTML = textTemp;
			
			//注销条数
			textTemp = "";
			var RkDeleteCount =  data.del + "";
			for(var i = 0 ; i < RkDeleteCount.length ; i++ ){
				numberTemp = RkDeleteCount.substring(i,i+1);
				textTemp+="<span name='numberStyle' class='"+ delClassName +"'>"+numberTemp+"</span>";
			}
			document.getElementById("rkDeleteCount").innerHTML = textTemp;
			
			Re_Count_Data = data;
			
		}
	});
}

//重新加载数据
function GridReloadData(){
	$('#dg').datagrid('reload');
}

//下拉框选择时调用
function selectChangeLoad(orgDom){
	var a = "<%=basePath %>gzjk/list/dz/"+orgDom.id;
	$('#dg').datagrid({url:a});
	$("#dwdm").val(orgDom.id);
	loadJrtj();
}

window.setInterval(loadJrtj, 60000);

window.setInterval(GridReloadData, 60000);

</script>  

</html>