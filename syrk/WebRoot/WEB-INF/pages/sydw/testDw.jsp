<!--  
	@备注：功能暂时没有用到，所以不进行修改
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'testDw.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  
  <br/>
  <br/>
  <br/>
  <br/>
  <br/>
  
  <center >
  <form action="<%=basePath%>sydwcx/queryDwByLx" id="queryDwform">
  	<input class="easyui-combobox" type="text" id="sydwlx" name="sydwlx"
	 	style="width:150px;"
				data-options="url: contextPath + '/common/dict/D_DW_DWLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
 	<br/><br/><br/><br/>
 	<input type="submit" value="测试单位类型">
  </form>
  </center>
  </body>
</html>
