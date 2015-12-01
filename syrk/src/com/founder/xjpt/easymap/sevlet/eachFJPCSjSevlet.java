package com.founder.xjpt.easymap.sevlet;

import com.founder.xjpt.cgsoft.demo.XJ_GPS_DAO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class eachFJPCSjSevlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  public void destroy()
  {
    super.destroy();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    String ZZJGDM = request.getParameter("zzjgdm");
    System.out.println("++++++++++" + ZZJGDM);
    Connection conn = XJ_GPS_DAO.getConnection();
    try
    {
      CallableStatement cs = conn.prepareCall("{call GET_DATA_PARAM(?,?,?,?,?,?,?,?,?,?,?,?)}");

      paramPrepare(cs, ZZJGDM);

      cs.execute();

      int SYRK_NUM = cs.getInt(2);
      int CZRK_NUM = cs.getInt(3);
      int LDRK_NUM = cs.getInt(4);
      int ZDRK_NUM = cs.getInt(5);
      int ZJL_NUM = cs.getInt(6);
      int XLJL_NUM = cs.getInt(7);
      int XLCL_NUM = cs.getInt(8);
      int PCS_NUM = cs.getInt(9);
      int SQ_NUM = cs.getInt(10);
      int XLLX_NUM = cs.getInt(11);

      Float MJ_NUM = Float.valueOf(cs.getFloat(12));

      StringBuffer sb = new StringBuffer();
      sb.append("<menus>");

      sb.append("<menu SYRK_NUM='" + SYRK_NUM + "' CZRK_NUM='" + CZRK_NUM + 
        "' LDRK_NUM='" + LDRK_NUM + "' ZDRK_NUM='" + ZDRK_NUM + 
        "' ZJL_NUM='" + ZJL_NUM + "' XLJL_NUM='" + XLJL_NUM + 
        "' XLCL_NUM='" + XLCL_NUM + "' PCS_NUM='" + PCS_NUM + 
        "' XLLX_NUM='" + XLLX_NUM + "' MJ_NUM='" + MJ_NUM + 
        "'/>");

      sb.append("</menus>");
      System.out.println(sb);
      response.setContentType("text/xml;charset=UTF-8");
      response.getWriter().write(sb.toString());
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void paramPrepare(CallableStatement cs, String zzjgdm)
    throws SQLException
  {
    cs.setString(1, zzjgdm);

    cs.registerOutParameter(2, 2);
    cs.registerOutParameter(3, 2);
    cs.registerOutParameter(4, 2);
    cs.registerOutParameter(5, 2);
    cs.registerOutParameter(6, 2);
    cs.registerOutParameter(7, 2);
    cs.registerOutParameter(8, 2);
    cs.registerOutParameter(9, 2);
    cs.registerOutParameter(10, 2);
    cs.registerOutParameter(11, 2);
    cs.registerOutParameter(12, 2);
  }
}