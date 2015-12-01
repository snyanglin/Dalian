<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String orglevel ="";
    String fxjdm ="";
    String orgBizType="";
    Boolean panduan=true;
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        orglevel =userInfo.getUserOrgLevel();
        if("31".equals(orglevel)){// 分局
        	fxjdm =userInfo.getExtendValue("ssFsxCode");
        	panduan=true;
        }else if("30".equals(orglevel)){// 市局
        	panduan=true;
        }else{
        	fxjdm =userInfo.getExtendValue("ssFsxCode");
        	panduan=false;
        }
        orgBizType=userInfo.getUserOrgBiztype();
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>居住证办理</title>
  </head>
  <object id="ActiveX_print" width="0" height="0" classid="clsid:A55994D7-DCD1-45A2-B108-24DF72773B17">
</object>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'居住证办理',border:false" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>jzzblxxb/list',
			            method:'POST',
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'xt_zhxgsj',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(105),
		        		pageList:[getAutoPageSize(105),
		        		getAutoPageSize(105) * 2],
		        		singleSelect:false,
		        		fitColumns:true,
						toolbar:'#datagridToolbar'
			            	">
							    <thead>
							        <tr>
							           <th data-options="checkbox:true,align:'center',halign:'center'"></th>
							            <th data-options="field:'jzz_blztdm',width:10,align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_JZZBLZTDM.js'">办理状态</th>
							            <th data-options="field:'bl_fjmc', 	width:15,	align:'center',	halign:'center',sortable:true">办理分局</th>
							            <th data-options="field:'bl_pcsmc', width:15,	align:'left',	halign:'center',sortable:true">办理派出所</th>
							           	<th data-options="field:'bl_zrqmc',width:15,align:'left',	halign:'center'	,sortable:true">办理责任区</th>
							           	<th data-options="field:'jzzblrq',width:15,align:'center',	halign:'center'	,sortable:true">办理日期</th>
							           	<th data-options="field:'jzz_qfrq',width:15,align:'center',	halign:'center'	,sortable:true">签发日期</th>
							           	<th data-options="field:'jzz_yxqdm',width:15,align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_JZZYXQDM.js'">有效期</th>
							           	<th data-options="field:'jzz_lqfsdm',width:15,align:'center',	halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_JZZLQFSDM.js'">领取方式</th>
							           <th data-options="field:'dy_bh',width:15,align:'center',	halign:'center'	,sortable:true">居住证打印编号</th>
							           	<th data-options="field:'jzz_bh',width:15,align:'center',	halign:'center'	,sortable:true">居住证编号</th>
							           	<th data-options="field:'zjhm',width:15,align:'center',	halign:'center'	,sortable:true">居住人员证件号码</th>
							           	<th data-options="field:'xm',width:15,align:'center',	halign:'center'	,sortable:true">居住人员姓名</th>
							            <th data-options="field:'process',	 width:10,align:'center',halign:'center',	formatter:datagridProcessFormater">操作</th>
							        </tr>
							    </thead>
							</table>
					<div id="datagridToolbar" style="padding:5px;height:70px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1000">
							<tbody>
								<tr>    
								    <td class="toolbarTd" style="width:250px" align="right">
										办理分局：<input type="text" name="orgList21" id="orgList21"  class="easyui-combobox" style="width:160px;" 
													data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',equired:true,method:'get',
														valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList21_onChange">
									</td>
									<td class="toolbarTd" style="width:250px" align="right">
										办理派出所：<input type="text" name="orgList22" id="orgList22"  class="easyui-combobox" style="width:130px;" 
											data-options="method:'get',
												valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList22_onChange">
									</td>
									
									<td class="toolbarTd" style="width:250px" align="right">
										    办理责任区：<input type="text" name="orgList23" id="orgList23"  class="easyui-combobox" style="width:160px;" 
											data-options="method:'get',
												valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
									</td>
									<td class="toolbarTd" style="width:250px" align="right">
										办理状态：<input class="easyui-combobox" type="text" id="jzz_blztdm" name="jzz_blztdm" style="width:160px;"  
										data-options="url: contextPath + '/common/dict/BD_D_JZZBLZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'" />
									</td>
								</tr>
								
								<tr>
								    <td class="toolbarTd" style="width:250px" align="right">
										办理起始日期：<input type="text" name="jzzblrq" id ="jzzblrq" class="easyui-validatebox" data-options="required:false" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',maxDate:'%y-%M-%d'})" 
										style="width:160px"  />
									</td>
									
									<td class="toolbarTd" style="width:250px" align="right">
										办理结束日期：<input type="text" name="jzzblrq" id ="jzzbljsrq" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'#F{$dp.$D(\'jzzblrq\') || \'%y-%M-%d\'}'})"
										style="width:130px"  />
									</td>
									
									<td class="toolbarTd" style="width:250px" align="right">
										    有效期：<input class="easyui-combobox" type="text" id="jzz_yxqdm" name="jzz_yxqdm" style="width:160px;" 
					                               data-options="url: contextPath + '/common/dict/BD_D_JZZYXQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
									</td>
									<td class="toolbarTd" style="width:250px" align="right">
										领取方式：<input class="easyui-combobox" type="text" id="jzz_lqfsdm" name="jzz_lqfsdm" style="width:160px;"  
										data-options="url: contextPath + '/common/dict/BD_D_JZZLQFSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'" />
									</td>
								</tr>
								
								<tr>
									<td class="toolbarTd" style="width:250px" align="right">
										居住人员姓名：<input type="text" name="xm" id ="xm" class="easyui-validatebox"
										style="width:160px"  />
									</td>
									<td class="toolbarTd" style="width:250px" align="right">
										居住人员证件号码：<input type="text" name="zjhm" id ="zjhm" class="easyui-validatebox"
										style="width:130px"  />
									</td>
									<td class="toolbarTd" style="width:250px" align="right">
										注销标志：<input type="text" name="xt_zxbz" id="xt_zxbz"  class="easyui-combobox" style="width:160px;" 
													data-options="valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,
													onChange:changeZx,
													data:[{
														id:'0',
														text:'未注销',
														selected:true
													},{
													id:'1',
													text:'已注销'}]">
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:250px" align="right">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
										&nbsp;&nbsp;
									    <a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();">重置</a>
									</td>
									<td class="toolbarTd" style="width:250px" align="left">
									    &nbsp;&nbsp;
									    <a class="easyui-linkbutton" id = "buttonPiliang" iconCls="icon-add" onclick="piliangdayin();">批量打印</a>
									    &nbsp;&nbsp;
									     <a class="easyui-linkbutton" id="buttonQuanbu" iconCls="icon-add" onclick="resultdayin();">全部打印</a>
								    </td>
									<td class="toolbarTd" style="width:250px" align="left">
									    <a class="easyui-linkbutton" id = "buttonPiliang" iconCls="icon-excel" onclick="exportExcel();">导出Excel</a>
									  
								</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
	</div>
	</div>
	</div>
	
	
