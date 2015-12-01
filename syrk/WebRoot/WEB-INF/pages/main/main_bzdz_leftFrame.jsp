<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String contextPath = request.getContextPath();
int frameCount = 2; // frame的个数
String frame1Url = contextPath + "/forward/main|bzdz_jlx";

StringBuffer cols = new StringBuffer();
StringBuffer frame = new StringBuffer();
cols.append("*");
for (int i = 1; i <= frameCount; i++) {
	if (i < frameCount) {
		cols.append(",0");
	}
	if (i == 1) {
		frame.append("<frame id='main_left_tab"+ i +"' noresize scrolling='no' src='"+ frame1Url +"'>");
	}
	else {
		frame.append("<frame id='main_left_tab"+ i +"' noresize scrolling='no' src=''>");
	}
}
%>
<script type="text/javascript">
window.top.mainLeftFrameCount = <%=frameCount%>;
</script>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<frameset id="main_left_set" cols="<%=cols.toString()%>" border="0" frameborder="0">
   <%=frame.toString()%>
   <noframes>
      <body>
         <p>此网页使用了框架，但您的浏览器不支持框架。</p>
      </body>
   </noframes>
</frameset>

</HTML>

