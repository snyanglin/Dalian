package com.founder.xjpt.com.founder.noreas.alermAnalyse.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.founder.xjpt.com.founder.noreas.conn.DBConnection;

public class PatrolLineDao {
	
	public String getXLLX(String orgId){
		StringBuffer res=new StringBuffer();
		res.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		res.append("<ROUTES>");
		Connection conn=null;
		try{
			conn=DBConnection.getJWZHConnection();
			Statement st1=conn.createStatement();
			Statement st2=conn.createStatement();
			String sql="select lineid,linename from jwm.line where policestationid='"+orgId+"' or policestationid in(select zzjgdm from pgisapp.t_zzjg t where t.ssjgdm='"+orgId+"' )";
			ResultSet rs1=st1.executeQuery(sql);
			while(rs1.next()){
				res.append("<ROUTE>");
				res.append("<ROUTEID>"+rs1.getString("lineid")+"</ROUTEID>");
				res.append("<ROUTENAME>"+rs1.getString("linename")+"</ROUTENAME>");
				res.append("<ORGID>"+orgId+"</ORGID>");
				ResultSet rs2=st2.executeQuery("select t1.siteid,t2.sitename,t1.sitesn,t2.longitude,t2.latitude from jwm.line_site t1 left join jwm.site t2 on t2.siteid=t1.siteid where t1.lineid='"+rs1.getString("lineid")+"'");
				res.append("<SITES>");
				while(rs2.next()){
					res.append("<SITE>");
					res.append("<SITEID>"+rs2.getString(1)+"</SITEID>");
					res.append("<SITENAME>"+rs2.getString(2)+"</SITENAME>");
					res.append("<SITESN>"+rs2.getString(3)+"</SITESN>");
					res.append("<PX>"+rs2.getString(4)+"</PX>");
					res.append("<PY>"+rs2.getString(5)+"</PY>");
					res.append("</SITE>");
				}
				res.append("</SITES>");
				res.append("</ROUTE>");
			}
			res.append("</ROUTES>");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res.toString();
	}
	
	public String getBYDD(String orgId){
		StringBuffer res=new StringBuffer();
		res.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		res.append("<SITES>");
		Connection conn=null;
		try{
			conn=DBConnection.getJWZHConnection();
			Statement st1=conn.createStatement();
			ResultSet rs1=st1.executeQuery("select t.siteid, t.sitename, t.longitude, t.latitude from jwm.site t where t.policestationid = '"+orgId+"' and t.siteid not in (select siteid from jwm.line_site where lineid in (select lineid from jwm.line where policestationid = '"+orgId+"'))");
			while(rs1.next()){
				res.append("<SITE>");
				res.append("<SITEID>"+rs1.getString(1)+"</SITEID>");
				res.append("<SITENAME>"+rs1.getString(2)+"</SITENAME>");
				res.append("<PX>"+rs1.getString(3)+"</PX>");
				res.append("<PY>"+rs1.getString(4)+"</PY>");
				res.append("</SITE>");
			}
			res.append("</SITES>");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res.toString();
	}
	
	public String updateXLLX(String patrolId,String lineId){
		Connection conn=null;
		try{
			conn=DBConnection.getJWZHConnection();
			Statement st=conn.createStatement();
			st.execute("delete jwm.line_site where lineid='"+patrolId+"'");
			conn.commit();
			conn.setAutoCommit(false);
			String[] ids=lineId.split("@@");
			for(int i=0;i<ids.length;i++){
				if("".equals(ids[i]))continue;
					st.addBatch("insert into jwm.line_site(id,lineid,siteid,sitesn) values('"+getGUID().replaceAll("-", "")+"','"+patrolId+"','"+ids[i]+"','"+(i+1)+"')");
			}
			st.executeBatch();
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "1";
	}
	
	public List<String[]> getStiesByIds(String ids){
		List<String[]> list=new ArrayList<String[]>();
		Connection conn=null;
		try{
			conn=DBConnection.getJWZHConnection();
			Statement st=conn.createStatement();
			ResultSet res=st.executeQuery("select t.siteid,t.longitude,t.latitude from jwm.site t where t.siteid in("+ids+")");
			while(res.next()){
				String[] arr=new String[3];
				arr[0]=res.getString(1);
				arr[1]=res.getString(2);//x
				arr[2]=res.getString(3);//y
				list.add(arr);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	private String getGUID(){
		return UUID.randomUUID().toString();
	}
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
	}
}
