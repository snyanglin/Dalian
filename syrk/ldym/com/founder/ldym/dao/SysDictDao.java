package com.founder.ldym.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.ldym.pojo.SysDict;
import com.founder.ldym.util.StringUtil;
import com.founder.ldym.util.SystemConfig;


/**
 * 
 * <p>标题：字典持久层</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-3-12</p>
 * @author	yi_chu
 */
@Repository("dictDao")
public class SysDictDao extends BaseDaoImpl {

	/**
	 * 
	 * <p>说明： 查询一个字典编号的所有字典项</p>
	 * <p>时间：2014-3-12 上午11:03:03</p>
	 * @param zdbh 字典编号（字典表名）
	 * @return list
	 */
	public List<SysDict> findAllList(String zdbh) {
		String sql="";
		if ("D_XQLX".equals(zdbh)){
		  sql = "select * from T_SYS_DICT where ZDBH='"
				+ StringUtil.getSqlExpression(zdbh) + "' and XT_ZXBZ='0' order by p_id";
		}
		else{
			sql = "select * from T_SYS_DICT where ZDBH='"
					+ StringUtil.getSqlExpression(zdbh) + "' and XT_ZXBZ='0' order by dm";
		}
//		System.out.print(sql); 
		return super.queryForList(sql, SysDict.class);
	}
	/**
	 * 
	 * @param zdbh
	 * @return
	 * zdbh相当于小组类型
	 */
//	public List<SysDict> getXzmc(String zdbh,User user) {
//		
//		String sql="select id,xzmc from T_QWGL_PZGL_XLXZ t,(select zzjgdm from t_zzjg t start with t.zzjgdm='"+user.getYwjgdm()+"' connect by prior t.zzjgdm=t.ssjgdm) f" +
//				" where xztypedm='"+zdbh+"' and t.orgid=f.zzjgdm  order by id";
//		List<Map<String,Object>> list=super.queryForMapList(sql);
//		List<SysDict> listdict=new ArrayList<SysDict>();
//		for(int i=0;i<list.size();i++) {
//			SysDict sd=new SysDict();
//			sd.setDm(list.get(i).get("ID").toString());
//			sd.setCt(list.get(i).get("XZMC").toString());
//			listdict.add(sd);
//		}
//		return listdict;
//	}
	/**
	 * 查询报警类型
	 * @return
	 */
//	public  List<SysDict> getBjlx() {
//		String sql="select STATUSID,STATUSNAME from T_GPS_STATUS where 1=1";
//		List<Map<String,Object>> list=super.queryForMapList(sql);
//		List<SysDict> listdict=new ArrayList<SysDict>();
//		for(int i=0;i<list.size();i++) {
//			SysDict sd=new SysDict();
//			sd.setDm(list.get(i).get("STATUSID").toString());
//			sd.setCt(list.get(i).get("STATUSNAME").toString());
//			listdict.add(sd);
//		}
//		return listdict;
//	}
	/**
	 * 
	 * <p>说明： 根据sql查询字典数据</p>
	 * <p>时间：2014-8-4 上午11:03:03</p>
	 * @param sql 查询sql完整语句
	 * @return objectArray 传入的参数
	 */
	public List<SysDict> findAllListBySql(String sql, Object[] objectArray) {
//		if (null == objectArray)
//		{
			//System.out.println(sql);
			return super.queryForList(sql, SysDict.class);
//		}
//		else 
//		{
//			return super.queryForList(sql, SysDict.class, objectArray);
//		}
	}
	
	/**
	 * 
	 * <p>说明： 查询一个字典编号的所有字典项(自定义排序)</p>
	 * <p>时间：2014-3-12 上午11:03:03</p>
	 * @param zdbh 字典编号（字典表名）
	 * @param orderBy 排序语句
	 * @return list
	 */
	public List<SysDict> findAllList(String zdbh,String orderBy) {
		String sql = "select * from T_SYS_DICT where ZDBH='"
				+ StringUtil.getSqlExpression(zdbh) + "' and XT_ZXBZ='0' " + orderBy;
		return super.queryForList(sql, SysDict.class);
	}
	
