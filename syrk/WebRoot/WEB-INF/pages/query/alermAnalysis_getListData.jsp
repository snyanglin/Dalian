<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.founder.xjpt.com.founder.noreas.conn.DBConnection"%>
<%@page import="java.sql.*"%>
<%
	String dept=request.getParameter("dept");
	String btime=request.getParameter("btime");
	String etime=request.getParameter("etime");
	String cjfs=request.getParameter("cjfs");
	String jqlb=request.getParameter("jqlb");
	Connection conn=null;
	Gson g=new Gson();
	try{
		conn=DBConnection.getJDBConnection();
		Statement st=conn.createStatement();
		StringBuffer sql=new StringBuffer();
		sql.append("select t.jjdwdm,max(t1.zzjgmc),count(1) from jcj_jq_pt t left join pgisapp.t_zzjg t1 on t1.zzjgdm=t.jjdwdm ");
		sql.append(" where jjsj between ").append("to_date('"+btime+" 00:00:00','yyyy-mm-dd hh24:mi:ss')");
		sql.append(" and ").append("to_date('"+etime+" 23:59:59','yyyy-mm-dd hh24:mi:ss')");
		sql.append(" and zbx is not null and zby is not null");
		if(!"210200000000".equals(dept)){
			sql.append(" and (jjdwdm = '"+dept+"'");
			sql.append(" or jjdwdm in (select zzjgdm from pgisapp.t_zzjg t where t.ssjgdm='"+dept+"'))");
		}
		sql.append(" group by t.jjdwdm");
		//sql.append(" and cjfs='"+cjfs+"'");
		//sql.append(" and jqlb='"+jqlb+"'");
		//System.out.println(sql.toString());
		ResultSet rs=st.executeQuery(sql.toString());
		List<Map<String,String>> res=new ArrayList<Map<String,String>>();
		while(rs.next()){
			Map<String,String> bean=new HashMap<String,String>();
			bean.put("area",rs.getString(2));
			bean.put("count",rs.getString(3));
			res.add(bean);
		}
		//System.out.println(g.toJson(res));
		out.write(g.toJson(res));
	}catch(Exception e){
		out.write(g.toJson(false));
		e.printStackTrace();
	}finally{
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
%>