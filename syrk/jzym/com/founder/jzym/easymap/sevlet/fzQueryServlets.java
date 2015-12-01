package com.founder.jzym.easymap.sevlet;

import com.founder.jzym.easymap.conn.DBConnection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fzQueryServlets
{
  private static Connection conn = null;
  private static PreparedStatement ps = null;
  private static ResultSet rs = null;

  public static String getFzFun(String queryType, String zzjgdm, String kssj, String jssj, String sumNum, String zzjglx)
  {
    int value1 = 0;
    int value2 = 0;
    int value3 = 0;
    int value4 = 0;
    int value5 = 0;
    int value6 = 0;
    String fz1 = "";
    String colorStr = "";
    try
    {
      conn = DBConnection.getZkConnection();
      String sql = returnSqlStr(zzjgdm, queryType, kssj, jssj, zzjglx);

      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        value1 = Integer.parseInt(rs.getString("a"));
        System.out.println("三年前同比警情value1：" + value1);
        value2 = Integer.parseInt(rs.getString("b"));
        System.out.println("两年前同比警情value2：" + value2);
        value3 = Integer.parseInt(rs.getString("c"));
        System.out.println("一年前同比警情value3：" + value3);
        value4 = Integer.parseInt(rs.getString("c"));
        System.out.println("上一年度同期同比警情数量value4：" + value4);
        value5 = Integer.parseInt(rs.getString("d"));
        System.out.println("本年度上一周期环比警情数量value5：" + value5);
        value6 = Integer.parseInt(rs.getString("e"));
        System.out.println("前一年警情数量value6：" + value6);
      }
      if (queryType.equals("0")) {
        fz1 = String.valueOf((value1 + value2 + value3) / 3 * 0.40000000000000002D + value4 * 0.29999999999999999D + value5 * 0.20000000000000001D + value6 / 52 * 0.10000000000000001D);
        System.out.println("周阀值计算公式：(value1+value2+value3)/3*0.4+value4*0.3+value5*0.2+value6/52*0.1");
        System.out.println("周阀值计算结果：" + fz1);
      } else if (queryType.equals("1")) {
        fz1 = String.valueOf((value1 + value2 + value3) / 3 * 0.40000000000000002D + value4 * 0.29999999999999999D + value5 * 0.20000000000000001D + value6 / 12 * 0.10000000000000001D);
        System.out.println("月阀值计算公式：(value1+value2+value3)/3*0.4+value4*0.3+value5*0.2+value6/12*0.1");
        System.out.println("月阀值计算结果：" + fz1);
      } else if (queryType.equals("2")) {
        fz1 = String.valueOf((value1 + value2 + value3) / 3 * 0.40000000000000002D + value4 * 0.29999999999999999D + value5 * 0.20000000000000001D + value6 / 4 * 0.10000000000000001D);
        System.out.println("季度阀值计算公式：(value1+value2+value3)/3*0.4+value4*0.3+value5*0.2+value6/4*0.1");
        System.out.println("季度阀值计算结果：" + fz1);
      } else if (queryType.equals("3")) {
        fz1 = String.valueOf((value1 + value2 + value3) / 3 * 0.40000000000000002D + value4 * 0.29999999999999999D + value5 * 0.20000000000000001D + value6 / 2 * 0.10000000000000001D);
        System.out.println("半年阀值计算公式：(value1+value2+value3)/3*0.4+value4*0.3+value5*0.2+value6/2*0.1");
        System.out.println("半年阀值计算结果：" + fz1);
      } else {
        fz1 = String.valueOf((value1 + value2 + value3) / 3 * 0.40000000000000002D + value4 * 0.29999999999999999D + value5 * 0.20000000000000001D + value6 * 0.10000000000000001D);
        System.out.println("年阀值计算公式：(value1+value2+value3)/3*0.4+value4*0.3+value5*0.2+value6*0.1");
        System.out.println("年阀值计算结果：" + fz1);
      }
      Double  fz1s;
      Double  bfb;

      if("0.0".equals(fz1)){

    	    fz1s=Double.valueOf("0");
    	    bfb=Double.valueOf("0");
      }else{
      Double fzs1 = Double.valueOf(Double.parseDouble(fz1));
      Double bfbs=((Double.parseDouble(sumNum)-fzs1)/fzs1)*100;
    
        bfb=Sswl(bfbs);
        fz1s=Sswl(Double.valueOf(fz1));
    }
      colorStr = returnColor(sumNum, fz1) + "||" + value1 + "||" + value2 + "||" + value3 + "||" + value4 + "||" + value5 + "||" + value6 + "||" + fz1s+ "||" + bfb;
      System.out.println(queryType + "-" + zzjgdm + "-" + sumNum + "-" + zzjglx + "-" + colorStr);
    }
    catch (Exception e) {
      e.printStackTrace();
      try {
        conn.close();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }

      try
      {
        conn.close();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }

      try
      {
        conn.close();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
    finally
    {
      try
      {
        conn.close();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
    return colorStr;
  }

  public static String returnColor(String dbValue, String fzValue) {
    Double fz1 = Double.valueOf(Double.parseDouble(fzValue));
    Double fz2 = Double.valueOf(Double.parseDouble(fzValue) * 1.1000000000000001D);
    Double fz3 = Double.valueOf(Double.parseDouble(fzValue) * 1.2D);
    String colorStr = "";
    if (Double.parseDouble(dbValue) <= fz1.doubleValue())
        colorStr = "blue";
      else if ((Double.parseDouble(dbValue) > fz1.doubleValue()) && (Double.parseDouble(dbValue) <= fz2.doubleValue()))
        colorStr = "yellow";
      else if ((Double.parseDouble(dbValue) > fz2.doubleValue()) && (Double.parseDouble(dbValue) <= fz3.doubleValue()))
        colorStr = "#FF3300";
      else if (Double.parseDouble(dbValue) > fz3.doubleValue()) {
        colorStr = "red";
      }
    return colorStr;
  }

  public static String returnZzjgdm(String sszzjg) {
    String zzjgdmStr = "";
    try {
      conn = DBConnection.getZkConnection();
      if (sszzjg.equals("210200000000")) {
        zzjgdmStr = "210200000000";
      } else {
        String sql = "select * from org_organization where parentid='" + sszzjg + "' or ssjgdm='" + sszzjg + "'";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next())
          zzjgdmStr = zzjgdmStr + rs.getString("zzjgdm") + ",";

        zzjgdmStr = zzjgdmStr.substring(0, zzjgdmStr.length() - 1);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      try {
        conn.close();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }

      try
      {
        conn.close();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }

      try
      {
        conn.close();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
    finally
    {
      try
      {
        conn.close();
      }
      catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
    return zzjgdmStr;
  }

  public static String returnSqlStr(String zzjgStr, String queryLx, String kssj, String jssj, String zzjglx) {
    String sqlStr = "";
    String yearStr = kssj.split("-")[0];
    String yearEnd = jssj.split("-")[0];
    String kssj1 = String.valueOf(Integer.parseInt(yearStr) - 3) + "-" + kssj.split("-")[1] + "-" + kssj.split("-")[2] + " 00:00:00";
    String jssj1 = String.valueOf(Integer.parseInt(yearEnd) - 3) + "-" + jssj.split("-")[1] + "-" + jssj.split("-")[2] + " 23:59:59";
    String kssj2 = String.valueOf(Integer.parseInt(yearStr) - 2) + "-" + kssj.split("-")[1] + "-" + kssj.split("-")[2] + " 00:00:00";
    String jssj2 = String.valueOf(Integer.parseInt(yearEnd) - 2) + "-" + jssj.split("-")[1] + "-" + jssj.split("-")[2] + " 23:59:59";
    String kssj3 = String.valueOf(Integer.parseInt(yearStr) - 1) + "-" + kssj.split("-")[1] + "-" + kssj.split("-")[2] + " 00:00:00";
    String jssj3 = String.valueOf(Integer.parseInt(yearEnd) - 1) + "-" + jssj.split("-")[1] + "-" + jssj.split("-")[2] + " 23:59:59";
    String kssj4 = "";
    String jssj4 = "";
    if (queryLx.equals("0")) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date queryTimeStar = null;
      Date queryTimeEnd = null;
      try {
        queryTimeStar = formatter.parse(kssj + " 00:00:00");
        queryTimeEnd = formatter.parse(jssj + " 23:59:59");
        kssj4 = DateToString(new Date(queryTimeStar.getTime() - 604800000L));
        jssj4 = DateToString(new Date(queryTimeEnd.getTime() - 604800000L));
      }
      catch (ParseException e) {
        e.printStackTrace();
      }
    } else if (queryLx.equals("1")) {
      if ((kssj.split("-")[1].equals("1")) || (kssj.split("-")[1].equals("01")))
        kssj4 = String.valueOf(Integer.parseInt(kssj.split("-")[0]) - 1) + "-12-" + kssj.split("-")[2] + " 00:00:00";
      else
        kssj4 = kssj.split("-")[0] + "-" + String.valueOf(Integer.parseInt(kssj.split("-")[1]) - 1) + "-" + kssj.split("-")[2] + " 00:00:00";

      if ((jssj.split("-")[1].equals("1")) || (jssj.split("-")[1].equals("01")))
        jssj4 = String.valueOf(Integer.parseInt(jssj.split("-")[0]) - 1) + "-12-" + jssj.split("-")[2] + " 23:59:59";
      else
        jssj4 = jssj.split("-")[0] + "-" + String.valueOf(Integer.parseInt(jssj.split("-")[1]) - 1) + "-" + jssj.split("-")[2] + " 23:59:59";
    }
    else if (queryLx.equals("2")) {
      if ((kssj.split("-")[1].equals("3")) || (kssj.split("-")[1].equals("03")))
        kssj4 = String.valueOf(Integer.parseInt(kssj.split("-")[0]) - 1) + "-12-" + kssj.split("-")[2] + " 00:00:00";
      else
        kssj4 = kssj.split("-")[0] + "-" + String.valueOf(Integer.parseInt(kssj.split("-")[1]) - 3) + "-" + kssj.split("-")[2] + " 00:00:00";

      if ((jssj.split("-")[1].equals("3")) || (jssj.split("-")[1].equals("03")))
        jssj4 = String.valueOf(Integer.parseInt(jssj.split("-")[0]) - 1) + "-12-" + jssj.split("-")[2] + " 23:59:59";
      else
        jssj4 = jssj.split("-")[0] + "-" + String.valueOf(Integer.parseInt(jssj.split("-")[1]) - 3) + "-" + jssj.split("-")[2] + " 23:59:59";
    }
    else if (queryLx.equals("3")) {
      if ((kssj.split("-")[1].equals("6")) || (kssj.split("-")[1].equals("06")))
        kssj4 = String.valueOf(Integer.parseInt(kssj.split("-")[0]) - 1) + "-12-" + kssj.split("-")[2] + " 00:00:00";
      else
        kssj4 = kssj.split("-")[0] + "-" + String.valueOf(Integer.parseInt(kssj.split("-")[1]) - 6) + "-" + kssj.split("-")[2] + " 00:00:00";

      if ((jssj.split("-")[1].equals("6")) || (jssj.split("-")[1].equals("06")))
        jssj4 = String.valueOf(Integer.parseInt(jssj.split("-")[0]) - 1) + "-12-" + jssj.split("-")[2] + " 23:59:59";
      else
        jssj4 = jssj.split("-")[0] + "-" + String.valueOf(Integer.parseInt(jssj.split("-")[1]) - 6) + "-" + jssj.split("-")[2] + " 23:59:59";
    }
    else {
      kssj4 = String.valueOf(Integer.parseInt(kssj.split("-")[0]) - 1) + "-" + kssj.split("-")[1] + "-" + kssj.split("-")[2] + " 00:00:00";
      jssj4 = String.valueOf(Integer.parseInt(jssj.split("-")[0]) - 1) + "-" + jssj.split("-")[1] + "-" + jssj.split("-")[2] + " 23:59:59";
    }
    String kssj5 = "";
    String jssj5 = "";
    if (kssj.split("-")[0].equals(jssj.split("-")[0])) {
      kssj5 = String.valueOf(Integer.parseInt(kssj.split("-")[0]) - 2) + "-12-26 00:00:00";
      jssj5 = String.valueOf(Integer.parseInt(jssj.split("-")[0]) - 1) + "-12-25 23:59:59";
    } else {
      kssj5 = String.valueOf(Integer.parseInt(kssj.split("-")[0]) - 1) + "-12-26 00:00:00";
      jssj5 = String.valueOf(Integer.parseInt(jssj.split("-")[0]) - 1) + "-12-25 23:59:59";
    }
    String whereStr = "";
    if (zzjglx.equals("11"))
    {
      whereStr = " and substr(gxdwdm,0,6) =substr('" + zzjgStr + "',0,6)";
    }
    else whereStr = " and gxdwdm ='" + zzjgStr + "'";

    sqlStr = "select * from (select count(1) as a from jcj.jcj_jjxxb t1 where to_date(t1.bj_sj, 'YYYY-MM-DD hh24:mi-ss') > to_date('" + 
      kssj1 + "', 'YYYY-MM-DD hh24:mi-ss')" + 
      " and to_date(t1.bj_sj, 'YYYY-MM-DD hh24:mi-ss')  < to_date('" + jssj1 + "', 'YYYY-MM-DD hh24:mi-ss')" + whereStr + ") table1," + 
      "(select count(1) as b from jcj.jcj_jjxxb t2 where to_date(t2.bj_sj, 'YYYY-MM-DD hh24:mi-ss') > to_date('" + kssj2 + "', 'YYYY-MM-DD hh24:mi-ss')" + 
      " and to_date(t2.bj_sj, 'YYYY-MM-DD hh24:mi-ss') < to_date('" + jssj2 + "', 'YYYY-MM-DD hh24:mi-ss')" + whereStr + ") table2," + 
      "(select count(1) as c from jcj.jcj_jjxxb t3 where to_date(t3.bj_sj, 'YYYY-MM-DD hh24:mi-ss') > to_date('" + kssj3 + "', 'YYYY-MM-DD hh24:mi-ss')" + 
      " and to_date(t3.bj_sj, 'YYYY-MM-DD hh24:mi-ss') < to_date('" + jssj3 + "', 'YYYY-MM-DD hh24:mi-ss')" + whereStr + ") table3," + 
      "(select count(1) as d from jcj.jcj_jjxxb t4 where to_date(t4.bj_sj, 'YYYY-MM-DD hh24:mi-ss') > to_date('" + kssj4 + "', 'YYYY-MM-DD hh24:mi-ss')" + 
      " and to_date(t4.bj_sj, 'YYYY-MM-DD hh24:mi-ss') < to_date('" + jssj4 + "', 'YYYY-MM-DD hh24:mi-ss')" + whereStr + ") table4," + 
      "(select count(1) as e from jcj.jcj_jjxxb t5 where to_date(t5.bj_sj, 'YYYY-MM-DD hh24:mi-ss') > to_date('" + kssj5 + "', 'YYYY-MM-DD hh24:mi-ss')" + 
      " and to_date(t5.bj_sj, 'YYYY-MM-DD hh24:mi-ss') < to_date('" + jssj5 + "', 'YYYY-MM-DD hh24:mi-ss')" + whereStr + ") table5";
    System.out.println(sqlStr);
    return sqlStr;
  }

  public static String DateToString(Date dateStr) {
    DateFormat dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return dd.format(dateStr);
  }
  
  public static double  Sswl(double ss){
        BigDecimal b=new BigDecimal(ss);
	   double f1=b.setScale(2,RoundingMode.HALF_UP).doubleValue();  
	 
	  return f1;
  }
  
}