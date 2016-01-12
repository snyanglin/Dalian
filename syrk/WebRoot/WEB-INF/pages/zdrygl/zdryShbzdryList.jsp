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
    <title>涉环保重点人员管理</title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "";
    </script>
    <style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}
	
	</style>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'center',border:false" style="width:538px;">
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/shb/shbzdry/list',
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(335),
		        		pageList:[getAutoPageSize(335),
		        		getAutoPageSize(335) * 2],
		        		singleSelect:true,
		        		fitColumns:true,
						toolbar:'#datagridToolbar'">
			        <thead>
			          <tr>
				            <th data-options="field:'xm',width:70,align:'left',sortable:true,halign:'center'">姓名</th>
				            <th data-options="field:'zjhm',width:120,align:'left',sortable:true,halign:'center'">身份证号码</th>
				            <th  data-options="field:'dz_jzdzxz',align:'left',halign:'center',sortable:true">居住地址</th>
				            <th  data-options="field:'xt_lrrbm',width:120,align:'left',halign:'center',sortable:true">登记部门</th>
				            <th  data-options="field:'ssfxjdm',width:120,align:'left',halign:'center',sortable:true">现管理部门</th>
				            <th data-options="field:'process',align:'center',width:100,halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
			       </thead>
	       </table>
	       <div id="datagridToolbar" style="padding:5px;height:auto">
				<form id="queryForm">
				   <input type="hidden" id ="zbz" value="">
				    <input type="hidden" id ="type" value="">
				    <input type="hidden" id ="mapRadius" value="">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr class="dialogTr">
							    <td width="5%" class="dialogTd" align="right">姓名：</td>
						    	<td width="10%" class="dialogTd"><input type="text" name="xm" id ="xm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"   /></td>
								<td width="8%" class="dialogTd" align="right">公民身份证号码：</td>
						    	<td width="12%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:150px;"  data-options="required:false,validType:'maxLength[20]'" />
								</td>	
								<td width="5%" class="dialogTd" align="right">现居住地：</td>
						    	<td width="15%" class="dialogTd"><input type="text" name="dz_jzdzxz" id ="dz_jzdzxz" style="width:150px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"   /></td>

						       <td  width="45%"  class="dialogTd" align="left" colspan="4">
						                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton()">查询</a>
							            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
							             &nbsp;&nbsp;
							            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="addLg();">新增</a>						    
					           </td>
					</tr>					
				</table>
				</form>
			</div>
	        
	  </div>
	  
   </body>
</html>
<script type="text/javascript">
 function datagridProcessFormater(val,row,index){
	 var html="";
	 if(row.qx=="edit"){
		 html='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateAndXq(this, '+index+')">编辑</a>&nbsp;'
	 }else{
		 html='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="view(this, '+index+')">查看</a>&nbsp;' 
	 }
	return html ;
};

 function doUpdateAndXq(linkObject, index){
	// 阻止冒泡，不然要执行onClickRow
	debugger;
	cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	
	/* menu_open(rowData.xm + '', '/zdryzb/' + rowData.ryid + '/' + rowData.syrkid
			+ '/view' + '?mainTabID=' + getMainTabID()); */
    menu_open(rowData.xm +'','/shb/shbzdry/edit?zdryid='+rowData.id+"&type="+rowData.qx+"&mainTabID="+getMainTabID());
  //  menu_open('涉环保重点人员编辑','/syrkGl/add?mainTabID='+getMainTabID()+'&invokeJSMethod=SyrkGl.queryButton');
};


function view(linkObject, index){
	// 阻止冒泡，不然要执行onClickRow
	cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];

	/* menu_open(rowData.xm + '', '/zdryzb/' + rowData.ryid + '/' + rowData.syrkid
			+ '/view' + '?mainTabID=' + getMainTabID()); */
    menu_open(rowData.xm +'','/shb/shbzdry/edit?zdryid='+rowData.id+"&type="+rowData.qx+"&mainTabID="+getMainTabID());
  //  menu_open('涉环保重点人员编辑','/syrkGl/add?mainTabID='+getMainTabID()+'&invokeJSMethod=SyrkGl.queryButton');
};


//查询按钮
function queryButton(){
	
	var xm =$("#xm").val();
	var zjhm =$("#zjhm").val();
	var dz_jzdzxz =$("#dz_jzdzxz").val();
	$('#dg').datagrid(
			'load',
			{    
				'xm': xm,   
				'zjhm': zjhm ,
				'dz_jzdzxz':dz_jzdzxz
			});
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}

//新增
function addLg(){
	menu_open('涉环保重点人员登记', '/shb/shbAddPre');
}

</script>