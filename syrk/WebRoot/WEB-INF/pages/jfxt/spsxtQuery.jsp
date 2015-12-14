<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>视频建设单位查询</title>
<!-- 字典翻译需要的js库文件  -->
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/jf_sxtScript.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/JF_DIC_TRANSLATE.js"></script>
<script type="text/javascript">
	var snswObject={"0":"室内","1":"室外"};
	var qjqjObject={"0":"枪机","1":"球机"};
	var gdkdObject={"0":"固定","1":"可动"};
	var sfgaObject={"0":"社会资源","1":"公安自建"};
	function traslateCode(code){
		return jslbObject[code];
		//return jslbObject.code;
	}
	function gaoqingbiaoqing(code){
		return JFXT.getResolution(code);
	}
	function qiangjiqiuji(code){
		return qjqjObject[code];
	}
	function shineishiwai(code){
		return snswObject[code];
	}
	function gudingkedong(code){
		return gdkdObject[code];
	}
	function sfgongan(code){
		return sfgaObject[code];
	}
	function yeshi(code){
		return JFXT.getSight(code);
	}
	function dlqy(code){
		return JFXT.getArea(code);
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
 <div data-options="region:'center',border:false">
   	<div class="easyui-layout" data-options="fit:true,border:false">   
       <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
		<table id="dg" class="easyui-datagrid" data-options="toolbar:'#datagridToolbar',
		            method:'post',
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
						            <th data-options="field:'sxtbh', width:10,	align:'left',	halign:'center'">摄像头编号</th>
						            <th data-options="field:'sfgazj', width:6,	align:'left',	halign:'center',formatter:function(value,row,index){return sfgongan(value);}">是否公安自建</th>
						            <th data-options="field:'sszrq', width:10,	align:'left',	halign:'center'">所在责任区</th>
						            <th data-options="field:'dwmc', width:10,	align:'left',	halign:'center'">点位名称</th>
						            <th data-options="field:'azbw_rw_dzxz', width:10,	align:'left',	halign:'center'">标准地址</th>
						            <th data-options="field:'jd', width:6,	align:'left',	halign:'center'">经度</th>
						            <th data-options="field:'wd', width:6,	align:'left',	halign:'center'">纬度</th>
						            <th data-options="field:'cx', width:6,	align:'left',	halign:'center'">朝向</th>
						            <th data-options="field:'jkjd', width:6,	align:'left',	halign:'center'">角度</th>
						            <th data-options="field:'sbgqsx', width:4,	align:'left',	halign:'center',formatter:function(value,row,index){return gaoqingbiaoqing(value);}">高清标清</th>
						            <th data-options="field:'sb_qjqj', width:4,	align:'left',	halign:'center',formatter:function(value,row,index){return qiangjiqiuji(value);}">枪击球机</th>
						            <th data-options="field:'sb_snsw', width:4,	align:'left',	halign:'center',formatter:function(value,row,index){return shineishiwai(value);}">室内室外</th>
						            <th data-options="field:'sbyssx', width:4,	align:'left',	halign:'center',formatter:function(value,row,index){return yeshi(value);}">夜视非夜视</th>
						            <th data-options="field:'sb_gd', width:4,	align:'left',	halign:'center',formatter:function(value,row,index){return gudingkedong(value);}">固动</th>
						        	<th data-options="field:'process',width:10,align:'center',	halign:'center',formatter:datagridProcessFormater">单位详细信息</th>
						        </tr>

						    </thead>
						</table>
				<!-- 工具条 start  -->
				<div id="datagridToolbar" style="padding:5px;height:30px;width:100%">
				   	<table width="100%">				   	
				   	<tr>
					   	<td>管理部门：</td>
					   	<td>
					   	<input type="text" id="orgcode1" name="orgcode1" value="" style="width: 100;" />
					    <input type="text" id="orgname1" name="orgname1" style="width: 400;" value="" />
					    <!-- --> 
					   	<input type="text" id="orgid1" name="orgid1" value="" style="width: 100;" />
					   	
					    <input type="button" id="orgbutton1" value="选择" onClick="selectOrganization()" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    				</td>
				    </tr>

				    
			        <tr>
			        	<td>
			        	<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px" onclick="searchJsdw();"/>
			        	</td>
			        </tr>				    
				    </table>					
				</div>
				<!-- 工具条 end  -->
       </div>
   </div>
</div>
<script type="text/javascript">

	function datagridProcessFormater(val,row,index){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="spxxShow(this,'+index+')">详细信息</a>&nbsp;&nbsp;';
	}
    
    //自定义列
    function showpic(val,row,index){
      return '&nbsp;<a class="link" title="点击显示摄像头照片" href="javascript:javascript:void(0)" onclick="picture(this,'+index+')">'+val+'</a>&nbsp;&nbsp;';
    }
 	function datagridJsdwFormater(val, row, index) { // 自定义操作生成
	  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="jsdwShow(this,'+index+')">'+val+'</a>&nbsp;&nbsp;';
    }
    function datagridJkxtFormater(val, row, index) { // 自定义操作生成
	  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="jkxtShow(this,'+index+')">'+val+'</a>&nbsp;&nbsp;';
    }
    //修改单条
 	function doEdit(linkObject, index) {
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		var editUrl = contextPath+"/spjsdw/queryByDwbm?dwbm="+rowData.dwbm;
		parent.document.getElementById("mainAreaId").src = editUrl;
	}
	///////////////////
 //根据选择的部门(大部门/小部门)
	function searchJsdw(){
	
		var condition = document.getElementById("orgcode1").value;
	
		
		if(condition==null || condition=='undefined'){
			condition="";
		}
		//alert("选择的部门id"+condition);
		var reloadUrl  = contextPath + '/sptgl/queryListByBmid';
		var opt = $('#dg').datagrid('options');
		opt.url = reloadUrl;
		
		condition= $.trim(condition);
		
		//alert("condition"+condition);
		$('#dg').datagrid('reload',{bmid:condition});//重新装载
		//$('#dg').datagrid("clearSelections");
	}
//重新加载列表
/*
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var zbz = document.getElementById("zbz").value;
	var type = document.getElementById("type").value;
	var mapRadius = document.getElementById("mapRadius").value;
	var reloadUrl = contextPath + '/ryjzdzzb/queryJzdz';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid(
			'reload',
			{    
				'zbz': zbz,   
				'type': type ,
				'mapRadius':mapRadius
			});
}
*/

//获得选择的行业类别,形如：id1,id2,...
function getSelectedNodes(){

	var t = $('#dwlx').combotree('tree');	// 获取树对象
	var nodes = t.tree('getChecked');		// 获取选择的节点
	//alert(nodes.length);
	var mdwlx="";
	var selectedItemArray=[];
	for(var i=0;i<nodes.length;i++){
		//alert(nodes[i].id+","+nodes[i].text);
		if(2!=nodes[i].id.length){
			selectedItemArray.push(nodes[i].id);
		}
	}
	//alert(selectedItemArray.join(','));
	for(var j=0;j<selectedItemArray.length;j++){
		mdwlx+="'"+selectedItemArray[j]+"',";
	}
	mdwlx=mdwlx.substring(0,mdwlx.length-1);//删除最后一个','号
	var toptext=$('#dwlx').combotree('getText');
	if (toptext==null||toptext==""){
	mdwlx="";
	}
	return mdwlx;

}	
	</script>
<script language="JavaScript">
	//选择了一个管理单位
	function onOrgSelected22(orgCodeInputID) {
		var condition=$('#orgcode1').val();
		
		//根据选择的部门查询所有子部门下的视频建设单位，然后再下拉列表中显示
		var reloadUrl  = contextPath + '/spjsdw/queryByBmid?bmid='+condition;
		var opt = $('#dwbm').combobox('options');
		opt.url = reloadUrl;
		
		condition= $.trim(condition);
		//alert("selected:"+condition+","+reloadUrl);
		//$('#dwbm').combobox('reload',{bmid:condition});//重新装载
		$('#dwbm').combobox('reload',reloadUrl);  
	}
	
	$(document).ready(function() { // 初始化部门名称
		public_getOrgName('orgcode', 'orgname');
	});
function jsdwShow(linkObject, index){
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		//alert(rowData.id);
		var sxtid =rowData.id;
		var title="建设单位简要信息";
   		var paramArray =null;
   		var editUrl = contextPath + '/sptgl/queryJsdwBySxtId?id='+sxtid;
   	   	openWindowNoSave(false, null,this.Window, 
   	   		paramArray, 
   	   		{
   	   		title: title,
   	   		url: editUrl,
   	   		maximizable: false,
   	   		width: 850,
   	   		height:600
   	   		}, 
   	   		null
   	   	);}
function jkxtShow(linkObject, index){
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		//alert(rowData.id);
		var sxtid =rowData.id;
		var title="监控系统简要信息";
   		var paramArray =null;
   		var editUrl = contextPath + '/sptgl/queryJkxtBySxtId?id='+sxtid;
   	   	openWindowNoSave(false, null,this.Window, 
   	   		paramArray, 
   	   		{
   	   		title: title,
   	   		url: editUrl,
   	   		maximizable: false,
   	   		width: 850,
   	   		height:600
   	   		}, 
   	   		null
   	   	);}
</script>	
<script type="text/javascript">
function spxxShow(linkObject, index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	//alert(rowData.id);
	var editUrl = contextPath+"/sptgl/showSXTxxxx?id="+rowData.id;
	//var editUrl = contextPath+"/sptgl/spsxtEdit?id="+rowData.id;
	var title="视频点位简要信息";
	var paramArray =null;
	openWindowNoSave(false, null,this.Window, 
   	   		paramArray, 
   	   		{
   	   		title: title,
   	   		url: editUrl,
   	   		maximizable: false,
   	   		width: 840,
   	   		height:550
   	   		}, 
   	   		null
   	   	);
}

</script>
<script type="text/javascript">
function picture(linkObject, index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var pic =rowData.pic_location;


	var pic_l=pic;
    var hsUrl = "/sptgl/showPicJsp?";
	hsUrl+="path="+pic_l;
	menu_open("摄像头照片",hsUrl);
}

</script>
<script type="text/javascript">
var g_filterOrgCode="210200000000";//全局变量

$(document).ready(function() { // 初始化部门名称
	public_getOrgName('orgcode', 'orgname');
	setFilterOrgCode();//获得初始过滤组织机构
});


//点击按钮后调用
function selectOrganization(){
	//第四个参数取值:01--社区,04--责任区
	public_singleSelectOrg('', '01', '', '', 'orgcode1', 'orgname1', 'orgid1', false, false, '', window, 'onOrgSelected', '');
	
}
//为全局变量赋值
function setFilterOrgCode(){
	url=contextPath+"/idName/getFilterOrgCode";
	$.getJSON(url,function(orgCode){
		g_filterOrgCode=orgCode;
		//alert(orgCode);
	})
}

function onOrgSelected(orgCodeInputID) {
	//alert(orgCodeInputID);
}
</script>
  </body>
</html>