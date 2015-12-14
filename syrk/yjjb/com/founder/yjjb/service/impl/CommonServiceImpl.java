package com.founder.yjjb.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.ComboBox;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.yjjb.dao.CommonDao;
import com.founder.yjjb.service.CommonService;

@Service("commonService")
@Transactional
public class CommonServiceImpl extends BaseService implements CommonService {

	@Resource(name = "commonDao")
	private CommonDao commonDao;
	
	/**
	 * 下级单位列表</br>
	 */
	public List<ComboBox> searchOrgListLower(String orgCode) {

		return commonDao.searchOrgListLower(orgCode);
	}

	/**
	 * 查询上级部门<br>
	 * @param entity
	 * @return
	 */
	public String queryUpOrgID(String orgcode) {
		
		return (String) commonDao.queryUpOrgID(orgcode);
	}
	
	/**
	 * 查询机构名称<br>
	 * @param entity
	 * @return
	 */
	public String queryNameOrgID(String orgcode) {
		
		return (String) commonDao.queryNameOrgID(orgcode);
	}
	
	/**
	 * 根据用户ID查询用户名称
	 * @param entity
	 * @return
	 */
	public String queryUserNameByUserId(String userId){
		
		return commonDao.queryUserNameByUserId(userId);
	}

	/**
	 * 根据地址查询派出所<br>
	 * @param entity
	 * @return
	 */
	public String queryPcsByDZID(String dzid) {

		return (String) commonDao.queryPcsByDZID(dzid);
	}

	/**
	 * 根据type和orgcode获取新编号
	 *XS		线索00
	 *DZ		递转03
	 *DZS		递转审批04
	 *ZJ		线索征集05
	 *ZJS		征集审批06
	 *JL		奖励申请07
	 *举报奖励信息表的主键使用奖励信息表的主键，不要新建（08不要使用）
	 *JLS		奖励审批09
	 *L			日志10
     *A			案件11
     *FFYY 		非法营运12
	 */
	public String CreateNewSeq(String type, String orgcode) {
		
		return (String) commonDao.createNewSeq(type, orgcode);
	}
	
	/**
	 * 递转申请的接收单位列表</br>
	 */
	public List<ComboBox> myOrg(String type) {

		return commonDao.myOrg(type);
	}
	
	/**
	 * 递转申请的接收单位列表(有参数)</br>
	 */
	public List<ComboBox> myOrg(String type,Map map) {

		return commonDao.myOrg(type,map);
	}

	/**
	 * 单位列表</br>
	 */
	public List<ComboBox> searchOrgList(String orgCode) {
		
		return commonDao.searchOrgList(orgCode);
	}

	/**
	 * 通过坐标返回责任区
	 */
	public Map mapBzZrq(String x, String y) {
		
		return commonDao.mapBzZrq(x,y);
	}

	/**
	 *  查询分局和公安局的列表
	 */
	public List<ComboBox> searchOrgListHigher(String orgCode) {

		return commonDao.searchOrgListHigher(orgCode);
	}

	/**
	 * 根据orgcode和orglevel查询下级单位</br>
	 * orglevel: 02-支队 10-中心 21-分局</br>
	 * @param orgcode
	 * @param orglevel
	 * @return
	 */
	public List<ComboBox> queryDownOrg(String orgCode, String orglevel) {

		return commonDao.queryDownOrg(orgCode,orglevel);
	}
	
	/**
	 * 老警综 案件状态</br>
	 */
	public List<ComboBox> myOldAjzt(String type) {

		return commonDao.myOldAjzt(type);
	}

	/**
	 * 根据ORGCODE返回DWJB
	 * @param orgcode
	 * @return
	 */
	public String getDwjb(String orgcode) {
		Map map = commonDao.getDwjb(orgcode);
		return map.get("DWJB").toString(); 
	}

	/* (非 Javadoc)
	 * <p>Title: selectByOrgId</p>
	 * <p>Description: </p>
	 * @param orgId
	 * @return
	 * @see com.founder.yjjb.service.CommonService#selectByOrgId(java.lang.String)
	 */
	public String selectByOrgId(String orgId) {
		return commonDao.selectByOrgId(orgId);
	}

	public List<ComboBox> searchOrgListChildren(String orgCode) {

		return commonDao.searchOrgListChildren(orgCode);
	}

	public OrgUser getUserByalarm(String alarm) {
		
		return commonDao.getUserByalarm(alarm);
	}

	public List<ComboBox> queryUserList() {

		return commonDao.queryUserList();
	}

	/**
	 * 根据身份证号查询人员信息</br>
	 * @param gmsfhm
	 * @return
	 */
	/*
	public RyRyjbxxb queryRyjbxxbByGmsfhm(String gmsfhm) {
		
		return commonDao.queryRyjbxxbByGmsfhm(gmsfhm);
	}
	*/
}
