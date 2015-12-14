package com.founder.xjpt.com.founder.noreas.conn;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@10.80.1.186:1521:ORADB1";
	private static String username = "GIS210200000000";
	private static String password = "SHAN2014_OK";
	
	private static String jzurl = "jdbc:oracle:thin:@10.80.8.175:1521:ORADB";
	private static String jzusername = "jwzh";
	private static String jzpassword = "jwzh";

	/**
	 * 获取数据库链接
	 * 
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Context ctx = (Context) new InitialContext();
		if (ctx == null) {
			throw new Exception("Context is null.");
		}
		DataSource ds = (DataSource) ctx.lookup("jdbc/hebgb");
		if (ds == null) {
			throw new Exception("DataSource is null.");
		}
		Connection conn = ds.getConnection();
		if (conn.isClosed()) {
			throw new Exception("Jndi Connection is closed.");
		} else {
//			System.out.println("Jndi Connection Succeed!");
		}
		return conn;
	}

	/**
	 * 获取数据库链接-直连模式
	 * 
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getJDBConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			// System.out.println("实例DataBaseConnection，连接为:" + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getJWZHConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(jzurl, jzusername, jzpassword);
			// System.out.println("实例DataBaseConnection，连接为:" + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
