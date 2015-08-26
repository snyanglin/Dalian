<!--  
	@Author:       [xu_haibo@founder.com.cn]
	@CreateDate:   [2015-7-6 下午13:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<script type="text/javascript">
function saveXfdwcccsxxb(){
	var nf = $("#nf").val();
	if(nf==""){
		topMessager.alert('', '年份必填项！');
		return false;
	}
	modifyXfdwcccsxxb("",nf);
};

function modifyXfdwcccsxxb(id,nf){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = basePath+"cyjh/edit?id="+id;
	openWindowWithSave(false, null, window, 
   		{nf:nf,zs:${entity.zddws+entity.ybdws+entity.jxcss+entity.qtdws },zddws:${entity.zddws },fzddws:${entity.ybdws+entity.jxcss+entity.qtdws }}, 
   		{
   		title: nf + '年度抽样参数配置',
   		url: editUrl,
   		width: 680,
   		height:300
   		}, 
   		null, null,null
   	);
};

//操作列 
function datagridProcessFormaterZS(val, row, index) { // 自定义操作生成
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	return  '总数<font color="red">'+rowData.zs+'</font>家,重点<font color="red">'+rowData.zddws+'</font>家,一般<font color="red">'+rowData.fzddws+'</font>家';
} 
//操作列 datagridProcessFormaterZS
function datagridProcessFormaterDelete(val, row, index) { // 自定义操作生成
	return  '<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(\''+row.id+'\')">删除</a>';
}
//操作列 
function datagridProcessFormaterCC(val, row, index) { // 自定义操作生成
	return  '<a class="link" href="javascript:javascript:void(0)" onclick="dwcyAdd(this, '+index+')">抽查</a>';
}
//操作列 
function datagridProcessFormaterCY(val, row, index) { // 自定义操作生成
	return  '<a class="link" href="javascript:javascript:void(0)" onclick="modifyXfdwcccsxxb(\''+row.id+'\','+row.nf+')">重设置</a>';
}

//删除单条
function doDelete(id) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/cyjh/deleteXfdwcccsxxb';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {    
		if (r) {	
			$.ajax({
				url: deleteUrl+"?id="+id,
				type: 'POST'
			}).done(function(result) {
				$("#nf").combobox("reload",contextPath + "/cyjh/querynf");
				doSubmitResult(result, null, "dg");
			});
		}
	});
}

function dwcyAdd(obj,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = contextPath + '/cyjh/todwcy?id='+rowData.id;
	//var rows = $('#dg').datagrid('getData');
	//var rowData = rows.rows[index];
	//datagridAdd(obj, 'viewWindow', {id:rowData.id}, {
	//	title : '大型活动非审批',
	//	url : editUrl,
	//	width : 850,
	//	height : 530
	//}, '您是否要保存数据？');
  	window.top.openWindow(false,'dwcywindow',contextPath + '/cyjh/todwcy?id='+rowData.id, {document: document}, {title: '抽样信息',    
    width: 850,   
    height: 530,  
	collapsible: false, 
	minimizable: false, 
	maximizable: false,
	closable: true,
    closed: false,    
    cache: false,
    inline: false,
	resizable: false, 
    modal: true});
}

</script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>抽样性监督检查量化标准</title>
		<style type="text/css">
			.title{
				font-size:12px;color: #0e2d5f;background:#eaf2ff;font-weight: bold;
			}
			.td-left-bottom{
				border-left:1px  #ccc dotted;
				border-bottom: 1px  #ccc solid;
			}
			.td-lb-dotted{
				border-left:1px  #ccc dotted;
				border-bottom: 1px  #ccc dotted;
			}
			.td-left{
				border-left:1px  #ccc dotted;
				border-bottom: 1px  #ccc solid;
			}
			.td-bottom{
				border-bottom: 1px  #ccc dotted;
			}
			.td-solid{
				border-left:1px  #ccc solid;
				border-top: 1px  #ccc solid;
				border-bottom: 1px  #ccc solid;
				border-right: 1px  #ccc solid;
			}
		</style>
	</head>
