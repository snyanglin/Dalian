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


</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>领导页面</title>
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
   
  </head>
  <body style="overflow-y: scroll;overflow-x: hidden;">
    <table class="bodyTable" border=0 style="padding:5px;">
        <tr height="500px" id="yhid">
           <td width="50%" id="dtid">
			 <table class="modTable">
                <tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">工作待办</td>
					<td class="titleBg"><a href="javascript:void(0);" onclick="queryMsg('工作待办');" title="更多">>></a></td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
   				</tr>
   				<tr>
   					<td class="modTd" colspan="4">
   					    <iframe id="wfTask" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/ldym/searchTask"></iframe>
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
   					   <iframe style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/ldym|flashChart"></iframe>
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
					<td class="titleBg">十日内工作量统计</td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
   				</tr>
   				<tr>
   					<td class="modTd" colspan="4">
   					    <iframe id="gzltj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/ldym|gzltjIndex"></iframe>
   					</td>
   				</tr>
             </table>
          </td>
          
           <td>
			<table class="modTable">
				<tr height="30px">
					<td width="9px"><img src="../images/sqjw/homePage/title-left.png"/></td>
					<td class="titleBg">有效数据统计</td>
					<td width="7px"><img src="../images/sqjw/homePage/title-right.png"/></td>
				</tr>
				<tr>
					<td class="modTd" colspan="4">
						<iframe id="dtjqMessage" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/ldym|yxsjtjIndex"></iframe>
					</td>
				</tr>
  			</table>
		  </td>
          
          
          
         
        </tr> 
     
        

     </table>
    <!--  <div id="gzjlInfoDiv" style="width:100%;height:100%;display: none;">
		 <table id="gzjlInfoTable"></table>
	 </div> -->
  </body>
</html>