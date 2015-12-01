package com.founder.xjpt.cgsoft.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * 
 * @描述 数据获取demo
 * @类名 XJ_GPS_DEMO
 * @作者 常东旭
 * @创建时间 2014-9-18下午12:22:14
 * @修改人 修改人
 * @修改时间 2014-9-18下午12:22:14
 * @文件位置  项目XJ_GPS_DEMO,包cgsoft.demo,文件XJ_GPS_DEMO.java
 * @类功能 TODO
 *
 */
public class XJ_GPS_DEMO {
	private static String orgcode="210211000000";
	public static void main(String[] args) {
		Connection conn = XJ_GPS_DAO.getConnection();
		/**
		 * ORG_CODE IN VARCHAR2,	输入参数	组织结构代码
         * SYRK_NUM OUT NUMBER,		输出参数	实有人口数量
         * CZRK_NUM OUT NUMBER,		输出参数	常住人口数量
         * LDRK_NUM OUT NUMBER,		输出参数	流动人口数量
         * ZDRK_NUM OUT NUMBER,		输出参数	重点人口数量
         * ZJL_NUM OUT NUMBER,		输出参数	总警力（暂无）
         * XLJL_NUM OUT NUMBER,		输出参数	巡逻警力（暂无）
         * XLCL_NUM OUT NUMBER,		输出参数	巡逻车辆（暂无）
         * PCS_NUM OUT NUMBER,		输出参数	派出所数量
         * SQ_NUM OUT NUMBER,		输出参数	社区数量
         * XLLX_NUM OUT NUMBER,		输出参数	巡逻路线数量（暂无）
         * MJ_NUMBER OUT NUMBER,	输出参数	面积
         * 总计：12个		输入参数1个		输出参数11个   
		 */
		try {
			CallableStatement cs = conn.prepareCall("{call GET_DATA_PARAM(?,?,?,?,?,?,?,?,?,?,?,?)}");
			/**
			 *参数赋值 
			 */
			paramPrepare(cs);
			/**
			 * 执行获取返回值
			 */
			cs.execute();
			/**
			 * 顺序和参数顺序一样
			 */
			int SYRK_NUM = cs.getInt(2);    //实有人口数量
			int CZRK_NUM = cs.getInt(3);	//常住人口数量
			int LDRK_NUM = cs.getInt(4);	//流动人口数量
			int ZDRK_NUM = cs.getInt(5);	//重点人口数量
			int ZJL_NUM = cs.getInt(6);		//总警力（暂无）
			int XLJL_NUM = cs.getInt(7);	//巡逻警力（暂无）
			int XLCL_NUM = cs.getInt(8);	//巡逻车辆（暂无）
			int PCS_NUM = cs.getInt(9);		//派出所数量
			int SQ_NUM = cs.getInt(10);		//社区数量
			int XLLX_NUM = cs.getInt(11);	//巡逻路线
			//面积值可能含有小数，单位平方公里
			Float MJ_NUM = cs.getFloat(12);	//面积
			
			/**
			 * 输出值
			 */
			System.out.println("实有人口："+SYRK_NUM);
			System.out.println("常住人口："+CZRK_NUM);
			System.out.println("流动人口："+LDRK_NUM);
			System.out.println("重点人口："+ZDRK_NUM);
			System.out.println("总警力："+ZJL_NUM);
			System.out.println("巡逻警力："+XLJL_NUM);
			System.out.println("巡逻车辆："+XLCL_NUM);
			System.out.println("派出所数量："+PCS_NUM);
			System.out.println("巡逻路线："+XLLX_NUM);
			System.out.println("面积："+MJ_NUM);
		
			
			
			
			
		} catch (SQLException e) {
			// 存储过程调用异常
			e.printStackTrace();
		}
	}
	private static void paramPrepare(CallableStatement cs) throws SQLException {
		/**
		 * 输入参数赋值
		 */
		cs.setString(1, orgcode);
		/**
		 * 输出参数赋类型
		 */
		cs.registerOutParameter(2,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(3,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(4,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(5,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(6,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(7,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(8,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(9,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(10,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(11,oracle.jdbc.OracleTypes.NUMBER);
		cs.registerOutParameter(12,oracle.jdbc.OracleTypes.NUMBER);
	}
}
