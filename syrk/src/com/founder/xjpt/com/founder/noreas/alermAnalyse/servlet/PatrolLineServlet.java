package com.founder.xjpt.com.founder.noreas.alermAnalyse.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolLineBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolPlanBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolPlanSiteBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolSiteBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.services.PatrolLineServices;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class PatrolLineServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String opeFlag=req.getParameter("opeFlag");
		Gson gson=new Gson();
		PatrolLineServices pls=new PatrolLineServices();
		if("getList".equals(opeFlag)){
			String orgId=req.getParameter("orgId");
			List<PatrolLineBean> res=pls.getXLLX(orgId);
//			System.out.println(gson.toJson(res));	
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(gson.toJson(res));
		}else if("getPatrolPlanList".equals(opeFlag)){
			String patrolId=req.getParameter("patrolId");
			String bdate=req.getParameter("bdate");
			String edate=req.getParameter("edate");
			List<PatrolPlanBean> res=pls.getXLJHTJ(patrolId,bdate,edate);
			req.setAttribute("patrol_planListResult", res);
			req.getRequestDispatcher("/WEB-INF/pages/query/patroline_getPatrolPlanList.jsp").forward(req, resp);
		}else if("udpatePatrolLine".equals(opeFlag)){
			String patrolId=req.getParameter("patrolId");
			String lineId=req.getParameter("lineId");
			boolean res=pls.updateXLLX(patrolId,lineId);
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(gson.toJson(res));
		}else if("getPatrolPointByOrgId".equals(opeFlag)){
			String orgId=req.getParameter("orgId");
			List<PatrolSiteBean> res=pls.getBYDD(orgId);
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(gson.toJson(res));
		}else if("getPatrolPlanExecute".equals(opeFlag)){
			String planId=req.getParameter("planId");
			String planDate=req.getParameter("planDate");
			String btime=req.getParameter("btime");
			String etime=req.getParameter("etime");
			List<PatrolPlanSiteBean> res=pls.getXLJHXX(planId, planDate, btime, etime);
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(gson.toJson(res));
		}
	}

}