<script language="javascript">

function print_test(Name_str, Sex_str,mz_str, Id_str,hjdz_str, xjzdz_str, bh_str,Date_startend_str, Path_str)

{

ActiveX_print.print_test(Name_str, Sex_str,mz_str, Id_str,hjdz_str, xjzdz_str, bh_str,Date_startend_str, Path_str); 

}
function downLoad(){
	var rows =$('#dg').datagrid("getSelections");
	if(rows==""){
		alert("请选择需要导出的数据，可多选");
		return false;
	}
	var exportIds="";
	$.each(rows,function(index,item){
		
		if(exportIds==""){
			exportIds=item.id;
		}else{
			exportIds=exportIds+","+item.id;
		}
	});
	console.log(exportIds);
	location.href=contextPath+'/jzzblxxb/jzzbl_export?exportIds='+exportIds;
}
</script>	
<script type="text/javascript">

function changeZx(n,o){
	if(n == 0 || n == "0"){
		$('#buttonPiliang').show();
		$('#buttonQuanbu').show();
	}else{
		$('#buttonPiliang').hide();
		$('#buttonQuanbu').hide();
	}
}

//操作列
function datagridProcessFormater(val, row, index) { 
	// 自定义操作生成
	if(row.xt_zxbz == "1"){
		return "-";
	}
    return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">详情</a>&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="yulan(this,'+index+')">预览</a>';
}
var orglevel = "<%=orglevel%>";  
function clearCase(){
	  $("#queryForm").form("reset");
	  $("#xt_zxbz").combobox(
	  {
	  	data:[{id:'0',
			text:'未注销',
			selected:true
		},
		{
			id:'1',
			text:'已注销'}]
		});
	  if(orglevel !="30"){
	  		if(<%=orgBizType%>!="12"){
	  			$("#orgList21").combobox("setValue","<%=fxjdm%>");
	  		}
			setInputReadonly('orgList21', true);
	  }
}

