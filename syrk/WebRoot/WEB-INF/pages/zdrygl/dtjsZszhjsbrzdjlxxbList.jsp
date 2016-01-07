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
				$('#zszhjsbrzdjlxxbAdd').hide();
			}
		});
		
		function getQueryParams(){
			return {zdryZjhm:window.parent.getZdryzjhm()};
		}
		
		function zszhjsbrzdjlxxbedit(linkObject, index){

			cancelBubble();
			var rows = $('#zszhjsbrzdjlxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsZszhjsbrzdjlxxb?id='+rowData.id +"&type=edit";
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '肇事肇祸精神病诊断记录编辑',url: url,width: 780,inline:true,height:400}, 
				   		null, "zszhjsbrzdjlxxbquery",null
				   	);
			
		}
		function zszhjsbrzdjlxxbview(linkObject, index){

			cancelBubble();
			var rows = $('#zszhjsbrzdjlxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsZszhjsbrzdjlxxb?id='+rowData.id +"&type=view";

			openWindow(false,null,url,null,{title:'肇事肇祸精神病诊断记录查看',width:880,height:500});

			
		}

		function zszhjsbrzdjlxxbDelete(linkObject, index){
			cancelBubble(); // 阻止冒泡，不然要执行onClickRow
			var deleteUrl = contextPath + '/dtjsMore/deleteDtjsZszhjsbrzdjlxxb';
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
						zszhjsbrzdjlxxbquery();
					});
				}
			});
		}
		
		function zszhjsbrzdjlxxbquery(){
			$('#zszhjsbrzdjlxxbtable').datagrid('load',{    
				
				'zdryZjhm':window.parent.getZdryzjhm()
			});
		}
		
		function zszhjsbrzdjlxxbFormater(val,row,index){
			 var html="";
			 if(row.xt_lrrbmid== window.parent.getUserOrgCode() && window.parent.getPageEditAble()){
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrzdjlxxbedit(this, '+index+')">编辑</a>&nbsp;'
				 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrzdjlxxbDelete(this, '+index+')">删除</a>&nbsp;'	 
			 }else{		 
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrzdjlxxbview(this, '+index+')">查看</a>&nbsp;'
			 }	
			return html ;
		}
		function zszhjsbrzdjlxxbAdd() {
			var url=contextPath+'/dtjsMore/addDtjsZszhjsbrzdjlxxb?zdryZjhm='+window.parent.getZdryzjhm()+'&zdryid='+window.parent.getZdryid();
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '肇事肇祸精神病诊断记录新增',url: url,width: 800,inline:true,height:400}, 
				   		null, "zszhjsbrzdjlxxbquery",null);
			
			
		}
	</script>
</head>
<body >
		<div id="toolbar">
			<a id="zszhjsbrzdjlxxbAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="zszhjsbrzdjlxxbAdd();">新增</a>
	    </div>
	
	<table id="zszhjsbrzdjlxxbtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsZszhjsbrzdjlxxb',
           			queryParams:getQueryParams(),
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		toolbar:'#toolbar',
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			        	<th data-options="field:'zdryzjhm',width:120,align:'left',halign:'center'">证件号码</th>
			            <th data-options="field:'zdsj',width:120,align:'left',halign:'center',sortable:false">诊断时间</th>
			            <th data-options="field:'qzjg',width:140,align:'left',halign:'center'">诊断结果</th>
			            <th data-options="field:'qzdw',width:120,align:'left',halign:'center'">诊断单位</th>
			            <th data-options="field:'qzyy',width:120,align:'left',halign:'center'">确诊医院</th>
			            <th data-options="field:'qzys',width:150,align:'left',halign:'center'">确诊医师</th>
			            <th data-options="field:'qzyslxdh',width:150,align:'left',halign:'center'">确诊医师联系电话</th>
			            <th data-options="field:'jdr',width:150,align:'left',halign:'center'">鉴定人</th>
			           	 <th data-options="field:'jdrlxdh',width:150,align:'left',halign:'center'">鉴定人联系电话</th>			           
			            <th data-options="field:'zdgcms',width:150,align:'left',halign:'center'">诊断过程描述</th>	         
			            <th data-options="field:'process',width:100,align:'center',formatter:zszhjsbrzdjlxxbFormater">操作</th>
			        </tr>
			    </thead>
		   </table>
	
</body>
</html>