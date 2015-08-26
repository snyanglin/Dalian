<%@page language="java" pageEncoding="UTF-8" %>
<%
String contextPath = request.getContextPath();
String dictName = request.getParameter("dictName");
if (dictName == null) {
	dictName = "";
}
response.sendRedirect(contextPath + "/common/dict/" + dictName + ".js");
%>