<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
    }
    
 %>
 <script type="text/javascript">

   window.setInterval("refresh_auto();", 180000);


// 页面刷新－自动时间间隔
function refresh_auto() {
   refresh_wfTask();
   refresh_message();
   refresh_inform();
}

// 页面刷新－流程待处理任务
function refresh_wfTask() {
   var myDate = new Date();
   var myTime = myDate.getTime();
   var openURL = "<%=contextPath%>/sysMessage/searchTask?myTime=" + myTime;
   if (IE) {
      document.frames["wfTask"].location.href = openURL;
   }
   else {
      document.getElementById("wfTask").contentWindow.location.href = openURL;
   }
}

// 页面刷新－个人消息查看
function refresh_message() {
   var myDate = new Date();
   var myTime = myDate.getTime();
   var messageOpenURL = "<%=contextPath%>/sysMessage/searchRemind?myTime=" + myTime;
   var dtjqOpenURL = "<%=contextPath%>/jcj/querySyDtjqxx?myTime=" + myTime;
   if (IE) {
      document.frames["message"].location.href = messageOpenURL;
      document.frames["dtjqMessage"].location.href = dtjqOpenURL;
   }
   else {
      document.getElementById("message").contentWindow.location.href = messageOpenURL;
      document.getElementById("dtjqMessage").contentWindow.location.href = dtjqOpenURL;
   }
}

// 页面刷新－个人通知公告
function refresh_inform() {
   var myDate = new Date();
   var myTime = myDate.getTime();
   var openURL = "<%=contextPath%>/sysMessage/searchInform?myTime=" + myTime;
   if (IE) {
      document.frames["inform"].location.href = openURL;
   }
   else {
      document.getElementById("inform").contentWindow.location.href = openURL;
   }
}

function queryMsg(bs){
   if (IE) {
      document.frames["message"].more_click(bs);
   }
   else {
      document.getElementById("message").contentWindow.more_click(bs);
   }
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
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/floatWin/floatWin.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/sqjw/homePage/homePage.js"></script>
  </head>
  <body style="overflow-y: scroll;overflow-x: hidden;">
    <table class="bodyTable" border=0 style="padding:5px;">
        <tr height="500px" id="yhid">
           <td width="50%" id="dtid">
			<table class="modTable">
				<tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">辖区地图</td>
					<td class="titleBg"><a href="javascript:void(0);" onclick="HomePage.zoomWin();" title="放大">>></a></td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
				</tr>
				<tr>
					<td class="modTd" colspan="4" id="tdmapid">
						<div id="mapDiv"></div>
						<div id="toolDiv" style="position: absolute;filter: alpha(opacity=90);"></div>
					</td>
				</tr>
  			</table>
		  </td>
          <td width="50%" id="xqid">
             <table class="modTable">
                <tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">辖区统计</td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
   				</tr>
   				<tr>
   					<td class="modTd" colspan="3">
   					   <iframe style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/sqjw|flashChart"></iframe>
   					</td>
   				</tr>
             </table>
          </td>
        </tr>
        <tr height="300px" id="lhid">
          <td>
  			 <table class="modTable">
                <tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">工作待办</td>
					<td class="titleBg"><a href="javascript:void(0);" onclick="queryMsg('工作待办');" title="更多">>></a></td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
   				</tr>
   				<tr>
   					<td class="modTd" colspan="4">
   					    <iframe id="wfTask" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/sysMessage/searchTask"></iframe>
   					</td>
   				</tr>
             </table>
          </td>
          
           <td>
			<table class="modTable">
				<tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">每日动态警情</td>
					<td class="titleBg"><a href="javascript:void(0);" onclick="menu_open('动态警情', '/forward/jcj|dtjjMessage');" title="更多">>></a></td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
				</tr>
				<tr>
					<td class="modTd" colspan="4">
						<iframe id="dtjqMessage" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/jcj/querySyDtjqxx"></iframe>
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
					<td class="titleBg"><a href="javascript:void(0);" onclick="queryMsg('消息提醒');" title="更多">>></a></td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
				</tr>
				<tr>
					<td class="modTd" colspan="4">
						<iframe id="message" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/sysMessage/searchRemind"></iframe>
					</td>
				</tr>
  			</table>
		  </td>
        
        
         <td>
              <table class="modTable">
				<tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">通知公告</td>
					<td class="titleBg"><a href="javascript:void(0);" onclick="queryMsg('通知公告');" title="更多">>></a></td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
				</tr>
				<tr>
					<td class="modTd" colspan="4">
 						<div id="gzggDiv">
 						  <iframe id="inform" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/sysMessage/searchInform"></iframe>
 						</div>
					</td>
				</tr>
  			</table>
          </td>
        </tr>
        
        
        <!-- 
        <tr height="300px" id="gzjlid">
             <td>
              <table class="modTable">
                <tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">工作记录</td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
   				</tr>
   				<tr>
   					<td class="modTd" colspan="3">
					    <iframe style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/sqjw|gzjlgrid"></iframe>
   					</td>
   				</tr>
             </table>
		  </td>
        </tr>
         -->
     </table>
     <div id="gzjlInfoDiv" style="width:100%;height:100%;display: none;">
		 <table id="gzjlInfoTable"></table>
	 </div>
  </body>
</html>