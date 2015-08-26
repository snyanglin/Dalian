<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String contextPath = request.getContextPath();
%>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js"></script>
<link href="<%=contextPath%>/common/skin/main.css" type="text/css" rel="stylesheet" >
<style type="text/css">
.ZoomBody {
   margin: 0;
   border: 0;
   background: #D9EEFB;
}

.zoomLeft1 {
   cursor: pointer;
   height: 67px;
   width: 8px;
   background: url(<%=contextPath%>/common/skin/images/zoom_button.jpg) no-repeat left top;
}

.zoomLeft2 {
   cursor: pointer;
   height: 67px;
   width: 8px;
   background: url(<%=contextPath%>/common/skin/images/zoom_button.jpg) no-repeat right top;
}

.zoomRight1 {
   cursor: pointer;
   height: 67px;
   width: 8px;
   background: url(<%=contextPath%>/common/skin/images/zoom_button.jpg) no-repeat left bottom;
}

.zoomRight2 {
   cursor: pointer;
   height: 67px;
   width: 8px;
   background: url(<%=contextPath%>/common/skin/images/zoom_button.jpg) no-repeat right bottom;
}
</style>
</HEAD>

<script type="text/javascript" >
var extend = false;
var parentCols1 = "220,6,*";
var parentCols2 = "0,6,*";

function zoom_onMouseMove() {
   if (extend) {
      document.getElementById("zoom").className = "zoomRight2";
   }
   else {
      document.getElementById("zoom").className = "zoomLeft2";
   }
}

function zoom_onMouseOut() {
   if (extend) {
      document.getElementById("zoom").className = "zoomRight1";
   }
   else {
      document.getElementById("zoom").className = "zoomLeft1";
   }
}

function zoom_click() {
   try {
      if (extend) {
         if (IE) {
            parent.kernel.cols = parentCols1;    
         }
         else {
            parent.frames.document.getElementById("kernel").cols = parentCols1; 
         }
         document.getElementById("zoom").className = "zoomLeft1"
         extend = false;
      }
      else {
         if (IE) {
            parent.kernel.cols = parentCols2;    
         }
         else {
            parent.frames.document.getElementById("kernel").cols = parentCols2; 
         }
         document.getElementById("zoom").className = "zoomRight1"
         extend = true;
      }
   }
   catch (err) {}     
}

function zoom_in() {
   try {
      if (extend) {
         if (IE) {
            parent.kernel.cols = parentCols1;    
         }
         else {
            parent.frames.document.getElementById("kernel").cols = parentCols1; 
         }
         document.getElementById("zoom").className = "zoomLeft1"
         extend = false;
      }
   }
   catch (err) {}     
}

function zoom_out() {
   try {
      if (!extend) {
         if (IE) {
            parent.kernel.cols = parentCols2;    
         }
         else {
            parent.frames.document.getElementById("kernel").cols = parentCols2; 
         }
         document.getElementById("zoom").className = "zoomRight1"
         extend = true;
      }
   }
   catch (err) {}     
}

</script>

<BODY class="ZoomBody" onselectstart="return false;" oncontextmenu="return false;">

<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" height="100%">
<tbody><tr>
  <td>
    <table border="0" cellpadding="0" cellspacing="0">
    <tr><td id="zoom" onclick="zoom_click();" class="zoomLeft1" onmousemove="zoom_onMouseMove()" onmouseout="zoom_onMouseOut()"></td></tr>
    </table>
  </td>
</tr></tbody>
</table>

</BODY>
</HTML>
