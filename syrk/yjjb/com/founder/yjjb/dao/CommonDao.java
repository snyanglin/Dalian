package com.founder.yjjb.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.sql.CLOB;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.ComboBox;
import com.founder.syrkgl.bean.RyRyjbxxb;
/**
 * 通用方法
 * @author Administrator
 *
 */
@Repository("commonDao")
public class CommonDao extends BaseDaoImpl{
	
	/**
	 * 分局和派出所下级单位列表</br>
	 * @param orgCode
	 * @return
	 * @since 2014-11-26
	 */
	public List<ComboBox> searchOrgListLower(String orgCode) {
		
		return super.queryForList("Common.searchOrgListLower",orgCode);
	}
	
	/**
	 * 分局和公安局下级单位列表</br>
	 * @param orgCode
	 * @return
	 * @since 2014-11-26
	 */
	public List<ComboBox> searchOrgListHigher(String orgCode) {
		
		return super.queryForList("Common.searchOrgListHigher",orgCode);
	}
	/**
	 * 单位列表</br>
	 * @param orgCode
	 * @return
	 * @since 2014-11-26
	 */
	public List<ComboBox> searchOrgListChildren(String orgCode) {
		
		return super.queryForList("Common.searchOrgListChildren",orgCode);
	}
	
	/**
	 * 单位列表</br>
	 * @param orgCode
	 * @return
	 * @since 2014-11-26
	 */
	public List<ComboBox> searchOrgList(String orgCode) {
		Map map = new HashMap() ;
		if(orgCode!=null && "".equals(orgCode.trim())) orgCode=null;
		map.put("orgCode", orgCode);
		return super.queryForList("Common.searchOrgList", map);
	}
	
	/**
	 * 查询上级
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public String queryUpOrgID(String orgcode){
		
		return (String)super.queryForObject("Common.queryUpOrgID", orgcode);
	}
	
	/**
	 * 查询机构名称
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public String queryNameOrgID(String orgcode){
		
		return (String)super.queryForObject("Common.queryNameOrgID", orgcode);
	}
	
	/**
	 * 根据用户ID查询用户名称
	 * @param entity
	 * @return
	 * @since 2014-12-08
	 */
	public String queryUserNameByUserId(String userId){
		
		return (String)super.queryForObject("Common.queryUserNameByUserId", userId);
	}
	
	/**
	 * 根据orgcode获取orglevel 02-支队 10-中心 21-分局</br>
	 * 根据orgcode和orglevel获取下级单位
	 * @param orgCode,orglevel
	 * @return
	 * @since 2014-12-02
	 */
	public List<ComboBox> queryDownOrg(String orgcode, String orglevel){
		
		if (orglevel.equals("02")) {
			
			return super.queryForList("Common.queryDownOrg01", orgcode);
		} else if(orglevel.equals("21")){
			
			return super.queryForList("Common.queryDownOrg02", orgcode);
		} else {
			
			return super.queryForList("Common.queryDownOrg00", orgcode);
		}
		
	}
	
	/**
	 * 根据地址查询派出所
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public String queryPcsByDZID(String dzid){
		
		return (String)super.queryForObject("Common.queryPcsByDZID", dzid);
	}
	
	/**
	 * 根据地址查询派出所
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public String createNewSeq(String type,String orgcode){

		Map<String,String> map = new HashMap<String,String>() ;
		map.put("type", type);
		map.put("orgcode", orgcode);
		return (String)super.queryForObject("Common.createNewSeq", map);
	}
	
	/**
	 * 递转申请的接收单位列表</br>
	 * @param orgCode
	 * @return
	 * @since 2014-11-27
	 */
	public List<ComboBox> myOrg(String type) {
		
		if (type.equals("DZSQ")) {
			
			return super.queryForList("Common.myOrgOfDZSQ",type);
		}else if (type.equals("DZSP")) {
			
			return super.queryForList("Common.myOrgOfDZSP",type);
		}else if (type.equals("ZCSQ")) {
			
			return super.queryForList("Common.myOrgOfZCSQ",type);
		}else if (type.equals("ZCSPSQ")) {
			
			return super.queryForList("Common.myOrgOfZCSPSQ",type);
		}else if (type.equals("JBJLSQ")) {
			
			return super.queryForList("Common.myOrgOfJBJLSQ",type);
		}else if (type.equals("JBJLSP")) {
			
			return super.queryForList("Common.myOrgOfJBJLSP",type);
		}else if (type.equals("JLDSQ")) {
			
			return super.queryForList("Common.myOrgOfJLDSQ",type);
		}else {
			
			return null;
		}
	}
	
	/**
	 * 递转申请的接收单位列表</br>
	 * @param orgCode
	 * @return
	 * @since 2014-11-27
	 */
	public List<ComboBox> myOrg(String type,Map map) {
		if (type.equals("XSZJSP")) {
			return super.queryForList("Common.myOrgOfXSZJSP",map);
		}else if (type.equals("XSZJSQ")) {
			
			return super.queryForList("Common.myOrgOfXSZJSQ",map);
		}
		else return null;
	}
	/**
	 * 通过坐标返回责任区
	 * @param x
	 * @param y
	 * @return
	 */
	public Map mapBzZrq(String x, String y){
		Map item = null;
		if((null!=x && !"".equals(x)) && (null!=y && !"".equals(y))){
			Map param = new HashMap();
			param.put("x",x);
			param.put("y",y);
			item = (Map)super.queryForObject("Common.mapBzZrq", param);
			if(null!=item){
				CLOB clob = (CLOB)item.get("BJZBZ");
				try {
					item.put("BJZBZ",clob.getSubString(1L,(int)clob.length()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return item;
	}
	
	/**
	 * 老警综案件状态</br>
	 * @param orgCode
	 * @return
	 * @since 2014-11-27
	 */
	public List<ComboBox> myOldAjzt(String type) {
		
			return super.queryForList("Common.myOldAjzt",type);
	}
	/**
	 * 根据ORGCODE返回DWJB
	 * @param orgcode
	 * @return
	 */
	public Map getDwjb(String orgcode){
		//return super.queryForList("Common.getDwjb", orgcode);
		//return super.queryForMap("Common.getDwjb", orgcode,"t1");
		return (Map)super.queryForObject("Common.getDwjb", orgcode);
	}

	/**
	 * @Title: selectByOrgId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param orgId
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String selectByOrgId(String orgId) {
		return (String)super.queryForObject("Common.selectByOrgId", orgId);
	}
	
	/**
	 * 根据警号查询警员信息</br>
	 */
	public OrgUser getUserByalarm(String alarm) {
		return (OrgUser)super.queryForObject("Common.getUserByalarm", alarm);
	}
	
	/**
	 * 返回用户列表</br>
	 */
	public List<ComboBox> queryUserList() {
		
		return super.queryForList("Common.queryUserList","");
	}
	
	/**
	 * 根据身份证号查询人员信息</br>
	 * 
	 * @param cyzjdm
	 * @param zjhm
	 * @return
	 */
	/*
	public RyRyjbxxb queryRyjbxxbByGmsfhm(String gmsfhm) {
		
		return (RyRyjbxxb)queryForObject("Common.queryRyjbxxbByGmsfhm", gmsfhm);
	}
	*/
	/**
	 * 根据组织机构代码获取单位下所有有权限人员
	 * @param orgCode
	 * @return
	 */
	public List<OrgUser> queryOrgUserByOrgCode(String orgCode,String roleid){
		Map map = new HashMap();
		map.put("orgcode", orgCode);
		map.put("roleid", roleid);
		return queryForList("Common.queryOrgUserByOrgCode",map);
	}
}
