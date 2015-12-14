<%@page import="com.founder.xjpt.controller.XjController"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.organization.role.bean.OrgRole"%>
<%@ page import="com.founder.framework.organization.right.service.OrgRightPublic"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    String id = "";
    String userid = "";
    String httpURI = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
        id = ""+userInfo.getUserOrgId();
        userid = userInfo.getUserId();
    }
    
    httpURI = new XjController().getURL();
    //httpURI = "http://10.80.5.228:9080/DLGA_XJPT_V2";
    
    //get role begin
    String role = "";
	List<OrgRole> list = new OrgRightPublic().queryUserAssignRole(userid);
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		OrgRole orgRole = (OrgRole) iterator.next();
		String roleName = orgRole.getRolename();
		if("巡警-支队管理员".equals(roleName)){
			role = roleName;
		} else if("巡警-分局管理员".equals(roleName)){
			role = roleName;
		} else if("巡警-派出所管理员".equals(roleName)){
			role = roleName;
		} else if("巡警-巡逻员".equals(roleName)){
			role = roleName;
		}
	}
	//System.out.println("rolanme: " + role);
	session.setAttribute("role", role);
	//get role end
 %>
 
 <script type="text/javascript">

   window.setInterval("refresh_auto();", 200000);


// 页面刷新－自动时间间隔
function refresh_auto() {
   //refresh_wfTask();
   refresh_message();
   //refresh_inform();
}

// 页面刷新－个人消息查看
function refresh_message() {
   var myDate = new Date();
   var myTime = myDate.getTime();
   var openURL = "<%=contextPath%>/sysMessage/xjsearchRemind?myTime=" + myTime;
   if (IE) {
      document.frames["message"].location.href = openURL;
   }
   else {
      document.getElementById("message").contentWindow.location.href = openURL;
   }
}

