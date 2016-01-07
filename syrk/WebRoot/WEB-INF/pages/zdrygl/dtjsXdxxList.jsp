<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		$(function(){
			if(!window.parent.getPageEditAble()){
				$('#sdxdxxbAdd').hide();
			}
		});
		
		function getQueryParams(){
			return {zdryZjhm:window.parent.getZdryzjhm()};
		}
		
		function sdxdxxbedit(linkObject, index){
			cancelBubble();
			var rows = $('#sdxdxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsSdxdxxb?id='+rowData.id +"&type=edit";
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '吸毒信息编辑',url: url,width: 780,inline:true,height:400}, 
				   		null, "sdxdxxbquery",null
				   	);
		}
		function sdxdxxbview(linkObject, index){

			cancelBubble();
			var rows = $('#sdxdxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsSdxdxxb?id='+rowData.id +"&type=view";

			openWindow(false,null,url,null,{title:'吸毒信息查看',width:880,height:500});
		}

		function sdxdxxbDelete(linkObject, index){
			cancelBubble(); // 阻止冒泡，不然要执行onClickRow
			var deleteUrl = contextPath + '/dtjsMore/deleteDtjsSdxdxxb';
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
						sdxdxxbquery();
					});
				}
			});
		}
		
		function sdxdxxbquery(){
			$('#sdxdxxbtable').datagrid('load',{    
				'zdryZjhm':window.parent.getZdryzjhm()
			});
		}
		
		function sdxdxxbFormater(val,row,index){
			 var html="";
			 if(row.xt_lrrbmid== window.parent.getUserOrgCode() && window.parent.getPageEditAble()){
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="sdxdxxbedit(this, '+index+')">编辑</a>&nbsp;'
				 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="sdxdxxbDelete(this, '+index+')">删除</a>&nbsp;'	 
			 }else{		 
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="sdxdxxbview(this, '+index+')">查看</a>&nbsp;'
			 }	
			return html ;
		}
		function sdxdxxbAdd() {
			var url=contextPath+'/dtjsMore/addDtjsSdxdxxb?zdryZjhm='+window.parent.getZdryzjhm()+'&zdryid='+window.parent.getZdryid();
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '吸毒信息新增',url: url,width: 800,inline:true,height:400}, 
				   		null, "sdxdxxbquery",null);
			
			
		}
	</script>
</head>
<body >
		<div id="toolbar">
			<a id="sdxdxxbAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="sdxdxxbAdd();">新增</a>
		</div>
	
	<table id="sdxdxxbtable" class="easyui-datagrid" 
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsSdxdxxb',
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
			        	<th data-options="field:'zdryzjhm',width:80,align:'left',halign:'center'">证件号码</th>
			            <th data-options="field:'dpzl',width:80,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/JD_D_DPZLDM.js'">毒品种类</th>
			            <th data-options="field:'dply',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/JD_D_DPLYDM.js'">毒品来源</th>
			            <th data-options="field:'dzly',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/JD_D_DZLYDM.js'">毒资来源</th>
			            <th data-options="field:'xscs',width:80,align:'left',halign:'center'">吸食次数</th>
			            <th data-options="field:'whhg',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_WHHG.js'">危害后果</th>
			            <th data-options="field:'sffx',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFDM.js'">是否复吸</th>
			            <th data-options="field:'ryxz',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_XDRYXZDM.js'">人员现状</th>
			            <th data-options="field:'process',width:80,align:'center',formatter:sdxdxxbFormater">操作</th>
			        </tr>
			    </thead>
		   </table>
	
</body>
</html>