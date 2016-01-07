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
				$('#zszhjsbrZszhjlxxbAdd').hide();
			}
		});
		
		function getQueryParams(){
			return {zdryZjhm:window.parent.getZdryzjhm()};
		}
		
		function zszhjsbrZszhjlxxbedit(linkObject, index){

			cancelBubble();
			var rows = $('#zszhjsbrZszhjlxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsZszhjsbrZszhjlxxb?id='+rowData.id +"&type=edit";
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '肇事肇祸精神病肇事肇祸记录编辑',url: url,width: 810,inline:true,height:400}, 
				   		null, "zszhjsbrZszhjlxxbquery",null
				   	);
			
		}
		function zszhjsbrZszhjlxxbview(linkObject, index){

			cancelBubble();
			var rows = $('#zszhjsbrZszhjlxxbtable').datagrid('getData');
			var rowData = rows.rows[index];
			var url=contextPath+'/dtjsMore/editDtjsZszhjsbrZszhjlxxb?id='+rowData.id +"&type=view";

			openWindow(false,null,url,null,{title:'肇事肇祸精神病肇事肇祸记录查看',width:880,height:500});

			
		}

		function zszhjsbrZszhjlxxbDelete(linkObject, index){
			cancelBubble(); // 阻止冒泡，不然要执行onClickRow
			var deleteUrl = contextPath + '/dtjsMore/deleteDtjsZszhjsbrZszhjlxxb';
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
						zszhjsbrZszhjlxxbquery();
					});
				}
			});
		}
		
		function zszhjsbrZszhjlxxbquery(){
			$('#zszhjsbrZszhjlxxbtable').datagrid('load',{    
				
				'zdryZjhm':window.parent.getZdryzjhm()
			});
		}
		
		function zszhjsbrZszhjlxxbFormater(val,row,index){
			 var html="";
			 if(row.xt_lrrbmid== window.parent.getUserOrgCode() && window.parent.getPageEditAble()){
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrZszhjlxxbedit(this, '+index+')">编辑</a>&nbsp;'
				 +'&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrZszhjlxxbDelete(this, '+index+')">删除</a>&nbsp;'	 
			 }else{		 
				 html='&nbsp;<a class="link" href="javascript:void(0)" onclick="zszhjsbrZszhjlxxbview(this, '+index+')">查看</a>&nbsp;'
			 }	
			return html ;
		}
		function zszhjsbrZszhjlxxbAdd() {
			var url=contextPath+'/dtjsMore/addDtjsZszhjsbrZszhjlxxb?zdryZjhm='+window.parent.getZdryzjhm()+'&zdryid='+window.parent.getZdryid();
			window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
					{title: '肇事肇祸精神病肇事肇祸记录新增',url: url,width: 900,inline:true,height:600}, 
				   		null, "zszhjsbrZszhjlxxbquery",null);
			
			
		}
	</script>
</head>
<body >
		<div id="toolbar">
			<a id="zszhjsbrZszhjlxxbAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="zszhjsbrZszhjlxxbAdd();">新增</a>
	   	</div>
	
	<table id="zszhjsbrZszhjlxxbtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsZszhjsbrZszhjlxxb',
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
			            <th data-options="field:'zszhlb',width:120,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_JSBZSZHLBDM.js'">肇事肇祸类别</th>
			            <th data-options="field:'sfsj',width:150,align:'left',halign:'center'">事发时间</th>
			            <th data-options="field:'sfdd',width:150,align:'left',halign:'center'">事发地点</th>	  
			            <th data-options="field:'cljg',width:140,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_JSBZSCLJG.js'">处理结果</th>
			            <th data-options="field:'jdjg',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_JSBZSJDJG.js'">鉴定结果</th>
                        <th data-options="field:'jdr',width:150,align:'left',halign:'center'">鉴定人</th>
			            <th data-options="field:'bamj',width:150,align:'left',halign:'center'">办案民警</th>	
			            <th data-options="field:'ssgajgmc',width:150,align:'left',halign:'center'">所属公安机关</th>	
			            
			            <th data-options="field:'process',width:100,align:'center',formatter:zszhjsbrZszhjlxxbFormater">操作</th>
			        </tr>
			    </thead>
		   </table>
	
</body>
</html>