//预览居住证
function yulan(linkObject, index){
	var datagrid_ID = "dg";
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = contextPath + '/jzzblxxb/jzzView'+"?id="+rowData.id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	try{
		ActiveX_print 
		}catch(e){
			alert("打印机调用异常，请联系系统管理员。");
			return false;
		}
	openWindowNoSave(false, null, this.Window, 
   		null, 
   		{
   		title: '居住证预览',
   		url: editUrl,
   		maximizable: false,
   		width: 440,
   		height: 390
   		}, 
   		'', null
   	);
  }

function onOrgSelected(orgCodeInputID) {
	alert(orgCodeInputID);
}

$(document).ready(function() { // 初始化部门名称
	if(orglevel !="30"){
		if(<%=orgBizType%>!="12"){
			$("#orgList21").combobox("setValue","<%=fxjdm%>");
		}
		
		setInputReadonly('orgList21', true);
	}
	//如果是内保的人办理居住证，查询条件不允许选择分县局、派出所、责任区
	if(<%=orgBizType%>=="12"){
		setInputReadonly("orgList21", true);
		setInputReadonly("orgList22", true);
		setInputReadonly("orgList23", true);


    }
	
	
	public_getOrgName('orgcode', 'orgname');
	orgList21_onChange(); // 三级级联选择例子初始化
	orgList22_onChange(); // 三级级联选择例子初始化
});

function orgList11_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList11').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList12').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#orgList12').combobox('reload', url);
	}
}

function orgList21_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList21').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList22').combobox('loadData', []);
		$('#orgList23').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#orgList22').combobox('reload', url);
	}
}

function orgList22_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList22').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList23').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=50&orgBizType=04&parentOrgCode=' + parentOrgCode;    
	    $('#orgList23').combobox('reload', url);
	}
}

