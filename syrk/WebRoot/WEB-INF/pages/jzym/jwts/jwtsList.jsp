<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>警务态势</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
				<div id="datagridToolbar" style="padding:0px;height:auto">
				<form id="queryForm">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
				        <tr class="dialogTr">
				        <!-- 210200000000 -->
						<td width="20%" class="dialogTd" align="right">警力类型：</td>
						<td width="30%" class="dialogTd"><input id="lx1" class="easyui-combobox" value=""
							         data-options="valueField: 'id',textField: 'text',width:130,
							         url: '<%=basePath %>showzzjgsevlet?type=13',
						         onSelect: function(rec){var url = '<%=basePath %>showzzjgsevlet?type=12&id='+rec.id;$('#lx2').combobox('reload', url);}"/>
							       
			            </td>
			            </tr>
			            
			        <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">所属分局：</td>
						<td width="30%" class="dialogTd">
							<input id="lx2" class="easyui-combobox"
							data-options="valueField:'id', width:130, textField:'text',onSelect: function(rec1){var url = '<%=basePath %>showzzjgsevlet?type=12&id='+rec1.id;$('#lx3').combobox('reload',url);}" />
						</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">所属单位：</td>
							<td width="30%" class="dialogTd" colspan="3">
								<input id="lx3" class="easyui-combobox"
							data-options="valueField:'id', width:130, textField:'text'" />
							</td>
						</tr>      
			            
			            
			            
			          
					<tr class="dialogTr">
						<td class="dialogTd" align="center" colspan="4">
								<hr>
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 	iconCls="icon-reset" onclick="resetButton()">重置</a>
								 &nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="GPSqueryButton()">查询</a>
					</td>
				</tr>					
				</table>
				</form>
				</div>
			</div>
        </div>
    </div>   
    
    <input type="hidden" id ="zbz" value="">
    <input type="hidden" id ="type" value="">
    <input type="hidden" id ="mapRadius" value="">


</body>
<script type="text/javascript">


//查询按钮
function GPSqueryButton(){

		// 新增查询条件 beign
		var lx1 = $("#lx1").val(); //   类型
		var lx2 = $("#lx2").val(); //
		var lx3 = $("#lx3").val(); //
		// 新增查询条件 end
		var parm = "?lx1=" + lx1 + "&lx2=" +  lx2+ "&lx3=" +  lx3;
		 window.parent.zdParm(parm, "jwts");

}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
	
}
-->
</script>  

</html>