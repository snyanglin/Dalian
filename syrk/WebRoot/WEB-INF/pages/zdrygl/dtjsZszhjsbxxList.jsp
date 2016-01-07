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
				$('#zszhjsbrxxbAdd').hide();
			}
		});
		
		function getQueryParams(){
			return {zdryZjhm:window.parent.getZdryzjhm()};
		}
		
		function zszhjsbrxxbedit(linkObject, index){

			cancelBubble();
			var rows = $('#zszhjsbrxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsZszhjsbrxxb?id='+rowData.id +"&type=edit";
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '肇事肇祸精神病信息编辑',url: url,width: 780,inline:true,height:400}, 
				   		null, "zszhjsbrxxbquery",null
				   	);
			
		}
		function zszhjsbrxxbview(linkObject, index){

			cancelBubble();
			var rows = $('#zszhjsbrxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsZszhjsbrxxb?id='+rowData.id +"&type=view";

			openWindow(false,null,url,null,{title:'肇事肇祸精神病信息查看',width:880,height:500});

			
		}

		function zszhjsbrxxbDelete(linkObject, index){
			cancelBubble(); // 阻止冒泡，不然要执行onClickRow
			var deleteUrl = contextPath + '/dtjsMore/deleteDtjsZszhjsbrxxb';
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
						zszhjsbrxxbquery();
					});
				}
			});
		}
		
		function zszhjsbrxxbquery(){
			$('#zszhjsbrxxbtable').datagrid('load',{    
				
				'zdryZjhm':window.parent.getZdryzjhm()
			});
		}
		
		function zszhjsbrxxbFormater(val,row,index){
			 var html="";
			 if(row.xt_lrrbmid== window.parent.getUserOrgCode() && window.parent.getPageEditAble()){
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrxxbedit(this, '+index+')">编辑</a>&nbsp;'
				 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrxxbDelete(this, '+index+')">删除</a>&nbsp;'	 
			 }else{		 
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrxxbview(this, '+index+')">查看</a>&nbsp;'
			 }	
			return html ;
		}
		function zszhjsbrxxbAdd() {
			var url=contextPath+'/dtjsMore/addDtjsZszhjsbrxxb?zdryZjhm='+window.parent.getZdryzjhm()+'&zdryid='+window.parent.getZdryid();
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '肇事肇祸精神病信息新增',url: url,width: 800,inline:true,height:400}, 
				   		null, "zszhjsbrxxbquery",null);
			
			
		}
	</script>
</head>
<body >
		<div id="toolbar">
			<a id="zszhjsbrxxbAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="zszhjsbrxxbAdd();">新增</a>
	    </div>
	
	<table id="zszhjsbrxxbtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsZszhjsbrxxb',
           			queryParams:getQueryParams(),
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		toolbar:'#toolbar',
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			        	<th data-options="field:'zdryzjhm',width:120,align:'left',halign:'center'">证件号码</th>
			            <th data-options="field:'sslb',width:120,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBZDRYLBDM.js'">所属类别</th>
			            <th data-options="field:'brlb',width:140,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_JSBRLBDM.js'">病人类别</th>
			            <th data-options="field:'xszk',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_JSBXSZTDM.js'">现实状况</th>
			            <th data-options="field:'bqms',width:150,align:'left',halign:'center'">病情描述</th>
			            <th data-options="field:'zyby',width:150,align:'left',halign:'center'">主要病因</th>	         
			            <th data-options="field:'process',width:100,align:'center',formatter:zszhjsbrxxbFormater">操作</th>
			        </tr>
			    </thead>
		   </table>
	
</body>
</html>