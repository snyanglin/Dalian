<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="framework/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="common/tools/SysTool.js"></script>
	<script type="text/javascript" src="common/components/stateControl/js/stateControl.js"></script>

  </head>
  
  <body>
	<div id="test1">
	sdfsdfsd</div>
----------------------------------test
	<div id="test">
	</div>
	
	<script type="text/javascript">
		StateControl.init("test","test1");
		 StateControl.numberChange(100, "red");
		StateControl.setFunction("gray", function(){
			alert("call gray function");
		});
		StateControl.setFunction("red", function(){
			alert("call red function");
		});
		StateControl.setFunction("blue", function(){
			alert("call blue function");
		}); 
		//StateControl.numberChange(4, "blue");
		//StateControl.remove("blue");
		/* StateControl.add("t",function(){
			alert("tj1")
		});
		StateControl.add("lf_menu_7",function(){
			alert("tj2")
		}); */
		/* $("#num").animate({
			left:200,
			top:50,
			height:20,
			width:20
		},1000) *//* 
		$(".dynamicNum").text(3);
			$(".dynamicNum").fadeIn(1000); */
		//StateControl.dynamicNum(-2);
	</script>
  </body>
</html>
