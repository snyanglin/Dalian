package com.founder.yjjb.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.ComboBox;
import com.founder.syrkgl.bean.RyRyjbxxb;

/**
 * 一些通用方法</br>
 * @author dangkp
 * @since 2014-11-26
 */
@TypeAnnotation("有奖举报_相关案件")
public interface CommonService {
	
	/**
	 * 查询分局和派出所的列表</br>
	 * @param orgCode
	 * @return
	 */
	@MethodAnnotation(value = "查询分局和派出所的列表", type = logType.query)
	public List<ComboBox> searchOrgListLower(String orgCode);
	
	/**
	 * 查询分局和公安局的列表</br>
	 * @param orgCode
	 * @return
	 */
	@MethodAnnotation(value = "查询分局和公安局的列表", type = logType.query)
	public List<ComboBox> searchOrgListHigher(String orgCode);
	
	/**
	 * 查询机构的列表</br>
	 * @param orgCode
	 * @return
	 */
	@MethodAnnotation(value = "查询机构的列表", type = logType.query)
	public List<ComboBox> searchOrgList(String orgCode);

	/**
	 * 查询下级机构的列表</br>
	 * @param orgCode
	 * @return
	 */
	@MethodAnnotation(value = "查询机构的列表", type = logType.query)
	public List<ComboBox> searchOrgListChildren(String orgCode);
	
	/**
	 * 查询上级部门</br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询上级部门", type = logType.query)
	public String queryUpOrgID(String orgcode); 
	
	/**
	 * 查询机构名称</br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询机构名称", type = logType.query)
	public String queryNameOrgID(String orgcode); 
	
	@MethodAnnotation(value = "根据地址ID查询所属派出所", type = logType.query)
	public String queryPcsByDZID(String dzid);
	
	/**
	 * 根据用户ID查询用户名称
	 * @param entity
	 * @return
	 * @since 2014-12-08
	 */
	public String queryUserNameByUserId(String userId);
	
	/**
	 * 根据type和orgcode获取新编号</br>
	 * 00-XSXX,01-DZSQ,02-DZSP,03-ZCSQ,04-ZSSP
	 * 05-XSZJ,06-ZJSP,07-JLXX,08-JBJL,09-JLSP
	 * 10-CLJL
	 * JL		奖励申请
	 * JLS		奖励审批
	 * XS		线索
	 * DZ		递转
	 * DZS		递转审批
	 * L	            日志
	 * ZJ		线索征集
	 * ZJS		征集审批
	 */
	@MethodAnnotation(value = "根据type和orgcode获取新编号", type = logType.query)
	public String CreateNewSeq(String type,String orgcode);
	
	/**
	 * 递转申请的接收单位列表</br>
	 * @param orgCode
	 * @return
	 */
	@MethodAnnotation(value = "递转申请的接收单位列表", type = logType.query)
	public List<ComboBox> myOrg(String type);
	
	/**
	 * 递转申请的接收单位列表(有参数)</br>
	 * @param orgCode
	 * @return
	 */
	@MethodAnnotation(value = "递转申请的接收单位列表", type = logType.query)
	public List<ComboBox> myOrg(String type,Map map);
	
	/**
	 * 通过坐标返回责任区</br>
	 * @param x
	 * @param y
	 * @return
	 */
	@MethodAnnotation(value = "通过坐标返回责任区", type = logType.query)
	public Map mapBzZrq(String x,String y);

	/**
	 * 根据orgcode和orglevel查询下级单位</br>
	 * orglevel: 02-支队 10-中心 21-分局</br>
	 * @param orgcode
	 * @param orglevel
	 * @return
	 */
	@MethodAnnotation(value = "根据orgcode和orglevel查询下级单位", type = logType.query)
	public List<ComboBox> queryDownOrg(String orgcode,String orglevel);
	
	/**
	 * 老警综案件状态</br>
	 * @param orgCode
	 * @return
	 */
	@MethodAnnotation(value = "递转申请的接收单位列表", type = logType.query)
	public List<ComboBox> myOldAjzt(String type);
	
	@MethodAnnotation(value = "通过ORGCODE返回受理单位级别", type = logType.query)
	public String getDwjb(String orgcode);

	/**
	 * 通过orgId查找警号
	 */
	@MethodAnnotation(value = "通过orgId查找警号", type = logType.query)
	public String selectByOrgId(String orgId);
	
	/**
	 * 根据警号查询警员信息</br>
	 */
	@MethodAnnotation(value = "根据警号查询警员信息", type = logType.query)
	public OrgUser getUserByalarm(String alarm);
	
	/**
	 * 用户列表</br>
	 * @param orgCode
	 * @return
	 */
	@MethodAnnotation(value = "用户列表", type = logType.query)
	public List<ComboBox> queryUserList();
	
	/**
	 * 根据身份证号查询人员信息</br>
	 * @param gmsfhm
	 * @return
	 */
	//public RyRyjbxxb queryRyjbxxbByGmsfhm(String gmsfhm);
}
