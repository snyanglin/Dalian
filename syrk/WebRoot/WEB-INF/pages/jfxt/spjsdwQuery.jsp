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
		//return jslbObject.code;
	}

</script>
</head>
<body class="easyui-layout" data-options="fit:true">
 <div data-options="region:'center',border:false">
   	<div class="easyui-layout" data-options="fit:true,border:false">   
       <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
		<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>spjsdw/queryListByBmid?bmid=31',toolbar:'#datagridToolbar',
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
						            <th data-options="field:'dwbm', width:15,	align:'left',	halign:'center',sortable:true">单位编码</th>
						            <th data-options="field:'dwmc', width:25,	align:'left',	halign:'center',sortable:true">单位名称</th>
						            <th data-options="field:'jslb', width:15,	align:'left',formatter:function(value,row,index){return traslateCode(value);},halign:'center',sortable:true">行业类别</th>
						            <th data-options="field:'xt_zhxgrxm', width:15,	align:'left',	halign:'center',sortable:true">采集人</th>
						            <th data-options="field:'xt_zhxgrbm', width:15,	align:'left',	halign:'center',sortable:true">采集人所在单位</th>
						            <th data-options="field:'process',width:10,align:'center',	halign:'center',formatter:datagridProcessFormater">单位详细信息</th>
						        </tr>

						    </thead>
						</table>
				<!-- 工具条  -->
				<div id="datagridToolbar" style="padding:5px;height:30px;width:100%">
				   	<table width="100%">				   	
				   	<tr>
					   	<td>管理部门：</td>
					   	<td>
					   	<input type="text" id="orgcode1" name="orgcode1" value="" style="width: 100;" />
					    <input type="text" id="orgname1" name="orgname1" readonly="readonly" style="width: 400;" value="" />
					   	<input type="hidden" id="orgid1" name="orgid1" value="" style="width: 100;" />
					    <input type="button" id="orgbutton1" value="选择管理单位" onClick="public_singleSelectOrg('', '01', '', '', 'orgcode1', 'orgname1', 'orgid1', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 100px;font-family:宋体;font-size:9pt;" />
					    </td>
				    </tr>
			        <tr>
			        	<td>
			        	<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px" onclick="searchJsdw();"/>
			        	</td>
			        </tr>				    
				    </table>
					
				</div>
       </div>
   </div>
</div>
<!--单位信息-->
<div class="easyui-dialog" id="dwDetail" 
	data-options=" title:'单位基本信息',modal:true,closed:true ">
<div class="lf_conta cont_edit">
<div class="lf_contb">
<div class="lf_contc">
<!-- 调整宽度  -->
<dl class="infodl" style="width:70%">
<dt><div class="dllf info_jbxx">基本信息</div></dt>
<dd >
    <ul>
  	<li><span class="spantitle">单位名称：</span><span id="dwmc" class="edit_word input_w2">400</span></li> 
    <li><span class="spantitle">经营范围：</span><span id="jyfwzy" class="edit_word input_w2"></span></li>
	<li><span class="spantitle">详细地址：</span><span id="dwdzxx" class="edit_word input_w1"></span></li> 
	
	
	<li><span class="spantitle">负责人姓名：</span><span id="xm"  class="edit_word input_w2">1</span></li> 
	<li><span class="spantitle">证件号码：</span><span id="zjhm" class="edit_word input_w2"></span></li>
	 
	<li><span class="spantitle">出生日期：</span><span id="csrq" class="edit_word input_w2"></span></li> 
	<li><span class="spantitle">联系电话：</span><span id="lxdh" class="edit_word input_w2">2014-10-14</span></li> 
	<li><span class="edit_word input_w2"><button onclick="$('#dwDetail').dialog('close');">关闭</button></span></li> 
    </ul>
	
</dd>
</dl>
</div>
</div>
</div>
</div>
<!--/基础信息-->
 

<script type="text/javascript">

    //自定义列--单位详细信息
 	function datagridProcessFormater(val, row, index) { // 自定义操作生成
	  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">详细信息</a>&nbsp;&nbsp;';
    }
    //单个视频单位详细信息展示
 	function doEdit(linkObject, index) {
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		var queryUrl = contextPath+"/spjsdw/getDepartmentInfoByDwId?dwbm="+rowData.dwbm;
		//alert(queryUrl);
		
		$.getJSON(queryUrl,function(rowObject){
			//alert(rowObject.dwmc);
			for(var attr in rowObject){
				//alert(attr+","+rowObject[attr]);
				$('#'+attr).html(rowObject[attr]);
				
			}
			$('#dwDetail').dialog('open');
		})
		
		//parent.document.getElementById("mainAreaId").src = editUrl;
	}
	///////////////////
 //根据选择的部门(大部门/小部门)
	function searchJsdw(){
	
		var condition = document.getElementById("orgcode1").value;
		if(condition==null || condition=='undefined'){
			condition="";
		}
		//alert("选择的部门id"+condition);
		var reloadUrl  = contextPath + '/spjsdw/queryListByBmid';
		var opt = $('#dg').datagrid('options');
		opt.url = reloadUrl;
		
		condition= $.trim(condition);
		
		$('#dg').datagrid('reload',{bmid:condition});//重新装载
		$('#dg').datagrid("clearSelections");
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
	
	</script>
<script language="JavaScript">

	function onOrgSelected(orgCodeInputID) {
		//alert(orgCodeInputID);
	}
	
	$(document).ready(function() { // 初始化部门名称
		public_getOrgName('orgcode', 'orgname');
	});

</script>	
  </body>
</html>