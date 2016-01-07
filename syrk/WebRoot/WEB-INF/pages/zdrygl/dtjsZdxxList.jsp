<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制毒信息</title>
	<script type="text/javascript">
		$(function(){
			if(!window.parent.getPageEditAble()){
				$('#sdzdxxbAdd').hide();
			}
		});
		
		function sdzdxxbFormater(val,row,index){
			 var html="";
			 if(row.xt_lrrbmid==window.parent.getUserOrgCode() && window.parent.getPageEditAble()){
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="sdzdxxbedit(this, '+index+')">编辑</a>&nbsp;'
				 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="sdzdxxbDelete(this, '+index+')">删除</a>&nbsp;'	 
			 }else{		 
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="sdzdxxbview(this, '+index+')">查看</a>&nbsp;'
			 }	
			return html ;
		}
		
		function sdzdxxbAdd() {
			var url=contextPath+'/dtjsMore/addDtjsSdzdxxb?zdryZjhm='+window.parent.getZdryzjhm()+'&zdryid='+window.parent.getZdryid();
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '制毒信息新增',url: url,width: 800,inline:true,height:400}, 
				   		null, "sdzdxxbquery",null);
		}

		function sdzdxxbedit(linkObject, index){
			cancelBubble();
			var rows = $('#sdzdxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsSdzdxxb?id='+rowData.id +"&type=edit";
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '制毒信息编辑',url: url,width: 780,inline:true,height:400}, 
				   		null, "sdzdxxbquery",null
				   	);
		}
		
		function sdzdxxbview(linkObject, index){
			cancelBubble();
			var rows = $('#sdzdxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsSdzdxxb?id='+rowData.id +"&type=view";
			openWindow(false,null,url,null,{title:'制毒信息查看',width:880,height:500});
		}

		function sdzdxxbDelete(linkObject, index){
			cancelBubble(); // 阻止冒泡，不然要执行onClickRow
			var deleteUrl = contextPath + '/dtjsMore/deleteDtjsSdzdxxb';
			var datagrid_ID = getDatagrid_ID(0, linkObject);
			topMessager.confirm('','您确认要删除数据吗？',function(r) {    
				if (r) {	
					var opts = $('#' + datagrid_ID).datagrid("options");
					var rows = $('#' + datagrid_ID).datagrid('getData');
					var rowData = rows.rows[index];
					$.ajax({
						url: deleteUrl,
						type: 'POST',
						data: {id:rowData.id}
					}).done(function(result) {
						sdzdxxbquery();
					});
				}
			});
		}
		
		function sdzdxxbquery(){
			$('#sdzdxxbtable').datagrid('load',{    
				zdryZjhm:window.parent.getZdryzjhm()
			});
		}
		
		function getQueryParams(){
			return {zdryZjhm:window.parent.getZdryzjhm()};
		}
	</script>
</head>
<body >
		<div id="toolbar">
			<a id="sdzdxxbAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="sdzdxxbAdd();">新增</a>
		</div>
	
	<table id="sdzdxxbtable" class="easyui-datagrid"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsSdzdxxb',
           			queryParams:getQueryParams(),
           			toolbar:'#toolbar',
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			        	<th data-options="field:'zdryzjhm',width:150,align:'left',halign:'center'">证件号码</th>
			            <th data-options="field:'dpzl',width:120,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/JD_D_DPZLDM.js'">制毒种类</th>
			            <th data-options="field:'zdhxp',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_ZDHXP.js'">制毒化学品</th>
			            <th data-options="field:'dpqx',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_DPQX.js'">毒品去向</th>
			            <th data-options="field:'shdzqx',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_DZQX.js'">毒资去向</th>
			            <th data-options="field:'fmdd',width:120,align:'left',halign:'center'">贩卖地点</th>
			            <th data-options="field:'process',width:120,align:'center',align:'center',formatter:sdzdxxbFormater">操作</th>
			        </tr>
			    </thead>
		   </table>
	
</body>
</html>