<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<title>显示流程图</title>
</head>
<body>
	ab  :${basePath}
	<!-- <A href="#" onclick="javascript:window.showModalDialog('/syrk/diagram/diagram/zalcg','dialogHeight=600px;dialogWidth=700px;dialogLeft=50px;center=no;scroll=no;menubar=no;resizable=yes');">查看流程图</a> 
	 -->
	 <A href="#" onclick="viewWorkflowDialog();">查看流程图</a> 

</body>
<script type="text/javascript">

function viewWorkflowDialog(){
	var processDefinitionKey = "zalcg";
	var url = '/syrk/diagram/diagram/' + processDefinitionKey;
	var result=window.open('/syrk/diagram/diagram/zalcg','newWindow','modal=yes,height=600px,width=900px,resizable=yes,z-look=yes,alwaysRaised=yes'); 
	window.onfocus=function (){result.focus();};

}

</script>
</html>