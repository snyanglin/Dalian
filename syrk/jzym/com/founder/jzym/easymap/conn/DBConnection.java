package com.founder.jzym.easymap.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection
{
  private static String driver = "oracle.jdbc.driver.OracleDriver";
  private static String url1 = "jdbc:oracle:thin:@10.80.8.175:1521:ORADB";
  private static String username3 = "jwzh";
  private static String password3 = "jwzh";

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

 public static Connection getZkConnection() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url1, username3, password3);
      System.out.println("实例DataBaseConnection，连接为:" + conn);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return conn; 
    }


}