function queryMsg(bs){
  document.frames("message").more_click(bs);
}
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>社区警务主界面</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/homePage.css">
    <style type="text/css">
	.text1{width:100%; margin-left:10px;margin-right:10px; font-size:14px; color:#333; line-height:24px; text-indent:25px;}
	.text2{width:100%; text-align: center;}
	.bold{font-weight:bold;font-size:14px}
	.redText{color:#F00;font-weight:bold;font-size:14px;}
	.blueText{color:blue;font-weight:bold;cursor: pointer;font-size:14px;}
	.oneText{font-size:12px;background-color:#007be3;text-align:center;width:22px; height:22px;float:left;color:#fff;font-weight:bold;line-height:22px;}
	.textwrap{width:100%; margin:5px auto;height:auto;overflow:hidden;margin-left: 10px;margin-top: 10px;font-size:14px;}
	.title_big{font-size:17px; color:#333333;line-height:22px;font-weight:bold;}
	.bigBlueText{color:blue;font-weight:bold;cursor: pointer;font-size:17px;}
    </style>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var userOrgName = "<%=userOrgName%>"; 
       var bjzbz = "<%=bjzbz%>";
       var id = "<%=id%>";
       var userid = "<%=userid%>";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/floatWin/floatWin.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/xj/xjhomePage.js"></script>
  </head>
  <body style="overflow-y: scroll;overflow-x: hidden;">
    <table class="bodyTable" border=0 style="padding:5px;">
        <tr height="500px" id="yhid">
           <td width="50%" id="xqid">
           		<table class="modTable" border="0">
                <tr height="31px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg" style="width: 50%">巡区统计</td>
					<td class="titleBg" align="right">
					<!-- onmouseover="this.style.color='red'; this.style.fontSize='13';" onmouseout="this.style.color='green'; this.style.fontSize='12';" -->
						<a href="javascript:void(0);" onclick="" title="日期" style="color: green;	font-weight: bold; font-family: '微软雅黑'; font-size: 12px;" id="date1"
							>日期</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="goIframe('xqtj')" title="刷新" style="color: green;	font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>刷新</a>
					</td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
   				</tr>
   				<tr>
   					<td class="modTd" colspan="4">
   					   <iframe id="xqtj" name="xqtj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/xj|flashChart_xj"></iframe>
   					</td>
   				</tr>
             </table>
             
          </td>
          <td width="50%" id="dtid">
			<table class="modTable" border="0">
				<tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg" style="width: 50%">巡区地图</td>
					<td class="titleBg" align="right">
						<!-- 
						<a href="javascript:void(0);" onclick="" title="日期" style="color: green;	font-weight: bold; font-family: '微软雅黑'; font-size: 12px;" id="date2"
							onmouseover="this.style.color='red'; this.style.fontSize='13';" onmouseout="this.style.color='green'; this.style.fontSize='12';">日期</a>
						&nbsp;
						<a href="javascript:void(0);" id="orgbutton3" onclick="filter();" title="筛选" style="color: green;	font-weight: bold; font-family: '微软雅黑'; font-size: 12px;" id="sx"
							onmouseover="this.style.color='red'; this.style.fontSize='13';" onmouseout="this.style.color='green'; this.style.fontSize='12';">筛选</a>
						&nbsp;
						 -->
						<a href="javascript:void(0);" onclick="goIframe('xqdt');" title="刷新" style="color: green;	font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>刷新</a>
						&nbsp;	
						<a href="javascript:void(0);" onclick="menu_open('智能巡检', '/forward/query|xj_zdrkQueryMain');" title="智能巡检" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡检</a>
						&nbsp;	
						<a href="javascript:void(0);" onclick="HomePage.zoomWin();" title="放大"
							>>></a>
					</td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
				</tr>
				<tr>
					<td class="modTd" colspan="4" id="tdmapid">
						<div id="mapDiv"></div>
						<div id="toolDiv" style="position: absolute; filter: alpha(opacity=90);"></div>
					</td>
				</tr>
  			</table>
		  </td>
        </tr>
        <tr height="300px" id="shid">
          <td>
              <table class="modTable">
				<tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">消息提醒</td>
					<td class="titleBg"><a href="javascript:void(0);" onclick="queryMsg('巡警');" title="更多"
						>>></a></td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
				</tr>
				<tr>
					<td class="modTd" colspan="4">
						<iframe id="message" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/sysMessage/xjsearchRemind"></iframe>
					</td>
				</tr>
  			</table>
		  </td>
          <td>
			<table class="modTable">
				<tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg"  style="width: 50%">考核统计</td>
					<td class="titleBg" align="right">
						<a href="javascript:void(0);" onclick="" title="日期" style="color: green;	font-weight: bold; font-family: '微软雅黑'; font-size: 12px;" id="date3"
							>日期</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="" title="申诉" style="color: green;	font-weight: bold; font-family: '微软雅黑'; font-size: 12px;" id="ss"
							>考核</a>
						<!-- 
						&nbsp;
						<a href="javascript:void(0);" onclick="menu_open('巡警考核', '/forward/query|xj_zdrkQueryMain');" title="考核" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							onmouseover="this.style.color='red'; this.style.fontSize='13';" onmouseout="this.style.color='green'; this.style.fontSize='12';">考核</a>
						 -->
						 &nbsp;
						<a href="javascript:void(0);" onclick="goIframe('khtj');" title="刷新" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>刷新</a>
					</td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
				</tr>
				<tr>
					<td class="modTd" colspan="4">
						<iframe style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/xj|total_xj" id="khtj"></iframe>
					</td>
				</tr>
  			</table>
		  </td>
        </tr>
        <tr height="300px" id="lhid">
          <td colspan="2">
              <table class="modTable" border="0">
                <tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg" style="width: 50%">巡逻任务</td>
					<td class="titleBg" align="right">
						<a href="javascript:void(0);" onclick="" title="日期" style="color: green; display:none;	font-weight: bold; font-family: '微软雅黑'; font-size: 12px;" id="date"
							>日期</a>
						&nbsp;
						<!-- 
						[
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻车管理', '<%=httpURI%>/basic/PoliceCar.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻车管理</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻车查询', '<%=httpURI%>/basic/PoliceCarSearch.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻车查询</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻车审批', '<%=httpURI%>/basic/PoliceCarApprove.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻车审批</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻员管理', '<%=httpURI%>/basic/Employee.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻员管理</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻员查询', '<%=httpURI%>/basic/EmployeeSearch.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻员查询</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻员考核', '<%=httpURI%>/evaluation/EvaluationEmployee.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻员考核</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻员审批', '<%=httpURI%>/basic/EmployeeApprove.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻员审批</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻车考核', '<%=httpURI%>/evaluation/EvaluationCar_List.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻车考核</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('部门考核', '<%=httpURI%>/evaluation/EvaluationDept_List.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>部门考核</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻事件卡', '<%=httpURI%>/basic/EventCode.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻事件卡</a>
						&nbsp;
						
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻地点视图', '<%=httpURI%>/basic/LineView.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻地点视图</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('查询报表', '<%=httpURI%>/data/QueryReport.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>查询报表</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('历史数据', '<%=httpURI%>/data/HistoryData.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>历史数据</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('触发事件', '<%=httpURI%>/basic/TriggerEvent.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>触发事件</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('考核项目管理', '<%=httpURI%>/evaluation/EvaluationItem_List.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>考核项目管理</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡检计划设置', '<%=httpURI%>/basic/Plan.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡检计划设置 </a>
						&nbsp;
						
						<a href="javascript:void(0);" onclick="javascript: menu_open('执法记录仪', '<%=httpURI%>/data/RecorderLogs.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>执法记录仪</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('考核申诉审批', '<%=httpURI%>/evaluation/EvaluationAppeal_List.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>考核申诉审批</a>
						&nbsp;
						
						
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻事件', '<%=httpURI%>/basic/Event.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻事件</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('巡逻线路管理', '<%=httpURI%>/basic/Line.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>巡逻线路管理</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="javascript: menu_open('考核项目类型管理', '<%=httpURI%>/evaluation/EvaluationItemType_List.jsp?UserID=<%=userid%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>考核项目类型管理</a>
							
						]
						 -->
						<a href="javascript:void(0);" onclick="javascript: menu_open('计划设置', '<%=httpURI%>/basic/Plan.jsp?UserID=<%=userid%>&Role=<%=role%>');" title="设置" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>计划</a>
						&nbsp;
						<a href="javascript:void(0);" onclick="dz('#lineTree');" title="筛选" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>筛选</a>
						<!-- 
						<input  class="easyui-validatebox" type="text" id="fqrbm" name="fqrbm" style="display: none;" value="" />
						<input type="hidden" id="fsbmid" name="fsbmid" value="" style="" />
						<input type="hidden" id="orgid3" name="orgid3" value="" style="" />
						<a href="javascript:void(0);" id="orgbutton3" onclick="public_singleSelectOrg('', '01', '50', '01,01,03,04', 'fsbmid', 'fqrbm', 'orgid3', false, false, '', window, '', '')" title="筛选" 
							style="color: green;	
							font-weight: bold; font-family: '微软雅黑'; font-size: 12px;" id="sx"
							onmouseover="this.style.color='red'; this.style.fontSize='13';" onmouseout="this.style.color='green'; this.style.fontSize='12';">筛选</a>
						 -->
						&nbsp;
						<a href="javascript:void(0);" onclick="goIframe('xlrw');" title="刷新" style="color: green; font-weight: bold; font-family: '微软雅黑'; font-size: 12px;"
							>刷新</a>
						&nbsp;	
						<a href="javascript:void(0);" onclick="HomePage.zoomWins();" title="" 
							>>></a>
					</td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
   				</tr>
   				<tr>
   					<td class="modTd" colspan="4">
					    <iframe id="xlrw" name="xlrw" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/xj|xlrwgrid"></iframe>
   					</td>
   				</tr>
             </table>
          </td>
        </tr>
     </table>
     <div id="gzjlInfoDiv" style="width:100%;height:100%;display: none;">
		 <table id="gzjlInfoTable"></table>
	 </div>
	 
	 <div id="win" class="easyui-window" title="筛选" 
        data-options="iconCls:'icon-search',
		        collapsible:false,
		        minimizable:false,
		        maximizable:false,
		        modal:true,
        		shadow: true,
		        closed:true,
			    cache: false,
			    inline: false,
		        width:350,
        		height:130
        		" >   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
	        <form id ="queryForm" >
		        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
			        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">日期：</td>
					    	<td width="70%" class="dialogTd">
								<input type="text" name="fqsj" id="fqsj" class="easyui-validatebox"  style="width:100px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM', maxDate:'%y-%M'})" data-options="required:true,tipPosition:'right',
							 	validType:['date[\'yyyy-MM\']']" style="" value=""/>
							</td>
				   	</tr>	
			    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
				    	<td width="100%" colspan="2" align="center">
				    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton('win', 'date');">确定</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton('queryForm')">重置</a>
				    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('win');">关闭</a>
				    	</td>
			    	</tr>
		         </table>
		        </form>
	        </div>   
	    </div>   
	</div>
	
	<div id="win3" class="easyui-window" title="筛选" 
        data-options="iconCls:'icon-search',
		        collapsible:false,
		        minimizable:false,
		        maximizable:false,
		        modal:true,
        		shadow: true,
		        closed:true,
			    cache: false,
			    inline: false,
		        width:350,
        		height:130
        		" >   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
	        <form id ="queryForm" >
		        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
			        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">日期：</td>
					    	<td width="70%" class="dialogTd">
								<input type="text" name="fqsj2" id="fqsj2" class="easyui-validatebox"  style="width:100px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM', maxDate:'%y-%M'})" data-options="required:true,tipPosition:'right',
							 	validType:['date[\'yyyy-MM\']']" style="" value=""/>
							</td>
				   	</tr>	
			    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
				    	<td width="100%" colspan="2" align="center">
				    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton('win3', 'line');">确定</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton('queryForm')">重置</a>
				    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('win3');">关闭</a>
				    	</td>
			    	</tr>
		         </table>
		        </form>
	        </div>   
	    </div>   
	</div>
	
	<div id="win2" class="easyui-window" title="筛选" 
        data-options="iconCls:'icon-search',
		        collapsible:false,
		        minimizable:false,
		        maximizable:false,
		        modal:true,
        		shadow: true,
		        closed:true,
			    cache: false,
			    inline: false,
			    top: '400px',
		        width:350,
        		height:130
        		" >   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
	        <form id ="queryForm2" >
		        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
			        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">日期：</td>
					    	<td width="70%" class="dialogTd">
								<input type="text" name="fqsj1" id="fqsj1" class="easyui-validatebox"  style="width:100px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM', maxDate:'%y-%M'})" data-options="required:true,tipPosition:'right',
							 	validType:['date[\'yyyy-MM\']']" style="" value=""/>
							</td>
				   	</tr>	
			    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
				    	<td width="100%" colspan="2" align="center">
				    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton('win2', 'kh');">确定</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton('queryForm2')">重置</a>
				    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('win2');">关闭</a>
				    	</td>
			    	</tr>
		         </table>
		        </form>
	        </div>   
	    </div>   
	</div>
	
	<div id="win1" class="easyui-window" title="筛选" 
        data-options="iconCls:'icon-search',
		        collapsible:false,
		        minimizable:false,
		        maximizable:false,
		        modal:true,
        		shadow: true,
		        closed:true,
		        width:450,
        		height:150
        		" >   
	    <div class="easyui-layout" data-options="fit:true">   
	        <form id ="queryForm1" method="post" action="">
		        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center" style="padding-left: 20px;">
			        <tr class="dialogTr">
					    	<td width="25%" class="dialogTd" align="left">
								<input type="checkbox" id='qyfw' value="qyfw" name="checks" />区域范围
							</td>
					    	<td width="25%" class="dialogTd" align="left">
								<input type="checkbox" id='zdrk' value="zdrk" name="checks" />重点人口
							</td>
							<td width="25%" class="dialogTd" align="left">
								<input type="checkbox" id='jq' value="jq" name="checks" />警情
							</td>
					    	<td width="25%" class="dialogTd" align="left">
								<input type="checkbox" id='aq' value="aq" name="checks" />案情
							</td>
				   	</tr>	
				   	<tr class="dialogTr">
					    	<td width="25%" class="dialogTd" align="left">
								<input type="checkbox" id='sj' value="sj" name="checks" />事件
							</td>
					    	<td width="25%" class="dialogTd" align="left">
								<input type="checkbox" id='xlxl' value="xlxl" name="checks" />巡逻线路
							</td>
							<td width="25%" class="dialogTd" align="left">
								<input type="checkbox" id='xlc' value="xlc" name="checks" />巡逻车
							</td>
					    	<td width="25%" class="dialogTd" align="left">
								<input type="checkbox" id='xly' value="xly" name="checks" />巡逻员
							</td>
				   	</tr>	
			    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
				    	<td width="100%" colspan="4" align="center">
				    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton('win1', 'xj');">确定</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton('queryForm1')">重置</a>
				    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('win1');">关闭</a>
				    	</td>
			    	</tr>
		         </table>
		        </form>
	        </div>   
	    </div>   
	</div>

    <div id="mm" class="easyui-menu" style="width:120px;">
        <div onclick="javascript:queryTj('last', 'line');" iconCls="icon-moveUp">上周</div>
        <div onclick="javascript:queryTj('now', 'line');" iconCls="icon-ok">本周</div>
        <div onclick="javascript:queryTj('next', 'line');" iconCls="icon-moveDown">下周</div>
        <div class="menu-sep"></div>
       <div onclick="javascript:dz('#win3')" iconCls="icon-search">自定义</div>
    </div>
    <div id="mm1" class="easyui-menu" style="width:120px;">
        <div onclick="javascript: queryTj('hour', 'pie');" iconCls="icon-time">24小时</div>
        <div onclick="javascript: queryTj('week', 'pie')" iconCls="icon-ok">本周</div>
        <div onclick="javascript: queryTj('month', 'pie')" iconCls="icon-tip">本月</div>
        <div class="menu-sep"></div>
       <div onclick="javascript:dz('#win')" iconCls="icon-search">自定义</div>
    </div>
    <div id="mm2" class="easyui-menu" style="width:120px;">
    <!-- 
        <div onclick="javascript: queryTj('week', 'kh')" iconCls="icon-ok">本周</div>
         -->
        <div onclick="javascript: queryTj('month', 'kh')" iconCls="icon-tip">本月</div>
        <div class="menu-sep"></div>
       <div onclick="javascript:dz('#win2')" iconCls="icon-search">自定义</div>
    </div>
    <div id="mm3" class="easyui-menu" style="width:120px;">
        <div onclick="javascript: menu_open('巡逻员考核', '<%=httpURI%>/evaluation/EvaluationEmployee_List.jsp?UserID=<%=userid%>');" iconCls="icon-position">巡逻员考核</div>
        <div onclick="javascript: menu_open('巡逻车考核', '<%=httpURI%>/evaluation/EvaluationCar_List.jsp?UserID=<%=userid%>');" iconCls="icon-excel">巡逻车考核</div>
        <div onclick="javascript: menu_open('部门考核', '<%=httpURI%>/evaluation/EvaluationDept_List.jsp?UserID=<%=userid%>');" iconCls="icon-flowStamp">部门考核</div>
        <div class="menu-sep"></div>
       <div onclick="javascript: menu_open('考核申诉', '<%=httpURI%>/evaluation/EvaluationAppeal_List.jsp?UserID=<%=userid%>');" iconCls="icon-flowWrite">考核申诉</div>
       <!-- 
       <div onclick="javascript: menu_open('巡警考核', '/forward/query|xj_zdrkQueryMain');" iconCls="icon-report">考核</div>
        -->
    </div>
    <!-- 线路树 -->
    <div id="lineTree" class="easyui-window" title="线路" 
        data-options="iconCls:'icon-search',
		        collapsible:false,
		        minimizable:false,
		        maximizable:false,
		        modal:true,
        		shadow: true,
		        closed:true,
			    cache: false,
			    inline: false,
			    top: '500px',
		        width:300,
        		height:400
        		" >   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
	        <form id ="queryFormLine" >
		        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
			        <tr class="dialogTr">
					    	<td width="100%" height="290" class="dialogTd">
								<div style="width: 100%; height: 88%; overflow: scroll; overflow-x: hidden;">
						            <ul  id="ltree" class="easyui-tree"></ul>      
							    </div>
							</td>
				   	</tr>	
			    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
				    	<td width="100%"  align="center">
				    	<hr>
				    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton('lineTree', 'xxx');">确定</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton('queryFormLine')">重置</a>
				    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('lineTree');">关闭</a>
				    	</td>
			    	</tr>
		         </table>
		        </form>
	        </div>   
	    </div>   
	</div>
	
    <script>
    <!--
	    var date = new Date()
		var y = date.getFullYear();
		var m = date.getMonth()+1+'';
		if(m.length != 2){
			m = '0'+m;
		}
		var d = date.getDate()+'';
		if(d.length != 2){
			d = '0'+d;
		}
		var last = y + "-" + m;
	
        $(function(){
        	
        	document.getElementById("fqsj1").value =  last;
        	document.getElementById("fqsj2").value =  last;
        	document.getElementById("fqsj").value =  last;
        	
            $("#date").click(function(e){
                e.preventDefault();
                $('#mm').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            });
            $("#date1").click(function(e){
                e.preventDefault();
                $('#mm1').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            });
            $("#date2").click(function(e){
                e.preventDefault();
                $('#mm1').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            });
            $("#date3").click(function(e){
                e.preventDefault();
                $('#mm2').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            });
            $("#ss").click(function(e){
                e.preventDefault();
                $('#mm3').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            });
            
        });
        
    	//巡区统计
        function queryTj(parm, type){
    		if(type == "pie"){
	        	window.xqtj.location.href = document.all("xqtj").src + "?flag=" + parm ;
    		} else if(type == "kh"){
    			window.khtj.location.href = document.all("khtj").src + "?flag=" + parm ;
    		} else if(type == "line"){
    			window.xlrw.location.href = document.all("xlrw").src + "?flag=" + parm ;
    		} else if(type == "xxx"){
    			selOrg();
    		}
        }
        
        //日期控件
        function dz(obj){
        	if('#lineTree' == obj){
	        	createTree();
        	}
        	$(obj).window("open");
        	$("#queryForm").form("reset");
        	$("#queryForm2").form("reset");
        }
      
        //自定义查询
        function queryButton(obj, v){
    	    var context = "";
    	  	if(v == 'date'){
    	  		var b = document.getElementById("fqsj").value;
    	  		queryTj(b, 'pie');
    	  	} else if(v == 'xj'){
    	  		var res = document.getElementsByName("checks");
       	    	for(var i=0; i<res.length; i++){
        	   		if(res[i].checked == true){
        	    		context += res[i].value + ",";
        	    	}
        	    }
       	    	submits(context);
       	    	//$("queryForm1").submit();
	        	//alert(context);
    	  	} else if(v == 'kh'){
    	  		var b = document.getElementById("fqsj1").value;
    	  		queryTj(b, 'kh');
    	  	} else if(v == 'line'){
    	  		var b = document.getElementById("fqsj2").value;
    	  		queryTj(b, 'line');
    	  	} else if(v == 'xxx'){
    	  		var b = '';
    	  		queryTj(b, 'xxx');
    	  	}
        	closeWindow(obj);
        }
      
        function submits(pro){
        	$.ajax({
        		type:"POST",
        		url:"<%= basePath%>homePage/uptSZ",
        		dataType:"json",
        		data:"userid=" + userid + "&pro=" + pro,
        		success:function(data){
        		if (data && data.length>0) {
        			$.messager.show({
        				title: '系统消息',
        				msg: '设置成功',
        				timeout: 3000,
        				showType:'slide'
        			});
        		}
        		}
        	});
        }
        //重置按钮
        function resetButton(obj){
        	$("#"+obj).form("reset");
        }
      
        function closeWindow(obj){
        	$("#"+obj).window("close"); 
        }
        
        //$('#dataForm').form('validate');
        function loadSZ(){
        	$.ajax({
        		type:"POST",
        		url:"<%= basePath%>homePage/querySZ",
        		dataType:"json",
        		data:"userid=" + userid,
        		success:function(data){
        		if (data && data.length>0) {
        			for(var i=0; i<data.length; i++){
        				var pro = data[i].pro;
        				var sfxz = data[i].sfxz;
        				if ("qyfw" == pro && "1"==sfxz) {
        					document.getElementById("qyfw").checked = true;
						} else if("qyfw" == pro && "0"==sfxz){
							document.getElementById("qyfw").checked = false;
						}
        				if ("zdrk" == pro && "1"==sfxz) {
        					document.getElementById("zdrk").checked = true;
						} else if("zdrk" == pro && "0"==sfxz){
							document.getElementById("zdrk").checked = false;
						}
        				if ("jq" == pro && "1"==sfxz) {
        					document.getElementById("jq").checked = true;
						} else if("jq" == pro && "0"==sfxz){
							document.getElementById("jq").checked = false;
						}
        				if ("aq" == pro && "1"==sfxz) {
        					document.getElementById("aq").checked = true;
						} else if("aq" == pro && "0"==sfxz){
							document.getElementById("aq").checked = false;
						}
        				if ("sj" == pro && "1"==sfxz) {
        					document.getElementById("sj").checked = true;
						} else if("sj" == pro && "0"==sfxz){
							document.getElementById("sj").checked = false;
						}
        				if ("xlxl" == pro && "1"==sfxz) {
        					document.getElementById("xlxl").checked = true;
						} else if("xlxl" == pro && "0"==sfxz){
							document.getElementById("xlxl").checked = false;
						}
        				if ("xlc" == pro && "1"==sfxz) {
        					document.getElementById("xlc").checked = true;
						} else if("xlc" == pro && "0"==sfxz){
							document.getElementById("xlc").checked = false;
						}
        				if ("xly" == pro && "1"==sfxz) {
        					document.getElementById("xly").checked = true;
						} else if("xly" == pro && "0"==sfxz){
							document.getElementById("xly").checked = false;
						}
        			}
        		}
        		}
        	});
        }
        
        function filter(){
        	loadSZ();
        	$("#win1").window("open"); 
        	$("#queryForm1").form("reset");
        }
        
        //刷新
        function goIframe(flag){
        	if(flag == 'xqtj'){
        		window.xqtj.location.href = document.all("xqtj").src ;
        	} else if(flag == 'xqdt'){
        		if(typeof EzServerClient != "undefined"){
        			HomePage.loadMap();
        			//统计信息
        			//HomePage.initFloatWin();
        		}
        	} else if(flag == 'xlrw'){
        		window.xlrw.location.href = document.all("xlrw").src + "?names=abc&a=中文";
        	} else if(flag == 'khtj'){
        		window.khtj.location.href = document.all("khtj").src;
        	}         	
        }
        
        function createTree(){
    		$("#ltree").tree({
    			url : "<%=basePath%>homePage/jsonTree?id=" + id + "&orgcode=" + userOrgCode + "&flag=line",
    			method: 'GET',
    			animate: true,
    			checkbox: true,
    			onlyLeafCheck: true,
    			lines: true,
    			cache: false,
    			onBeforeExpand: function(node){
    				if(node){
    					$('#ltree').tree('options').url = "<%=basePath%>homePage/jsonTree?id=" + node.id + "&orgcode=" + userOrgCode + "&flag=line";
    				}
    			}
    		});
    	}
        
        //
        function selOrg(){
    		var node = $("#ltree").tree("getChecked");
    		var temp = "";
    		var pnodes = "";
    		for(var i=0; i<node.length; i++){
    			if($("#ltree").tree("isLeaf", node[i].target)){
    				var root = $("#ltree").tree("getRoot", node[i].target);
    				var pnode = $("#ltree").tree("getParent", node[i].target);
    				if(pnode.checked){
    					if(pnode.orgcode==root.orgcode && temp!=node[i].orgcode){
    						pnodes += node[i].orgcode + ",";
    						temp = node[i].orgcode;
    					} else if(temp != pnode.orgcode){
    						pnodes += pnode.orgcode + ",";
    						temp = node[i].orgcode;
    					}
    				} else if(temp!=node[i].orgcode){
    					pnodes += node[i].orgcode + ",";
    					temp = node[i].orgcode;
    				}
    			}
    		}
    		pnodes = pnodes.substring(0, pnodes.length-1);
    		window.xlrw.location.href = document.all("xlrw").src + "?flag=" + pnodes ;
    	}
        
        -->
    </script>
    
  </body>
</html>