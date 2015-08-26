<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
    </script>
    <style type="text/css">
		.blueText{color:blue;font-weight:bold;cursor: pointer;font-size:14px;text-align: right;}
		.oneText{font-size:12px;background-color:#007be3;text-align:center;width:18px; height:18px;float:left;color:#fff;font-weight:bold;line-height:18px;}
		.textwrap{width:300px; margin:5px auto;height:auto;overflow:hidden;font-size:12px;}
		.title_big{width:100%; font-size:12px; color:#333333;line-height:18px;}
    </style>
    <script type="text/javascript" src="<%=contextPath%>/js/jcj/jcjManage.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'west',border:false" style="width:538px;">
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/jcj/list',
	              	    method:'POST',
						onLoadSuccess:function(data){jcjManage.loadPoint(data,'dg');},
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(105),
		        		pageList:[getAutoPageSize(105),
		        		getAutoPageSize(105) * 2],
		        		singleSelect:true,
		        		fitColumns:true,
						toolbar:'#datagridToolbar'">
			        <thead>
			          <tr>
			            <th data-options="field:'bj_sj',width:110,align:'center'">报警时间</th>
			            <th data-options="field:'jjlxdm',width:60,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_JCJ_JJLXDM.js'">接警类型</th>
			            <th data-options="field:'bjnr',width:190,align:'left',halign:'center'">警情摘要</th>
			            <th data-options="field:'jjbh',hidden:true">jjbh</th>
			            <th data-options="field:'xzqhdm',hidden:true">xzqhdm</th>
			            <th data-options="field:'id',hidden:true">id</th>
			            <th data-options="field:'cjdbh',hidden:true">cjdbh</th>
			            <th data-options="field:'orgseatno',hidden:true">orgseatno</th>
			          	<th data-options="field:'process',width:90,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
			          </tr>
			       </thead>
	       </table>
           <!-- 查询条件 -->
           <div id="datagridToolbar" style="padding:5px;height:auto;">
			    <form>
				<table cellspacing="0" cellpadding="0" border="0" >
					<tbody>
					  <tr class="dialogTr">
						<td align="right" >
							<input type="text" class="searchText" name="bjnr"  id="bjnr" 
									style="color:gray;height:32px;font-size:18px;width:240px;color: gray" onclick="setBjnr(this)" onkeydown="passwordOnkeyPress(this)"/>
						</td>
						<td align="left">
							<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px" onclick="queryButton();"/>
						</td>
						
						<td width="110px;">
							&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="detailSearch()">精确查询</a>
						</td>
						<td width="110px;">
							<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="jcjZjjAdd();">自接警登记</a>
						</td>
					</tr>
				  </tbody>
				</table>
			    </form>
           </div>
	  </div>
	  
	  
	  <div id="win" class="easyui-window" title="接处警精确查询" 
        data-options="iconCls:'icon-search',
		        collapsible:false,
		        minimizable:false,
		        maximizable:false,
		        modal:true,
		        closed:true,
		        top:100,
		        width:400,
        		height:280,
        		left:50" >   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
	        <form id ="queryForm" >
		        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
		        <tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">警情编号：</td>
				    	<td width="70%" class="dialogTd"><input type="text" name="jjbh" id="jjbh" class="easyui-validatebox" style="width:220px;" /></td>
			    	</tr>
			    	<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">警情来源：</td>
				    	<td width="70%" class="dialogTd"><input class="easyui-combobox" type="text" id="jjlxdm" name="jjlxdm" style="width:220px;"
							data-options="url: contextPath + '/common/dict/D_JCJ_JJLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
			    	</tr>	
			    	<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">报警时间：</td>
				    	<td width="70%" class="dialogTd">
				    	  <input type="text" name="jj_sj" id="jj_sj" class="easyui-validatebox" style="width: 101px;" 
						 data-options="required:false,validType:['date[\'yyyy-MM-dd HH:mm:ss\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %h:%m:%s'})"/>至
				    	  
				    	<input type="text" name="jj_sj1" id="jj_sj1" class="easyui-validatebox" style="width: 101px;"
						data-options="required:false,validType:['date[\'yyyy-MM-dd HH:mm:ss\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %h:%m:%s',minDate:'#F{$dp.$D(\'jj_sj\') || \'%y-%M-%d %h:%m:%s\'}'})"/>
				    	</td>
			    	</tr>	
			    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
				    	<td width="100%" colspan="2" align="right">
				    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton();">确定</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
				    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('win');">关闭</a>
				    	</td>
			    	</tr>
		         </table>
		        </form>
	        </div>   
	    </div>   
</div>
	  
	  
	  
	  <div data-options="region:'center',border:false">
	       <div id="mapDiv"></div>
	       <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
	  </div>
   </body>
<script type="text/javascript">
function setBjnr(obj){
	   obj.value="";
}
//按下enter
function passwordOnkeyPress(obj) {
		obj.style.color = "black";
	    var keycode = event.keyCode;
}
	
//精确查询
function detailSearch(){
	$("#win").window("open"); 
	$("#queryForm").form("reset");
}


//查询按钮
function queryButton(){
	var jjbh = document.getElementById("jjbh").value;
	var jjlxdm = document.getElementById("jjlxdm").value;
	var jj_sj = document.getElementById("jj_sj").value;
	var jj_sj1 = document.getElementById("jj_sj1").value;
	var bjnr = document.getElementById("bjnr").value;
	var sfdt =0;
	var reloadUrl  = contextPath + '/jcj/list';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$("#dg").datagrid(
	'load',
	{    
		'jjbh':jjbh,
		'jjlxdm': jjlxdm,   
		'jj_sj': jj_sj,
		'jj_sj1':jj_sj1,
		'bjnr':bjnr
	});
	$("#jjbh").val("");
	$("#jjlxdm").combobox('setValue','');
	$("#jj_sj").val("");
	$("#jj_sj1").val("");
	$("#jqlxdm").combobox('setValue','');
	$("#cljgdm").combobox('setValue','');
	$("#cjy_xm").val("");
	$("#bjnr").val("");
	
	
	
	
	closeWindow("win");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}

//关闭精确查询窗口
function closeWindow(obj){
	$("#"+obj).window("close"); 
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	  if(row.cjdbh !=''){
			  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">详情</a>&nbsp;'+
		         '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="fankui(this,'+index+')">反馈</a>';
	  }else{
		  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">详情</a>&nbsp;'+
		          '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="qianshou(this,'+index+')">签收</a>';
	   }
}

//修改单条
function doEdit(linkObject, index) {
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/jcj?id="+rowData.id+"&sfcx=0&mainTabID="+getMainTabID();
	menu_open("接处警－详情",editUrl);
}


//签收
function qianshou(linkObject, index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var rows = $('#' + datagrid_ID).datagrid("getData");
	var rowData = rows.rows[index];
	$.ajax({
		type:"POST",
		url:"<%=basePath%>jcj/saveCjxxb",
		dataType:"json",
		data:"jjbh="+rowData.jjbh+"&xzqhdm="+rowData.xzqhdm+"&orgseatno="+rowData.orgseatno,
		complete:function() {
			queryButton();
		},
		error:function() {
		}
	});	
}
//反馈
function fankui(linkObject, index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
    var rows = $('#' + datagrid_ID).datagrid("getData");
    var rowData = rows.rows[index];
	var editUrl = contextPath + '/jcj/addFkxxb?jjbh='+rowData.jjbh+"&xzqhdm="+rowData.xzqhdm+"&cjdbh="+rowData.cjdbh;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [3];
	paramArray[0] = rowData.jjbh;
	paramArray[1] = rowData.xzqhdm;
	paramArray[2] = rowData.cjdbh;
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '接处警反馈信息新增',
   		url: editUrl,
   		maximizable: false,
   		width: 880,
   		height: 620
   		}, 
   		'你是否要保存数据？', null
   	);
}
//自接警登记打开
function jcjZjjAdd(){
	menu_open('自接警登记', '/jcj/addZjjxxb');
}





</script>
</html>