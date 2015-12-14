<%@page pageEncoding="UTF-8"%>
<%
Object sessionObject = session.getAttribute("userSession");
if (sessionObject != null) {
   session.removeAttribute("userSession");
}
%>
