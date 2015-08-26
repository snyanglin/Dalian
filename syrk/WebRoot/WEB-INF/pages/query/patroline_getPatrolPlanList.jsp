<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolPlanBean"%>
<%
	List<PatrolPlanBean> res=(List<PatrolPlanBean>)request.getAttribute("patrol_planListResult");
%>
<div align="center" style="width: 100%;height: 400px;overflow:scroll;background: white;padding: 10px 0 50px 0;">
	<table align="center" style="width: 98%;" cellpadding="1" cellspacing="1" border="black 1px solid" >
		<tr>
			<td align="center">巡逻计划编号</td>
			<td align="center">计划巡检日期</td>
			<td align="center">开始时间</td>
			<td align="center">结束时间</td>
			<td align="center">实际到达次数</td>
			<td align="center">漏巡次数</td>
			<td align="center">迟到次数</td>
			<td align="center">早退次数</td>
			<td align="center">&nbsp;</td>
		</tr>
		<% 
			for(PatrolPlanBean ppb:res){
		%>
		<tr>
			<td align="center"><%=ppb.getId() %></td>
			<td align="center"><%=ppb.getPlanDate().substring(0,10) %></td>
			<td align="center"><%=ppb.getBtime().substring(10,ppb.getBtime().length()) %></td>
			<td align="center"><%=ppb.getEtime().substring(10,ppb.getBtime().length()) %></td>
			<td align="center"><%=ppb.getArrCount() %></td>
			<td align="center"><%=ppb.getOmiCount() %></td>
			<td align="center"><%=ppb.getLatCount() %></td>
			<td align="center"><%=ppb.getEarCount() %></td>
			<td align="center"><a href="###" onclick="patrolLine_patrolPlanShow('<%=ppb.getId() %>','<%=ppb.getPlanDate().substring(0,10) %>','<%=ppb.getBtime() %>','<%=ppb.getEtime() %>')">显示</a></td>
		</tr>	
		<% 
			}
		%>
	</table>
</div>