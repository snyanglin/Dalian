<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
String original=null,certAuthen =null;
original = request.getAttribute("original")==null?null:request.getAttribute("original").toString();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<style type="text/css">
	.login_body {
	    background-image: url(<%=contextPath%>/images/pki/bg.jpg);
	    background-repeat: repeat-x;
	    color: #FFFFFF;
	    font-size: 12px;
	}
	.login_body .login_img {
	    height: 405px;
	    width: 538px;
	    margin-right: auto;
	    margin-left: auto;
	    top: 15%;
	    position: relative;
	}
	.login_body .copyright {
	    line-height: 35px;
	    background-color: #688DB9;
	    height: 70px;
	    position: absolute;
	    bottom: 0px;
	    width: 100%;
	    padding-left:0px;
	    margin-left: 0px;
	}
	.copyright .part_1 {
	    line-height: 35px;
	    background-color: #9DC6F7;
	    height: 35px;
	    font-family: Arial, Helvetica, sans-serif;
	    font-size: 12px;
	    color: #FFFFFF;
	    text-align: center;
	}
</style>
</head>
<body class="login_body">
	<div class="login_img">
		<form name="test" method="post" action="auth">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<img width="538" height="314" src="<%=contextPath%>/images/pki/login_04.png"/>
				</td>
			</tr>
			<tr>
				<td height="70" align="center">
						<!--颁发者DN：-->
						<input type="hidden" id="RootCADN" value="" width="30" />
						<input type="hidden" id="signed_data" name="signed_data" /> 
						<input type="hidden" id="original_jsp" name="original_jsp" /> 
						<img width="166" height="54" src="<%=contextPath%>/images/pki/login_05.png" onclick="doDataProcess();"/>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div class="copyright" style="margin-left: -11px;">
		<div class="part_1">
			&copy 版权所有方正国际(北京)有限公司&nbsp;&nbsp;&nbsp;| Privacy Policy
			&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;京ICP
			备05053940&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;京公网安备 11010501040
		</div>
		<div>
			<table border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="35">
						<img width="25" height="25" src="<%=contextPath%>/images/pki/cr_07.png"/>
					</td>
					<td width="200">
						建议屏幕分辨率高于1024x768
					</td>
					<td width="35">
						<img width="25" height="25" src="<%=contextPath%>/images/pki/cr_09.png"/>
					</td>
					<td width="200">
						IE7以上的浏览器版本
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>