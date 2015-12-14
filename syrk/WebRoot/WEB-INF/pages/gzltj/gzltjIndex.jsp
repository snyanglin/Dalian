<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	SessionBean userInfo = (SessionBean) session
			.getAttribute("userSession");
	String userOrgCode = "";
	String userOrgName = "";
	String userOrgLevel ="";
	
	String level1Name="";
	String level1Code="";

	String level2Name="";
	String level2Code="";

	String level3Name="";
	String level3Code="";

	String level4Name="";
	String level4Code="";

	if (userInfo != null) {
		userOrgCode = userInfo.getUserOrgCode();
		userOrgName = userInfo.getUserOrgName();
		userOrgLevel = userInfo.getUserOrgLevel();
		if("10".equals(userOrgLevel)||"20".equals(userOrgLevel)||"30".equals(userOrgLevel)||"40".equals(userOrgLevel)){
			level1Name=userInfo.getExtendValue("ssDsjName");
			level1Code=userInfo.getExtendValue("ssDsjCode");
		}else if("21".equals(userOrgLevel)||"31".equals(userOrgLevel)||"41".equals(userOrgLevel)){
			//市局
			level1Name=userInfo.getExtendValue("ssDsjName");
			level1Code=userInfo.getExtendValue("ssDsjCode");
			//分局
			level2Name=userInfo.getExtendValue("ssFsxName");
			level2Code=userInfo.getExtendValue("ssFsxCode");
		}else if("32".equals(userOrgLevel)||"42".equals(userOrgLevel)){
			//市局
			level1Name=userInfo.getExtendValue("ssDsjName");
			level1Code=userInfo.getExtendValue("ssDsjCode");
			//分局
			level2Name=userInfo.getExtendValue("ssFsxName");
			level2Code=userInfo.getExtendValue("ssFsxCode");
			//派出所
			level3Name=userInfo.getExtendValue("ssPcsName");
			level3Code=userInfo.getExtendValue("ssPcsCode");
		}
		else if("50".equals(userOrgLevel)){
			//市局
			level1Name=userInfo.getExtendValue("ssDsjName");
			level1Code=userInfo.getExtendValue("ssDsjCode");
			//分局
			level2Name=userInfo.getExtendValue("ssFsxName");
			level2Code=userInfo.getExtendValue("ssFsxCode");
			//派出所
			level3Name=userInfo.getExtendValue("ssPcsName");
			level3Code=userInfo.getExtendValue("ssPcsCode");
			//责任区
			level4Name=userOrgName;
			level4Code=userOrgCode;
		}
		
	}
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, -1);
	String beforeDay = sdf.format(cal.getTime());			
	
	
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作量统计首页</title>
<script type="text/javascript"
	src="<%=contextPath%>/js/gzltj/gzltjIndex.js"></script>
<script type="text/javascript">
	var userOrgCode = "<%=userOrgCode%>"; 
    var userOrgName = "<%=userOrgName%>";
    var userOrgLevel="<%=userOrgLevel%>";
    var queryCount=1;
    
    var level1Name= "<%=level1Name%>"; 
    var level1Code= "<%=level1Code%>"; 

    var level2Name= "<%=level2Name%>"; 
    var level2Code= "<%=level2Code%>"; 

    var level3Name= "<%=level3Name%>"; 
    var level3Code= "<%=level3Code%>"; 

    var level4Name= "<%=level4Name%>"; 
    var level4Code= "<%=level4Code%>"; 
   
</script>
</head>
<body >
	<div class="easyui-layout" data-options="fit:true,border:false">
	<div id="testabc" data-options="region:'center', split:true,title:'工作量统计列表'" style="width:500px; border-width: 0px;">
					<!-- 表格工具条按钮 -->
					<table id="gzltj_index_infoList"></table>
				    <div id="datagridToolbar" style="padding:5px;height:auto">
					<table cellspacing="0" cellpadding="0" border="0">
				<tr>
				                <td id="gzltj_indexDh" class="" align="left"  ></td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">开始时间：</td>
								<td class="toolbarTd">
									<input class="easyui-validatebox" type="text" id="gzltj_index_kssj" name="gzltj_index_kssj" value="<%= beforeDay %>" style="width:200px;" 
   	 			                data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>	
								</td>
								<td class="toolbarTd" align="right">结束时间：</td>
								<td class="toolbarTd">
									<input class="easyui-validatebox" type="text" id="gzltj_index_jssj" name="gzltj_index_jssj" value="<%= beforeDay %>" style="width:200px;" 
   	 			                data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
								</td>
								<td class="">
							    	<button style="height:23px;width:50px" iconCls="icon-query" plain="true" onclick="query()">查 询</button>
								</td>
								<td>&nbsp;&nbsp;</td>
								<td class="">
							    	<button style="height:23px;width:80px" onclick="gzltj_index_toExcel()">导出Excel</button>
								</td>
							</tr>
					</table>
				</div>
				</div>
				
				
			</div>
		
</body>
</html>
