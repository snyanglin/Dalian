<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}
	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	.imgStyle{
		height:19px;
		width:19px;
	}
	</style>
<script type="text/javascript">
  var markerArr = new Array();
  var dz_dwdzdmArr = new Array();
  var Globalsydwlx = '${dwlbdm}';
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
   <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto;overflow:hidden;">
            	<table id="dg" class="easyui-datagrid" 
            	data-options="url:'<%=basePath %>sydw_dl/list',
            		delayCountUrl:'<%=basePath %>sydwcx_dl/queryCountDw',
            		queryParams:{dwlbdm:'${dwlbdm}'},
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		sortName:'',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:getAutoPageSize(120),
            		pageList:[getAutoPageSize(120),
            		getAutoPageSize(120) * 2],
            		onLoadSuccess:function(data){ loadpoints1(data);},
            		onSelect:onSelectRow,
            		singleSelect:true,
            		fitColumns:true,
            		toolbar:'#datagridToolbar'">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'dwlbdm',	width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_DWLB.js',sortable:true">类别</th>
				            <th data-options="field:'dwmc',		width:120,align:'left',halign:'center',sortable:true">单位名称</th>
				            <th data-options="field:'dz_dwdzxz',	width:200,align:'right',halign:'center',formatter:subjzdz,sortable:true">单位地址</th>
				            <th data-options="field:'process',width:90,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td align="right" >
							<input type="text" class="searchText" name="condition"  id="condition" value="请输入单位名称、地址信息" 
									style="color:gray;height:32px;font-size:13px;width:240px"  onclick="setDzqc(this)" onkeydown="passwordOnkeyPress(this)" />
						</td>
						<td align="left">
							<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" 
									style="cursor: pointer;height:32px" onclick="searchMain();"/>
						</td>
						<td>
							<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="detailSearch()">精确查询</a>
						</td>
						<td>
							<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="syrkAdd();">新增</a>
						</td>
					</tr>
				</table>
				</div>
			</div>
        </div>
    </div>   
    
    <input type="hidden" id ="zbz" value="">
    <input type="hidden" id ="type" value="">
    <input type="hidden" id ="mapRadius" value="">
    <!-- 精确查询框 -->
    <div id="win" class="easyui-window" title="实有单位精确查询" style="width:400px;height:350px;top:20px;display:none;"   
        data-options="iconCls:'icon-search',
        collapsible:false,
        minimizable:false,
        maximizable:false,
        modal:true,
        closed:true,
        top:100,
        width:400,
        height:280,
        left:50">   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
		       <form id ="queryForm" >
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				       <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">单位类型：</td>
						    	<td width="70%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="dwlbdm" name="dwlbdm"
									 style="width:150px;"
										data-options="url: contextPath + '/common/dict/D_DW_DWLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>
					   	</tr>					      
				       <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">单位名称：</td>
						    	<td width="70%" class="dialogTd"><!-- data-options="url: contextPath + '/common/dict/D_RK_ZDRYLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" -->
									<input  type="text" id="dwmc" name="dwmc" style="width:150px;"
									class="easyui-validatebox" 
										data-options="required:false,validType:'maxLength[20]'"
									/>
									</td>
					   	</tr>	
				        <!--  <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">单位别名：</td>
						    	<td width="70%" class="dialogTd"><input type="text" name="dwbm"  id ="dwbm" class="easyui-validatebox" 
						    		data-options="required:false,validType:'maxLength[20]'"  style="width:150px;" /></td>
					    </tr>-->
					    <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">单位地址：</td>
						    	<td width="70%" class="dialogTd"><input type="text" id="dz_dwdzxz" name="dz_dwdzxz" class="easyui-validatebox" 
						    		data-options="required:false,validType:'maxLength[30]'"  
						    		style="width:150px;" /></td>
					    </tr>	
					   <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">经营范围(主营)：</td>
						    	<!-- data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" -->
						    	<td width="70%" class="dialogTd"><input type="text" id="jyfwzy" name="jyfwzy" style="width:150px;"
						    	class="easyui-validatebox" 
						    	data-options="required:false,validType:'maxLength[30]'"
									/></td>
					    </tr>
					    <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">经营性质：</td>
						    	<td width="70%" class="dialogTd"><input class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm" style="width:150px;"
									data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
					    </tr>
					    <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">单位地址状态：</td>
						    	<td width="70%" class="dialogTd">
							    	<input type='checkbox' id='ybzdz'/>有标准地址 
							    	<input type='checkbox' id='wbzdz'/>无标准地址
						    	</td>
					    </tr>
					    <tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
						    	<td width="100%" colspan="2" align="right">
						    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton();">确定</a>
						    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
						    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
						    	</td>
					    </tr>
			         </table>
			       </form>
	        </div>  
	        <div id="cancel_1" class="easyui-window" data-options="iconCls:'icon-user',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:460,height:180">
		        <form action="<%=basePath%>sydw_dl/" id="cancelform_1" name="cancelform_1" method="post">
		            <input type="hidden" id="main_id" name="id" />
		            <input type="hidden"   name="_method" value="delete" />
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">注销原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					            <textarea id="xt_zxyy" name="xt_zxyy" class="easyui-validatebox" style="width: 300px; height:78px;overflow: auto;" data-options="validType:['maxLength[100]'],required:true,invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
					        </td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="3" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="cancelButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('cancel_1');">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div> 
	    </div>   