var pan=<%=panduan%>
//查询按钮
function queryButton() {
	if(pan == true){
		var bl_fjdm = $("#orgList21").val();
		var bl_pcsdm = $("#orgList22").val();
		var bl_zrqdm = $("#orgList23").val();
		var jzzblrq = $("#jzzblrq").val();
		var jzz_blztdm = $("#jzz_blztdm").val();
		var jzzbljsrq = $("#jzzbljsrq").val();
		var jzz_yxqdm = $("#jzz_yxqdm").val();
		var jzz_lqfsdm = $("#jzz_lqfsdm").val();
		var xm = $("#xm").val();
		var zjhm=$("#zjhm").val();
		var xt_zxbz = $("#xt_zxbz").val();
		$('#dg').datagrid('reload', {
			'bl_fjdm' : bl_fjdm,
			'bl_pcsdm' : bl_pcsdm,
			'bl_zrqdm' : bl_zrqdm,
			'jzzblrq' : jzzblrq,
			'jzz_blztdm' : jzz_blztdm,
			'jzzbljsrq' : jzzbljsrq,
			'jzz_yxqdm' : jzz_yxqdm,
			'jzz_lqfsdm' : jzz_lqfsdm,
			'xm' : xm,
			'zjhm':zjhm,
			'xt_zxbz':xt_zxbz
		});
	}else{
		alert("无此功能权限！");
	}
	
}
//打印全部查询结果，取得所有id，ajax方式到后台查询
function resultdayin(){
	var bl_fjdm = $("#orgList21").val();
	var bl_pcsdm = $("#orgList22").val();
	var bl_zrqdm = $("#orgList23").val();
	var jzzblrq = $("#jzzblrq").val();
	var jzz_blztdm = $("#jzz_blztdm").val();
	var jzzbljsrq = $("#jzzbljsrq").val();
	var jzz_yxqdm = $("#jzz_yxqdm").val();
	var jzz_lqfsdm = $("#jzz_lqfsdm").val();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>jzzblxxb/getAllIds",
		dataType:"json",
		data:"bl_fjdm="+bl_fjdm+"&bl_pcsdm="+bl_pcsdm+"&bl_zrqdm="+bl_zrqdm+"&jzz_blztdm="+jzz_blztdm+"&jzzbljsrq="+jzzbljsrq+"&jzz_yxqdm="+jzz_yxqdm+"&jzz_lqfsdm="+jzz_lqfsdm+"&jzzblrq="+jzzblrq,
		async:false,
		success:function(data){
			var jzzList = eval(data)
			for(var i=0;i<jzzList.length;i++){
				var xb= window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', jzzList[i].xbdm);
				var mz= window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js', jzzList[i].mzdm);
				var url ="<%=basePath%>/zpfjPtryzp/queryPtryzpSingle.jpg?ryid="+jzzList[i].ryid+"&zjhm="+jzzList[i].zjhm+"&cyzjdm="+jzzList[i].cyzjdm;
				// 调用后台，改变状态和时间
				$.ajax({
				type:"POST",
				url:"<%= basePath%>jzzblxxb/piLiangDaYing",
				dataType:"json",
				data:"id="+jzzList[i].id,
				async:false,
				success:function(data){
					if(data && data != null && data != undefined ){
						data= eval("("+data+")");
						var Date_startend_str=data.jzz_qfrq+"至"+data.yxq_jzrq;
						data_refresh(data.xm, xb,mz, data.zjhm,data.hjd_dzxz, data.jzd_dzxz, data.dy_bh,Date_startend_str, url);
						print_test(data.xm, xb,mz, data.zjhm,data.hjd_dzxz, data.jzd_dzxz, data.dy_bh,Date_startend_str, url); 
					}
				},
				complete:function(){}
			});
				
			}
		},
		complete:function(){}
	});
	
}
function exportExcel(){

	var bl_fjdm = $("#orgList21").val();
	var bl_pcsdm = $("#orgList22").val();
	var bl_zrqdm = $("#orgList23").val();
	var jzzblrq = $("#jzzblrq").val();
	var jzzbljsrq = $("#jzzbljsrq").val();
	var jzz_yxqdm = $("#jzz_yxqdm").val();
	var xm = $("#xm").val();
	var zjhm=$("#zjhm").val();
	
	
	exportUrl =basePath+'jzzblxxb/export?bl_fjdm='+bl_fjdm+'&bl_pcsdm='+bl_pcsdm+'&bl_zrqdm='+bl_zrqdm+'&jzzblrq='+jzzblrq+'&jzzbljsrq='+jzzbljsrq+'&jzz_yxqdm='+jzz_yxqdm+'&xm='+xm+'&zjhm='+zjhm;
	location.href=exportUrl;
}
//批量打印
function piliangdayin(){
	var  getSelections = $("#dg").datagrid("getSelections");
	var len = getSelections.length;
	var idstr="";
	if(len>=1){
		for(var i=0;i<len;i++){
			idstr+=getSelections[i].id +",";
			var xb= window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', getSelections[i].xbdm);
			var mz= window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js', getSelections[i].mzdm);
			var url ="<%=basePath%>/zpfjPtryzp/queryPtryzpSingle.jpg?ryid="+getSelections[i].ryid+"&zjhm="+getSelections[i].zjhm+"&cyzjdm="+getSelections[i].cyzjdm;
			// 调用后台，改变状态和时间
			$.ajax({
			type:"POST",
			url:"<%= basePath%>jzzblxxb/piLiangDaYing",
			dataType:"json",
			data:"id="+getSelections[i].id,
			async:false,
			success:function(data){
				if(data && data != null && data != undefined ){
					data= eval("("+data+")");
					var Date_startend_str=data.jzz_qfrq+"至"+data.yxq_jzrq;
					data_refresh(data.xm, xb,mz, data.zjhm,data.hjd_dzxz, data.jzd_dzxz, data.dy_bh,Date_startend_str, url);
					print_test(data.xm, xb,mz, data.zjhm,data.hjd_dzxz, data.jzd_dzxz, data.dy_bh,Date_startend_str, url); 
				}
			},
			complete:function(){}
		});
			
		}
	}else{
		alert("请选择你要打印的居住证信息！");
	}
}

function data_refresh(Name_str, Sex_str,mz_str, Id_str,hjdz_str, xjzdz_str, bh_str,Date_startend_str, Path_str)
{
	try{
	ActiveX_print.data_refresh(Name_str, Sex_str,mz_str, Id_str,hjdz_str, xjzdz_str, bh_str,Date_startend_str, Path_str); 
	}catch(e){
		alert("打印机调用异常，请联系系统管理员。");
	}

}

function doEdit(linkObject, index){
	var datagrid_ID = "dg";
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = contextPath + '/jzzblxxb/edit'+"?id="+rowData.id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [3];
   	openWindowWithSave(false, null, this.Window, 
   		null, 
   		{
   		title: '居住证详细',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 560
   		}, 
   		'您是否保存?', null
   	);
  }

    </script>
  </body>
</html>
