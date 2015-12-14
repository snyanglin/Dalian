package com.founder.xjpt.easymap.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection
{
  private static String driver = "oracle.jdbc.driver.OracleDriver";
  private static String url = "jdbc:oracle:thin:@10.80.1.186:1521:ORADB1";
  private static String username = "DLEZGADATA";
  private static String password = "DATA01_18";
  private static String username1 = "DLEZGABUILDER";
  private static String password1 = "BUILD02_18";
  private static String username2 = "gis210200000000";
  private static String password2 = "SHAN2014_OK";

  public static Connection getConnection()
    throws Exception
  {
    Context ctx = new InitialContext();
    if (ctx == null)
      throw new Exception("Context is null.");

    DataSource ds = (DataSource)ctx.lookup("jdbc/ora/gpsinfo");
    if (ds == null)
      throw new Exception("DataSource is null.");

    Connection conn = ds.getConnection();
    if (conn.isClosed()) {
      throw new Exception("Jndi Connection is closed.");
    }

    System.out.println("Jndi Connection Succeed!");

    return conn;
  }

  public static Connection getZlConnection()
  {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, username, password);
      System.out.println("实例DataBaseConnection，连接为:" + conn);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }

  public static Connection getZkConnection() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, username1, password1);
      System.out.println("实例DataBaseConnection，连接为:" + conn);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return conn; }

  public static Connection getFkConnection() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, username2, password2);
      System.out.println("实例DataBaseConnection，连接为:" + conn);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }
}