	/**
	 * <p>说明：获取警情类别字典项</p>
	 * <p>时间：2014-4-1 下午5:09:41</p>
	 * @param zdbh   字典编号
	 * @param dm     选项代码
	 * @param count  标记
	 * @return 字典列表
	 */
	public List<SysDict> findAllList(String zdbh, String dm, int count) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT T.*  FROM T_SYS_DICT T WHERE T.ZDBH = '").append(zdbh).append("' ");
		String zddm = dm;
		if (count == 1) {
			builder.append("AND t.DM LIKE '%0000' ");
		} else if (count == 2) {
			if (!StringUtil.isEmpty(zddm)) {
				zddm = zddm.substring(0, zddm.length() - count);
			}
			builder.append("AND t.DM LIKE '%00' AND T.DM NOT LIKE '%0000' ");
		} else {
			if (!StringUtil.isEmpty(zddm)) {
				zddm = zddm.substring(0, zddm.length() - (count - 1));
			}
			builder.append("AND T.DM LIKE '" + zddm + "%' AND t.DM NOT LIKE '%00' ");
		}
		builder.append("ORDER BY T.DM ASC");
		return super.queryForList(builder.toString(), SysDict.class);
	}
	
	/**
	 * 
	 * <p>说明： 查询一个字典编号的所有字典项</p>
	 * <p>时间：2014-3-12 上午11:03:03</p>
	 * @param zdbh 字典编号（字典表名）
	 * @param xzqh 行政区划
	 * @param databaseUsername 数据库用户名
	 * @return list
	 */
	public List<SysDict> findAllDlList(String zdbh, String xzqh, String databaseUsername) {
		String sql = "select DLDM as DM, DLMC as CT, F_GETPYSZM(DLMC) as PY, GLBM || ',' || XZQH || ',' || F_GETWBSZM(DLMC) as WB from " + databaseUsername + "." + StringUtil.getSqlExpression(zdbh) + " where XZQH like '%" + StringUtil.getSqlExpression(xzqh) + "%'";
		return super.queryForList(sql, SysDict.class);
	}
	
	/**
	 * 
	 * <p>说明： 查询一个字典编号的所有字典项，根据行政区划</p>
	 * <p>时间：2014-3-12 上午11:03:03</p>
	 * @param zdbh 字典编号（字典表名）
	 * @param dldm 行政区划
	 * @param databaseUsername 数据库用户名
	 * @return list
	 */
	public List<SysDict> findAllLdList(String zdbh, String dldm, String databaseUsername) {
		String sql = "select LDDM as DM, LDMC as CT, F_GETPYSZM(LDMC) as PY, GLBM || ',' || DLDM || ',' || F_GETWBSZM(LDMC) as WB from " + databaseUsername + "." + StringUtil.getSqlExpression(zdbh);
		if (null != dldm && !"".equals(dldm.trim()))
		{
			sql = sql + " where DLDM = '" + StringUtil.getSqlExpression(dldm) + "'";
		}
		return super.queryForList(sql, SysDict.class);
	}
	
	/**
	 * 获取GPS重点监控车辆类型
	 * @param zdbh 字典编号
	 * @returnList<SysDict>
	 */
	public List<SysDict> getGpsCarTypeDictList(String zdbh){
		String sql = "select dm,ct,py from T_GPS_CARTYPE where zdbh = '" + zdbh + "'";
		return super.queryForList(sql, SysDict.class);
	}
	
	
	/**
	 * <p>说明：根据行政区划获取道路代码</p>
	 * <p>时间：2014-4-10 下午5:34:54</p>
	 * @param zdbh 字典名称
	 * @param xzqh 行政区划
	 * @param dbus 查询用户
	 * @return 路段信息
	 */
	public List<SysDict> findLdByXzqh(String zdbh, String xzqh, String dbus) {
		StringBuilder sqlBuilder = new StringBuilder(500);
		sqlBuilder.append("SELECT LD.LDDM AS DM, LD.LDMC AS CT, F_GETPYSZM(LD.LDMC) AS PY, LD.GLBM || ',' || LD.DLDM || ',' || F_GETWBSZM(LD.LDMC) AS WB FROM  ");
		sqlBuilder.append(dbus).append(".JT_ROADSEGITEM_PL LD, ").append(dbus).append(".JT_ROADITEM_PL DL");
		sqlBuilder.append(" WHERE LD.DLDM = DL.DLDM AND DL.XZQH LIKE '%").append(xzqh).append("%'");
		return super.queryForList(sqlBuilder.toString(), SysDict.class);
	}
	
	/**
	 * 
	 * <p>说明： 查询一个字典编号的所有字典项（用于生成列表JS）</p>
	 * <p>时间：2014-3-28上午16:59:59</p>
	 * @param zdbh 字典编号（字典表名）
	 * @param databaseUsername 数据库用户名
	 * @param xzqh 行政区划
	 * @param dldm 道路代码
	 * @return list
	 */
	public List<SysDict> findAllList(String zdbh, String databaseUsername, String xzqh, String dldm) {
		String sql = null;
		if (!StringUtil.isEmpty(xzqh) && StringUtil.isEmpty(dldm)) {// 查询道路
			sql = "select DLDM as DM, DLMC as CT, F_GETPYSZM(DLMC) as PY, GLBM || ',' || XZQH || ',' || F_GETWBSZM(DLMC) as WB from " + databaseUsername + "." + StringUtil.getSqlExpression(zdbh) + " where XZQH = '" + StringUtil.getSqlExpression(xzqh) + "'";
		} else if (StringUtil.isEmpty(xzqh) && !StringUtil.isEmpty(dldm)) {// 查询路段
			sql = "select LDDM as DM, LDMC as CT, F_GETPYSZM(LDMC) as PY, GLBM || ',' || DLDM || ',' || F_GETWBSZM(LDMC) as WB from " + databaseUsername + "." + StringUtil.getSqlExpression(zdbh) + " where DLDM = '" + StringUtil.getSqlExpression(dldm) + "'";
		}
		
		return super.queryForList(sql, SysDict.class);
	}
	
	/**
	 * 
	 * <p>说明：根据自定义的SQL语句查询出字典对象数组（用于生成定制的JS文件）</p>
	 * <p>时间：2014-3-12 下午3:12:59</p>
	 * @param querySql 查询sql
	 * @return list
	 */
	public List<SysDict> findDictForCustomize(String querySql) {
//		//System.out.print(querySql);
		return super.queryForList(querySql, SysDict.class);
	}
	
	/**
	 * 
	 * <p>说明：根据自定义的SQL语句统计字典是否存在（用于生成树形JS）</p>
	 * <p>时间：2014-3-12 下午2:52:41</p>
	 * @param querySql 查询sql
	 * @return boolean
	 */
	public boolean isExistDictForCustomize(String querySql) {
//		int count = super.queryForInt(querySql);
//		if (count > 0) {
			return true;
//		} else {
//			return false;
//		}
	}
	
	/**
	 * 
	 * <p>说明：根据自定义的SQL语句查询出组织机构字典对象集合（用于生成定制的JS文件）</p>
	 * <p>时间：2014-3-12 下午3:12:59</p>
	 * @param zzjgdm 组织机构代码
	 * @param auth 权限
	 * @param userId 用户登录ID
	 * @return list  v3222
	 */
	public List<SysDict> findOrganizationDictForCustomize(String zzjgdm, String auth, String userId) {
		StringBuilder builder = new StringBuilder();
		if ("1".equals(auth)) {
			builder.append("SELECT T.* FROM (");
			builder.append("SELECT ZZJGDM as dm, ZZJGMC as ct, F_GETPYSZM(ZZJGMC) as py, F_GETWBSZM(ZZJGMC) as wb, LEVEL as treeLevel, SSJGDM as parentDm, CONNECT_BY_ISLEAF as isTreeLeaf, ZZJGLX, NO FROM T_ZZJG");
			builder.append(" WHERE SFYX = '1' AND JGLX = 3");
			builder.append(" START WITH ZZJGDM = '" + zzjgdm + "'");
			builder.append(" CONNECT BY PRIOR ZZJGDM = SSJGDM and (ZZJGMC like '%支队' or ZZJGMC like '%大队')");
			builder.append(") T");
			builder.append(" WHERE T.DM in(");
			/*builder.append("SELECT distinct ZZJGDM FROM T_ZZJG");
			builder.append(" WHERE SFYX = '1' AND JGLX = 3");
			builder.append(" START WITH ZZJGDM in(SELECT ZZJGDM FROM (SELECT t1.USERID, t2.ZZJGDM from M_USER_ROLE t1, M_ROLE_PROPERTY t2 where t1.ROLEID = t2.ROLEID union SELECT * FROM M_USER_PROPERTY) WHERE USERID = '" + userId + "')");
			builder.append(" CONNECT BY PRIOR ZZJGDM = SSJGDM and (ZZJGMC like '%支队' or ZZJGMC like '%大队' or ZZJGMC like '%中队')");
			builder.append(" UNION ");*/
			builder.append("SELECT distinct ZZJGDM FROM T_ZZJG");
			builder.append(" WHERE SFYX = '1' AND JGLX = 3");
			builder.append(" START WITH ZZJGDM in(SELECT ZZJGDM FROM (select t3.* from (SELECT t1.USERID, t2.ZZJGDM from M_USER_ROLE t1, M_ROLE_PROPERTY t2 where t1.ROLEID = t2.ROLEID union SELECT * FROM M_USER_PROPERTY) t3, T_ZZJG t4 WHERE t3.ZZJGDM = t4.ZZJGDM and (t4.ZZJGMC like '%支队' or t4.ZZJGMC like '%大队')) WHERE USERID = '" + userId + "')");
			builder.append(" CONNECT BY PRIOR SSJGDM = ZZJGDM and (ZZJGMC like '%支队' or ZZJGMC like '%大队')");
			builder.append(")");
			builder.append(" ORDER BY T.ZZJGLX ASC, T.DM ASC, T.NO ASC");
		} else if("9".equals(auth)){
			builder.append("SELECT T.ZZJGDM as dm, T.ZZJGLX as bz, T.ZZJGMC as ct, F_GETPYSZM(T.ZZJGMC) as py, F_GETWBSZM(T.ZZJGMC) as wb, LEVEL as treeLevel, T.SSJGDM as parentDm, CONNECT_BY_ISLEAF as isTreeLeaf");
			builder.append(" FROM T_ZZJG T WHERE T.SFYX = '1'");
			builder.append(" START WITH T.ZZJGDM = '" + zzjgdm + "'");
			builder.append(" CONNECT BY PRIOR T.ZZJGDM = T.SSJGDM");
			builder.append(" ORDER BY T.ZZJGLX ASC, T.ZZJGDM ASC, T.NO ASC");
		}else if("10".equals(auth)){
			builder.append("SELECT T.ZZJGDM as dm, T.ZZJGMC as ct, F_GETPYSZM(T.ZZJGMC) as py, F_GETWBSZM(T.ZZJGMC)||'_'||T.ZZJGLX as wb, LEVEL as treeLevel, T.SSJGDM as parentDm, CONNECT_BY_ISLEAF as isTreeLeaf");
			builder.append(" FROM T_ZZJG T WHERE T.SFYX = '1' and JGLX = 3");
			builder.append(" START WITH T.ZZJGDM = '" + zzjgdm + "'");
			builder.append(" CONNECT BY PRIOR T.ZZJGDM = T.SSJGDM");
			builder.append(" ORDER BY T.ZZJGLX ASC, T.ZZJGDM ASC, T.NO ASC");
		}
		else if("11".equals(auth)){
			builder.append("SELECT T.* FROM (");
			builder.append("SELECT ZZJGDM as dm, ZZJGMC as ct, F_GETPYSZM(ZZJGMC) as py, F_GETWBSZM(ZZJGMC)||'_'|| ZZJGLX as wb, LEVEL as treeLevel, SSJGDM as parentDm, CONNECT_BY_ISLEAF as isTreeLeaf, ZZJGLX, NO FROM T_ZZJG");
			builder.append(" WHERE SFYX = '1' AND JGLX = 3");
			builder.append(" START WITH ZZJGDM = '" + zzjgdm + "'");
			builder.append(" CONNECT BY PRIOR ZZJGDM = SSJGDM and (ZZJGMC like '%支队' or ZZJGMC like '%大队')");
			builder.append(") T");
			builder.append(" WHERE T.DM in(");
			builder.append("SELECT distinct ZZJGDM FROM T_ZZJG");
			builder.append(" WHERE SFYX = '1' AND JGLX = 3");
			builder.append(" START WITH ZZJGDM in(SELECT ZZJGDM FROM (select t3.* from (SELECT t1.USERID, t2.ZZJGDM from M_USER_ROLE t1, M_ROLE_PROPERTY t2 where t1.ROLEID = t2.ROLEID union SELECT * FROM M_USER_PROPERTY) t3, T_ZZJG t4 WHERE t3.ZZJGDM = t4.ZZJGDM and (t4.ZZJGMC like '%支队' or t4.ZZJGMC like '%大队')) WHERE USERID = '" + userId + "')");
			builder.append(" CONNECT BY PRIOR SSJGDM = ZZJGDM and (ZZJGMC like '%支队' or ZZJGMC like '%大队')");
			builder.append(")");
			builder.append(" ORDER BY T.ZZJGLX ASC, T.DM ASC, T.NO ASC");
		}
		else {
			builder.append("SELECT T.ZZJGDM as dm, T.ZZJGMC as ct, F_GETPYSZM(T.ZZJGMC) as py, F_GETWBSZM(T.ZZJGMC) as wb, LEVEL as treeLevel, T.SSJGDM as parentDm, CONNECT_BY_ISLEAF as isTreeLeaf");
			builder.append(" FROM T_ZZJG T WHERE T.SFYX = '1' ");
			builder.append(" START WITH T.ZZJGDM = '" + zzjgdm + "'");
			builder.append(" CONNECT BY PRIOR T.ZZJGDM = T.SSJGDM ");
			builder.append(" ORDER BY T.ZZJGLX ASC, T.ZZJGDM ASC, T.NO ASC");
		}
		
		return super.queryForList("Ldym.findDictList", builder.toString());
	}
	
	/**
	 * 
	 * <p>说明：根据自定义的SQL语句查询出GPS组织机构字典对象集合（用于生成定制的JS文件）</p>
	 * <p>时间：2014-3-12 下午3:12:59</p>
	 * @param zzjgdm 组织机构代码
	 * @return list
	 */
	public List<SysDict> findGpsDictForCustomize(String zzjgdm) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT T.orgid as dm, T.orgname as ct, F_GETPYSZM(T.orgname) as py, F_GETWBSZM(T.orgname) as wb, LEVEL as treeLevel, nvl(T.PARENTID, T.ORGID) as parentDm, ORGCODE|| ';' ||(SELECT P.ZZJGMC FROM T_ZZJG P WHERE P.ZZJGDM = ORGCODE)||';'|| NO||';'|| PARENTID  AS bz,CONNECT_BY_ISLEAF as isTreeLeaf");
		builder.append(" FROM t_gps_zzjg T");
		/**modify by guobing 20141017  */
		//builder.append(" START WITH T.orgid = '"+zzjgdm+"'");
		builder.append(" START WITH T.orgcode = '"+zzjgdm+"'");
		
		builder.append(" CONNECT BY PRIOR T.orgid = T.PARENTID  ORDER BY TREELEVEL ASC,T.NO ASC");
		return super.queryForList(builder.toString(), SysDict.class);
	}

	/**
	 * 
	 * <p>说明：根据自定义的SQL语句查询出组织机构字典对象集合（用于生成定制的JS文件）</p>
	 * <p>时间：2014-3-12 下午3:12:59</p>
	 * @param zzjgdm 组织机构代码
	 * @return list
	 */
	public List<SysDict> findAuthorityOrganizationDictForCustomize(String zzjgdm,List<String> list) {
		StringBuilder builder = new StringBuilder();
		if(list.isEmpty()){
			builder.append(" SELECT * FROM (SELECT T.ZZJGDM as dm, T.ZZJGMC as ct, F_GETPYSZM(T.ZZJGMC) as py, F_GETWBSZM(T.ZZJGMC) as wb, LEVEL as treeLevel, T.SSJGDM as parentDm, CONNECT_BY_ISLEAF as isTreeLeaf");
			builder.append(" FROM T_ZZJG T WHERE T.SFYX = '1' AND T.JGLX = 3");
			builder.append(" START WITH T.ZZJGDM = '" + zzjgdm + "'");
			builder.append(" CONNECT BY PRIOR T.ZZJGDM = T.SSJGDM");
			builder.append(" ORDER BY T.ZZJGDM ASC, T.NO ASC)");
		}else{
			builder.append(" SELECT * FROM (SELECT T.ZZJGDM as dm, T.ZZJGMC as ct, F_GETPYSZM(T.ZZJGMC) as py, F_GETWBSZM(T.ZZJGMC) as wb, LEVEL as treeLevel, T.SSJGDM as parentDm, CONNECT_BY_ISLEAF as isTreeLeaf");
			builder.append(" FROM T_ZZJG T WHERE T.SFYX = '1' AND T.JGLX = 3");
			builder.append(" START WITH T.ZZJGDM = '" + zzjgdm + "'");
			builder.append(" CONNECT BY PRIOR T.ZZJGDM = T.SSJGDM");
			builder.append(" ORDER BY T.ZZJGDM ASC, T.NO ASC)");
			for(String propertydm:list){
				builder.append(" union all  SELECT * FROM (SELECT T.ZZJGDM as dm, T.ZZJGMC as ct, F_GETPYSZM(T.ZZJGMC) as py, F_GETWBSZM(T.ZZJGMC) as wb, LEVEL as treeLevel, T.SSJGDM as parentDm, CONNECT_BY_ISLEAF as isTreeLeaf");
				builder.append(" FROM T_ZZJG T WHERE T.SFYX = '1' AND T.JGLX = 3");
				builder.append(" START WITH T.ZZJGDM = '" + propertydm + "'");
				builder.append(" CONNECT BY PRIOR T.ZZJGDM = T.SSJGDM");
				builder.append(" ORDER BY T.ZZJGDM ASC, T.NO ASC)");
			}
		}
		return super.queryForList(builder.toString(), SysDict.class);
	}
	
	
	/**
	 * 
	 * <p>说明：根据自定义的SQL语句查询出资源管理图层树形字典对象集合（用于生成定制的JS文件）</p>
	 * <p>时间：2014-3-12 下午3:12:59</p>
	 * @param zzjgdm 组织机构代码
	 * @return list
	 */
	public List<SysDict> findZyglDictForCustomize(String zzjgdm,String layerType) {
		StringBuilder builder = new StringBuilder();
		String dbUser = SystemConfig.getString("EZSPATIAL_DB_USERNAME");
		builder.append("SELECT  T.CODE AS DM,T.CHNAME AS CT,  F_GETPYSZM(T.CHNAME) AS PY,F_GETWBSZM(T.CHNAME) AS WB,LEVEL AS TREELEVEL, T.PARENT AS PARENTDM,T. ID ||';' ||T. ENNAME||';' ||T. LAYERTYPE  AS bz ,CONNECT_BY_ISLEAF AS ISTREELEAF");
		builder.append(" FROM ").append(dbUser).append(".EZ_STD_LAYERS_LAYER T ");
//		if ("PT".equals(layerType)) {
//	    builder.append(" WHERE T.layerType='"+layerType+"'");
//		}
		builder.append(" START WITH T.CODE in ("+zzjgdm+")");
		builder.append(" CONNECT BY PRIOR T.CODE = T.PARENT ORDER BY T.ID  ASC, T.SEQUENCE ASC");
		System.out.print(builder.toString());
		return super.queryForList(builder.toString(), SysDict.class);
	}
	
	/**
	 * 获得表字段的字典对象
	 * @param table 表
	 * @return List<SysDict>
	 */
	public List<SysDict> getTableColumnSysDict(String table){
		String sql = " select * from " + table;
		RowCountCallbackHandler rcch = new RowCountCallbackHandler();
//		jdbcTemplate.query(sql,rcch);
		String[] coloumnArray =rcch.getColumnNames();
		List<SysDict> sysDictList = new ArrayList<SysDict>();
		for (String column : coloumnArray)
		{
			SysDict sysDict = new SysDict();
			sysDict.setDm(column);
			sysDict.setCt(column);
			sysDictList.add(sysDict);
		}
		return sysDictList;
	}
	
	/**
	 * 智能交管用户下所有表的字典
	 * @return List<SysDict>
	 */
	public List<SysDict> getTableNameFromOwner(){
		String sql = "select table_name dm,table_name ct from user_tables";
		return super.queryForList(sql, SysDict.class);
	}
	
	/**
	 * 智能交管用户下所有表的字典
	 * @return List<SysDict>
	 */
	public List<SysDict> getViewNameFromOwner(){
		String sql = "select view_name dm,view_name ct from user_views";
		return super.queryForList(sql, SysDict.class);
	}
	
	/**
	 * 检查字典查询sql语句合法性
	 * @param sql  sql语句
	 * @return ResponseEntity<String>
	 */
	public void checkSql(String sql){
		super.queryForList(sql, SysDict.class);
	}
}