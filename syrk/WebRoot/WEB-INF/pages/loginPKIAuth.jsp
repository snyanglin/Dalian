<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/errorPage.sp"%>
<%@include file="common.jsp"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@page import="java.util.*" %>
<%
String successStr = (String)request.getAttribute("isSuccess");
String errCode = "";
String errDesc = "";
boolean isSuccess = false;
if (successStr != null && !"".equals(successStr)) {
   isSuccess = Boolean.valueOf(successStr).booleanValue();
}
String sfzh = "";
if (isSuccess) { 
	
   Map attributeNodeMap = (Map)request.getAttribute("attributeNodeMap");
   if (attributeNodeMap != null) {
      Iterator iter = attributeNodeMap.entrySet().iterator(); 
      while (iter.hasNext()) { 
         Map.Entry entry = (Map.Entry) iter.next(); 
         Object key = entry.getKey(); 
         String [] keys =null;
         if (key != null && !"".equals(key)){
            keys = (String[])key;
            Object val = entry.getValue(); 
        	
            // 取身份证号开始 --------->
            if ("X509Certificate.SubjectDN".equals(keys[0])) {
               String valueString = val.toString();
               String[] tempArray = valueString.split(",");
               String cn = tempArray[0].substring(3);
               String[] tempArray2 = cn.split(" ");
               if (tempArray2.length > 1) {
                  sfzh = tempArray2[1];
                  sfzh = sfzh.toUpperCase();
               }
            }
            // 取身份证号结束 ---------->
            
            System.out.print("身份证号："+sfzh);
         }
      }
   }
}
else {
	errCode = (String)request.getAttribute("errCode");
	if (errCode == null) {
		errCode = "";
	}
	errDesc = (String)request.getAttribute("errDesc");
	if (errDesc == null) {
		errDesc = "";
	}
}
String contextPath = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/common/js/global.js"></script>
<link href="<%=contextPath%>/common/skin/main.css" type="text/css" rel="stylesheet" >
<title></title>
</head>

<script language="JavaScript">
var isSuccess = "<%=isSuccess%>";
var backURL = "<%=contextPath%>/random";
var delaySecond = 10;
var sfzh = "210203194703112293"; 

function body_onload() {
	
   if (isSuccess == "true" && sfzh != "") {
      document.forms["PKIForm"].submit();
   }
   else {
      document.getElementById("errorTable").style.display = "block";
      setTimeout("backInterval();", 2000);
   }
}

function backInterval() {
   delaySecond = delaySecond - 1;
   if (delaySecond == 0) {
      window.location.href = backURL;
   }
   else {
      document.getElementById("delayTd").innerHTML = "系统将在&nbsp; <font color='red'>"+ delaySecond +"</font> 秒之后返回到登陆页面 ...";
      setTimeout("backInterval();", 1000);
   }
}

function backExecute() {
   window.location.href = backURL;
}

</script>

<body class="errorBody" scroll="no" marginheight="0" onselectstart="return false;"
	style="-moz-user-select: none;" oncontextmenu="return false;" onload="body_onload()">
	
	
	

<table id="errorTable" width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="display: none;">
<tr><td valign="center">

   <table class="PKIFailTable" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><td height="225" colspan="2"></td></tr>
	  <tr>
	     <td width="259"></td>
	     <td valign="top"><input type="button" onclick="backExecute()" class="PKIFailBackBut1" onmouseover="this.className='PKIFailBackBut2'" onmouseout="this.className='PKIFailBackBut1'"></td>
	  </tr>
	  </td></tr>
   </table>
   <table border="0" align="center" cellpadding="0" cellspacing="0" width="600px">
	  <tr><td height="2"></td></tr>
	  <tr><td id="delayTd" align="center" style="color:#999999;">系统将在 <font color="red">10</font> 秒之后返回到登陆页面 ...</td></tr>
   </table>

</td></tr>
</table>

<div style="display:none;">
<form name="PKIForm" method="post" action="LoginPage/login">
	 <input type="hidden" name="action" value="pki">
    <input type="hidden" name="userid" value="210203194703112293">
</form>
</div>
	
</body>
</html>
