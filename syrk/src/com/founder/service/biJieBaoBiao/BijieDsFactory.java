package com.founder.service.biJieBaoBiao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import bios.report.api.factory.DataSourceFactoryAdapter;
import bios.report.api.usermodel.DataSourceEntity;
/**
 * @类名: MyDsFactory 
 * @描述: 皕杰报表连接数据源工厂类
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2013-8-29 上午10:51:32 
 */
public class BijieDsFactory extends DataSourceFactoryAdapter {
	private static String url;
	private static String username;
	private static String password;
	public DataSourceEntity getDbDataSource(String dsName) {
		//自定义获取数据库连接
		Connection conn = getConnection(dsName); 
		if(conn != null)
			return DataSourceEntity.createDbDataSource(conn, "GBK", DataSourceEntity.DBTYPE_ORACLE);
		return null;
	}
	/**
	 * @Title: getConnection 
	 * @描述: 根据数据源名称，获取数据库连接
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-8-15 下午7:55:19 
	 * @返回值: Connection    返回类型 
	 * @throws
	 */
	private Connection getConnection(String dataSourceName){
		//创建properties文件
		Properties props = new Properties();
	    try {
			props.load(BijieDsFactory.class.getClassLoader().getResourceAsStream("resources.properties"));
			url = props.getProperty("oracle.url");
			username = props.getProperty("oracle.username");
			password = props.getProperty("oracle.password");
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}