package com.founder.xjpt.easymap.Dao;

import com.founder.xjpt.easymap.bean.SsyjBean;
import com.founder.xjpt.easymap.conn.DBConnection;
import com.founder.xjpt.easymap.sevlet.Mytext;
import com.founder.xjpt.easymap.sevlet.fzQueryServlet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SsyjSqlJava
{
  public static List<SsyjBean> getWeakSql(String zzjgdm, String jglx, String Qweak, String Zweak, String type, String zzjglx)
  {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List list = null;
    String Qweak1 = Qweak + " 00:00:00";
    String Zweak1 = Zweak + " 23:59:59";

    String sql = "";
    try {
      conn = DBConnection.getFkConnection();
      stmt = conn.createStatement();
      if ("13".equals(jglx))
        sql = "select t.zzjgdm,t.zzjgmc,nvl(t2.zs,0) as sum from dlezgabuilder.t_zzjg t left join(select jjdwdm,count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak1 + "', 'YYYY-MM-DD hh24:mi-ss')  and bjsj < to_date('" + Zweak1 + "', 'YYYY-MM-DD hh24:mi-ss'))group by jjdwdm) t2 on t2.jjdwdm =t.zzjgdm where t.zzjgdm = '" + zzjgdm + "'";
      else if ("12".equals(jglx))
        sql = "select t.zzjgdm,t.zzjgmc,nvl(t2.zs,0) as sum from dlezgabuilder.t_zzjg t left join(select jjdwdm,count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak1 + "', 'YYYY-MM-DD hh24:mi-ss') and bjsj < to_date('" + Zweak1 + "', 'YYYY-MM-DD hh24:mi-ss')) group by jjdwdm) t2 on t2.jjdwdm = t.zzjgdm where t.ssjgdm = '" + zzjgdm + "'";
      else if ("11".equals(jglx))
        sql = "select t.zzjgdm,t.zzjgmc,nvl(t2.zs,0) as sum from dlezgabuilder.t_zzjg t left join(select xzqhdm,count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak1 + "', 'YYYY-MM-DD hh24:mi-ss') and bjsj < to_date('" + Zweak1 + "', 'YYYY-MM-DD hh24:mi-ss')) group by xzqhdm) t2 on t2.xzqhdm =t.zzjgdm where t.ssjgdm = '210200000000'";

      System.out.println("+++++++++++++" + sql);
      rs = stmt.executeQuery(sql);
      list = new ArrayList();
      while (rs.next())
      {
        SsyjBean sb = new SsyjBean();
        String sum = rs.getString("sum");
        sb.setSumu(sum);
        System.out.println(type);
        String ysz = fzQueryServlet.getFzFun(type, rs.getString("zzjgdm"), Qweak, Zweak, sum, zzjglx);
        sb.setZzjgdm(rs.getString("zzjgdm"));

        sb.setZzjgmc(rs.getString("zzjgmc"));
        sb.setYsz(ysz);
        list.add(sb);
      }

      rs.close();
      stmt.close();
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public static List<SsyjBean> getJKWeakSql(String zzjgdm, String year, String jglx)
  {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List list = null;
    String Qweak0 = Mytext.getQmonth(year, "1") + " 00:00:00";
    String Zweak0 = Mytext.getZmonth(year, "1") + " 23:59:59";

    String sql = "";
    if ("3".equals(jglx))
      sql = "select count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak0 + "', 'YYYY-MM-DD hh24:mi-ss')  and bjsj < to_date('" + Zweak0 + "', 'YYYY-MM-DD hh24:mi-ss')) and zzjgdm = '" + zzjgdm + "' ";
    else if ("2".equals(jglx))
      sql = "select count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak0 + "', 'YYYY-MM-DD hh24:mi-ss')  and bjsj < to_date('" + Zweak0 + "', 'YYYY-MM-DD hh24:mi-ss')) and xzqhdm = '" + zzjgdm + "'";
    else if ("1".equals(jglx))
      sql = "select count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak0 + "', 'YYYY-MM-DD hh24:mi-ss')  and bjsj < to_date('" + Zweak0 + "', 'YYYY-MM-DD hh24:mi-ss'))";

    StringBuffer sb = new StringBuffer(sql);
    try
    {
      conn = DBConnection.getFkConnection();
      stmt = conn.createStatement();

      for (int z = 2; z <= 12; ++z) {
        String Qweak = Mytext.getQmonth(year, String.valueOf(z)) + " 00:00:00";
        String Zweak = Mytext.getZmonth(year, String.valueOf(z)) + " 23:59:59";
        if ("3".equals(jglx))
          sb.append(" union all select count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak + "', 'YYYY-MM-DD hh24:mi-ss')  and bjsj < to_date('" + Zweak + "', 'YYYY-MM-DD hh24:mi-ss')) and zzjgdm = '" + zzjgdm + "'");
        else if ("2".equals(jglx))
          sb.append(" union all select count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak + "', 'YYYY-MM-DD hh24:mi-ss')  and bjsj < to_date('" + Zweak + "', 'YYYY-MM-DD hh24:mi-ss')) and xzqhdm = '" + zzjgdm + "' ");
        else if ("1".equals(jglx))
          sb.append(" union all select count(*) zs from GIS210200000000.jcj_jq_pt where (bjsj > to_date('" + Qweak + "', 'YYYY-MM-DD hh24:mi-ss')  and bjsj < to_date('" + Zweak + "', 'YYYY-MM-DD hh24:mi-ss'))");

      }

      System.out.println("+++++++++" + sb.toString());
      rs = stmt.executeQuery(sb.toString());
      list = new ArrayList();
      while (rs.next())
      {
        SsyjBean kk = new SsyjBean();
        String sum = rs.getString("zs");
        kk.setSumu(sum);

        list.add(kk);
      }

      rs.close();
      stmt.close();
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
}