<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common.jsp"%>
<%
String contextPath = request.getContextPath();
String emptyImage = contextPath + "/common/skin/images/sys_empty.gif";

%>
<script type="text/javascript">
   var contextPath = "<%=contextPath%>";
</script>

<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/mainMenu.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/bzdz.css">

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
</HEAD>

<BODY class="menuBody">

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td valign="top" height="80">

	<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" height="50" class="searchTable" style="z-index: 20;">
	<tbody>
	<tr>
		<td align="right"><input type="text" class="searchText" style="width: 220px;"/></td>
		<td width="60" class="searchIcon"></td>
	</tr>
	</tbody>
	</table>

	<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" >
	<tbody>
	<tr><td nowrap class="dzTitle">标准地址</td></tr>
	</tbody>
	</table>
	
</td></tr>
<tr><td valign="top">
	
	<table border="2" cellpadding="2" cellspacing="0" borderColor="#007BE3" align="center" width="100%" height="100%">
	<tbody>
	<tr><td valign="top">
		
		<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" height="100%">
		<tr><td valign="top">
		
			<table border="0" cellpadding="2" cellspacing="2" align="center" width="100%" class="dzDetailTable">
			<tr>
			    <td class="dzDetailTableHeadTd" align="center"><input type="checkbox">全选</td>
			    <td class="dzDetailTableHeadTd" align="center">选择地址类型</td>
			    <td class="dzDetailTableHeadTd" align="center">状态</td>
			</tr>
			<tr>
			    <td class="dzDetailTableTd2" align="center"><input type="checkbox">&nbsp;01</td>
			    <td class="dzDetailTableTd1" align="center">辽宁省大连市西岗区五四路1号</td>
			    <td class="dzDetailTableTd2" align="center"><input type="text" class="dzZt01_1"><input type="text" class="dzZt02_1"></td>
			</tr>
			<tr>
			    <td class="dzDetailTableTd2" align="center"><input type="checkbox">&nbsp;02</td>
			    <td class="dzDetailTableTd1" align="center">辽宁省大连市西岗区五四路2号</td>
			    <td class="dzDetailTableTd2" align="center"><input type="text" class="dzZt01_2"><input type="text" class="dzZt02_1"></td>
			</tr>
			<tr>
			    <td class="dzDetailTableTd2" align="center"><input type="checkbox">&nbsp;03</td>
			    <td class="dzDetailTableTd1" align="center">辽宁省大连市西岗区五四路3号</td>
			    <td class="dzDetailTableTd2" align="center"><input type="text" class="dzZt01_1"><input type="text" class="dzZt02_1"></td>
			</tr>
			<tr>
			    <td class="dzDetailTableTd2" align="center"><input type="checkbox">&nbsp;04</td>
			    <td class="dzDetailTableTd1" align="center">辽宁省大连市西岗区五四路4号</td>
			    <td class="dzDetailTableTd2" align="center"><input type="text" class="dzZt01_1"><input type="text" class="dzZt02_1"></td>
			</tr>
			<tr>
			    <td class="dzDetailTableTd2" align="center"><input type="checkbox">&nbsp;05</td>
			    <td class="dzDetailTableTd1" align="center">辽宁省大连市西岗区五四路5号</td>
			    <td class="dzDetailTableTd2" align="center"><input type="text" class="dzZt01_1"><input type="text" class="dzZt02_1"></td>
			</tr>
			<tr>
			    <td class="dzDetailTableTd2" align="center"><input type="checkbox">&nbsp;06</td>
			    <td class="dzDetailTableTd1" align="center">辽宁省大连市西岗区五四路6号</td>
			    <td class="dzDetailTableTd2" align="center"><input type="text" class="dzZt01_1"><input type="text" class="dzZt02_2"></td>
			</tr>
			</table>
	
        </td></tr>
		<tr><td valign="bottom" align="right">
		
			<table border="0" cellpadding="2" cellspacing="2">
			<tr>
			    <td align="center" style="padding-left:5px;padding-right:5px;"><a href="#">首页</a></td>
			    <td align="center" style="padding-left:5px;padding-right:5px;"><a href="#">上一页</a></td>
			    <td align="center" style="padding-left:5px;padding-right:5px;"><a href="#">下一页</a></td>
			    <td align="center" style="padding-left:5px;padding-right:5px;"><a href="#">末页</a></td>
			</tr>
			</table>
	
	    </td></tr>
	    </table>

	</td></tr>
	</tbody>
	</table>
	
</td></tr>
<tr><td valign="bottom" height="85">

	<table border="0" cellpadding="0" cellspacing="2" align="center">
	<tbody>
	<tr><td colspan="4" height="5"><td></tr>
	<tr>
	    <td><div class="dzTconText dzIconFh"><a href="#">返回</a></div></td>
	    <td><div class="dzTconText dzIconCht"><a href="#">层户图</a></div></td>
	    <td><div class="dzTconText dzIconWh"><a href="#">维护</a></div></td>
	    <td><div class="dzTconText dzIconBz"><a href="#">标注</a></div></td>
	</tr>
	<tr><td colspan="4" height="10"><td></tr>
	<tr>
	    <td><div class="dzTconText dzIconOk"><a href="#">确定</a></div></td>
	    <td><div class="dzTconText dzIconAdd"><a href="#">新增</a></div></td>
	    <td><div class="dzTconText dzIconPrev"><a href="#">上一条</a></div></td>
	    <td><div class="dzTconText dzIconNext"><a href="#">下一条</a></div></td>
	</tr>
	<tr><td colspan="4" height="5"><td></tr>
	</tbody>
	</table>
	</tbody></table>

</td></tr>
</table>

</BODY>
</HTML>

