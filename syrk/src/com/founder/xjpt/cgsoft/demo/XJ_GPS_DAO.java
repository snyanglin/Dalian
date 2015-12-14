package com.founder.xjpt.cgsoft.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class XJ_GPS_DAO {

	private static String className="";
	private static String url="";
	private static String userName="";
	private static String password="";
	
	private static Properties p = new Properties();
	
	private static ThreadLocal<Connection> connections = new ThreadLocal<Connection>();

	static{ 
		try {
			InputStream in = XJ_GPS_DAO.class.getResourceAsStream("/Config.properties");
			p.load(in);
			className = p.getProperty("oracle.driverClassName");
			url = p.getProperty("oracle.url");
			userName = p.getProperty("oracle.username");
			password = p.getProperty("oracle.password");
			Class.forName(className);
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	

	public static Connection getConnection(){
		Connection conn = connections.get();
		if (conn==null) {
			connections.set(getcon());
			conn = connections.get();
		}
		return conn;
	}

	private static Connection getcon(){
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean closeConnnection(){
		Connection con = connections.get();
		if (con==null) {
			return true;
		}else{
			try {
				con.close();
				connections.set(null);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	
	
}
