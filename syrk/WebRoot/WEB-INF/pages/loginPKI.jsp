<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String original=null,certAuthen =null;
original = request.getAttribute("original")==null?null:request.getAttribute("original").toString();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>集中认证</title>
<link href="images/body.css" rel="stylesheet" type="text/css">
<object classid="clsid:707C7D52-85A8-4584-8954-573EFCE77488"
	id="JITDSignOcx" width="0" codebase="./JITDSign.cab#version=2,0,24,19"></object>
<script type="text/javascript">

//根据原文和证书产生认证数据包
function doDataProcess(){
	var Auth_Content = '<%=original%>';
	var DSign_Subject = document.getElementById("RootCADN").value;
	if(Auth_Content==""){
		alert("认证原文不能为空!");
	}else{
		//控制证书为一个时，不弹出证书选择框
		JITDSignOcx.SetCertChooseType(1);
		JITDSignOcx.SetCert("SC","","","",DSign_Subject,"");
		if(JITDSignOcx.GetErrorCode()!=0){
			alert("错误码："+JITDSignOcx.GetErrorCode()+"　错误信息："+JITDSignOcx.GetErrorMessage(JITDSignOcx.GetErrorCode()));
			return false;
		}else {
			 var temp_DSign_Result = JITDSignOcx.DetachSignStr("",Auth_Content);
			 if(JITDSignOcx.GetErrorCode()!=0){
					alert("错误码："+JITDSignOcx.GetErrorCode()+"　错误信息："+JITDSignOcx.GetErrorMessage(JITDSignOcx.GetErrorCode()));
					return false;
			 }
		//如果Get请求，需要放开下面注释部分
		//	 while(temp_DSign_Result.indexOf('+')!=-1) {
		//		 temp_DSign_Result=temp_DSign_Result.replace("+","%2B");
		//	 }
			document.getElementById("signed_data").value = temp_DSign_Result;
		}
	}
	document.getElementById("original_jsp").value = Auth_Content;
	document.forms[0].submit();
}
</script>
</head>
<body>
<center>
 
<form name="test" method="post" action="auth">颁发者DN：<input
	type="text" id="RootCADN" value="CN=DemoCA, O=JIT, C=CN" width="30" /><font color="red">(过滤证书选择框中的证书)</font>
	 <input type="hidden" id="signed_data" name="signed_data" /> 
	<input type="hidden" id="original_jsp" name="original_jsp" /> 
	<input type="button" name="b_refer1" onclick="doDataProcess();" value="认证" />
	
</form>
</center>
</body>
</html>