</div>  


</body>
<script type="text/javascript">
///----------查询功能页方法--------------
//----精确查询框方法---------
function closeWindow(id){
	if(id)
		$("#"+id).window("close"); 
	else
		$("#win").window("close"); 
}
function detailSearch(){
	$("#win").show();
	$("#win").window("open"); 
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
}
// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl_dl/view?id="+rowData.id;
	menu_open("实有单位编辑",editUrl);
}
var datagrid_ID ;
//删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	datagrid_ID = getDatagrid_ID(0, linkObject);
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	$("#main_id").val(rowData.id);
	$("#cancelform_1").attr("action",basePath+"sydw_dl/"+rowData.id);
	$("#cancel_1").window("open"); 
	$("#cancel_1").window("setTitle","注销");
}
function cancelButton(obj){
	if(!$("#cancelform_1").form("validate")){
		return ;
	}
	topMessager.confirm('','您确认要注销数据吗？',function(r){    
		if(r){
			$("#cancelform_1").form("submit",{
				dataType:"json",
				success: function(result){
					result = parseReturn(result);
					if (result.status == "success"){
						closeWindow("cancel_1");
						$("#cancelform_1").form("reset");
						doSubmitResult(result, null, datagrid_ID);
					}
					else {
						topMessager.alert(MESSAGER_TITLE, result.message, "error");
					}
				}
			});
		}
	});
};
//按下enter
function passwordOnkeyPress(obj) {
			 obj.style.color = "black";
			 var keycode = event.keyCode;
			   if (keycode == 13) {
				   searchMain();
			   }
		}
//按下enter,清空
function setDzqc(obj){
			   obj.value="";
		}

function syrkAdd(){
	menu_open('实有单位新增', '/dwjbxxb_dl/create');
}

function searchMain(){
	if (IE) {
		parent.frames["biz_center"].SydwMap.clearGraph();
	}else{
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.SydwMap.clearGraph();
	}
	var condition = document.getElementById("condition").value;
	if(condition=="请输入单位名称、地址信息"){
		condition="";
	}
	var reloadUrl = contextPath + '/sydwcx_dl/queryDw';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	
	condition= $.trim(condition);
	if(Globalsydwlx!=null && Globalsydwlx!="" && typeof(Globalsydwlx)!="undefined"){
		$('#dg').datagrid('load',{condition:condition,dwlbdm:Globalsydwlx}); 
	}else{
		$('#dg').datagrid('load',{condition:condition});
	}
	
	 
	$('#dg').datagrid("clearSelections");
}

//----精确查询框方法---------
//1关注：绿；2重点关注：红；3重点管理：黄
function jgjbdm(value,row,index){
	if(value==1){
		return '<img src= '+contextPath+'/images/lamp_green.png class=imgStyle title=关注		/>';
	}else if(value==2){
		return '<img src= '+contextPath+'/images/lamp_red.png class=imgStyle title=重点关注			/>';
	}else if(value==3){
		return '<img src= '+contextPath+'/images/lamp.png class=imgStyle title=重点管理		/>';
	}
	return "";
}

