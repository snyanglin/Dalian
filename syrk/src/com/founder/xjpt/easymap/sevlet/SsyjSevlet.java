package com.founder.xjpt.easymap.sevlet;

import com.founder.xjpt.easymap.Dao.SsyjSqlJava;
import com.founder.xjpt.easymap.bean.SsyjBean;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SsyjSevlet extends HttpServlet
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
    StringBuffer sb;
    List list;
    int i;
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    String type = request.getParameter("type");
    String time1 = request.getParameter("time1");
    String time2 = request.getParameter("time2");
    String zzjgdm = request.getParameter("zzjgdm");
    String jglx = request.getParameter("zzjglx");

    String Qweak = "";
    String Zweak = "";
    String Qmonth = "";
    String Zmonth = "";
    String Qquarter = "";
    String Zquarter = "";
    String Qhalfyear = "";
    String Zhalfyear = "";
    String Qyear = "";
    String Zyear = "";
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    if ("0".equals(type))
      try {
        Date timeb = sdf.parse(time1);
        cal.setTime(timeb);
        int dayweek = cal.get(7);
        if (1 == dayweek) {
          cal.add(8, -1);
        }
        else
          cal.add(8, 0);

        cal.set(7, 2);
        Qweak = sdf.format(cal.getTime());

        Zweak = sdf.format(nDaysAfterOneDate(cal.getTime(), 6));
        System.out.println("+++++++++++" + Qweak);
        System.out.println("+++++++++++" + Zweak);

        StringBuffer sbs = new StringBuffer();
        List lis = SsyjSqlJava.getWeakSql(zzjgdm, jglx, Qweak, Zweak, type, jglx);
        sbs.append("<menus>");
        for (int z = 0; z < lis.size();z++)
          sbs.append("<menu zzjgdm='" + ((SsyjBean)lis.get(z)).getZzjgdm() + "' sum='" + ((SsyjBean)lis.get(z)).getSumu() + 
            "' zzjgmc='" + ((SsyjBean)lis.get(z)).getZzjgmc() + "' ysz='" + ((SsyjBean)lis.get(z)).getYsz() + 
            "'/>");

        sbs.append("</menus>");
        System.out.println(sbs);
        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().write(sbs.toString());
      }
      catch (ParseException e) {
        e.printStackTrace();
      }

    if ("1".equals(type)) {
      System.out.println(Integer.parseInt(time2) - 1);
      if (Integer.parseInt(time2) - 1 == 0)
      {
        Qmonth = String.valueOf(Integer.parseInt(time1) - 1) + "-12-26";
        Zmonth = time1 + "-01-25";
      } else {
        Qmonth = time1 + "-" + String.valueOf(Integer.parseInt(time2) - 1) + "-26";
        Zmonth = time1 + "-" + time2 + "-25";
      }
      System.out.println("+++++++++++" + Qmonth);
      System.out.println("+++++++++++" + Zmonth);

      sb = new StringBuffer();
      list = SsyjSqlJava.getWeakSql(zzjgdm, jglx, Qmonth, Zmonth, type, jglx);
      sb.append("<menus>");
      for (i = 0; i < list.size(); ++i)
        sb.append("<menu zzjgdm='" + ((SsyjBean)list.get(i)).getZzjgdm() + "' sum='" + ((SsyjBean)list.get(i)).getSumu() + 
          "' zzjgmc='" + ((SsyjBean)list.get(i)).getZzjgmc() + "' ysz='" + ((SsyjBean)list.get(i)).getYsz() + 
          "'/>");

      sb.append("</menus>");
      System.out.println(sb);
      response.setContentType("text/xml;charset=UTF-8");
      response.getWriter().write(sb.toString()); }
    if ("2".equals(type))
    {
      if (Integer.parseInt(time2) == 1)
      {
        Qquarter = String.valueOf(Integer.parseInt(time1) - 1) + "-12-26";
        Zquarter = time1 + "-03-25"; }
      if (Integer.parseInt(time2) == 2)
      {
        Qquarter = time1 + "-3-26";
        Zquarter = time1 + "-06-25";
      }
      if (Integer.parseInt(time2) == 3)
      {
        Qquarter = time1 + "-6-26";
        Zquarter = time1 + "-09-25"; }
      if (Integer.parseInt(time2) == 4)
      {
        Qquarter = time1 + "-09-26";
        Zquarter = time1 + "-12-25";
      }
      System.out.println("+++++++++++" + Qquarter);
      System.out.println("+++++++++++" + Zquarter);

      sb = new StringBuffer();
      list = SsyjSqlJava.getWeakSql(zzjgdm, jglx, Qquarter, Zquarter, type, jglx);
      sb.append("<menus>");
      for (i = 0; i < list.size(); ++i)
        sb.append("<menu zzjgdm='" + ((SsyjBean)list.get(i)).getZzjgdm() + "' sum='" + ((SsyjBean)list.get(i)).getSumu() + 
          "' zzjgmc='" + ((SsyjBean)list.get(i)).getZzjgmc() + "' ysz='" + ((SsyjBean)list.get(i)).getYsz() + 
          "'/>");

      sb.append("</menus>");
      System.out.println(sb);
      response.setContentType("text/xml;charset=UTF-8");
      response.getWriter().write(sb.toString()); }
    if ("3".equals(type))
    {
      if (Integer.parseInt(time2) == 1)
      {
        Qhalfyear = String.valueOf(Integer.parseInt(time1) - 1) + "-12-26";
        Zhalfyear = time1 + "-06-25"; }
      if (Integer.parseInt(time2) == 2)
      {
        Qhalfyear = time1 + "-06-26";
        Zhalfyear = time1 + "-12-25";
      }
      System.out.println("+++++++++++" + Qhalfyear);
      System.out.println("+++++++++++" + Zhalfyear);

      sb = new StringBuffer();
      list = SsyjSqlJava.getWeakSql(zzjgdm, jglx, Qhalfyear, Zhalfyear, type, jglx);
      sb.append("<menus>");
      for (i = 0; i < list.size(); ++i)
        sb.append("<menu zzjgdm='" + ((SsyjBean)list.get(i)).getZzjgdm() + "' sum='" + ((SsyjBean)list.get(i)).getSumu() + 
          "' zzjgmc='" + ((SsyjBean)list.get(i)).getZzjgmc() + "' ysz='" + ((SsyjBean)list.get(i)).getYsz() + 
          "'/>");

      sb.append("</menus>");
      System.out.println(sb);
      response.setContentType("text/xml;charset=UTF-8");
      response.getWriter().write(sb.toString()); }
    if ("4".equals(type))
    {
      Qyear = String.valueOf(Integer.parseInt(time1) - 1) + "-12-26";
      Zyear = time1 + "-12-25";
      System.out.println("+++++++++++" + Qyear);
      System.out.println("+++++++++++" + Zyear);

      sb = new StringBuffer();
      list = SsyjSqlJava.getWeakSql(zzjgdm, jglx, Qyear, Zyear, type, jglx);
      sb.append("<menus>");
      for (i = 0; i < list.size(); ++i)
        sb.append("<menu zzjgdm='" + ((SsyjBean)list.get(i)).getZzjgdm() + "' sum='" + ((SsyjBean)list.get(i)).getSumu() + 
          "' zzjgmc='" + ((SsyjBean)list.get(i)).getZzjgmc() + "' ysz='" + ((SsyjBean)list.get(i)).getYsz() + 
          "'/>");

      sb.append("</menus>");
      System.out.println(sb);
      response.setContentType("text/xml;charset=UTF-8");
      response.getWriter().write(sb.toString());
    }
  }

  public Date timeSD(String date)
    throws ParseException
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date k = sdf.parse(date);
    return k; }

  public Date nDaysAfterOneDate(Date bd, int n) {
    long nDay = (bd.getTime() / 86400000L + 1L + n) * 86400000L;
    bd.setTime(nDay);
    return bd;
  }

  public void init()
    throws ServletException
  {
  }
}