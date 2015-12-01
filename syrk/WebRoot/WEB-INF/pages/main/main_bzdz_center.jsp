<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common.jsp"%>

<%
String contextPath = request.getContextPath();
String emptyImage = contextPath + "/common/skin/images/sys_empty.gif";
%>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/bzdz.css">
</HEAD>

<BODY onload="body_onload();">

<table border="0" cellpadding="2" cellspacing="2" align="left">
<tr>
	<td><font class="dzHouseColor1">红</font>色为：<font class="dzHouseColor1">重点</font>人口&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><font class="dzHouseColor3">黄</font>色为：<font class="dzHouseColor3">暂住</font>人口&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><font class="dzHouseColor2">绿</font>色为：<font class="dzHouseColor2">常住</font>人口&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
</table>

<br>
<br>

<table border="0" cellpadding="0" cellspacing="0" align="left">
<tr>
	<td valign="bottom">

		<table border="0" cellpadding="0" cellspacing="0">
		<tr><td height="43" valign="bottom" align="center"><img src="<%=contextPath%>/common/skin/images/dz_house_top.gif" border="0" width="0" height="43"></td></tr>
		<tr><td height="17" class="dzHouseDyTd" align="center">一单元</td></tr>
	
		<tr><td>
	
			<table border="0" cellpadding="0" cellspacing="1" align="center" class="dzHouseTable">
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">5层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">501</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">502</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">503</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">4层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">401</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">402</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">403</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">3层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">301</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">302</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">303</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">2层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">201</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">202</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">203</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">1层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">101</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">102</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">103</div></td>
			</tr>
			<tr>
			   <td colspan="5" class="dzHouseHorizon"><img src="<%=emptyImage%>" width="213" height="1" border="0"></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">B1层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B101</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">B102</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B103</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">B2层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B201</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B202</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">B203</div></td>
			</tr>
			</table>
	    
	    </td></tr>
	    </table>
    
	</td>
	<td valign="bottom">

		<table border="0" cellpadding="0" cellspacing="0">
		<tr><td height="43" valign="bottom" align="center"><img src="<%=contextPath%>/common/skin/images/dz_house_top.gif" border="0" width="0" height="43"></td></tr>
		<tr><td height="17" class="dzHouseDyTd" align="center">二单元</td></tr>
	
		<tr><td>
	
			<table border="0" cellpadding="0" cellspacing="1" align="center" class="dzHouseTable">
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">3层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">301</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">302</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">303</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">2层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">201</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">202</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">203</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">1层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">101</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">102</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">103</div></td>
			</tr>
			<tr>
			   <td colspan="5" class="dzHouseHorizon"><img src="<%=emptyImage%>" width="213" height="1" border="0"></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">B1层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B101</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">B102</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B103</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">B2层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B201</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B202</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">B203</div></td>
			</tr>
			</table>
	    
	    </td></tr>
	    </table>

	</td>
	<td valign="bottom">

		<table border="0" cellpadding="0" cellspacing="0">
		<tr><td height="43" valign="bottom" align="center"><img src="<%=contextPath%>/common/skin/images/dz_house_top.gif" border="0" width="0" height="43"></td></tr>
		<tr><td height="17" class="dzHouseDyTd" align="center">三单元</td></tr>
	
		<tr><td>
	
			<table border="0" cellpadding="0" cellspacing="1" align="center" class="dzHouseTable">
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">7层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">701</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">702</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">703</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">6层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">601</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">602</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">603</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">5层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">501</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">502</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">503</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">4层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">401</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">402</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">403</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">3层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">301</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">302</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">303</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">2层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">201</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">202</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">203</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">1层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">101</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">102</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">103</div></td>
			</tr>
			<tr>
			   <td colspan="5" class="dzHouseHorizon"><img src="<%=emptyImage%>" width="213" height="1" border="0"></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">B1层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B101</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">B102</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B103</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">B2层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B201</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B202</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">B203</div></td>
			</tr>
			</table>
	    
	    </td></tr>
	    </table>

	</td>
	<td valign="bottom">

		<table border="0" cellpadding="0" cellspacing="0">
		<tr><td height="43" valign="bottom" align="center"><img src="<%=contextPath%>/common/skin/images/dz_house_top.gif" border="0" width="0" height="43"></td></tr>
		<tr><td height="17" class="dzHouseDyTd" align="center">四单元</td></tr>
	
		<tr><td>
	
			<table border="0" cellpadding="0" cellspacing="1" align="center" class="dzHouseTable">
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">7层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">701</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">702</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">703</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">704</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">6层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">601</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">602</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">603</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">604</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">5层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">501</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">502</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">503</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">504</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">4层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">401</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">402</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">403</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">404</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">3层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">301</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">302</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">303</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">304</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">2层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">201</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">202</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">203</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">204</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">1层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">101</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">102</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">103</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">104</div></td>
			</tr>
			<tr>
			   <td colspan="6" class="dzHouseHorizon"><img src="<%=emptyImage%>" width="263" height="1" border="0"></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">B1层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B101</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">B102</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B103</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv3">B104</div></td>
			</tr>
			<tr height="60">
			   <td class="dzHouseWall"></td>
			   <td class="dzHouseTd" align="center">B2层</td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B201</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B202</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv2">B203</div></td>
			   <td class="dzHouseTd" align="center" valign="top"><div class="dzHouseDiv1">B204</div></td>
			</tr>
			</table>
	    
	    </td></tr>
	    </table>

	</td>
</tr>
<tr>
	<td colspan="4" align="center" class="dzHouseDesc">大连市旅顺口区（高新工业园区）中山路12号楼</td>
</tr>	
</table>



<script type="text/javascript">

function body_onload() {
	var images = document.getElementsByTagName("img");
	for (var i = 0; i < images.length; i++) {
  		var imgObject = images[i];
  		if (imgObject.src.indexOf("dz_house_top.gif") != -1) {
  			imgObject.width = imgObject.parentNode.offsetWidth;
  		}
  }
		
}

function test() {
	alert("test");
}

</script>

</BODY>
</HTML>

