<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.sql.*"%>
<%
	String zbs=request.getParameter("zbs");
	String[] zbArr=zbs.split("\\|");
	Gson g=new Gson();
	try{
		List<String> res=new ArrayList<String>();
		for(String zb:zbArr){
			res.add(zb);
		}
		session.setAttribute("alermAnalyse_hotPic_zbArr",res);
		out.write(g.toJson(true));
	}catch(Exception e){
		out.write(g.toJson(false));
		e.printStackTrace();
	}
%>