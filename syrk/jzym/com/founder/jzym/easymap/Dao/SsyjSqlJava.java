package com.founder.jzym.easymap.Dao;

import com.founder.jzym.easymap.bean.SsyjBean;
import com.founder.jzym.easymap.conn.DBConnection;
import com.founder.jzym.easymap.sevlet.fzQueryServlets;
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
      conn = DBConnection.getZkConnection();
      stmt = conn.createStatement();
      if ("13".equals(jglx))
        sql = "select t.orgcode,t.orgname,nvl(t2.zs,0) as sum from org_organization t left join(select gxdwdm,count(*) zs from   jcj.jcj_jjxxb where (to_date(bj_sj, 'YYYY-MM-DD hh24:mi-ss')  > to_date('" + Qweak1 + "', 'YYYY-MM-DD hh24:mi-ss')  and to_date(bj_sj, 'YYYY-MM-DD hh24:mi-ss')  < to_date('" + Zweak1 + "', 'YYYY-MM-DD hh24:mi-ss'))group by gxdwdm) t2 on t2.gxdwdm =t.orgcode where t.orgcode = '" + zzjgdm + "'";
      else if ("12".equals(jglx))
        sql = "select t.orgcode,t.orgname,nvl(t2.zs,0) as sum from org_organization t left join(select gxdwdm,count(*) zs from   jcj.jcj_jjxxb where (to_date(bj_sj, 'YYYY-MM-DD hh24:mi-ss')  > to_date('" + Qweak1 + "', 'YYYY-MM-DD hh24:mi-ss') and to_date(bj_sj, 'YYYY-MM-DD hh24:mi-ss')  < to_date('" + Zweak1 + "', 'YYYY-MM-DD hh24:mi-ss')) group by gxdwdm) t2 on t2.gxdwdm =t.orgcode where substr(t.orgcode,0,6)  =  substr('"+zzjgdm+"',0,6) and orglevel='32'";
      else if ("11".equals(jglx))
        sql = "select t1.orgcode,t1.orgname,nvl(t2.zs,0) as sum  from (select orgcode,orgname from org_organization where parentid='194113' and orglevel='21' and orgbiztype='01' )t1 left join   (select substr(gxdwdm,0,6)  as fj,count(*) zs from   jcj.jcj_jjxxb where (to_date(bj_sj, 'YYYY-MM-DD hh24:mi-ss')  > to_date('" + Qweak1 + "', 'YYYY-MM-DD hh24:mi-ss') and to_date(bj_sj, 'YYYY-MM-DD hh24:mi-ss')  < to_date('" + Zweak1 + "', 'YYYY-MM-DD hh24:mi-ss')) group by substr(gxdwdm,0,6)) t2 on substr(t1.orgcode,0,6)=t2.fj";
      System.out.println("+++++++++++++" + sql);
      rs = stmt.executeQuery(sql);
      list = new ArrayList();
      while (rs.next())
      {
        SsyjBean sb = new SsyjBean();
        String sum = rs.getString("sum");
        sb.setSumu(sum);
        System.out.println(type);
        String ysz = fzQueryServlets.getFzFun(type, rs.getString("orgcode"), Qweak, Zweak, sum, zzjglx);
        sb.setZzjgdm(rs.getString("orgcode"));

        sb.setZzjgmc(rs.getString("orgname"));
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

}