<body >   
	<table border="0" cellpadding="0" cellspacing="0" style="border-top: 1px  #95B8E7 solid;border-bottom: 1px  #95B8E7 solid;height:30px" width="100%">
		<tr>
			<td  class="title">
				&nbsp;抽样性监督检查量化标准
			</td>
		</tr>
	</table>
	<table  border="0" cellpadding="0" cellspacing="0" width="100%" align="center"   style="height: 90px" >
		<tr>
			<td  rowspan="3" bgcolor="#efefef"  align="right" class="td-solid">
				量化标准：
			</td>
			<td class="td-bottom">
				辖区内每年应抽查的单位总数（Q）=（<font color="red">${entity.zzxfjdjcrymzjcdws }</font>x专职监督检查人员数（M）+<font color="red">${entity.jzxfjdjcrymzjcdws }</font>x兼职监督检查人员数（N）)x<font color="red">${entity.mngzzs }</font>/<font color="red">${entity.mcssjcsjcrys }</font>
			</td>
		</tr>
		<tr>
			<td class="td-bottom">
				每年应抽查的重点单位数（D）=Qx重点单位数占抽查单位总数的百分比（<font color="red">注</font>：如果出现小数，则用四舍五入法则精确到整数位。）
			</td>
		</tr>
		<tr>
			<td class="td-bottom">
				非重点单位的全年抽样总数=辖区内每年应抽查的单位总数-重点单位数
			</td>
		</tr>
	</table>
	&nbsp;&nbsp;
	<table border="0" cellpadding="0" cellspacing="0" style="border-top: 1px  #95B8E7 solid;border-bottom: 1px  #95B8E7 solid;height:30px" width="100%">
		<tr>
			<td  class="title">
				&nbsp;辖区现已录入单位数
			</td>
		</tr>
	</table>
	<table border="0" width="100%" align="center"   cellpadding="0" cellspacing="0" style="height: 56px">
		<tr align="center" style="background:#efefef; ">
			<td class="td-left-bottom">
				重点单位
			</td>
			<td class="td-left-bottom">
				一般单位
			</td>
			<td class="td-left-bottom">
				九小场所
			</td>
			<td class="td-left-bottom">
				其他单位
			</td>
			<td class="td-left-bottom">
				总计
			</td>
		</tr>
		<tr  align="center">
			<td style="color: blue;" class="td-lb-dotted">${entity.zddws }
			</td>
			<td style="color: blue;" class="td-lb-dotted">${entity.ybdws }
			</td>
			<td style="color: blue;" class="td-lb-dotted">${entity.jxcss }
			</td>
			<td style="color: blue;" class="td-lb-dotted">${entity.qtdws }
			</td>
			<td style="color: blue;" class="td-lb-dotted">${entity.zddws+entity.ybdws+entity.jxcss+entity.qtdws }
			</td>
		</tr>
	</table>
	&nbsp;&nbsp;&nbsp;
	<table border="0" cellpadding="0" cellspacing="0" style="border-top: 1px  #95B8E7 solid;border-bottom: 1px  #95B8E7 solid;height:30px" width="100%">
		<tr>
			<td  class="title">&nbsp;年度抽样检查总计划列表
			</td>
		</tr>
	</table>
	<table id="datagridToolbar" cellspacing="0" cellpadding="0" border="0" width="100%">
		<tbody>
			<tr>
				<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
				<font color="red">*</font><input id="nf" name="nf" class="easyui-combobox" data-options="valueField: 'id',textField: 'text',width:120,method:'GET',isTopLoad:false,url: '<%=basePath%>cyjh/querynf'" />  
					年度抽样检查计划  &nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="saveXfdwcccsxxb();">生成</a>
				</td>
			</tr>
		</tbody>
	</table>
	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/cyjh/queryXfdwcccsxxbForPage',
         		toolbar:'#datagridToolbar',
         		singleSelect:true,selectOnCheck:true,
         		checkOnSelect:true,border:false,
         		sortName:'nf',sortOrder:'desc',
         		idField:'id',pageSize:getAutoPageSize(),
         		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
			    <thead>
			        <tr>
			        	<th data-options="field:'id',hidden:true"></th>
			        	<th data-options="field:'zs',hidden:true"></th>
			        	<th data-options="field:'zddws',hidden:true"></th>
			        	<th data-options="field:'fzddws',hidden:true"></th>
			        	<th data-options="field:'nf',width:150,align:'center',sortable:true,halign:'center'">年份</th>
						<th data-options="field:'zzjcrs',width:150,align:'center',sortable:true,halign:'center'">专职检查人员数</th>
						<th data-options="field:'jzjcrs',width:150,align:'center',sortable:true,halign:'center'">兼职检查人员数</th>
						<th data-options="field:'2',width:380,align:'center',sortable:true,halign:'center',formatter:datagridProcessFormaterZS">全年抽样总数估算</th>
			        	<th data-options="field:'3',width:150,align:'center',sortable:true,halign:'center',formatter:datagridProcessFormaterCY">抽样参数</th>
			        	<th data-options="field:'4',width:150,align:'center',sortable:true,halign:'center',formatter:datagridProcessFormaterCC">分次抽查</th>
			            <th data-options="field:'process',width:150,align:'center',halign:'center',formatter:datagridProcessFormaterDelete">删除</th>
			        </tr>
			    </thead>
	</table>
</body>  
</html>
