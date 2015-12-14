<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.founder.xjpt.com.founder.noreas.conn.DBConnection"%>
<%@page import="java.sql.*"%>
<%
	String pid=request.getParameter("pid");
	String level=request.getParameter("level");
	Gson g=new Gson();
	List<Map<String,String>> res=new ArrayList<Map<String,String>>();
	Map<String,String> unsel=new HashMap<String,String>();
	unsel.put("id","");
	unsel.put("text","请选择");
	res.add(unsel);
	if("".equals(pid)){
		out.write(g.toJson(res));
		return;
	}
	Connection conn=null;
	try{
		conn=DBConnection.getJDBConnection();
		Statement st=conn.createStatement();
		String sql="";
		if("2".equals(level)){
			if("210200000000".equals(pid)){
				sql="select zzjgdm,zzjgmc from pgisapp.t_zzjg t where t.ssjgdm='"+pid+"'";
			}else{
				sql="select zzjgdm,zzjgmc from pgisapp.t_zzjg t where t.zzjgdm='"+pid+"'";
			}
		}else{
			sql="select zzjgdm,zzjgmc from pgisapp.t_zzjg t where t.ssjgdm='"+pid+"'";
		}
		//System.out.println(sql);
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			Map<String,String> m=new HashMap<String,String>();
			m.put("id",rs.getString("zzjgdm"));
			m.put("text",rs.getString("zzjgmc"));
			res.add(m);
		}
		if(res.size()==2){
			res.remove(0);
			res.get(0).put("selected","true");
		}
		//System.out.println(g.toJson(res));
		out.write(g.toJson(res));
	}catch(Exception e){
		out.write(g.toJson(res));
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