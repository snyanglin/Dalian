<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/errorPage.jsp"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%
String contextPath = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery1.11.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.cookie.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><%=SystemConfig.getString("systemOrganization")%>－<%=SystemConfig.getString("systemName")%></title>
<link href="<%=contextPath%>/common/skin/login.css" rel="stylesheet" />
<script type="text/javascript">
 function setTab(name,cursel,n){
 for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  menu.className=i==cursel?"hover":"";
  con.style.display=i==cursel?"block":"none";
 }
}
</script>
</head>

<body bgcolor="#F3FAFF" onload="body_onload();" style="overflow: auto;">

<div class="login_nr">
<div class="header">
<form>
<ul>
<li><input value="用户名" type="text" onclick="setUser(this)" id="userId1" class="input2" /></li>
<li><input value="密码" type="text" id="password1" onclick="setPsd(this)" class="input2" /></li>
<li><input type="button" onclick="login1();" class="login_btn3" value="" /></li>
<li><input type="button" class="login_btn4" value="" /></li>
<li><img src="<%=contextPath%>/common/skin/images/hf2.png" width="14" height="14" class="hf img1" /></li>
</ul>
</form>
</div>
  <div class="tabbox">
    <div class="menu5">
      <ul>
        <li id="one1" onClick="setTab('one',1,2)" class="hover">普通登录</li>
        <li id="one2" onClick="setTab('one',2,2)">数字证书登录</li>
      </ul>
    </div>
    <div class="con_t1" id="con_one_1">
      <table width="584" border="0" cellpadding="0" cellspacing="0" align="center">
       <form name="dataform" action="<%=basePath%>LoginPage/login"  checkType="blur" target="_self" method="post">
         <input type="hidden" name="action" id="action" value="login">
        <tr>
          <td align="center"><div class="erroword" id="erroword"></div></td>
        </tr>
        <tr>
          <td align="center"><input class="inputon" maxlength="30" name="userid" id="userId" type="text" onfocus="this.select();" onKeyPress="userIdOnkeyPress()" class="text1"/></td>
        </tr>
        <tr>
          <td align="center"><input class="inputon" type="password" maxlength="30" name="password" id="password" onfocus="this.select();"  onKeyPress="passwordOnkeyPress()" class="text2"/></td>
        </tr>
        <tr>
          <td align="center" ><img src="<%=contextPath%>/common/skin/images/login_btn.png" width="391" height="44" class="login_btn1"  onclick="login();"/></td>
        </tr>
        <tr>
          <td align="center"><img src="<%=contextPath%>/common/skin/images/qx_btn.png" width="391" height="44" class="login_btn1"  /></td>
        </tr>
        </from>
      </table>
    </div>
    <div class="con_t1" id="con_one_2" style="display:none">
      <table width="584" border="0">
       <tr>
          <td align="center"><img src="<%=contextPath%>/common/skin/images/zs_text.png" width="65" height="69" class="img1 zs_login" /></td>
        </tr>
        <tr>
            <td align="center"><img src="<%=contextPath%>/common/skin/images/login_btn.png" width="391" height="44" class="login_btn2" /></td>
        </tr>
      </table>
    </div>

  </div>

</div>
</body>

<script language="JavaScript" >
try {
   if (window != top) { // 在顶层窗口打开登陆页面
      top.location.href = location.href;
   }
}
catch (err) {}

function body_onload() {
 
   if (focus == "userId" || focus == "") {
      document.getElementById("userId").focus();
   }
   else if (focus == "password") {
      document.getElementById("password").focus();
   }
}

function userIdOnkeyPress() {
   var keycode = event.keyCode;
   if (keycode == 13) {
      document.getElementById("password").focus();
   }
}

function passwordOnkeyPress() {
   var keycode = event.keyCode;
   if (keycode == 13) {
      login();
   }
}

function login(){
    var userIdValue = document.getElementById("userId").value;
    userIdValue = userIdValue.trim(); 
    if(null == userIdValue || "" == userIdValue ){
      //alert("请输入用户名！");
      document.getElementById("erroword").innerHTML="请输入用户名！";
      document.getElementById("userId").focus();
      document.getElementById("userId").className="inputerro";
      return;
    }
    $.cookie("lastUser",userIdValue,{expires:365});
    document.getElementById("userId").value = userIdValue;
    document.forms["dataform"].submit();
}

function login1(){
    var userIdValue = document.getElementById("userId1").value;
    var password1Value = document.getElementById("password1").value;
    userIdValue = userIdValue.trim(); 
    if(null == userIdValue || "" == userIdValue ){
      //alert("请输入用户名！");
      document.getElementById("erroword").innerHTML="请输入用户名！";
      document.getElementById("userId").focus();
      document.getElementById("userId").className="inputerro";
      return;
    }
    document.getElementById("userId").value = userIdValue;
    document.getElementById("password").value = password1Value;
    document.forms["dataform"].submit();
}

function reset(){
  document.getElementById("userId").value="";
  document.getElementById("password").value="";
}

String.prototype.trim = function() { 
   return this.replace(/(^\s*)|(\s*$)/g, ""); 
} 
errMsg();
function errMsg(){
   var errors = "${errors}";
   var focus = "${focus}";
   if (errors != "") {
      //alert(errors);
      document.getElementById("erroword").innerHTML=errors;
   }
}

function setUser(obj){
  obj.value="";
}
function setPsd(obj){
 obj.value="";
}
$(document).ready(function(){
	$("#userId").val($.cookie("lastUser"));
});
</script>

</body>
</html>