function onSelectRow(rowIndex, data){
	if(typeof(markerArr[data.dz_dwdzmlpdm])!="undefined" && markerArr[data.dz_dwdzmlpdm]!="" && markerArr[data.dz_dwdzmlpdm]!=null){
		if(IE){
			parent.frames["biz_center"].SydwMap.centerByPoint(markerArr[data.dz_dwdzmlpdm],19,dz_dwdzdmArr[data.dz_dwdzmlpdm]);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.SydwMap.centerByPoint(markerArr[data.dz_dwdzmlpdm],19,dz_dwdzdmArr[data.dz_dwdzmlpdm]);
		}
	}else{
		alert("单位地址无坐标");
	}
}
//查询按钮
function queryButton(){
	var dwlbdm = document.getElementById("dwlbdm").value;
	var dwmc = document.getElementById("dwmc").value;
	var dz_dwdzxz = document.getElementById("dz_dwdzxz").value;
	var jyfwzy = document.getElementById("jyfwzy").value;
	var jyxzdm = document.getElementById("jyxzdm").value;
	dwmc= $.trim(dwmc);
	dz_dwdzxz= $.trim(dz_dwdzxz);
	var reloadUrl = contextPath + '/sydw_dl/list';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	var dwdzzt = "0";
	var ybzdz = document.getElementById("ybzdz");
	var wbzdz = document.getElementById("wbzdz");
	if(ybzdz.checked==true&&wbzdz.checked==false){
		dwdzzt = "1";
	}else if(ybzdz.checked==false&&wbzdz.checked==true){
		dwdzzt = "2";
	}
	if(Globalsydwlx!=null && Globalsydwlx!="" && typeof(Globalsydwlx)!="undefined"){
		$('#dg').datagrid(
				'load',
				{    
					'dwlbdm':Globalsydwlx,
					'dwmc':dwmc,
					'dz_dwdzxz':dz_dwdzxz,
					'jyfwzy':jyfwzy,
					'jjlxdm':jyxzdm,
					'dwdzzt':dwdzzt
				});
	}else{
		$('#dg').datagrid(
				'load',
				{    
					'dwlbdm':dwlbdm,
					'dwmc':dwmc,
					'dz_dwdzxz':dz_dwdzxz,
					'jyfwzy':jyfwzy,
					'jjlxdm':jyxzdm,
					'dwdzzt':dwdzzt
				});
	}
	closeWindow("win");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
//---------------框查-----
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	/*
	if(val.indexOf("辽宁省大连市")>=0){
		val = val.substring(val.lastIndexOf("市")+1,val.length);
	}
	if(val.indexOf("辽宁省")>=0){
		val = val.substring(val.lastIndexOf("省")+1,val.length);
	}
	*/
	//var searchKey = "美丽巷";
	//var regExp = new RegExp(searchKey, "igm");
	//val = val.replace(regExp, "<font color=\"#FF0000\">"+ searchKey +"</font>");
	return val;
}

//重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var zbz = document.getElementById("zbz").value;
	var type = document.getElementById("type").value;
	var mapRadius = document.getElementById("mapRadius").value;
	var reloadUrl = contextPath + '/sydwcx_dl/queryDwDzOnPT';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid(
			'load',
			{    
				'zbz': zbz,   
				'type': type ,
				'mapRadius':mapRadius
			});
}

//重置加载
function loadGrid(){
	$('#dg').datagrid('load',{zbz:null,type:null,mapRadius:null,rows:21});  
	$('#dg').datagrid("clearSelections");
}

function loadpoints1(data){
	//延迟加载统计
	beforeTableLoad(data,'dg');
	
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}
	else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if (mapWindow.SydwMap) {
			mapPoint(mapWindow);
		}
		else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}

function mapPoint(mapWindow) {
	//markerArr = new Array();
	if (mapWindow.SydwMap) {
		mapWindow.SydwMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		var dwidsArray = [];
		for (var i = 0; i < len; i++) {
			dwidsArray.push("'" + rows[i].id + "'");
			if (rows[i].dz_dwdzdm != "undefined" && rows[i].dz_dwdzdm != "") {
				dz_dwdzdmArr[rows[i].dz_dwdzdm] = rows[i].dz_dwdzdm;
			}
		}
		if (len > 0) {
			$.ajax({
				type:"GET",
				sync:true,
				url:contextPath+"/sydwcx_dl/queryZbByDzId",
				data:{dwids:dwidsArray.join(",")},
				dataType:'json',
				success:function(json){
					var len = json.length;
					for (var i = 0; i < len; i++) {
						
						if (json[i].zbx!=null && json[i].zbx!=""){
							var marker = null;
							if (IE) {
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							} else{
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							}
							markerArr[json[i].dz_dwdzdm] = marker;
							dz_dwdzdmArr[json[i].dz_dwdzdm] = json[i].dz_dwdzdm;
							console.log(json[i].dz_dwdzdm);
						}
					}
				}
			});
		}
	}
}

</script>  

</html>