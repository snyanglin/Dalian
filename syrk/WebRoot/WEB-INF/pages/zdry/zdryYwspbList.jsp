<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<title>重点人员业务审批</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'重点人员业务审批',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/zdryYwspb/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		fitColumns:true,
            		idField:'id',pageSize:getAutoPageSize(150),
            		pageList:[getAutoPageSize(150),getAutoPageSize(150) * 2]">
				    <thead>
				        <tr>
				        	<th data-options="field:'ywlx',width:140,align:'center',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/DL_D_YWZTDM.js'">审批类型</th>
				        	 <th data-options="field:'sqsj',width:400,align:'center',halign:'center',sortable:true">申请时间</th>
				        	<th data-options="field:'sqr_xm',width:180,align:'center',sortable:true,halign:'center'">申请人</th>
				            <th data-options="field:'sqyj',width:400,align:'center',halign:'center',sortable:true">申请意见</th>
				        	<th data-options="field:'spjg',width:100,align:'center',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_GG_SPJG.js'">审批结果</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:50px;width:100%" align="center">
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table border="0" cellpadding="0" cellspacing="10"
							style="width: 100%;" align="center">
							<tr class="dialogTr">
								<td width="10%" class="dialogTd" align="right">审批类型：</td>
								<td width="20%" class="dialogTd"><input
									class='easyui-combobox' type='text' id='ywlx'
									name='ywlx' style="width:200px;"
									data-options="url: contextPath + '/common/dict/DL_D_YWZTDM.js',valueField:'id',
									textField:'text',selectOnNavigation:false,required:false,method:'get',dataFilter:'1|2|5'"  />
								</td>
								<td width="10%" class="dialogTd" align="right">申请人：</td>
								<td width="20%" class="dialogTd"><input
									class='easyui-validatebox ' 
									type='text' id='sqr_xm' name='sqr_xm'
									 style="width:250px;" />
								</td>
								<td width="10%" class="dialogTd" align="right">审批状态：</td>
								<td width="20%" class="dialogTd">
								   <select class="easyui-combobox" name='sfsp' id="sfsp">
								   <option value='0'>未审批</option>
								   <option value='1'>已审批</option>
								    <option value='3'>全部</option>
								   </select>
								</td>
							</tr>
									<tr class="dialogTr">
								<td width="10%" class="dialogTd" align="right">审批结果 ：</td>
								<td width="20%" class="dialogTd"><input
									class='easyui-combobox' type='text' id='spjg'
									name='spjg' style="width:200px;"
									data-options="url: contextPath + '/common/dict/D_GG_SPJG.js',valueField:'id',
									textField:'text',selectOnNavigation:false,required:false,method:'get'" />
								</td>
								<td width="10%" class="dialogTd" align="right">审批日期：</td>
				    	<td width="60%" class="dialogTd" colspan="3">
				    	  <input type="text" name="sj" id="kssj" class="easyui-validatebox" style="width: 120px;" 
						 data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd ',maxDate:'%y-%M-%d'})"/>至
				    	  
				    	<input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width: 120px;"
						data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd ',maxDate:'%y-%M-%d '})"/>
				    	</td>
							</tr>
						</table>
							<div id="saveDiv"
									style="text-align:center; height:50px; padding-top: 10px;">
									<a id="saveBotton" class="l-btn l-btn-small"
										href="javascript:void(0)" group="" onclick="queryButton();"> <span
										class="l-btn-left l-btn-icon-left"> <span
											class="l-btn-text">查询</span> <span
											class="l-btn-icon icon-save"> </span> </span> </a>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="resetBotton"
										class="l-btn l-btn-small" href="javascript:void(0)" group="">
										<span class="l-btn-left l-btn-icon-left"> <span
											class="l-btn-text">重置</span> <span
											class="l-btn-icon icon-reset"> </span> </span> </a>
								</div>
					</form>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">
var windowID = null;
function doInit(paramArray) {
	windowID = paramArray['windowID'];
}

function processFormater(val, row, index) { // 自定义操作生成
	var hsButton='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHslg(this,'+index+',\'edit\')">审批</a>&nbsp;';
	if(row.spjg){
		hsButton='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHslg(this,'+index+',\'view\')">查看</a>&nbsp;'
	}
	
	return hsButton;
}


$("#resetBotton").click(function(){
	 $("#queryForm").form("reset");
		
});


//核实列管
function doHslg(linkObject, index,openType) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl ="";
	if(rowData.ywlx=="1"||rowData.ywlx=="2"){
		editUrl = contextPath+"/zdryLcg/creatLcgApporval?zdryYwspbId="+rowData.id+"&openType="+openType;
	}else{
		editUrl = contextPath+"/zdryZd/createZdjs?zdryLczywblbId="+rowData.ywbid+"&type=sjcj&openType="+openType;
	}
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	openTabPage('重点人员审批', editUrl,datagrid_ID)
}




//查询按钮
function queryButton() {
	$('#dg').datagrid('reload', {
		'ywlx' : $("#ywlx").val(),
		'sqr_xm' : $("#sqr_xm").val(),
		'sfsp':$("#sfsp").val(),
		'spjg':$("#spjg").val(),
		'kssj':$("#kssj").val(),
		'jssj':$("#jssj").val()
		
	});
}

function openTabPage(menuName, openURL,datagrid_ID) {
	openWindow(false,'', openURL, {document: document}, {title: menuName,    
	    width: 880,   
	    height: 420,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true})
	
}
function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}


</script>  

</html>

