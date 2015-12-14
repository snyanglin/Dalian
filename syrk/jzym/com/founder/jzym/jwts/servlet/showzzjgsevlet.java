package com.founder.jzym.jwts.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.founder.jzym.jwts.bean.Gpsbean;
import com.founder.jzym.jwts.conn.DBConnection;;



public class showzzjgsevlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
    if ("13".equals(type)){	
	   Connection conn = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   Gson j=new Gson();
		try {
      
			String sql = "select * from t_gps_zzjg  t where t.parentid='210200000000' ";
			List<Map<String,String>> res=new ArrayList<Map<String,String>>();
			conn = DBConnection.getZlConnection();
			stmt = conn.createStatement();
			System.out.println("++++++++++"+sql);
			rs = stmt.executeQuery(sql.toString());
 
		  	while (rs.next()) {
		  	 String id= rs.getString("orgid");
		  	String name= rs.getString("orgname");
			Map<String,String> bean=new HashMap<String,String>();
			bean.put("id",id);
			bean.put("py","");
			bean.put("text",name);
			res.add(bean);
 	  		}
		  
			rs.close();
			stmt.close();
			conn.close();
			response.setContentType("text/json;charset=UTF-8");
			response.getWriter().write(j.toJson(res));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {

					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}  
		}
       else if ("12".equals(type)){	
			String ids=request.getParameter("id");
			   Connection conn = null;
			   Statement stmt = null;
			   ResultSet rs = null;
			   Gson j=new Gson();
				try {
		      
					String sql = "select * from t_gps_zzjg  t where t.parentid='"+ids+"' ";
					List<Map<String,String>> res=new ArrayList<Map<String,String>>();
					conn = DBConnection.getZlConnection();
					stmt = conn.createStatement();
					System.out.println("++++++++++"+sql);
					rs = stmt.executeQuery(sql.toString());
		 
				  	while (rs.next()) {
				  	String id= rs.getString("orgid");
				  	String name= rs.getString("orgname");
					Map<String,String> bean=new HashMap<String,String>();
					bean.put("id",id);
					bean.put("py","");
					bean.put("text",name);
					res.add(bean);
		 	  		}
				  
					rs.close();
					stmt.close();
					conn.close();
					response.setContentType("text/json;charset=UTF-8");
					response.getWriter().write(j.toJson(res));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if (conn != null) {

							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				  }
       
	 else if ("14".equals(type)){	
		 
		 String lx1=request.getParameter("lx1");
		 String lx2=request.getParameter("lx2");
	
		 String fz=request.getParameter("fz");
		 String pdz=request.getParameter("pdz");
	     SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String tjz="";
	     String sqs="";
	     
	    	  if("".equals(lx2))
	    	   {
	    		
	    		   if("210200000000".equals(lx1)){
		    		   sqs ="select count(*) sum from t_gps_info where oldorgid is not null ";
		    		   tjz="";
		    		   } else {
			    		   sqs ="select count(a.oldorgid) sum from t_gps_info a left join t_zzjg b  on b.zzjgdm=a.oldorgid  where a.oldorgid is not null and b.ssjgdm='"+lx1+"'";
			    		   tjz="and ssjgdm="+lx1;
			    		   }
	    		   
	    	   }else{
	    		   sqs = "select count(oldorgid) sum from  t_gps_info where oldorgid='"+lx2+"'";
	    		   tjz="and oldorgid="+lx2;
	    	   }
	     
	     String sum="kk";
	     if("1".equals(pdz)){
	         sum=getSqleach(sqs);
	     }
	       String times  =df.format(new Date());;
		   Connection conn = null;
		   Statement stmt = null;
		   ResultSet rs = null;
			try {
	      
			String sql = "select * from (select t1.oldorgid,t.gpsid,t1.carno,t1.callno,(select t3.zzjgmc from t_zzjg t3 where t3.zzjgdm = t1.oldorgid) orgname,(select t3.ssjgdm from t_zzjg t3 where t3.zzjgdm = t1.oldorgid) ssjgdm,t.x,t.y,t.realtime,(select t4.policetypename from t_gps_policetype t4 where t4.policetypeid = t1.policetypeid) policetypename from t_gps_realtime t, t_gps_info t1 where t.gpsid =t1.gpsid(+) and t1.oldorgid is not null and t.realtime>(to_date( '"+times+"' , 'YYYY-MM-DD hh24:mi-ss')-interval '"+fz+"' MINUTE )order by t.realtime desc ) where 1=1 "+tjz;
				conn = DBConnection.getZlConnection();
				stmt = conn.createStatement();
				System.out.println("++++第"+fz+"分钟++++++"+sql);
				rs = stmt.executeQuery(sql.toString());
				Map<String,Gpsbean> map = new HashMap<String,Gpsbean>(); 
			  	while (rs.next()) {

			  		Gpsbean xb = new Gpsbean();
			  		xb.setZbx(rs.getString("x"));
			  		xb.setZby(rs.getString("y"));
			  		xb.setHh(rs.getString("callno"));
			  		xb.setCph(rs.getString("carno"));
			  		xb.setJzlx(rs.getString("policetypename"));
			  		xb.setTimes(rs.getString("realtime"));
			  		xb.setSsdw(rs.getString("orgname"));
			        map.put(rs.getString("gpsid"), xb);

				}
				rs.close();
				stmt.close();
				conn.close();
				
			 Iterator<String> iter=map.keySet().iterator();
		
				StringBuffer sb = new StringBuffer();
		  sb.append("<menus>");
		   while(iter.hasNext()){
			String key=(String)iter.next();

		            	sb.append("<menu gpsid='"+key+"'  x='"+ map.get(key).getZbx() + "' y='" +map.get(key).getZby()
						        + "'  hh='" +map.get(key).getHh() + "'  cph='" +map.get(key).getCph()
						        + "'  dw='" +map.get(key).getSsdw() + "'  lx='" +map.get(key).getJzlx()
						        + "'  sum='" +sum
								+ "' times= '"+map.get(key).getTimes()+" '/>");	
			   }
				
				
				sb.append("</menus>");
				System.out.println(sb);
				response.setContentType("text/xml;charset=UTF-8");
				response.getWriter().write(sb.toString());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (conn != null) {

						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 
	 }

	
	}


	private String getSqleach(String sqs) {
		 Connection conn = null;
		    Statement stmt = null;
			 ResultSet rs = null;
		   String ss="";
		    try
		    {
		    	System.out.println("+++++1+++++"+sqs);
		      conn = DBConnection.getZlConnection();
			   stmt = conn.createStatement();
			  rs = stmt.executeQuery(sqs.toString());

		      rs.next();
		      ss =rs.getString("sum");
		    	System.out.println("+++++2+++++"+ss);
	      rs.close();
		
		      conn.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return ss;

	}

}
